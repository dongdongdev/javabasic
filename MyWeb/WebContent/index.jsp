<%@page import="cn.huhuiyu.web.entity.TbGoods"%>
<%@page import="java.util.List"%>
<%@page import="cn.huhuiyu.web.dao.TbGoodsDAO"%>
<%@page import="cn.huhuiyu.web.dao.Db"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Connection conn=Db.getConnection();
	TbGoodsDAO dao=new TbGoodsDAO();
	dao.setConnection(conn);
	List<TbGoods> list=dao.query();
	conn.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息管理</title>
</head>
<body>
	<div>商品管理系统</div>
	<div style="text-align: right;">
		<button onclick="location='add.jsp'">添加</button>
	</div>
	<table border="1" style="width:700px; margin: 0px auto;">
		<thead>
			<tr>
				<th>名称</th>
				<th>描述</th>
				<th>价格</th>
				<th>数量</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<% 
			for(TbGoods goods:list) {
			%>		
			<tr>
				<td><%=goods.getGname() %></td>
				<td><%=goods.getGinfo() %></td>
				<td><%=goods.getPrice() %></td>
				<td><%=goods.getAmount() %></td>
				<td>
					<a href="delete.jsp?gid=<%=goods.getGid()%>">删除</a>
					<a href="modify.jsp?gid=<%=goods.getGid()%>">修改</a>
				</td>
			</tr>	
			<%}%>
		</tbody>
	</table>
</body>
</html>