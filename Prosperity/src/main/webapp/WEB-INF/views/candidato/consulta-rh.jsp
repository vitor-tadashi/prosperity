<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Consulta RH</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->

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

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!--    Modais   -->
	<!-- Modal Avaliação de Competencias -->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 style="text-align: center;">Gestão de candidato</h4>
				</div>
				<div class="modal-body">
					<div class="panel-body">
						<form class="form-border" id="formCadastro" novalidate="">
							<div class="panel-tab clearfix">
								<ul class="tab-bar wizard-demo" id="wizardDemo">
									<li class="active tab-verity"><a href="#first"
										data-toggle="tab"><i class="fa fa-user"></i> Informações
											de entrevista</a></li>
									<li class="tab-verity"><a href="#second" data-toggle="tab"
										class="text-success"><i class="fa fa-pencil"></i> Processo
											de seleção</a></li>
									<li class="tab-verity"><a href="#third" data-toggle="tab"
										class="text-success"><i class="fa fa-briefcase"></i>
											Avaliação de competências</a></li>
									<li class="tab-verity"><a href="#fourth" data-toggle="tab"
										class="text-success"><i class="fa fa-money"></i> Proposta</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="first">
										<div class="row">
											<div>
												<div class="form-group col-md-6">
													<label for="exampleInputEmail1">Nome do candidato:</label>
													<input type="text" class="form-control input-sm"
														id="exampleInputEmail1" placeholder="Nome do candidato"
														data-required="true" name="nome">
												</div>
												<!-- /form-group -->
											</div>
										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<label for="exampleInputEmail1">Vaga:</label> 
												<select
													class="form-control chzn-select" name="vagas">
													<c:forEach var="vaga" items="${listaVaga}">
														<option value="${vaga.id}">${vaga.nomeVaga}</option>
													</c:forEach>
												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label for="exampleInputEmail1">Senioridade da vaga:</label>
												<select class="form-control chzn-select" name="senioridade">
													<c:forEach var="senioridade" items="${listaSenioridade}">
														<option value="${senioridade.id}" ${senioridade.nome}></option>
													</c:forEach>
												</select>
											</div>
											<!-- /form-group -->
										</div>
										<!-- /-row -->
										<div class="row">
											<div class="form-group col-md-12">
												<div class="panel panel-default">
													<div class="panel-heading">
														<label for="exampleInputEmail1">Avaliadores:</label>
													</div>
													<div class="panel-body relative"name="nmPerfil">
														<select multiple="multiple" id="selectedBox1"
															class="select-box pull-left form-control">
															<option value="1">Taiama</option>
															<option value="2">Melissa</option>
															<option value="3">Juliana</option>
														</select>

														<div class="select-box-option">
															<a class="btn btn-sm btn-default" id="btnRemove"> <i
																class="fa fa-angle-left"></i>
															</a> <a class="btn btn-sm btn-default" id="btnSelect"> <i
																class="fa fa-angle-right"></i>
															</a>
															<div class="seperator"></div>
															<a class="btn btn-sm btn-default" id="btnRemoveAll">
																<i class="fa fa-angle-double-left"></i>
															</a> <a class="btn btn-sm btn-default" id="btnSelectAll">
																<i class="fa fa-angle-double-right"></i>
															</a>
														</div>

														<select multiple="multiple" id="selectedBox2"
															class="select-box pull-right form-control" >
															<option>Vitor</option>
															<option>Evandro</option>
															<option>Suelen</option>
															<option>Rodrigo</option>
														</select>
													</div>
												</div>
												<!-- /panel -->
											</div>
											<!-- /form-group -->
										</div>
										<div class="form-group col-md-6">
											<div class="form-group">
												<label class="control-label">Data do último contato:</label>
												<div class="form-group" name="dtUltimoContato">
													<div class="input-group">
														<input type="text" value="01/01/2017"
															class="datepicker form-control"> <span
															class="input-group-addon"><i
															class="fa fa-calendar"></i></span>
													</div>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<div class="form-group">
													<label class="control-label">Data de entrevista:</label>
													<div class="form-group" name="dtEntrevista">
														<div class="input-group">
															<input type="text" value="00/00/0000"
																class="datepicker form-control" name=""> <span
																class="input-group-addon"><i
																class="fa fa-calendar"></i></span>
														</div>
													</div>
													<!-- /.col -->
												</div>
												<!-- /form-group -->
											</div>
											<!-- /form-group -->
										</div>
										<!-- /form-group -->
										<div class="form-group col-md-6">
											<div class="form-group">
												<label class="control-label">Parecer:</label>
												<div class="form-group">
													<textarea class="form-control" id="message-text"
														style="margin-left: 10px; width: 570px" name="parecer"></textarea>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>
										<!-- /form-group -->
									</div>
									<div class="tab-pane fade" id="second">
										<section id="dadosInterno" class="panel panel-default">
											<div class="panel-body">
												<label>Etapas dos processos de seleção: </label>
												<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->
												<form name="form1" action="paginaPHPouASP" method="post">
													<input class="btn btn-xs btn-success" type="button"
														value="Adicionar etapa" onclick="AddCampos()" name=""> <br>
													<br>
													<script type="text/javascript">
														//Escrevendo o código-fonte HTML e ocultando os campos criados:
														for (iLoop = 1; iLoop <= totalCampos; iLoop++) {
															document
																	.write("<span id='linha"+iLoop+"' style='display:none'> <select class='btn btn-default btn-xs dropdown-toggle' style='width: 160px;'><option value='0'>Selecione etapa</option><option value='1'>Prova Prática</option><option value='2'>Prova teórica</option><option value='3'>Dinâmica de Grupo</option></select> <input type='text' id='arq"+iLoop+"' name='arq"+iLoop+"'> <input class='btn btn-xs btn-danger' type='button' value='Remover' onclick='RemoverCampos(\""
																			+ iLoop
																			+ "\")'></span><br>");
														}
													</script>
													<input type="hidden" name="hidden2" id="hidden2">
												</form>
												<div class="form-group">
													<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->
													<label>Parecer técnico: </label>
													<textarea class="form-control" id="message-text"
														style="margin-left: 10px; width: 570px" name="parecer"></textarea>
												</div>
											</div>
										</section>
									</div>
									<div class="tab-pane fade" id="fourth">
										<section class="panel panel-default">
											<div class="panel-heading">
												<label for="exampleInputEmail1">Proposta:</label>
												<textarea id="wysihtml5-textarea"
													placeholder="Digite ..." class="form-control"
													rows="6" name=""></textarea>
											</div>
										</section>
										<!-- /panel -->
									</div>
									<div class="tab-pane fade" id="third">
										<section class="panel panel-default">
											<div class="panel-heading text-center">
												<label for="exampleInputEmail1">Avaliação de competências</label>
											</div>
											<table class="table" style="font-size: 10px">
												<thead class="text-center">
													<tr class="text-center">
														<th class="text-center">Competências</th>
														<th>Insatisfatório</th>
														<th>Em Desenvolvimento</th>
														<th>Atende as Expectativas</th>
														<th>Supera as Expectativas</th>
													</tr>
												</thead>
												<tbody class="text-center">
													<tr>
														<td>Desenvolvimento</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio1">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio1">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio1">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio1">
																<span class="custom-radio"></span>
														</label></td>
													</tr>
													<tr>
														<td>Profundidade</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio2">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio2">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio2">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio2">
																<span class="custom-radio"></span>
														</label></td>
													</tr>
													<tr>
														<td>Planejamento</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio3">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio3">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio3">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio3">
																<span class="custom-radio"></span>
														</label></td>
													</tr>
													<tr>
														<td>Execução e Entrega</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio5">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio5">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio5">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio5">
																<span class="custom-radio"></span>
														</label></td>
													</tr>
													<tr>
														<td>Relacionamento</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio4">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio4">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio4">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio"> <span
																class="custom-radio"></span>
														</label></td>
													</tr>
													<tr>
														<td>Pessoas</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio6">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio6">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio6">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio6">
																<span class="custom-radio"></span>
														</label></td>
													</tr>
													<tr>
														<td>Comercial</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio7">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio7">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio7">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio7">
																<span class="custom-radio"></span>
														</label></td>
													</tr>
													<tr>
														<td>Financeiro</td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio8">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio8">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio8">
																<span class="custom-radio"></span>
														</label></td>
														<td><label class="label-radio inline"> <input
																id="interno" type="radio" name="inline-radio8">
																<span class="custom-radio"></span>
														</label></td>
													</tr>
												</tbody>
											</table>
									</div>
									</section>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-footer ">
						<button type="submit" class="btn btn-sm btn-primary pull-right"
							id="nextStep">Salvar</button>
						<button type="submit" class="btn btn-sm btn-danger">
							<i class="fa fa-times fa-lg"></i>&nbsp;Reprovar
						</button>
						<button type="submit" class="btn btn-sm btn-success">
							<i class="fa fa-check fa-lg"></i>&nbsp;Aprovar
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Modal Feedback-->
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
					<h4 class="modal-title" id="modalLabel">Fechar vaga</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir esta vaga?</div>
				<div class="modal-footer">
					<a id="excluir" href="#">
						<button type="button" class="btn btn-danger">Sim</button>
					</a>
					<button type="button" class="btn btn-success" data-dismiss="modal">Não</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal delete-->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="index.html"> Home</a></li>
				<li>Consultar</li>
				<li class="active">Candidatos - RH</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<div class="padding-md">
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading">Consultar candidatos - RH</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-2">
										<label for="exampleInputEmail1">Nome: </label>
										<div class="search-block">
											<div class="input-group">
												<input type="text" class="form-control input-sm"
													placeholder="Nome" name="nome">
											</div>
											<!-- /input-group -->
										</div>
										<!-- /search-block -->
									</div>
									<div class="col-md-2">
										<label for="exampleInputEmail1">Cargo</label> <select
											class="form-control inline" name="cargo">							
											<c:forEach var="cargo" items="${listaCargo}">
															<option value="${cargo.id}">${cargo.nome}</option>
														</c:forEach>
										</select>
									</div>
									<div class="col-md-1">
										<label for="exampleInputEmail1">Salário</label> <input
											type="text" class="form-control" placeholder="De"
											style="width: 80px">
									</div>
									<div class="col-md-1">
										<label for="exampleInputEmail1">&nbsp;</label> <input
											type="text" class="form-control" placeholder="Até"
											style="width: 80px">
									</div>
									<div class="col-md-3">
										<label for="exampleInputEmail1">Data:</label>
										<div class="input-group">
											<input type="date" class="form-control"> <span
												class="input-group-addon">até</span> <input type="date"
												class="form-control">
										</div>
									</div>
									<div class="col-md-2 col-md-offset-1">
										<a class="btn btn-primary pull-right "
											style="margin-top: 22px">Filtrar</a>
									</div>
								</div>
								<!-- /.row -->
							</div>
							<!-- /.panel-body -->
							<table
								class="table table-bordered table-condensed table-hover table-striped"
								id=""
								style="font-size: 12px !important; vertical-align: middle !important;">
								<thead>
									<tr>
										<th class="text-center">Nome do candidato</th>
										<th class="text-center">Vaga</th>
										<th class="text-center">Pretensão</th>
										<th class="text-center">Data de abertura</th>
										<th class="text-center">Data de aprovação</th>
										<th class="text-center">Status</th>
										<th class="text-center">Ações</th>
									</tr>
								</thead>
								<tbody class="text-center">
									<c:forEach var="candidato" items="${candidatos}">
										<tr>
											<td>${candidato.nome}</td>
											<td>${candidato.vagas[0].nome}</td>
											<td>${candidato.valorPretensao}</td>
											<td>${candidato.dataAbertura}</td>
											<td>${candidato.dataFechamento}</td>
											<td>${candidato.ultimoStatus.status.nome}</td>
											<td><span class="label label-analiseRH">Em análise do RH</span></td>
											<td><span class="line"></span>
												<div class="btn-group">
													
													<!-- comeco do botao -->
													<button type="button"
														class="btn btn-info dropdown-toggle btn-sm"
														data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">
														<i class="fa fa-cogs fa-lg">&nbsp; </i><span class="caret"></span>
													</button>
													<ul class="dropdown-menu slidedown btnAlinhado">
														<li><a href="#aprovado-modal" data-toggle="modal"
															data-toggle="modal" data-target=".bs-example-modal-lg"><i
																class="fa fa-tasks fa-lg"></i>&nbsp;Gestão de candidato</a></li>
														<li class="divider"></li>
														<li><a href="#"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>

														<li class="divider"></li>
														<li><a href="#delete-modal" data-toggle="modal"><i
																class="fa fa-trash-o fa-lg">&nbsp;</i>Fechar vaga</a></li>
													</ul>
												</div> <!-- /fim botao --></td>
										</tr>
									</c:forEach>
									<!-- fim do botao -->
									<!-- <tr>
										<td>Kevin Durant</td>
										<td>Diretor</td>
										<td>R$7.500</td>
										<td>17/02/2015</td>
										<td>25/07/2016</td>
										<td><span class="label label-analiseTecnica">Em
												análise técnica</span></td>
										<td class="text-center"><span class="line"></span>
											<div class="btn-group">
												começo botao
												<button type="button"
													class="btn btn-info dropdown-toggle btn-sm"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class="fa fa-cogs fa-lg">&nbsp; </i><span class="caret"></span>
												</button>
												<ul class="dropdown-menu slidedown btnAlinhado">
													<li><a href="#aprovado-modal" data-toggle="modal"
														data-toggle="modal" data-target=".bs-example-modal-lg"><i
															class="fa fa-tasks fa-lg"></i>&nbsp;Gestão de candidato</a></li>
													<li class="divider"></li>
													<li><a href="#"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>

													<li class="divider"></li>
													<li><a href="#delete-modal" data-toggle="modal"><i
															class="fa fa-trash-o fa-lg">&nbsp;</i>Fechar vaga</a></li>
												</ul>
											</div> /fim botao</td>
									</tr> -->
									<!-- <tr class="text-center">
										<td>James Harden</td>
										<td>Desenvolvedor</td>
										<td>R$1000</td>
										<td>17/02/2015</td>
										<td>09/11/2017</td>
										<td><span class="label label-reprovado">Reprovado</span></td>
										<td class="text-center"><span class="line"></span>
											<div class="btn-group">
												começo botao
												<button type="button"
													class="btn btn-info dropdown-toggle btn-sm"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class="fa fa-cogs fa-lg">&nbsp; </i><span class="caret"></span>
												</button>
												<ul class="dropdown-menu slidedown btnAlinhado">
													<li><a href="#aprovado-modal" data-toggle="modal"
														data-toggle="modal" data-target=".bs-example-modal-lg"><i
															class="fa fa-tasks fa-lg"></i>&nbsp;Gestão de candidato</a></li>
													<li class="divider"></li>
													<li><a href="#"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>
													<li class="divider"></li>
													<li><a href="#delete-modal" data-toggle="modal"><i
															class="fa fa-trash-o fa-lg">&nbsp;</i>Fechar vaga</a></li>
												</ul>
											</div> /fim botao</td>
									</tr>
									<tr class="text-center">
										<td>Michael Jordan</td>
										<td>Desenvolvedor</td>
										<td>R$1000</td>
										<td>17/02/2015</td>
										<td>09/11/2017</td>
										<td><span class="label label-stand">Candidatura</span></td>
										<td class="text-center"><span class="line"></span>
											<div class="btn-group">
												começo botao
												<button type="button"
													class="btn btn-info dropdown-toggle btn-sm"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class="fa fa-cogs fa-lg">&nbsp; </i><span class="caret"></span>
												</button>
												<ul class="dropdown-menu slidedown btnAlinhado">
													<li><a href="#aprovado-modal" data-toggle="modal"
														data-toggle="modal" data-target=".bs-example-modal-lg"><i
															class="fa fa-tasks fa-lg"></i>&nbsp;Gestão de candidato</a></li>
													<li class="divider"></li>
													<li><a href="#"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>
													<li class="divider"></li>
													<li><a href="#delete-modal" data-toggle="modal"><i
															class="fa fa-trash-o fa-lg">&nbsp;</i>Fechar vaga</a></li>
												</ul>
											</div> /fim botao</td>
									</tr>
									<tr>
										<td>Kyrie Irving</td>
										<td>Desenvolvedor</td>
										<td>R$3.000</td>
										<td>08/11/2016</td>
										<td>31/12/2016</td>
										<td><span class="label label-contratado" style="">Contratado</span>
										</td>
										<td>
											<div class="btn-group">
												começo botao
												<button type="button"
													class="btn btn-info dropdown-toggle btn-sm"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class="fa fa-cogs fa-lg">&nbsp; </i><span class="caret"></span>
												</button>
												<ul class="dropdown-menu slidedown btnAlinhado">
													<li><a href="#aprovado-modal" data-toggle="modal"
														data-toggle="modal" data-target=".bs-example-modal-lg"><i
															class="fa fa-tasks fa-lg"></i>&nbsp;Gestão de candidato</a></li>
													<li class="divider"></li>
													<li><a href="#"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>
													<li class="divider"></li>
													<li><a href="#delete-modal" data-toggle="modal"><i
															class="fa fa-trash-o fa-lg">&nbsp;</i>Fechar vaga</a></li>
												</ul>
											</div> /fim botao
										</td>
									</tr>
									<tr>
										<td>LeBron James</td>
										<td>Desenvolvedor</td>
										<td>R$3.000</td>
										<td>08/11/2016</td>
										<td>31/04/2017</td>
										<td><span class="label label-aprovadoPendente" style="">Proposta</span>
										</td>
										<td>
											<div class="btn-group">
												começo botao
												<button type="button"
													class="btn btn-info dropdown-toggle btn-sm"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class="fa fa-cogs fa-lg">&nbsp; </i><span class="caret"></span>
												</button>
												<ul class="dropdown-menu slidedown btnAlinhado">
													<li><a href="#aprovado-modal" data-toggle="modal"
														data-toggle="modal" data-target=".bs-example-modal-lg"><i
															class="fa fa-tasks fa-lg"></i>&nbsp;Gestão de candidato</a></li>
													<li class="divider"></li>
													<li><a href="#"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>
													<li class="divider"></li>
													<li><a href="#delete-modal" data-toggle="modal"><i
															class="fa fa-trash-o fa-lg">&nbsp;</i>Fechar vaga</a></li>
												</ul>
											</div> /fim botao -->
									</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- fim da div panel -->
						<div class="panel-footer clearfix">
							<ul class="pagination pagination-xs m-top-none pull-right">
								<li class="disabled"><a href="#">Anterior</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">Próxima</a></li>
							</ul>
						</div>
					</div>
					<!-- /col-md-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.paddin.md -->
		</div>
		<!-- /.container -->
		<a href="" id="scroll-to-top" class="hidden-print"><i
			class="fa fa-chevron-up"></i></a>
		<!-- /Modal -->
		<div class="modal fade" id="formModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4>Modal with form</h4>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label>Username</label> <input type="text"
									class="form-control input-sm" placeholder="Email Address">
							</div>
							<div class="form-group">
								<label>Password</label> <input type="password"
									class="form-control input-sm" placeholder="Password">
							</div>
							<div class="form-group">
								<label class="label-checkbox"> <input type="checkbox"
									class="regular-checkbox" /> <span class="custom-checkbox"></span>
									Remember me
								</label>
							</div>
							<div class="form-group text-right">
								<a href="#" class="btn btn-success">Sign in</a> <a href="#"
									class="btn btn-success">Sign up</a>
							</div>
						</form>
					</div>
				</div>
				<!-- /wrapper -->
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>

	<script>
		$(function() {
			$('#dataTable').dataTable({
				"bJQueryUI" : true,
				"sPaginationType" : "full_numbers"
			});

			$('#chk-all').click(
					function() {
						if ($(this).is(':checked')) {
							$('#responsiveTable').find('.chk-row').each(
									function() {
										$(this).prop('checked', true);
										$(this).parent().parent().parent()
												.addClass('selected');
									});
						} else {
							$('#responsiveTable').find('.chk-row').each(
									function() {
										$(this).prop('checked', false);
										$(this).parent().parent().parent()
												.removeClass('selected');
									});
						}
					});
		});
	</script>
	<script type="text/javascript">
		//Total máximo de campos que você permitirá criar em seu site:
		var totalCampos = 4;

		//Não altere os valores abaixo, pois são variáveis controle;
		var iLoop = 1;
		var iCount = 0;
		var linhaAtual;

		function AddCampos() {
			var hidden1 = document.getElementById("hidden1");
			var hidden2 = document.getElementById("hidden2");

			//Executar apenas se houver possibilidade de inserção de novos campos:
			if (iCount < totalCampos) {

				//Limpar hidden1, para atualizar a lista dos campos que ainda estão vazios:
				hidden2.value = "";

				//Atualizando a lista dos campos que estão ocultos.
				//Essa lista ficará armazenada temporiariamente em hidden2;
				for (iLoop = 1; iLoop <= totalCampos; iLoop++) {
					if (document.getElementById("linha" + iLoop).style.display == "none") {
						if (hidden2.value == "") {
							hidden2.value = "linha" + iLoop;
						} else {
							hidden2.value += ",linha" + iLoop;
						}
					}
				}
				//Quebrando a lista que foi armazenada em hidden2 em array:

				linhasOcultas = hidden2.value.split(",");

				if (linhasOcultas.length > 0) {
					//Tornar visível o primeiro elemento de linhasOcultas:
					document.getElementById(linhasOcultas[0]).style.display = "block";
					iCount++;

					//Acrescentando o índice zero a hidden1:
					if (hidden1.value == "") {
						hidden1.value = linhasOcultas[0];
					} else {
						hidden1.value += "," + linhasOcultas[0];
					}

					/*Retirar a opção acima da lista de itens ocultos: <-------- OPCIONAL!!!
					if (hidden2.value.indexOf(","+linhasOcultas[0]) != -1) {
					        hidden2.value = hidden2.value.replace(linhasOcultas[0]+",","");
					}else if (hidden2.indexOf(linhasOcultas[0]+",") == 0) {
					        hidden2.value = hidden2.value.replace(linhasOcultas[0]+",","");
					}else{
					        hidden2.value = "";
					}
					 */
				}
			}
		}

		function RemoverCampos(id) {
			//Criando ponteiro para hidden1:        
			var hidden1 = document.getElementById("hidden1");

			//Pegar o valor do campo que será excluído:
			var campoValor = document.getElementById("arq" + id).value;
			//Se o campo não tiver nenhum valor, atribuir a string: vazio:
			if (campoValor == "") {
				campoValor = "vazio";
			}

			if (confirm("O campo que contém o valor:\n» " + campoValor
					+ "\nserá excluído!\n\nDeseja prosseguir?")) {
				document.getElementById("linha" + id).style.display = "none";
				iCount--;

				//Removendo o valor de hidden1:
				if (hidden1.value.indexOf(",linha" + id) != -1) {
					hidden1.value = hidden1.value.replace(",linha" + id, "");
				} else if (hidden1.value.indexOf("linha" + id + ",") == 0) {
					hidden1.value = hidden1.value.replace("linha" + id + ",",
							"");
				} else {
					hidden1.value = "";
				}
			}
		}
	</script>
</body>
</html>