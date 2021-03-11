<jsp:include page="AdminHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
		<h4 class="text-primary">Welcome to admin home page...</h4>
		<%Object addDoctor = request.getAttribute("addDoctor"); %>
		<%Object errorAddDoctor = request.getAttribute("errorAddDoctor"); %>
		<%Object errorAdminAction = request.getAttribute("errorAdminAction"); %>
		<%Object leaveUpdated = request.getAttribute("leaveUpdated"); %>
		<%Object leaveNotUpdated = request.getAttribute("leaveNotUpdated"); %>
		
		<%if(addDoctor!=null){ %>
			<h3 class="text-success"><%=addDoctor %></h3>
		<%} %>
		<%if(errorAddDoctor!=null){ %>
			<h3 class="text-danger"><%=errorAddDoctor %></h3>
		<%} %>
		<%if(errorAdminAction!=null){ %>
			<h3 class="text-danger"><%=errorAdminAction %></h3>
		<%} %>
		<%if(leaveUpdated!=null){ %>
			<h3 class="text-success"><%=leaveUpdated %></h3>
		<%} %>
		<%if(leaveNotUpdated!=null){ %>
			<h3 class="text-danger"><%=leaveNotUpdated %></h3>
		<%} %>		
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>