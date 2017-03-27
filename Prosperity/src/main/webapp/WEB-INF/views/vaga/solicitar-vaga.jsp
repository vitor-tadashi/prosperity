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
						<form class="form-border" id="formCadastro2" action="cadastrar"
							method="POST">
							
							<div id="textDiv">
							
							<c:forEach var="erro" items="${listaErros}">
								<p>${erro}</p>

							</c:forEach>
							
							</div>
							
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
														type="text" name="nomeSolicitante"
														class="form-control input-sm" id="txtSolicitante"
														placeholder="Solicitante" data-required="true">
												</div>
												<!-- /form-group -->
												<div class="form-group col-md-6">
													<label>Local de trabalho</label>
													<div>
														<label class="label-radio inline"> <input
															id="interno" name="localTrabalho" value="I" type="radio" checked>
															<span class="custom-radio"></span> Interno
														</label> <label class="label-radio inline"> <input
															id="cliente" name="localTrabalho" value="C" type="radio"> <span
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
												<label for="cmbCargo">Cargo</label> <select
													class="form-control chzn-select" id="cmbCargo" name="cargoBean.id">
														
														<option value="0">Selecione o cargo</option>
														
													<c:forEach var="cargo" items="${cargos}" varStatus="i">
														<option value="${cargo.id}">${cargo.nome}</option>
													</c:forEach>

												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label>Tipo de vaga</label>
												<div>
													<label class="label-radio inline"> <input
														name="idTipoVaga" value="R" type="radio" checked> <span
														class="custom-radio"></span> Real
													</label> <label class="label-radio inline"> <input
														 name="idTipoVaga" value="P" type="radio" > <span
														class="custom-radio"></span> Prospecção
													</label> <label class="label-radio inline"> <input
														name="idTipoVaga" value="H" type="radio" > <span
														class="custom-radio"></span> Hunting
													</label>
												</div>
											</div>
											<!-- /form-group -->

										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<label for="cmbSenioridade">Senioridade da vaga</label> <select
													id="cmbSenioridade" name="senioridadeBean.id" class="form-control chzn-select" >
													
													<option value="0">Selecione a senioridade</option>

													<c:forEach var="senioridade" items="${senioridades}"
														varStatus="i">
														<option value="${senioridade.id}">${senioridade.nome}</option>
													</c:forEach>

												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label class="control-label" for="txtHorarioInicial">Horário</label>
												<div>
													<div class="form-group col-md-2">
														<div class="input-group bootstrap-timepicker">
															<input id="txtHorarioInicial" name="horarioEntrada" type="text"
																 value="08:00">
														</div>
													</div>
													<!-- /form-group -->
													<div class="form-group col-md-1">
														<label style="margin-top: 7px">às</label>
													</div>
													<!-- /form-group -->
													<div class="form-group col-md-2">
														<div class="input-group bootstrap-timepicker">
															<input id="txtHorarioFinal" name="horarioSaida"
																 type="text" value="17:00">
														</div>
													</div>
													<!-- /form-group -->
												</div>
											</div>
											<!-- /form-group -->
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<label for="txtPropostaSalarial">Proposta salarial</label> 
												<input id="txtPropostaSalarial" name="valorPretensao" type="text" class="form-control input-sm" 
												placeholder="R$">
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label>Aumento de quadro</label>
												<div>
													<label class="label-radio inline"> <input id="novo" name="aumentaQuadro" value="N"
														type="radio" checked> <span
														class="custom-radio"> </span> Novo
													</label> <label class="label-radio inline"> <input
														id="substituicao" name="aumentaQuadro" value="S" type="radio">
														<span class="custom-radio"> </span> Substituição
													</label>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<label class="control-label" for="dataInicio">Data
													para início</label>
												<div class="input-group">
													<input id="dataInicio" name="dataInicio" type="text"  value="01/01/2017"
														class="datepicker form-control" data-required="true">
													<span class="input-group-addon"><i
														class="fa fa-calendar"></i></span>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
											<div id="nome" class="form-group col-md-6 hide">
												<label>Nome do substituido</label> <input id="nomeSubstituido" name="nomeSubstituido" type="text"
													class="form-control input-sm"
													placeholder="Nome do Substituido"  data-required="true">
											</div>
										</div>
										<!-- /form-group -->
									</div>
									<div class="tab-pane fade" id="second">
										<section id="dadosInterno" class="panel panel-default">
											<div class="panel-body">
												<div class="form-group col-md-4" style="padding-left: 0px;">
													<label for="exampleInputEmail1">Nome do projeto</label> <select id ="cmbProjetoInterno"  name="projetoBean.id"
														class="form-control chzn-select">
														
														<option value="0">Selecione o projeto</option>

														<c:forEach var="projeto" items="${projetos}" varStatus="i">
															<option value="${projeto.id}">${projeto.nome}</option>
														</c:forEach>

													</select>
												</div>
												<!-- /form-group -->
												<div class="form-group col-md-4" style="padding-left: 0px;">
													<label for="exampleInputEmail1">Cliente</label> <input
														type="text" class="form-control input-sm" id="textCliente"
														placeholder="Cliente" data-required="false"
														disabled="disabled" onblur="cliente">

												</div>
												<!-- /form-group -->
												<div class="form-group col-md-4" style="padding-left: 0px;">
													<label for="exampleInputEmail1">Gestor imediato</label> <select id ="cmbGestorInterno" name="usuarioBean.id"
														class="form-control chzn-select">
														
														<option value="0">Selecione o gestor</option>
														
														<c:forEach var="usuario" items="${usuarios}" varStatus="i">
															<option value="${usuario.id}">${usuario.nome}</option>
														</c:forEach>
													</select>
												</div>
												<!-- /form-group -->
											</div>
										</section>
										<!-- /Section-->
										
										<!-- Sessão de Projeto Alocado -->
										
										<section id="dadosAlocacao" class="panel panel-default hide">
											<div class="panel-body">
												<div class="col-md-6">
													<div class="form-group" style="padding-left: 0px;">
														<label for="exampleInputEmail1">Nome do projeto</label> <select id ="cmbProjetoCliente"  name="projetoBean.id"
															class="form-control chzn-select">
															
															<option value="0">Selecione o projeto</option>
															
															<c:forEach var="projeto" items="${projetos}"
																varStatus="i">
																<option value="${projeto.id}">${projeto.nome}</option>
															</c:forEach>

														</select>
													</div>
													<!-- /form-group -->
													<div class="form-group">
														<label for="exampleInputEmail1">Cliente</label> <input
															type="text" class="form-control input-sm"
															id="textCliente" placeholder="Cliente"
															data-required="false" disabled="disabled"
															onblur="cliente">
													</div>
													<!-- /form-group -->
													<div class="form-group" style="padding-left: 0px;">
														<label for="exampleInputEmail1">Gestor imediato</label> <select id ="cmbGestorCliente" name="usuarioBean.id"
															class="form-control chzn-select">
															
															<option value="0">Selecione o gestor</option>
															
															<c:forEach var="usuario" items="${usuarios}"
																varStatus="i">
																<option value="${usuario.id}">${usuario.nome}</option>
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
														<label for="exampleInputEmail1">Nome do
															responsável</label> <input type="name"
															class="form-control input-sm" id="exampleInputEmail1"
															placeholder="Nome do Cliente Responsável"
															data-required="true">
													</div>
													<!-- /form-group -->
													<div class="form-group">
														<label for="exampleInputEmail1">Área do
															responsável</label> <input type="text"
															class="form-control input-sm" id="exampleInputEmail1"
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
												<textarea class="form-control" name="descricaoFormacaoAcademica"
													rows="3"></textarea>
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default">
											<div class="panel-heading">Perfil comportamental</div>
											<div class="panel-body relative">
												<textarea class="form-control" name="descricaoPerfilComportamental"
													rows="3"></textarea>
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default">
											<div class="panel-heading">Perfil técnico</div>
											<div class="panel-body relative">
												<textarea class="form-control" name="descricaoPerfilTecnico"
													rows="3"></textarea>
											</div>
										</section>
										<!-- /panel -->
									</div>
								</div>
							</div>
							<div class="panel-footer text-right pull-right">
								<input class="btn btn-sm btn-success hide"
									id="btnCadastrar2" value="Cadastrar"/>
							</div>
						</form>
							<div class="panel-footer text-right pull-right">
								<button class="btn btn-success btn-sm disabled" id="prevStep2"
									disabled="">Anterior</button>
								<button class="btn btn-sm btn-success" id="nextStep2">Próximo</button>
							</div>
							
					</div>
				</div>
			</div>
			<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->
		</div>
		<!-- /wrapper -->
	</div>
	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
	<input value="${erro}" id="contErro">

	<!-- Custom -->
	<script src="/resources/js/custom/solicitacaoVaga.js"></script>
	<script src="/resources/js/parsley.min.js"></script>
	<script src="/resources/js/custom/custom.js"></script>
	
	<script>
	$(document).ready(function() {
			if ($("input#contErro").val() > 0) {
				$('#textDiv').addClass("alert alert-danger text-center");
			}
		})
	</script>	
</body>


</html>