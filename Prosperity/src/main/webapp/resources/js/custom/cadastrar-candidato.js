  $(document).ready(function () {
	        setTimeout(function () {
	            $('#msg-sucesso').fadeOut(1500);
	        }, 5000);
	    });
	  
		$(document).ready(function() {
		 	 $('.cpf').mask('000.000.000-00', {
				reverse : true 
			}) ; 
			$('.telefone').mask('(00)00000-0000');
			$('#rg').mask('00.000.000-0');
			$("#cep").mask("99999-999");
			$('.date').mask('00/00/0000');
			$('.dinheiro').mask('000.000.000.000.000,00', {reverse: true});

		}) 
		
		
		function validarTel(){
		var tel = $("#contato").val().replace(/[^\d]+/g,'');
		if (tel.length == 10){
			$("#contato").val(tel).mask('(99)9999-9999');
		}else{
			$("#contato").val(tel).mask('(99)99999-9999');
		}
	}

		function limpa_formulário_cep() {
			//Limpa valores do formulário de cep.
			document.getElementById('rua').value = ("");
			document.getElementById('cidade').value = ("");
			document.getElementById('uf').value = ("");
		}

		function meu_callback(conteudo) {
			if (!("erro" in conteudo)) {
				//Atualiza os campos com os valores.
				document.getElementById('rua').value = (conteudo.logradouro);
				document.getElementById('cidade').value = (conteudo.localidade);
				document.getElementById('uf').value = (conteudo.uf);
			} //end if.
			else {
				//CEP não Encontrado.
				limpa_formulário_cep();
				var div = document.getElementById("textDiv").className = "alert alert-danger";

				textDiv.textContent = "";

				var textDiv = "[" + div.textContent + "]";
			}
		}

		function pesquisacep(valor) {

			//Nova variável "cep" somente com dígitos.
			var cep = valor.replace(/\D/g, '');

			//Verifica se campo cep possui valor informado.
			if (cep != "") {

				//Expressão regular para validar o CEP.
				var validacep = /^[0-9]{8}$/;

				//Valida o formato do CEP.
				if (validacep.test(cep)) {
					var script = document.createElement('script');

					//Sincroniza com o callback.
					script.src = '//viacep.com.br/ws/' + cep
							+ '/json/?callback=meu_callback';

					//Insere script no documento e carrega o conteúdo.
					document.body.appendChild(script);

				} //end if.
				else {
					//cep é inválido.
					limpa_formulário_cep();
					var div = document.getElementById("textDiv").className = "alert alert-danger";

    				textDiv.textContent = "CEP inválido";

    				var text = "[" + div.textContent + "]";
				}


				textDiv.textContent = "";

				var text = "[" + div.textContent + "]";
			} //end if.
			else {
				//cep sem valor, limpa formulário.
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
			if (strCPF == "00000000000") {
				var div = document.getElementById("textDiv1").className = "alert alert-danger x";

				textDiv1.textContent = "CPF inválido.";

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

				textDiv1.textContent = "CPF inválido.";

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

				textDiv1.textContent = "CPF inválido.";

				var text = "[" + div.textContent + "]";
				return false;
			}

			textDiv1.textContent = "";

			var text = "[" + div.textContent + "]";
			return true;
		}
		
		
		
		function validarData(idCampo) {

			var campo = $("#"+idCampo).val();
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
			                resultado = (!isNaN(dia) && (dia > 0) && (dia < 32)) && (!isNaN(mes) && (mes > 0) && (mes < 13)) && (!isNaN(ano) && (ano.length == 4) && (ano >= 1900));
			                if (!resultado)
			                {
			                	var div = document.getElementById("textDiv2").className = "alert alert-danger";

			    				textDiv2.textContent = "Data inválida";

			    				var text = "[" + div.textContent + "]";
			                        
			                        return false;
			                }
			         }
			         else
			         {
			        		var div = document.getElementById("textDiv2").className = "";

			    			textDiv2.textContent = "Data inválida";

			    			var text = "[" + div.textContent + "]";
			              
			                return false;
			         }
			        var div = document.getElementById("textDiv2").className = "";

	    			textDiv2.textContent = "";

	    			var text = "[" + div.textContent + "]";
	                
			return true;
			
			}
		}
			

	function dataFormatada(dt){
		var data = new Date(dt);
	    var dia = data.getDate();
	    if (dia.toString().length == 1)
	      dia = "0"+dia;
	    var mes = data.getMonth()+1;
	    if (mes.toString().length == 1)
	      mes = "0"+mes;
	    var ano = data.getFullYear();  
	    return dia+"/"+mes+"/"+ano;
	}
	function pesquisacpf(){
		var cpf = $('#cpf').val();
		
		if (verificarCPF(cpf)) {
			obterCandidato(cpf);
		}	
	}
	
	function obterCandidato(cpf) {
		$.ajax({
			url : "http://localhost:8080/candidato/obter",
			dataType : "JSON",
			data : {
				"cpf" : cpf
			},
			type : "GET",
			success: function (data){
				if(data != null){
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
					$("#mesAnoConclusao").val(dataFormatada(data.formacao.dataConclusao));
					$("#valorPretensao").val(data.valorPretensao);
					$("#valorPretensao").val(data.valorPretensao);
					$("#vaga").val(data.vagaCandidato.vaga.id);
					$("#canalInformacao").val(data.vagaCandidato.canalInformacao.id);
					$("#dataUltimoContato").val(dataFormatada(data.dataUltimoContato));
					$("#entrevista").val(dataFormatada(data.entrevista));
					$("#situacaoAtual").val(data.formacao.situacaoAtual.id);
					
				}
			},
			error: function (data) {
				console.log("Cpf não encontrado");
				
			}
		});
	}
	
	