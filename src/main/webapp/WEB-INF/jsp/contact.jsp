<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
	<h2>Contact Manager</h2>
	<form:form method="post" action="addContact.html">
		<form:label path="firstname">First Name</form:label>
		<form:input path="firstname" />
		<br>
		<form:label path="lastname">Last Name</form:label>
		<form:input path="lastname" />
		<br>
		<form:label path="email">Email</form:label>
		<form:input path="email" />
		<br>
		<form:label path="telephone">Telephone</form:label>
		<form:input path="telephone" />
		<br>
		<input type="submit" value="Add Contact" />
	</form:form>
</body>
</html>