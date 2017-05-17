<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Histórico de candidato</title>
		<link rel="stylesheet" href="/resources/css/custom/timeline.css" />
	</layout:put>
	
	<layout:put block="contents">
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						Início</a></li>
				<li class="active">Histórico candidato</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->

		<div class="padding-md">
			<div class="row">
				<section class="panel panel-default">
					<div class="panel-heading">Informações básicas</div>
					<div class="panel-body">
						<div class="panel-tab clearfix">
									<ul class="tab-bar wizard-demo" id="wizardDemo">
										<li class="active tab-verity"><a href="#first"
											data-toggle="tab"><i class="fa fa-user"></i> Dados gerais</a></li>
										<li class="tab-verity"><a href="#second"
											data-toggle="tab" class="text-success"><i
												class="fa fa-pencil"></i> Processo seletivo</a></li>
										<li class="tab-verity"><a href="#third" data-toggle="tab"
											class="text-success"><i class="fa fa-code-fork"></i> Linha do tempo</a></li>
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
														<p class="" id="nome"><strong>Nome: </strong>${candidato.nome}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Data de nascimento: </strong><fmt:formatDate value="${candidato.dataNascimento}"
															pattern="dd/MM/yyyy" /></p>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>CPF: </strong>${candidato.cpf}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>RG: </strong>${candidato.rg}</p>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>E-mail: </strong>${candidato.email}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Telefone: </strong>${candidato.contato.telefone}</p>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Pretensão salarial: </strong>${candidato.valorPretensao }</p>
													</div>
												</div>
											</fieldset>
											<fieldset>
												<legend style="color:#424f63"><h5><strong>Endereço</strong></h5></legend>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Logradouro: </strong>${candidato.endereco.logradouro}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Número: </strong>${candidato.endereco.numero}</p>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Complemento: </strong>${candidato.endereco.complemento}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>CEP: </strong>${candidato.endereco.cep}</p>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Cidade: </strong>${candidato.endereco.cidade}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Estado: </strong>${candidato.endereco.estado}</p>
													</div>
												</div>
											</fieldset>
											<fieldset>
												<legend style="color:#424f63"><h5><strong>Formação</strong></h5></legend>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Curso: </strong>${candidato.formacao.nomeCurso}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Instituição: </strong>${candidato.formacao.nomeInstituicao}</p>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Grau de instrução: </strong>${candidato.formacao.tipoCurso.nome}</p>
													</div>
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Situação Atual: </strong>${candidato.formacao.situacaoAtual.descricao}</p>
													</div>
												</div>
												<div class="row">
													<div class="form-group col-md-6">
														<p class="" id="nome"><strong>Data de conclusão: </strong><fmt:formatDate value="${candidato.formacao.dataConclusao}"
															pattern="dd/MM/yyyy" /></p>
													</div>
												</div>
											</fieldset>
										</div>
										<div class="tab-pane fade" id="second">
											<fieldset>
												<legend style="color:#424f63"><h5><strong>Provas aplicadas</strong></h5></legend>
												<div class="row">
													<div class="form-group col-md-6">
														<label>Tipo de prova</label>
														<ol type="none">
														<c:forEach items="${provas }" var="prova">
															<li>${prova.provas.nome }</li>
														</c:forEach>
														</ol>
													</div>
													<div class="form-group col-md-6">
														<label>Descrição</label>
														<ol type="none">
														<c:forEach items="${provas }" var="prova">
															<li>${prova.descricao }</li>
														</c:forEach>
														</ol>
													</div>
												</div>
											</fieldset>
											<fieldset>
												<legend style="color:#424f63"><h5><strong>Avaliação de skill</strong></h5></legend>
												<div class="row">
													<c:forEach begin="1" end="${colCompetencias }" var="i">
														<div class="form-group col-md-4">
															<p class="text-center" id="nome"><strong>Avaliador: </strong>${candidato.competencias[(i * 7) -1].nmAvaliador }</p>
															<table class="table table-condensed">
																<tbody>
																	<tr>
																		<th class="text-center">Competências</th>
																		<th class="text-center">Resultados</th>
																	</tr>
																	<c:forEach var="c" begin="${(i*7)-7 }" end="${(i * 7) -1 }">
																		<tr class="text-center">
																			<td>${candidato.competencias[c].competencia.nome}</td>
																			<td><span class="badge" style="color:#fff; background-color:${candidato.competencias[c].avaliacao.tipoCss}">${candidato.competencias[c].avaliacao.nome}</span></td>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</c:forEach>
												</div>
											</fieldset>
										</div>
										<div class="tab-pane fade" id="third">
											<fieldset>
												<legend style="color:#424f63"><h5><strong>Eventos do processo seletivo</strong></h5></legend>
												<ul class="timeline">
													<c:set var="count" value="0" scope="page" />
													<c:forEach var="statusPorMesAno"
														items="${candidato.statusPorMesAno}">
														<li><div class="tldate">${statusPorMesAno.key}</div></li>
														<c:forEach var="status" items="${statusPorMesAno.value}"
															varStatus="count">
						
															<c:choose>
																<c:when test="${count.index %2 eq 0}">
																	<c:set value="timeline" var="cssTimeline"></c:set>
																</c:when>
																<c:otherwise>
																	<c:set value="timeline-inverted" var="cssTimeline"></c:set>
																</c:otherwise>
															</c:choose>
						
															<li class="${cssTimeline}">
																<div class="tl-circ"></div>
																<div class="timeline-panel">
																	<div class="tl-heading">
																		<h4>Status: ${status.status.nome}</h4>
																		<p>
																			<small class="text-muted"><i class="fa fa-calendar"></i>
																				<fmt:formatDate value="${status.dataAlteracao}"
																					pattern="dd/MM/yyyy" /></small>
																		</p>
																	</div>
																	<div class="tl-body">
																		<p class="desParecer">
																			<label>Parecer:</label> <span>${status.descricaoParecer}</span>
																		</p>
																		<p>
																			<label>Usuário:</label> <span>${status.usuario.nome}</span>
																		</p>
																	</div>
																</div>
															</li>
														</c:forEach>
													</c:forEach>
												</ul>
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
	<script>	
		$(function() {
			$('p.desParecer').each(function() {
				if($(this).find('span').text() == '') {
					$(this).remove();
				}
			});
		});
	</script>
	</layout:put>
</layout:extends>