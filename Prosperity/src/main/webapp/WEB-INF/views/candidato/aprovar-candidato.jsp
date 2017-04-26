<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="contents">
		<link rel="stylesheet"
			href="/resources/css/ckeditor_/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
		<!--    Modais   -->
		<!-- Modal Avaliação de Competencias -->
		<div id="modalProposta" class="modal fade"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 style="text-align: center;" class="modal-title" id="myModalLabel">Gestão de candidato</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-tab clearfix">
								<ul class="tab-bar" id="tabs">
									<li id="entrevista-tab" class="active"><a href="#infoEntrevista"
										data-toggle="tab"><i class="fa fa-user"></i> Informações
											de entrevista</a></li>
									<li id="processo-tab"><a href="#processoSelecao"
										data-toggle="tab"><i class="fa fa-pencil"></i> Processo de
											seleção</a></li>
									<li id="avaliacao-tab"><a href="#avaliacaoComp"
										data-toggle="tab"><i class="fa fa-briefcase"></i>
											Avaliação de competências</a></li>
									<li id="proposta-tab"><a href="#proposta"
										data-toggle="tab"><i class="fa fa-money"></i> Proposta</a></li>
								</ul>
							</div>
							<div class="panel-body">
							<form id="formValidar" data-validate="parsley" novalidate>
								<div class="tab-content">
									<div class="tab-pane fade in active" id="infoEntrevista">
										<div class="form-group">
										
											<label class="control-label">Parecer :</label>
											<div class="form-group">
												<input type="hidden" id="hdn-id-candidato" /> <input
													type="hidden" id="hdn-status" />
												<textarea class="form-control parsley-validated" id="parecer"
													style="margin-left: 0px; width: 800px" name="parecer"  data-required="true"></textarea>
											</div>
										</div>
									</div>
									<div class="tab-pane fade" id="processoSelecao">
										<div class="form-group">
											<div class="panel panel-default">
												<div class="panel-body">
													<div class="form-group col-md-12" id="processoSeletivo">
														<label>Etapas dos processos de seleção: </label> <input
															type="button" id="gerarCampo"
															value="Gerar etapa do processo seletivo"
															class="btn btn-sm btn-primary"> <br> <br>
													</div>
												</div>
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
															<textarea id="editor" name="editor"></textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								</form>
							</div>
							<div class="panel-footer">
								<button type="button" class="btn btn-sm btn-primary"
									 id="btnEnviar">
									<i class="fa fa-check fa-lg"></i>&nbsp;Enviar
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="confirm-modal" tabindex="-1" role="dialog"
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
					<div class="modal-body"><p>Deseja confirmar a operação?</p></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" id="alterarStatus">Sim</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
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
						<h4 class="modal-title" id="modalLabel">Cancelar candidato</h4>
					</div>
					<div class="modal-body">Deseja realmente cancelar este
						candidato?</div>
					<div class="modal-footer">
						<input type="hidden" id="idCancelamento" value="" />
						<button type="button" class="btn btn-danger"
							onclick="cancelarCandidato()">Sim</button>
						<button type="button" class="btn btn-success" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal delete-->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial"> Página inicial</a></li>
					<li>Consultar</li>
					<li class="active">Aprovação de candidatos</li>
				</ul>
			</div>
			<!--breadcrumb-->
			<div class="padding-md">
				<div class="row">
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
										<th class="text-center">Status</th>
										<th class="text-center">Ações</th>
									</tr>
								</thead>
								<tbody class="text-center">
									<form id="form">
										<c:forEach var="candidato" items="${candidatos}">
											<tr>
												<input type="hidden" id="${candidato.id}"/>
												<td>${candidato.nome}</td>
												<td>${candidato.ultimaVaga.nomeVaga}</td>
												<td><fmt:formatNumber
														value="${candidato.valorPretensao}" minFractionDigits="2"
														type="currency" /></td>
												<td><fmt:formatDate value="${candidato.dataAbertura}"
														pattern="dd/MM/yyyy" /></td>
												<td><span class="label"
													style="color: #fff; background-color: ${candidato.ultimoStatus.status.css}">${candidato.ultimoStatus.status.nome}</span></td>
												<td><input type="hidden" name="idStatus" id="idStatus"
													value="${candidato.ultimoStatus.status.id}" />
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
																<li><a class="clickable"
																	id="aprovar-candidato" 
																	onclick="alterarStatus(${candidato.id}, ${statusDisponivel.id})">
																		<i ${statusDisponivel.classe}>&nbsp;</i>${statusDisponivel.nome}</a></li>
																<li class="divider"></li>
															</c:forEach>
															<li><c:url
																	value="cancelar-candidato/${candidato.id}"
																	var="urlCancelar">
																</c:url><a href="#delete-modal"
																onclick="cancelarClick(${candidato.id})"
																data-toggle="modal"><i class="fa fa-trash-o fa-lg">&nbsp;</i>Cancelar</a></li>
															<!-- /fim botao -->
														</ul>
												</div> <!-- /btn-group --></td>
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
				<!-- /col-md-12 -->
			</div>
			<!-- /.row -->
			<!-- /.paddin.md -->
		</div>
	</layout:put>
	<layout:put block="scripts" type="REPLACE">

		<script src="/resources/js/parsley.min.js"></script>
		<script src="https://cdn.ckeditor.com/4.6.2/standard/ckeditor.js"></script>
		<script>
	var cont;
	
		$("body").on("click", "#aprovar-candidato", function(){
			var inputs  = $(this).closest("tr").find("input[type=hidden]");
			CKEDITOR.instances.editor.setData("");
			CKEDITOR.instances.editor.insertHtml("");
			
			inputs.each(function(index, value){
				if(!isNaN($(value).attr("id"))){
					var id = $(value).attr("id");
					
					$.ajax({
						url:"buscar/"+id,
						dataType:"json",
						method:"GET",
						success:function(data){	
							var perfil = $('#user').val();
							if(data.ultimoStatus.status.id == "9"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
									CKEDITOR.instances.editor.insertHtml(data.ultimoStatus.proposta);
									document.getElementById("proposta-tab").style.visibility = "visible";
									document.getElementById("proposta").style.visibility = "visible";
				                 }
							}else if(data.ultimoStatus.status.id == "10"){
				                 if(perfil == "Administrador" || perfil == "CEO" || perfil == "Diretor de operação"){
										CKEDITOR.instances.editor.insertHtml(data.ultimoStatus.proposta);
										$("#proposta-tab").show();
					                	CKEDITOR.instances['editor'].setReadOnly(true);
					                 }
							}else{
								$("#proposta-tab").hide();
							}
							if(data.ultimoStatus.status.id == "6"){
								$("#avaliacao-tab").show();
								$("#avaliacaoComp").show();
								document.getElementById("avaliacaoComp").style.visibility = "visible";
								$("#processo-tab").show();
								$("#processoSelecao").show();
							}else{
								$("#avaliacao-tab").hide();
								$("#avaliacaoComp").hide();
								document.getElementById("avaliacaoComp").style.visibility = "hidden";
								$("#processo-tab").hide();
								$("#processoSelecao").hide();
							}
							$('.tab-bar a[href="#infoEntrevista"]').tab('show')
							$('#modalProposta').modal('show');
						}
					})
				}
				});

			function alterarStatus(id,status){
				$('input.cancelar-id').val(id);
				$('input.cancelar-status').val(status);
			}
				
			})
            CKEDITOR.replace('editor');
                  $('#alterarStatus').click(function() {
                        var data = CKEDITOR.instances.editor.getData();                    
	                   	var avaliacoes = [];

	                   	$(".avaliacaoCompetencia").each(function(){
                            if($(this).prop("checked")){
                                var idAvaliacao = $(this).attr("alt");
                                var idCompetencia = $(this).val();
								avaliacoes.push(idAvaliacao);
								avaliacoes.push(idCompetencia);
                            }
                        });

	                   	var provasDescricoes  = [];
	                	var x = 0;
	                   	$(".processoSeletivo").each(function(){
		                   	var provaDescricao = {
		                   			"prova" : "",
		                   			"descricao" : ""
		                   	};
		                   	
	                   	    var select = $(this).find("#prova"+x).val();
	                   	    var input = $(this).find("#descricao"+x).val();

	                   		provasDescricoes.push(select);
	                   		provasDescricoes.push(input);
	                   		x++;
	                   	});                  	
                        $.ajax({
                              url : "alterar-status-candidato",
                              method : "POST",
                              dataType : "JSON",
                              data : {
                                   'idCandidato' : $('#hdn-id-candidato').val(),
                                   'parecer' : $('#parecer').val(),
                                   'proposta' : CKEDITOR.instances.editor.getData(),
                                   'idStatus' : $('#hdn-status').val(),
                                   'parecerTecnico' : $('#parecerTecnico').val(),
                                   'processoSelectivo' : JSON.stringify(provasDescricoes),
                                   'ac' : JSON.stringify(avaliacoes)
                              },
                              success : function(data) {
                            	  location.reload();
                              },
                              error : function(e) {
                                   location.reload();
                              }
                        });
                  });

            function alterarStatus(idCandidato, idStatus, proposta) {
                  $('#hdn-id-candidato').val(idCandidato);
                  $('#hdn-proposta').val(proposta);
                  $('#hdn-status').val(idStatus);
            }
            
            function cancelarCandidato() {
            	var id = $("#idCancelamento").val();
            	
            	$.ajax({
        			url : "cancelar-candidato/"+id,
        			type : "POST"
        		}).done(function() {
        			 location.reload();
        		}).fail(function(jqXHR, textStatus) {
        			alert('fail');
        			 location.reload();
        		});
            }

           function cancelarClick (id){
        	   $("#idCancelamento").val(id);
           } 

        /*gerador de campo*/    
            var cont = 0;
            $("#gerarCampo").click(function(){
            	var campos = 
            	"<div class='div"+cont+" processoSeletivo'>" +
            	"<select id='prova"+ cont +"'>" +
            	"<br>" +
            	"<option value='0'>Selecione:</option>"+
            	"<c:forEach var='selecao' items='${provas}'>" +
            	"<option value='${selecao.id}'>${selecao.nome}</option>"+
            	"</c:forEach>" +
            	"</select>"+
            	"<input type='text' id='descricao"+ cont +"'/>"+
            	"<input type='button' id='btnRemover' onclick='remover("+ cont +")'value='Remover campo' class='btn btn-sm btn-danger'>"+
            	"</div>" ;
            	cont++;
        /*adiciona na div*/
            	$("#processoSeletivo").append(campos);
            });
       /*remove os campos*/
            function remover(id){
            	$(".div"+id).remove();
            	cont--;
            }
       
         // Submit do formulário
        	$("button#btnEnviar").click(function() {
        		$("form#formValidar").submit();
        		if($('form#formValidar').parsley('isValid')){
					$('#confirm-modal').modal('show');
			   }
        	});
         
        	$(document).ready(function () {
                $('form#formValidar').parsley();

                $('form#formValidar').on('submit', function (e) {
                    e.preventDefault();
                    $(this).parsley().validate();
                });
            });
         
/* paginação */
	$(function	()	{
		$('#tabelaCandidato').dataTable( {
			"bJQueryUI": true,
			"sPaginationType": "simple_numbers",
			"bFilter": false,
			"bInfo": false,
			"bLengthChange": false,
			"bSort": false,

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
		});
	});
	</script>
	</layout:put>
</layout:extends>
