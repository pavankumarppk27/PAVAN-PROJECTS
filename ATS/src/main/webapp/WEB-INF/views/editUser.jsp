<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit user</title>
<script type="text/javascript">


<script src="http://code.jquery.com/jquery-1.12.4.js" ></script>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>  
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 

  <script type="text/javascript">
       $(function() {
               $("#datepicker").datepicker({ dateFormat: "dd-mm-yy" }).val();
       });

  </script>





<!-- validation access -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
					email : {
						required : true,
						email : true
					},
					phoneNumber : 'required',
					gender : 'required',
					dob : 'required'
					
				

			},
			messages : {
				firstName : 'Please enter YOur FirstName ',
				lastName : 'Please Enter Your LastName',
				email : 'Please enter valid Email',
				phoneNumber : 'please enter phone number',
				gender : 'please enter gender',
					dob : 'please enter dob'
					
				
				
			
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>



       
  </head>
<body>
	
	<h2 style="color:green">${msg}</h2>
					<div align="center">
					<fieldset>
			<legend><b>Edit Account Details</b><br></legend>
			
			
				<br>	<br><br>	<br>
				<form:form action="/editUserDtls" modelAttribute="userModel" method="post" id="userRegForm">
					<table>

						<tr>
							<td><b>FirstName:</b></td>
							<td><form:input path="firstName" />
							<td>
						</tr>

						<tr>
							<td><b>LastName:</b></td>
							<td><form:input path="lastName" /></td>
						</tr>

						<tr>
							<td><b>Emial:</b></td>
							<td><form:input path="email" /></td>
						</tr>

						<tr>
							<td><b>PhoneNumber:</b></td>
							<td><form:input path="phoneNumber" /></td>
						</tr>

						<tr>
							<td><b>Gender:</b></td>
							<td>Male:<form:radiobutton path="gender" value="Male" /> FeMale:<form:radiobutton
									path="gender" value="Female"/>
							</td>
						</tr>


						<tr>
							<td><b>DateOfBirth:</b></td>
							<td><form:input path="dob" id="datepicker"/></td>
						</tr>
						<tr>
							<td><b>Role:</b></td>
							<td><form:input path="role" readonly="true"/>
							</td>
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
							<td colspan="2"  align="center"><input type="submit" value="EDIT"></td>
						</tr>

						
					</table>

				</form:form>
				
				<a href="/login"><h1>HOME</h1></a>
				
				<a href="/admin"><h1>ADMIN</h1></a>
				</fieldset>
				</div>
				
				
 
		
</body>
</html>
