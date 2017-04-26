<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Solicitar Vaga</title>
		<link rel="stylesheet" href="/resources/css/custom/solicitar-vaga.css" />
	</layout:put>

	<layout:put block="contents">
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="/pagina-inicial">
						Página inicial</a></li>
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
							<fmt:formatDate value="${vaga.dataAbertura}"
														pattern="dd/MM/yyyy" var="dataAbertura" />
							<input id="dataAbertura" name="dataAbertura" type="hidden" value="${dataAbertura}">
							<c:if test="${ultimoStatus.status.id == 27 }">
								<input id="status" name="status[0].status.id" type="hidden" value="1">
								<input name="status[0].status.nome" type="hidden" value="Ativo">	
							</c:if>
							<input id="contErro" class ="hidden" value="${erro}">
							<input id="txtSolicitante" type="hidden" name="nomeSolicitante" value="${autenticado.funcionario.nome}">
							
							<div id="textDiv">
								<c:forEach var="erro" items="${listaErros}">
									<p>${erro}</p>
								</c:forEach>
								
								<!-- MENSAGEM DE SUCESSO -->
							<c:if test="${not empty sucesso}">
									<div id="msg-sucesso" class="alert alert-success msg-margin">
										<ul>
											<li class="li-msg">${sucesso }</li>
										</ul>
									</div>
								</c:if>
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
										class="text-success"><i class="glyphicon glyphicon-education"></i>
											Perfil</a></li>
									<li id="tabAvaliadores2" class="tab-verity"><a id="tabAvaliadores" href="#fourth" data-toggle="tab"
										class="text-success hide"><i class="fa fa-group"></i>
											Avaliadores</a></li>
									<li id="tabMarketing" class="tab-verity"><a id="tabMarketing" href="#fifth" data-toggle="tab"
										class="text-success"><i class="fa fa-briefcase"></i>
											Marketing</a></li>
								</ul>
							</div>

							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="first">
										
										<div class="row">
											<div class="form-group col-md-6" style="padding-top:0px">
												<label for="txtNomeVaga">Nome da vaga</label> <input
													type="text" name="nomeVaga"
													value="${vaga.nomeVaga}"
													class="form-control input-sm" id="txtNomeVaga"
													placeholder="Nome da Vaga" data-required="true" maxlength="50">
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-2">
												<label class="control-label" for="dataInicio">Data
													para início</label>
												<div class="input-sm-group">
												<fmt:formatDate value="${vaga.dataInicio}"
													pattern="dd/MM/yyyy" var="dataInicio"/>
													<input id="dataInicio" name="dataInicio" type="text"
														class="form-control data parsley-validated" data-required="true"
														value="${dataInicio}" style="height:30px" >  
												</div>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-4">
												<div class="row">
													<label class="control-label label-time-input col-xs-12" for="txtHorarioInicial">Horário</label>
													<input id="txtHorarioInicial" name="horarioEntrada" 
														type="time" class="form-control verity-time-input input-sm col-xs-5" value="${vaga.horarioEntrada}">
													<span class="col-xs-1">às</span>
													<input id="txtHorarioFinal" name="horarioSaida"
														type="time" class="form-control verity-time-input input-sm col-xs-5" value="${vaga.horarioSaida}">
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="form-group col-md-6">
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
											<div class="form-group col-md-6">
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
											<div>
												<label class="control-label" for="txtPropostaSalarial">Range salarial</label>
											</div>
												<label class="control-label col-md-2" for="txtPropostaSalarial" style="padding-top:5px">Mínimo</label>
											 	<input
													id="valorMinimo" name="valorMinimo" type="number"
													class="input-sm col-md-4" disabled placeholder="R$"
													value="" style="height:30px">
												<label class="control-label col-md-2" style="padding-left:10px;padding-top:5px" for="txtPropostaSalarial">Máximo</label>
													<input
													id="valorMaximo" name="valorMaximo" type="number"
													class="input-sm col-md-4" disabled placeholder="R$" 
													value="" style="height:30px">
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6" style="padding-top:0px">
												<label class="control-label">Aumento de quadro</label>
												<div>
													 <div class="form-group col-md-5" style="padding-top:0px;padding-left:0px"> 
														<input id="novo" name="aumentaQuadro" value="N" type="radio" checked>
													 	<span class="custom-radio"> </span>
														<label class="label-radio inline">Novo</label>
														<input id="substituicao" name="aumentaQuadro" value="S" type="radio"> 
														 <span class="custom-radio"> </span>
														 <label class="label-radio inline">Substituição</label>
													 	<input id="aumentoQuadroVar" type="hidden" value="${vaga.aumentaQuadro}">
													</div>
													<div id="nome" class="col-md-6 hide" style="padding-top:0px">
														<input id="nomeSubstituido" name="nomeSubstituido" type="text"
														class="form-control input-sm"
														placeholder="Nome do Substituido" data-required="true"
														value="${vaga.nomeSubstituido}" maxlength="50">
													</div>
												</div>
											</div>
											<!-- /form-group -->
										</div>
										
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
														${usuario.id == vaga.usuarioBean.id ? 'selected="selected"' : ''}>${usuario.funcionario.nome}</option>
													</c:forEach>
													
												</select>
											</div>
											<!-- /form-group -->

											<!-- Sessão de Projeto Alocado -->
											
											<div id="dadosAlocacao" class="col-md-12 hide" style="padding-top:0px">
												<div class="col-md-6" style="padding-left:0px">
											    <label for="nmResponsavel">Nome do responsável</label> 
											    <input type="name" class="form-control input-sm" id="nmResponsavel"
												placeholder="Nome do Cliente Responsável" data-required="true" name="nmResponsavel" value="${vaga.nmResponsavel}" maxlength="30"> 
												</div>
												<div class="col-md-6">
												<label for="nmAreaResponsavel">Área do responsável</label> 
												<input type="text" class="form-control input-sm" id="nmAreaResponsavel" name="nmAreaResponsavel" value="${vaga.nmAreaResponsavel}"
												placeholder="Área do Cliente Responsável" data-required="true" maxlength="30"> 
												</div>
												<div class="col-md-6" style="padding-left:0px;padding-top:15px">
												<label for="emailResponsavel">E-mail do responsável</label> 
												<input type="text" class="form-control input-sm" id="emailResponsavel" name="emailResponsavel" value="${vaga.emailResponsavel}"
												placeholder="E-mail do Cliente Responsável" data-required="true" maxlength="50">
												</div>
												<div class="col-md-6" style="padding-top:15px">
												<label for="telResponsavel">Telefone</label> 
												<input id="telResponsavel" type="tel" class="form-control input-sm telefone" name="telResponsavel" 
												value="${vaga.telResponsavel}" onblur="validarTel(this.value)"> 
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
												<textarea id="descricaoFormacaoAcademica" class="form-control"
													name="descricaoFormacaoAcademica" rows="5"
													value="${vaga.descricaoFormacaoAcademica}" maxlength="500" onkeyup="maxCaracterFormacaoAcademica()">${vaga.descricaoFormacaoAcademica}</textarea>
												<label id="maxFormacaoAcademica">Caracteres restantes : 500</label>
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default">
											<div class="panel-heading"><label>Perfil comportamental</label></div>
											<div class="panel-body relative">
												<textarea id="descricaoPerfilComportamental" class="form-control"
													name="descricaoPerfilComportamental" rows="5"
													value="${vaga.descricaoPerfilComportamental}" maxlength="500" onkeyup="maxCaracterPefilComportamental()">${vaga.descricaoPerfilComportamental}</textarea>
													<label id="maxPerfilComportamental">Caracteres restantes : 500</label>
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default">
											<div class="panel-heading"><label>Perfil técnico</label></div>
											<div class="panel-body relative">
												<textarea id="descricaoPerfilTecnico" class="form-control" name="descricaoPerfilTecnico"
													value="${vaga.descricaoPerfilTecnico}" rows="5" maxlength="500" onkeyup="maxCaracterPefilTecnico()">${vaga.descricaoPerfilTecnico}</textarea>
													<label id="maxPerfilTecnico">Caracteres restantes : 500</label>
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
													${usuario.id == vaga.usuarioBean.id ? 'selected="selected"' : ''}>${usuario.funcionario.nome}</option>
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
									<div class="tab-pane fade" id="fifth">
										<div class="panel panel-default">
											<div class="adjoined-bottom">
												<div class="grid-container">
													<textarea id="editor" name="editor">
														
													</textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="text-right pull-right">
								<button type="submit" class="btn btn-sm btn-success" id="btnSalvar"><i class="fa fa-check"></i> Salvar</button>
							</div>
						</form>

					</div>
				</div>
			</div>
			<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->
		</div>
		<!-- /wrapper -->
	</div>
	</layout:put>

	<layout:put block="scripts" type="REPLACE">
	<!-- Custom -->
	<script src="/resources/js/custom/solicitacaoVaga.js"></script>
	<script src="/resources/js/parsley.min.js"></script>
	
	<script src="https://cdn.ckeditor.com/4.6.2/standard/ckeditor.js"></script>
		  
	</layout:put>
</layout:extends>