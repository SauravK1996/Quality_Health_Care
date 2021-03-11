<%@page import="com.aq.qmc.bean.DoctorBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="AdminHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75">
	<%ArrayList<DoctorBean> allDoctorList = (ArrayList<DoctorBean>)request.getAttribute("allDoctorList"); %>
	<%if(allDoctorList != null && allDoctorList.size()>0){%>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Date of Birth</th>
				<th>Date of Joining</th>
				<th>Gender</th>
				<th>Qualif.</th>
				<th>Spec.</th>
				<th>Expc.</th>
				<th>Address for communication</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<%for(DoctorBean dBean : allDoctorList){ %>
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
					<td><a href="/admin/deleteDoctor?doctorid=<%=dBean.getDoctorId()%>">Delete</a></td>				
				</tr>
			<%}}else{%>
				<p>No doctors available...</p>
			<%} %>
		</tbody>
	</table>
	</div>
</div>
	
</body>
</html>