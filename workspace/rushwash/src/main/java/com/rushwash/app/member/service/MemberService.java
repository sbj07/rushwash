package com.rushwash.app.member.service;

import java.sql.Connection;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.member.dao.MemberDao;
import com.rushwash.app.member.vo.MemberVo;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
	
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//bussiness logic
		//아이디 6~12 영문소문자 + 숫자 + 특수문자
		// 아이디 6~12 영문소문자 + 숫자 + 특수문자
		String id = vo.getMemberId();
		boolean idOk = id.matches("[a-z0-9_-]{6,12}");

		if(!idOk) {
		    throw new Exception("아이디 형식이 잘못되었습니다.");
		}

		// 비밀번호 8~15자리, 특수문자 포함
		String pwd = vo.getMemberPwd();
		boolean pwdOk = pwd.matches("[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,15}");

		if(!pwdOk) {
		    throw new Exception("비밀번호는 특수문자를 포함한 8~15자리로 설정해주세요.");
		}

		// 비밀번호 일치여부 체크
		if(!(vo.getMemberPwd().equals(vo.getMemberPwd2()))) {
		    throw new Exception("비밀번호가 일치하지 않습니다.");
		}

		// 이름 필수 입력
		String name = vo.getMemberName();
		if(name == null || name.trim().isEmpty()) {
		    throw new Exception("이름을 입력해주세요.");
		}

		// 이메일 필수 입력 및 이메일 양식 체크
		String email = vo.getMemberEmail();
		boolean emailOk = email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");

		if(email == null || email.trim().isEmpty()) {
		    throw new Exception("이메일을 입력해주세요.");
		} else if(!emailOk) {
		    throw new Exception("이메일 주소 형식에 맞게 입력해주세요.");
		}

		// 주소 필수 입력
		String addr = vo.getMemberAddress();
		if(addr == null || addr.trim().isEmpty()) {
		    throw new Exception("주소를 입력해주세요.");
		}

		// 전화번호 필수 입력
		String phoneNo = vo.getMemberTel();
		boolean phoneOk = phoneNo.matches("([01]{2})([01679]{1})-([0-9]{3,4})-([0-9]{4})");
		if(phoneNo == null || phoneNo.trim().isEmpty()) {
		    throw new Exception("전화번호를 입력해주세요.");
		} else if(!phoneOk) {
			throw new Exception("전화번호 형식에 맞게 입력해주세요.");
		}
	
		
		//dao
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		return result;
	
	}

	public MemberVo login(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn,vo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		return loginMember;
	}

}
