<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>unlock your account</title>



<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				
					email : {
						required : true,
						email : true
					},
					password : 'required',
					pwd : 'required'
				
					
				

			},
			messages : {
				
				email : 'Please enter valid Email',
				password : 'please enter password number',
				pwd : 'required'
				
					
				
				
			
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>









</head>
<body>


	<h2>${msg}</h2>
	<div align="center">
			<fieldset>
			<legend>
				<b>UnLock Account</b><br>
			</legend>
			<br> <br> <br> <br>
			<form:form action="/unLockUserAccount" modelAttribute="userModel"
				method="post" id="userRegForm">
				<table>

					<tr>
						<td><b>Email (UserName):</b></td>
						<td><form:input path="email" readonly="true"/>
						<td>
					</tr>

					<tr>
						<td><b>Temporary Password:</b></td>
						<td><form:input path="password" /></td>
					</tr>

					<%-- <tr>
						<td><b>Choose New Password:</b></td>
						<td><form:input path="password" name="pwd"/></td>
					</tr>

					<tr>
						<td><b>Confirm New Password:</b></td>
						<td><form:input path="password" /></td>
					</tr>
 --%>
 
 <tr>
						<td><b>Choose New Password:</b></td>
						<td><input type="text" name="pwd"/></td>
					</tr>

					<tr>
						<td><b>Confirm New Password:</b></td>
						<td><input type="text" /></td>
					</tr>
 

					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Un-Lock"></td>
					</tr>


				</table>
			</form:form>
			
			<a href="/login"><h1>HOME</h1></a>
				<br><br><br><br>
				
				
		
		</fieldset>
	</div>
</body>
</html>