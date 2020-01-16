<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>

	<div style="width: 735px; height: 50px; margin: 10px 0 0 0px">
		<br /> <a href="addcustomer">Add a new customer</a>
	</div>

	<div align="left">
		<div align="center"
			style="width: 833px; height: 50px; margin: 10px 0 0 0px; background-color: grey">
			<br />Valuable Customer List
		</div>
		<table border="1">
			<tr align="center" style="height: 30px; margin: 10px 0 0 0px; background-color: lightgrey">
				<th>Customer Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>Zip Code</th>
				<th>Phone</th>
				<th>Account list</th>
				<th>Edit</th>
				<th>Delete</th>

			</tr>

			<c:forEach var="customer" items="${customerList}">
				<tr align="center" style="height: 30px; margin: 10px 0 0 0px; background-color: lightgrey">
					<td><c:out value="${customer.customerId}"></c:out></td>
					<td><c:out value="${customer.firstName}"></c:out></td>
					<td><c:out value="${customer.lastName}"></c:out></td>
					<td><c:out value="${customer.address}"></c:out></td>
					<td><c:out value="${customer.city}"></c:out></td>
					<td><c:out value="${customer.state}"></c:out></td>
					<td><c:out value="${customer.zip}"></c:out></td>
					<td><c:out value="${customer.phone}"></c:out></td>
					<td><a
						href="getaccountsbycustomerid?customerId=${customer.customerId}">List</a></td>
					<td><a href="editcustomer?customerId=${customer.customerId}">Edit
					</a></td>
					<td><a href="deletecustomer?customerId=${customer.customerId}">Delete
					</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<div align="left"
		style="width: 830px; height: 80px; margin: 20px 0 0 0px; background-color: LIGHTSALMON">
		<br /> Msg:
		<c:out value="${errorMsg}"></c:out>
		<br />
	</div>

</body>
</html>