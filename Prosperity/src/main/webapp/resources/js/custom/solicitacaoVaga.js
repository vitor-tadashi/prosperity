$(function() {
    
    $("#novo").click(function(){
        $("div#nome").addClass("hide");	
    });
    $("#substituicao").click(function(){
        $("div#nome").removeClass("hide");
    });
    
    $("#cliente").click(function(){
        $("section#dadosInterno").addClass("hide");	
        $("section#dadosAlocacao").removeClass("hide");
    });
    $("#interno").click(function(){
        $("section#dadosInterno").removeClass("hide");
        $("section#dadosAlocacao").addClass("hide");
    });
    
    var currentStep = 1; 
    
    $("#prevStep2").click(function(){
		
		currentStep--;
		
		if(currentStep == 1)	{
		
			$('#wizardDemo li:eq(0) a').tab('show');
				
			$('#prevStep2').attr('disabled',true);
			$('#prevStep2').addClass('disabled');
			
		}
		else if(currentStep == 2)	{
			$('#wizardDemo li:eq(1) a').tab('show');
			$('#nextStep2').text('Próximo');
			$('#btnCadastrar2').addClass('hide');
			$('#nextStep2').removeClass('disabled')
		}
		
		else if(currentStep == 3)	{
			$('#wizardDemo li:eq(2) a').tab('show');
		}
		return false;
    });
    
    $("#nextStep2").click(function(){
    	currentStep++ ;
   	 if(currentStep == 2)	{
			$('#wizardDemo li:eq(1) a').tab('show');
			
			$('#prevStep2').attr('disabled',false);
			$('#prevStep2').removeClass('disabled');
           $('#nextStep2').text('Próximo');
   	 }
		else if(currentStep == 3)	{
			$('#wizardDemo li:eq(2) a').tab('show');
			$('#nextStep2').addClass('disabled')
			$('#btnCadastrar2').removeClass('hide');
		}
	 });
		
    $("#btnCadastrar2").click(function(){
    	$('#formCadastro2').submit();
    });
    
    
});

