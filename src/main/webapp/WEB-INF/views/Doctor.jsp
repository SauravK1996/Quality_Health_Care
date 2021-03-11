<jsp:include page="DoctorHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
		<h4 class="text-primary">Welcome to doctor home page...</h4>
		<%Object errorDoctorAction = request.getAttribute("errorDoctorAction"); %>
		<%Object leaveDetailsAdded = request.getAttribute("leaveDetailsAdded");%>
		<%Object leaveCancelled = request.getAttribute("leaveCancelled"); %>
		<%Object leaveNotCancelled = request.getAttribute("leaveNotCancelled"); %>
		<%Object leaveUpdated = request.getAttribute("leaveUpdated"); %>
		<%Object leaveNotUpdated = request.getAttribute("leaveNotUpdated"); %>
		
		<%if(errorDoctorAction != null){ %>
			<h3 class="text-danger"><%=errorDoctorAction %></h3>
		<%} %>
		<%if(leaveDetailsAdded != null){ %>
			<h3 class="text-danger"><%=leaveDetailsAdded %></h3>
		<%} %>
		<%if(leaveCancelled != null){ %>
			<h3 class="text-success"><%=leaveCancelled %></h3>
		<%} %>
		<%if(leaveNotCancelled != null){ %>
			<h3 class="text-danger"><%=leaveNotCancelled %></h3>
		<%} %>
		<%if(leaveUpdated != null){ %>
			<h3 class="text-danger"><%=leaveUpdated %></h3>
		<%} %>
		<%if(leaveNotUpdated != null){ %>
			<h3 class="text-danger"><%=leaveNotUpdated %></h3>
		<%} %>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>