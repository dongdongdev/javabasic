<%@page import="cn.huhuiyu.web.dao.Db"%>
<%@page import="cn.huhuiyu.web.dao.TbGoodsDAO"%>
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
	goods = dao.queryByKey(goods);
	conn.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加</title>
</head>
<body>
	<div>商品信息修改</div>
	<div style="text-align: right;">
		<button onclick="location='index.jsp'">返回</button>
	</div>
	<div>
		<form action="modifyGoods.jsp" method="post">
			<input type="hidden" name="gid" value="<%=goods.getGid()%>">
			<label>商品名称：<input type="text" name="gname" value="<%=goods.getGname()%>"></label>
			<label>商品描述：<input type="text" name="ginfo" value="<%=goods.getGinfo()%>"></label>
			<label>商品价格：<input type="text" name="price" value="<%=goods.getPrice()%>"></label>
			<label>商品数量：<input type="text" name="amount" value="<%=goods.getAmount()%>"></label>
			<input type="submit" value="保存">
		</form>
	</div>
</body>
</html>