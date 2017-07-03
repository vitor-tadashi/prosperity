//MASK DOS CAMPOS DE CADASTRAR CANDIDATO  

$(document).ready(function() {
	setTimeout(function() {
		$('#msg-sucesso').fadeOut(1500);
	}, 5000);
	if($("#upload-curriculo2").val() == ""){
		$("#btnDownload").prop('disabled',true);
	}
	$(document).on("change","select",function(){
		  $("option[value=" + this.value + "]", this)
		  .attr("selected", true).siblings()
		  .removeAttr("selected")
		});
});

$( "#canalInformacao" ).change(function() {
	
	/* Função para mostrar o textarea Outros quando este for selecionado no combobox */
	
	var select = $(this).val();
	
    if (select == '9') {
    	// Outros fica obrigatório e visível:
    	$('.js-outros').show();
    	$('#outros').prop('required',true);
    	
    	$('.js-indicacao-colegas').hide();
    	$('#indicacao-colegas').prop('required',false);
    	
    }
    else if (select == '8') {
    	$('.js-outros').hide();
    	$('#outros').prop('required',false);
    	
    	// Indicacao colegas fica obrigatório e visível:
    	$('.js-indicacao-colegas').show();
    	$('#indicacao-colegas').prop('required',true);
    }
    else {
    	
    	// Ninguém selecionado, ninguém aparece:
    	$('.js-outros').hide();
    	$('.js-indicacao-colegas').hide();
    	
    	// Ninguém obrigatório:
    	$('#outros').prop('required',false);
    	$('#indicacao-colegas').prop('required',false);
    }
	});

$(document).ready(function() {

	// Ao carregar a página, esses campos não aparecem nem ficam obrigatórios:
	$('.js-outros').hide();
	$('.js-indicacao-colegas').hide();
	$('#outros').prop('required',false);
	$('#indicacao-colegas').prop('required',false);
	
	$('.cpf').mask('000.000.000-00');
	$('.telefone').mask('(00)0000-00009');
	$("#cep").mask("00000-000");
	$('.date').mask('00/00/0000');
	$('.dinheiro').mask('000.000,00', {
		reverse : true
	});
});
// FUNCTION CEP

function limpa_formulário_cep() {
	// Limpa valores do formulário de cep.
	document.getElementById('rua').value = ("");
	document.getElementById('cidade').value = ("");
	document.getElementById('uf').value = ("");
}

function meu_callback(conteudo) {
	if (!("erro" in conteudo)) {
		// Atualiza os campos com os valores.
		document.getElementById('rua').value = (conteudo.logradouro);
		document.getElementById('cidade').value = (conteudo.localidade);
		document.getElementById('uf').value = (conteudo.uf);

		var div = document.getElementById("textDiv").className = "hide";
	} // end if.
	else {
		// CEP não Encontrado.

		var div = document.getElementById("textDiv").className = "alert alert-danger";

		textDiv.textContent = "CEP inválido";

		var text = "[" + div.textContent + "]";

		limpa_formulário_cep();
		var div = document.getElementById("textDiv");

		textDiv.textContent = "CEP inválido";

		var text = "[" + div.textContent + "]";

	}
}

function pesquisacep(valor) {

	// Nova variável "cep" somente com dígitos.
	var cep = valor.replace(/\D/g, '');

	// Verifica se campo cep possui valor informado.
	if (cep != "") {

		// Expressão regular para validar o CEP.
		var validacep = /^[0-9]{8}$/;

		// Valida o formato do CEP.
		if (validacep.test(cep)) {
			var script = document.createElement('script');

			// Sincroniza com o callback.
			script.src = '//viacep.com.br/ws/' + cep
					+ '/json/?callback=meu_callback';

			// Insere script no documento e carrega o conteúdo.
			document.body.appendChild(script);

		} // end if.
		else {
			// cep é inválido.
			var div = document.getElementById("textDiv").className = "alert alert-danger";

			textDiv.textContent = "CEP inválido";

			var text = "[" + div.textContent + "]";
			limpa_formulário_cep();

		}

	} // end if.
	else {
		// cep sem valor, limpa formulário.
		var div = document.getElementById("textDiv");

		textDiv.textContent = "";

		var text = "[" + div.textContent + "]";
		limpa_formulário_cep();
	}
};

