	$(document).ready(function() {

		if ($("input#contErro").val() > 0) {
			$('#textDiv').addClass("alert alert-danger");
		}
		
		$('.cpf').mask('999.999.999-99', {
			reverse : true
		});
		$('.telefone').mask('(99) 99999-9999');
		$('#rg').mask('99.999.999-9');
		$("#cep").mask("99999-999");
		$('.date').mask('99/99/9999');
	})
	
	var elements1 = $("#selectedBox1 option").each(function()
			{
			    $(this).val();
			});
	var elements2 = $("#selectedBox2 option").each(function()
			{
			    $(this).val();
			});
	for(var i = 0 ; i<elements1.length;i++){
		for (var j=0;j<elements2.length;j++) {
			if (elements1[i].value == elements2[j].value){
				elements1[i].remove();
			}
		}
	}
	
	var a = $("#dataAbertura").value + 1;
	if (a == 1){
		$("#dataAbertura").val("2017-01-01")
	}
	
	var dropdownProjeto = document.querySelector("#cmbProjetoInterno");
	dropdownProjeto.addEventListener("change",function(){

		var id = $("#cmbProjetoInterno").val();
		$.ajax({
			url: "http://localhost:8080/vaga/obter-cliente",
			type: "GET",
			dataType: "JSON",
			data: {id : id},
			success: function(lista){
				if(id == 0){
					$("#Cliente").val("Selecione o projeto");
				}
				$("#Cliente").val(lista[0].cliente.nome);
			}
		});
		
	});
	
		//Ajax para verificar o perfil e ver se ele pode editar avaliadores
	
    	var id = $("#idPerfil").val();
    	$.ajax({
    		url: "http://localhost:8080/usuario/obter-perfil-funcionalidade",
    		type: "GET",
    		dataType: "JSON",
    		data: {id : id},
    		success: function(lista){
    			if(lista != null){
	    				$.each(lista,function(i,item){
	    					if(item.id == 24){
	    						$("#fourth").removeClass('hide');
	    						$("#tabAvaliadores").removeClass('hide')
	    				}
	    			});
    			}
    		}
    	});
    	
    	$("#cmbProjetoInterno").change(function(){
    		var cliente = $("#cmbProjetoInterno").val();
    	});
    	
    	
	// Verifica o status da vaga e esconde caso seja somente para editar avaliadores
	
	if ($("#status").val() == 27){
		$("#tabInformacoes").hide();
		$("#tabDados").hide();
		$("#tabPerfil").hide();
		$("#tabInformacoes2").removeClass("active");
		$("#tabAvaliadores2").addClass("active");
		$("#first").removeClass("active in");
		$("#fourth").addClass("active in");
	}
	
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
		$("div#dadosAlocacao").hide();
	}else if(($("#localTrabalhoVar").val() == "I")){
		$("div#dadosAlocacao").show();
	};

	$("#cliente").click(function() {
		$("div#dadosAlocacao").removeClass("hide");
	});
	$("#interno").click(function() {
		$("div#dadosAlocacao").addClass("hide");
	});

	$("#btnSalvar").click(function() {
		
		var info = enviarAvaliadores();
		var result = JSON.stringify(info);
    	$.ajax({
    		url: "http://localhost:8080/vaga/avaliadores",
    		type: "POST",
    		data: {avaliadores : result},
    		success: function(data){
    			console.log(data);
    		}
    	});
    	$("#formCadastro2").submit();
//    	var resp = ${resposta};
//    	if (resp == "Ok"){
//    		alert("Cadastrado com Sucesso");
//    	};
	});
	
	function enviarAvaliadores(){
		var avaliadores = $('#selectedBox2')[0].length;
		var dados = [];
		for(var i=0; i<avaliadores; i++){
			dados.push($('#selectedBox2')[0][i].value);	
			
		}
			return dados;
	}
	
	function validarData(id) {
		
		var campo = $('#dataInicio').val();			
		
		 if (campo!="")
		{
		        erro=0;
		        hoje = new Date();
		        anoAtual = hoje.getFullYear();
		        barras = campo.split("/");
		        if (barras.length == 3)
		        	
		        {
		                dia = barras[0];
		                mes = barras[1];
		                ano = barras[2];
		                resultado = (!isNaN(dia) && (dia > 0) && (dia < 32)) && (!isNaN(mes) && (mes > 0) && (mes < 13)) && (!isNaN(ano) && (ano.length == 4) && (ano >= anoAtual && ano >= 1900));
		                if (!resultado)
		                {
		                	var div = document.getElementById("textDiv2").className = "alert alert-danger";

		    				textDiv2.textContent = "Campo Data para inicio tem que estar no futuro";

		    				var text = "[" + div.textContent + "]";
		                        return false;
		                }
		         }
		         else
		         {
		        		var div = document.getElementById("textDiv").className = "";

		    			textDiv2.textContent = "Campo Data para inicio inválido";

		    			var text = "[" + div.textContent + "]";
		                
		                return false;
		         }
		        var div = document.getElementById("textDiv2").className = "";

    			textDiv2.textContent = "";

    			var text = "[" + div.textContent + "]";
                
		return true;
		
		}
	}
