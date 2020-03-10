<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot password</title>
</head>



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
					}

			},
			messages : {
				
				email : 'Please enter valid Email',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>


<body>



<div align="center">
				<fieldset>
					<legend>
						<b>Forgot Password</b><br>
					</legend>

<h1>${msg}</h1>
					<br> <br>
					<br> <br>
					<form:form action="/getForgotPwd" modelAttribute="userModel"
						method="post" id="userRegForm">
						<table>

							<tr>
								<td><b>UserName(Email):</b></td>
								<td><form:input path="email"/>
								<td>
							</tr>
							<tr>
							<td></td><td></td>
							</tr>

							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Submit"></td>
							</tr>

							

						</table>
						
						<a href="/login"><h1>HOME</h1></a>

					</form:form>
					<br>
					<br>
					<br>
					<br>
				</fieldset>
			</div>






</body>
</html>