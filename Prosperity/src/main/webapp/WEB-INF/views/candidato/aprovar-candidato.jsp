
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Aprovação de candidatos</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>



<!--
<link rel="stylesheet" href="/resources/css/ckeditor_/ckeditor/samples/css/samples.css">
-->
<link rel="stylesheet"
	href="/resources/css/ckeditor_/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">

<!-- <script> -->
<!-- 	//Total máximo de campos que você permitirá criar em seu site: -->
<!-- 	var totalCampos = 3; -->

<!-- // 	Não altere os valores abaixo, pois são variáveis controle -->
<!-- 	var iLoop = 1; -->
<!-- 	var iCount = 0; -->
<!-- 	var linhaAtual; -->


<!-- 	function AddCampos() { -->
<!-- 	var hidden1 = document.getElementById("hidden1"); -->
<!-- 	var hidden2 = document.getElementById("hidden2"); -->

<!-- 	//Executar apenas se houver possibilidade de inserção de novos campos: -->
<!-- 	if (iCount < totalCampos) { -->

<!-- 	//Limpar hidden1, para atualizar a lista dos campos que ainda estão vazios: -->
<!-- 	hidden2.value = ""; -->

<!-- 	//Atualizando a lista dos campos que estão ocultos. -->
<!-- 	//Essa lista ficará armazenada temporiariamente em hidden2; -->
<!-- 	for (iLoop = 1; iLoop <= totalCampos; iLoop++) { -->
<!-- 	        if (document.getElementById("linha"+iLoop).style.display == "none") { -->
<!-- 	                if (hidden2.value == "") { -->
<!-- 	                        hidden2.value = "linha"+iLoop; -->
<!-- 	                }else{ -->
<!-- 	                        hidden2.value += ",linha"+iLoop; -->
<!-- 	                } -->
<!-- 	        } -->
<!-- 	} -->
<!-- 	//Quebrando a lista que foi armazenada em hidden2 em array: -->

<!-- 	linhasOcultas = hidden2.value.split(","); -->


<!-- 	        if (linhasOcultas.length > 0) { -->
<!-- 	                //Tornar visível o primeiro elemento de linhasOcultas: -->
<!-- 	                document.getElementById(linhasOcultas[0]).style.display = "block"; iCount++; -->

<!-- 	                //Acrescentando o índice zero a hidden1: -->
<!-- 	                if (hidden1.value == "") { -->
<!-- 	                        hidden1.value = linhasOcultas[0]; -->
<!-- 	                }else{ -->
<!-- 	                        hidden1.value += ","+linhasOcultas[0]; -->
<!-- 	                } -->

<!-- 	                /*Retirar a opção acima da lista de itens ocultos: <-------- OPCIONAL!!! -->
<!-- 	                if (hidden2.value.indexOf(","+linhasOcultas[0]) != -1) { -->
<!-- 	                        hidden2.value = hidden2.value.replace(linhasOcultas[0]+",",""); -->
<!-- 	                }else if (hidden2.indexOf(linhasOcultas[0]+",") == 0) { -->
<!-- 	                        hidden2.value = hidden2.value.replace(linhasOcultas[0]+",",""); -->
<!-- 	                }else{ -->
<!-- 	                        hidden2.value = ""; -->
<!-- 	                } -->
<!-- 	                */ -->
<!-- 	        } -->
<!-- 	} -->
<!-- 	} -->

