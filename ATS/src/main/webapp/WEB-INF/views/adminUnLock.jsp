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
		$('form[id="adminRegForm"]').validate({
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
				password : 'please enter password ',
				pwd : 'required'

			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>



<script>
	// Function to check Whether both passwords 
	// is same or not. 
	/* function checkPassword(form) {
		pwd = form.pwd.value;
		password2 = form.password2.value;

		// If password not entered 
		if (pwd == '')
			alert("Please enter Password");

		// If confirm password not entered 
		else if (password2 == '')
			alert("Please enter confirm password");

		// If Not same return False.     
		else if (pwd != password2) {
			alert("\nPassword did not match: Please try again...")
			return false;
		}

	} */
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
			<form:form action="/unLockAdminAccount" modelAttribute="userModel" method="post"
				id="adminRegForm" onSubmit="return checkPassword(this)">
				<table>

					<tr>
						<td><b>Email (UserName):</b></td>
						<td><form:input path="email" />
						<td>
					</tr>

					<tr>
						<td><b>Temporary Password:</b></td>
						<td><form:input path="password" /></td>
					</tr>


					<tr>
						<td><b>Choose New Password:</b></td>
						<td><input type="text" name="pwd" /></td>
					</tr>

					<tr>
						<td><b>Confirm New Password:</b></td>
						<td><input type="text" name="password2" /></td>
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

			<a href="/login"><h1>HOME</h1></a> <br>
			<br>
			<br>
			<br>



		</fieldset>
	</div>
</body>
</html>