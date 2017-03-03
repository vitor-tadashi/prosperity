<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hist�rico de candidato</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="shared/stylesheet.jsp"></c:import>

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
</head>
<body>
	<c:import url="shared/dashboard.jsp"></c:import>
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						In�cio</a></li>
				<li class="active">Hist�rico candidato</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->

		<div class="padding-md">
			<div class="row">
				<section class="panel panel-default">
				<div class="panel-heading">Informa��es b�sicas</div>
				<div class="panel-body">
					<div class="row">
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Nome do candidato</label>
							<div class="col-xs-7">
								<p class="form-control-static">Jo�o da Silva</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Email</label>
							<div class="col-xs-7">
								<p class="form-control-static">joaosilva@verity.com</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">CPF</label>
							<div class="col-xs-7">
								<p class="form-control-static">123.456.789-10</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">RG</label>
							<div class="col-xs-7">
								<p class="form-control-static">15.124.234</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Data nascimento</label>
							<div class="col-xs-7">
								<p class="form-control-static">01/01/2000</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Idade</label>
							<div class="col-xs-7">
								<p class="form-control-static">27</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Telefone</label>
							<div class="col-xs-7">
								<p class="form-control-static">(99) 99999-9999</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Cidade</label>
							<div class="col-xs-7">
								<p class="form-control-static">S�o Paulo</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Estado</label>
							<div class="col-xs-7">
								<p class="form-control-static">SP</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Curso</label>
							<div class="col-xs-7">
								<p class="form-control-static">Engenharia da Computa��o</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Institui��o</label>
							<div class="col-xs-7">
								<p class="form-control-static">UNASP</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Tipo de curso</label>
							<div class="col-xs-7">
								<p class="form-control-static">Gradua��o</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Situa��o atual</label>
							<div class="col-xs-7">
								<p class="form-control-static">Cursando</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">M�s/Ano conclus�o</label>
							<div class="col-xs-7">
								<p class="form-control-static">07/2018</p>
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-xs-5 control-label">Pretens�o salarial</label>
							<div class="col-xs-7">
								<p class="form-control-static">R$ 1200,00</p>
							</div>
						</div>
						<div class="form-group col-xs-12">
							<label class="col-xs-2 control-label">Compet�ncias</label>
							<div class="col-xs-4"
								style="margin-left: 39px; padding-right: 30px">
								<table class="table table-condensed table-bordered">
									<tr>
										<td>Desenvolvimento</td>
										<td><span class="badge badge-info">Atende as
												expectativas</span></td>
									</tr>
									<tr>
										<td>Profundidade</td>
										<td><span class="badge badge-info">Atende as
												expectativas</span></td>
									</tr>
									<tr>
										<td>Planejamento</td>
										<td><span class="badge badge-info">Atende as
												expectativas</span></td>
									</tr>
									<tr>
										<td>Execu��o e entrega</td>
										<td><span class="badge badge-info">Atende as
												expectativas</span></td>
									</tr>
									<tr>
										<td>Pessoas</td>
										<td><span class="badge badge-info">Atende as
												expectativas</span></td>
									</tr>
									<tr>
										<td>Comercial e financeiro</td>
										<td><span class="badge badge-info">Atende as
												expectativas</span></td>
									</tr>
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
									<h4>Contrata��o</h4>
									<p>
										<small class="text-muted"><i class="fa fa-calendar"></i>
											01/02/2017</small>
									</p>
								</div>
								<div class="tl-body">
									<p>O candidato foi considerado apto para as fun��es da
										vaga.</p>
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
									<p>O candidato possui boa comunica��o, aparenta ser
										pr�-ativo e possui vasto conhecimento na linguagem JAVA.</p>
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
									<p>Realizado �ltima etapa do processo seletivo, a pr�xima
										etapa ser� a entrevista com o gestor.</p>
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

	<c:import url="shared/footer.jsp"></c:import>
	<c:import url="shared/js.jsp"></c:import>
</body>
</html>