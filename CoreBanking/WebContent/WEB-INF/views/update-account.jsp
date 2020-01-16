<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updating a account</title>
</head>
<body>

	<div align="center">
		<form:form action="updateaccount" method="post" modelAttribute="editedAccount">
			<table>
				<form:hidden path="accountId" />

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
					<td><form:input path="customer.customerId" /></td>
				</tr>
				<tr>
					<td>Interest ID</td>
					<td><form:input path="interest.interestId" /></td>
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
					<td colspan="2"><input type="submit" value="update account"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>