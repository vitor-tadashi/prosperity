<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<li class="active">Vaga</li>
				<li class="active">Solicitar</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="padding-md">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">Informações da vaga</div>
					<div class="panel-body">
								
						<form class="form-border" id="formCadastro2" action="/vaga/salvar"
							method="POST" >
							<input id="vagaIdVar" name="id" type="hidden" value="${vaga.id}">
							<input id="dataAbertura" name="dataAbertura" type="hidden" value="${vaga.dataAbertura}">
							<input id="status" name="ultimoStatus" type="hidden" value="${ultimoStatus.status.id}">
							<input class ="hidden" value="${erro}" id="contErro">
							<input id="txtSolicitante" type="hidden" name="nomeSolicitante" value="${autenticado.funcionario.nome}">
							<input id="cliente" type="hidden" name="nomeSolicitante" value="${projetos}">
							
							<div id="textDiv">
								<c:forEach var="erro" items="${listaErros}">
									<p>${erro}</p>
								</c:forEach>
							</div>
							
							<div id="textDiv1"></div>
								<div id="textDiv2"></div>
								<div id="textDiv3"></div>

							<div class="panel-tab clearfix">
								<ul class="tab-bar wizard-demo" id="wizardDemo">
									<li id="tabInformacoes2" class="active tab-verity"><a id="tabInformacoes" href="#first"
										data-toggle="tab"><i class="fa fa-user"></i> Informações
											básicas</a></li>
									<li class="tab-verity"><a id="tabDados" href="#second" data-toggle="tab"
										class="text-success"><i class="fa fa-pencil"></i> Dados do
											projeto</a></li>
									<li class="tab-verity"><a id="tabPerfil" href="#third" data-toggle="tab"
										class="text-success"><i class="fa fa-briefcase"></i>
											Perfil</a></li>
									<li id="tabAvaliadores2" class="tab-verity"><a id="tabAvaliadores" href="#fourth" data-toggle="tab"
										class="text-success hide"><i class="fa fa-group"></i>
											Avaliadores</a></li>
								</ul>
							</div>

							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="first">
										
										<div class="row">
											<div class="form-group col-md-12" style="padding-top:0px">
												<label for="txtNomeVaga">Nome da vaga</label> <input
													type="text" name="nomeVaga"
													value="${vaga.nomeVaga}"
													class="form-control input-sm" id="txtNomeVaga"
													placeholder="Nome da Vaga" data-required="true">
											</div>
											<!-- /form-group -->
											
											<!-- /form-group -->
										</div>
										
										<div class="row">
											<div class="form-group col-md-6" style="">
												<label for="cmbCargo">Cargo</label> <select
													class="form-control" id="cmbCargo"
													name="cargoBean.id" value="${cargoBean.id}">

													<option value="0">Selecione o cargo</option>

													<c:forEach var="cargo" items="${cargos}" varStatus="i">
														<option value="${cargo.id}"
															${cargo.id ==
															vaga.cargoBean.id ? 'selected="selected"' : ''}>${cargo.nome}</option>
													</c:forEach>

												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6" style="">
												<label>Local de trabalho</label>
												<div>
													<input id="localTrabalhoVar" type="hidden"
														value="${vaga.localTrabalho}"> <label
														class="label-radio inline"> <input id="interno"
														name="localTrabalho" value="I" type="radio" checked>
														<span class="custom-radio"></span> Interno
													</label> <label class="label-radio inline"> <input
														id="cliente" name="localTrabalho" value="C" type="radio">
														<span class="custom-radio"></span> Cliente
													</label>
												</div>
											</div>
											<!-- /form-group -->
										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6" style="padding-top:0px">
												<label for="cmbSenioridade">Senioridade da vaga</label> <select
													id="cmbSenioridade" name="senioridadeBean.id"
													class="form-control">

													<option value="0">Selecione a senioridade</option>

													<c:forEach var="senioridade" items="${senioridades}"
														varStatus="i">
														<option value="${senioridade.id}"
															${senioridade.id ==
															vaga.senioridadeBean.id ? 'selected="selected"' : ''}>${senioridade.nome}</option>
													</c:forEach>

												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6" style="padding-top:0px">
												<label>Tipo de vaga</label>
												<div>
													<input id="tipoVagaVar" type="hidden"
														value="${vaga.idTipoVaga}"> <label
														class="label-radio inline"> <input
														id="idTipoVagaR" name="idTipoVaga" value="R" type="radio"
														checked> <span class="custom-radio"></span> Real
													</label> <label class="label-radio inline"> <input
														id="idTipoVagaP" name="idTipoVaga" value="P" type="radio">
														<span class="custom-radio"></span> Prospecção
													</label> <label class="label-radio inline"> <input
														id="idTipoVagaH" name="idTipoVaga" value="H" type="radio">
														<span class="custom-radio"></span> Hunting
													</label>
												</div>
											</div>
											<!-- /form-group -->

										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6" style="padding-top:0px">
												<label for="txtPropostaSalarial">Proposta salarial</label> <input
													id="txtPropostaSalarial" name="valorPretensao" type="number"
													class="form-control input-sm" placeholder="R$"
													value="${vaga.valorPretensao}" style="height:30px">
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6" style="padding-top:0px">
												<label class="control-label" for="txtHorarioInicial">Horário</label>
												<div>
													<div class="form-group col-md-2" style="padding-top:0px">
														<div class="input-group bootstrap-timepicker">
															<input id="txtHorarioInicial" name="horarioEntrada"
																type="time" value="${vaga.horarioEntrada}" style="width:70px;height:30px;padding-top:0px">
														</div>
													</div>
													<!-- /form-group -->
													<div class="form-group col-md-1" style="padding-top:0px">
														<label style="margin-top: 0px" >às</label>
													</div>
													<!-- /form-group -->
													<div class="form-group col-md-2" style="padding-top:0px">
														<div class="input-group bootstrap-timepicker">
															<input id="txtHorarioFinal" name="horarioSaida"
																type="time" value="${vaga.horarioSaida}" style="width:70px;height:30px;padding-top:0px">
														</div>
													</div>
													<!-- /form-group -->
												</div>
											</div>
											<!-- /form-group -->
										</div>
										<div class="row">
											<div class="form-group col-md-6" style="padding-top:0px">
												<label class="control-label" for="dataInicio">Data
													para início</label>
												<div class="input-sm-group">
												 <fmt:formatDate value="${vaga.dataInicio}"
													pattern="dd/MM/yyyy" var="dataInicio"/>
													<input id="dataInicio" name="dataInicio" type="text"
														class="form-control date parsley-validated" data-required="true"
														value="${dataInicio}" style="height:30px" onblur="validarData(this.value)"> 
												</div>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6" style="padding-top:0px">
												<label class="control-label">Aumento de quadro</label>
												<div>
													 <div class="form-group col-md-5" style="padding-top:0px"> 
														<input id="aumentoQuadroVar" type="hidden" value="${vaga.aumentaQuadro}">
														
														<label class="label-radio inline">Novo</label>
														<input id="novo" name="aumentaQuadro" value="N" type="radio" checked>
														<span class="custom-radio"> </span> 
														 <label class="label-radio inline">Substituição</label>
															 <input id="substituicao" name="aumentaQuadro" value="S" type="radio"> 
															 <span class="custom-radio"> </span>
													</div>
													<div id="nome" class="col-md-6 hide" style="padding-top:0px">
														<input id="nomeSubstituido" name="nomeSubstituido" type="text"
														class="form-control input-sm"
														placeholder="Nome do Substituido" data-required="true"
														value="${vaga.nomeSubstituido}">
													</div>
												</div>
											</div>
											<!-- /form-group -->
										</div>
										<!-- /form-group -->
									</div>
									
									<div class= "row tab-pane fade" id="second">
									
										<div id="dadosInterno" class="row panel panel-default">
											<div class="form-group col-md-12">
												<label for="exampleInputEmail1">Nome do projeto</label> <select
													id="cmbProjetoInterno" name="projeto.id"
													class="form-control">

													<option value="0">Selecione o projeto</option>

													<c:forEach var="projeto" items="${projetos}" varStatus="i">
														<option value="${projeto.id}"
															${projeto.id ==
														vaga.projeto.id ? 'selected="selected"' : ''}>${projeto.nome}</option>
													</c:forEach>
													
												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6" style="padding-top:0px">
												<label for="exampleInputEmail1">Cliente</label> 
												<input type="text" class="form-control input-sm" placeholder="Selecione o projeto" id="Cliente" name="Cliente" 
												value="${vaga.projeto.cliente.nome}" disabled="disabled" onblur="cliente">
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6" style="padding-top:0px">
												<label for="exampleInputEmail1">Gestor imediato</label> 
												<select id="cmbGestorInterno" name="usuarioBean.id" class="form-control">
												
													<option value="0">Selecione o gestor</option>

													<c:forEach var="usuario" items="${usuarios}" varStatus="i">
														<option value="${usuario.id}"
														${usuario.id == vaga.usuarioBean.id ? 'selected="selected"' : ''}>${usuario.nome}</option>
													</c:forEach>
													
												</select>
											</div>
											<!-- /form-group -->

											<!-- Sessão de Projeto Alocado -->
											
											<div id="dadosAlocacao" class="col-md-12 hide" style="padding-top:0px">
												<div class="col-md-6" style="padding-left:0px">
											    <label for="exampleInputEmail1">Nome do responsável</label> 
											    <input type="name" class="form-control input-sm" id="exampleInputEmail1"
												placeholder="Nome do Cliente Responsável" data-required="true" name="nmResponsavel" value="${vaga.nmResponsavel}"> 
												</div>
												<div class="col-md-6">
												<label for="exampleInputEmail1">Área do responsável</label> 
												<input type="text" class="form-control input-sm" id="exampleInputEmail1" name="nmAreaResponsavel" value="${vaga.nmAreaResponsavel}"
												placeholder="Área do Cliente Responsável" data-required="true"> 
												</div>
												<div class="col-md-6" style="padding-left:0px;padding-top:10px">
												<label for="exampleInputEmail1">E-mail do responsável</label> 
												<input type="email" class="form-control input-sm" id="exampleInputEmail1" name="emailResponsavel" value="${vaga.emailResponsavel}"
												placeholder="E-mail do Cliente Responsável" data-required="true">
												</div>
												<div class="col-md-6" style="padding-top:10px">
												<label for="exampleInputEmail1">Telefone 1</label> 
												<input id="phone-mask" type="text" class=" form-control input-sm phone" name="telResponsavel" value="${vaga.telResponsavel}"> 
												</div>
											</div>
											<!-- /Section -->
											
										</div>
										<!-- /Section-->
									</div>
									
									<div class="tab-pane fade" id="third">
										<section class="panel panel-default">
											<div class="panel-heading"><label>Formação acadêmica</label></div>
											<div class="panel-body relative">
												<textarea class="form-control"
													name="descricaoFormacaoAcademica" rows="5"
													value="${vaga.descricaoFormacaoAcademica}">${vaga.descricaoFormacaoAcademica}</textarea>
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default">
											<div class="panel-heading"><label>Perfil comportamental</label></div>
											<div class="panel-body relative">
												<textarea class="form-control"
													name="descricaoPerfilComportamental" rows="5"
													value="${vaga.descricaoPerfilComportamental}">${vaga.descricaoPerfilComportamental}</textarea>
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default">
											<div class="panel-heading"><label>Perfil técnico</label></div>
											<div class="panel-body relative">
												<textarea class="form-control" name="descricaoPerfilTecnico"
													value="${vaga.descricaoPerfilTecnico}" rows="5">${vaga.descricaoPerfilTecnico}</textarea>
											</div>
										</section>
										<!-- /panel -->
									</div>
									
									<div class="tab-pane fade hide" id="fourth">
									
									<div class="panel panel-default">
									
										<div class="panel-heading">
											<label>Avaliadores</label>
										</div>
										
										<div class="panel-body relative">
											<select multiple="multiple" id="selectedBox1" class="select-box pull-left form-control">
											
												<c:forEach var="usuario" items="${usuarios}" varStatus="i">
													<option value="${usuario.id}"
													${usuario.id == vaga.usuarioBean.id ? 'selected="selected"' : ''}>${usuario.nome}</option>
												</c:forEach>
										
											</select>		
					
											<div class="select-box-option">
												<a class="btn btn-sm btn-default" id="btnRemove">
													<i class="fa fa-angle-left"></i>
												</a>
												<a class="btn btn-sm btn-default" id="btnSelect">
													<i class="fa fa-angle-right"></i>
												</a>
												<div class="seperator"></div>
												<a class="btn btn-sm btn-default" id="btnRemoveAll">
													<i class="fa fa-angle-double-left"></i>
												</a>
												<a class="btn btn-sm btn-default" id="btnSelectAll">
													<i class="fa fa-angle-double-right"></i>
												</a>
											</div>
					
											<select multiple="multiple" name="avaliadores" id="selectedBox2" class="select-box pull-right form-control">
												
												 <c:forEach var="avaliador" items="${avaliadorVagaBean}" varStatus="i">
													<option value="${avaliador.usuario.id}"
													<%-- ${vaga.id == avaliadorVagaBean.vaga.id && usuario.id == avaliadorVagaBean.usuario.id ? 'selected="selected"' : ''} --%> >${avaliador.usuario.nome}</option>
												</c:forEach> 
												
											</select>		
										</div>
									</div>
														
									</div>
									
								</div>
							</div>
							<div class="text-right pull-right">
								<button type="submit" class="btn btn-sm btn-success" id="btnSalvar">Salvar</button>
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
	
	<script>
	
	var dropdownProjeto = document.querySelector("#cmbProjetoInterno");
	dropdownProjeto.addEventListener("change",function(){

		var id = $("#cmbProjetoInterno").val();
		$.ajax({
			url: "http://localhost:8080/vaga/obter-cliente",
			type: "GET",
			dataType: "JSON",
			data: {id : id},
			success: function(lista){
				if(id == 0){
					$("#Cliente").val("Selecione o projeto");
				}
				$("#Cliente").val(lista[0].cliente.nome);
			}
		});
		
	});
	
		$(document).ready(function() {
			if ($("input#contErro").val() > 0) {
				$('#textDiv').addClass("alert alert-danger");
			}
		})
		
		$(document).ready(function() {
			$('.cpf').mask('999.999.999-99', {
				reverse : true
			});
			$('.telefone').mask('(99) 99999-9999');
			$('#rg').mask('99.999.999-9');
			$("#cep").mask("99999-999");
			$('.date').mask('99/99/9999');
		})
		
		var a = ${vaga.dataAbertura} + 1
		if (a == 1){
			$("#dataAbertura").val("2017-01-01")
		}
	
