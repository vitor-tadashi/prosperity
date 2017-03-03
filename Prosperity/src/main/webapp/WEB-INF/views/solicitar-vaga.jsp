<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Vaga</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="shared/stylesheet.jsp"></c:import>
<body>

	<c:import url="shared/dashboard.jsp"></c:import>
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						In�cio</a></li>
				<li class="active">Solicita��o de vaga</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="padding-md">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">Informa��es da vaga</div>
					<div class="panel-body">
						<form class="form-border" id="formCadastro" novalidate="">
							<div class="panel-tab clearfix">
								<ul class="tab-bar wizard-demo" id="wizardDemo">
									<li class="active tab-verity"><a href="#first"
										data-toggle="tab"><i class="fa fa-user"></i> Informa��es
											b�sicas</a></li>
									<li class="tab-verity"><a href="#second" data-toggle="tab"
										class="text-success"><i class="fa fa-pencil"></i> Dados do
											projeto</a></li>
									<li class="tab-verity"><a href="#third" data-toggle="tab"
										class="text-success"><i class="fa fa-briefcase"></i>
											Perfil</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="first">
										<div class="row">
											<div>
												<div class="form-group col-md-6">
													<label for="exampleInputEmail1">Solicitante</label> <input
														type="name" class="form-control input-sm"
														id="exampleInputEmail1" placeholder="Solicitante"
														data-required="true">
												</div>
												<!-- /form-group -->

												<div class="form-group col-md-6">
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
												</div>
												<!-- /form-group -->
											</div>
										</div>
										<!-- /form-group -->

										<div class="row">

											<div class="form-group col-md-6">
												<label for="exampleInputEmail1">Cargo</label> <select
													class="form-control chzn-select">
													<option>Analista de testes</option>
													<option>Analista de sistemas</option>
													<option>Desenvolvedor</option>
													<option>Gerente de projetos</option>
												</select>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6">
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
											</div>
											<!-- /form-group -->

										</div>
										<!-- /form-group -->

										<div class="row">
											<div class="form-group col-md-6">
												<label for="exampleInputEmail1">Senioridade da vaga</label>
												<select class="form-control chzn-select">
													<option>Est�gio</option>
													<option>J�nior</option>
													<option>Pleno</option>
													<option>Senior</option>
												</select>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6">
												<label class="control-label">Hor�rio</label>

												<div>
													<div class="form-group col-md-5">
														<div class="input-group bootstrap-timepicker">
															<input class="timepicker form-control" type="text"
																value="08:00 AM"> <span
																class="input-group-addon"><i
																class="fa fa-clock-o"></i></span>
														</div>
													</div>
													<!-- /form-group -->

													<div class="form-group col-md-1">
														<label style="margin-top: 7px">�s</label>
													</div>
													<!-- /form-group -->

													<div class="form-group col-md-5">
														<div class="input-group bootstrap-timepicker">
															<input class="timepicker form-control" type="text"
																/ value="05:00 PM"> <span
																class="input-group-addon"><i
																class="fa fa-clock-o"></i></span>
														</div>
													</div>
													<!-- /form-group -->
												</div>

											</div>
											<!-- /form-group -->
										</div>

										<div class="row">

											<div class="form-group col-md-6">
												<label for="exampleInputEmail1">Proposta salarial</label> <input
													type="name" class="form-control input-sm"
													id="exampleInputEmail1" placeholder="R$"
													data-required="true">
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-6">
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
											<!-- /form-group -->

										</div>
										<!-- /form-group -->

										<div class="row">

											<div class="form-group col-md-6">
												<div class="form-group">
													<label class="control-label">Data para in�cio</label>
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
											<!-- /form-group -->

											<div id="nome" class="form-group col-md-6 hide">
												<label>Nome do substituido</label> <input type="text"
													class="form-control input-sm"
													placeholder="Nome do Substituido">
											</div>

										</div>
										<!-- /form-group -->

									</div>
									<div class="tab-pane fade" id="second">
										<section id="dadosInterno" class="panel panel-default">

										<div class="panel-body">

											<div class="form-group col-md-4" style="padding-left: 0px;">
												<label for="exampleInputEmail1">Nome do projeto</label> <select
													class="form-control chzn-select">
													<option>P20150806_001 - Biometria Facial no Front
														�nico</option>
													<option>P20160120_001 - Melhorias na abertura de
														Conta via internet</option>
													<option>P20160805_001 - Cart�o Gold</option>
													<option>P20150226_001 - Migra��o Servidores 2012</option>
												</select>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-4" style="padding-left: 0px;">
												<label for="exampleInputEmail1">Cliente</label> <select
													class="form-control chzn-select">
													<option>Cliente A</option>
													<option>Cliente B</option>
													<option>Cliente C</option>
												</select>
											</div>
											<!-- /form-group -->

											<div class="form-group col-md-4" style="padding-left: 0px;">
												<label for="exampleInputEmail1">Gestor imediato</label> <select
													class="form-control chzn-select">
													<option>Gabriela Nascimento</option>
													<option>Michela Senario</option>
													<option>Vitor Tadashi</option>
													<option>Vera Tavares</option>
												</select>
											</div>
											<!-- /form-group -->

										</div>
										</section>
										<!-- /Section-->

										<section id="dadosAlocacao" class="panel panel-default hide">

										<div class="panel-body">

											<div class="col-md-6">

												<div class="form-group" style="padding-left: 0px;">
													<label for="exampleInputEmail1">Nome do Projeto</label> <select
														class="form-control chzn-select">
														<option>P20150806_001 - Biometria Facial no Front
															�nico</option>
														<option>P20160120_001 - Melhorias na abertura de
															Conta via internet</option>
														<option>P20160805_001 - Cart�o Gold</option>
														<option>P20150226_001 - Migra��o Servidores 2012</option>
													</select>
												</div>
												<!-- /form-group -->

												<div class="form-group">
													<label for="exampleInputEmail1">Cliente</label> <input
														type="text" class="form-control input-sm"
														id="exampleInputEmail1" placeholder="Cliente"
														data-required="true">
												</div>
												<!-- /form-group -->

												<div class="form-group" style="padding-left: 0px;">
													<label for="exampleInputEmail1">Gestor imediato</label> <select
														class="form-control chzn-select">
														<option>Gabriela Nascimento</option>
														<option>Michela Senario</option>
														<option>Vitor Tadashi</option>
														<option>Vera Tavares</option>
													</select>
												</div>
												<!-- /form-group -->

												<div class="form-group">
													<label for="exampleInputEmail1">Telefone 1</label> <input
														id="phone-mask" type="text"
														class=" form-control input-sm phone">
												</div>
												<!-- /form-group -->

											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="exampleInputEmail1">Nome do respons�vel</label>
													<input type="name" class="form-control input-sm"
														id="exampleInputEmail1"
														placeholder="Nome do Cliente Respons�vel"
														data-required="true">
												</div>
												<!-- /form-group -->

												<div class="form-group">
													<label for="exampleInputEmail1">�rea do respons�vel</label>
													<input type="text" class="form-control input-sm"
														id="exampleInputEmail1"
														placeholder="�rea do Cliente Respons�vel"
														data-required="true">
												</div>
												<!-- /form-group -->

												<div class="form-group">
													<label for="exampleInputEmail1">E-mail</label> <input
														type="email" class="form-control input-sm"
														id="exampleInputEmail1"
														placeholder="E-mail do Cliente Respons�vel"
														data-required="true">
												</div>
												<!-- /form-group -->

												<div class="form-group">
													<label for="exampleInputEmail1">Telefone 2</label> <input
														id="phone-mask" type="text"
														class=" form-control input-sm phone">
												</div>
												<!-- /form-group -->
											</div>

										</div>
										</section>
										<!-- /Section -->
									</div>
									<div class="tab-pane fade" id="third">
										<section class="panel panel-default">
										<div class="panel-heading">Forma��o acad�mica</div>
										<div class="panel-body relative">
											<textarea class="form-control" rows="3"></textarea>
										</div>
										</section>
										<!-- /panel -->

										<section class="panel panel-default">
										<div class="panel-heading">Perfil comportamental</div>
										<div class="panel-body relative">
											<textarea class="form-control" rows="3"></textarea>
										</div>
										</section>
										<!-- /panel -->

										<section class="panel panel-default">
										<div class="panel-heading">Perfil t�cnico</div>
										<div class="panel-body relative">
											<textarea class="form-control" rows="3"></textarea>
										</div>
										</section>
										<!-- /panel -->
									</div>
								</div>
							</div>
							<div class="panel-footer text-right">
								<button class="btn btn-success btn-sm disabled" id="prevStep"
									disabled="">Anterior</button>
								<button type="submit" class="btn btn-sm btn-success"
									id="nextStep">Pr�ximo</button>
							</div>
						</form>

					</div>
				</div>
			</div>

			<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->

		</div>
		<!-- /wrapper -->
	</div>


	<c:import url="shared/footer.jsp"></c:import>
	<c:import url="shared/js.jsp"></c:import>

</body>
</html>