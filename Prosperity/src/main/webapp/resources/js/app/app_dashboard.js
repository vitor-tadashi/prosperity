$(function	()	{

	//Morris Chart
	var donutChart = Morris.Donut({
	  element: 'donutChart',
	  data: [
		{label: "Candidatura", value: 10000},
		{label: "Em análise", value: 3091},
		{label: "Mail-Order Sales", value: 2781},
		{label: "Mail-Order Sales", value: 2781},
		{label: "Mail-Order Sales", value: 2781},
		{label: "Download Sales", value: 1236},
		{label: "In-Store Sales", value: 3091},
		{label: "Mail-Order Sales", value: 2781},
		{label: "Mail-Order Sales", value: 2781},
		{label: "Mail-Order Sales", value: 2781},
		{label: "Mail-Order Sales", value: 2781}
	  ],
	  colors: ['#f3ce85','#65CEA7' ,'#FC8675','#65CEA7','#65CEA7','#f3ce85','#65CEA7' ,'#FC8675','#65CEA7','#65CEA7','#65CEA7']
	});
	

	$(window).resize(function(e)	{
		//resize morris chart
		setTimeout(function() {
			donutChart.redraw();
		},500);
	});
});
