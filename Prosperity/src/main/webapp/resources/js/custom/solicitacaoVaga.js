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
    	
    	//Validação da primeira WizardTab
    	/*if (document.getElementById("txtSolicitante").value == ""){
    		alert("Nome do solicitante é obrigatório");
    		return false;
    		
    	}else if(document.getElementById("substituicao").checked == true && document.getElementById("nomeSubstituido").value == ""){
    		alert("Nome do substituido é obrigatório");
    		return false;
		
		}else if(document.getElementById("cmbCargo").value == 0){
    		alert("Cargo é obrigatório");
    		return false;
		
		}else if(document.getElementById("cmbSenioridade").value == 0){
    		alert("Senioridade é obrigatório");
    		return false;
		
		}else if(document.getElementById("dataInicio").value == "01/01/2017"){
    		alert("Data de inicio é obrigatório");
    		return false;
		
		}//Validação segunda WizardTab projetos Internos
		 
		 else{	*/ //WizardTab de próxima página
			 	if (currentStep == 1){
				    currentStep++;
				    $('#wizardDemo li:eq(1) a').tab('show');
					$('#prevStep2').attr('disabled',false);
					$('#prevStep2').removeClass('disabled');
		            $('#nextStep2').text('Próximo');
		            return false;
			 	}
			 	else if(currentStep == 2)	{
			        /* if(document.getElementById("cliente").checked == true){
							if(document.getElementById("cmbProjetoCliente").value == 0 ){
								alert("Projeto é obrigatório");
							return false;
							}else if(document.getElementById("cmbGestorCliente").value == 0){
								alert("Gestor é obrigatório");
							return false;
							}else{*/
						   /*      $('#wizardDemo li:eq(2) a').tab('show');
						         $('#nextStep2').addClass('disabled');
						         $('#btnCadastrar2').removeClass('hide');
						         currentStep++;
							//}
		 			}*/
			         //else if(document.getElementById("interno").checked == true){
							/*if(document.getElementById("cmbProjetoInterno").value == 0 ){
								alert("Projeto é obrigatório");
							return false;
							}else if(document.getElementById("cmbGestorInterno").value == 0){
								alert("Gestor é obrigatório");
							return false;
							}else{*/
						         $('#wizardDemo li:eq(2) a').tab('show');
						         $('#nextStep2').addClass('disabled');
						         $('#btnCadastrar2').removeClass('hide');
						         currentStep++;
							//}
		 			}
			   	// }
    		//}
	 });
		
    $("#btnCadastrar2").click(function(){
    	$('#formCadastro2').submit();
    	$(document).ready(function() {
    		if($("input#contErro").val()>0){
    			$('#textDiv').addClass("alert alert-danger text-center");
    		}
    	})
    });
    
    
});

