<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="quovadis.model.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm</title>
</head>
<body>
<h1>Your Data</h1>
<ul>
	<li>Name: ${customer.name }</li>
	<li>Surname: ${customer.surname }</li>
	<li>Username:${customer.username}</li>
	<li>Email: ${customer.email }</li>
	
</ul>	
<a href= "confirm"> Confirm</a>
<a href= "indexProva.jsp"> Cancel</a>

</body>
</html>