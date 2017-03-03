<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar vaga</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="shared/stylesheet.jsp"></c:import>

<style>
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
	left: -115px !important;
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
									class="fa fa-info-circle">&nbsp</i>Informa��es</a></li>
							<li><a data-toggle="tab" href="#menu1"><i
									class="fa fa-tags">&nbsp</i>Especifica��es</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
							<form>
								<section class="panel panel-default panel-body">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Data de abertura</label>
											<div class="form-group">
												<div class="input-group">
													<input type="text" value="01/01/2017"
														class="datepicker form-control" readonly> <span
														class="input-group-addon"><i class="fa fa-calendar"></i></span>
												</div>
											</div>
											<!-- /.col -->
										</div>
										<!-- /form-group -->
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Data de aprova��o</label>
											<div class="form-group">
												<div class="input-group">
													<input type="text" value="01/01/2017"
														class="datepicker form-control" readonly> <span
														class="input-group-addon"><i class="fa fa-calendar"></i></span>
												</div>
											</div>
											<!-- /.col -->
										</div>
										<!-- /form-group -->
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Data de fechamento</label>
											<div class="form-group">
												<div class="input-group">
													<input type="text" value="01/01/2017"
														class="datepicker form-control" readonly> <span
														class="input-group-addon"><i class="fa fa-calendar"></i></span>
												</div>
											</div>
											<!-- /.col -->
										</div>
										<!-- /form-group -->
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-3">
										<label for="">Candidatos</label> <input type="number"
											class="form-control input-sm" id="" min="0" value="123">
									</div>
									<!-- /form-group -->
								</div>
								</section>
							</form>
						</div>
						<div id="menu1" class="tab-pane fade">
							<section class="panel panel-default">
							<div class="panel-heading">Informa��es b�sicas</div>
							<div class="panel-body">
								<form>
									<div class="form-group row">
										<div>
											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Solicitante</label> <input
													type="name" class="form-control input-sm"
													id="exampleInputEmail1" placeholder="Solicitante"
													data-required="true">
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Local de trabalho</label>
												<div>
													<label class="label-radio inline"> <input
														id="interno" type="radio" name="inline-radio2" checked>
														<span class="custom-radio"></span> Interno
													</label> <label class="label-radio inline"> <input
														id="cliente" type="radio" name="inline-radio2"> <span
														class="custom-radio"></span> Cliente
													</label>
												</div>
												<!-- /.col -->
											</div>
										</div>
									</div>

									<div class="form-group row">
										<div>
											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Cargo</label> <select
													class="form-control chzn-select">
													<option>Analista de testes</option>
													<option>Analista de sistemas</option>
													<option>Desenvolvedor</option>
													<option>Gerente de projetos</option>
												</select>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<label for="exampleInputEmail1">Tipo de vaga</label>
												<div>
													<label class="label-radio inline"> <input
														type="radio" name="inline-radio3" checked> <span
														class="custom-radio"></span> Real
													</label> <label class="label-radio inline"> <input
														type="radio" name="inline-radio3"> <span
														class="custom-radio"></span> Prospec��o
													</label> <label class="label-radio inline"> <input
														type="radio" name="inline-radio3"> <span
														class="custom-radio"></span> Hunting
													</label>
												</div>
												<!-- /.col -->
											</div>
										</div>
									</div>

									<div class="form-group row">
										<div class="form-group col-md-4" style="margin-bottom: 0px">
											<label for="exampleInputEmail1">Senioridade da vaga</label> <select
												class="form-control chzn-select">
												<option>Est�gio</option>
												<option>J�nior</option>
												<option>Pleno</option>
												<option>Senior</option>
											</select>
										</div>
										<!-- /form-group -->

										<div class="form-group" style="margin-bottom: 0px">
											<label class="control-label">Hor�rio</label>

											<div>
												<div class="form-group col-md-3">
													<div class="input-group bootstrap-timepicker"
														style="width: 105%;">
														<input class="timepicker form-control" type="text"
															/ value="08:00 AM"> <span
															class="input-group-addon"><i class="fa fa-clock-o"></i></span>
													</div>
												</div>

												<div class="form-group col-md-1">
													<label style="margin-top: 7px">�s</label>
												</div>

												<div class="form-group col-md-3">
													<div class="input-group bootstrap-timepicker"
														style="width: 105%;">
														<input class="timepicker form-control" type="text"
															/ value="05:00 PM"> <span
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
														type="radio" name="inline-radio"> <span
														class="custom-radio"> </span> Substitui��o
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
															class="datepicker form-control"> <span
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
													class="form-control input-sm"
													placeholder="Nome do substituido">
											</div>
										</div>

									</div>

								</form>
							</div>
							</section>
							<!-- /Section -->
							<section class="panel panel-default">
							<div class="panel-heading">Forma��o acad�mica</div>
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
							<div class="panel-heading">Perfil t�cnico</div>
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
				<div class="modal-body">Deseja realmente fechar est� vaga?</div>
				<div class="modal-footer">
					<a href="#">
						<button id="fechaVaga" type="button" class="btn btn-primary"
							data-dismiss="modal">Sim</button>
					</a>
					<button type="button" class="btn btn-default" data-dismiss="modal">N�o</button>
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
				<div class="modal-body">Deseja realmente cancelar est� vaga?</div>
				<div class="modal-footer">
					<a href="#">
						<button id="excluiVaga" type="button" class="btn btn-primary"
							data-dismiss="modal">Sim</button>
					</a>
					<button type="button" class="btn btn-default" data-dismiss="modal">N�o</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal delete-->

	<c:import url="shared/dashboard.jsp"></c:import>

	<!--corpo -->
	<div id="main-container">
		<div class="padding-md">
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">Consulta de vagas</div>
						<!--<form class="form-inline">-->
						<div class="panel-body">

							<div class="row ">
								<div class="col-md-4">
									<div class="form-group">
										<label>Vaga</label> <select class="form-control">
											<!--chzn-select-->
											<option>Selecione:</option>
											<option>Desenvolvedor .Net Junior</option>
											<option>Desenvolvedor .Net Pleno</option>
											<option>Desenvolvedor .Net S�nior</option>
											<option>Analista Java Junior</option>
										</select>
									</div>
								</div>

								<div class="col-md-5">
									<label for="">Data</label>
									<div class="input-group">
										<input type="date" class="form-control"> <span
											class="input-group-addon">at�</span> <input type="date"
											class="form-control">
									</div>
								</div>

								<div class="col-md-2">
									<label for="cargo">Status</label> <select id="cargo"
										class="form-control" style="width: 130px;">
										<option value="0">Selecione:</option>
										<option value="1">Ativo</option>
										<option value="2">Fechado</option>
										<option value="3">Cancelado</option>
									</select>
								</div>

								<div class="text-right">
									<a href="#" style="text-decoration: none; color: #ffffff">
										<button class="btn btn-primary"
											style="margin-top: 22px; margin-right: 22px;">Filtrar</button>
									</a>
								</div>
							</div>
						</div>
						<!--</panel body>-->
						<table
							class="table table-bordered table-condensed table-hover table-striped"
							style="font-size: 12px; vertical-align: middle;">
							<thead>
								<tr>
									<th class="text-center">Vaga</th>
									<th class="text-center">Cliente</th>
									<th class="text-center">Local de trabalho</th>
									<th class="text-center">Data de abertura</th>
									<th class="text-center">Status</th>
									<th class="text-center">A��es</th>
								</tr>
							</thead>
							<tbody class="text-center">
								<tr>
									<td>Desenvolvedor .Net Junior</td>
									<td>Carrefour</td>
									<td>Alocado</td>
									<td>15/02/2017</td>
									<td><span id="tdStatus" class="label label-contratado">Ativo</span></td>
									<td>
										<div class="btn-group">
											<button class="btn btn-sm btn-info dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right slidedown">
												<li><a href="#vaga-modal" data-toggle="modal"><i
														class="fa fa-eye">&nbsp</i>Visualizar</a></li>
												<li class="divider"></li>
												<li><a href="#fecha-modal" data-toggle="modal"><i
														class="fa fa-lock">&nbsp</i>Fechar</a></li>
												<li class="divider "></li>
												<li><a href="#delete-modal" data-toggle="modal"><i
														class="fa fa-times">&nbsp</i>Cancelar</a></li>
											</ul>
										</div> <!-- /btn-group -->
									</td>
								</tr>
								<tr>
									<td>Analista de sistema</td>
									<td>Carrefour</td>
									<td>Interno</td>
									<td>15/02/2017</td>
									<td><span class="label label-analiseTecnica">Fechado</span></td>
									<td>
										<div class="btn-group">
											<button class="btn btn-sm btn-info dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right slidedown">
												<li><a href="#vaga-modal" data-toggle="modal"><i
														class="fa fa-eye ">&nbsp</i>Visualizar</a></li>
												<li class="divider "></li>
												<li><a href="# "><i class="fa fa-pencil ">&nbsp</i>Editar</a></li>
												<li class="divider "></li>
												<li><a href="#delete-modal" data-toggle="modal"><i
														class="fa fa-trash-o ">&nbsp</i>Excluir</a></li>
											</ul>
										</div> <!-- /btn-group -->
									</td>
								</tr>
								<tr>
									<td>Analista .NET Pleno</td>
									<td>Carrefour</td>
									<td>Alocado</td>
									<td>15/02/2017</td>
									<td><span class="label label-reprovado">Cancelado</span></td>
									<td>
										<div class="btn-group">
											<button class="btn btn-info btn-sm dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right slidedown">
												<li><a href="#vaga-modal" data-toggle="modal"><i
														class="fa fa-eye ">&nbsp</i>Visualizar</a></li>
												<li class="divider "></li>
												<li><a href="# "><i class="fa fa-pencil ">&nbsp</i>Editar</a></li>
												<li class="divider "></li>
												<li><a href="#delete-modal" data-toggle="modal"><i
														class="fa fa-trash-o ">&nbsp</i>Excluir</a></li>
											</ul>
										</div> <!-- /btn-group -->
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!--</panel default>-->
					<div class="panel-footer clearfix">
						<div class="row">
							<ul class="pagination pagination-xs m-top-none pull-right">
								<li class="disabled"><a href="#">Previous</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">Next</a></li>
							</ul>
						</div>
						<!--</div row>-->
					</div>
					<!--</panel footer>-->
				</div>
				<!--</col-sm-12>-->
			</div>
			<!--</row>-->
		</div>
		<!--</padding>-->
	</div>
	<!--</container>-->
	<!--</main container>-->
	<!--corpo -->

	<c:import url="shared/footer.jsp"></c:import>
	<c:import url="shared/js.jsp"></c:import>

	<script>
		$("#fechaVaga").click(
				function() {
					$("#tdStatus").toggleClass(
							"label-contratado label-analiseTecnica");
					$("#tdStatus").html("Fechado")
				});
		$("#excluiVaga").click(function() {
			$("#tdStatus").toggleClass("label-contratado label-reprovado");
			$("#tdStatus").html("Cancelado")
		});
	</script>
</body>
</html>