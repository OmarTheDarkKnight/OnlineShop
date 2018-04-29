$(document).ready(function(){

   $("#updateButton").on("click", function(){
   		$("#adminDataBox").hide();
   		$("#updateBox").show();
	});


   $("#backButton").on( "click", function(){
   		$("#updateBox").hide();
   		$("#adminDataBox").show();
	});

   $("#passChangeLink").on( "click", function(){    
        $("#passChangeDiv").show();
        $("#passChangeLink").hide();
                  
    });

   $("#passChangeHideLink").on( "click", function(){
   		$("#passChangeDiv").hide();
   		$("#passChangeLink").show();
	});

});