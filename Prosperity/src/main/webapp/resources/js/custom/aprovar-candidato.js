/* Variáveis globais para auxílio das mensagens */
			var nomeCandidato = "";
			var mensagemMudancaStatus = "";

			function maxCaracterParecer() {
				var maxParecer = $("#parecer").val();
				var restante = 500 - maxParecer.length;
				var maxCaracteres = document.querySelector("#maxParecer");
				maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
			}
			function maxCaracterParecerCancelamento() {
				var maxParecer = $("#parecerCancelamento").val();
				var restante = 300 - maxParecer.length;
				var maxCaracteres = document.querySelector("#maxParecerCanc");
				maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
			}

			$("body").on("click","#aprovar-candidato",function() {
				var inputs = $(this).closest("tr").find("input[type=hidden]");
				var tituloModal = $(this).text();
				inputs.each(function(index, value) {
					if (!isNaN($(value).attr("id"))) {
						var id = $(value).attr("id");
						$.ajax({url : "buscar/"+ id, dataType : "json", method : "GET", success : function(data) {
							console.log('Esse aqui');
							console.log(data);
							var perfil = $('#user').val();
							$("#modalTitulo").text(tituloModal);
								if (data.ultimoStatus.status.id == "9") {
									if (perfil == "Analista de RH" || perfil == "Gestor RH") {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "10") {
									if (perfil == "Administrador" || perfil == "CEO" || perfil == "Diretor de operação") {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "11") {
									if (perfil == "Analista de RH" || perfil == "Gestor RH") {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "13") {
									if (perfil == "Analista de RH" || perfil == "Gestor RH") {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "14") {
									if (perfil == "Analista de RH" || perfil == "Gestor RH") {
										$("#proposta-tab").show();
									}
								} else {
									$("#proposta-tab").hide();
								}
								if (data.ultimoStatus.status.id == "6") {
									$("#avaliacao-tab").show();
									$("#processo-tab").show();
								} else {
									$("#avaliacao-tab").hide();
									$("#processo-tab").hide();
								}
								$('.tab-bar a[href="#infoEntrevista"]').tab('show');
								$('#modalProposta').modal('show');
																
								//carregando as informações do EXCEL via AJAX para a JSP
																
								$('#anteriorCargo').text(data.ultimaProposta.anteriorCargo);
								$('#anteriorEmpresa').text(data.ultimaProposta.anteriorEmpresa);
								$('#vlrAntSalarioFixoBruto').text(data.ultimaProposta.anteriorSalarioFixoBruto);
								$('#vlrAntSalarioLiquidoMensal').text(data.ultimaProposta.anteriorSalarioLiquidoMensal);
								$('#vlrAntVrMensal').text(data.ultimaProposta.anteriorVrMensal);
								$('#vlrAntVaMensal').text(data.ultimaProposta.anteriorVaMensal);
								$('#vlrAntSeguroSaudeMensal').text(data.ultimaProposta.anteriorSeguroSaudeMensal);
								$('#vlrAntValeAuto').text(data.ultimaProposta.anteriorValeAuto);
								$('#vlrAntValeEstacionamento').text(data.ultimaProposta.anteriorEstacionamento);
								$('#vlrAntValeTransporte').text(data.ultimaProposta.anteriorValeTransporte);
								$('#vlrAntLiquidoComBeneficios').text(data.ultimaProposta.anteriorLiquidoComBeneficios);
								$('#vlrAntAnualLiquido').text(data.ultimaProposta.anteriorAnualLiquido);
								$('#vlrAntParticipacaoLucrosOuBonus').text(data.ultimaProposta.anteriorParticipacaoLucrosOuBonus);
								$('#vlrAntTotalAnualLiquidoComBeneficios').text(data.ultimaProposta.anteriorTotalAnualLiquidoComBeneficios);
								
								$('#novaEmpresa').text(data.ultimaProposta.novaEmpresa);
								$('#novoCargo').text(data.ultimaProposta.novoCargo);
								$('#vlrNvSalarioFixoBruto').text(data.ultimaProposta.novoSalarioFixoBruto);
								$('#vlrNvSalarioLiquidoMensal').text(data.ultimaProposta.novoSalarioLiquidoMensal);
								$('#vlrNvVrMensal').text(data.ultimaProposta.novoVrMensal);
								$('#vlrNvVaMensal').text(data.ultimaProposta.novoVaMensal);
								$('#vlrNvSeguroSaudeMensal').text(data.ultimaProposta.novoSeguroSaudeMensal);
								$('#vlrNvValeAuto').text(data.ultimaProposta.novoValeAuto);
								$('#vlrNvValeEstacionamento').text(data.ultimaProposta.novoEstacionamento);
								$('#vlrNvValeTransporte').text(data.ultimaProposta.novoValeTransporte);
								$('#vlrNvLiquidoComBeneficios').text(data.ultimaProposta.novoLiquidoComBeneficios);
								$('#vlrNvAnualLiquido').text(data.ultimaProposta.novoAnualLiquido);
								$('#vlrNvParticipacaoLucrosOuBonus').text(data.ultimaProposta.novaParticipacaoLucrosOuBonus);
								$('#vlrNvTotalAnualLiquidoComBeneficios').text(data.ultimaProposta.novoTotalAnualLiquidoComBeneficios);
							}
						})
					}
				});

				function alterarStatus(id, status, nome) {
					nomeCandidato = nome;
					mensagemMudancaStatus = defineMudancaStatus(status);
					localStorage.setItem("nomeCandidato", nomeCandidato);
					localStorage.setItem("mensagemMudancaStatus", mensagemMudancaStatus);
					$('input.cancelar-id').val(id);
					$('input.cancelar-status').val(status);
				}
			})
			$('#alterarStatus').click(function() {
				var avaliacoes = [];

				$(".avaliacaoCompetencia").each(function() {
					if ($(this).prop("checked")) {
						var idAvaliacao = $(this).attr("alt");
						var idCompetencia = $(this).val();
						avaliacoes.push(idAvaliacao);
						avaliacoes.push(idCompetencia);
					}
				});

				var provasDescricoes = [];
				var x = 0;
				$(".processoSeletivo").each(function() {
					var provaDescricao = {
						"prova" : "",
						"descricao" : ""
					};

					var select = $(this).find("#prova-js").val();
					var input = $(this).find("#descricao-js").val();

					provasDescricoes.push(select);
					provasDescricoes.push(input);
					x++;
				});
				file();

				$.ajax({
					url : "alterar-status-candidato",
					method : "POST",
					dataType : "JSON",
					data : {
						'idCandidato' : $('#hdn-id-candidato').val(),
						'parecer' : $('#parecer').val(),
						'idStatus' : $('#hdn-status').val(),
						'parecerTecnico' : $('#parecerTecnico').val(),
						'processoSeletivo' : JSON.stringify(provasDescricoes),
						'avaliacoesCandidato' : JSON.stringify(avaliacoes)
					},
					success : function(data) {
						mensagemMudancaStatus = defineMudancaStatus(data.ultimoStatus.status.id);
						localStorage.setItem("mensagemMudancaStatus", mensagemMudancaStatus);
						localStorage.setItem("nomeCandidato", data.nome);
						
						location.reload();
					},
					error : function(e) {
						/* Mensagem de erro: */
						$('#confirm-modal').modal('hide');
						$('#modalTitulo').modal('hide');
						$('#modalProposta').modal('hide');
						
						msg = 'Ocorreu algo de errado!'
						$('#msg-sucesso').html(msg).addClass(
						'alert alert-danger').show();
						escondeMensagem();
					}
				});
			});

			function file() {
				var paperElement = document.getElementById("modalPapers");

				if ($(paperElement).val()) {
					var form = document.getElementById("formValidar");
					var formData = new FormData(form);
					var xhr = new XMLHttpRequest();
					xhr.open('POST', "submitFiles");
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							console.log("Files Uploaded")
						}
					};
					xhr.send(formData);
				}
			}

			function alterarStatus(idCandidato, idStatus, proposta) {
				$('#hdn-id-candidato').val(idCandidato);
				$('#hdn-proposta').val(proposta);
				$('#hdn-status').val(idStatus);
				$('#idCandidatoFile').val(idCandidato);
			}

			function cancelarClick(id, nome) {

				nomeCandidato = nome;

				$("#idCancelamento").val(id);

				$('#frmCancelar')[0].reset();
				maxCaracterParecerCancelamento();
			}

			/*gerador de campo*/
			var cont = 0;
			$("#gerarCampo").click(function() {
				var campos =
					"<div class='div"+cont+" processoSeletivo'>"
					+ "<div class='row'>"
					+ "<div class='col-md-6 form-inline'>"
					+ "<a id='btnRemover' onclick='remover("
					+ cont
					+ ")'class='text-danger fa fa-times fa-lg'></a>"
					+ "&nbsp;<select class='form-control' id='prova-js'>"
					+ "<option value='0'>Selecione</option>"
					+ "<c:forEach var='selecao' items='${provas}'>"
					+ "<option value='${selecao.id}'>${selecao.nome}</option>"
					+ "</c:forEach>"
					+ "</select>"
					+ "<input class='form-control descricaoProva' type='text'	id='descricao-js' name='descricao"
					+ cont
					+ "' placeholder='Descrição' maxlength='50'	onkeyup='maxDescricaoProva()' />"
					+ "</div>"
					+ "<div class='col-md-5 form-inline'>"
					+ "<input name='papers' id='modalPapers' type='file' class='input-sm' multiple data-input='false'>"
					+ "</div>"
					+ "&nbsp; &nbsp;<label id='maxDescricao'>Caracteres restantes : <span class='numeroCaracteres" + cont +"'>50</span></label>"
					+ "</div>" + "</div>";
					cont++;
					/*adiciona na div*/
				$("#processoSeletivo").append(campos);

				/*contador de caracter - descrição prova*/
			});
			/*remove os campos*/

			function maxDescricaoProva() {
				var cont = 0;
				$(".descricaoProva").each(function() {

					var descricao = $(this).val().length;
					var restante = 50 - descricao;
					$(".numeroCaracteres" + cont).text(restante);
					cont++;
				})
			}
			
			function remover(id) {
				$(".div" + id).remove();
				cont--;
			}

			// Submit do formulário
			$("button#btnEnviar").click(function() {
				$("form#formValidar").submit();
				if ($('form#formValidar').parsley('isValid')) {
					$('#confirm-modal').modal('show');
				}
			});

			$(document).ready(function() {
				$('form#formValidar').parsley();

				$('form#formValidar').on('submit', function(e) {
					e.preventDefault();
					$(this).parsley().validate();
				});
				
				/* Pegando valor das variáveis que foram armazenadas localmente:  */
				var nome = localStorage.getItem("nomeCandidato");
				var statusMudado = localStorage.getItem("mensagemMudancaStatus");
				
				/* Exibe a mensagem de mudança de status do candidato: */
				if(nome!=""){
					msg = 'O candidato <strong>' + nome
					+ '</strong> ' + statusMudado +  ' com sucesso!'
					$('#msg-sucesso').html(msg).addClass('alert alert-success').show();
					escondeMensagem();
				}
				
				/* Limpa as variáveis locais, para quando a página for atualizada/acessada novamente não exiba uma mensagem nula */
				localStorage.setItem("nomeCandidato", "");
				localStorage.setItem("mensagemMudancaStatus", "");
			});

			function gerarProposta() {
				var paperElement = document.getElementById("upload-proposta");

				if ($(paperElement).val()) {
					var form = document.getElementById("formValidar");
					var formData = new FormData(form);
					$.ajax({
						url : 'gerar-proposta',
						enctype : 'multipart/form-data',
						type : 'POST',
						data : formData,
						processData : false,
						contentType : false,
						cache : false,
						success : function(data) {

							$.ajax({
								url : "proposta",
								dataType : "JSON",
								type : "GET",
								success : function(data) {
									$("#anteriorEmpresa").text(data.anteriorEmpresa);
									$("#anteriorCargo").text(data.anteriorCargo);
									$("#vlrAntSalarioFixoBruto").text(data.anteriorSalarioFixoBruto);
									$("#vlrAntSalarioLiquidoMensal").text(data.anteriorSalarioLiquidoMensal);
									$("#vlrAntVrMensal").text(data.anteriorVrMensal);
									$("#vlrAntVaMensal").text(data.anteriorVaMensal);
									$("#vlrAntSeguroSaudeMensal").text(data.anteriorSeguroSaudeMensal);
									$("#vlrAntValeAuto").text(data.anteriorValeAuto);
									$("#vlrAntEstacionamento").text(data.anteriorEstacionamento);
									$("#vlrAntValeTransporte").text(data.anteriorValeTransporte);
									$("#vlrAntLiquidoComBeneficios").text(data.anteriorLiquidoComBeneficios);
									$("#vlrAntAnualLiquido").text(data.anteriorAnualLiquido);
									$("#vlrAntParticipacaoLucrosOuBonus").text(data.anteriorParticipacaoLucrosOuBonus);
									$("#vlrAntTotalAnualLiquidoComBeneficios").text(data.anteriorTotalAnualLiquidoComBeneficios);
								
									$("#novaEmpresa").text(data.novaEmpresa);
									$("#novoCargo").text(data.novoCargo)
									$("#vlrNvSalarioFixoBruto").text(data.novoSalarioFixoBruto);
									$("#vlrNvSalarioLiquidoMensal").text(data.novoSalarioLiquidoMensal);
									$("#vlrNvVrMensal").text(data.novoVrMensal);
									$("#vlrNvVaMensal").text(data.novoVaMensal);
									$("#vlrNvSeguroSaudeMensal").text(data.novoSeguroSaudeMensal);
									$("#vlrNvValeAuto").text(data.novoValeAuto);
									$("#vlrNvEstacionamento").text(data.novoEstacionamento);
									$("#vlrNvValeTransporte").text(data.novoValeTransporte);
									$("#vlrNvLiquidoComBeneficios").text(data.novoLiquidoComBeneficios);
									$("#vlrNvAnualLiquido").text(data.novoAnualLiquido);
									$("#vlrNvParticipacaoLucrosOuBonus").text(data.novaParticipacaoLucrosOuBonus);
									$("#vlrNvTotalAnualLiquidoComBeneficios").text(data.novoTotalAnualLiquidoComBeneficios);
									
									$('document').ready(function() {
									    $(".dinheiro").maskMoney();
									});
								},
								error : function(data) {
								}
							});
						},
					});
				}
			};

			function cancelarCandidato() {
				var id = $("#idCancelamento").val();
				$.ajax({
					url : "cancelar-candidato/" + id,
					type : "POST"
				}).done(
					function() {
						/* Fecha o modal de cancelamento: */
						$('#delete-modal').modal('hide');
						
						/* Mensagem: */
						msg = 'O candidato <strong>' + nomeCandidato
							+ '</strong> foi cancelado com sucesso!'
						$('#msg-sucesso').html(msg).addClass('alert alert-success').show();
						/* Remove a linha dele na tabela: */
						$('#js-trCandidato_' + id).remove();
								
						escondeMensagem();
							
					}).fail(function(jqXHR, textStatus) {
							
						/* Exibe mensagem no caso de falha de requisição: */
						msg = 'Falha ao cancelar o candidato <strong>' + nomeCandidato
							+ '</strong>!'
						$('#msg-sucesso').html(msg).addClass('alert alert-danger').show();
									
						escondeMensagem();
					});
				}

				function escondeMensagem(id) {
					window.setTimeout(function() {
						$("#msg-sucesso").hide();
						$(".mensagem").hide();
					}, 5000);
				}
			
				/* Função para alterar a mensagem conforme mudança de status: */
				function defineMudancaStatus(status) {
				
					var mensagem;
					switch(status) {
						case 6:
							mensagem = "enviado para análise";
							break;
						case 7:
						mensagem = "aprovado";
							break;
						case 8:
							mensagem = "reprovado";
							break;
						case 9:
							mensagem = "teve proposta gerada";
							break;
						case 10:
							mensagem = "teve proposta aprovada";
							break;
						case 11:
							mensagem = "teve proposta reprovada";
							break;
						case 15:
							mensagem = "foi contratado";
							break;
						default:
							mensagem = "sofreu alteração de status";
					}
					return mensagem;
				}
			
				/* paginação */