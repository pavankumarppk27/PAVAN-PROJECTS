<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Vehicle Owner Address Details</title>
</head>
<body>
<div align="center">
<fieldset>
<legend><h1>Register Vehicle Owner Address Details</h1></legend>



<form:form action="/processOwnerAddressDetailsForm" modelAttribute="vehicleOwnerAddressDetailsModel" >


<input type="hidden" name="addressId" value="${vehicleOwnerAddressDetailsModel.getAddressId()}">

VehicleOwnerId:<form:input path="vehicleOwnerId"  readonly="true" /><br><br>

 
 HouseNo:<form:input path="houseNo"/><br><br>
StreetName<form:input path="streetName"/><br><br>
City:<form:input path="city"/><br><br>
ZipCode:<form:input path="zipCode"/><br><br>

<input type="submit" value="Next">

</form:form>
<br>
&nbsp;&nbsp;&nbsp;
<a href="editOwnerDetailsForm?ownerId=${vehicleOwnerAddressDetailsModel.getVehicleOwnerId()}">Previous</a>&nbsp;&nbsp;&nbsp;&nbsp;



</fieldset>
</div>
</body>
</html>