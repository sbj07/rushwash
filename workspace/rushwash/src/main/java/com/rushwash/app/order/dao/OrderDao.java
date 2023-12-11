package com.rushwash.app.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.rushwash.admin.app.db.util.JDBCTemplate;
import com.rushwash.app.order.vo.OrderVo;

public class OrderDao {

   public List<OrderVo> getorderList(Connection conn, String memberNo) throws Exception {

      String sql = "SELECT O.NO ,I.PRICE AS PRICE_ITEM ,TO_CHAR(O.PAYMENT_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS PAYMENT_DATE ,TO_CHAR(O.RECEIVE_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS RECEIVE_DATE ,O.DEL_YN ,M.NAME AS MEMBER_NAME ,M.ADDRESS ,M.TEL ,I.NAME AS ITEM ,L.EA ,S.STATUS AS LAUNDRY_STATUS ,T.STATUS AS ORDER_STATUS FROM LAUNDRY L JOIN LAUNDRY_ORDER O ON O.NO = L.ORDER_NO JOIN ORDER_STATUS T ON O.ORDER_STATUS = T.NO JOIN MEMBER M ON O.MEMBER_NO = M.NO JOIN LAUNDRY_STATUS S ON L.LAUNDRY_STATUS = S.NO JOIN ITEM I ON L.ITEM_NO = I.NO WHERE M.NO = ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberNo);
      ResultSet rs = pstmt.executeQuery();
      List<OrderVo> orderVoList = new ArrayList<OrderVo>();
      while (rs.next()) {

         String no = rs.getString("NO");
         String priceItem = rs.getString("PRICE_ITEM");
         String paymentDate = rs.getString("PAYMENT_DATE");
         String receiveDate = rs.getString("RECEIVE_DATE");
         String delYn = rs.getString("DEL_YN");
         String memberName = rs.getString("MEMBER_NAME");
         String address = rs.getString("ADDRESS");
         String tel = rs.getString("TEL");
         String item = rs.getString("ITEM");
         String ea = rs.getString("EA");
         String laundryStatus = rs.getString("LAUNDRY_STATUS");
         String orderStatus = rs.getString("ORDER_STATUS");

         OrderVo vo = new OrderVo();
         vo.setNo(no);
         vo.setPriceItem(priceItem);
         vo.setPaymentDate(paymentDate);
         vo.setReceiveDate(receiveDate);
         vo.setDelYn(delYn);
         vo.setMemberName(memberName);
         vo.setAddress(address);
         vo.setTel(tel);
         vo.setItem(item);
         vo.setEa(ea);
         vo.setLaundryStatus(laundryStatus);
         vo.setOrderStatus(orderStatus);

         orderVoList.add(vo);
      }

      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);

      return orderVoList;
   }

   public ArrayList<OrderVo> getorderDetail(Connection conn, String memberNo, String no) throws Exception {

	  String sql = "SELECT O.NO ,I.NAME AS ITEM ,I.PRICE AS PRICE_ITEM ,O.PRICE ,L.EA ,TO_CHAR(O.PAYMENT_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS PAYMENT_DATE ,TO_CHAR(O.EXP_DATE , 'YYYY\"년\"MM\"월\"DD\"일\"') AS EXP_DATE ,T.STATUS AS LAUNDRY_STATUS ,M.NAME AS MEMBER_NAME ,M.TEL ,O.ADDRESS ,O.REQUEST FROM MEMBER M JOIN LAUNDRY_ORDER O ON M.NO = O.MEMBER_NO JOIN ORDER_STATUS T ON O.ORDER_STATUS = T.NO JOIN LAUNDRY L ON T.NO = L.ORDER_NO JOIN ITEM I ON L.ITEM_NO = I.NO  WHERE M.NO = ? AND O.NO = ? AND L.DEL_YN = 'N'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberNo);
      pstmt.setString(2, no);
      
      ResultSet rs = pstmt.executeQuery();

      OrderVo vo = null;

      ArrayList<OrderVo> voList = new ArrayList<OrderVo>();
      while (rs.next()) {
         vo = new OrderVo();
         vo.setItem(rs.getString("ITEM"));
         vo.setPriceItem(rs.getString("PRICE_ITEM"));
         vo.setPrice(rs.getString("PRICE"));
         vo.setEa(rs.getString("EA"));
         vo.setPaymentDate(rs.getString("PAYMENT_DATE"));
         vo.setExpDate(rs.getString("EXP_DATE"));
         vo.setLaundryStatus(rs.getString("LAUNDRY_STATUS"));
         vo.setMemberName(rs.getString("MEMBER_NAME"));
         vo.setTel(rs.getString("TEL"));
         vo.setAddress(rs.getString("ADDRESS"));
         vo.setRequest(rs.getString("REQUEST"));
         
         voList.add(vo);
      }
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return voList;
   }

public int detaildelete(Connection conn, String no) throws Exception {
	String sql = "";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, no);
	
	
}

}