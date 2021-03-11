<%@page import="com.aq.qmc.bean.DoctorBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.aq.qmc.bean.CredentialsBean"%>
<jsp:include page="PatientHeaderAndSidebar.jsp" /> 
	<div class="bg-light w-75 mt-5 pl-4">
	<%ArrayList<DoctorBean> allDoctorBySpec = (ArrayList<DoctorBean>)request.getAttribute("allDoctorsBySpec"); %>
	<%if(allDoctorBySpec.size()>0){ %>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th colspan="3">Name</th>
				<th>Gender</th>
				<th>Qualification</th>
				<th>Specialization</th>
				<th>Experience</th>
			</tr>
		</thead>
		<tbody>
			<%for(DoctorBean dBean : allDoctorBySpec){ %>
				<tr>
					<td><%=dBean.getDoctorId() %></td>
					<td colspan="3"><%=dBean.getDoctorName() %></td>
					<td><%=dBean.getGender() %></td>
					<td><%=dBean.getQualification() %></td>
					<td><%=dBean.getSpecialization() %></td>
					<td><%=dBean.getYearsOfExperience() %></td>
				</tr>
	<%}}else{ %>
		<h3 class="text-danger mt-5">Selected specialized doctors are not available.</h3>
	<%} %>
	</div>
</div>
</body>
</html>