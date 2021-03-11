<jsp:include page="ReporterHeaderAndSidebar.jsp" /> 
	<div class="bg-light w-75 mt-5">
		<h4 class="text-primary">Welcome to Reporter home page...</h4>
	<%Object errorAction = request.getAttribute("errorAction"); %>
		<%if(errorAction!=null){ %>
			<h3 class="text-danger"><%=errorAction %></h3>
		<%} %>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>