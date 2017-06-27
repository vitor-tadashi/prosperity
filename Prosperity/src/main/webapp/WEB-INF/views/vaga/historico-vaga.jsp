<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Histórico da vaga</title>
		<link rel="stylesheet" href="/resources/css/custom/timeline.css" />
	</layout:put>
	
	<layout:put block="contents">
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="/pagina-inicial">
						Início</a></li>
				<li class="active">Histórico da vaga</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->
		<div class="padding-md">
			<div class="row">
				<section class="panel panel-default">
					<div class="panel-body">
						<div class="panel-tab clearfix">
							<ul class="tab-bar wizard-demo" id="wizardDemo">
								<li class="active tab-verity"><a href="#first"
									data-toggle="tab"><i class="fa fa-suitcase"></i> Dados gerais</a></li>
								<li class="tab-verity"><a href="#second"
									data-toggle="tab" class="text-success"><i
										class="fa fa-user"></i> Candidatos</a></li>
							</ul>
						</div>
						<br>
						<div class="panel-body">
							<div class="tab-content">
								<div class="tab-pane fade in active" id="first">
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Informações básicas</strong></h5></legend>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Nome da vaga: </strong>${vaga.nomeVaga}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Data para início: </strong><fmt:formatDate value="${vaga.dataInicio}"
													pattern="dd/MM/yyyy" /></p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Solicitante: </strong>${vaga.nomeSolicitante}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Data de fechamento: </strong><fmt:formatDate value="${vaga.dataFechamento}"
													pattern="dd/MM/yyyy" /></p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Avaliadores: </strong>
													<c:forEach items="${vaga.avaliadores }" var="av" varStatus="i">
														<c:if test="${i.index > 0 }">,</c:if> 
														${av.funcionario.nome }
													</c:forEach>
												</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Status da vaga: </strong>${vaga.ultimoStatus.status.nome}</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Cargo: </strong>${vaga.cargoBean.nome }</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Faixa salarial: </strong>R$ 1000,00 até R$ 5000,00</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Senioridade: </strong>${vaga.senioridadeBean.nome }</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Local de trabalho: </strong> 
													<c:if test="${vaga.localTrabalho.toString() eq 'C' }">Cliente</c:if>
													<c:if test="${vaga.localTrabalho.toString() eq 'I' }">Interno</c:if>
												</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Tipo de vaga: </strong>
													<c:if test="${vaga.idTipoVaga.toString() eq 'R' }">Real</c:if>
													<c:if test="${vaga.idTipoVaga.toString() eq 'P' }">Prospecção</c:if>
													<c:if test="${vaga.idTipoVaga.toString() eq 'H' }">Hunting</c:if>
												</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Aumento de quadro: </strong>
													<c:if test="${vaga.aumentaQuadro.toString() eq 'N' }">Novo</c:if>
													<c:if test="${vaga.aumentaQuadro.toString() eq 'S' }">Substituição - ${vaga.nomeSubstituido }</c:if>
												</p>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<c:if test="${vaga.localTrabalho.toString() eq 'C' }">
											<legend style="color:#424f63"><h5><strong>Informações do projeto</strong> - cliente</h5></legend>
											<div class="row">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Nome do projeto: </strong>${vaga.projeto.nome}</p>
												</div>
											</div>
											<div class="row">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Cliente: </strong>${vaga.projeto.cliente.nome}</p>
												</div>
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Gestor imediato: </strong>${vaga.usuarioBean.funcionario.nome}</p>
												</div>
											</div>
											<div class="row">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Nome do responsável: </strong>${vaga.nmResponsavel}</p>
												</div>
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Área do responsável: </strong>${vaga.nmAreaResponsavel}</p>
												</div>
											</div>
											<div class="row">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>E-mail: </strong>${vaga.emailResponsavel}</p>
												</div>
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Telefone: </strong>${vaga.telResponsavel}</p>
												</div>
											</div>
										</c:if>
										<c:if test="${vaga.localTrabalho.toString() eq 'I' }">
											<legend style="color:#424f63"><h5><strong>Informações do projeto</strong> - interno</h5></legend>
											<div class="row">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Nome do projeto: </strong>${vaga.projeto.nome}</p>
												</div>
											</div>
											<div class="row">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Cliente: </strong>${vaga.projeto.cliente.nome}</p>
												</div>
											</div>
											<div class="row">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Gestor imediato: </strong>${vaga.usuarioBean.funcionario.nome}</p>
												</div>
											</div>
										</c:if>
									</fieldset>
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Indicadores</strong></h5></legend>
										<div class="panel panel-default">
											<div class="panel-body">
												<div id="donutChart" style="height: 300px;"></div>
												<div class="panel-group" id="accordion">
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
																	Candidatura
																	<span class="badge badge-success pull-right">75%</span>
																</a>
															</h4>
														</div>
														<div id="collapseOne" class="panel-collapse collapse">
															<div class="panel-body">
																<table class="table table-bordered table-condensed table-hover table-striped" id="tabelaCandidato"
																	style="font-size: 12px !important; vertical-align: middle !important;">
																	<thead>
																		<tr>
																			<th class="text-center">Nome do candidato</th>
																			<th class="text-center">Data de alteração</th>
																			<th class="text-center">Status</th>
																			<th class="text-center">Histórico do Candidato</th>
																		</tr>
																	</thead>
																	<tbody class="text-center">
																		<c:forEach var="candidato" items="${candidatos}">
																			<c:if test="${candidato.ultimoStatus.status.id == 5 }">
																				<tr id="">
																					<td>${candidato.nome}</td>
																					<td><fmt:formatDate value="${candidato.ultimoStatus.dataAlteracao}"
																							pattern="dd/MM/yyyy" /></td>
																					<td><span class="label"
																						style="color: #fff; background-color: ${candidato.ultimoStatus.status.css}">${candidato.ultimoStatus.status.nome}</span></td>
																					<td>Historico</td>
																				</tr>
																			</c:if>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>
													</div><!-- panel -->
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
																	DOWMLOAD Sales
																</a>
															</h4>
														</div>
														<div id="collapseTwo" class="panel-collapse collapse">
															<div class="panel-body">
																Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. 
															</div>
														</div>
													</div><!-- panel -->
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
																	MAIL-ORDER Sales 
																	<span class="badge badge-danger pull-right"><i class="fa fa-arrow-down"></i> 3%</span>
																</a>
															</h4>
														</div>
														<div id="collapseThree" class="panel-collapse collapse">
															<div class="panel-body">
																Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. 
															</div>
														</div>
													</div><!-- panel -->
												</div><!-- panel-group -->
											</div>
										</div><!-- /panel -->
									</fieldset>
								</div>
								<div class="tab-pane fade" id="second">
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Vaga aplicado</strong></h5></legend>
										
									</fieldset>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- /Section -->
			</div>
			<!-- /.padding-md -->
		</div>
	</div>
	</layout:put>
	<layout:put block="scripts" type="REPLACE">
	</layout:put>
</layout:extends>