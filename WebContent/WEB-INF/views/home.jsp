<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</p>

	<form action="voter" method="post">
		<label> Voter Name </label> <input type="text" name="voterName"
			id="voterName"><br> <label> Voter Email ID</label><input
			type="email" name="emailId" id="emailId"><br> <label>
			Voter Phone Number</label><input type="number" name="phoneNumber"
			id="phoneNumber"><br> <label> Voter Nationality</label><input
			type="text" name="nationality" id="nationality"><br> <label>
			AddressLine1 </label><input type="text" name="address.addressLine1"
			id="address.addressLine1"><br> <label>
			AddressLine2</label><input type="text" name="address.addressLine2"
			id="address.addressLine2"><br> <label> City</label><input
			type="text" name="address.city" id="address.city"><br> <label>
			State</label><input type="text" name="address.state" id="address.state"><br>
		<label> Country</label><input type="text" name="address.country"
			id="address.country"><br> <label> Pin Code</label><input
			type="text" name="address.pincode" id="address.pincode"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>