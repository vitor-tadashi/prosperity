<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Consultar vaga</title>
		<link rel="stylesheet" href="/resources/css/custom/consultar-vaga.css">
	</layout:put>

	<layout:put block="contents">
		<div class="modal fade" id="vaga-modal" data-target="#vaga-modal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div id="PrintThis">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="titulo">Desenvolvedor .Net Pleno</h4>
						</div>
						<div class="modal-body">
							<div class="panel-tab clearfix"></div>
							<div class="tab-content">
								<div id="menu1" class="tab-pane fade in active">
									<section class="panel panel-default">
										<div class="panel-heading">
											<i class="fa fa-tags"></i> Especificações
										</div>
										<div class="panel-body">
											<form>
												<div class="form-group row">
													<div>
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="solicitante">Solicitante</label> <input
																class="form-control input-sm" disabled
																name="solicitante.id" id="solicitante"
																data-required="true" name="solicitante">
														</div>
														<!-- /form-group -->
														'
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputEmail1">Local de
																trabalho:</label>
															<div class="radiogroup" id="local">
																<label id="lblLocal" class="label-radio inline">
																</label>
															</div>
															<!-- /.col -->
														</div>
													</div>
												</div>

												<div class="form-group row">
													<div>
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="cargo">Cargo</label> <input
																class="form-control input-sm" disabled name="cargo.id"
																id="cargo" data-required="true" name="cargo">
														</div>


														<!-- /form-group -->

														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputEmail1">Tipo de vaga:</label>
															<div class="radiogroup" id="tipo">
																<label id="tpVaga" class="label-radio inline"> </label>
															</div>
															<!-- /.col -->
														</div>
													</div>
												</div>

												<div class="form-group row">
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">
														<label for="senioridade">Senioridade da vaga</label> <input
															class="form-control input-sm" disabled
															name="senioridade.id" id="senioridade"
															data-required="true" name="senioridade">
													</div>
													<!-- /form-group -->

													<div class="form-group" style="margin-bottom: 0px">
														<label class="control-label" style="padding-left: 15px;">Horário:</label>

														<div>
															<div class="form-group col-md-2 col-xs-2">
																<div class="input-group bootstrap-timepicker">
																	<label id="horaEntrada" style="margin-top: 7px"></label>
																</div>
															</div>

															<div class="form-group col-md-1 col-xs-1">
																<label style="margin-top: 7px">às</label>
															</div>

															<div class="form-group col-md-2 col-xs-1">
																<div class="input-group bootstrap-timepicker">
																	<label id="horaSaida" style="margin-top: 7px"></label>
																</div>
															</div>
														</div>

													</div>
												</div>

												<div class="form-group row">

													<div class="">
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputPassword1">Faixa salarial</label>
															<input class="form-control input-sm" id="pretensao"
																placeholder="Faixa Salarial" disabled
																name="valorPretensao">
														</div>
														<!-- /form-group -->

														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputEmail1">Aumento de
																quadro:</label>
															<div class="radiogroup" id="aumento">
																<label id="lblQuadro" class="label-radio inline">
																</label>

															</div>
															<!-- /.col -->
														</div>
													</div>
												</div>

												<div class="form-group row">

													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">

														<div class="form-group">
															<label class="control-label">Data para inicio</label>
															<div class="form-group">
																<div class="input-group">
																	<input type="text" value=""
																		class="datepicker form-control" name="dataInicio"
																		id="dataInicio" disabled> <span
																		class="input-group-addon"> <i
																		class="fa fa-calendar"></i></span>
																</div>
															</div>
															<!-- /.col -->
														</div>
														<!-- /form-group -->
													</div>
													
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">
														<div id="" class="">
															<label id="substituidoId">Nome do substituido:</label>
														</div>
														<label id="substituido" style="margin-top: 7px"></label>
													</div>

												</div>
												<div class="form-group row">
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: -30px">
															<label>Avaliadores da vaga</label>
															<table class="table table-condensed table-bordered" style="width: 7px;">
																<tbody id="tBodyAvaliador">
																	<tr id="trAvaliadores"></tr>
																</tbody>
															</table>
													</div>
												</div>
												</form>
										</div>
									</section>
									
									<div id="quebra">
										<section class="panel panel-default infos"
											style="margin-bottom: 5px;">
											<div class="panel-heading">Informações de projeto</div>
											<div class="panel-body">
											
												<div class="form-group row" id="divLocalTrabalho">
													<div class="form-group col-md-12"
													style="margin-bottom: 5px;">
													<label class="control-label">Projeto</label> <input
														readonly class="form-control default-cursor"
														id="vagaProjeto" value="Mobile">
												</div>
												<div class="form-group col-md-6 col-xs-6"
													style="margin-bottom: 5px;">
													<label class="control-label">Cliente</label> <input
														readonly class="form-control" id="vagaCliente"
														value="Carrefour">
												</div>
												<div class="form-group col-md-6 col-xs-6"
													style="margin-bottom: 5px;">
													<label class="control-label">Gestor imediato</label> <input
														readonly class="form-control" id="vagaGestor"
														value="Vitor Tadashi">
												</div>
													<div class="form-group col-md-6 col-xs-6">
														<label for="nmResponsavel">Nome do responsável</label> <input
															class="form-control input-sm" disabled
															id="nmResponsavel" />
													</div>
													<div class="form-group col-md-6 col-xs-6">
														<label for="nmResponsavel">Área do responsável</label> <input
															class="form-control input-sm" disabled
															id="nmAreaResponsavel" />
													</div>
													<div class="form-group col-md-6 col-xs-6">
														<label for="nmResponsavel">Email do responsável</label> <input
															class="form-control input-sm" disabled
															id="emailResponsavel" />
													</div>
													<div class="form-group col-md-6 col-xs-6">
														<label for="nmResponsavel">Telefone do responsável</label> <input
															class="form-control input-sm" disabled
															id="telResponsavel" />
													</div>
												</div>
												
											</div>
										</section>
									<!-- /Section -->
									
									<section class="panel panel-default"
											style="margin-bottom: 0px;">
											<div style="page-break-before: always;"></div>
											<div class="panel-heading"><strong>Formação acadêmica</strong></div>
											<div class="panel-body relative">
													<p class="text-justify">
														<span id="formacaoAcademica"></span>
													</p>
												<!-- /form-group -->
											</div>
										</section>
									
									<!-- /panel -->
											<section class="panel panel-default"
											style="margin-bottom: 0px;">
											<div class="panel-heading"><strong>Perfil comportamental</strong></div>
											<div class="panel-body relative">
													<p class="text-justify">
														<span id="perfilComportamental"></span>
													</p>
												<!-- /form-group -->
											</div>
										</section>
									<!-- /panel -->

									<section class="panel panel-default">
										<div class="panel-heading"><strong>Perfil técnico</strong></div>
										<div class="panel-body relative">

												<p class="text-justify">
													<span id="perfilTecnico"></span>
												</p>
										</div>
									</section>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /panel -->
					<!-- /tab-content -->
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="Print"
							onclick="imprimir()">Imprimir</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal visualizar -->

		<!-- Modal fechar -->
		<div class="modal fade" id="fecha-modal" data-target="#fecha-modal"
			tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Fechar vaga</h4>
					</div>
					<div class="modal-body">Deseja realmente fechar está vaga?</div>
					<input class="reprovar-id" type="hidden"> <input
						class="reprovar-status" type="hidden">
					<div class="modal-footer">
						<a href="#">
							<button id="fechaVaga" onclick="status()" type="button"
								class="btn btn-primary" data-dismiss="modal">Sim</button>
						</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal fechar-->


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
					<div class="modal-body">Deseja realmente cancelar está vaga?</div>
					<input class="cancela-id" type="hidden"> <input
						class="cancela-status" type="hidden">
					<div class="modal-footer">
						<a href="#">
							<button id="excluiVaga" onclick="status()" type="button"
								class="btn btn-primary" data-dismiss="modal">Sim</button>
						</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal delete-->

		<!--corpo -->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial">
							Página inicial</a></li>
					<li>Vaga</li>
					<li class="active">Consultar</li>
				</ul>
			</div>
			<!--breadcrumb-->
			<div class="padding-md clearfix">
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading">Consulta de vagas</div>
							<!--<form class="form-inline">-->
							<div class="panel-body">

								<form action="filtro" method="GET" class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Vaga</label> <input class="form-control" id="filtro1"
												name="nomeVaga" placeholder="Digite o nome de uma vaga"
												value="${filtroVaga.nomeVaga }">
										</div>
									</div>

									<div class="col-md-5">
										<label for="">Data de abertura</label>
										<div class="input-group">
											<fmt:formatDate value="${filtroVaga.dataAberturaDe}"
												pattern="yyyy-MM-dd" var="d1" />
											<fmt:formatDate value="${filtroVaga.dataAberturaPara}"
												pattern="yyyy-MM-dd" var="d2" />
											<input type="date" name="dataAberturaDe" id="data1"
												class="form-control" value="${d1 }"> <span
												class="input-group-addon">até</span> <input type="date"
												class="form-control" name="dataAberturaPara" id="data2"
												value="${d2 }">
										</div>
									</div>

									<div class="col-md-1">
										<label for="cargo">Status</label> <select class="form-control"
											style="width: 130px;" id="status" name="status">
											<option value="0">Selecione</option>
											<c:forEach var="status" items="${listaStatusDrop}">
												<option id="${status.id}" value="${status.id}"
													${status.id == filtroVaga.status[0].status.nome? 'selected="selected"' : ''}>${status.nome}</option>
											</c:forEach>
										</select>
									</div>

									<div class="text-right">
										<a href="#" style="text-decoration: none; color: #ffffff">
											<button id="pesquisar" class="btn btn-primary"
												style="margin-top: 22px; margin-right: 22px;" type="submit">Pesquisar</button>
										</a>
									</div>
								</form>

								<br />
								<div class ="table-responsive">
								<table id="tabelaVaga"
									class="table table-bordered table-condensed table-hover"
									style="font-size: 12px; vertical-align: middle; margin-top: -10px;">
									<thead>
										<tr>
											<th class="text-center"></th>
											<th class="text-center">Id</th>
											<th class="text-center">Vaga</th>
											<th class="text-center">Solicitante</th>
											<th class="text-center">Cliente</th>
											<th class="text-center">Local de trabalho</th>
											<th class="text-center">Data de abertura</th>
											<th class="text-center">Data de Início</th>
											<th class="text-center">Status</th>
											<th class="text-center">Ações</th>
										</tr>
									</thead>
									<tbody class="text-center">
										<c:forEach var="vaga" items="${vagas}" varStatus="count">
											<tr position="infoVaga" >
												<td class="accordion-toggle" data-toggle="collapse"
												data-target="#demo${count.index}" 
												style="cursor: pointer;"><span class="fa fa-plus-circle"></span></td>
												<td>${vaga.id}</td>
												<td id="linhaNome">${vaga.nomeVaga}</td>
												<td>${vaga.nomeSolicitante}</td>
												<td>${vaga.projeto.cliente.nome}</td>
												<td><c:if test="${vaga.localTrabalho == 73}">
											     Interno
											</c:if> <c:if test="${vaga.localTrabalho == 67}">
											     Cliente
											</c:if></td>
												<td><fmt:formatDate value="${vaga.dataAbertura}"
														pattern="dd/MM/yyyy" /></td>
												<td><fmt:formatDate value="${vaga.dataInicio}"
														pattern="dd/MM/yyyy" /></td>
												<td id="linhaStatus"><span class="label"
													style="color: #fff; background-color: ${vaga.ultimoStatus.status.css}">${vaga.ultimoStatus.status.nome}</span></td>
												<td>
													<div class="btn-group">
														<button class="btn btn-xs btn-info dropdown-toggle"
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="fa fa-cogs fa-lg">&nbsp;</i> <span
																class="caret"></span>
														</button>
														<ul class="dropdown-menu dropdown-menu-right slidedown ulAcoes">

															<li><a data-toggle="modal"
																data-target="#visualizar-modal"
																onclick="info(${vaga.id})"><i class="pri fa fa-eye">&nbsp;</i>Visualizar</a></li>
															<li role="separator" class="editarDivider pro divider"></li>
															<li><c:url value="historico/${vaga.id}"
																var="myURL">
															</c:url> <a href="${myURL}"><i class="fa fa-book fa-lg">&nbsp;</i>Histórico
																da vaga</a></li>
															<c:if
																test="${vaga.ultimoStatus.status.nome == 'Pendente'}">
																<li role="separator" class="editarDivider pro divider"></li>
																<li><c:url value="editar/${vaga.id}" var="myURL">
																	</c:url> <a href="${myURL}" class="editarPendente pro"><i
																		class="fa fa-pencil"></i> Editar</a></li>
															</c:if>

															<c:if
																test="${vaga.ultimoStatus.status.nome == 'Vaga nova'}">
																<li role="separator"
																	class="editarDivider divider btnEdita pre hide"></li>
																<li><c:url value="editar/${vaga.id}" var="myURL">
																	</c:url> <a href="${myURL}"
																	class="editarPendente btnEdita pre hide"><i
																		class="fa fa-pencil"></i> Editar</a></li>
															</c:if>
														</ul>
													</div> <!-- /btn-group -->
												</td>
											</tr>
											<tr>
												<td colspan="12" class="hiddenRow"
													style="background-color: #c7dbe5"><div
														class="accordian-body collapse" id="demo${count.index}">

														<br />
														<div class="col-sm-12" style="margin-left: 5px">
															<div class="col-md-3 well well-sm btn btn-success"
																style="height: 56px; margin-right: 5px; width: 200px; margin-left: 5px;">
																<label>Data de Abertura</label>
																<p style="margin-top: -5px;">
																	<fmt:formatDate value="${vaga.dataAbertura}"
																		pattern="dd/MM/yyyy" />
																</p>
															</div>
 															<div class="col-md-3 well well-sm btn btn-info"
																style="height: 56px; margin-right: 5px; width: 200px; margin-left: 5px;">
																<label>Data de Aprovação</label>
																<p style="margin-top: -5px;">
																	<fmt:formatDate value="${vaga.dataAprovacao}"
																		pattern="dd/MM/yyyy" />
																</p>
																
															</div>
															<div class="col-md-3 well well-sm btn btn-danger"
																style="height: 56px; margin-right: 5px; width: 200px; margin-left: 5px;">
																<label>Data de Fechamento</label>
																<p style="margin-top: -5px;">
																	<fmt:formatDate value="${vaga.dataFechamento}"
																		pattern="dd/MM/yyyy" />
																</p>
															</div>
															
															<div class="col-md-3 well well-sm btn btn-info"
																style="height: 56px; margin-right: 5px; width: 200px; margin-left: 5px;">
																<label>Solicitante da Vaga</label>
																<p style="margin-top: -5px;">
																	${vaga.nomeSolicitante}
																		
																</p>
															</div>
															
															<a href="/candidato/filtrar?nome=&vagaBean.id=${vaga.id}">
																<div class="col-md-3 well well-sm btn btn-warning"
																	style="height: 56px; margin-right: 5px; width: 200px; margin-left: 5px;"
																	data-toggle="tooltip" data-placement="bottom"
																	title="Clique para visualizar os candidatos">

																	<label>Numero de Candidatos</label>
																	<p style="margin-top: -5px;">${vaga.countCandidatos}</p>

																</div>
															</a>
														</div>

														<br />


													</div></td>
											</tr>

										</c:forEach>
									</tbody>
								</table>
								</div>
							</div>
							<!--</panel body>-->
							<div class="panel-footer clearfix">
								<div class="row">
									<input type="hidden" id="pageActive" value="${page }">
									<ul class="pagination pagination-xs m-top-none pull-right">
	                                  <li>
	                                      <c:if test="${page > 1}">
	                                          <button class="btn btn-default btn-sm" onclick="paginar(${page-1})">Anterior</button>
	                                      </c:if>
	                                      <c:forEach begin="${startpage}" end="${endpage}" var="p">
	                                          <button class="btn btn-default btn-sm" onclick="paginar(${p})" id="page${p}">${p}</button>
	                                      </c:forEach>
	                                      <c:if test="${page < endpage}">
	                                          <button class="btn btn-default btn-sm" onclick="paginar(${page+1})">Próximo</button>
	                                      </c:if>
	                                  </li>
                              		</ul>
								</div>
								<!--</div row>-->
							</div>
							<!--</panel footer>-->
						</div>
						<!--</panel default>-->
					</div>
					<!--</col-sm-12>-->
				</div>
				<!--</row>-->
			</div>
			<!--</padding>-->
		</div>
	</layout:put>

	<layout:put block="scripts" type="REPLACE">
	
		<script src="/resources/js/custom/moment-with-locales.min.js"></script>
		<script type="text/javascript">
		
		
		function paginar (page){
			if($('#filtro1').val() || $('#status').val() > 0 || $('#data1').val() || $('#data2').val()){
				$('form').append('<input type="hidden" name="page" value="' + page +'"/>')
				$('#pesquisar').click();
			}
			else{
				window.location.href = '/vaga/consultar?page='+page;
			}
		};
	
	$('#page'+$('#pageActive').val()).addClass('active');
	
	$('.accordian-body').on('show.bs.collapse', function () {
	    $(this).closest("table")
	        .find(".collapse.in")
	        .not(this)
	        .collapse('toggle')
	})
	
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
    						
    						$(".btnEdita").removeClass('hide')
    					}
    					
    				});
				
			}
		}
	});
	
	
	//linhaStatus
	//span-[status]
	$(".span-Fechado").addClass("label-warning");
	$(".span-Ativo").addClass("label-success");
	$(".span-Cancelado").addClass("label-danger");
	$(".span-Pendente").addClass("label-info");
	
	if($(".span-Fechado") || $(".span-Cancelado") || $(".span-Pendente")) {
		$('li#Fechado').hide();
		$('li#Cancelado').hide();
		$('li#Pendente').hide();
	}
	
	
	
	function info(listaId){
		
    	//var Visualizar = $("#fid option:selected").val();
    	var Solicitante;
    	var Titulo;
    	
    	//
    	$.ajax({
    		url: "abrir",
    		type: "GET",
    		dataType: "JSON",
    		data: { 'id' : listaId},
    		success: function(lista){
    			console.log(lista);
    			$('#titulo').html(lista.nomeVaga);
    			$('input#dataAbertura').val(lista.dataAbertura);
    			$('input#dataAprovacao').val(lista.dataAprovacao);
    			$('input#dataFechamento').val(lista.dataFechamento);
    			$('input#candidatos').val(lista.numeroCandidatos);
    			
    			if(lista.localTrabalho == 'C') {
    				$("#lblLocal").text('Cliente')
    				$('.infos').show();
    				$('div#divLocalTrabalho').show();
    				$('#nmResponsavel').val(lista.nmResponsavel);
    				$('#nmAreaResponsavel').val(lista.nmAreaResponsavel);
    				$('#emailResponsavel').val(lista.emailResponsavel);
    				$('#telResponsavel').val(lista.telResponsavel);
    			} else {
    				$('div#divLocalTrabalho').hide();
    				$('.infos').hide();
    				$("#lblLocal").text('Interno')
    			}
    			if(lista.idTipoVaga == 'H') { 
    				$("#tpVaga").text('Hunting')
    			} else if(lista.idTipoVaga == 'P') {
    				$("#tpVaga").text('Prospecção')
    			} else {
    				$("#tpVaga").text('Real')
    			}
    			if(lista.aumentaQuadro == 'N') {
    				$("#lblQuadro").text('Novo');
    				$("#substituido").hide();
    				$("#substituidoId").hide();
       			} else {
       				$("#lblQuadro").text('Substituição')
       				$("#substituido").show();
    				$("#substituidoId").show();
    			}
    			
    			$('input#solicitante').val(lista.nomeSolicitante);
    			
    			
    			$('input#cargo').val(lista.cargoBean.nome);
    			
    			
    			$('input#senioridade').val(lista.senioridadeBean.nome);
    			$('label#horaEntrada').text(lista.horarioEntrada);
    			$('label#horaSaida').text(lista.horarioSaida);
    			var pretensao = 'R$ ' + lista.valorPretensaoMin + ' - R$ ' + lista.valorPretensaoMax
    			$('input#pretensao').val(pretensao);
    			var date = moment(lista.dataInicio);
    			$('input#dataInicio').val(date.format("DD/MM/YYYY"));
    			$('label#substituido').text(lista.nomeSubstituido);
    			$('#formacaoAcademica').text(lista.descricaoFormacaoAcademica);
    			$('#perfilComportamental').text(lista.descricaoPerfilComportamental);
    			$('#perfilTecnico').text(lista.descricaoPerfilTecnico);
    			
    			$('.removeTd').remove()
    			$.each(lista.avaliadores,function(i,item){
    				$('#trAvaliadores').append(
    						"<td class='removeTd' style='width: 1px'><i class='fa fa-user pull-center'></i></td> <td class='removeTd' style='width: 6px'><span class='badge badge-info'>"+item.funcionario.nome+"</span></td>"
    						
    				);
    			});
    			
    			$('#vaga-modal').modal('show');
    		}
    	})
    } 
	function imprimir(){
	//document.getElementById("Print").onclick = function() {
	    printElement(document.getElementById("PrintThis"));
	//};
	}

	function printElement(elem) {
	    var domClone = elem.cloneNode(true);

	    var $printSection = document.getElementById("printSection");

	    if (!$printSection) {
	        var $printSection = document.createElement("div");
	        $printSection.id = "printSection";
	        document.body.appendChild($printSection);
	    }

	    $printSection.innerHTML = "";
	    $printSection.appendChild(domClone);
	    window.print();
	}
	
	function mudarQuadro() {
		var $quadro = document.getElementById("lblQuadro");
		var $sub = document.getElementById("substituido");
		
		
	}
	
	function status(){
    	$.ajax({
    		url: "status",
    		type: "POST",
    		dataType: "JSON",
    		data: { 'idVaga' : $('.cancela-id').val(), 'status' : $('.cancela-status').val()},
    		success: function(){
    				location.reload();	
    			}
    	});
    	}
	function alterarStatus(id,status){
		$('input.cancela-id').val(id);
		$('input.cancela-status').val(status);
	
		$('input.reprovar-id').val(id);
		$('input.reprovar-status').val(status);
		
	}
	
	
	</script>
		<script>
	
	$(function() {
		
    	var id = $("#idPerfil").val();
    	$.ajax({
    		url: "/usuario/obter-perfil-funcionalidade",
    		type: "GET",
    		dataType: "JSON",
    		data: {id : id},
    		success: function(lista){
    			if(lista != null){
    				var editar = 0;
    				
	    				$.each(lista,function(i,item){
    						if(item.id == 31){
    							editar++;
	    					}
	    				});
	    				
    				if (editar == 0){
    					$('.pro').hide();
    					$('.pre').hide();
    				}
    				
    			}
    		}
    	});
	})
	
	function filtrarCandidato(){
	$.ajax({
		url: "filtro",
		type: "GET",
		dataType: "JSON",
		data: { 'CandidatoBean' : $('nomeVaga').val()},
		success: function(){
				location.reload();	
			}
	});
	}
	</script>
	</layout:put>
</layout:extends>