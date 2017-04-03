$(function() {
	
	//Script para preencher automático o Radio de TipoVaga
	
	if(($("#tipoVagaVar").val() == "R")){
		$("#idTipoVagaR").prop("checked",true)
	} else if(($("#tipoVagaVar").val() == "P")){
		$("#idTipoVagaP").prop("checked",true)
	} else if (($("#tipoVagaVar").val() == "H")){
		$("#idTipoVagaH").prop("checked",true)
	};
	
	//Script para preencher automático o Radio de Aumento de Quadro
	
	if(($("#aumentoQuadroVar").val() == "N")){
		$("#novo").prop("checked",true)
	} else if(($("#aumentoQuadroVar").val() == "S")){
		$("#substituicao").prop("checked",true)
	};
	
	if(($("#aumentoQuadroVar").val() == "N")) {
		$("div#nome").addClass("hide");
	}else if (($("#aumentoQuadroVar").val() == "S")){
		$("div#nome").removeClass("hide");
	};
	
	$("#novo").click(function() {
		$("div#nome").addClass("hide");
	});
	
	$("#substituicao").click(function() {
		$("div#nome").removeClass("hide");
	});
	
	//Script para preencher automático o Radio de Local de Trabalho
	
	if(($("#localTrabalhoVar").val() == "C")){
		$("#cliente").prop("checked",true)
	} else if(($("#localTrabalhoVar").val() == "I")){
		$("#interno").prop("checked",true)
	}
	
	//Script para alteração da Aba Dados do Projeto e do Radio Button Local de Trabalho
	
	if (($("#localTrabalhoVar").val() == "C")) {
		$("div#dadosAlocacao").removeClass("hide");
	}else if(($("#localTrabalhoVar").val() == "I")){
		$("div#dadosAlocacao").addClass("hide");
	};

	$("#cliente").click(function() {
		$("div#dadosAlocacao").removeClass("hide");
	});
	$("#interno").click(function() {
		$("div#dadosAlocacao").addClass("hide");
	});
	
	//Script para alternar o WizardTab para proxima aba
	
	var currentStep = 1;

	$("#prevStep2").click(function() {

		currentStep--;

		if (currentStep == 1) {

			$('#wizardDemo li:eq(0) a').tab('show');

			$('#prevStep2').attr('disabled', true);
			$('#prevStep2').addClass('disabled');

		} else if (currentStep == 2) {
			$('#wizardDemo li:eq(1) a').tab('show');
			$('#nextStep2').text('Próximo');
			$('#btnCadastrar2').addClass('hide');
			$('#nextStep2').removeClass('disabled')
		}

		else if (currentStep == 3) {
			$('#wizardDemo li:eq(2) a').tab('show');
		}
		return false;
	});

	$("#nextStep2").click(function() {
		
		if (currentStep == 1) {
			currentStep++;
			$('#wizardDemo li:eq(1) a').tab('show');
			$('#prevStep2').attr('disabled', false);
			$('#prevStep2').removeClass('disabled');
			$('#nextStep2').text('Próximo');
			return false;
			
		} else if (currentStep == 2) {
			
			$('#wizardDemo li:eq(2) a').tab('show');
			$('#nextStep2').addClass('disabled');
			$('#btnCadastrar2').removeClass('hide');
			currentStep++;
		}
	});

	$("#btnCadastrar2").click(function() {
		//var data = new Date().toLocaleDateString();
		$("#dataInicio").val(new Date().toLocaleDateString()); 
		$("#formCadastro2").submit();
	});

});
