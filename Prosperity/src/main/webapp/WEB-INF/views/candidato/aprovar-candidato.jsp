<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>

<layout:extends name="base">
	<layout:put block="contents">
		<link rel="stylesheet"
			href="/resources/css/ckeditor_/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
		<!--    Modais   -->
		<!-- Modal Avaliação de Competencias -->
		<div id="modalProposta" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>

						<h4 style="text-align: center;" class="modal-title"
							id="modalTitulo">placeholder</h4>

					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-tab clearfix">
								<ul class="tab-bar" id="tabs">
									<li id="entrevista-tab" class="active"><a
										href="#infoEntrevista" data-toggle="tab"><i
											class="fa fa-user"></i> Informações de entrevista</a></li>
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

												<label class="control-label">Observação :</label>
												<div class="form-group">
													<input type="hidden" id="hdn-id-candidato" /> <input
														type="hidden" id="hdn-status" />
													<textarea class="form-control parsley-validated"
														id="parecer" style="margin-left: 0px; width: 800px"
														name="parecer" data-required="true" maxlength="500"
														rows="5" onkeyup="maxCaracterParecer()"></textarea>
													<label id="maxParecer">Caracteres restantes : 500</label>
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
							<div class="panel-footer clearfix">
								<button type="button" class="btn btn-sm btn-primary pull-right"
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
					<div class="modal-body">
						<p>Deseja confirmar a operação?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success"
							onclick="cancelarCandidato()" id="alterarStatus">Sim</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal delete -->
		<div class="modal fade" id="delete-modal" data-target="#delete-modal"
			tabindex="-1" role="dialog" aria-labelledby="modalLabel" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Cancelar candidato</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<form id="frmCancelar">
								<div class="row">
									<div class="form-group col-sm-12">
										<label for="cancelamento">Motivo do cancelamento:</label> <select
											class="form-control" id="cancelamento"
											name="candidato.cancelamento.id">
											<option value="0">Selecione</option>
											<c:forEach var="cancelamento" items="${cancelamento}">
												<option value="${cancelamento.id}"
													${cancelamento.id == candidato.cancelamento.id ? 'selected="selected"' : ''}>${cancelamento.descricao}</option>
											</c:forEach>
	
										</select>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-sm-12">
										<label for="">Observação :</label> <input type="hidden"
											id="hdn-id-candidato" /> <input type="hidden" id="hdn-status" />
										<textarea class="form-control parsley-validated"
											id="parecerCancelamento" name="parecer" data-required="true"
											maxlength="300" rows="3"
											onkeyup="maxCaracterParecerCancelamento()"></textarea>
										<label id="maxParecerCanc">Caracteres restantes : 300</label>
	
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<input type="hidden" id="idCancelamento" value="" />
						<button type="button" class="btn btn-success"
							onclick="cancelarCandidato()">Confirmar</button>
							<button button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal delete-->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial">
							Página inicial</a></li>
					<li>Consultar</li>
					<li class="active">Aprovação de candidatos</li>
				</ul>
			</div>
			<!--breadcrumb-->
			<div class="padding-md">
				<div class="row">
					<div class="panel panel-default">

						<!-- MENSAGEM DE SUCESSO -->
						<c:if test="${not empty sucesso}">
							<div id="msg-sucesso" class="alert alert-success msg-margin">
								<ul style="list-style: none;">
									<li class="li-msg">${sucesso}</li>
								</ul>
							</div>
						</c:if>

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
												<input type="hidden" id="${candidato.id}" />
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
																<li><a class="clickable" id="aprovar-candidato"
																	onclick="alterarStatus(${candidato.id}, ${statusDisponivel.idStatusDisponivel})">
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
								<c:if test="${empty candidatos}">
									<tfoot>
										<tr>
											<td colspan="6">Nenhum registro</td>
										</tr>
									</tfoot>
								</c:if>
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
		
		
	/*contador de caracter - parecer*/
	
	function maxCaracterParecer(){
		var maxParecer = $("#parecer").val();
		var restante = 500 - maxParecer.length;
		var maxCaracteres = document.querySelector("#maxParecer");
		maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
		}
	function maxCaracterParecerCancelamento(){
		var maxParecer = $("#parecerCancelamento").val();
		var restante = 300 - maxParecer.length;
		var maxCaracteres = document.querySelector("#maxParecerCanc");
		maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
	}
	
		$("body").on("click", "#aprovar-candidato", function(){
			var inputs  = $(this).closest("tr").find("input[type=hidden]");
			CKEDITOR.instances.editor.setData("");
			CKEDITOR.instances.editor.insertHtml("");
			var tituloModal = $(this).text();
			
			inputs.each(function(index, value){
				if(!isNaN($(value).attr("id"))){
					var id = $(value).attr("id");
					CKEDITOR.instances['editor'].setReadOnly(false);
					
					$.ajax({
						url:"buscar/"+id,
						dataType:"json",
						method:"GET",
						success:function(data){	
							var perfil = $('#user').val();
							$("#modalTitulo").text(tituloModal);
							if(data.ultimoStatus.status.id == "9"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
									CKEDITOR.instances.editor.insertHtml(data.ultimoStatus.proposta);
									$("#proposta-tab").show();
				                 }
							}else if(data.ultimoStatus.status.id == "10"){
				                 if(perfil == "Administrador" || perfil == "CEO" || perfil == "Diretor de operação"){
										CKEDITOR.instances.editor.insertHtml(data.ultimoStatus.proposta);
					                	$("#proposta-tab").show();
					                	CKEDITOR.instances['editor'].setReadOnly(true);
					                 }
							}else if(data.ultimoStatus.status.id == "11"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
										CKEDITOR.instances.editor.insertHtml(data.ultimoStatus.proposta);
					                	$("#proposta-tab").show();
					                	CKEDITOR.instances['editor'].setReadOnly(true);
					                 }
							}else if(data.ultimoStatus.status.id == "13"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
										CKEDITOR.instances.editor.insertHtml(data.ultimoStatus.proposta);
					                	$("#proposta-tab").show();
					                 }
							}else if(data.ultimoStatus.status.id == "14"){
				                 if(perfil == "Analista de RH" || perfil == "Gestor RH"){
										CKEDITOR.instances.editor.insertHtml(data.ultimoStatus.proposta);
					                	$("#proposta-tab").show();
					                 }
							}else{
			                	$("#proposta-tab").hide();
							}
							if(data.ultimoStatus.status.id == "6"){
								$("#avaliacao-tab").show();
								$("#processo-tab").show();
							}else{
								$("#avaliacao-tab").hide();
								$("#processo-tab").hide();
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
        			 location.reload();
        		});
            }

           function cancelarClick (id){
        	   $("#idCancelamento").val(id);
        	   $('#frmCancelar')[0].reset();
        	   maxCaracterParecerCancelamento();
           } 

        /*gerador de campo*/    
            var cont = 0;
            $("#gerarCampo").click(function(){
            	
            	var campos = 
            	"<div class='div"+cont+" col-md-12 processoSeletivo'>" +
            	"<select class='form-control col-md-3' style='width: 120px; height: 30px;' id='prova"+ cont +"'>" +
            	"<br>" +
            	"&nbsp;"+
            	"<br/>" +
            	"<option value='0'>Selecione:</option>"+
            	"<br/>" +
            	"<c:forEach var='selecao' items='${provas}'>" +
            	"<br/>" +
            	"<option value='${selecao.id}'>${selecao.nome}</option>"+
            	"<br/>" +
            	"</c:forEach>" +
            	"<br/>" +
            	"</select>"+
            	"&nbsp;"+
            	"<input class='form-control col-md-3 descricaoProva' style='width: 190px; height: 30px;' type='text' id='descricao"+ cont +"' name='descricao"+ cont +"' maxlength='50'  onkeyup='maxDescricaoProva()' />"+
            	"&nbsp; <input type='button' id='btnRemover' onclick='remover("+ cont +")'value='Remover campo' class='btn btn-sm btn-danger'>"+
            	"&nbsp; &nbsp;<label id='maxDescricao'>Caracteres restantes : <span class='numeroCaracteres" + cont +"'>50</span></label>"+
            	"<br>" + 	
            	"</div>" ;
            	cont++;
        /*adiciona na div*/
            	$("#processoSeletivo").append(campos);
        
            	
            	/*contador de caracter - descrição prova*/	
            });
       /*remove os campos*/
       
                function maxDescricaoProva(){
    	   			var cont = 0;
    	   			$(".descricaoProva").each(function(){
    	   				
                		var descricao = $(this).val().length;
                		var restante = 50 - descricao;
                		$(".numeroCaracteres"+cont).text(restante);
    	   				cont++;
    	   			})

            	}
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
	</script>
	</layout:put>
</layout:extends>
