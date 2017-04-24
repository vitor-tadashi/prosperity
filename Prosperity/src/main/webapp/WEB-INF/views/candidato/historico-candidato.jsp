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
						<div class="row">
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Nome do candidato:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="nome">${candidato.nome}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Email:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="email">${candidato.email}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">CPF:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="cpf">${candidato.cpf}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">RG:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="rg">${candidato.rg}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Data nascimento:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="dtNascimento">
										<fmt:formatDate value="${candidato.dataNascimento}"
											pattern="dd/MM/yyyy" />
									</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Telefone:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="telefone">${candidato.contato.telefone}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Cidade:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="cidade">${candidato.endereco.cidade}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Estado:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="estado">${candidato.endereco.estado}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Curso:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="nomeCurso">${candidato.formacao.nomeCurso}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Instituição:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="instituicao"
										>${candidato.formacao.nomeInstituicao}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Tipo de curso:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="tipoCurso">${candidato.formacao.tipoCurso.nome}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Situação atual:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="situacaoAtual">
										${candidato.formacao.situacaoAtual.descricao}
									</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Mês/Ano conclusão:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="conclusao">
										<fmt:formatDate value="${candidato.formacao.dataConclusao}"
											pattern="dd/MM/yyyy" />
									</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Pretensão
									salarial:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="pretensao">
										<fmt:formatNumber value="${candidato.valorPretensao}"
											minFractionDigits="2" type="currency" pattern="#,##0.00" />
									</p>
								</div>
							</div>

							<div class="form-group col-xs-12">
								<label class="col-xs-2 control-label">Competências</label>
								<div class="col-xs-4"
									style="margin-left: 39px; padding-right: 30px">
									<table class="table table-condensed table-bordered">
										<c:forEach var="competencias" items="${candidato.competencias}">
											<tr>
												<td>${competencias.competencia.nome}</td>
												<td><span class="badge badge-info">${competencias.avaliacao.nome}</span></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							
							
							
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Tipo de prova:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="situacaoAtual"
										name="situacaoAtual">Prova teórica</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Descrição:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="conclusao" name="conclusao">
										Prova de .NET e Java
									</p>
								</div>
							</div>
							
							
							
							
						</div>


						<hr>

						<h3 class="text-center">Linha do tempo</h3>
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
												<p>
													<label>Parecer:</label> ${status.descricaoParecer}
												</p>
												<p>
													<label>Usuário:</label> ${candidato.usuario.nome}
												</p>
											</div>
										</div>
									</li>
								</c:forEach>
							</c:forEach>

						</ul>
					</div>
				</section>
				<!-- /Section -->
			</div>
			<!-- /.padding-md -->
		</div>
	</div>
	</layout:put>
</layout:extends>