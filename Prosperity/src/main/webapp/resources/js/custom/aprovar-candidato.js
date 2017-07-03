/* Variáveis globais para auxílio das mensagens */
			var nomeCandidato = "";
			var mensagemMudancaStatus = "";

/* Função violenta para limpar o modal no click */
			$('#modalProposta').on('hidden.bs.modal', function (e) {
				  $(this).find("textarea,select").val('').end();
				  $(".processoSeletivo").remove();
				  limparProposta();
				  
			})

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
				$(".tiraTabela").remove();
				inputs.each(function(index, value) {
					if (!isNaN($(value).attr("id"))) {
						var id = $(value).attr("id");
						$.ajax({url : "buscar/"+ id, dataType : "json", method : "GET", success : function(data) {
							var perfil = $('#idPerfil').val();
							$("#nmCandProp").text(data.nome);
							$("#modalTitulo").text(tituloModal);
							$("#idVaga").val(data.ultimaVaga.id);
							$('#parecer').removeClass("parsley-error")
							$('.parsley-error-list').attr("style", "display: none;");
								if (data.ultimoStatus.status.id == "9") {
									if (perfil == 2 || perfil == 3) {
										$("#proposta-tab").show();
										$("#importxlsx").show();
									}
									$('.dinheiro').text("");
								} else if (data.ultimoStatus.status.id == "10") {
									if (perfil == 1 || perfil == 4 || perfil == 9) {
										$("#proposta-tab").show();
										$("#importxlsx").hide();
									}
								} else if (data.ultimoStatus.status.id == "11") {
									if (perfil == 2 || perfil == 3) {
										$("#proposta-tab").show();
										$("#importxlsx").hide();
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
									$(".tiraTabela").remove();
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
									$('#dsAntOutros1').text(data.ultimaProposta.antDsOutros1);
									$('#vlrAntOutros1').text(parseFloat(data.ultimaProposta.antVlrOutros1).toFixed(2));
									if(data.ultimaProposta.antDsOutros1 != null){
										$('.divAntOutros1').removeClass("hide");
									}
									$('#dsAntOutros2').text(data.ultimaProposta.antDsOutros2);
									$('#vlrAntOutros2').text(parseFloat(data.ultimaProposta.antVlrOutros2).toFixed(2));
									if(data.ultimaProposta.antDsOutros2 != null){
										$('.divAntOutros2').removeClass("hide");
									}
									$('#dsAntOutros3').text(data.ultimaProposta.antDsOutros3);
									$('#vlrAntOutros3').text(parseFloat(data.ultimaProposta.antVlrOutros3).toFixed(2));
									if(data.ultimaProposta.antDsOutros3 != null){
										$('.divAntOutros3').removeClass("hide");
									}
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
									$('#dsNvOutros1').text(data.ultimaProposta.nvDsOutros1);
									$('#vlrNvOutros1').text(parseFloat(data.ultimaProposta.nvVlrOutros1).toFixed(2));
									if(data.ultimaProposta.nvDsOutros1 != null){
										$('.divNvOutros1').removeClass("hide");
									}
									$('#dsNvOutros2').text(data.ultimaProposta.nvDsOutros2);
									$('#vlrNvOutros2').text(parseFloat(data.ultimaProposta.nvVlrOutros2).toFixed(2));
									if(data.ultimaProposta.nvDsOutros2 != null){
										$('.divNvOutros2').removeClass("hide");
									}
									$('#dsNvOutros3').text(data.ultimaProposta.nvDsOutros3);
									$('#vlrNvOutros3').text(parseFloat(data.ultimaProposta.nvVlrOutros3).toFixed(2));
									if(data.ultimaProposta.nvDsOutros3 != null){
										$('.divNvOutros3').removeClass("hide");
									}
									$('#vlrNvLiquidoComBeneficios').text(parseFloat(data.ultimaProposta.novoLiquidoComBeneficios).toFixed(2));
									$('#vlrNvAnualLiquido').text(parseFloat(data.ultimaProposta.novoAnualLiquido).toFixed(2));
									$('#vlrNvParticipacaoLucrosOuBonus').text(parseFloat(data.ultimaProposta.novaParticipacaoLucrosOuBonus).toFixed(2));
									$('#vlrNvTotalAnualLiquidoComBeneficios').text(parseFloat(data.ultimaProposta.novoTotalAnualLiquidoComBeneficios).toFixed(2));

									var comparativo = data.ultimaProposta.comparativoProposta;

									// for each que percorre a lista e mostra na tela
									var aux = 0;
									if(data.ultimaProposta.comparativoProposta != null){
										$(comparativo).each(function(index, value) {
											var campos = "<tr>"+
											"<td class='tiraTabela' id='nmFuncionario"+aux+"'></td>" +
											"<td class='tiraTabela' id='nmCargo"+aux+"'></td>" +
											"<td class='tiraTabela' id='nmSenioridade"+aux+"'></td>" +
											"<td class='tiraTabela' id='dsConhecimento"+aux+"'></td>" +
											"<td class='tiraTabela' id='dtAdmissao"+aux+"'></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrSalario"+aux+"' class='dinheiro'></p></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrVr"+aux+"' class='dinheiro'></p></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrVa"+aux+"' class='dinheiro'></p></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrEstacionamento"+aux+"' class='dinheiro'></p></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrCombustivel"+aux+"' class='dinheiro'></p></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrAssistenciaMedica"+aux+"' class='dinheiro'></p></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrOutros"+aux+"' class='dinheiro'></p></td>" +
											"<td class='tiraTabela'><p>R$ </p><p id='vlrTaxa"+aux+"' class='dinheiro'></p></td> </tr>";

											$(".tbComparativo").append(campos);


											$('#nmFuncionario'+aux).text(data.ultimaProposta.comparativoProposta[index].nmFuncionario);
											$('#nmCargo'+aux).text(data.ultimaProposta.comparativoProposta[index].nmCargo);
											$('#nmSenioridade'+aux).text(data.ultimaProposta.comparativoProposta[index].nmSenioridade);
											$('#dsConhecimento'+aux).text(data.ultimaProposta.comparativoProposta[index].dsConhecimento);

											var date = moment(data.ultimaProposta.comparativoProposta[index].dtAdmissao);
											$('#dtAdmissao'+aux).text(date.format("DD/MM/YYYY"));
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
								if (data.ultimoStatus.status.id == "9") {
									$('.dinheiro').text("");
									$('.nmLimpar').text("");
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
						'idVaga' : $('#idVaga').val(),
						'idStatus' : $('#hdn-status').val(),
						'processoSeletivo' : JSON.stringify(provasDescricoes),
						'avaliacoesCandidato' : JSON.stringify(avaliacoes)
					},
					success : function(data) {
						//mensagemMudancaStatus = defineMudancaStatus(data.ultimoStatus.status.id);
						//localStorage.setItem("mensagemMudancaStatus", mensagemMudancaStatus);
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
				var paperElement = document.getElementsByClassName("modalPapers");

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
				mensagemMudancaStatus = defineMudancaStatus(parseInt(idStatus));
				localStorage.setItem("mensagemMudancaStatus", mensagemMudancaStatus);
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
			}
			function valida(){
				var erro = true;
				$(".erro-prova").each(function(i,item) {
					var paperElement = document.getElementsByClassName("modalPapers");
					if($(this).find("#prova-js").val() == 0 || !$(this).find(".modalPapers").val()){
						$(item).addClass('alert alert-danger')
						erro = false;
					}else{
						$(item).removeClass('alert alert-danger')
						
					}
				})
				return erro;
			}

			// Submit do formulário
			$("button#btnEnviar").click(function() {
				$("form#formValidar").submit();
				
				if ($('form#formValidar').parsley('isValid') && valida()) {
					$('#confirm-modal').modal('show');
				}
			});

			$(document).ready(function() {
				$('form#formValidar').parsley();

				$('form#formValidar').on('submit', function(e) {
					valida();
					e.preventDefault();
					$(this).parsley().validate();
				});

				/* Pegando valor das variáveis que foram armazenadas localmente:  */
				var nome = localStorage.getItem("nomeCandidato");
				var statusMudado = localStorage.getItem("mensagemMudancaStatus");

				/* Exibe a mensagem de mudança de status do candidato: */
				if(nome!="" && nome != undefined){
					msg = 'O candidato <strong>' + nome
					+ '</strong> ' + statusMudado
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
						data : formData, 'idCandidato' : $('#hdn-id-candidato').val(),
						processData : false,
						contentType : false,
						cache : false,
						success : function(data) {

							$.ajax({
								url : "proposta",
								dataType : "JSON",
								type : "GET",
								success : function(data) {
									$(".tiraTabela").remove();
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
									$('#dsAntOutros1').text(data.antDsOutros1);
									$('#vlrAntOutros1').text(parseFloat(data.antVlrOutros1).toFixed(2));
									if(data.antDsOutros1 != null){
										$('.divAntOutros1').removeClass("hide");
									}
									$('#dsAntOutros2').text(data.antDsOutros2);
									$('#vlrAntOutros2').text(parseFloat(data.antVlrOutros2).toFixed(2));
									if(data.antDsOutros2 != null){
										$('.divAntOutros2').removeClass("hide");
									}
									$('#dsAntOutros3').text(data.antDsOutros3);
									$('#vlrAntOutros3').text(parseFloat(data.antVlrOutros3).toFixed(2));
									if(data.antDsOutros3 != null){
										$('.divAntOutros3').removeClass("hide");
									}
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
									$('#dsNvOutros1').text(data.nvDsOutros1);
									$('#vlrNvOutros1').text(parseFloat(data.nvVlrOutros1).toFixed(2));
									if(data.nvDsOutros1 != null){
										$('.divNvOutros1').removeClass("hide");
									}
									$('#dsNvOutros2').text(data.nvDsOutros2);
									$('#vlrNvOutros2').text(parseFloat(data.nvVlrOutros2).toFixed(2));
									if(data.nvDsOutros2 != null){
										$('.divNvOutros2').removeClass("hide");
									}
									$('#dsNvOutros3').text(data.nvDsOutros3);
									$('#vlrNvOutros3').text(parseFloat(data.nvVlrOutros3).toFixed(2));
									if(data.nvDsOutros3 != null){
										$('.divNvOutros3').removeClass("hide");
									}
									$("#vlrNvLiquidoComBeneficios").text(parseFloat(data.novoLiquidoComBeneficios).toFixed(2));
									$("#vlrNvAnualLiquido").text(parseFloat(data.novoAnualLiquido).toFixed(2));
									$("#vlrNvParticipacaoLucrosOuBonus").text(parseFloat(data.novaParticipacaoLucrosOuBonus).toFixed(2));
									$("#vlrNvTotalAnualLiquidoComBeneficios").text(parseFloat(data.novoTotalAnualLiquidoComBeneficios).toFixed(2));

									var comparativo = data.comparativoProposta;

									// for each que percorre a lista e mostra na tela
									var aux = 0;
									$(comparativo).each(function(index, value) {
										var campos = "<tr><td class='tiraTabela' id='nmFuncionario"+aux+"'></td>" +
										"<td class='tiraTabela' id='nmCargo"+aux+"'></td>" +
										"<td class='tiraTabela' id='nmSenioridade"+aux+"'></td>" +
										"<td class='tiraTabela' id='dsConhecimento"+aux+"'></td>" +
										"<td class='tiraTabela' id='dtAdmissao"+aux+"'></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrSalario"+aux+"' class='dinheiro'></p></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrVr"+aux+"' class='dinheiro'></p></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrVa"+aux+"' class='dinheiro'></p></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrEstacionamento"+aux+"' class='dinheiro'></p></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrCombustivel"+aux+"' class='dinheiro'></p></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrAssistenciaMedica"+aux+"' class='dinheiro'></p></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrOutros"+aux+"' class='dinheiro'></p></td>" +
										"<td class='tiraTabela'><p>R$ </p><p id='vlrTaxa"+aux+"' class='dinheiro'></p></td> </tr>";

										$(".tbComparativo").append(campos);

										$('#nmFuncionario'+aux).text(data.comparativoProposta[index].nmFuncionario);
										$('#nmCargo'+aux).text(data.comparativoProposta[index].nmCargo);
										$('#nmSenioridade'+aux).text(data.comparativoProposta[index].nmSenioridade);
										$('#dsConhecimento'+aux).text(data.comparativoProposta[index].dsConhecimento);

										var date2 = moment(data.comparativoProposta[index].dtAdmissao);
										$('#dtAdmissao'+aux).text(date2.format("DD/MM/YYYY"));
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
					data : {'dsCancelamento' : $('#parecerCancelamento').val(),
							'idCancelamento':$('#cancelamento').val()},
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
							mensagem = " foi enviado para análise";
							break;
						case 7:
							mensagem = "foi aprovado";
							break;
						case 8:
							mensagem = "foi reprovado";
							break;
						case 10:
							mensagem = "teve a proposta gerada";
							break;
						case 13:
							mensagem = "teve a proposta reprovada";
							break;
						case 11:
							mensagem = "teve a proposta aprovada";
							break;
						case 14:
							mensagem = "recusou a proposta"
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

				//exibir ou esconder comparativo proposta
				function mudarEstado(el) {
			        var display = document.getElementById(el).style.display;
			        if(display == "none")
			            document.getElementById(el).style.display = 'block';
			        else
			            document.getElementById(el).style.display = 'none';
			    }
				
				function limparProposta(){
					$(".tiraTabela").remove();
					$('#anteriorCargo').text('');
					$('#anteriorEmpresa').text('');
					$('#vlrAntSalarioFixoBruto').text('');
					$('#vlrAntSalarioLiquidoMensal').text('');
					$('#vlrAntVrMensal').text('');
					$('#vlrAntVaMensal').text('');
					$('#vlrAntSeguroSaudeMensal').text('');
					$('#vlrAntValeAuto').text('');
					$('#vlrAntValeEstacionamento').text('');
					$('#vlrAntValeTransporte').text('');
					$('#dsAntOutros1').text('');
					$('#vlrAntOutros1').text('');
					$('#dsAntOutros2').text('');
					$('#vlrAntOutros2')
					$('#dsAntOutros3').text('');
					$('#vlrAntOutros3').text('');
					$('#vlrAntLiquidoComBeneficios').text('');
					$('#vlrAntAnualLiquido').text('');
					$('#vlrAntParticipacaoLucrosOuBonus').text('');
					$('#vlrAntTotalAnualLiquidoComBeneficios').text('');
					$('#novaEmpresa').text('');
					$('#novoCargo').text('');
					$('#vlrNvSalarioFixoBruto').text('');
					$('#vlrNvSalarioLiquidoMensal').text('');
					$('#vlrNvVrMensal').text('');
					$('#vlrNvVaMensal').text('');
					$('#vlrNvSeguroSaudeMensal').text('');
					$('#vlrNvValeAuto').text('');
					$('#vlrNvValeEstacionamento').text('');
					$('#vlrNvValeTransporte').text('');
					$('#dsNvOutros1').text('');
					$('#vlrNvOutros1').text('');
					$('#dsNvOutros2').text('');
					$('#vlrNvOutros2').text('');
					$('#dsNvOutros3').text('');
					$('#vlrNvOutros3').text('');
					$('#vlrNvLiquidoComBeneficios').text('');
					$('#vlrNvAnualLiquido').text('');
					$('#vlrNvParticipacaoLucrosOuBonus').text('');
					$('#vlrNvTotalAnualLiquidoComBeneficios').text('');
					$('.upload-file').parent().find('span').attr('data-title','');
					$('.upload-file').parent().find('label').attr('data-title','Selecione');
					$('.upload-file').parent().find('label').removeClass('selected');
				}
