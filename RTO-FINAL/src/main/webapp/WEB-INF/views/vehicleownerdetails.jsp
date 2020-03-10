<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>vehicle owner details</title>


<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "dd-mm-yy"
		}).val();
	});
</script>




</head>
<body>
	<div align="center">
		<fieldset>
			<legend>
				<h1>Register Vehicle Owner Details</h1>
			</legend>

			<form:form action="/processOwnerDetailsForm"
				modelAttribute="vehicleOwnerDetailsModel">

				<%-- VehicleOwnerId:<form:input path="vehicleOwnerId"/><br><br>
 --%>
 
 
  <input type="hidden" name="vehicleOwnerId" value="${vehicleOwnerDetailsModel.getVehicleOwnerId()}">
 
 FirstName:<form:input path="firstName" />
				<br>
				<br>
LastName:<form:input path="lastName" />
				<br>
				<br>
Gender<form:radiobutton path="gender" value="Male" />Male
 <form:radiobutton path="gender" value="FeMale" />FeMale <br>
				<br>
Email:<form:input path="email" />
				<br>
				<br>
DOB:<form:input path="dob" id="datepicker" />
				<br>
				<br>
PhoneNumber:<form:input path="phoneNumber" />
				<br>
				<br>

				<input type="submit" value="Next">

			</form:form>

		</fieldset>
	</div>
</body>
</html>