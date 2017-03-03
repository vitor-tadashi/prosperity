<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aprovação de vagas</title>
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
	<!-- Modal visualizar-->


	<div class="modal fade" id="vaga-modal" data-target="#vaga-modal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Desenvolvedor .Net
						Pleno</h4>
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
							<section class="panel panel-default">
							<div class="panel-heading">Informações básicas</div>
							<div class="panel-body">
								<form>
									<div class="form-group row">
										<div>
											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Solicitante</label> <input
													type="name" class="form-control input-sm"
													id="exampleInputEmail1" placeholder="Vitor Tadashi"
													"Solicitante" disabled>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Local de trabalho</label>
												<div>
													<label class="label-radio inline"> <input
														id="interno" type="radio" name="inline-radio2" checked>
														<span class="custom-radio"></span> Interno
													</label> <label class="label-radio inline"> <input
														id="cliente" type="radio" name="inline-radio2" disabled>
														<span class="custom-radio"></span> Cliente
													</label>
												</div>
												<!-- /.col -->
											</div>
										</div>
									</div>

									<div class="form-group row">
										<div>
											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Cargo</label> <input
													type="name" class="form-control input-sm"
													id="exampleInputEmail1" placeholder="Analista de testes"
													"Cargo" disabled>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Tipo de vaga</label>
												<div>
													<label class="label-radio inline"> <input
														type="radio" name="inline-radio3" checked> <span
														class="custom-radio"></span> Real
													</label> <label class="label-radio inline"> <input
														type="radio" name="inline-radio3" disabled> <span
														class="custom-radio"></span> Prospecção
													</label> <label class="label-radio inline"> <input
														type="radio" name="inline-radio3" disabled> <span
														class="custom-radio"></span> Hunting
													</label>
												</div>
												<!-- /.col -->
											</div>
										</div>
									</div>

									<div class="form-group row">
										<div class="form-group col-md-4" style="margin-bottom: 0px">
											<label for="exampleInputEmail1">Senioridade da vaga</label> <input
												type="name" class="form-control input-sm"
												id="exampleInputEmail1" placeholder="Estágio" "Senioridade
												da Vaga" disabled>
										</div>
										<!-- /form-group -->

										<div class="form-group" style="margin-bottom: 0px">
											<label class="control-label">Horário</label>

											<div>
												<div class="form-group col-md-3">
													<div class="input-group bootstrap-timepicker"
														style="width: 105%;">
														<input class="timepicker form-control" type="text"
															/ value="08:00 AM" disabled> <span
															class="input-group-addon"><i class="fa fa-clock-o"></i></span>
													</div>
												</div>

												<div class="form-group col-md-1">
													<label style="margin-top: 7px">Às</label>
												</div>

												<div class="form-group col-md-3">
													<div class="input-group bootstrap-timepicker"
														style="width: 105%;">
														<input class="timepicker form-control" type="text"
															/ value="05:00 PM" disabled> <span
															class="input-group-addon"><i class="fa fa-clock-o"></i></span>
													</div>
												</div>
											</div>

										</div>
									</div>

									<div class="form-group row">

										<div class="">
											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputPassword1">Faixa salarial</label> <input
													type="password" class="form-control input-sm"
													id="exampleInputPassword1" placeholder="Faixa Salarial"
													disabled>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Aumento de quadro</label>
												<div>
													<label class="label-radio inline"> <input id="novo"
														type="radio" name="inline-radio" checked> <span
														class="custom-radio"> </span> Novo
													</label> <label class="label-radio inline"> <input id="sub"
														type="radio" name="inline-radio" disabled> <span
														class="custom-radio"> </span> Substituição
													</label>

												</div>
												<!-- /.col -->
											</div>
										</div>
									</div>

									<div class="form-group row">

										<div class="form-group col-md-6" style="margin-bottom: 0px">

											<div class="form-group">
												<label class="control-label">Data para inicio</label>
												<div class="form-group">
													<div class="input-group">
														<input type="text" value="01/01/2017"
															class="datepicker form-control" disabled> <span
															class="input-group-addon"><i
															class="fa fa-calendar"></i></span>
													</div>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>

										<div class="form-group col-md-6" style="margin-bottom: 0px">
											<div id="" class="">
												<label>Nome do substituido</label> <input type="text"
													class="form-control input-sm" placeholder="Evandro"
													disabled>
											</div>
										</div>

									</div>

								</form>
							</div>
							</section>
							<!-- /Section -->

							<section class="panel panel-default">
							<div class="row">
								<div class="panel-heading">Informações de projeto</div>

								<div class="form-group row"></div>
								<!-- /form-group -->
								<div class="form-group col-md-4">
									<label class="control-label">Projeto</label> <input readonly
										class="form-control default-cursor" value="Mobile">
								</div>
								<div class="form-group col-md-4">
									<label class="control-label">Cliente</label> <input readonly
										class="form-control" value="Carrefour">
								</div>
								<div class="form-group col-md-4">
									<label class="control-label">Gestor imediato</label> <input
										readonly class="form-control" value="Vitor Tadashi">
								</div>
							</div>

							</section>
							<!-- /panel -->

							<section class="panel panel-default">
							<div class="panel-heading">Formação acadêmica</div>
							<div class="panel-body relative">
								<div class="form-group">
									<textarea class="form-control" rows="3"></textarea>
								</div>
								<!-- /form-group -->

							</div>
							</section>
							<!-- /panel -->

							<section class="panel panel-default">
							<div class="panel-heading">Perfil comportamental</div>
							<div class="panel-body relative">
								<div class="form-group">
									<textarea class="form-control" rows="3"></textarea>
								</div>
								<!-- /form-group -->

							</div>
							</section>
							<!-- /panel -->

							<section class="panel panel-default">
							<div class="panel-heading">Perfil técnico</div>
							<div class="panel-body relative">

								<div class="form-group">
									<textarea class="form-control" rows="3"></textarea>
								</div>
								<!-- /form-group -->

							</div>
							</section>
							<!-- /panel -->
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">Imprimir</button>
							</div>
						</div>
					</div>
					<!-- /tab-content -->
				</div>
			</div>
		</div>
	</div>

	<c:import url="shared/dashboard.jsp"></c:import>
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
		<div class="padding-md">
			<div class="panel panel-default">
				<div class="panel-heading">Aprovação de vaga</div>
				<div class="panel-body">

					<table
						class="table table-bordered table-condensed table-hover table-striped"
						id=""
						style="font-size: 12px !important; vertical-align: middle !important;">
						<!-- Começo Tabela -->
						<thead>
							<tr class="text-center">
								<th class="text-center">Nome da vaga</th>
								<th class="text-center">Solicitante</th>
								<th class="text-center">Senioridade</th>
								<th class="text-center">Projeto</th>
								<th class="text-center">Cliente</th>
								<th class="text-center">Local de trabalho</th>
								<th class="text-center">Data abertura</th>
								<th class="text-center">Data encerramento</th>
								<th class="text-center">Ações</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<tr>
								<td>Desenvolvedor</td>
								<td>Vitor Tadashi</td>
								<td>Senior</td>
								<td>Projeto Web</td>
								<td>Carrefour</td>
								<td>Interno</td>
								<td>17/02/2017</td>
								<td>01/03/2017</td>
								<td>
									<div class="btn-group">
										<!-- Começo Botão -->
										<button class="btn btn-sm dropdown-toggle btn-info"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<i class="fa fa-cogs fa-lg"></i> <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#vaga-modal" data-toggle="modal"><i
													class="fa fa-eye">&nbsp</i>Visualizar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-check fa-lg"></i>
													Aprovar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-times fa-lg"></i>
													Reprovar</a></li>
										</ul>
									</div> <!-- Fim Botão -->
								</td>
							</tr>
							<tr>
								<td>Desenvolvedor</td>
								<td>Vitor Tadashi</td>
								<td>Senior</td>
								<td>Projeto Web</td>
								<td>Carrefour</td>
								<td>Interno</td>
								<td>17/02/2017</td>
								<td>01/03/2017</td>
								<td>
									<div class="btn-group">
										<!-- Começo Botão -->
										<button class="btn btn-sm dropdown-toggle btn-info"
											data-toggle="dropdown">
											<i class="fa fa-cogs fa-lg"></i> <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#vaga-modal" data-toggle="modal"><i
													class="fa fa-eye">&nbsp</i>Visualizar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-check fa-lg"></i>
													Aprovar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-times fa-lg"></i>
													Reprovar</a></li>
										</ul>
									</div> <!-- Fim Botão -->
								</td>
							</tr>
							<tr>
								<td>Analista</td>
								<td>Marcelo</td>
								<td>Junior</td>
								<td>Mobile</td>
								<td>Alelo</td>
								<td>Interno</td>
								<td>17/02/2017</td>
								<td>01/03/2017</td>
								<td>
									<div class="btn-group">
										<!-- Começo Botão -->
										<button class="btn btn-sm dropdown-toggle btn-info"
											data-toggle="dropdown">
											<i class="fa fa-cogs fa-lg"></i> <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#vaga-modal" data-toggle="modal"><i
													class="fa fa-eye">&nbsp</i>Visualizar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-check fa-lg"></i>
													Aprovar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-times fa-lg"></i>
													Reprovar</a></li>
										</ul>
									</div> <!-- Fim Botão -->
								</td>
							</tr>
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
	<c:import url="shared/footer.jsp"></c:import>
	<c:import url="shared/js.jsp"></c:import>
</body>
</html>