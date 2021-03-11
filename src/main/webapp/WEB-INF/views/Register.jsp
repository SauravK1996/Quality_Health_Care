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
	<div class="container-fluid bg-light w-50 mt-5 border border-primary rounded py-5 md" style="opacity:0.7;">
	<%Object errorRgisterUser = request.getAttribute("errorRgisterUser"); %>
	<%if(errorRgisterUser!=null){ %>
		<h4 class="text-danger"><%=errorRgisterUser %></h4>
	<%} %>
		<h2 class="text-center">Register at Quality health care</h2>	
		<div class="w-75 ml-5">
			<form action="/auth/register" method="post">
			  <div class="form-group">
			    <label for="firstname" class="font-weight-bold">Firstname</label>
			    <input type="text" class="form-control border-primary" name="firstname" id="firstname" placeholder="Enter firstname">
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="font-weight-bold">Lastname</label>
			    <input type="text" class="form-control border-primary" name="lastname" id="lastname" placeholder="Enter lastname">
			  </div>
			  <div class="form-group">
			    <label for="dateOfBirth" class="font-weight-bold">Date of Birth</label>
			    <input type="date" class="form-control border-primary" name="dateOfBirth" id="dateOfBirth">
			  </div>
			  <div class="form-group">
			  	<div class="form-check">
						<input class="form-check-input" type="radio" name="gender" id="Male" value="Male" >
						<label class="form-check-label font-weight-bold" for="Male">Male</label>
				 </div>
			  	<div class="form-check">
						<input class="form-check-input" type="radio" name="gender" id="Female" value="Female" >
						<label class="form-check-label font-weight-bold" for="Female">Female</label>
				 </div>
			  	<div class="form-check">
						<input class="form-check-input" type="radio" name="gender" id="Others" value="Others" >
						<label class="form-check-label font-weight-bold" for="Others">Others</label>
				 </div>
				</div>
			  <div class="form-group">
			    <label for="street" class="font-weight-bold">Street</label>
			    <input type="text" class="form-control border-primary" name="street" id="street" placeholder="Enter street">
			  </div>
			  <div class="form-group">
			    <label for="location" class="font-weight-bold">Location</label>
			    <input type="text" class="form-control border-primary" name="location" id="location" placeholder="Enter location">
			  </div>
			  <div class="form-group">
			    <label for="city" class="font-weight-bold">City</label>
			    <input type="text" class="form-control border-primary" name="city" id="city" placeholder="Enter city">
			  </div>
			  <div class="form-group">
			    <label for="state" class="font-weight-bold">State</label>
			    <input type="text" class="form-control border-primary" name="state" id="state" placeholder="Enter state">
			  </div>
			  <div class="form-group">
			    <label for="pincode" class="font-weight-bold">Pincode</label>
			    <input type="text" class="form-control border-primary" name="pincode" id="pincode" placeholder="Enter pincode">
			  </div>
			  <div class="form-group">
			    <label for="mobileno" class="font-weight-bold">Mobile number</label>
			    <input type="text" class="form-control border-primary" name="mobileno" id="mobileno" placeholder="Enter mobile number">
			  </div>
			  <div class="form-group">
			    <label for="emailid" class="font-weight-bold">Email Id</label>
			    <input type="email" class="form-control border-primary" name="emailid" id="emailid" placeholder="Enter email address">
			  </div>
			  <div class="form-group">
			    <label for="password" class="font-weight-bold">Password</label>
			    <input type="password" class="form-control border-primary" name="password" id="password" placeholder="Enter password">
			  </div>
			  <div class="float-right">
				<button type="submit" class="btn btn-outline-success">Submit</button>
				<button type="reset" class="btn btn-outline-info">Clear</button>
			  </div>
			</form>
			
			<p class="font-weight-bold">Already registered? <a href="/auth/login" class="text-decoration-none ">Login</a></p>
		</div>
	</div>
	
</body>
</html>