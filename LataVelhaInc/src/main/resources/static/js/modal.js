var url = '';
		
$('button[id*="btn_"]').click(function() {
	url = "http://localhost:8080/" + $(this).attr('id').split("_")[1]
});
		
$('#ok_confirm').click(function() {
	document.location.href = url;
});