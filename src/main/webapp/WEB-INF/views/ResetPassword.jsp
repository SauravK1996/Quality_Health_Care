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
	<%Object passwordNotUpdated = request.getAttribute("passwordNotUpdated"); %>
	<%Object pwdCnfPwdNotsame = request.getAttribute("pwdCnfPwdNotsame"); %>
	<%if(passwordNotUpdated != null){ %>
		<h4 class="text-danger"><%=passwordNotUpdated %></h4>
	<%} %>
	<%if(pwdCnfPwdNotsame != null){ %>
		<h4 class="text-danger"><%=pwdCnfPwdNotsame %></h4>
	<%} %>
	
	<div class="container-fluid bg-light w-50 mt-5 border border-primary rounded py-5 md" style="opacity:0.7;">
		
		<h2 class="text-center">Welcome back to Quality health care</h2>	
		<div class="w-75 ml-5">
			<form action="/auth/resetPassword" method="post">
			  <div class="form-group">
			    <label for="userid" class="font-weight-bold">Enter username</label>
			    <input type="text" class="form-control border-primary" name="userid" id="userid" placeholder="Enter username">
			  </div>
			  <div class="form-group">
			    <label for="newpwd" class="font-weight-bold">Enter new password</label>
			    <input type="password" class="form-control border-primary" name="newpwd" id="newpwd" placeholder="Enter new password">
			  </div>
			  <div class="form-group">
			    <label for="cnfnewpwd" class="font-weight-bold">Enter confirm Password</label>
			    <input type="password" class="form-control border-primary" name="cnfnewpwd" id="cnfnewpwd" placeholder="Enter confirm password">
			  </div>
			  
			  <div class="float-right">
				<button type="submit" class="btn btn-outline-success">Submit</button>
				<button type="reset" class="btn btn-outline-info">Clear</button>
			 </div>
			</form>
			<p class="font-weight-bold">Already registered? <a href="/" class="text-decoration-none ">Login</a></p>
			<p class="font-weight-bold">Not registered? <a href="/auth/register" class="text-decoration-none ">register here</a></p>
		</div>
	</div>
</body>
</html>