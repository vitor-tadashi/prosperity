<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Histórico de candidato</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>


</head>

<body>
	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>
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
									<p class="form-control-static" id="nome" name="nome">${candidato.nome}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Email:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="email" name="email">${candidato.email}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">CPF:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="cpf" name="cpf">38748842877</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">RG:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="rg" name="rg">${candidato.rg}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Data nascimento:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="dtNascimento"
										name="dtNascimento">
										<fmt:formatDate value="${candidato.dataNascimento}"
											pattern="dd/MM/yyyy" />
									</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Telefone:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="telefone" name="telefone">${candidato.contato.telefone}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Cidade:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="cidade" name="cidade">${candidato.endereco.cidade}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Estado:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="estado" name="estado">${candidato.endereco.estado}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Curso:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="nomeCurso" name="nomeCurso">${candidato.formacao.nomeCurso}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Instituição:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="instituicao"
										name="instituicao">${candidato.formacao.nomeInstituicao}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Tipo de curso:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="tipoCurso" name="tipoCurso">${candidato.formacao.tipoCurso.nome}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Situação atual:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="situacaoAtual"
										name="situacaoAtual">${candidato.formacao.situacaoAtual.descricao}</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Mês/Ano conclusão:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="conclusao" name="conclusao">
										<fmt:formatDate value="${candidato.formacao.dataConclusao}"
											pattern="dd/MM/yyyy" />
									</p>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label class="col-xs-5 control-label">Pretensão
									salarial:</label>
								<div class="col-xs-7">
									<p class="form-control-static" id="pretensao" name="pretensao">
										<fmt:formatNumber value="${candidato.valorPretensao}"
											minFractionDigits="2" type="currency" />
									</p>
								</div>
							</div>

							<div class="form-group col-xs-12">
								<label class="col-xs-2 control-label">Competências</label>
								<div class="col-xs-4"
									style="margin-left: 39px; padding-right: 30px">
									<table class="table table-condensed table-bordered">
										<c:forEach var="competencia" items="${candidato.competencias}">
											<tr>
												<td>${competencia.nome}</td>
												<td><span class="badge badge-info">${competencia.avaliacao.nome}</span></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							
							<div class="form-group col-xs-12">
								<label class="col-xs-2 control-label">Avaliadores</label>
								<div class="col-xs-4"
									style="margin-left: 39px; padding-right: 30px">
									<table class="table table-condensed table-bordered">
										<c:forEach var="avaliador" items="${candidato.avaliadores}">
											<tr>
												<td>${avaliador.nome}</td>
												<td><span class="badge badge-info">${avaliador.nome}</span></td>
											</tr>
										</c:forEach>
									</table>
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

	<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
</body>
</html>