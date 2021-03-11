<%@page import="com.aq.qmc.bean.LeaveBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="AdminHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
		<h4 class="text-primary">Welcome to doctor home page...</h4>
		<%ArrayList<LeaveBean> leavesList = (ArrayList<LeaveBean>)request.getAttribute("leavesList"); %>
		<%if(leavesList != null && leavesList.size()>0){ %>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Leave Id</th>
						<th>Doctor Id</th>
						<th>From</th>
						<th>To</th>
						<th>Reason</th>
						<th>Approve</th>
					</tr>
				</thead>
				<tbody>
					<%for(LeaveBean leaveBean : leavesList){ %>
						<tr>
							<td><%=leaveBean.getLeaveid()%></td>
							<td><%=leaveBean.getDoctorid() %></td>
							<td><%=leaveBean.getLeaveFrom() %></td>
							<td><%=leaveBean.getLeaveTo() %></td>
							<td><%=leaveBean.getReason() %></td>
							
							<td><a href="/admin/updateLeave?leaveid=<%=leaveBean.getLeaveid()%>" class="btn btn-success">Approve</a></td>
						</tr>
					<%} %>
				</tbody>
			</table>
		<%}else{ %>
			<h3 class="text-danger">No leaves added in your list.</h3>
		<%} %>
		
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>