$(document).ready(function() {
	if ($("input#contErro").val() > 0) {
		$('#textDiv').addClass("alert alert-danger");
	}
})
function verificarCPF(strCPF) {
	var Soma;
	var Resto;
	strCPF = strCPF.substring(0, 3) + strCPF.substring(4, 7)
			+ strCPF.substring(8, 11) + strCPF.substring(12, 14);
	Soma = 0;

	console.log(strCPF);
	var div = document.getElementById("textDiv1");

	if (strCPF == '') {
		var div = document.getElementById("textDiv1").className = "alert alert-danger";

		textDiv1.textContent = "O campo CPF deve ser preenchido";
		var text = "[" + div.textContent + "]";

		return false;
	}

	if (strCPF == "00000000000") {
		var div = document.getElementById("textDiv1").className = "alert alert-danger";

		textDiv1.textContent = "CPF inválido zeros";

		var text = "[" + div.textContent + "]";
		return false;
	}

	for (i = 1; i <= 9; i++)
		Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
	Resto = Soma % 11;

	if ((Resto == 0) || (Resto == 1)) {
		Resto = 0;
	} else {
		Resto = 11 - Resto;
	}

	if (Resto != parseInt(strCPF.substring(9, 10))) {
		var div = document.getElementById("textDiv1").className = "alert alert-danger";

		textDiv1.textContent = "CPF inválido";

		var text = "[" + div.textContent + "]";
		return false
	}

	Soma = 0;
	for (i = 1; i <= 10; i++)
		Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
	Resto = Soma % 11;

	if ((Resto == 0) || (Resto == 1)) {
		Resto = 0;
	} else {
		Resto = 11 - Resto;
	}

	if (Resto != parseInt(strCPF.substring(10, 11))) {
		var div = document.getElementById("textDiv1").className = "alert alert-danger";

		textDiv1.textContent = "CPF inválido";

		var text = "[" + div.textContent + "]";
		return false;
	}

	var div = document.getElementById("textDiv1").className = "";

	textDiv1.textContent = "";

	return true;
}

function validarData(idCampo) {

	var campo = $("#" + idCampo).val();
	if (campo != "") {
		erro = 0;
		hoje = new Date();
		anoAtual = hoje.getFullYear();
		barras = campo.split("/");
		if (barras.length == 3) {
			dia = barras[0];
			mes = barras[1];
			ano = barras[2];
			resultado = (!isNaN(dia) && (dia > 0) && (dia < 32))
					&& (!isNaN(mes) && (mes > 0) && (mes < 13))
					&& (!isNaN(ano) && (ano.length == 4) && (ano >= 1900));
			if (!resultado) {
				var div = document.getElementById("textDiv2").className = "alert alert-danger";

				textDiv2.textContent = "Data de nascimento inválida";

				var text = "[" + div.textContent + "]";

				return false;
			}
		} else {
			var div = document.getElementById("textDiv2").className = "";

			textDiv2.textContent = "Data de nascimento inválida";

			var text = "[" + div.textContent + "]";

			return false;
		}
		var div = document.getElementById("textDiv2").className = "";

		textDiv2.textContent = "";

		var text = "[" + div.textContent + "]";

		return true;

	}
}

function validarData1(idCampo) {

	var campo = $("#" + idCampo).val();
	if (campo != "") {
		erro = 0;
		hoje = new Date();
		anoAtual = hoje.getFullYear();
		barras = campo.split("/");
		if (barras.length == 3) {
			dia = barras[0];
			mes = barras[1];
			ano = barras[2];
			resultado = (!isNaN(dia) && (dia > 0) && (dia < 32))
					&& (!isNaN(mes) && (mes > 0) && (mes < 13))
					&& (!isNaN(ano) && (ano.length == 4) && (ano >= 1900));
			if (!resultado) {
				var div = document.getElementById("textDiv2").className = "alert alert-danger";

				textDiv2.textContent = "Data de conclusão inválida";

				var text = "[" + div.textContent + "]";

				return false;
			}
		} else {
			var div = document.getElementById("textDiv2").className = "";

			textDiv2.textContent = "Data de nascimento inválida";

			var text = "[" + div.textContent + "]";

			return false;
		}
		var div = document.getElementById("textDiv2").className = "";

		textDiv2.textContent = "";

		var text = "[" + div.textContent + "]";

		return true;

	}
}

