package com.rushwash.admin.app.member.controller;

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
import com.rushwash.admin.app.member.service.MemberService;
import com.rushwash.admin.app.member.vo.MemberVo;

@WebServlet("/admin/member/loginInfo")
public class MemberLoginInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data

			// service
			MemberService us = new MemberService();
			List<MemberVo> memberVoList = us.infoView();

			// result
			if (memberVoList == null) {
				throw new Exception("[ERROR-U002 유저 로그인정보 전체조회 실패]");
			}

			req.setAttribute("memberVoList", memberVoList);
			req.getRequestDispatcher("/WEB-INF/admin/view/member/memberLoginInfo.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println("[ERROR-U002 유저 로그인정보 전체조회 실패]");
			e.printStackTrace();
			req.setAttribute("errMsg", "유저 로그인정보 전체조회 에러");
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
            String delYn = getString(jsonData, "status");
            MemberVo vo = new MemberVo();
            vo.setNo(no);
            vo.setDelYn(delYn);
            
            //service
            MemberService ms = new MemberService();
            int result = ms.submitStatus(vo);
            
            //result
            if (result != 1) {
				throw new Exception("[ERROR-L002]멤버상태 상태변경 실패");
			}
            
            resp.sendRedirect("/rushwash/admin/member/loginInfo");

        } catch (Exception e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", "멤버상태 상태변경 실패");
			req.getRequestDispatcher("/WEB-INF/admin/view/common/error.jsp").forward(req, resp);
        }
    }

    // Helper method to get an integer with null handling
    private String getString(JsonObject jsonObject, String key) {
        return jsonObject.has(key) ? jsonObject.getAsJsonPrimitive(key).getAsString() : ""; // 최종null""
    }
	
}
