/**
 * Created by Mustafa Gaziani on 6/3/2016.
 */


// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['corechart']});

// Set a callback to run when the Google Visualization API is loaded.
//google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    data.addRows([
        ['Positive', positiveCount],
        ['Negative', negativeCount],
        ['Neutrals', neutralCount]
    ]);

    // Set chart options
    var options = {'title':'Analysis Report',
        is3D: true,
        colors: ['#00b36e','#ff1a1a','#ccccb3']
        };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, options);
}