function validarData3(idCampo) {

	var campo = $("#" + idCampo).val();
	if (campo != "") {
		erro = 0;
		hoje = new Date();
		anoAtual = hoje.getFullYear();
		barras = campo.split("/");
		if (barras.length == 3) {
			dia = barras[0];
			mes = barras[1];
			ano = barras[2];
			resultado = (!isNaN(dia) && (dia > 0) && (dia < 32))
					&& (!isNaN(mes) && (mes > 0) && (mes < 13))
					&& (!isNaN(ano) && (ano.length == 4) && (ano >= 1900));
			if (!resultado) {
				var div = document.getElementById("textDiv2").className = "alert alert-danger";

				textDiv2.textContent = "Data de último contato inválida";

				var text = "[" + div.textContent + "]";

				return false;
			}
		} else {
			var div = document.getElementById("textDiv2").className = "";

			textDiv2.textContent = "Data de último contato inválida";

			var text = "[" + div.textContent + "]";

			return false;
		}
		var div = document.getElementById("textDiv2").className = "";

		textDiv2.textContent = "";

		var text = "[" + div.textContent + "]";

		return true;

	}
}

function validarData4(idCampo) {

	var campo = $("#" + idCampo).val();
	if (campo != "") {
		erro = 0;
		hoje = new Date();
		anoAtual = hoje.getFullYear();
		barras = campo.split("/");
		if (barras.length == 3) {
			dia = barras[0];
			mes = barras[1];
			ano = barras[2];
			resultado = (!isNaN(dia) && (dia > 0) && (dia < 32))
					&& (!isNaN(mes) && (mes > 0) && (mes < 13))
					&& (!isNaN(ano) && (ano.length == 4) && (ano >= 1900));
			if (!resultado) {
				var div = document.getElementById("textDiv2").className = "alert alert-danger";

				textDiv2.textContent = "Data de última entrevista inválida";

				var text = "[" + div.textContent + "]";

				return false;
			}
		} else {
			var div = document.getElementById("textDiv2").className = "";

			textDiv2.textContent = "Data de última entrevista inválida";

			var text = "[" + div.textContent + "]";

			return false;
		}
		var div = document.getElementById("textDiv2").className = "";

		textDiv2.textContent = "";

		var text = "[" + div.textContent + "]";

		return true;

	}
}

function dataFormatada(dt) {
	var data = new Date(dt);
	var dia = data.getDate();
	if (dia.toString().length == 1)
		dia = "0" + dia;
	var mes = data.getMonth() + 1;
	if (mes.toString().length == 1)
		mes = "0" + mes;
	var ano = data.getFullYear();
	return dia + "/" + mes + "/" + ano;
}
function pesquisacpf() {
	var cpf = $('#cpf').val();

	$('select#vaga').removeAttr('disabled');

	if (verificarCPF(cpf)) {
		obterCandidato(cpf);
		// $('input#cpf').attr('disabled', 'disabled');
	}
}

function obterCandidato(cpf) {
	$.ajax({
		url : "/candidato/obter",
		dataType : "JSON",
		data : {
			"cpf" : cpf
		},
		type : "GET",
		success : function(data) {
			console.log(data);

			if (data != null) {
				$("#id").val(data.id);
				$("#nome").val(data.nome);
				$("#rg").val(data.rg);
				$("#email").val(data.email);
				$("#dataNascimento").val(dataFormatada(data.dataNascimento));
				$("#contato").val(data.contato.telefone);
				$("#cep").val(data.endereco.cep);
				$("#rua").val(data.endereco.logradouro);
				$("#numero").val(data.endereco.numero);
				$("#complemento").val(data.endereco.complemento);
				$("#uf").val(data.endereco.estado);
				$("#cidade").val(data.endereco.cidade);
				$("#curso").val(data.formacao.nomeCurso);
				$("#instituicao").val(data.formacao.nomeInstituicao);
				$("#tipoDeCurso").val(data.formacao.tipoCurso.id);
				$("#mesAnoConclusao").val(
						dataFormatada(data.formacao.dataConclusao));
				$("#valorPretensao").val(data.valorPretensao);
				$("#valorPretensao").val(data.valorPretensao);
				$("#vaga").val(data.vagaCandidato.vaga.id);
				$("#canalInformacao")
						.val(data.vagaCandidato.canalInformacao.id);
				$("#dataUltimoContato").val(
						dataFormatada(data.dataUltimoContato));
				$("#entrevista").val(dataFormatada(data.entrevista));
				$("#situacaoAtual").val(data.formacao.situacaoAtual.id);

				var status = data.ultimoStatus.status;
				if (status.id != 17 && status.id != 5 && status.id != 29 && status.id != 15) {
					$('select#vaga').attr('disabled', 'disabled');
				}
				$('input#cpf').attr('disabled', 'disabled');

				var dadosEntrevistadores = data.dataEntrevista;

				// for each que percorre a lista e mostra na tela
				$(dadosEntrevistadores).each(function(index, value) {
					// var campos = "<div class='row'>" +
					// "<div class='col-xs-4 form-group'>" +
					// "<label>Nome do entrevistador: &nbsp;</label>" +
					// "<input type='hidden' value='dataEntrevista.usuario'
					// name='dataEntrevista"+'['+ index +
					// ']'+".usuario.funcionario'>" +
					// "<p id='entrevistador"+ index +"' name
					// ='dataEntrevista"+'['+ index +
					// ']'+".usuario.funcionario.nome'></p>" +
					// "</div>" +
					// "<div class='col-md-2 form-group'>" +
					// "<label>Data de entrevista: &nbsp;</label>" +
					// "<input type='text' id='data"+ index +"'
					// class='form-control date' value='"+ value.dataEntrevista
					// +"'/>" +
					// "</div>" +
					// "</div>";

					$("#fourth").append(campos);
				});
			}
		},
		error : function(data) {
			console.log("Cpf não encontrado");
		}
	});
}

