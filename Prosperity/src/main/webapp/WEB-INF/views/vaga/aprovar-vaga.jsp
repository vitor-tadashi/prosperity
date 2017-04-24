<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Aprovação de vagas</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<style type="text/css">
footer {
	page-break-before: always;
	}

@media screen {
	#printSection {
		display: none;
	}
}

@media print {
	body * {
		visibility: hidden;
	}
	#printSection * {
		visibility: visible;
	}
	#printSection {
		position: absolute;
		left: 0;
		top: 0;
	}
	label {
		font-weight: normal;
	}
	#quebra { page-break-inside: avoid; }
}
</style>

</head>
<body>

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>


	<!-- Modal visualizar-->
	<div class="modal fade" id="vaga-modal" data-target="#vaga-modal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div id="printThis">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="titulo">Vaga</h4>
					</div>
					<div class="modal-body">
						<div class="panel-tab clearfix">
					</div>
						<div class="tab-content">
							<div id="home" class="tab-pane fade in active">
								<section class="panel panel-default" style="margin-bottom: 0px">
									<div class="panel-heading">Informações básicas</div>
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
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Aprovação de vagas</title>
		<link rel="stylesheet" href="/resources/css/custom/aprovar-vaga.css" />
	</layout:put>

	<layout:put block="contents">
		<!-- Modal visualizar-->
		<div class="modal fade" id="vaga-modal" data-target="#vaga-modal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div id="printThis">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="titulo">Vaga</h4>
						</div>
						<div class="modal-body">
							<div class="panel-tab clearfix">
								<ul class="tab-bar">
									<li class="active"><a data-toggle="tab" href="#home"><i
											class="fa fa-tags">&nbsp</i>Especificações</a></li>
								</ul>
							</div>
							<div class="tab-content">
								<div id="home" class="tab-pane fade in active">
									<section class="panel panel-default" style="margin-bottom: 0px">
										<div class="panel-heading">Informações básicas</div>
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

														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputEmail1">Local de
																trabalho:</label>
															<div class="radiogroup" name="localTrabalho" id="local">
																<label id="lblLocal" class="label-radio inline" value="">
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
															<label for="cargo">Nome do cargo</label> <input
																type="name" class="form-control input-sm" id="cargo"
																value="Cargo" disabled>
														</div>
														<!-- /form-group -->

														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputEmail1">Tipo de vaga:</label>
															<div class="radiogroup" name="idTipoVaga" id="tipo">
																<label id="tpVaga" class="label-radio inline" value="">
																</label>
															</div>
															<!-- /.col -->
														</div>
													</div>
												</div>
												<div class="form-group row" style="margin-bottom: 0px;">
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">
														<label for="vagaSenioridade">Senioridade da vaga</label> <input
															type="name" class="form-control input-sm"
															id="vagaSenioridade" placeholder="Estágio"
															value="Senioridade
													da Vaga" disabled>
													</div>
													<!-- /form-group -->
													<div class="form-group" style="margin-bottom: 0px">
														<label for="vagaHorario" style="padding-left: 15px;">Horário:</label>

														<div>
															<div class="form-group col-md-2 col-xs-2">
																<div class="input-group bootstrap-timepicker">
																	<label id="horaEntrada" name="horarioEntrada"
																		type="time" style="margin-top: 7px" value=""></label>
																</div>
															</div>

															<div class="form-group col-md-1 col-xs-1">
																<label style="margin-top: 7px">Às</label>
															</div>

															<div class="form-group col-md-2 col-xs-1">
																<div class="input-group bootstrap-timepicker">
																	<label id="horaSaida" name="horaSaida" type="time"
																		style="margin-top: 7px"></label>
																</div>
															</div>
														</div>

													</div>
												</div>

												<div class="form-group row">
													<div class="">
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="vagaSalario">Faixa salarial</label> <input
																class="form-control input-sm" id="vagaSalario"
																placeholder="Faixa Salarial" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="vagaQuadro">Aumento de quadro:</label>
															<div class="radiogroup" id="aumento">
																<label id="lblQuadro" class="label-radio inline">
																</label>

															</div>
															<!-- /.col -->
														</div>
													</div>
												</div>
												<div class="form-group row" style="margin-bottom: 0px">
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">
														<div class="form-group">

															<label class="control-label"> Data para inicio</label>
															<div class="form-group">
																<div class="input-group">
																	<fmt:formatDate value="${vaga.dataInicio}"
																		pattern="dd/MM/yyyy" var="dataInicio" />
																	<input type="date" value="${vaga.dataInicio}"
																		name="dataInicio" class="datepicker form-control"
																		id="dataInicio" disabled> <span
																		class="input-group-addon"><i
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
														<label id="vagaSubstituto" style="margin-top: 7px"></label>
													</div>
												</div>
											</form>
										</div>
									</section>
									<!-- /Section -->

									<div id="quebra">
										<section class="panel panel-default"
											style="margin-bottom: 5px;">
											<div class="panel-heading">Informações de projeto</div>
											<div class="panel-body">
												<!-- /form-group -->
												<div class="form-group col-md-13 "
													style="margin-bottom: 5px;">
													<label class="control-label">Projeto</label> <input
														readonly class="form-control default-cursor"
														id="vagaProjeto" value="Mobile">
												</div>
												<div class="form-group col-md-6 col-xs-6"
													style="margin-bottom: 5px;">
													<label class="control-label">Cliente</label> <input
														readonly class="form-control" id="vagaCiente"
														value="Carrefour">
												</div>
												<div class="form-group col-md-6 col-xs-6"
													style="margin-bottom: 5px;">
													<label class="control-label">Gestor imediato</label> <input
														readonly class="form-control" id="vagaGestor"
														value="Vitor Tadashi">
												</div>
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default"
											style="margin-bottom: 0px;">
											<div style="page-break-before: always;"></div>
											<div class="panel-heading">Formação acadêmica</div>
											<div class="panel-body relative"
												style="padding-top: 5px; padding-right: 5px; padding-bottom: 5px; padding-left: 5px;">
												<div class="form-group">
													<textarea class="form-control" rows="3" name="vagaFormacao"
														id=vagaFormacao disabled>
										</textarea>
												</div>
												<!-- /form-group -->
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default"
											style="margin-bottom: 0px;">
											<div class="panel-heading">Perfil comportamental</div>
											<div class="panel-body relative"
												style="padding-top: 5px; padding-right: 5px; padding-bottom: 5px; padding-left: 5px;">
												<div class="form-group">
													<textarea class="form-control" rows="3" name="vagaPerfil"
														id=vagaPerfil disabled></textarea>
												</div>
												<!-- /form-group -->
											</div>
										</section>
										<!-- /panel -->

										<section class="panel panel-default "
											style="margin-bottom: 0px;">
											<div class="panel-heading">Perfil técnico</div>
											<div class="panel-body relative"
												style="padding-top: 5px; padding-right: 5px; padding-bottom: 5px; padding-left: 5px;">
												<div class="form-group">
													<textarea class="form-control" rows="3"
														name="vagaPerfilTecnico" id=vagaPerfilTecnico disabled></textarea>
												</div>
												<!-- /form-group -->
											</div>
										</section>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /tab-content -->
					<!-- /panel -->
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="Print">Imprimir</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal aprovar -->
		<div class="modal fade" id="aprova-modal" data-target="#fecha-modal"
			tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Aprovar vaga</h4>
					</div>
					<div class="modal-body">Deseja realmente aprovar está vaga?</div>
					<input class="aprovar-id" type="hidden"> <input
						class="aprovar-status" type="hidden">
					<div class="modal-footer">
						<a href="#">
							<button id="aprovaVaga" onclick="status()" type="button"
								class="btn btn-primary" data-dismiss="modal">Sim</button>
						</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal aprovar-->

		<!-- Modal reprovar -->
		<div class="modal fade" id="reprova-modal" data-target="#fecha-modal"
			tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Reprovar vaga</h4>
					</div>
					<div class="modal-body">Deseja realmente reprovar está vaga?</div>
					<input class="reprovar-id" type="hidden"> <input
						class="reprovar-status" type="hidden">
					<div class="modal-footer">
						<a href="#">
							<button id="reprovaVaga" type="button" onclick="status()"
								class="btn btn-primary" data-dismiss="modal">Sim</button>
						</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal aprovar-->

		<!-- modal cancelar -->
		<div class="modal fade" id="cancela-modal"
			data-target="#cancela-modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
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
						<a id="excluir" href="${urlCancelar}">
							<button id="excluiVaga" onclick="status()" type="button"
								class="btn btn-primary" data-dismiss="modal">Sim</button>
						</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal cancelar -->

		<!-- modal cancelar avaliador -->
		<div class="modal fade" id="avaliador-modal"
			data-target="#avaliador-modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Cancelar avaliadores</h4>
					</div>
					<div class="modal-body">Deseja realmente cancelar avaliador?</div>
					<input class="avaliador-id" type="hidden"> <input
						class="avaliador-status" type="hidden">
					<div class="modal-footer">
						<a id="excluir" href="${urlCancelar}">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Sim</button>
						</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal cancelar avaliador -->

		<!-- modal fechar -->
		<div class="modal fade" id="fechar-modal" data-target="#fechar-modal"
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
		<!-- /.modal fechar -->

		<!-- CORPO DA PÁGINA -->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="dashboard.html">
							Início</a></li>
					<li class="active">Aprovação de vaga</li>
				</ul>
			</div>
			<!--breadcrumb-->

			<div class="padding-md" id="fourth">
				<div class="panel panel-default">
					<div class="panel-heading">Aprovação de vaga</div>
					<div class="panel-body">

						<table
							class="table table-bordered table-condensed table-hover table-striped"
							id="tabelaVaga"
							style="font-size: 12px !important; vertical-align: middle !important;">
							<!-- Começo Tabela -->
							<thead>
								<tr class="text-center">
									<th class="text-center">Nome da vaga</th>
									<th class="text-center">Cargo</th>
									<th class="text-center">Senioridade</th>
									<th class="text-center">Solicitante</th>
									<th class="text-center">Projeto</th>
									<!-- <th class="text-center">Cliente</th>
								<th class="text-center">Local de trabalho</th> -->
									<th class="text-center">Data abertura</th>
									<th class="text-center">Status</th>
									<th class="text-center">Ações</th>
								</tr>
							</thead>
							<tbody class="text-center">
								<c:forEach var="vaga" items="${vagas}" varStatus="i">

									<tr>
										<td>${vaga.nomeVaga}</td>
										<td>${vaga.cargoBean.nome}</td>
										<td>${vaga.senioridadeBean.nome}</td>
										<td style="width: 112px;">${vaga.nomeSolicitante}</td>
										<td style="width: 302px;">${vaga.projeto.nome}</td>
										<%-- <td>${vaga.projeto.cliente.nome}</td>
									<td><c:if test="${vaga.localTrabalho == 73}">
										     Interno
										</c:if> <c:if test="${vaga.localTrabalho == 67}">
										     Cliente
										</c:if></td> --%>
										<td><fmt:formatDate value="${vaga.dataAbertura }"
												pattern="dd/MM/yyyy" /></td>
										<td id="linhaStatus"><span class="label"
											style="color: #fff; background-color:${vaga.ultimoStatus.status.css}">${vaga.ultimoStatus.status.nome}</span></td>
										<td>
											<div class="btn-group">
												<!-- <-- ! Começo Botão -->
												<button type="button"
													class="btn btn-info dropdown-toggle btn-sm"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class="fa fa-cogs fa-lg">&nbsp; </i><span class="caret"></span>
												</button>
												<ul class="dropdown-menu slidedown btnAlinhado">
													<li><a href="#visualizar-modal"
														onclick="info(${vaga.id})"> <i class="fa fa-eye fa-lg">&nbsp</i>Visualizar
													</a></li>


													<c:if test="${vaga.ultimoStatus.status.nome == 'Pendente'}">
														<li id="${vaga.ultimoStatus.status.nome}" role="separator"
															class="Aprovar divider"></li>
														<li id="${vaga.ultimoStatus.status.nome}" class="Aprovar"><a
															href="#aprova-modal"
															onclick="alterarStatus(${vaga.id}, 'ATIVO')"
															data-toggle="modal"><i
																class="Aprovar fa fa-check fa-lg"></i> Aprovar</a></li>
													</c:if>

													<c:if test="${vaga.ultimoStatus.status.nome == 'Pendente'}">
														<li id="${vaga.ultimoStatus.status.nome}" role="separator"
															class="Reprovar divider"></li>
														<li id="${vaga.ultimoStatus.status.nome}" class="Reprovar"><a
															href="#reprova-modal"
															onclick="alterarStatus(${vaga.id}, 'RECUSADO')"
															data-toggle="modal"><i
																class="Reprovar fa  fa-times fa-lg"></i> Reprovar</a></li>
													</c:if>


													<c:if test="${vaga.ultimoStatus.status.nome == 'Ativo'}">
														<c:url scope="session" value="cancelar-vaga/${vaga.id}"
															var="urlCancelar">
														</c:url>
														<li id="${vaga.ultimoStatus.status.nome}" role="separator"
															class="cancelarDivider divider"></li>
														<li id="${vaga.ultimoStatus.status.nome}"><a
															href="#cancela-modal"
															onclick="alterarStatus(${vaga.id}, 'CANCELADO')"
															data-toggle="modal" class="cancelarAtivos"><i
																class="Cancelar fa fa-ban fa-lg"></i> Cancelar</a></li>
													</c:if>

													<c:if test="${vaga.ultimoStatus.status.nome == 'Ativo'}">
														<li id="${vaga.ultimoStatus.status.nome}" role="separator"
															class="fecharDivider divider"></li>
														<li id="${vaga.ultimoStatus.status.nome}"><a
															href="#fechar-modal"
															onclick="alterarStatus(${vaga.id}, 'FECHADO')"
															data-toggle="modal" class="fecharAtivo"><i
																class="Fechar fa fa-trash-o fa-lg"></i> Fechar</a></li>
													</c:if>

													<c:if
														test="${vaga.ultimoStatus.status.nome == 'Aguardando avaliadores'}">
														<c:url scope="session" value="cancelar-vaga/${vaga.id}"
															var="urlCancelar">
														</c:url>
														<li id="${vaga.ultimoStatus.status.nome}" role="separator"
															class="avaliadorDivider divider"></li>
														<li id="${vaga.ultimoStatus.status.nome}"><a
															href="#avaliador-modal"
															onclick="alterarStatus(${vaga.id}, ${candidato.id} 'CANCELADO')"
															data-toggle="modal" class="avaliador"><i
																class="Cancelar fa fa-ban fa-lg"></i> Cancelar</a></li>
													</c:if>
												</ul>
											</div> <!-- Fim Botão -->
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- Fim Tabela -->
					</div>
					<!-- /panel -->
				</div>
				<!-- /.padding-md -->
			</div>
			<!-- /wrapper -->
		</div>
	</layout:put>

	<layout:put block="scripts" type="REPLACE">
	<script type="text/javascript">
	
	// script para cores dos status
	$(".span-Fechado").addClass("label-warning");
	$(".span-Ativo").addClass("label-success");
	$(".span-Cancelado").addClass("label-danger");
	$(".span-Pendente").addClass("label-info");
	
	// função para mostrar no modal (visualizar) os campos preenchidos
	function info(listaId){
    	//
    	$.ajax({
    		url: "visualizar",
    		type: "GET",
    		dataType: "JSON",
    		data: { 'id' : listaId},
    		success: function(lista){
    			console.log(lista);
    			$('#titulo').html(lista.nomeVaga);
    			$('input#vagaGestor').val(lista.nomeSolicitante);
    			if(lista.localTrabalho == 'C') {
    				//$("#cliente").attr('checked', 'checked');
    				$("#lblLocal").text('Cliente')
    			} else {
    				//$("#interno").attr('checked', 'checked');
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
    				$("#lblQuadro").text('Novo')
    				$("#substituidoId").hide();
    				$("#vagaSubstituto").hide();
       			} else {
       				$("#lblQuadro").text('Substituição')
       				$("#substituidoId").show();
    				$("#vagaSubstituto").show();
    			}
    			$('input#vagaSalario').val(lista.valorPretensao);
    			$('input#cargo').val(lista.cargoBean.nome);
    			$('input#vagaSenioridade').val(lista.senioridadeBean.nome);
    			$('label#horaEntrada').text(lista.horarioEntrada);
    			$('label#horaSaida').text(lista.horarioSaida);
    			$('input#solicitante').val(lista.nomeSolicitante);
    			$('input#vagaQuadro').val(lista.aumentaQuadro);
    			$('label#vagaSubstituto').text(lista.nomeSubstituido);
    			$('input#dataInicio').val(lista.dataInicio);
    			$('input#vagaCiente').val(lista.projeto.cliente.nome);
    			$('input#vagaProjeto').val(lista.projeto.nome);
    			$('#vagaPerfil').val(lista.descricaoPerfilComportamental);
    			$('#vagaFormacao').val(lista.descricaoFormacaoAcademica);
    			$('#vagaPerfilTecnico').val(lista.descricaoPerfilTecnico);
    			$('#vaga-modal').modal('show');
    		}
    	})
    } 

	// metodo para a função imprimir
	document.getElementById("Print").onclick = function () {
	    printElement(document.getElementById("printThis"));
	};

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
	
	// função para a alteração de status no botão ações
	function status(){
    	$.ajax({
    		url: "status",
    		type: "POST",
    		dataType: "JSON",
    		data: { 'idVaga' : $('.aprovar-id').val(), 'status' : $('.aprovar-status').val()},
    		success: function(){
    				location.reload();	
    			}
    	});
    	}
	// funcao para alterar status
	function alterarStatus(id,status){
		$('input.aprovar-id').val(id);
		$('input.aprovar-status').val(status);

		$('input.reprovar-id').val(id);
		$('input.reprovar-status').val(status);
		
		$('input.cancelar-id').val(id);
		$('input.cancelar-status').val(status);
		
	}
	// função para formatar a dataInicio dd/MM/yyyy no modal (visualizar)
	function dataAtualFormatada(){
	    var data = new Date();
	    var dia = data.getDate();
	    if (dia.toString().length == 1)
	      dia = "0"+dia;
	    var mes = data.getMonth()+1;
	    if (mes.toString().length == 1)
	      mes = "0"+mes;
	    var ano = data.getFullYear();  
	    return dia+"/"+mes+"/"+ano;
	}
	
	// função para o metodo status ativo
	$(function() {
		
    	var id = $("#idPerfil").val();
    	$.ajax({
    		url: "http://localhost:8080/usuario/obter-perfil-funcionalidade",
    		type: "GET",
    		dataType: "JSON",
    		data: {id : id},
    		success: function(lista){
    			if(lista != null){
    				var cancelar = 0;
    				var fechar = 0;
    				
	    				$.each(lista,function(i,item){
    						if(item.id == 29){
    							cancelar++;
	    					}
    						if(item.id == 30){
    							fechar++;
	    					}
	    				});
	    				
    				if (cancelar == 0){
    					$('.cancelarAtivos').hide();
   						$('.cancelarDivider').hide();
    				}
    				if (fechar == 0){
    					$('.fecharAtivo').hide();
   						$('.fecharDivider').hide();
   						
   						
    				}
    			}
    		}
    	});
	})
	</script>
	</layout:put>
</layout:extends>