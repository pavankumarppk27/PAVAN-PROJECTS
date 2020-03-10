<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	background-color: #666;
	padding: 10px;
	text-align: center;
	font-size: 15px;
	color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
	float: left;
	width: 40%;
	height: 460px; /* only for demonstration, should be removed */
	background: #ccc;
	padding: 20px;
}

/* Style the list inside the menu */
nav ul {
	list-style-type: none;
	padding: 0;
}

article {
	float: left;
	padding: 20px;
	width: 60%;
	background-color: #f1f1f1;
	height: 460px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 600px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>








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
					password : 'required'
					
				

			},
			messages : {
				
				email : 'Please enter valid Email',
				password : 'please enter password number'
				
				
				
				
			
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>



</head>
<body>

	<header>
		<h1>Automatic Toll gate System</h1>
	</header>

	<section>
		<nav>















<div class="w3-content w3-section" style="max-width:500px">
  <img class="mySlides" src="image1.jpg" style="width:50%">
  <img class="mySlides" src="image2.jpg" style="width:50%">
  <img class="mySlides" src="image3.jpg" style="width:50%">
</div>

<script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>

</body>







			<h1>images</h1>
		</nav>
		<article>
			<div align="center">
				<fieldset>
					<legend>
						<b>LogIn Account</b><br>
					</legend>

<h1>${msg}</h1>
					<br> <br>
					<br> <br>
					<form:form action="/submit" modelAttribute="userModel"
						method="post" id="userRegForm">
						<table>

							<tr>
								<td><b>UserName:</b></td>
								<td><form:input path="email" />
								<td>
							</tr>

							<tr>
								<td><b>PassWord:</b></td>
								<td><form:input path="password" /></td>
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
									value="LogIn"></td>
							</tr>

							<tr>
								<td align="center"><a href="/forgot">ForgottenAccount?</a></td>
								<td align="center"><a href="/signup">SignUp</a></td>
							</tr>

						</table>

					</form:form>
					<br>
					<br>
					<br>
					<br>
				</fieldset>
			</div>
		</article>
	</section>

	<footer>
		<h2>&#169 2019 All Copy Rights Are Reserved</h2>
	</footer>

</body>
</html>
