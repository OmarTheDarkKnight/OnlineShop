$(document).ready(function() {
	$("#password, #conPass").keyup(checkPassMatch);

	function checkPassMatch() {
		var password = $("#password").val();
    	var conPass = $("#conPass").val();

	    if (password != [] && password == conPass)
	        $("#checkPassMatch").html("Passwords match");
	    else {
	    	if(password == [])
	    		$("#checkPassMatch").html("Password can not be empty");
    		else
    			$("#checkPassMatch").html("Passwords do not match!"); 
	    }	        
	};
});