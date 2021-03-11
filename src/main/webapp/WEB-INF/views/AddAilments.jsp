<%@page import="com.aq.qmc.bean.CredentialsBean"%>
<jsp:include page="PatientHeaderAndSidebar.jsp" />
<%HttpSession sessionObj = request.getSession();
Object obj = sessionObj.getAttribute("credentialsBean");
CredentialsBean credBean = (CredentialsBean)obj; %> 
	<div class="bg-light w-75">
		<div class="w-75">
			<form action="/patient/postAddAilment" class="container w-50" method="post">
				<h3 class="text-primary">Add ailments details </h3>
				<div class="form-group">
				    <label for="userid" class="font-weight-bold">User Id</label>
				    <input type="text" class="form-control border-primary" name="userId" value="<%=credBean.getUserid() %>" readonly="readonly">
				</div>
				<div class="form-group">
				    <label for="userid" class="font-weight-bold">Appointment Date</label>
				    <input type="date" class="form-control border-primary" name="appointmentDate">
				</div>
				<div class="form-group">
				    <label for="userid" class="font-weight-bold">Ailment Type</label>
				    <input type="text" class="form-control border-primary" name="ailmentType" id="ailmentType" placeholder="Enter ailment type">
				</div>
				<div class="form-group">
				    <label for="userid" class="font-weight-bold">Ailment Details</label>
				    <textarea style="resize:none" rows="3" cols="10" class="form-control border-primary" name="ailmentDetails" id="ailmentDetails" placeholder="Enter ailment details"></textarea>
				</div>
				<div class="form-group">
				    <label for="userid" class="font-weight-bold">Diagnosis History</label>
				    <textarea style="resize:none" rows="3" cols="10" class="form-control border-primary" name="diagnosisHistory" id="diagnosisHistory" placeholder="Enter diagnosis history"></textarea>
				</div>
				
				<div class="float-right">
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