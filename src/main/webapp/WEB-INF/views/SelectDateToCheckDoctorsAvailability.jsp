<jsp:include page="ReporterHeaderAndSidebar.jsp" /> 
	<div class="bg-light w-75 mt-5">
				
			<form action="/reporter/doctorsOnDate" method="post" class="mt-5 w-75 ml-4" >
			  <div class="form-group">
			    <label for="selectDate" class="font-weight-bold">
			    	Select Date to check doctors availability</label>
			    <input type="date" class="form-control border-primary" name="selectDate" id="selectDate">
			  </div>
			  <div class="float-right">
				<button type="submit" class="btn btn-outline-success">Submit</button>
				<button type="reset" class="btn btn-outline-info">Clear</button>
			  </div>
			</form>
		
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>