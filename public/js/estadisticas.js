google.charts.load('current', {'packages':['corechart']});

google.charts.setOnLoadCallback(drawChart);

function drawChart() {
  var data = new google.visualization.DataTable();
  data.addColumn('date', 'Jahr');
  data.addColumn('number', 'Anz. Mitglieder');
  data.addRows([
    [new Date('2006-01-01'), 4296746],
    [new Date('2007-01-01'), 4370450],
    [new Date('2008-01-01'), 4383961],
    [new Date('2009-01-01'), 4380701],
    [new Date('2010-01-01'), 4368527],
    [new Date('2011-01-01'), 4395723],
    [new Date('2012-01-01'), 4404590],
    [new Date('2013-01-01'), 4429098],
    [new Date('2014-01-01'), 4456835],
    [new Date('2015-01-01'), 4483521]
  ]);

  var options = {
    title: 'Anzahl Mitglieder nach Jahren',
    function: 'linear',
    pointSize: 16
  };

  var chart = new google.visualization.LineChart(document.getElementById('chart'));
  google.visualization.events.addListener(chart, 'ready', function() {
    console.log(chart.getImageURI());
  });
  chart.draw(data, options);
}
