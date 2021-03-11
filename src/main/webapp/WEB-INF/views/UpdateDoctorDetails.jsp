<%@page import="com.aq.qmc.bean.DoctorBean"%>
<jsp:include page="AdminHeaderAndSidebar.jsp" />
 
 <%DoctorBean dBean = (DoctorBean)request.getAttribute("dBean"); %>
 
	<div class="bg-light w-75 mt-5">
	<%if(dBean != null){ %>
		<div>
			<form action="/admin/postUpdateDoctor" method="post" class="container w-75">
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="doctorId" class="font-weight-bold">Doctor Id</label>
					    <input readonly="readonly" type="text" class="form-control border-primary" value="<%=dBean.getDoctorId() %>" name="doctorId" id="doctorId">
					</div>
					<div class="form-group px-3">
					    <label for="doctorName" class="font-weight-bold">Full name</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getDoctorName() %>" name="doctorName" id="doctorName">
					</div>
					<div class="form-group px-3">
					    <label for="dateOfBirth" class="font-weight-bold">Date of birth</label>
					    <input type="date" class="form-control border-primary" value="<%=dBean.getDateOfBirth() %>" name="dateOfBirth" id="dateOfBirth">
					</div>
				</div>
				<div class="d-flex">
					
					<div class="form-group px-3">
					    <label for="dateOfJoining" class="font-weight-bold">Date of joining</label>
					    <input type="date" class="form-control border-primary"  value="<%=dBean.getDateOfJoining()%>" name="dateOfJoining" id="dateOfJoining">
					</div>				
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
					    <input type="text" class="form-control border-primary" value="<%=dBean.getQualification() %>" name="qualification" id="qualification">
					</div>
				</div>
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="specialization" class="font-weight-bold">Specialization</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getSpecialization() %>" name="specialization" id="specialization">
					</div>
					<div class="form-group px-3">
					    <label for="yearsOfExperience" class="font-weight-bold">Years of experience</label>
					    <input type="number" class="form-control border-primary" value="<%=dBean.getYearsOfExperience() %>" name="yearsOfExperience" id="yearsOfExperience">
					</div>
					<div class="form-group px-3">
					    <label for="street" class="font-weight-bold">Street</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getStreet() %>" name="street" id="street">
					</div>
				</div>
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="location" class="font-weight-bold">Location</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getLocation() %>" name="location" id="location">
					</div>
					<div class="form-group px-3">
					    <label for="city" class="font-weight-bold">City</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getCity()%>" name="city" id="city">
					</div>
					<div class="form-group px-3">
					    <label for="state" class="font-weight-bold">State</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getState() %>" name="state" id="state">
					</div>
				</div>
				<div class="d-flex">
					<div class="form-group px-3">
					    <label for="pincode" class="font-weight-bold">Pincode</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getPincode() %>" name="pincode" id="pincode">
					</div>
					<div class="form-group px-3">
					    <label for="contactno" class="font-weight-bold">Contact number</label>
					    <input type="text" class="form-control border-primary" value="<%=dBean.getContactno() %>" name="contactno" id="contactno">
					</div>
					<div class="form-group px-3">
					    <label for="emailid" class="font-weight-bold">Email </label>
					    <input type="email" class="form-control border-primary" value="<%=dBean.getEmailid() %>" name="emailid" id="emailid">
					</div>
				</div>
			  <div class="float-right">
				<button type="submit" class="btn btn-outline-success">Submit</button>
				<button type="reset" class="btn btn-outline-info">Clear</button>
			  </div>
			</form>
		</div>
		<%}else{ %>
			<h4 class="text-danger">No doctor is available...</h4>
		<%} %>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>