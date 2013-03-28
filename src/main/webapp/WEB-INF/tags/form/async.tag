<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="action" required="true" description="Action Mapping."%>

<form class="async" name="${action}" id="${action}-form" action="javascript:console.log('shouldn't be called')">
	<jsp:doBody />
	<input type="button" name="form-submit-${action}" value="${action}" onclick="doSubmit('${action}-form')">
</form>