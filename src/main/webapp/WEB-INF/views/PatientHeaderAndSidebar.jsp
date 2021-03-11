<%@page import="com.aq.qmc.bean.CredentialsBean"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta http-equiv="X-UA-Compatible" content="ie=edge">
  	<link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  	<link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" 
    	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
    	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" 
    	crossorigin="anonymous">
</head>
<body>
<%
	HttpSession sessionObj = request.getSession();
	Object obj = sessionObj.getAttribute("credentialsBean");
	CredentialsBean credBean = (CredentialsBean)obj;

	Object patientName = session.getAttribute("patientName");

%>
	<nav class="navbar navbar-expand-sm navbar-dark bg-primary py-2 fixed-top">
    	<div class="container">
	      <a href="/patient"><img src="https://i.ibb.co/qy17PCj/qmc-logo.png" alt="qmc-logo" ></a>
	      <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarCollapse">
	       <ul class="navbar-nav ml-auto">
	         
	         <li class="nav-item">
	           <a href="/patient" class="nav-link active">Home</a>
	         </li>
	         <li class="nav-item">
	           <a href="#" class="nav-link active">About</a>
	         </li>
	         
	         <%if(credBean != null){%>
	        	 <li class="nav-item">
		           <%-- <a href="#" class="nav-link active"><%=credBean.getUserid() %></a> --%>
		           <a href="#" class="nav-link active"><%=patientName%></a>
		         </li>
		         <li class="nav-item">
		           <a href="/auth/logout?userid=<%=credBean.getUserid() %>" class="nav-link active">Logout</a>
		         </li>
	         <%}else{%>
	        	 <li class="nav-item">
		           <a href="/" class="nav-link active">Login</a>
		         </li>
	         <%}%>
	       </ul>
	   	 </div>
    	</div>
	</nav>

<div class="d-flex mt-5" style="height: 100%">
  <div class="list-group w-25 h-100 bg-secondary">
    <form action="/patient/action" method="post" class="mt-5 w-75 ml-4" >
	  <div class="form-group">
	    <label for="reqid" class="font-weight-bold">Enter Requirement ID</label>
	    <input type="text" class="form-control border-primary" name="reqid" id="reqid" placeholder="Enter requirement id">
	  </div>
	  <div class="float-right">
		<button type="submit" class="btn btn-success">Submit</button>
		<button type="reset" class="btn btn-info">Clear</button>
	  </div>
	</form>
 </div>
 