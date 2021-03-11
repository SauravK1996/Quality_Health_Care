<%@page import="com.aq.qmc.bean.DoctorBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="ReporterHeaderAndSidebar.jsp" /> 
	<div class="bg-light w-75 mt-3">
	<h2 class="text-danger">List of doctors who are on leave on an appointment date.</h2>
	<%ArrayList<DoctorBean> doctorBeanList = (ArrayList<DoctorBean>)request.getAttribute("doctorBeanList");%>
	<%if(doctorBeanList != null && doctorBeanList.size()>0){%>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>D.O.B.</th>
				<th>D.O.J.</th>
				<th>Gender</th>
				<th>Qualif.</th>
				<th>Spec.</th>
				<th>Expc.</th>
				<th>Address for communication</th>
			</tr>
		</thead>
		<tbody>
			<%for(DoctorBean dBean : doctorBeanList){ %>
				<tr>
					<td><%=dBean.getDoctorId() %></td>
					<td><%=dBean.getDoctorName() %></td>
					<td><%=dBean.getDateOfBirth() %></td>
					<td><%=dBean.getDateOfJoining() %></td>
					<td><%=dBean.getGender() %></td>
					<td><%=dBean.getQualification() %></td>
					<td><%=dBean.getSpecialization() %></td>
					<td><%=dBean.getYearsOfExperience() %></td>
					<td>
						<%=dBean.getStreet()%>
						<%=dBean.getLocation()%>
						<%=dBean.getCity()%>
						<%=dBean.getState()%>
						<%=dBean.getPincode()%><br/>
						Ph.no: <%=dBean.getContactno() %><br/>
						Email: <%=dBean.getEmailid() %>
					</td>
				</tr>
			<%}}else{%>
				<h4 class="text-primary mt-5 ml-4">No doctors are on leave on an appointment date.</h4>
			<%} %>
		</tbody>
	</table>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>