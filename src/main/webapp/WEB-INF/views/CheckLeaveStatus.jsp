<%@page import="com.aq.qmc.bean.LeaveBean"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="DoctorHeaderAndSidebar.jsp" /> 
 
	<div class="bg-light w-75 mt-5">
		<h4 class="text-primary text-center">Check your leave status</h4>
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
						<th>Status</th>
						<th>Update</th>
						<th>Cancel</th>
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
							
							<%if(leaveBean.getStatus() == 0){ %>
								<td class="text-danger">Pending</td>
								<td><a href="/doctor/updateLeave?leaveid=<%=leaveBean.getLeaveid()%>">Update</a></td>
								<td><a href="/doctor/cancelLeave?leaveid=<%=leaveBean.getLeaveid()%>">Cancel</a></td>
							<%}else{%>
								<td class="text-success">Approved</td>
								<td class="text-secondary">Update</td>
								<td class="text-secondary">Cancel</td>
							<%} %>
						</tr>
					<%} %>
				</tbody>
			</table>
		<%}else{ %>
			<h3 class="text-danger">No leaves added in you list.</h3>
		<%} %>
		
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>