<%@page import="com.aq.qmc.bean.LeaveBean"%>
<jsp:include page="DoctorHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
		<div class="w-75">
		<% LeaveBean leaveBean = (LeaveBean)request.getAttribute("leaveBean"); %>
			<form action="/doctor/updateLeave" class="container w-50" method="post">
				<h3 class="text-secondary">Update leave</h3>
				<div class="form-group">
				    <label for="leaveid" class="font-weight-bold">Leave Id</label>
				    <input type="text" class="form-control border-primary" name="leaveid" value="<%=leaveBean.getLeaveid() %>" readonly="readonly">
				</div>
				<div class="form-group">
				    <label for="doctorid" class="font-weight-bold">Doctor Id</label>
				    <input type="text" class="form-control border-primary" name="doctorid" value="<%=leaveBean.getDoctorid()%>" readonly="readonly">
				</div>
				<div class="form-group">
				    <label for="leaveFrom" class="font-weight-bold">Leave From</label>
				    <input type="date" class="form-control border-primary" name="leaveFrom" value="<%=leaveBean.getLeaveFrom()%>">
				</div>
				<div class="form-group">
				    <label for="leaveTo" class="font-weight-bold">Leave To</label>
				    <input type="date" class="form-control border-primary" name="leaveTo" value="<%=leaveBean.getLeaveTo()%>">
				</div>
				<div class="form-group">
				    <label for="reason" class="font-weight-bold">Reason</label>
				    <input type="text" class="form-control border-primary" name="reason" id="reason" value="<%=leaveBean.getReason() %>" placeholder="Enter leave reason">				    
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