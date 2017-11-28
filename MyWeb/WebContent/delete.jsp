<%@page import="cn.huhuiyu.web.dao.TbGoodsDAO"%>
<%@page import="cn.huhuiyu.web.dao.Db"%>
<%@page import="java.sql.Connection"%>
<%@page import="cn.huhuiyu.web.entity.TbGoods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	TbGoods goods = new TbGoods();
	goods.setGid(Integer.parseInt(request.getParameter("gid")));

	Connection conn = Db.getConnection();
	TbGoodsDAO dao = new TbGoodsDAO();
	dao.setConnection(conn);
	dao.delete(goods);
	conn.close();
	response.sendRedirect("index.jsp");
%>