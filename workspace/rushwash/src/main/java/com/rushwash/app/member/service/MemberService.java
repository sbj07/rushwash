package com.rushwash.app.member.service;

import java.sql.Connection;
import java.util.List;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.member.dao.MemberDao;
import com.rushwash.app.member.vo.MemberVo;

public class MemberService {

	//회원가입
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

		// 비밀번호 8~16자리, 특수문자 포함
		String pwd = vo.getMemberPwd();
		boolean pwdOk = pwd.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*()_+|<>?:{}]).{8,16}$");

		if(!pwdOk) {
		    throw new Exception("비밀번호는 영문 대문자, 소문자, 숫자, 특수문자(~!@#$%^&*()_+|<>?:{})를 각각 최소 하나 이상 포함한 8~16자리로 설정해주세요.");
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
		int result2 = dao.insertPlan(conn, vo);
		
		//tx
		if(result == 1 && result2 == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		return result;
	
	}

	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		// 아이디(6~12)자리
		String id = vo.getMemberId();
		boolean idOk = id.matches("[a-z0-9_-]{6,12}");

		if(!idOk) {
		    throw new Exception("아이디 형식이 잘못되었습니다.");
		}
		
		// 비밀번호 8~16자리, 특수문자 포함
		String pwd = vo.getMemberPwd();
		boolean pwdOk = pwd.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*()_+|<>?:{}]).{8,16}$");

		if(!pwdOk) {
		    throw new Exception("비밀번호는 영문 대문자, 소문자, 숫자, 특수문자(~!@#$%^&*()_+|<>?:{})를 각각 최소 하나 이상 포함한 8~16자리로 설정해주세요.");
		}
		
		//dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn,vo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		return loginMember;
	}

	//중복체크
	public boolean checkId(String memberId) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		boolean result = dao.checkId(conn, memberId);
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//아이디 변경
	public int idChange(String id, String newId) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();

		//dao
		MemberDao dao = new MemberDao();
		int result = dao.idChange(conn, id, newId);
		
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

	//비번변경
	public int pwdChange(String id, String pwd, String newPwd) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		int result = dao.pwdChange(conn, id, pwd, newPwd);
		
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

	//주소변경
	public int addrChange(String id, String addr, String newAddr) throws Exception {
	    //conn
	    Connection conn = JDBCTemplate.getConnection();

	    //dao
	    MemberDao dao = new MemberDao();
	    int result = dao.addrChange(conn, id, addr, newAddr); 

	    //tx
	    if(result == 1) {
	        JDBCTemplate.commit(conn);
	    } else {
	        JDBCTemplate.rollback(conn);
	    }

	    //close
	    JDBCTemplate.close(conn);

	    return result;
	}
	
	//회원탈퇴
	public int delete(String id, String pwd) throws Exception {
	
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		int result = dao.delete(conn , id , pwd);
		
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
	
	//이메일 중복체크
	public boolean checkEmail(String memberEmail) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		boolean result = dao.checkEmail(conn, memberEmail);
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//비번찾기
	public String pwdFind(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		String memberPwd = dao.pwdFind(conn, vo);
		//close
		JDBCTemplate.close(conn);
		
		return memberPwd;
	}

	//구독 정보만 가져오기
	public String getMemberInfo(String no) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		String gradeName = dao.getMemberInfo(conn, no);
		
		//close
		JDBCTemplate.close(conn);
		return gradeName;
	
	}

//	//결제 정보만 가져오기
//	public String getMemberPayInfo(String no) throws Exception {
//
//		//conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		//dao
//		MemberDao dao = new MemberDao();
//		String payInfo = dao.getMemberPayInfo(conn, no);
//		
//		//close
//		JDBCTemplate.close(conn);
//		return payInfo;
//	
//	}


	//이메일 인증으로 아이디 찾기
	public String findUserByEmail(String email) throws Exception {
		
		//conn
	    Connection conn = JDBCTemplate.getConnection();

	    // MemberDao 인스턴스 생성
	    MemberDao dao = new MemberDao();

	    // email을 통해 사용자의 아이디 찾기
	    String memberId = dao.findUserByEmail(conn, email);

	    // Connection 종료
	    JDBCTemplate.close(conn);

	    // 찾아진 사용자 아이디 반환
	    return memberId;
	}

	//포인트 정보만 가져오기
	public int getPointInfo(String no) throws Exception {
	
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		MemberDao dao = new MemberDao();
		int pointInfo = dao.getPointInfo(conn, no);
		
		//close
		JDBCTemplate.close(conn);
		return pointInfo;
	
	}

}	
