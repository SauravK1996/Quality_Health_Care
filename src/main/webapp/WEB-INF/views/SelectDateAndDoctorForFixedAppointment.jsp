<%@page import="com.aq.qmc.bean.DoctorBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="PatientHeaderAndSidebar.jsp" /> 
<div class="bg-light w-75 mt-5">
		<div class="container-fluid w-50">
		<h3 class="text-primary">Select Date and Doctor to check whether doctor is busy.</h3>
		<%ArrayList<DoctorBean> allDoctorList = (ArrayList<DoctorBean>)request.getAttribute("allDoctorsFixedList"); %>
		<%if(allDoctorList != null && allDoctorList.size()>0){ %>
			<form action="/patient/viewAllListOfDoctors" method="post">
			  <div class="form-group">
			    <label for="selectDate" class="font-weight-bold">
			    	Select Date</label>
			    <input type="date" class="form-control border-primary" name="selectDate" id="selectDate">
			  </div>
			  
				  <div class="form-group">
				    <label for="specialization" class="font-weight-bold">Select Doctor</label>
					    <select name="doctorId" class="form-select form-control border-primary">
						  <option selected="selected">--select--</option>
						  <%for(DoctorBean dBean : allDoctorList){%>
						  	<option value="<%=dBean.getDoctorId()%>"><%=dBean.getDoctorName()%> (<%= (dBean.getSpecialization()) %>)</option>						  	
						  <%} %>
						</select>
			 	 </div>
			  
			  <div class="float-right">
				<button type="submit" class="btn btn-outline-success">Submit</button>
				<button type="reset" class="btn btn-outline-info">Clear</button>
			  </div>
			</form>
			<%}else{ %>
				  <div class="form-group">
				    <h3 class="text-danger ml-4">No doctors are available.</h3>
				  </div>
			 <%} %>
		</div>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>