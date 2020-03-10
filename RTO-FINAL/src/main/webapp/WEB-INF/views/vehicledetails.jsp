<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>vehicle owner details</title>
</head>
<body>
<div align="center">
<fieldset>

<legend><h1>Register Vehicle Details</h1></legend>

<form:form action="/processVehicleDetailsForm" modelAttribute="vehicleDetailsModel" >


<input type="hidden" name="vehicleDetailId" value="${vehicleDetailsModel.getVehicleDetailId()}">

VehicleOwnerId:<form:input path="vehicleOwnerId" readonly="true"/> <br><br>

 VehicleType  :<form:select path="vehicleType"> <br><br>
 
 <form:options items="${vehicleType}" />
 
 </form:select>
 <br><br>
MfgYear:<form:select path="mfgYear">
<form:options items="${mfgYear}"/>
</form:select>
<br><br>
VehicleBrand:<form:select path="vehicleBrand">
<form:options items="${vehicleBrand}"/>

</form:select>
<br><br>



<input type="submit" value="Next">

</form:form>

<br>

<a href="editOwnerAddressDetailsForm?ownerId=${vehicleDetailsModel.getVehicleOwnerId()}">Previous</a>&nbsp;&nbsp;&nbsp;&nbsp;

</fieldset>
</div>
</body>
</html>