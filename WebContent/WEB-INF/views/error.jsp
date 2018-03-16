<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
	<form action="/spring-mvc-example" method="GET">
	<label>Hi ${voterName}, there was some error in the registry. Please try again later.</label>
	<input type="submit" value="Try Again!">
	</form>
</body>
</html>