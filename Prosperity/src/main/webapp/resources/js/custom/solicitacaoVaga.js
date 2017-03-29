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
		$("section#dadosInterno").addClass("hide");
		$("section#dadosAlocacao").removeClass("hide");
	}else if(($("#localTrabalhoVar").val() == "I")){
		$("section#dadosInterno").removeClass("hide");
		$("section#dadosAlocacao").addClass("hide");
	};

	$("#cliente").click(function() {
		$("section#dadosInterno").addClass("hide");
		$("section#dadosAlocacao").removeClass("hide");
	});
	$("#interno").click(function() {
		$("section#dadosInterno").removeClass("hide");
		$("section#dadosAlocacao").addClass("hide");
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
		
		// Validação da primeira WizardTab
		/*
		 * if (document.getElementById("txtSolicitante").value == ""){
		 * alert("Nome do solicitante é obrigatório"); return false;
		 * 
		 * }else if(document.getElementById("substituicao").checked == true &&
		 * document.getElementById("nomeSubstituido").value == ""){ alert("Nome
		 * do substituido é obrigatório"); return false;
		 * 
		 * }else if(document.getElementById("cmbCargo").value == 0){
		 * alert("Cargo é obrigatório"); return false;
		 * 
		 * }else if(document.getElementById("cmbSenioridade").value == 0){
		 * alert("Senioridade é obrigatório"); return false;
		 * 
		 * }else if(document.getElementById("dataInicio").value ==
		 * "01/01/2017"){ alert("Data de inicio é obrigatório"); return false;
		 * 
		 * }//Validação segunda WizardTab projetos Internos
		 * 
		 * else{
		 */// WizardTab de próxima página
		if (currentStep == 1) {
			currentStep++;
			$('#wizardDemo li:eq(1) a').tab('show');
			$('#prevStep2').attr('disabled', false);
			$('#prevStep2').removeClass('disabled');
			$('#nextStep2').text('Próximo');
			return false;
		} else if (currentStep == 2) {
			/*
			 * if(document.getElementById("cliente").checked == true){
			 * if(document.getElementById("cmbProjetoCliente").value == 0 ){
			 * alert("Projeto é obrigatório"); return false; }else
			 * if(document.getElementById("cmbGestorCliente").value == 0){
			 * alert("Gestor é obrigatório"); return false; }else{
			 */
			/*
			 * $('#wizardDemo li:eq(2) a').tab('show');
			 * $('#nextStep2').addClass('disabled');
			 * $('#btnCadastrar2').removeClass('hide'); currentStep++; //} }
			 */
			// else if(document.getElementById("interno").checked == true){
			/*
			 * if(document.getElementById("cmbProjetoInterno").value == 0 ){
			 * alert("Projeto é obrigatório"); return false; }else
			 * if(document.getElementById("cmbGestorInterno").value == 0){
			 * alert("Gestor é obrigatório"); return false; }else{
			 */
			$('#wizardDemo li:eq(2) a').tab('show');
			$('#nextStep2').addClass('disabled');
			$('#btnCadastrar2').removeClass('hide');
			currentStep++;
			// }
		}
		// }
		// }
	});

	$("#btnCadastrar2").click(function() {
		$('#formCadastro2').submit();
		
	});

});
