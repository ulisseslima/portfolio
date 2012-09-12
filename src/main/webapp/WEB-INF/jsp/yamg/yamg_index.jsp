<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Yet Another Motivational Generator</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script>
	function getJson() {
		jQuery.getJSON("./get/json", {
			title : "White",
			subtitle : "jack"
		}, function(data) {
			$('#json').html(data.title);
		});
	}
	</script>
</head>
<body>
	<h2>Yet Another Motivational Generator</h2>
	
	<form action="./add">
		<input type="text" name="title">
		<input type="text" name="subtitle">
		
		<input type="submit" value="submit">
	</form>
	<button onclick="getJson()">Get Json</button>
	<span id="json"></span>

	<c:forEach var="motivation" items="${motivations}">
		<div>${motivation}</div>
	</c:forEach>
</body>
</html>