function Request() {}

function doSubmit(formId) {
	var form = document.getElementById(formId);
	var request = new Request();
	$(form).children(":input.property").each(function(i) {
		request[this.name] = this.value;
	});
	
	$.getJSON("./"+form.getAttribute("name"), request, function(response) {
		$('#response-message').html(response.message);
	});
}	

function scroll(containerId) {
	var container = document.getElementById(containerId);
	$.getJSON("./scroll", null, function(response) {
		$.each(response.contents, function(i, item) {
			var div = document.createElement("DIV");
			div.innerHTML = item.title;
			container.appendChild(div);
		});
	});
}
