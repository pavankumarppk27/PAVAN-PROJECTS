<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle Registration Data Summary </title>

<style>

</style>

</head>





<form action="/userInfo?ownerId=${ownerId}" method="post">


<div align="center">
<h1 style="color:blue">Vehicle Registration Data Summary:</h1>




<table border="1">


<tr>
<td>

<div align="center">

<h1 style="color:blue">Vehicle Owner Details Details:</h1>


<table border="1">
<tr>
<td>firstName:</td>
<td>${vod.firstName}</td>
</tr>
<tr>
<td>lastName:</td>
<td>${vod.lastName}</td>
</tr>
<tr>
<td>gender:</td>
<td>${vod.gender}</td>
</tr>
<tr>
<td>email:</td>
<td>${vod.email}</td>
</tr>
<tr>
<td>dob:</td>
<td>${vod.dob}</td>

</tr>
<tr>
<td>phoneNumber:</td>
<td>${vod.phoneNumber}</td>

</tr>
</table>
<br><br>
</div>
</td>
</tr>


<tr>
<td>
<div align="center">
<h1 style="color:blue">Vehicle Owner Address Details Details:</h1>

<table border="1">
<tr>
<td>houseNo:</td>
<td>${voad.houseNo}</td>
</tr>
<tr>
<td>streetName:</td>
<td>${voad.streetName}</td>
</tr>
<tr>
<td>city:</td>
<td>${voad.city}</td>
</tr>
<tr>
<td>zipCode:</td>
<td>${voad.zipCode}</td>
</tr>

</table>
<br><br>
</div>

</td>
</tr>


<tr>
<td>

<div align="center">
<h1 style="color:blue">Vehicle Details:</h1>

<table border="1">
<tr>
<td>vehicleType:</td>
<td>${vd.vehicleType}</td>
</tr>
<tr>
<td>mfgYear:</td>
<td>${vd.mfgYear}</td>
</tr>
<tr>
<td>vehicleBrand:</td>
<td>${vd.vehicleBrand}</td>
</tr>

</table>
<br><br>
</div>

</td>
</tr>

<tr>
<td>
<div align="center">
<h1 style="color:blue">Vehicle Registered Details:</h1>

<table border="1">
<tr>
<td>registerDate:</td>
<td>${vrd.registerDate}</td>
</tr>
<tr>
<td>registerCenter:</td>
<td>${vrd.registerCenter}</td>
</tr>
<tr>
<td>vehicleRegisterNumber:</td>
<td>${vrd.vehicleRegisterNumber}</td>
</tr>

</table>
<br><br>
</div>

</td>
</tr>

</table>

<br><br>

</div>
<div align="center">
<input type="submit" value="Register">
<br><br>
<a href="editVehicleRegisterDetailsForm?ownerId=${ownerId}">Previous</a>
</div>

</form>


</body>
</html>