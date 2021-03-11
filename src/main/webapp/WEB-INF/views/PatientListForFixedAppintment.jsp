<%@page import="com.aq.qmc.bean.PatientBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="AdminHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-2">
		<%ArrayList<PatientBean> patientList = (ArrayList<PatientBean>)request.getAttribute("patientList"); %>
		<%if(patientList != null && patientList.size()>0){%>
		<h4 class="text-success pl-3 mt-4">List of patient whose appointment is fixed on selected date.</h4>
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			    	<th>PatientId</th>
			    	<th>Appointment date</th>
			    	<th>Ailment Type</th>
			    	<th>Ailment Details</th>
			    	<th>Diagnosis history</th>
			    </tr>
			  </thead>
			  <tbody>
			    <%
					for(PatientBean pb : patientList){%>
						<tr>
							<td><%=pb.getPatientId() %></td>
							<td><%=pb.getAppointmentDate() %></td>
							<td><%=pb.getAilmentType() %></td>
							<td><%=pb.getAilmentDetails() %></td>
							<td><%=pb.getDiagnosisHistory() %></td>
						</tr>
					<%}
				%>
			  </tbody>
			</table>
		<%}else{ %>
			<h4 class="text-success pl-3 mt-4">No patient has fixed appointment on selected date.</h4>
		<%} %>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>