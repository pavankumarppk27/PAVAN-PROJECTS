<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase a Tag</title>


<!-- for date picker -->
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'dd-mm-yy',
			changeMonth : true,
			changeYear : true,
			yearRange : "1970:2025"

		});
	});
</script>

<!-- for validation -->

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('form[id="purchageTag"]').validate({
			rules : {

				tagStartDate : 'required',
				tagBal : 'required'

			},
			messages : {

				tagStartDate : 'Please enter TagStartDate',
				tagBal : 'Please enter Tag Balance',

			},

			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>



</head>
<body>

	<div align="center">


		<fieldset>
			<legend>
				<h1>Purchase Tag</h1>
			</legend>


			<form:form action="/purchaseTagDtls" modelAttribute="purchaseTagModel"
				id="purchageTag">


				<table border="1">


					<tr>
						<td><b>VehicleRegNumber:</b></td>
						<td><b><form:input path="vehicleRegNum" readonly="true" /></b></td>
					</tr>

					<tr>
						<td><b>VehicleType</b></td>
						<td><b><form:input path="vehicleType" readonly="true" /></b></td>
					</tr>
					<tr>
						<td><b>TagStartDate</b></td>
						<td><b><form:input path="tagStartDate" id="datepicker" /></b></td>
					</tr>

					<%-- <tr>
						<td><b>tagBal</b></td>
						<td><b><form:input path="tagBal" /></b></td>
					</tr>
 --%>
					<!-- <tr>
						<td><b></b></td>
						<td><b></b></td>
					</tr> -->
				</table>
				<br>
				<input type="submit" value="Register">

			</form:form>

			<a href="/searchVegRegNo"><h1>Previous</h1></a> <a href="/login"><h1>HOME</h1></a>

		</fieldset>


	</div>
</body>
</html>