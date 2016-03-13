<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Sentiment Analysis of facebook Post Comments.">
    <meta name="author" content="Mustafa Gaziani">
    <link rel="icon" href="../../favicon.ico">

    <title>Facebook Sentiment Analysis</title>

    <!--Load the AJAX API For Goolge Charts-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <!--JQuery to Load FB SDK First-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>


    <!-- This is our Google Arvo font and Font-Awesome -->
    <link href='http://fonts.googleapis.com/css?family=Arvo' rel='stylesheet' type='text/css'>
    <link rel="resources/stylesheet" href="style/bootstrap-3.3.6-dist/fonts/font-awesome/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="resources/style/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/style/style.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="resources/../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="resources/images/fb.png" alt="logo" title="Company logo"></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.html">Home</a></li>
                <li><a href="#project_description" class="smoothScroll">Project Description</a></li>
                <li><a href="#group_members" class="smoothScroll">Group Members</a></li>
                <li><a href="#sentiment_analysis" class="smoothScroll hideShowSentimentAnalysis">Sentiment Analysis</a></li>
                <!--<li><button id="loginButtonNavbar" type="button" class="btn btn-sm btn-danger login_btn">Login</button></li>-->
                <li><a role="button" class="login_btn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1>Our goal is to inspire <br>Social Advertisers / Marketers<br> About Their Products</h1>
        <p>
            All over the world people do <strong>Adertising</strong> of their <strong>Products</strong>.
            Millions of products get sold by social Media Marketing and Advertisers get reviews of their produts accordingly.
            Our target is to do sentiment analysis of those reviews and let the advertisers knnow about their product likeliness and dislikeliness.
        </p>
        <p><a class="btn btn-danger btn-lg login_btn" role="button">FB Login</a></p>
    </div>
</div>



<div id="sentiment_analysis" class="hideShowSentimentAnalysis">
    <div class="container homepage">
        <h2>Welcome To FaceBook Sentiment Analysis</h2>
        <hr style="width: 50%"/>
        <p>Please Select The Type Of Post</p>
        <form role="form">
            <label class="radio-inline">
                <input type="radio" name="link_type" value="public_post">Public Post
            </label>
            <label class="radio-inline">
                <input type="radio" name="link_type" value="my_post">My Post
            </label>

            <div class="form-group">
                <!--<label for="usr">Name:</label>-->
                <span class="label label-default">Paste The Selected Post URL</span>
                <input type="text" class="form-control" name="link_to_post" id="id_link_to_post" placeholder="URL will come here...">
            </div>
        </form>
        <button id="start_analysis_btn" type="button" class="btn btn-primary">Start Analysis</button>
        <button id="get_result_btn" type="button" class="btn btn-primary">Get Result</button>
    </div>
</div>


<div id="sentiment_result" class="hideShowSentimentResult">
    <div class="container homepage">
        <h2>Results After Setiment Analysis</h2>
        <hr style="width: 40%"/>

        <div class="row">
            <div class="col-md-12">
                <div id="chart_div" class="pieChart"></div>
            </div>
        </div>
    </div>
</div>

<div id="project_description">
    <div class="container homepage">
        <img src="resources/images/facebook.png" title="Facebook-logo" alt="Facebook-logo" style="margin-top: 30px"/>
        <h2>project description</h2>
        <hr/>
        <p>
            In this project the problem we would try to solve is sentiment analysis or opinion mining of a post on the social network
            <a href="http://www.facebook.com/" target="_blank">Facebook</a> ,
            through this we can extract the attitude of a person's post or what are the opinions of the people about a person's post from the comments on that post.
            It can be used for getting people reviews on a product and it can also be used for getting people opinion on a political or social cause post
            and also for entertainment like getting people reviews on a restaurant or food or a travelling place post or a post about a movie.
        </p>
    </div>
</div>


<div id="group_members">
    <div class="container homepage">
        <h2>Group Members</h2>
        <hr/>
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-6">
                <img src="resources/images/mustafa.jpg" alt="Mustafa" class="img-circle"/>
                <h3>Muhammad Mustafa Gaziani</h3>
                <p>Mustafa Gaziani has done his BSCS from UBIT department located at UoK, His role in this project is to build the UI for the project. He uses SImple HTML CSS and Bootstrap Framework to build the UI of the Project.</p>
                <p><a class="btn btn-default" href="#" role="button">Learn More &raquo;</a></p>
            </div>
            <div class="col-md-6">
                <img src="resources/images/mustafa.jpg" alt="Mustafa" class="img-circle"/>
                <h3>Fahad Ahmed Quraishi</h3>
                <p>Mustafa Gaziani has done his BSCS from UBIT department located at UoK, His role in this project is to build the UI for the project. He uses SImple HTML CSS and Bootstrap Framework to build the UI of the Project.</p>
                <p><a class="btn btn-default" href="#" role="button">Learn More &raquo;</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <img src="resources/images/mustafa.jpg" alt="Mustafa" class="img-circle"/>
                <h3>Muhammad Hassan Khan</h3>
                <p>Mustafa Gaziani has done his BSCS from UBIT department located at UoK, His role in this project is to build the UI for the project. He uses SImple HTML CSS and Bootstrap Framework to build the UI of the Project.</p>
                <p><a class="btn btn-default" href="#" role="button">Learn More &raquo;</a></p>
            </div>
            <div class="col-md-6">
                <img src="resources/images/mustafa.jpg" alt="Mustafa" class="img-circle"/>
                <h3>Muhammad Owais Ameen</h3>
                <p>Mustafa Gaziani has done his BSCS from UBIT department located at UoK, His role in this project is to build the UI for the project. He uses SImple HTML CSS and Bootstrap Framework to build the UI of the Project.</p>
                <p><a class="btn btn-default" href="#" role="button">Learn More &raquo;</a></p>
            </div>
        </div>
    </div> <!-- /container -->
</div>


<footer>
    <div class="container">
        <p><img src="resources/images/fb.png" title="top logo" alt="top logo"/></p>
    </div>
</footer>



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>


<!--For Smooth Scrolling-->
<!--<script src="resources/scripts/smoothscroll.js"></script>-->      <!--Source: http://www.dwuser.com/education/content/quick-guide-adding-smooth-scrolling-to-your-webpages/-->
<script src="resources/scripts/SmoothScroll.js"></script><!--Source: https://css-tricks.com/snippets/jquery/smooth-scrolling/   &     https://codepen.io/anon/pen/avdeqx-->


<script src="resources/scripts/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/../../assets/js/ie10-viewport-bug-workaround.js"></script>

<script src="resources/scripts/GlobalVarsAndSupportFunctions.js"></script>
<script src="resources/scripts/Login.js"></script>
<script src="resources/scripts/SentimentAnalysis.js"></script>
<script src="resources/scripts/GoogleCharts.js"></script>

</body>
</html>