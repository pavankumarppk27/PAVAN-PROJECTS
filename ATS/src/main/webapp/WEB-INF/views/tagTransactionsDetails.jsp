<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tag Transactions Details</title>
</head>
<body>


	<div align="center">
		<fieldset>
			<legend>
				<h2>Tag Transactions Details</h2>
			</legend>


			<br> <br>

			<c:choose>
				<c:when test="${!empty allTxDtlsModel}">

					<table border="1">
						<tr>
							<th>TagRegId</th>
							<th>VehRegNo</th>
							<th>TollPlazaAmount</th>
							<th>TransactionStatus</th>
							<th>TransactionFailureReason</th>
							<th>Transaction Date</th>
						</tr>
						<c:forEach var="txDtls" items="${allTxDtlsModel}">

							<tr>
								<td>${txDtls.tagRegId}</td>
								<td>${txDtls.vehicleRegNo}</td>
								<td>${txDtls.tollPlazaAmount}</td>
								<td>${txDtls.transactionStatus}</td>
								<td>${txDtls.transactionFailureReason}</td>
								<td>${txDtls.createdDate}</td>

							</tr>

						</c:forEach>

					</table>
				</c:when>
				<c:otherwise>
					<h1>There Is No Transactions Are Done Yet.</h1>
				</c:otherwise>
			</c:choose>

			<br> <br> <br>









		</fieldset>
	</div>


</body>
</html>