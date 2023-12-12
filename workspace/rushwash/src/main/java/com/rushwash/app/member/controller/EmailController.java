package com.rushwash.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/email")
public class EmailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("memberEmail");
        int checkNum = (int)(Math.random() * 1000000);

        String host = "smtp.naver.com";            
        final String user = "ronaldo39@naver.com";   
        final String password = "qudwn0812,";         
        String to = email;

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        boolean sendOk = false;
        PrintWriter out = resp.getWriter();
        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("[RushWash] 아이디 찾기 이메일 인증번호입니다.");
            message.setText("[RushWash] 아이디 찾기 인증번호는 "+ checkNum +" 입니다.");
            Transport.send(message);
            sendOk = true;

            if(sendOk) {
                System.out.println("인증메세지 발송 성공");
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute(email, checkNum);
            } else {
                throw new MessagingException();
            }
        } catch (MessagingException e) {
            resp.sendRedirect("/rushwash/member/idfind");
            out.write("{\"msg\" : \"fail\"}");
            e.printStackTrace();
        }
	}
}
