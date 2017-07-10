function maxCaracterFormacaoAcademica() {
	var maxFormacaoAcademica = $("#descricaoFormacaoAcademica").val();
	var restante = 2000 - maxFormacaoAcademica.length;
	var maxCaracteres = document.querySelector("#maxFormacaoAcademica");
	maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
}

function maxCaracterPefilComportamental() {
	var maxPerfilComportamental = $("#descricaoPerfilComportamental").val();
	var restante = 2000 - maxPerfilComportamental.length;
	var maxCaracteres = document.querySelector("#maxPerfilComportamental");
	maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
}

function maxCaracterPefilTecnico() {
	var maxPerfilTecnico = $("#descricaoPerfilTecnico").val();
	var restante = 2000 - maxPerfilTecnico.length;
	var maxCaracteres = document.querySelector("#maxPerfilTecnico");
	maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
}
function formatReal( int )
{
		int = int.replace('.','');
        var tmp = int+'';
        tmp = tmp.replace(/([0-9]{2})$/g, ",$1");
        if( tmp.length > 6 )
                tmp = tmp.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");

        return tmp;
}
// Ajax para verificar o projeto e preencher o campo cliente de acordo com o
// projeto

var dropdownProjeto = document.querySelector("#cmbProjetoInterno");
dropdownProjeto.addEventListener("change", function() {
	var id = dropdownProjeto.value;
	if (id > 0) {
		$.ajax({
			url : "/vaga/obter-cliente",
			type : "GET",
			dataType : "JSON",
			data : {
				id : id
			},
			success : function(lista) {
				$("#Cliente").val(lista[0].cliente.nome);
			}
		});
	} else {
		$("#Cliente").val("Selecione o projeto");
	}
});


$("#novo").click(function() {
	$("div#nome").addClass("hide");
});

$("#substituicao").click(function() {
	$("div#nome").removeClass("hide");
});

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
		url : "/vaga/avaliadores",
		type : "POST",
		data : {
			avaliadores : result
		},
	}).done(function() {

		/* Mensagem: */
		msg = 'Vaga solicitada com sucesso!'
		$('#msg-sucesso').html(msg).addClass('alert alert-success').show();
		escondeMensagem();
	}).fail(function(jqXHR, textStatus) {

		/* Exibe mensagem no caso de falha de requisição: */
		msg = 'Ocorreu algo de errado!'
		$('#msg-sucesso').html(msg).addClass('alert alert-danger').show();
		escondeMensagem();
	});

	var tel = $("#telResponsavel").val().replace(/[^\d]+/g, '');
	$("#telResponsavel").val(tel);
	var data = $("#dataInicio").val();
	$("#dataInicio").val(data);
	console.log(dataInicio.value);
	
	$("#formCadastro2").submit();
	// var resp = ${resposta};
	// if (resp == "Ok"){
	// alert("Cadastrado com Sucesso");
	// };
});

function enviarAvaliadores() {
	var avaliadores = $('#selectedBox2')[0].length;
	var dados = [];
	for (var i = 0; i < avaliadores; i++) {
		dados.push($('#selectedBox2')[0][i].value);

	}
	return dados;
}

function validarData() {

	var campo = $("#dataInicio").val();
	debugger;
	if (campo != "") {
		erro = 0;
		hoje = new Date();
		anoAtual = hoje.getFullYear();
		barras = campo.split("/");
		if (barras.length == 3)

		{
			dia = barras[0];
			mes = barras[1];
			ano = barras[2];
			resultado = (!isNaN(dia) && (dia > 0) && (dia < 32))
					&& (!isNaN(mes) && (mes > 0) && (mes < 13))
					&& (!isNaN(ano) && (ano.length == 4) && (ano >= anoAtual && ano >= 1900));
			if (!resultado) {
				var div = document.getElementById("textDiv1").className = "alert alert-danger";

				textDiv1.textContent = "Campo \"Data para início\" tem que estar no futuro.";

				var text = "[" + div.textContent + "]";
				return false;
			}
		} else {
			var div = document.getElementById("textDiv1").className = "";

			textDiv1.textContent = "Campo Data para inicio inválido";

			var text = "[" + div.textContent + "]";

			return false;
		}
		var div = document.getElementById("textDiv1").className = "";

		textDiv1.textContent = "";

		var text = "[" + div.textContent + "]";

		return true;

	}

}

// Ajax para verificar o cargo e a senioridade e preencher os campos de formação
// academica
// Perfil coomportamental
// Perfil técnico

// COMENTADO PARA USAR FUTURAMENTE !!!

