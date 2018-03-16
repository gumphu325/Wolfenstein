<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
<form action="searchResult" method="GET">
		<c:forEach items="${voterList}" var="voter">
        		Voter Name:${voter.voterName}<br/>
        		Email_ID: ${voter.emailId}<br/>
        		PhoneNumber: ${voter.phoneNumber}<br/>
			Nationality: ${voter.nationality}<br/>
    			Address Line1: ${voter.address.addressLine1}<br/>
        		Address Line2: ${voter.address.addressLine2}<br/>
            	City: ${voter.address.city}<br/>
            	State: ${voter.address.state}<br/>
            	Country: ${voter.address.country}<br/>
            	PinCode: ${voter.address.pincode}<br/>
            	<br/><br/>
		</c:forEach>
	</form>
</body>
</html>