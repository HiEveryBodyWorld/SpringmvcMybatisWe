<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
	<table width="100%" border=1>
		<tr>
			<td>商品名称</td>
			<td><input type="text" name="name" value="${itemsCustom.name }" /></td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><input type="text" name="price"
				value="${itemsCustom.price }" /></td>
		</tr>
</body>

</html>