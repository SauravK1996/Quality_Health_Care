<jsp:include page="AdminHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
	<%Object errorAddDoctor = request.getAttribute("errorAddDoctor"); %>
	<%if(errorAddDoctor != null){ %>
		<h2 class="text-danger"><%=errorAddDoctor %></h2>
	<%} %>
		<div>
			<h3 class="text-primary py-2">Add doctor to Quality Health Care</h3>
			<form action="/admin/postAddDoctor" method="post" class="container w-75">
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="doctorName" class="font-weight-bold">Full name</label>
					    <input type="text" class="form-control border-primary" name="doctorName" id="doctorName" placeholder="Enter doctor name">
					</div>
					<div class="form-group px-3">
					    <label for="dateOfBirth" class="font-weight-bold">Date of birth</label>
					    <input type="date" class="form-control border-primary" name="dateOfBirth" id="dateOfBirth">
					</div>
					<div class="form-group px-3">
					    <label for="dateOfJoining" class="font-weight-bold">Date of joining</label>
					    <input type="date" class="form-control border-primary" name="dateOfJoining" id="dateOfJoining">
					</div>
				</div>
				<div class="d-flex">				
				  	<div class="form-group px-3">
				  		<div class="form-check">
				  			<label class="font-weight-bold">Gender</label>
				  		</div>
				  		<div class="d-flex">
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
					</div>
					<div class="form-group px-3">
					    <label for="qualification" class="font-weight-bold">Qualification</label>
					    <input type="text" class="form-control border-primary" name="qualification" id="qualification" placeholder="Enter qualification">
					</div>
					<div class="form-group px-3">
					    <label for="specialization" class="font-weight-bold">Specialization</label>
					    <input type="text" class="form-control border-primary" name="specialization" id="specialization" placeholder="Enter specialization">
					</div>
				</div>
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="yearsOfExperience" class="font-weight-bold">Years of experience</label>
					    <input type="number" value="0" class="form-control border-primary" name="yearsOfExperience" id="yearsOfExperience" placeholder="Enter years of experience">
					</div>
					<div class="form-group px-3">
					    <label for="street" class="font-weight-bold">Street</label>
					    <input type="text" class="form-control border-primary" name="street" id="street" placeholder="Enter street">
					</div>
					<div class="form-group px-3">
					    <label for="location" class="font-weight-bold">Location</label>
					    <input type="text" class="form-control border-primary" name="location" id="location" placeholder="Enter location">
					</div>
				</div>
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="city" class="font-weight-bold">City</label>
					    <input type="text" class="form-control border-primary" name="city" id="city" placeholder="Enter city">
					</div>
					<div class="form-group px-3">
					    <label for="state" class="font-weight-bold">State</label>
					    <input type="text" class="form-control border-primary" name="state" id="state" placeholder="Enter state">
					</div>
					<div class="form-group px-3">
					    <label for="pincode" class="font-weight-bold">Pincode</label>
					    <input type="text" class="form-control border-primary" name="pincode" id="pincode" placeholder="Enter pincode">
					</div>
				</div>
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="contactno" class="font-weight-bold">Contact number</label>
					    <input type="text" class="form-control border-primary" name="contactno" id="contactno" placeholder="Enter contact number">
					</div>
					<div class="form-group px-3">
					    <label for="emailid" class="font-weight-bold">Email </label>
					    <input type="text" class="form-control border-primary" name="emailid" id="emailid" placeholder="Enter email address">
					</div>
				</div>
			  <div class="float-right">
				<button type="submit" class="btn btn-outline-success">Submit</button>
				<button type="reset" class="btn btn-outline-info">Clear</button>
			  </div>
			</form>
		</div>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>