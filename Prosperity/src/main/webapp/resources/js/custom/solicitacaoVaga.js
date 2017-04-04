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

	$("#btnSalvar").click(function() {
		$("#dataInicio").val(new Date().toLocaleDateString()); 
		$("#formCadastro2").submit();
	});

});
