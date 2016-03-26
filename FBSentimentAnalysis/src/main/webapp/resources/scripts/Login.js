/******************fb sdk thing******************************/
window.fbAsyncInit = function() {
    FB.init({
      appId      : '',
      xfbml      : true,
      version    : 'v2.5'
    });
  };

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

/******************start document******************************/

$(document).ready(function () {

	$(".hideShowSentimentAnalysis").hide();
	$(".hideShowSentimentResult").hide();

});

function checkIsLoggedIn () {
	FB.getLoginStatus(function(response) {
		  if (response.status === 'connected') {
		    // the user is logged in and has authenticated your
		    // app, and response.authResponse supplies
		    // the user's ID, a valid access token, a signed
		    // request, and the time the access token 
		    // and signed request each expire
		    var uid = response.authResponse.userID;
		    var accessToken = response.authResponse.accessToken;
		    setUserId(uid);
		    setAccessToken(accessToken);
		    console.log("already logged in");
		  } else if (response.status === 'not_authorized') {
		    // the user is logged in to Facebook, 
		    // but has not authenticated your app
			  $('#status').text("You're not login, please login to get started");
			  $("#content").children().prop('disabled',true);
		  } else {
		    // the user isn't logged in to Facebook.
			  $('#status').text("You're not login, please login to get started");
			  $("#content").children().prop('disabled',true);
		  }
		 });
}

$('.login_btn').click(function () {
	FB.getLoginStatus(function(response) {
		  if (response.status === 'connected') {
		    // the user is logged in and has authenticated your
		    // app, and response.authResponse supplies
		    // the user's ID, a valid access token, a signed
		    // request, and the time the access token 
		    // and signed request each expire
		    var uid = response.authResponse.userID;
		    var accessToken = response.authResponse.accessToken;
		    setUserId(uid);
		    setAccessToken(accessToken);
		    console.log("already logged in");
			$(".hideShowSentimentAnalysis").show(1000);
			$("#get_result_btn").attr("disabled", true); // :)

		  } else if (response.status === 'not_authorized') {
		    // the user is logged in to Facebook, 
		    // but has not authenticated your app
			  $(".hideShowSentimentAnalysis").hide();
		  } else {
		    // the user isn't logged in to Facebook.
			  FB.login(function(response) {
				  if(response != null || response != undefined){
					console.log(response);	
					 var uid = response.authResponse.userID;
					 var accessToken = response.authResponse.accessToken;
					 setUserId(uid);
					 setAccessToken(accessToken);
					  $(".hideShowSentimentAnalysis").show(1000);
				      $("#get_result_btn").attr("disabled", true);

				  } else {
					  $(".hideShowSentimentAnalysis").hide();
					  $(".hideShowSentimentResult").hide();
				  }
					}, {
						scope : 'user_posts'
					});
		  }
		 });
});


