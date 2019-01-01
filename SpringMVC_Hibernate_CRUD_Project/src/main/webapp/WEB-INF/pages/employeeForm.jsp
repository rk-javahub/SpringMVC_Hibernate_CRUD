<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Information</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style type="text/css">
.myrow-container {
	margin: 20px;
}
</style>
</head>
<body class=".container-fluid">
	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Employee Details</h3>
			</div>
			<div class="panel-body">
				<form:form id="employeeRegisterForm" cssClass="form-horizontal"
					modelAttribute="employee" method="post" action="saveEmployee">

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="name">Name</form:label>
						</div>
						<div class="col-xs-6">
							<form:hidden path="id" value="${employeeObject.id}" />
							<form:input cssClass="form-control" path="name"
								value="${employeeObject.name}" />
						</div>
					</div>

					<div class="form-group">
						<form:label path="age" cssClass="control-label col-xs-3">Age</form:label>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="age"
								value="${employeeObject.age}" />
						</div>
					</div>

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="salary">Salary</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="salary"
								value="${employeeObject.salary}" />
						</div>
					</div>

					<div class="form-group">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<input type="submit" id="saveEmployee" class="btn btn-primary"
									value="Save" onclick="return submitEmployeeForm();" />
							</div>
							<div class="col-xs-4"></div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		function submitEmployeeForm() {

			// getting the employee form values
			var name = $('#name').val().trim();
			var age = $('#age').val();
			var salary = $('#salary').val();
			if (name.length == 0) {
				alert('Please enter name');
				$('#name').focus();
				return false;
			}

			if (age <= 0) {
				alert('Please enter proper age');
				$('#age').focus();
				return false;
			}

			if (salary <= 0) {
				alert('Please enter proper salary');
				$('#salary').focus();
				return false;
			}
			return true;
		};
	</script>


</body>
</html>