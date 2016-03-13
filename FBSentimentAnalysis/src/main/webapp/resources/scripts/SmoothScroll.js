/**
 * Created by Mustafa Gaziani on 25/2/2016.
 */

$(function() {
    // This will select everything with the class smoothScroll
    // This should prevent problems with carousel, scrollspy, etc...
    $('.smoothScroll').click(function() {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: target.offset().top
                }, 800); // The number here represents the speed of the scroll in milliseconds
                return false;
            }
        }
    });
});










// Change the speed to whatever you want
// Personally i think 1000 is too much
// Try 800 or below, it seems not too much but it will make a difference

//$(document).ready(function () {
//    $("#sentiment_analysis").hide();
//    $(".senti_analys").hide();
//    $("#sentiment_result").hide();
//});
//
//
//$('.login_btn').click(function () {
//    //$("#get_result_btn").removeClass("disabled");
//    $("#sentiment_analysis").show(1000);
//    $(".senti_analys").show(1000);
//});
//
//$("#start_analysis_btn").click(function(){
//    $("#get_result_btn").removeClass("disabled");
//});
//
//$("#get_result_btn").click(function(){
//    $("#sentiment_result").show(1000);
//});

