<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Recharge</title>
</head>
<body>

<div align="center">
<h2>${msg}</h2>

<fieldset>

<legend><h1>Update Tag Recharge</h1></legend>


<form action="updateRecharge" method="post">

Enter TagRegId:<input type="text" name="tagRegId" placeholder="enter your tagRegId"><br><br>
Enter Balance:<input type="text" name="tagBal" placeholder="enter Balance"><br><br>

<input type="submit" value="UpdateRecharge">
</form>


</fieldset>
</div>
</body>
</html>