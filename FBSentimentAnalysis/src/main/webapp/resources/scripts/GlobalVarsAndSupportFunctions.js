  var LIMIT = 25;
  
  var after = ""; //link of after paginated comments
  var accessToken = "";
  var positiveCount, negativeCount, neutralCount;
  var userId = "";
  var isLoggedIn = false;
  var objectId;
  
  /*--------------------------------------------------------------------------------- support functions-------------------------------------------------------------------------------------- */
	var k = 0;
	function printComments(comments) {
		for (var i = 0; i < comments.length; i++) {
			console.log((++k) + " comment : " + comments[i].message);
		}
	}

	function setafter(link) {
		after = link;
	}

	function setAccessToken(token) {
		accessToken = token;
	}
	
	function setUserId (user) {
		userId = user;
	}