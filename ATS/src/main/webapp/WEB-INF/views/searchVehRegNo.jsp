<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<fieldset>
			<legend>
				<b>Search Vehicle Register Number</b>
			</legend>
			<form action="/search">
				<br> <br> SearchVehRegNo:<input type="text"
					name="vehRegNo" placeholder="Enter VehRegNo"><br> <br>
				<input type="submit" value="Search"> <br> <br>
			</form>
		</fieldset>
	</div>
</body>
<br>
<br>
<body>
	<div align="center">


<h1>${msg}</h1>

		<c:if test="${not empty vehicleSummary}">

			<fieldset>
				<br>

				<form
					action="/checkVehRegNo?vehRegNo=${vehicleSummary.vehicleRegisterDetailsModel.vehicleRegisterNumber}"
					method="post">

					<table border="1">

						<tr>
							<td><b>VEHICLE REGNO:</b></td>
							<td><b>${vehicleSummary.vehicleRegisterDetailsModel.vehicleRegisterNumber}</b>
							</td>
						</tr>
						<tr>
							<td><b>FIRST NAME:</b></td>
							<td><b>${vehicleSummary.vehicleOwnerDetailsModel.firstName}
							</b></td>
						</tr>
						<tr>
							<td><b>EMAIL:</b></td>
							<td><b> ${vehicleSummary.vehicleOwnerDetailsModel.email}</b></td>
						</tr>
						<tr>
							<td><b>CITY:</b></td>
							<td><b>${vehicleSummary.vehicleOwnerAddressDetailsModel.city}</b></td>
						</tr>
						<tr>
							<td><b>PHONE NUMBER:</b></td>
							<td><b>${vehicleSummary.vehicleOwnerDetailsModel.phoneNumber}</b></td>
						</tr>
						<tr>
							<td><b>VEHICLE BRAND:</b></td>
							<td><b>${vehicleSummary.vehicleDetailModel.vehicleBrand}</b></td>
						</tr>

						<tr>
							<td><b>VEHICLE TYPE:</b></td>
							<td><b>${vehicleSummary.vehicleDetailModel.vehicleType}</b></td>
						</tr>

					</table>
					<br> <br> <input type="submit" value="Proceed">

				</form>
				<br>
			</fieldset>

		</c:if>
	</div>

	<div align="center">

		<!-- <a href="/admin"><h1>Previous</h1></a> --> <a href="/login"><h1>HOME</h1></a>

	</div>

</body>
</html>