<%@include file="/WEB-INF/tags/custom.jsp"%>

<dvl:page title="label.motivation.title">
	<dvl:body subtitle="label.motivation.subtitle">
		<form:async action="add">
			<input:text field="title" />
			<input:text field="subtitle" />
		</form:async>

		<dvl:list id="motivation-collection">
			<c:forEach var="motivation" items="${response.contents}">
				<div>${motivation}</div>
			</c:forEach>
		</dvl:list>
	</dvl:body>
</dvl:page>
