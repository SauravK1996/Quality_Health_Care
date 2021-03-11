<%@page import="com.aq.qmc.bean.DoctorBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="PatientHeaderAndSidebar.jsp" />
	<div class="bg-light w-75">
	
	<%ArrayList<DoctorBean> allDoctorList = (ArrayList<DoctorBean>)request.getAttribute("allDoctorList"); %>
	<%if(allDoctorList != null && allDoctorList.size()>0){%>
		
			<div class="container w-50 mt-3">
				<h2>Request for an appointment</h2>
				<form action="requestforAppointment" method="post">
					<div class="form-group">
					    <label for="specialization" class="font-weight-bold">Select Doctor</label>
						    <select name="doctorId" class="form-select form-control border-primary">
							  <option selected="selected">--select--</option>
							  <%for(DoctorBean dBean : allDoctorList){%>
							  	<option value="<%=dBean.getDoctorId()%>"><%=dBean.getDoctorName()%> (<%= (dBean.getSpecialization()) %>)</option>						  	
							  <%} %>
							</select>
				  	</div>
					<div class="form-group">
						<label for="patientId" class="font-weight-bold">Enter your Patient Id</label>
						<input type="text" class="form-control border-primary" name="patientId" id="patientId" placeholder="Enter your patientid you want to diagnose">
					</div>
					<div class="form-group">
						<label for="appointmentDate" class="font-weight-bold">Appointment Date</label>
						<input type="date" class="form-control border-primary" name="appointmentDate" id="appointmentDate">
					</div>
					<div class="form-group">
						<label for="firstname" class="font-weight-bold">Appointment Time</label>
						<input type="time" class="form-control border-primary" name="appointmentTime">
					</div>
					  <div class="float-right">
						<button type="submit" class="btn btn-outline-success">Submit</button>
						<button type="reset" class="btn btn-outline-info">Clear</button>
					  </div>
				</form>
			</div>
	<%}else{%>
		<h4 class="text-danger">No doctors are available right now...</h4>
	<%} %>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>