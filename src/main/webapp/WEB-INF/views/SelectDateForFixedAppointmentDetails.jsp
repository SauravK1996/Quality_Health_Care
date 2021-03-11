<jsp:include page="AdminHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
		<div class="container-fluid w-50">
			<form action="/admin/patientListWithfixedAppointment" method="post">
			  <div class="form-group">
			    <label for="selectDate" class="font-weight-bold">
			    	Select Date to view list of patient whose appointment is fixed.</label>
			    <input type="date" class="form-control border-primary" name="selectDate" id="selectDate">
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