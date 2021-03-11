<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta http-equiv="X-UA-Compatible" content="ie=edge">
  	<link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  	<link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" 
    	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
    	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" 
    	crossorigin="anonymous">
</head>
<body
	style="background-image:url('https://i.ibb.co/kKk6xDb/qmc-1.gif'); 
			background-repeat: no-repeat;
			background-size: 100% 120%;">
	<%Object userid = request.getAttribute("userid"); %>
	<%Object errorLogin = request.getAttribute("errorLogin"); %>
	<%Object passwordUpdated = request.getAttribute("passwordUpdated"); %>
	
	
	<div class="container-fluid bg-light w-50 mt-5 border border-primary rounded py-5 md" style="opacity:0.7;">
		<%if(userid!=null){%>
			<h4 class="text-danger text-center">Please note your username for login : <%=userid %></h4>
		<%} %>
		<%if(errorLogin!=null){ %>
			<h4 class="text-danger text-center"><%=errorLogin%></h4>
		<%} %>
		<%if(passwordUpdated!=null){ %>
			<h4 class="text-danger text-center"><%=passwordUpdated%></h4>
		<%} %>
		<h2 class="text-center">Welcome back to Quality health care</h2>	
		<div class="w-75 ml-5">
			<form action="/auth/login" method="post">
			  <div class="form-group">
			    <label for="userid" class="font-weight-bold">Enter Username</label>
			    <input type="text" class="form-control border-primary" name="userid" id="userid" placeholder="Enter username">
			  </div>
			  <div class="form-group">
			    <label for="password" class="font-weight-bold">Enter Password</label>
			    <input type="password" class="form-control border-primary" name="password" id="password" placeholder="Enter password">
			  </div>
			  <div class="form-group">
			  	<div class="form-check">
						<input class="form-check-input" type="radio" name="userType" id="Admin" value="Admin" >
						<label class="form-check-label font-weight-bold" for="Admin">Admin</label>
				 </div>
				 <div class="form-check d-inline">
						<input class="form-check-input" type="radio" name="userType" id="Patient" value="Patient" checked>
						<label class="form-check-label font-weight-bold" for="Patient">Patient</label>
				 </div>
				 <div class="form-check">
						<input class="form-check-input" type="radio" name="userType" id="Reporter" value="Reporter">
						<label class="form-check-label font-weight-bold" for="Reporter">Reporter</label>
				 </div>
				 <div class="form-check">
						<input class="form-check-input" type="radio" name="userType" id="Doctor" value="Doctor">
						<label class="form-check-label font-weight-bold" for="Doctor">Doctor</label>
				 </div>
				</div>
			  <div class="form-check">
			    <input type="checkbox" class="form-check-input" id="rememberme">
			    <label class="form-check-label font-weight-bold" for="rememberme">Remember me</label>
			  </div>
				<div class="float-right">
					<button type="submit" class="btn btn-outline-success">Submit</button>
					<button type="reset" class="btn btn-outline-info">Clear</button>
				</div>
			</form>
			<p class="font-weight-bold">Forgot password? <a href="/auth/resetPassword" class="text-decoration-none ">reset password</a></p>
			<p class="font-weight-bold">Not registered? <a href="/auth/register" class="text-decoration-none ">register here</a></p>
		</div>
	</div>
</body>
</html>