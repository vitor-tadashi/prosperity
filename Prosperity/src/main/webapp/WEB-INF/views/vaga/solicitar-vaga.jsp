<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Solicitar Vaga</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<script type="text/javascript">
function cliente()
projeto.getElementById("textCliente").value("");
</script>

<body>
	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						Início</a></li>
				<li class="active">Solicitação de vaga</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="padding-md">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">Informações da vaga</div>
					<div class="panel-body">
						<form class="form-border" id="formCadastro" novalidate="">
							<div class="panel-tab clearfix">
								<ul class="tab-bar wizard-demo" id="wizardDemo">
									<li class="active tab-verity"><a href="#first"
										data-toggle="tab"><i class="fa fa-user"></i> Informações
											básicas</a></li>
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
													<label for="txtSolicitante">Solicitante</label> <input
														type="text" class="form-control input-sm"
														id="txtSolicitante" placeholder="Solicitante"
														data-required="true">
												</div>
												<!-- /form-group -->
												<div class="form-group col-md-6">
													<label>Local de trabalho</label>
													<div>
														<label class="label-radio inline">
															<input id="interno" type="radio" name="radLocalTrabalho" checked>
															<span class="custom-radio"></span> Interno
														</label>
														<label class="label-radio inline">
															<input id="cliente" type="radio" name="radLocalTrabalho">
															<span class="custom-radio"></span> Cliente
														</label>
													</div>
												</div>
												<!-- /form-group -->
											</div>
										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<label for="cmbCargo">Cargo</label>
												<select class="form-control chzn-select" id="cmbCargo">
													
													<c:forEach var="cargo" items="${cargos}" varStatus="i">
														<option value="i">${cargo.nome}</option>
													</c:forEach>
													
												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label>Tipo de vaga</label>
												<div>
													<label class="label-radio inline">
														<input type="radio" name="radTipoVaga" checked>
														<span class="custom-radio"></span> Real
													</label>
													<label class="label-radio inline">
														<input type="radio" name="radTipoVaga">
														<span class="custom-radio"></span> Prospecção
													</label>
													<label class="label-radio inline">
														<input type="radio" name="radTipoVaga">
														<span class="custom-radio"></span> Hunting
													</label>
												</div>
											</div>
											<!-- /form-group -->

										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<label for="cmbSenioridade">Senioridade da vaga</label>
												<select class="form-control chzn-select" id="cmbSenioridade">
												
													<c:forEach var="senioridade" items="${senioridades}" varStatus="i">
														<option value="i">${senioridade.nome}</option>
													</c:forEach>
													
												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label class="control-label" for="txtHorarioInicial">Horário</label>
												<div>
													<div class="form-group col-md-5">
														<div class="input-group bootstrap-timepicker">
															<input class="timepicker form-control" type="text"
																value="08:00 AM" id="txtHorarioInicial"> <span
																class="input-group-addon"><i
																class="fa fa-clock-o"></i></span>
														</div>
													</div>
													<!-- /form-group -->
													<div class="form-group col-md-1">
														<label style="margin-top: 7px">às</label>
													</div>
													<!-- /form-group -->
													<div class="form-group col-md-5">
														<div class="input-group bootstrap-timepicker">
															<input class="timepicker form-control" type="text" value="05:00 PM" id="txtHorarioFinal">
															<span class="input-group-addon">
																<i class="fa fa-clock-o"></i>
															</span>
														</div>
													</div>
													<!-- /form-group -->
												</div>
											</div>
											<!-- /form-group -->
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<label for="txtPropostaSalarial">Proposta salarial</label> <input
													type="text" class="form-control input-sm"
													id="txtPropostaSalarial" placeholder="R$"
													data-required="true">
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label>Aumento de quadro</label>
												<div>
													<label class="label-radio inline"> <input id="novo"
														type="radio" name="radAumentoQuadro" checked> <span
														class="custom-radio"> </span> Novo
													</label> <label class="label-radio inline"> <input id="substituicao"
														type="radio" name="radAumentoQuadro"> <span
														class="custom-radio"> </span> Substituição
													</label>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<label class="control-label" for="txtDataInicio">Data para início</label>
												<div class="input-group">
													<input type="text" value="01/01/2017"
														class="datepicker form-control" id="txtDataInicio"> <span
														class="input-group-addon"><i
														class="fa fa-calendar"></i></span>
												</div>
												<!-- /.col -->
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
													
													<c:forEach var="projeto" items="${projetos}" varStatus="i">
														<option value="i">${projeto.nome}</option>
													</c:forEach>

												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-4" style="padding-left: 0px;">
												<label for="exampleInputEmail1">Cliente</label> 
												<input type="text" class="form-control input-sm"
														id="textCliente" placeholder="Cliente"
														data-required="false" disabled="disabled" onblur="cliente">
												
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-4" style="padding-left: 0px;">
												<label for="exampleInputEmail1">Gestor imediato</label> <select
													class="form-control chzn-select">
														<c:forEach var="usuario" items="${usuarios}" varStatus="i">
															<option value="i">${usuario.nome}</option>
														</c:forEach>
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
													<label for="exampleInputEmail1">Nome do projeto</label>
													 <select class="form-control chzn-select">
													 
														<c:forEach var="projeto" items="${projetos}" varStatus="i">
															<option value="i">${projeto.nome}</option>
														</c:forEach>
														
													</select>
												</div>
												<!-- /form-group -->
												<div class="form-group">
													<label for="exampleInputEmail1">Cliente</label> 
													<input type="text" class="form-control input-sm"
														id="textCliente" placeholder="Cliente"
														data-required="false" disabled="disabled" onblur="cliente">
												</div>
												<!-- /form-group -->
												<div class="form-group" style="padding-left: 0px;">
													<label for="exampleInputEmail1">Gestor imediato</label> 
													<select	class="form-control chzn-select">
														<c:forEach var="usuario" items="${usuarios}" varStatus="i">
															<option value="i">${usuario.nome}</option>
														</c:forEach>
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
													<label for="exampleInputEmail1">Nome do responsável</label>
													<input type="name" class="form-control input-sm"
														id="exampleInputEmail1"
														placeholder="Nome do Cliente Responsável"
														data-required="true">
												</div>
												<!-- /form-group -->
												<div class="form-group">
													<label for="exampleInputEmail1">Área do responsável</label>
													<input type="text" class="form-control input-sm"
														id="exampleInputEmail1"
														placeholder="Área do Cliente Responsável"
														data-required="true">
												</div>
												<!-- /form-group -->
												<div class="form-group">
													<label for="exampleInputEmail1">E-mail</label> <input
														type="email" class="form-control input-sm"
														id="exampleInputEmail1"
														placeholder="E-mail do Cliente Responsável"
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
											<div class="panel-heading">Formação acadêmica</div>
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
											<div class="panel-heading">Perfil técnico</div>
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
									id="nextStep">Próximo</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->
		</div>
		<!-- /wrapper -->
	</div>
	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
    <c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
    
    <!-- Custom -->
		<script src="/resources/js/custom/solicitacaoVaga.js"></script>
		<script src="/resources/js/parsley.min.js"></script>
		<script src="/resources/js/custom/custom.js"></script>
		
</body>

		
</html>