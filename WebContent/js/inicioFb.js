function cargarFbSDK(){
    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
      }(document, 'script', 'facebook-jssdk'));
}

function  iniciarFb(){
	window.fbAsyncInit = function() {
		  FB.init({
		    appId      : '847142835297547',
		    cookie     : true,  // enable cookies to allow the server to access 
		                        // the session
		    xfbml      : true,  // parse social plugins on this page
		    version    : 'v2.1' // use version 2.0
		  });
	}
}
function loginFB(){
	FB.getLoginStatus(function (response){
		if (response.status == "connected") {
			$("#loginFbInput").css("display","none");
			FB.api("/me", function(response){
				$("#user").css("display", "inline");
				$("#user").html("Bienvenido :" + response.name);	
			});
			
		}
	});
	FB.login(function(response){
		console.log(response);
	});
}
function verificarPermisos(){
	FB.getLoginStatus(function(response) {
		if (response.status == "connected") {
			$("#basicModal").modal();
		}else {
			alert("solo los usuarios registrados pueden subir imagenes");
		}
    });
}