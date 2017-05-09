$(document).ready(function() {
	if($("#solicitante").val()) {
		$("#txtSolicitante").val($("#solicitante").val());
	}
	

	$(document).ready(function() {

		if ($("input#contErro").val() > 0) {
			$('#textDiv').addClass("alert alert-danger");
		}
		$('.telefone').mask('(00)0000-00009');
		$('.data').mask('00/00/0000');
		
		 CKEDITOR.replace('editor');
		 
		 setTimeout(function () {
	            $('#msg-sucesso').fadeOut(1500);
	        }, 5000);
	})
	
	var elements1 = $("#selectedBox1 option").each(function(){
			    $(this).val();
			});
	
	var elements2 = $("#selectedBox2 option").each(function(){
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
	
	function maxCaracterFormacaoAcademica(){
		var maxFormacaoAcademica = $("#descricaoFormacaoAcademica").val();
		var restante = 500 - maxFormacaoAcademica.length;
		var maxCaracteres = document.querySelector("#maxFormacaoAcademica");
		maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
	}
	
	function maxCaracterPefilComportamental(){
		var maxPerfilComportamental = $("#descricaoPerfilComportamental").val();
		var restante = 500 - maxPerfilComportamental.length;
		var maxCaracteres = document.querySelector("#maxPerfilComportamental");
		maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
	}
	
	function maxCaracterPefilTecnico(){
		var maxPerfilTecnico = $("#descricaoPerfilTecnico").val();
		var restante = 500 - maxPerfilTecnico.length;
		var maxCaracteres = document.querySelector("#maxPerfilTecnico");
		maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
	}
	
	//Ajax para verificar o projeto e preencher o campo cliente de acordo com o projeto
	
	var dropdownProjeto = document.querySelector("#cmbProjetoInterno");
	dropdownProjeto.addEventListener("change",function(){
		var id = dropdownProjeto.value;
		if (id>0){
			$.ajax({
				url: "/vaga/obter-cliente",
				type: "GET",
				dataType: "JSON",
				data: {id : id},
				success: function(lista){
					$("#Cliente").val(lista[0].cliente.nome);
				}
			});
		} else {
			$("#Cliente").val("Selecione o projeto");
		}
	});
	
	//Ajax para verificar o cargo e a senioridade e preencher o campo de valor minimo e valor máximo
	
	var dropdownSenioridade = document.querySelector("#cmbSenioridade");
	var dropdownCargo = document.querySelector("#cmbCargo");
	dropdownSenioridade.addEventListener("change",function(){
		var idSenioridade = dropdownSenioridade.value;
		var idCargo = dropdownCargo.value;
		if (idSenioridade>0 && idCargo>0){
			$.ajax({
				url: "/vaga/obter-range-salarial",
				type: "GET",
				dataType: "JSON",
				data: {idCargo : idCargo,
					idSenioridade : idSenioridade},
				success: function(lista){
					$("#valorMinimo").val(lista[0].valorMinSalario);
					$("#valorMaximo").val(lista[0].valorMaxSalario);
				}
			});
		} else{
			$("#valorMinimo").val("R$");
			$("#valorMaximo").val("R$");
		}
	});
	
	dropdownCargo.addEventListener("change",function(){
		var idSenioridade = dropdownSenioridade.value;
		var idCargo = dropdownCargo.value;
		if (idSenioridade>0 && idCargo>0){
			$.ajax({
				url: "/vaga/obter-range-salarial",
				type: "GET",
				dataType: "JSON",
				data: {idCargo : idCargo,
					idSenioridade : idSenioridade},
				success: function(lista){
					$("#valorMinimo").val(lista[0].valorMinSalario);
					$("#valorMaximo").val(lista[0].valorMaxSalario);
				}
			});
		} else{
			$("#valorMinimo").val("R$");
			$("#valorMaximo").val("R$");
			
		}
	});
	
	// Ajax para verificar o cargo e a senioridade e preencher os campos de formação
	// academica
	// Perfil coomportamental
	// Perfil técnico
		
		var dropdowndescricaoFormacaoAcademica = document.querySelector("#cmbSenioridade");
		var dropdownCargo = document.querySelector("#cmbCargo");
		dropdownSenioridade.addEventListener("change",function(){
			var idSenioridade = dropdownSenioridade.value;
			var idCargo = dropdownCargo.value;
			if (idSenioridade>0 && idCargo>0){
				$.ajax({
					url: "/vaga/obter-perfil-pre-pronto",
					type: "GET",
					dataType: "JSON",
					data: {idCargo : idCargo,
						idSenioridade : idSenioridade},
					success: function(lista){
						$("#descricaoFormacaoAcademica").val(lista[0].dsPreTexto);
						$("#descricaoPerfilComportamental").val(lista[0].dsPreTexto);
						$("#descricaoPerfilTecnico").val(lista[0].dsPreTexto);
					}
				});
			} else{
				$("#descricaoFormacaoAcademica").val("Nao funcionou");
				$("#descricaoPerfilComportamental").val("Nao funcionou");
				$("#descricaoPerfilTecnico").val("Nao funcionou");
			}
		});
	
		//Ajax para verificar o perfil e ver se ele pode editar avaliadores
	
    	var id = $("#idPerfil").val();
    	$.ajax({
    		url: "/usuario/obter-perfil-funcionalidade",
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
		$("div#dadosAlocacao").removeClass("hide");
	}else if(($("#localTrabalhoVar").val() == "I")){
		$("div#dadosAlocacao").hide();
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
    		url: "/vaga/avaliadores",
    		type: "POST",
    		data: {avaliadores : result},
    		success: function(data){
    			console.log(data);
    		}
    	});
    	var tel = $("#telResponsavel").val().replace(/[^\d]+/g,'');
    	$("#telResponsavel").val(tel);
    	var data = $("#dataInicio").val();
    	$("#dataInicio").val(data);
    	console.log(dataInicio.value);
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
	
	function validarData() {
		
		var campo = $(this).val();			
		
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
	}})
