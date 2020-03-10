<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<script>
	function confirmActivate() {
		return confirm("Are you sure,do you want to Activate ?");
	}
	function confirmDeActivate() {
		return confirm("Are you sure,do you want to DeActivate ?");
	}

	function confirmEdit() {

		return confirm("Are you sure,do you want to Edit ?");
	}
</script>




</head>
<body>
	<div align="center">

		<fieldset>

			<table style="font-size: 30px;">
				<tr>
					<td><a href="/adminSignUp">Create Account</a></td>
				</tr>
				<tr>
					<td><a href="/viewAgencyAccounts">View Agency Accounts</a></td>
				</tr>
				<tr>
					<td><a href="/viewUserAccounts">View User Accounts</a><br></td>
				</tr>
				<tr>
					<td><a href="/searchVegRegNo">PurchageTag</a></td>
				</tr>
				<tr>
					<td><a href="/viewTags">ViewTags</a></td>
				</tr>
				<tr>
					<td><a href="/tagTxDetails">TransactionHistory</a></td>
				</tr>
				<tr>
					<td><a href="/update">Update Recharge</a></td>
				</tr>

			</table>

		</fieldset>



		<c:choose>
			<c:when test="${!empty agencyList}">

				<fieldset>
					<legend>
						<h2>Agencies Accounts Details</h2>
					</legend>

					<table border="1">
						<tr>
							<th>FIRSTNAME</th>
							<th>LASTNAME</th>
							<th>EMAIL</th>
							<th>GENDER</th>
							<th>DOB</th>
							<th>ACTIVE_SWITCH</th>
							<th>EDIT</th>
						</tr>
						<c:forEach var="list" items="${agencyList}">
							<tr>

								<td>${list.firstName}</td>
								<td>${list.lastName}</td>
								<td>${list.email}</td>
								<td>${list.gender}</td>
								<td>${list.dob}</td>
								<td><c:if test="${list.activeSwitch=='Y'}">
										<a href="/agencyDeActivie?email=${list.email}"
											onclick="confirmDeActivate()">DE-ACTIVE</a>
									</c:if> <c:if test="${list.activeSwitch=='N'}">
										<a href="/agencyActivie?email=${list.email}"
											onclick="confirmActivate()">ACTIVE</a>
									</c:if></td>

								<td><a href="/editAgency?email=${list.email}"
									onclick="confirmEdit()">EDIT</a></td>

							</tr>
						</c:forEach>
					</table>
					<br>
					<br>
				</fieldset>
			</c:when>
		</c:choose>





		<c:choose>
			<c:when test="${!empty userList}">

				<fieldset>
					<legend>
						<h2>Users Account Details</h2>
					</legend>

					<table border="1">
						<tr>
							<th>FIRSTNAME</th>
							<th>LASTNAME</th>
							<th>EMAIL</th>
							<th>GENDER</th>
							<th>DOB</th>
							<th>ACTIVE_SWITCH</th>
							<th>EDIT</th>
						</tr>
						<c:forEach var="list" items="${userList}">
							<tr>

								<td>${list.firstName}</td>
								<td>${list.lastName}</td>
								<td>${list.email}</td>
								<td>${list.gender}</td>
								<td>${list.dob}</td>
								<td><c:if test="${list.activeSwitch=='Y'}">
										<a href="/userDeActivie?email=${list.email}"
											onclick="confirmDeActivate()">DE-ACTIVE</a>
									</c:if> <c:if test="${list.activeSwitch=='N'}">
										<a href="/userActivie?email=${list.email}"
											onclick="confirmActivate()">ACTIVE</a>

									</c:if></td>

								<td><a href="/editUser?email=${list.email}"
									onclick="confirmEdit()">EDIT</a></td>

							</tr>
						</c:forEach>
					</table>
					<br>
					<br>
				</fieldset>
			</c:when>
		</c:choose>










		<a href="/login"><h1>HOME</h1></a>
	</div>
</body>
</html>