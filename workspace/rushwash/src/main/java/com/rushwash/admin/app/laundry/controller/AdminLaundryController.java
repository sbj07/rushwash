package com.rushwash.admin.app.laundry.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.rushwash.admin.app.laundry.service.LaundryService;
import com.rushwash.admin.app.laundry.vo.LaundryVo;

@WebServlet("/admin/laundry/control")
public class AdminLaundryController extends HttpServlet{
	LaundryService ls = new LaundryService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//service
			List<LaundryVo> voList = ls.getLaundryList();
			
			//result
			if(voList == null) {
				throw new Exception();
			}
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/admin/view/laundry/laundryControl.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR-L001 상세세탁물 정보 전체조회 실패]");
			e.printStackTrace();
			req.setAttribute("errMsg", "상세세탁물 정보 전체조회 실패 에러");
			req.getRequestDispatcher("/WEB-INF/view/common/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Set the response content type
        resp.setContentType("application/json");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
            
        	//DATA
        	// Parse JSON data using Gson
            JsonObject jsonData = JsonParser.parseReader(reader).getAsJsonObject();

            // Extract values from the parsed object
            String no = getString(jsonData, "no");
            String status = getString(jsonData, "status");

            LaundryVo vo = new LaundryVo();
            vo.setNo(no);
            vo.setStatus(status);
            
            //service
            int result = ls.submitStatus(vo);
            
            //result
            if (result != 1) {
				throw new Exception("[ERROR-L002]세탁물 상태변경 실패");
			}
            
         // Assuming you have methods in your service to retrieve updated startDate and endDate
            String updatedStartDate = ls.getUpdatedStartDate(no);
            String updatedEndDate = ls.getUpdatedEndDate(no);

            // Create a JSON response with the updated start and end dates
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("updatedStartDate", updatedStartDate);
            jsonResponse.addProperty("updatedEndDate", updatedEndDate);

            // Send the JSON response back to the client
            resp.getWriter().write(jsonResponse.toString());

        } catch (Exception e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", "세탁물 상태변경 실패");
			req.getRequestDispatcher("/WEB-INF/admin/view/common/error.jsp").forward(req, resp);
        }
    }

    // Helper method to get an integer with null handling
    private String getString(JsonObject jsonObject, String key) {
        return jsonObject.has(key) ? jsonObject.getAsJsonPrimitive(key).getAsString() : ""; // 최종null""
    }
    
}//class End
