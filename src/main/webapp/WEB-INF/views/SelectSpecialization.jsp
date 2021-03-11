<jsp:include page="PatientHeaderAndSidebar.jsp" /> 
	<div class="bg-light w-75">
	<%Object errorSelect = request.getAttribute("errorSelect");%>
	<%if(errorSelect != null){ %>
		<h2 class="text-danger"><%=errorSelect%></h2>
	<%} %>
		<div class="container  w-50">
			<form action="/patient/viewDocBySpec" method="get">
			  <div class="form-group container w-75 mt-5">
			    <label for="specialization" class="font-weight-bold">Select Specialization</label>
				    <select name="specialization" class="form-select form-control border-primary">
					  <option selected="selected">--select--</option>
					  <option value="Allergists/Immunologists">Allergists/Immunologists</option>
					  <option value="Anesthesiologists">Anesthesiologists</option>
					  <option value="Cardiologists">Cardiologists</option>
					  <option value="Colon and Rectal Surgeons">Colon and Rectal Surgeons</option>
					  <option value="Critical Care Medicine Specialists">Critical Care Medicine Specialists</option>
					  <option value="Dermatologists">Dermatologists</option>
					  <option value="Endocrinologists">Endocrinologists</option>
					  <option value="Emergency Medicine Specialists">Emergency Medicine Specialists</option>
					  <option value="Gastroenterologists">Gastroenterologists</option>
					  <option value="Geriatric Medicine Specialists">Geriatric Medicine Specialists</option>
					  <option value="Hematologists">Hematologists</option>
					  <option value="Internists">Internists</option>
					  <option value="Medical Geneticists">Medical Geneticists</option>
					  <option value="Neurologists">Neurologists</option>
					  <option value="Oncologists">Oncologists</option>
					  <option value="Ophthalmologists">Ophthalmologists</option>
					  <option value="Physiatrists">Physiatrists</option>
					  <option value="Podiatrists">Podiatrists</option>
					  <option value="Pulmonologists">Pulmonologists</option>
					  <option value="Urologists">Urologists</option>
					</select>
			  </div>
			  <div class="float-right">
				<button type="submit" class="btn btn-outline-success">Submit</button>
			  </div>
			</form>
		</div>
	</div>
</div>
	<jsp:include page="Footer.jsp" /> 
</body>
</html>