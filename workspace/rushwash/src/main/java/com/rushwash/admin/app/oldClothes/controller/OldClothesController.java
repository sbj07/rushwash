package com.rushwash.admin.app.oldClothes.controller;

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
import com.rushwash.admin.app.oldClothes.service.OldClothesService;
import com.rushwash.admin.app.oldClothes.vo.OldClothesVo;

@WebServlet("/admin/clothes")
public class OldClothesController extends HttpServlet{

	OldClothesService os = new OldClothesService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//service
			List<OldClothesVo> voList = os.getOldClothesList();
			
			//result
			if(voList == null) {
				throw new Exception();
			}
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/admin/view/laundry/oldClothes.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR-O001] 헌 옷 정보 조회 실패");
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set the response content type
        resp.setContentType("application/json");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()))) {
            
        	//DATA
        	// Parse JSON data using Gson
            JsonObject jsonData = JsonParser.parseReader(reader).getAsJsonObject();

            // Extract values from the parsed object
            String no = getString(jsonData, "no");
            String status = getString(jsonData, "status");
            String collectDate = getString(jsonData, "collectDate");

            OldClothesVo vo = new OldClothesVo();
            vo.setNo(no);
            vo.setStatus(status);
            
            //service
            int result = os.submitStatus(vo);
            
            //result
            if (result != 1) {
				throw new Exception("[ERROR-L002]세탁물 상태변경 실패");
			}
            
            resp.sendRedirect("/rushwash/admin/clothes");

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
}