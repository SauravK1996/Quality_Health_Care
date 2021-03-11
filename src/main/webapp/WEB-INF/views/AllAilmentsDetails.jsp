<%@page import="com.aq.qmc.bean.PatientBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="PatientHeaderAndSidebar.jsp" /> 
	<div class="bg-light w-75 h-100">
		<%ArrayList<PatientBean> allAilmentDetails = (ArrayList<PatientBean>)request.getAttribute("viewAllAilmentDetails"); %>
		<%if(allAilmentDetails != null && allAilmentDetails.size()>0){ %>
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			    	<th>PatientId</th>
			    	<th>Appointment date</th>
			    	<th>Ailment Type</th>
			    	<th>Ailment Details</th>
			    	<th>Diagnosis history</th>
			    	<th>Update</th>
			    </tr>
			  </thead>
			  <tbody>
			    <%
					for(PatientBean pb : (ArrayList<PatientBean>)allAilmentDetails){%>
						<tr>
							<td><%=pb.getPatientId() %></td>
							<td><%=pb.getAppointmentDate() %></td>
							<td><%=pb.getAilmentType() %></td>
							<td><%=pb.getAilmentDetails() %></td>
							<td><%=pb.getDiagnosisHistory() %></td>
							<td><a href="getUpdateAilmentDetails?patientid=<%=pb.getPatientId() %>">Update</a></td>
						</tr>
					<%}
				%>
			  </tbody>
		</table>
		<%}else{ %>
			<h4 class="text-primary">No ailments are added yet.</h4>
		<%} %>
	</div>
</div>
<jsp:include page="Footer.jsp" /> 
</body>
</html>