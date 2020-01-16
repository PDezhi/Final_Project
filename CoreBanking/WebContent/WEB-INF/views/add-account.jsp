<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a account</title>
</head>
<body>
	<div align="center">
		<form:form action="saveAccount" method="post" modelAttribute="account">
			<table>
				<form:hidden path="accountId" />
				<form:hidden path="interest.interestId" />

				<tr>
					<td>Account Number</td>
					<td><form:input path="accountNo" /></td>
				</tr>

				<tr>
					<td>Account Name</td>
					<td><form:input path="name" /></td>
				</tr>

				<tr>
					<td>Account Balance</td>
					<td><form:input path="balance" /></td>
				</tr>

				<tr>
					<td>Account Status</td>
					<td><form:input path="status" /></td>
				</tr>
				<tr>
					<td>Customer ID</td>
					<td><form:input path="customer.customerId" readonly="true"/></td>
				</tr>
				<tr>
					<td>Interest Balance</td>
					<td><form:input path="interest.balance" /></td>
				</tr>
				<tr>
					<td>Interest Rate</td>
					<td><form:input path="interest.rate" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Open account"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>