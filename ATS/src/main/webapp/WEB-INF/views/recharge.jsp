<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge</title>
</head>
<body>

	<div align="center">
		<br>
		<h2>${msg}</h2>
		<br>
		<fieldset>
			<form action="/rechargeBalance" method="post">
			<input type="hidden" name="id" value=${id}>
				<br> Recharge the Tag:<input type="text"
					placeholder="Enter a Balance" name="balance"><br> <br> <input
					type="submit">
			</form>
		</fieldset>
	</div>
</body>
</html>