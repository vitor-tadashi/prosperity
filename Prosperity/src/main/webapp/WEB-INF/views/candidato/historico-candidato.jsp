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

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>
</head>
<style>
.page-header h1 {
	font-size: 3.26em;
	text-align: center;
	color: #efefef;
	text-shadow: 1px 1px 0 #000;
}

/** timeline box structure **/
.timeline {
	list-style: none;
	padding: 20px 0 20px;
	position: relative;
}

.timeline:before {
	top: 0;
	bottom: 0;
	position: absolute;
	content: " ";
	width: 3px;
	background-color: #eee;
	left: 50%;
	margin-left: -1.5px;
}

.tldate {
	display: block;
	width: 200px;
	background: #414141;
	border: 3px solid #212121;
	color: #ededed;
	margin: 0 auto;
	padding: 3px 0;
	font-weight: bold;
	text-align: center;
	-webkit-box-shadow: 0 0 11px rgba(0, 0, 0, 0.35);
}

.timeline li {
	margin-bottom: 25px;
	position: relative;
}

.timeline li:before, .timeline li:after {
	content: " ";
	display: table;
}

.timeline li:after {
	clear: both;
}

.timeline li:before, .timeline li:after {
	content: " ";
	display: table;
}

/** timeline panels **/
.timeline li .timeline-panel {
	width: 46%;
	float: left;
	background: #fff;
	border: 1px solid #d4d4d4;
	padding: 20px;
	position: relative;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	-webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.15);
	box-shadow: 0 1px 6px rgba(0, 0, 0, 0.15);
}

/** panel arrows **/
.timeline li .timeline-panel:before {
	position: absolute;
	top: 26px;
	right: -15px;
	display: inline-block;
	border-top: 15px solid transparent;
	border-left: 15px solid #ccc;
	border-right: 0 solid #ccc;
	border-bottom: 15px solid transparent;
	content: " ";
}

.timeline li .timeline-panel:after {
	position: absolute;
	top: 27px;
	right: -14px;
	display: inline-block;
	border-top: 14px solid transparent;
	border-left: 14px solid #fff;
	border-right: 0 solid #fff;
	border-bottom: 14px solid transparent;
	content: " ";
}

.timeline li .timeline-panel.noarrow:before, .timeline li .timeline-panel.noarrow:after
	{
	top: 0;
	right: 0;
	display: none;
	border: 0;
}

.timeline li.timeline-inverted .timeline-panel {
	float: right;
}

.timeline li.timeline-inverted .timeline-panel:before {
	border-left-width: 0;
	border-right-width: 15px;
	left: -15px;
	right: auto;
}

.timeline li.timeline-inverted .timeline-panel:after {
	border-left-width: 0;
	border-right-width: 14px;
	left: -14px;
	right: auto;
}

/** timeline circle icons **/
.timeline li .tl-circ {
	position: absolute;
	top: 23px;
	left: 50%;
	text-align: center;
	background: #6a8db3;
	color: #fff;
	width: 35px;
	height: 35px;
	line-height: 35px;
	margin-left: -16px;
	border: 3px solid #90acc7;
	border-top-right-radius: 50%;
	border-top-left-radius: 50%;
	border-bottom-right-radius: 50%;
	border-bottom-left-radius: 50%;
	z-index: 99999;
}

/** timeline content **/
.tl-heading h4 {
	margin: 0;
	color: #c25b4e;
}

.tl-body p, .tl-body ul {
	margin-bottom: 0;
}

.tl-body>p+p {
	margin-top: 5px;
}

/** media queries **/
@media ( max-width : 991px) {
	.timeline li .timeline-panel {
		width: 44%;
	}
}

@media ( max-width : 700px) {
	.page-header h1 {
		font-size: 1.8em;
	}
	ul.timeline:before {
		left: 40px;
	}
	.tldate {
		width: 140px;
	}
	ul.timeline li .timeline-panel {
		width: calc(100% - 90px);
		width: -moz-calc(100% - 90px);
		width: -webkit-calc(100% - 90px);
	}
	ul.timeline li .tl-circ {
		top: 22px;
		left: 22px;
		margin-left: 0;
	}
	ul.timeline>li>.tldate {
		margin: 0;
	}
	ul.timeline>li>.timeline-panel {
		float: right;
	}
	ul.timeline>li>.timeline-panel:before {
		border-left-width: 0;
		border-right-width: 15px;
		left: -15px;
		right: auto;
	}
	ul.timeline>li>.timeline-panel:after {
		border-left-width: 0;
		border-right-width: 14px;
		left: -14px;
		right: auto;
	}
}

.timeline-title {
	font-size: 16px;
}

.label-stand, .badge-stand {
	background-color: #9b59b6;
	color: #fff;
}

.label-aprovadoPendente, .badge-stand {
	background-color: #2980b9;
	color: #fff;
}

.label-analiseRH, .badge-stand {
	background-color: #e67e22;
	color: #fff;
}

.label-analiseTecnica, .badge-stand {
	background-color: #f1c40f;
	color: #fff;
}

.label-reprovado, .badge-stand {
	background-color: #e74c3c;
	color: #fff;
}

.label-contratado, .badge-stand {
	background-color: #2ecc71;
	color: #fff;
}

.dropdown-menu {
	/*left: -115px !important;*/
	z-index: 1050;
}

.col-md-9 .label-radio {
	margin-right: 58px;
	margin-left: 20px;
}
</style>

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
									<p class="form-control-static" id="cpf" name="cpf">${candidato.cpf}</p>
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
												<td>${competencia.competencia.nome}</td>
												<td><span class="badge badge-info">${competencia.avaliacao.nome}</span></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>

						<hr>

						<h3 class="text-center">Linha do tempo</h3>
						<ul class="timeline">

							<li><div class="tldate">Fev 2017</div></li>

							<li>
								<div class="tl-circ"></div>
								<div class="timeline-panel">
									<div class="tl-heading">
										<h4>Parecer</h4>
										<p>
											<small class="text-muted"><i class="fa fa-calendar"></i>
												01/02/2017</small>
										</p>
									</div>
									<div class="tl-body">
										<p>O candidato foi considerado apto para as funções da
											vaga.</p>
										<p><label>Status: </label> Aprovado</p>
									</div>
								</div>
							</li>

							<li><div class="tldate">Jan 2017</div></li>

							<li class="timeline-inverted">
								<div class="tl-circ"></div>
								<div class="timeline-panel">
									<div class="tl-heading">
										<h4>Aprovado pelo Gestor de Projetos</h4>
										<p>
											<small class="text-muted"><i class="fa fa-calendar"></i>
												27/01/2017</small>
										</p>
									</div>
									<div class="tl-body">
										<p>O candidato possui boa comunicação, aparenta ser
											pró-ativo e possui vasto conhecimento na linguagem JAVA.</p>
									</div>
								</div>
							</li>
							<li>
								<div class="timeline-panel">
									<div class="tl-heading">
										<h4>Aprovado pelo RH</h4>
										<p>
											<small class="text-muted"><i class="fa fa-calendar"></i>
												20/01/2017</small>
										</p>
									</div>
									<div class="tl-body">
										<p>Realizado última etapa do processo seletivo, a próxima
											etapa será a entrevista com o gestor.</p>
									</div>
								</div>
							</li>
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