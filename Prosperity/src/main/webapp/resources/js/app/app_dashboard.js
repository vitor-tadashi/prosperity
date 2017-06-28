$(function	()	{

	//Morris Chart
	var donutChart = Morris.Donut({
	  element: 'donutChart',
	  data: [
		{label: "Candidatura", value: $('#qtd-candidaturas-js').val()},
		{label: "Em análise", value: $('#qtd-emAnalise-js').val()},
		{label: "Aprovado", value: $('#qtd-aprovados-js').val()},
		{label: "Reprovado", value: $('#qtd-reprovados-js').val()},
		{label: "Contratado", value: $('#qtd-contratados-js').val()},
		{label: "Cancelado", value: $('#qtd-cancelados-js').val()}
	  ],
	  colors: ['#03C9A9','#e67e22' ,'#2ECC71','#CF000F','#2ECC71','#CF000F']
	});
	

	$(window).resize(function(e)	{
		//resize morris chart
		setTimeout(function() {
			donutChart.redraw();
		},500);
	});
});
