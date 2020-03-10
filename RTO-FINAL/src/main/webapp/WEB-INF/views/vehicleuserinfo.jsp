<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Registration is successfully completed ...! </h1>

<c:if test="${vod ne null}">
<table border="1">
<tr>
<td>
<h2>Name:</h2>
</td>
<td>
<h2>${vod.firstName}&nbsp;&nbsp;${vod.lastName}</h2>
</td>
</tr>

<tr>
<td>
<h2>VehicleType:</h2>
</td>
<td>
<h2>${vd.vehicleType}</h2>
</td>
</tr>

<tr>
<td>
<h2>RegistrationNumber Id is:</h2>
</td>
<td>
<h2>${vrd.vehicleRegisterNumber}</h2>
</td>
</tr>
</table>
</c:if>


<a href="/index"><h1>HOME</h1></a>

</body>
</html>