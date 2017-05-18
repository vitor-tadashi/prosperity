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
							var perfil = $('#idPerfil').val();
							$("#modalTitulo").text(tituloModal);
								if (data.ultimoStatus.status.id == "9") {
									if (perfil == 2 || perfil == 3) {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "10") {
									if (perfil == 1 || perfil == 4 || perfil == 9) {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "11") {
									if (perfil == 2 || perfil == 3) {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "13") {
									if (perfil == 2 || perfil == 3) {
										$("#proposta-tab").show();
									}
								} else if (data.ultimoStatus.status.id == "14") {
									if (perfil == 2 || perfil == 3) {
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
								if(data.ultimaProposta != null){	
									//carregando as informações do EXCEL via AJAX para a JSP
									$('#anteriorCargo').text(data.ultimaProposta.anteriorCargo);
									$('#anteriorEmpresa').text(data.ultimaProposta.anteriorEmpresa);
									$('#vlrAntSalarioFixoBruto').text(parseFloat(data.ultimaProposta.anteriorSalarioFixoBruto).toFixed(2));
									$('#vlrAntSalarioLiquidoMensal').text(parseFloat(data.ultimaProposta.anteriorSalarioLiquidoMensal).toFixed(2));
									$('#vlrAntVrMensal').text(parseFloat(data.ultimaProposta.anteriorVrMensal).toFixed(2));
									$('#vlrAntVaMensal').text(parseFloat(data.ultimaProposta.anteriorVaMensal).toFixed(2));
									$('#vlrAntSeguroSaudeMensal').text(parseFloat(data.ultimaProposta.anteriorSeguroSaudeMensal).toFixed(2));
									$('#vlrAntValeAuto').text(parseFloat(data.ultimaProposta.anteriorValeAuto).toFixed(2));
									$('#vlrAntValeEstacionamento').text(parseFloat(data.ultimaProposta.anteriorEstacionamento).toFixed(2));
									$('#vlrAntValeTransporte').text(parseFloat(data.ultimaProposta.anteriorValeTransporte).toFixed(2));
									$('#vlrAntLiquidoComBeneficios').text(parseFloat(data.ultimaProposta.anteriorLiquidoComBeneficios).toFixed(2));
									$('#vlrAntAnualLiquido').text(parseFloat(data.ultimaProposta.anteriorAnualLiquido).toFixed(2));
									$('#vlrAntParticipacaoLucrosOuBonus').text(parseFloat(data.ultimaProposta.anteriorParticipacaoLucrosOuBonus).toFixed(2));
									$('#vlrAntTotalAnualLiquidoComBeneficios').text(parseFloat(data.ultimaProposta.anteriorTotalAnualLiquidoComBeneficios).toFixed(2));
									
									$('#novaEmpresa').text(data.ultimaProposta.novaEmpresa);
									$('#novoCargo').text(data.ultimaProposta.novoCargo);
									$('#vlrNvSalarioFixoBruto').text(parseFloat(data.ultimaProposta.novoSalarioFixoBruto).toFixed(2));
									$('#vlrNvSalarioLiquidoMensal').text(parseFloat(data.ultimaProposta.novoSalarioLiquidoMensal).toFixed(2));
									$('#vlrNvVrMensal').text(parseFloat(data.ultimaProposta.novoVrMensal).toFixed(2));
									$('#vlrNvVaMensal').text(parseFloat(data.ultimaProposta.novoVaMensal).toFixed(2));
									$('#vlrNvSeguroSaudeMensal').text(parseFloat(data.ultimaProposta.novoSeguroSaudeMensal).toFixed(2));
									$('#vlrNvValeAuto').text(parseFloat(data.ultimaProposta.novoValeAuto).toFixed(2));
									$('#vlrNvValeEstacionamento').text(parseFloat(data.ultimaProposta.novoEstacionamento).toFixed(2));
									$('#vlrNvValeTransporte').text(parseFloat(data.ultimaProposta.novoValeTransporte).toFixed(2));
									$('#vlrNvLiquidoComBeneficios').text(parseFloat(data.ultimaProposta.novoLiquidoComBeneficios).toFixed(2));
									$('#vlrNvAnualLiquido').text(parseFloat(data.ultimaProposta.novoAnualLiquido).toFixed(2));
									$('#vlrNvParticipacaoLucrosOuBonus').text(parseFloat(data.ultimaProposta.novaParticipacaoLucrosOuBonus).toFixed(2));
									$('#vlrNvTotalAnualLiquidoComBeneficios').text(parseFloat(data.ultimaProposta.novoTotalAnualLiquidoComBeneficios).toFixed(2));
								
									var comparativo = data.ultimaProposta.comparativoProposta;

									// for each que percorre a lista e mostra na tela
									var aux = 0;
									if(data.ultimaProposta.comparativoProposta != null){
										$(comparativo).each(function(index, value) {
											var campos = "<tr><td id='nmFuncionario"+aux+"'></td>" +
											"<td id='nmCargo"+aux+"'></td>" +
											"<td id='nmSenioridade"+aux+"'></td>" +
											"<td id='dsConhecimento"+aux+"'></td>" +
											"<td id='dtAdmissao"+aux+"'></td>" +
											"<td><p>R$ </p><p id='vlrSalario"+aux+"'></p></td>" +
											"<td><p>R$ </p><p id='vlrVr"+aux+"'></p></td>" +
											"<td><p>R$ </p><p id='vlrVa"+aux+"'></p></td>" +
											"<td><p>R$ </p><p id='vlrEstacionamento"+aux+"'></p></td>" +
											"<td><p>R$ </p><p id='vlrCombustivel"+aux+"'></p></td>" +
											"<td><p>R$ </p><p id='vlrAssistenciaMedica"+aux+"'></p></td>" +
											"<td><p>R$ </p><p id='vlrOutros"+aux+"'></p></td>" +
											"<td><p>R$ </p><p id='vlrTaxa"+aux+"'></p></td> </tr>";
											
											$(".tbComparativo").append(campos);
											
											alert(data.ultimaProposta.comparativoProposta[index].dtAdmissao);
	
											$('#nmFuncionario'+aux).text(data.ultimaProposta.comparativoProposta[index].nmFuncionario);
											$('#nmCargo'+aux).text(data.ultimaProposta.comparativoProposta[index].nmCargo);
											$('#nmSenioridade'+aux).text(data.ultimaProposta.comparativoProposta[index].nmSenioridade);
											$('#dsConhecimento'+aux).text(data.ultimaProposta.comparativoProposta[index].dsConhecimento);
											$('#dtAdmissao'+aux).text(data.ultimaProposta.comparativoProposta[index].dtAdmissao);
											$('#vlrSalario'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrSalario).toFixed(2));
											$('#vlrVr'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrVr).toFixed(2));
											$('#vlrVa'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrVa).toFixed(2));
											$('#vlrEstacionamento'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrEstacionamento).toFixed(2));
											$('#vlrCombustivel'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrCombustivel).toFixed(2));
											$('#vlrAssistenciaMedica'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrAssistenciaMedica).toFixed(2));
											$('#vlrOutros'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrOutros).toFixed(2));
											$('#vlrTaxa'+aux).text(parseFloat(data.ultimaProposta.comparativoProposta[index].vlrTaxa).toFixed(2));
											
											aux++;
										});
									}
									$(document).ready(function() {
										$('.dinheiro').mask('0.000.000,00', {reverse : true});
									});
								}
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
									$('#vlrAntSalarioFixoBruto').text(parseFloat(data.anteriorSalarioFixoBruto).toFixed(2));
									$("#vlrAntSalarioLiquidoMensal").text(parseFloat(data.anteriorSalarioLiquidoMensal).toFixed(2));
									$("#vlrAntVrMensal").text(parseFloat(data.anteriorVrMensal).toFixed(2));
									$("#vlrAntVaMensal").text(parseFloat(data.anteriorVaMensal).toFixed(2));
									$("#vlrAntSeguroSaudeMensal").text(parseFloat(data.anteriorSeguroSaudeMensal).toFixed(2));
									$("#vlrAntValeAuto").text(parseFloat(data.anteriorValeAuto).toFixed(2));
									$("#vlrAntValeEstacionamento").text(parseFloat(data.anteriorEstacionamento).toFixed(2));
									$("#vlrAntValeTransporte").text(parseFloat(data.anteriorValeTransporte).toFixed(2));
									$("#vlrAntLiquidoComBeneficios").text(parseFloat(data.anteriorLiquidoComBeneficios).toFixed(2));
									$("#vlrAntAnualLiquido").text(parseFloat(data.anteriorAnualLiquido).toFixed(2));
									$("#vlrAntParticipacaoLucrosOuBonus").text(parseFloat(data.anteriorParticipacaoLucrosOuBonus).toFixed(2));
									$("#vlrAntTotalAnualLiquidoComBeneficios").text(parseFloat(data.anteriorTotalAnualLiquidoComBeneficios).toFixed(2));
								
									$("#novaEmpresa").text(data.novaEmpresa);
									$("#novoCargo").text(data.novoCargo)
									$("#vlrNvSalarioFixoBruto").text(parseFloat(data.novoSalarioFixoBruto).toFixed(2));
									$("#vlrNvSalarioLiquidoMensal").text(parseFloat(data.novoSalarioLiquidoMensal).toFixed(2));
									$("#vlrNvVrMensal").text(parseFloat(data.novoVrMensal).toFixed(2));
									$("#vlrNvVaMensal").text(parseFloat(data.novoVaMensal).toFixed(2));
									$("#vlrNvSeguroSaudeMensal").text(parseFloat(data.novoSeguroSaudeMensal).toFixed(2));
									$("#vlrNvValeAuto").text(parseFloat(data.novoValeAuto).toFixed(2));
									$("#vlrNvValeEstacionamento").text(parseFloat(data.novoEstacionamento).toFixed(2));
									$("#vlrNvValeTransporte").text(parseFloat(data.novoValeTransporte).toFixed(2));
									$("#vlrNvLiquidoComBeneficios").text(parseFloat(data.novoLiquidoComBeneficios).toFixed(2));
									$("#vlrNvAnualLiquido").text(parseFloat(data.novoAnualLiquido).toFixed(2));
									$("#vlrNvParticipacaoLucrosOuBonus").text(parseFloat(data.novaParticipacaoLucrosOuBonus).toFixed(2));
									$("#vlrNvTotalAnualLiquidoComBeneficios").text(parseFloat(data.novoTotalAnualLiquidoComBeneficios).toFixed(2));
									
									var comparativo = data.comparativoProposta;

									// for each que percorre a lista e mostra na tela
									var aux = 0;
									$(comparativo).each(function(index, value) {
										var campos = "<tr><td id='nmFuncionario"+aux+"'></td>" +
										"<td id='nmCargo"+aux+"'></td>" +
										"<td id='nmSenioridade"+aux+"'></td>" +
										"<td id='dsConhecimento"+aux+"'></td>" +
										"<td id='dtAdmissao"+aux+"'></td>" +
										"<td><p>R$ </p><p id='vlrSalario"+aux+"'></p></td>" +
										"<td><p>R$ </p><p id='vlrVr"+aux+"'></p></td>" +
										"<td><p>R$ </p><p id='vlrVa"+aux+"'></p></td>" +
										"<td><p>R$ </p><p id='vlrEstacionamento"+aux+"'></p></td>" +
										"<td><p>R$ </p><p id='vlrCombustivel"+aux+"'></p></td>" +
										"<td><p>R$ </p><p id='vlrAssistenciaMedica"+aux+"'></p></td>" +
										"<td><p>R$ </p><p id='vlrOutros"+aux+"'></p></td>" +
										"<td><p>R$ </p><p id='vlrTaxa"+aux+"'></p></td> </tr>";
										
										$(".tbComparativo").append(campos);
										
										$('#nmFuncionario'+aux).text(data.comparativoProposta[index].nmFuncionario);
										$('#nmCargo'+aux).text(data.comparativoProposta[index].nmCargo);
										$('#nmSenioridade'+aux).text(data.comparativoProposta[index].nmSenioridade);
										$('#dsConhecimento'+aux).text(data.comparativoProposta[index].dsConhecimento);
										$('#dtAdmissao'+aux).text(data.comparativoProposta[index].dtAdmissao);
										$('#vlrSalario'+aux).text(parseFloat(data.comparativoProposta[index].vlrSalario).toFixed(2));
										$('#vlrVr'+aux).text(parseFloat(data.comparativoProposta[index].vlrVr).toFixed(2));
										$('#vlrVa'+aux).text(parseFloat(data.comparativoProposta[index].vlrVa).toFixed(2));
										$('#vlrEstacionamento'+aux).text(parseFloat(data.comparativoProposta[index].vlrEstacionamento).toFixed(2));
										$('#vlrCombustivel'+aux).text(parseFloat(data.comparativoProposta[index].vlrCombustivel).toFixed(2));
										$('#vlrAssistenciaMedica'+aux).text(parseFloat(data.comparativoProposta[index].vlrAssistenciaMedica).toFixed(2));
										$('#vlrOutros'+aux).text(parseFloat(data.comparativoProposta[index].vlrOutros).toFixed(2));
										$('#vlrTaxa'+aux).text(parseFloat(data.comparativoProposta[index].vlrTaxa).toFixed(2));
										
										aux++;
									});
									
									$(document).ready(function() {
										$('.dinheiro').mask('0.000.000,00', {reverse : true});
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