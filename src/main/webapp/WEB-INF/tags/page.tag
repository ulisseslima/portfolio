<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ attribute name="title" required="true" description="Page title message key." %>
<%@ attribute name="titleBody" required="false" description="Page title as string." %>

<!doctype html>
<html>
	<head>
		<title>Dvlcube -
		<c:choose>
			<c:when test="${not empty title}">
				<spring:message code="${title}" />
			</c:when> 
			<c:otherwise>
				${title}
			</c:otherwise>
		</c:choose>
		</title>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
		
		<spring:url var="Main_js" value="/static/script/Main.js" />
		<spring:url var="Main_css" value="/static/style/Main.css" />
		<script async="async" type="text/javascript" src="${Main_js}"></script>
		<style type="text/css">@import url("${Main_css}");</style>
	</head>
	<body>
		<span id="response-message">
			<span id="response-message">
				<c:if test="${not empty response.message}">
					<spring:message code="${response.message}" />
				</c:if>
			</span>
		</span>
		<jsp:doBody />
	</body>
</html>