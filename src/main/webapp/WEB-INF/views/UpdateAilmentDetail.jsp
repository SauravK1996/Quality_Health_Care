<%@page import="com.aq.qmc.bean.PatientBean"%>
<jsp:include page="PatientHeaderAndSidebar.jsp" /> 
	<div class="bg-light w-75">
		<h4 class="text-primary">Update ailment details...</h4>
		<%PatientBean pbean = (PatientBean) request.getAttribute("pbean"); %>
		<div class="container-fluid w-50">
			<h3>Update ailment details</h3>
			<form action="/patient/postUpdateAilmentDetails" method="post" class="container w-75">
				<div class="form-group">
					<label for="patientId" class="font-weight-bold">Patient Id</label>
					<input type="text" class="form-control border-primary" name="patientId" id="patientId" value="<%=pbean.getPatientId() %>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="ailmentType" class="font-weight-bold">Ailment type</label>
					<input type="text" class="form-control border-primary" value="<%=pbean.getAilmentType()%>" id="ailmentType"  name="ailmentType" >
				</div>
				<div class="form-group">
					<label for="appointmentDate" class="font-weight-bold">Appointment Date</label>
					<input type="date" class="form-control border-primary" value="<%=pbean.getAppointmentDate()%>" id="appointmentDate"  name="appointmentDate" >
				</div>
				<div class="form-group">
					<label for="ailmentDetails" class="font-weight-bold">Ailment Details</label>
					<input type="text" class="form-control border-primary" value="<%=pbean.getAilmentDetails()%>" id="ailmentDetails" name="ailmentDetails">
				</div>
				<div class="form-group">
					<label for="diagnosisHistory" class="font-weight-bold">Diagnosis history</label>
					<input type="text" class="form-control border-primary" value="<%=pbean.getDiagnosisHistory() %>" id="diagnosisHistory" name="diagnosisHistory">
				</div>			
				<div class="float-right form-group">
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