<%@page import="com.aq.qmc.bean.AppointmentBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="DoctorHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
		
		<%ArrayList<AppointmentBean> checkAppointmentList = (ArrayList<AppointmentBean>)request.getAttribute("checkAppointmentList"); %>
		<%if(checkAppointmentList != null && checkAppointmentList.size()>0){ %>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Appointment Id</th>
						<th>Patient Id</th>
						<th>Appointment Date</th>
						<th>Appointment Time</th>
					</tr>
				</thead>
				<tbody>
					<%for(AppointmentBean appBean : checkAppointmentList){ %>
						<tr>
							<td><%=appBean.getAppointmentId()%></td>
							<td><%=appBean.getPatientId()%></td>
							<td><%=appBean.getAppointmentDate()%></td>
							<td><%=appBean.getAppointmentTime()%></td>
						</tr>
					<%} %>
				</tbody>
			</table>
		<%}else{ %>
			<h3 class="text-danger">You have no appointment till now. Please check again later.</h3>
		<%} %>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>