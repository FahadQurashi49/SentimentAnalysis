$('#start_analysis_btn').click(function () {
	var post_type = $('input[name=link_type]:checked').val();
	
	var postLink = $("#id_link_to_post").val();
	objectId = resolveObjectIdOfPost(postLink);
	
	if (objectId != null) {
		if (post_type == "my_post") {
			objectId = userId + "_" + objectId;
		}
		console.log(objectId);
		getCommentsAndAnalyse(objectId);
		
	}
	else {
		console.log("some error occur in obtaning the object id");
	}
});

function extractUrlValue(key, url)
{
    if (typeof(url) === 'undefined') {
		url = window.location.href;
	}
    var match = url.match('[?&]' + key + '=([^&]+)');
    return match ? match[1] : null;
}

function resolveObjectIdOfPost (link) {
	if(link.indexOf("fbid") > -1) {
		var fbid = extractUrlValue("fbid", link);
		return isNaN(fbid) ? null : fbid;
	}
	if (link.indexOf("?") > -1) 
		link = link.substring(0, link.indexOf("?"));
	var indexOfLastSlash = link.lastIndexOf("/");
	if (indexOfLastSlash == link.length - 1) {
		link = link.substring(0, indexOfLastSlash);
		indexOfLastSlash = link.lastIndexOf("/");
	}
	var objectId = 
		link.substring(indexOfLastSlash + 1,
				link.length);
	
	return isNaN(objectId) || objectId == ""? null : objectId;
	
}

function getCommentsAndAnalyse(objectId) {
	  positiveCount = negativeCount = neutralCount = 0;
	  FB.api(objectId + "/comments", 
				{
			        "fields" : "message",
					"limit" : LIMIT,
					"accessToken" : accessToken,
					"summary" : true,
					"filter" : "toplevel"
				},
				'get',
				function(response) {
					if(response.data.length > 1) {
						 setafter(response.paging.cursors.after);
						printComments(response.data);	
						getSentimentAnalysis(response.data);						
					}  else {
				 		$("#get_result_btn").removeAttr("disabled");
//				        $("#get_result_btn").attr("class", "btn btn-primary");

				 		/*$("#get_result_btn").removeAttr("class");
				 		$("#get_result_btn").prop('class','btn btn-primary');*/
				 	}			
			});
}

$('#get_result_btn').click(function () {
	  console.log("positive : " + positiveCount);
	  console.log("negative : " + negativeCount);
	  console.log("neutral : " + neutralCount);
	$(".hideShowSentimentResult").show(1000);
	drawChart();
} );





	function fetchafterComments() {
			FB.api(objectId + "/comments", {
				"fields" : "message",
				"limit" : LIMIT,
				"after" : after
			}, 'get', function(response) {
			 	if(response.data.length > 1) {
			 		setafter(response.paging.cursors.after);
					printComments(response.data); 
					getSentimentAnalysis(response.data);
			 	} else {
			 		$("#get_result_btn").removeAttr("disabled");
			 	}
			 	
			});
	}

	function getSentimentAnalysis (data) {
		var comments = data;
		$.ajax({
		    url : 'performSentimentAnalysis',
		    data : JSON.stringify(comments),
		    type : 'POST', //<== not 'GET',
		    contentType : "application/json; charset=utf-8",
		    dataType : 'json',
		    error : function() {
		        console.log("error");
		    },
		    success : function(result) {
//		    	console.log(result);
		    	updateSentimentsCount(result);
				fetchafterComments();

		    }
		  });
	}
	
	function updateSentimentsCount (analysisResult) {
		if (analysisResult != null) {
			positiveCount += analysisResult.positiveCount;
			negativeCount += analysisResult.negativeCount;
			neutralCount += analysisResult.neutralCount;
		}
	}
	
