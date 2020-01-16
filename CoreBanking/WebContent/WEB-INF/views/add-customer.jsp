<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a customer</title>
</head>
<body>
	<div align="center">
		<form:form action="saveCustomer" method="post" modelAttribute="customer">
			<table>
				<form:hidden path="customerId" />

				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td>Address</td>
					<td><form:input path="address" /></td>
				</tr>

				<tr>
					<td>City</td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><form:input path="state" /></td>
				</tr>
				<tr>
					<td>Zip</td>
					<td><form:input path="zip" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add customer"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>