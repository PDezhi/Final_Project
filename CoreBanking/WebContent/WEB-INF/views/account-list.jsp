<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account List</title>
</head>
<body>

	<div>
	<br />
		<a href="openaccount?customerId=${customerId}">open an account</a>
	</div>
	<div align="left">
		<br />
		<div align="center"
			style="width: 614px; height: 50px; margin: 20px 0 0 0px; background-color: lightblue">
			<br /> Hi, it's me. My customerId is equal to 
			<c:out value="${customerId}"></c:out>.
			<br />
		</div>
		<br />
		<br /> 
		<div align="center" style="width: 614px; height: 50px; margin: 10px 0 0 0px; background-color: lightgrey"><br/>Valuable Account List</div>
		<table border="1">
			<tr align="center" style="height: 30px; margin: 10px 0 0 0px; background-color: lightgrey">
				<th>Account Number</th>
				<th>Name</th>
				<th>Balance</th>
				<th>Status</th>
				<th>Interest Rate</th>
				<th>Interest Balance</th>
				<th>Update</th>
				<th>Close</th>

			</tr>

			<c:forEach var="account" items="${accountList}">
				<tr align="center" style="height: 30px; margin: 10px 0 0 0px; background-color: lightgrey">
					<td><c:out value="${account.accountNo}"></c:out></td>
					<td><c:out value="${account.name}"></c:out></td>
					<td><c:out value="${account.balance}"></c:out></td>
					<td><c:out value="${account.status}"></c:out></td>
					<td><c:out value="${account.interest.interestId}"></c:out></td>
					<td><c:out value="${account.interest.balance}"></c:out></td>
					<td><a href="editaccount?accountId=${account.accountId}">Edit
					</a></td>
					<td><a href="closeaccount?accountId=${account.accountId}">Delete
					</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>


</body>
</html>