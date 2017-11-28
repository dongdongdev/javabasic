<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加</title>
</head>
<body>
	<div>商品信息添加</div>
	<div style="text-align: right;">
		<button onclick="location='index.jsp'">返回</button>
	</div>
	<div>
		<form action="addGoods.jsp" method="post">
			<label>商品名称：<input type="text" name="gname"></label>
			<label>商品描述：<input type="text" name="ginfo"></label>
			<label>商品价格：<input type="text" name="price"></label>
			<label>商品数量：<input type="text" name="amount"></label>
			<input type="submit" value="添加">
		</form>
	</div>
</body>
</html>