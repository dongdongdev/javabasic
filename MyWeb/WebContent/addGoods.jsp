<%@page import="cn.huhuiyu.web.dao.TbGoodsDAO"%>
<%@page import="cn.huhuiyu.web.dao.Db"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="cn.huhuiyu.web.entity.TbGoods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	TbGoods goods = new TbGoods();
	goods.setGname(request.getParameter("gname"));
	goods.setGinfo(request.getParameter("ginfo"));
	goods.setPrice(new BigDecimal(request.getParameter("price")));
	goods.setAmount(Integer.parseInt(request.getParameter("amount")));

	Connection conn = Db.getConnection();
	TbGoodsDAO dao = new TbGoodsDAO();
	dao.setConnection(conn);
	dao.add(goods);
	conn.close();
	response.sendRedirect("index.jsp");
%>