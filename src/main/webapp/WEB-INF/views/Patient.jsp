<jsp:include page="PatientHeaderAndSidebar.jsp" /> 
<div class="bg-light w-75 mt-4">
	<h4 class="text-primary ml-3">Patient Home page</h4>
		<%Object reqForAppointment = request.getAttribute("reqForAppointment"); %>
		<%Object errorInRequesForAppointment = request.getAttribute("errorInRequesForAppointment"); %>
		<%Object modifyAilments = request.getAttribute("modifyAilments"); %>
		<%Object errorModifyAilments = request.getAttribute("errorModifyAilments"); %>
		<%Object errorPatientAction = request.getAttribute("errorPatientAction"); %>
		<%Object addAilments = request.getAttribute("addAilments"); %>
		<%if(reqForAppointment != null){ %>
			<h1 class="text-success">Your status for appointment is updated successfully.</h1>
		<%} %>
		<%if(errorInRequesForAppointment != null){ %>
			<h2 class="text-danger"><%=errorInRequesForAppointment%></h2>
		<%} %>
		<%if(modifyAilments != null){ %>
			<h2 class="text-success"><%=modifyAilments%></h2>
		<%} %>
		<%if(errorModifyAilments != null){ %>
			<h2 class="text-danger"><%=errorModifyAilments%></h2>
		<%} %>
		<%if(errorPatientAction != null){ %>
			<h2 class="text-danger"><%=errorPatientAction%></h2>
		<%} %>
		<%if(addAilments != null){ %>
			<h2 class="text-success"><%=addAilments%></h2>
		<%} %>
	
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>