//Script para preencher automático o Radio de TipoVaga
	
	if(($("#tipoVagaVar").val() == "R")){
		$("#idTipoVagaR").prop("checked",true)
	} else if(($("#tipoVagaVar").val() == "P")){
		$("#idTipoVagaP").prop("checked",true)
	} else if (($("#tipoVagaVar").val() == "H")){
		$("#idTipoVagaH").prop("checked",true)
	};
	
	//Script para preencher automático o Radio de Aumento de Quadro
	
	if(($("#aumentoQuadroVar").val() == "N")){
		$("#novo").prop("checked",true)
	} else if(($("#aumentoQuadroVar").val() == "S")){
		$("#substituicao").prop("checked",true)
	};
	
	if(($("#aumentoQuadroVar").val() == "N")) {
		$("div#nome").addClass("hide");
	}else if (($("#aumentoQuadroVar").val() == "S")){
		$("div#nome").removeClass("hide");
	};
	
	$("#novo").click(function() {
		$("div#nome").addClass("hide");
	});
	
	$("#substituicao").click(function() {
		$("div#nome").removeClass("hide");
	});
	
	//Script para preencher automático o Radio de Local de Trabalho
	
	if(($("#localTrabalhoVar").val() == "C")){
		$("#cliente").prop("checked",true)
	} else if(($("#localTrabalhoVar").val() == "I")){
		$("#interno").prop("checked",true)
	}
	
	//Script para alteração da Aba Dados do Projeto e do Radio Button Local de Trabalho
	
	if (($("#localTrabalhoVar").val() == "C")) {
		$("div#dadosAlocacao").hide();
	}else if(($("#localTrabalhoVar").val() == "I")){
		$("div#dadosAlocacao").show();
	};

	$("#cliente").click(function() {
		$("div#dadosAlocacao").removeClass("hide");
	});
	$("#interno").click(function() {
		$("div#dadosAlocacao").addClass("hide");
	});
	
	
	</script>

</body>

</html>