$(document).ready(function() {
	var url = window.location.href;
	if (url.match(/editar/)) {
		$(".download-download").show();
		if($('#funcionalidade34').val()){
			$('#tabDataContato').removeClass('hide');
			$('#tabDataEntrevista').removeClass('hide');
			
		}
	} else {
		$(".download-download").hide();
	}
});

function download(url) {
	window.location.href = url;
}
function validarVaga() {
	var vaga = document.getElementById("vaga").value;
	$vaga = vaga;
	if (vaga == "0") {
		var div = document.getElementById("textDiv2").className = "alert alert-danger";

		textDiv2.textContent = "O campo vaga a ser aplicado deve ser preenchido";

		var text = "[" + div.textContent + "]";

		return false;
	}
	return true;
}

//funcão para a aba de data de comunicação
function inserirComunicacao(){
	if($.trim($('#dataContato').val()) == ''  || $.trim($('#obs').val()) == '' ){
		var div = document.getElementById("textDiv2").className = "alert alert-danger";

		textDiv2.textContent = "Preencha os campos";
		return false;
	}
	var dadosajax = {
			'dataContato' : $("#dataContato").val(),
			'observacao' : $("#obs").val(),
			'usuario': $("#txtUsuario").val(),
			'candidato': $("#id").val(),
			'vaga' : $('#vaga').val()
			};
			$.ajax({
			url: "/candidato/comunicacao",
			data: dadosajax,
			type: 'POST',
			cache: false,
			success: function(){
				
				$('#trNova').append(
						"<tr>"+
						"<td>"+$("#dataContato").val()+"</td>"+
						"<td>"+$("#obs").val()+"</td>"+
						"<td>"+$("#nmUsuario").val()+"</td>"+
						"</tr>"
				)
				$('#dataContato').val("")
				$('#obs').val("")
			},
			error: function(){
				
			}
			});
}
//função para validar e exibir mensagem da data de contato
function validarDataContato(idCampo) {

				var campo = $("#" + idCampo).val();
				if (campo != "") {
					erro = 0;
					hoje = new Date();
					anoAtual = hoje.getFullYear();
					mesAtual = hoje.getMonth()+ 1;
					diaAtual = hoje.getDate();
					dataAtual = diaAtual +"/"+mesAtual+"/"+anoAtual;
					barras = campo.split("/");
					if (barras.length == 3) {
						dia = barras[0];
						mes = barras[1];
						ano = barras[2];
						if(ano>=anoAtual){
							if(mes>=mesAtual){
								if(dia>diaAtual){
								
								var div = document.getElementById("textDiv2").className = "alert alert-danger";

								textDiv2.textContent = "Data de último contato inválida";

								var text = "[" + div.textContent + "]";
									return false;
								}
							}
							
						}
						resultado = (!isNaN(dia) && (dia > 0) && (dia < 32))
								&& (!isNaN(mes) && (mes > 0) && (mes < 13))
								&& (!isNaN(ano) && (ano.length == 4) && (ano >= 1900));
						if (!resultado) {
							var div = document.getElementById("textDiv2").className = "alert alert-danger";

							textDiv2.textContent = "Data de último contato inválida";

							var text = "[" + div.textContent + "]";

							return false;
						}
					} else {
						var div = document.getElementById("textDiv2").className = "";

						textDiv2.textContent = "Data de último contato inválida";

						var text = "[" + div.textContent + "]";

						return false;
					}
					var div = document.getElementById("textDiv2").className = "";

					textDiv2.textContent = "";

					var text = "[" + div.textContent + "]";

					return true;

				}
			}

function salvarForm(){
	$('#vaga').prop('disabled',false);
	$('#formCadastro').submit();
}
