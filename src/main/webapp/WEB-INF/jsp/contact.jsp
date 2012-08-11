<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring 3 MVC Series - Contact Manager | viralpatel.net</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function getTimeRequest() {
		$.ajax({
			url : 'time',
			data : ({
				name : "me"
			}),
			success : function(data) {
				$('#time').html(data);
			}
		});
	}
	function getJson() {
		jQuery.getJSON("demo", {
			name : "White",
			email : "jack"
		}, function(data) {
			$('#json').html(data.name);
		});
	}
</script>
</head>
<body>
	<h2>Contact Manager</h2>

	<form:form method="post" action="add.html" commandName="contact">
		<table>
			<tr>
				<td><form:label path="firstname">
						<spring:message code="label.firstname" />
					</form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">
						<spring:message code="label.lastname" />
					</form:label></td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">
						<spring:message code="label.telephone" />
					</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td><form:label path="age">
						<spring:message code="label.age" />
					</form:label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><form:label path="birthDate">
						<spring:message code="label.birthDate" />
					</form:label></td>
				<td><form:input path="birthDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addcontact"/>" /></td>
			</tr>
		</table>
	</form:form>

	<div class="message">
		<button onclick="getTimeRequest()">Show Time</button>
		<span id="time"></span>
		<button onclick="getJson()">Get Json</button>
		<span id="json"></span>
	</div>

<div>
<script type="text/javascript">
for (var i = 0; i < 5; i++) {
	<spring:message code="label.firstname" />
}
</script>
</div>
	<h3>Contacts</h3>
	<c:if test="${!empty contactList}">
		<table class="data">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactList}" var="contact">
				<tr>
					<td>${contact.lastname}, ${contact.firstname}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<td>${contact.age}</td>
					<td>${contact.birthDate}</td>
					<td><a href="delete/${contact.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>