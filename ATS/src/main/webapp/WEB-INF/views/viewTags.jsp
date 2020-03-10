<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




	<div align="center">
		<fieldset>
			<br>			
			<br>
			<h1>${msg}</h1>
			<c:choose>
				<c:when test="${!empty listTagDtls}">

					<table border="1">
						<tr>
							<th>TagRegId</th>
							<th>VehRegNo</th>
							<th>VehType</th>
							<th>Tag Balance</th>
							<th>TagExpiryDate</th>
						</tr>
						<c:forEach var="tagDtls" items="${listTagDtls}">

							<tr>
								<td>${tagDtls.tagRegId}</td>
								<td>${tagDtls.vehicleRegNum}</td>
								<td>${tagDtls.vehicleType}</td>
								<td>${tagDtls.tagBal}</td>
								<td>${tagDtls.tagExpiryDate}</td>
							</tr>

						</c:forEach>

					</table>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>

			<br>
			<br>
			<br> 
		</fieldset>
	</div>



</body>
</html>