/*
 * var dropdowndescricaoFormacaoAcademica =
 * document.querySelector("#cmbSenioridade"); var dropdownCargo =
 * document.querySelector("#cmbCargo");
 * dropdownSenioridade.addEventListener("change",function(){ var idSenioridade =
 * dropdownSenioridade.value; var idCargo = dropdownCargo.value; if
 * (idSenioridade>0 && idCargo>0){ $.ajax({ url:
 * "/vaga/obter-perfil-pre-pronto", type: "GET", dataType: "JSON", data:
 * {idCargo : idCargo, idSenioridade : idSenioridade}, success: function(lista){
 * $("#descricaoFormacaoAcademica").val(lista[0].dsPreFormacaoAcademica);
 * $("#descricaoPerfilComportamental").val(lista[0].dsPrePerfilComportamental);
 * $("#descricaoPerfilTecnico").val(lista[0].dsPrePerfilTecnico); } }); } else{
 * $("#descricaoFormacaoAcademica").val("Nao funcionou");
 * $("#descricaoPerfilComportamental").val("Nao funcionou");
 * $("#descricaoPerfilTecnico").val("Nao funcionou"); } });
 */

$(document).ready(function() {

	if ($("#solicitante").val()) {
		$("#txtSolicitante").val($("#solicitante").val());
	}

	var elements1 = $("#selectedBox1 option").each(function() {
		$(this).val();
	});

	var elements2 = $("#selectedBox2 option").each(function() {
		$(this).val();
	});

	for (var i = 0; i < elements1.length; i++) {
		for (var j = 0; j < elements2.length; j++) {
			if (elements1[i].value == elements2[j].value) {
				elements1[i].remove();
			}
		}
	}

	var a = $("#dataAbertura").value + 1;
	if (a == 1) {
		$("#dataAbertura").val("2017-01-01")
	}

	// Ajax para verificar o perfil e ver se ele pode editar avaliadores

	var id = $("#idPerfil").val();
	$.ajax({
		url : "/usuario/obter-perfil-funcionalidade",
		type : "GET",
		dataType : "JSON",
		data : {
			id : id
		},
		success : function(lista) {
			if (lista != null) {
				$.each(lista, function(i, item) {
					if (item.id == 24) {
						$("#fourth").removeClass('hide');
						$("#tabAvaliadores").removeClass('hide')
					}
				});
			}
		}
	});

	$("#cmbProjetoInterno").change(function() {
		var cliente = $("#cmbProjetoInterno").val();
	});

	// Verifica o status da vaga e esconde caso seja somente para editar
	// avaliadores

	if ($("#status").val() == 27) {
		$("#tabInformacoes2").removeClass("active");
		$("#tabAvaliadores2").addClass("active");
		$("#first").removeClass("active in");
		$("#fourth").addClass("active in");
	}

	// Script para preencher automático o Radio de TipoVaga

	if (($("#tipoVagaVar").val() == "R")) {
		$("#idTipoVagaR").prop("checked", true)
	} else if (($("#tipoVagaVar").val() == "P")) {
		$("#idTipoVagaP").prop("checked", true)
	} else if (($("#tipoVagaVar").val() == "H")) {
		$("#idTipoVagaH").prop("checked", true)
	}
	;

	// Script para preencher automático o Radio de Aumento de Quadro

	if (($("#aumentoQuadroVar").val() == "N")) {
		$("#novo").prop("checked", true)
	} else if (($("#aumentoQuadroVar").val() == "S")) {
		$("#substituicao").prop("checked", true)
	}
	;

	if (($("#aumentoQuadroVar").val() == "N")) {
		$("div#nome").addClass("hide");
	} else if (($("#aumentoQuadroVar").val() == "S")) {
		$("div#nome").removeClass("hide");
	}
	;

	// Script para preencher automático o Radio de Local de Trabalho

	if (($("#localTrabalhoVar").val() == "C")) {
		$("#cliente").prop("checked", true)
	} else if (($("#localTrabalhoVar").val() == "I")) {
		$("#interno").prop("checked", true)
	}

	// Script para alteração da Aba Dados do Projeto e do Radio Button Local de
	// Trabalho

	if (($("#localTrabalhoVar").val() == "C")) {
		$("div#dadosAlocacao").removeClass("hide");
	} else if (($("#localTrabalhoVar").val() == "I")) {
		$("div#dadosAlocacao").hide();
	}
	;

	if ($("input#contErro").val() > 0) {
		$('#textDiv').addClass("alert alert-danger");
	}
	$('.telefone').mask('(00)0000-00009');
	$('.data').mask('00/00/0000');

	CKEDITOR.replace('editor');

	setTimeout(function() {
		$('#msg-sucesso').fadeOut(1500);
	}, 5000);

	$('.dinheiro').mask('000.000,00', {
		reverse : true
	});

	// aba de divulgação só aparece para o RH
	var url = window.location.href;
	if (url.match(/editar/)) {
		if ($('#funcionalidade17').val()) {
			$('#tabMarketing').removeClass('hide');

		}
	}
});
