<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aprova��o vaga</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="shared/stylesheet.jsp"></c:import>
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
									class="fa fa-tags">&nbsp</i>Especifica��es</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
							<section class="panel panel-default">
							<div class="panel-heading">Informa��es b�sicas</div>
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
														class="custom-radio"></span> Prospec��o
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
												id="exampleInputEmail1" placeholder="Est�gio" "Senioridade
												da Vaga" disabled>
										</div>
										<!-- /form-group -->

										<div class="form-group" style="margin-bottom: 0px">
											<label class="control-label">Hor�rio</label>

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
													<label style="margin-top: 7px">�s</label>
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
								<div class="panel-heading">Informa��es de projeto</div>

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
	<!-- CORPO DA P�GINA -->
	<div class="padding-md">
		<div class="panel panel-default">
			<div class="panel-heading">Aprova��o de vaga</div>
			<div class="panel-body">

				<table
					class="table table-bordered table-condensed table-hover table-striped"
					id=""
					style="font-size: 12px !important; vertical-align: middle !important;">
					<!-- Come�o Tabela -->
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
							<th class="text-center">A��es</th>
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
									<!-- Come�o Bot�o -->
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
								</div> <!-- Fim Bot�o -->
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
									<!-- Come�o Bot�o -->
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
								</div> <!-- Fim Bot�o -->
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
									<!-- Come�o Bot�o -->
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
								</div> <!-- Fim Bot�o -->
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
	<c:import url="shared/footer.jsp"></c:import>
	<c:import url="shared/js.jsp"></c:import>
</body>
</html>