<!-- 	function RemoverCampos(id) { -->
<!-- 	//Criando ponteiro para hidden1:         -->
<!-- 	var hidden1 = document.getElementById("hidden1"); -->

<!-- 	//Pegar o valor do campo que será excluído: -->
<!-- 	var campoValor = document.getElementById("arq"+id).value; -->
<!-- 	        //Se o campo não tiver nenhum valor, atribuir a string: vazio: -->
<!-- 	        if (campoValor == "") { -->
<!-- 	                campoValor = "vazio"; -->
<!-- 	        } -->

<!--                document.getElementById("linha"+id).style.display = "none"; iCount--; -->

<!--                //Removendo o valor de hidden1: -->
<!--                if (hidden1.value.indexOf(",linha"+id) != -1) { -->
<!--                        hidden1.value = hidden1.value.replace(",linha"+id,""); -->
<!--                }else if (hidden1.value.indexOf("linha"+id+",") == 0) { -->
<!--                        hidden1.value = hidden1.value.replace("linha"+id+",",""); -->
<!--                }else{ -->
<!--                        hidden1.value = ""; -->
<!--                } -->
<!-- 	} -->
<!--  </script> -->

</head>
<body id="main">

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!--    Modais   -->
	<!-- Modal Avaliação de Competencias -->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 style="text-align: center;">Gestão de candidato</h4>
				</div>
				<div class="modal-body">

					<div class="panel panel-default">
						<div class="panel-tab clearfix">
							<ul class="tab-bar">
								<li class="active"><a href="#infoEntrevista"
									data-toggle="tab"><i class="fa fa-user"></i> Informações de
										entrevista</a></li>
								<li><a href="#processoSelecao" data-toggle="tab"><i
										class="fa fa-pencil"></i> Processo de seleção</a></li>
								<li><a href="#avaliacaoComp" data-toggle="tab"><i
										class="fa fa-briefcase"></i> Avaliação de competências</a></li>
								<li><a href="#proposta" data-toggle="tab"><i
										class="fa fa-money"></i> Proposta</a></li>
							</ul>
						</div>

						<div class="panel-body">
							<div class="tab-content">

								<div class="tab-pane fade in active" id="infoEntrevista">
									<div class="form-group">
										<label class="control-label">Parecer :</label>
										<div class="form-group">
											<input type="hidden" id="hdn-id-candidato" /> <input
												type="hidden" id="hdn-status" />
											<textarea class="form-control" id="parecer"
												style="margin-left: 0px; width: 770px" name="parecer">
											</textarea>
										</div>
									</div>
								</div>

								<div class="tab-pane fade" id="processoSelecao">
									<div class="form-group">
										<div class="panel panel-default">
											<div class="panel-body">

												<label>Etapas dos processos de seleção: </label>
												<!-- campo chumbado -->
												<div class="form-group col-md-6">
													<label for="nmEtapa">Tipo da prova</label> <select
														class="form-control" id="nome1" name="nome1">
														<option value="0">Selecione:</option>
														<option value="1">Prova teórica</option>
														<option value="2">Prova prática</option>
														<option value="3">Dinâmica de grupo</option>
													</select>
												</div>

												<div class="form-group col-md-6">
													<label for="instituicao">Descrição</label> <input
														type="text" class="form-control" id="descricao1"
														name="descricao1" data-required="true" placeholder="">
												</div>

												<div class="form-group col-md-6">

													<select class="form-control" id="nome2" name="nome2">
														<option value="0">Selecione:</option>
														<option value="1">Prova teórica</option>
														<option value="2">Prova prática</option>
														<option value="3">Dinâmica de grupo</option>
													</select>
												</div>

												<div class="form-group col-md-6">

													<input type="text" class="form-control" id="descricao2"
														name="descricao2" data-required="true" placeholder="">
												</div>

												<div class="form-group col-md-6">

													<select class="form-control" id="nome3" name="nome3">
														<option value="0">Selecione:</option>
														<option value="1">Prova teórica</option>
														<option value="2">Prova prática</option>
														<option value="3">Dinâmica de grupo</option>
													</select>
												</div>

												<div class="form-group col-md-6">

													<input type="text" class="form-control" id="descricao3"
														name="descricao3" data-required="true" placeholder="">
												</div>

												
											</div>
										</div>
										<div class="form-group">
											<input type="hidden" id="hdn-id-candidato" /> <input
												type="hidden" id="hdn-status" /> <label
												class="control-label">Parecer técnico:</label>
											<textarea class="form-control" id="parecerTecnico"
												style="margin-left: 0px; width: 800px" name="parecerTecnico">
										</textarea>
										</div>

									</div>

								</div>

								<div class="tab-pane fade" id="avaliacaoComp">
									<section class="panel panel-default">
										<div class="panel-heading text-center">
											<label for="exampleInputEmail1">Avaliação de
												competências</label>
										</div>

										<table id="tabelaCompetencias" class="table"
											style="font-size: 10px">
											<thead class="text-center">
												<tr class="text-center">
													<th class="text-center">Competências</th>
													<c:forEach var="avaliacao" items="${avaliacoes}">
														<th>${avaliacao.nome}</th>
													</c:forEach>
												</tr>
											</thead>
											<tbody class="text-center">
												<c:forEach var="competencia" items="${competencias}">
													<tr class="linhaAvaliacao">
														<td>${competencia.nome}</td>
														<c:forEach var="avaliacao" items="${avaliacoes}">
															<td><label class="label-radio inline"> <input
																	class="avaliacaoCompetencia" type="radio"
																	alt="${avaliacao.id}"
																	name="avaliacao${competencia.nome}"
																	value="${competencia.id}"> <span
																	class="custom-radio"></span>
															</label></td>
														</c:forEach>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</section>
								</div>

								<div class="tab-pane fade" id="proposta">
									<div class="form-group col-md-12" id="divCkEditor">
										<div class="form-group">
											<label class="control-label">Proposta:</label>
											<div class="adjoined-bottom">
												<div class="grid-container">
													<div class="grid-width-100">
														<textarea id="editor" name="editor">
															
														</textarea>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						<div class="panel-footer ">
							<button type="button" class="btn btn-sm btn-primary"
								href="#confirm-modal" data-toggle="modal">
								<i class="fa fa-check fa-lg"></i>&nbsp;Enviar
							</button>
						</div>
					</div>

				</div>
			</div>
		</div>
		</div>

		<!-- Modal confirmacao-->
		<div class="modal fade" id="confirm-modal"
			data-target="#confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Confirmação</h4>
					</div>
					<div class="modal-body">Deseja realmente fazer isso?</div>
					<div class="modal-footer">
						<a id="excluir" href="#">
							<button type="button" class="btn btn-success" id="alterarStatus">Sim</button>
						</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal delete-->
		<!-- Modal delete -->
		<div class="modal fade" id="delete-modal" data-target="#delete-modal"
			tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Cancelar vaga</h4>
					</div>
					<div class="modal-body">Deseja realmente fechar esta vaga?</div>
					<div class="modal-footer">
						<a id="excluir" href="#">
							<button type="button" class="btn btn-danger">Sim</button>
						</a>
						<button type="button" class="btn btn-success" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal delete-->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="index.html"> Home</a></li>
					<li>Consultar</li>
					<li class="active">Aprovação de candidatos</li>
				</ul>
			</div>
			<!--breadcrumb-->
			<div class="container">
				<div class="padding-md">
					<div class="row">
						<div>
							<div class="panel panel-default">
								<div class="panel-heading">Aprovação de candidatos</div>
								<div class="panel-body">
									<input type="hidden" name="user" id="user"
										value="${autenticado.perfil.nome}" />

									<table
										class="table table-bordered table-condensed table-hover table-striped"
										id="tabelaCandidato"
										style="font-size: 12px !important; vertical-align: middle !important;">
										<thead>
											<tr>
												<th class="text-center">Nome do candidato</th>
												<th class="text-center">Vaga</th>
												<th class="text-center">Pretensão</th>
												<th class="text-center">Data de abertura</th>
												<th class="text-center">Data de aprovação</th>
												<th class="text-center">Status</th>
												<th class="text-center">Ações</th>
											</tr>
										</thead>
										<tbody class="text-center">
											<form id="form">
												<c:forEach var="candidato" items="${candidatos}">
													<tr>
														<td>${candidato.nome}</td>
														<td>${candidato.ultimaVaga.nomeVaga }</td>
														<td>${candidato.valorPretensao}</td>
														<td><fmt:formatDate value="${candidato.dataAbertura}"
																pattern="dd/MM/yyyy" /></td>
														<td><fmt:formatDate
																value="${candidato.dataFechamento}" pattern="dd/MM/yyyy" /></td>
														<td><span class="label"
															style="color: #fff; background-color: ${candidato.ultimoStatus.status.css}">${candidato.ultimoStatus.status.nome}</span></td>

														<td><input type="hidden" name="idStatus"
															id="idStatus" value="${candidato.ultimoStatus.status.id}" />
															<div class="btn-group">
																<div class="btn-group">
																	<button class="btn btn-sm btn-info dropdown-toggle"
																		data-toggle="dropdown" aria-haspopup="true"
																		aria-expanded="false">
																		<i class="fa fa-cogs fa-lg">&nbsp;</i> <span
																			class="caret"></span>
																	</button>
																	<ul class="dropdown-menu dropdown-menu-right slidedown">
																		<c:forEach var="statusDisponivel"
																			items="${candidato.ultimoStatus.status.statusDisponiveis}">
																			<li><a data-toggle="modal"
																				data-target=".bs-example-modal-lg"
																				id="aprovar-candidato"
																				onclick="alterarStatus(${candidato.id}, ${statusDisponivel.id})"><i
																					${statusDisponivel.classe}>&nbsp;</i>${statusDisponivel.nome}
																			</a></li>
																			<li class="divider "></li>
																		</c:forEach>
																		<li><c:url value="editar/${candidato.id}"
																				var="myURL">
																			</c:url> <a href="${myURL}"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>

																		<li class="divider"></li>

																		<li><a href="#delete-modal" data-toggle="modal"><i
																				class="fa fa-trash-o fa-lg">&nbsp;</i>Cancelar</a></li>
																		<!-- /fim botao -->

																	</ul>
																</div>
																</div>
																<!-- /btn-group --></td>
													</tr>
												</c:forEach>
											</form>
										</tbody>
									</table>

								</div>
								<!-- /.row -->
							</div>
							<!-- /.panel-body -->

						</div>
						<!-- fim da div panel -->

					</div>
					<!-- /col-md-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.paddin.md -->
		</div>
		<!-- /.container -->
		<a href="" id="scroll-to-top" class="hidden-print"><i
			class="fa fa-chevron-up"></i></a>
		<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
		<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>

		<!-- import da merda da proposta -->

		<script src="https://cdn.ckeditor.com/4.6.2/standard/ckeditor.js"></script>
		<script>
            $(document).ready(function() {
                  perfil = $('#user').val();
                  status = $('#idStatus').val();
                  if(status == 9 || status == 10 ){
                        if(perfil.nome == "RH" || perfil.nome == "Administrador" ||
                              perfil.nome == "CEO" || perfil.nome == "Diretor de Operação")
						var div = document.getElementById("divCkEditor").className = "show";
                  }
                  else
                	  var div = document.getElementById("divCkEditor").className = "hidden";
            })
      </script>
		<script>
            $(document).ready(function() {        	
            	proposta = $('#propostas').val();
            	CKEDITOR.instances.editor.setData(proposta);
            })
      </script>
		<script>
            CKEDITOR.replace('editor');
                  $('#alterarStatus').click(function() {
                        
                        var data = CKEDITOR.instances.editor.getData();                    
                        
	                   	 var avaliacoes = [];
	                   	 
	                   	$(".avaliacaoCompetencia").each(function(){
                            if($(this).prop("checked")){
                                
                                 var avaliacaoCompetencia = {
                                        competencia : {
                                            id : ""
                                        },
                                        avaliacao : {
                                            id : ""
                                        }
                                     };
                                 
                                var idAvaliacao = $(this).attr("alt");
                                var idCompetencia = $(this).val();
                                
                                avaliacaoCompetencia.avaliacao.id = idAvaliacao;
                                avaliacaoCompetencia.competencia.id = idCompetencia;
                                
                                console.log(avaliacaoCompetencia);
                                avaliacoes.push(avaliacaoCompetencia);
                            }
                        });
	            		
                        $.ajax({
                              url : "alterar-status-candidato",
                              type : "POST",
                              dataType : "JSON",
                              data : {
                                   'idCandidato' : $('#hdn-id-candidato').val(),
                                   'parecer' : $('#parecer').val(),
                                   'proposta' : CKEDITOR.instances.editor.getData(),
                                   'idStatus' : $('#hdn-status').val(),
                                   'avaliacoesCompetencias' : JSON.stringify(avaliacoes),
                                   'nome1' : $("#nome1").val(),
                                   'nome2' : $("#nome2").val(),
                                   'nome3' : $("#nome3").val(),
                                   'descricao1' : $("#descricao1").val(),
                                   'descricao2' : $("#descricao2").val(),
                                   'descricao3' : $("#descricao3").val(),
                                   'parecerTecnico' : $("#parecerTecnico").val()
                              },
                              success : function(data) {
                                   location.reload();
                              },
                              error : function(e) {
                                   location.reload();
                              }
                        });
                        
                  });

            function alterarStatus(idCandidato, idStatus, proposta, processoSelecao) {
                  $('#hdn-id-candidato').val(idCandidato);
                  $('#hdn-proposta').val(proposta);
                  $('#hdn-status').val(idStatus);
            
            }
            
            function cancelarCandidato(id) {
            	$.ajax({
        			url : "cancelar-candidato/"+id,
        			type : "POST"
        		}).done(function() {
        			alert('done');
        		}).fail(function(jqXHR, textStatus) {
        			alert('fail');
        		});
            }
            
            </script>
		<script>/* paginação */
	$(function	()	{
		$('#tabelaCandidato').dataTable( {
			"bJQueryUI": true,
			"sPaginationType": "simple_numbers",
			"bFilter": false,
			"bInfo": false,
			"bLengthChange": false,

			"oLanguage": {
				"sEmptyTable": "Nenhum registro encontrado",
				"sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
				"sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
				"sInfoFiltered": "(Filtrados de _MAX_ registros)",
				"sInfoPostFix": "",
				"sInfoThousands": ".",
				"sLengthMenu": "_MENU_ resultados por página",
				"sLoadingRecords": "Carregando...",
				"sProcessing": "Processando...",
				"sZeroRecords": "Nenhum registro encontrado",
				"sSearch": "Pesquisar",
				"oPaginate": {
					"sNext": "Próximo",
					"sPrevious": "Anterior",
					"sFirst": "Primeiro",
					"sLast": "Último"
				},
				"oAria": {
					"sSortAscending": ": Ordenar colunas de forma ascendente",
					"sSortDescending": ": Ordenar colunas de forma descendente"
				}
			}
		/* $(function	()	{
			$('#tabelaVaga').dataTable( {
				"bJQueryUI": true,
				"sPaginationType": "full_numbers"
			});
			$('#tabelaVaga_length').hide();
			$('#tabelaVaga_filter').hide();
			$('#tabelaVaga_info').hide();
			$('#tabelaVaga_last').css('margin-left:2000px');
			$('#tabelaVaga_next').css('margin-left:200px');
			$('#tabelaVaga_paginate').css('margin-left: 500px');
			$("#tabelaVaga_next").text("Próximo");
			$("#tabelaVaga_last").text("Último");
			$("#tabelaVaga_previous").text("Anterior");
			$("#tabelaVaga_first").text("Primeiro");
			
			$("#tabelaVaga_next").attr("href", "#");
			$("#tabelaVaga_last").attr("href", "#");
			$("#tabelaVaga_previous").attr("href", "#");
			$("#tabelaVaga_first").attr("href", "#");
			$(".fg-button").attr("href", "#"); */
 		
		});
	});
	</script>
</body>
</html>