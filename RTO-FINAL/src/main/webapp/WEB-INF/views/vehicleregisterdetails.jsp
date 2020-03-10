<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Vehicle Register Details</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>  
   <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 

   <script type="text/javascript">
       $(function() {
               $("#datepicker").datepicker({ dateFormat: "dd-mm-yy" }).val();
       });

       </script>



</head>
<body>
<div align="center">
<fieldset>
<legend><h1>Register Vehicle Registration Details</h1></legend>

<form:form action="/processVehicleRegisterDetailsForm" modelAttribute="vehicleRegisterDetailsModel">


<%--  VehicleOwnerId:<form:input path="vehicleOwnerId"/><br><br>
 --%>
 
 <input type="hidden" name="vehicleRegisterId" value="${vehicleRegisterDetailsModel.getVehicleRegisterId()}"><br><br>
 
 
 VehicleOwnerId :<form:input path="vehicleOwnerId" readonly="true"/> <br><br> 
 registerDate :<form:input path="registerDate" id="datepicker"/><br><br>
registerCenter :<form:select path="registerCenter">
<form:options items="${registerCenter}"/>
</form:select>

<br><br>
<%-- VehicleRegisterNumber:<form:input path="vehicleRegisterNumber"/><br><br>
 --%>
<input type="submit" value="Preview">


</form:form>

<br>
<a href="editVehicleDetailsForm?ownerId=${vehicleRegisterDetailsModel.getVehicleOwnerId()}">Previous</a>&nbsp;&nbsp;&nbsp;&nbsp;



</fieldset>
</div>
</body>
</html>