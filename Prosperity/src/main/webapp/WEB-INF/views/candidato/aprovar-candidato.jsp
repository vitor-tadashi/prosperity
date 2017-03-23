<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Aprovação de candidatos</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->

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
												<label for="exampleInputEmail1">Vaga:</label> <select
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
													<div class="panel-body relative" name="nmPerfil">
														<select multiple="multiple" id="selectedBox1"
															class="select-box pull-left form-control">
															<c:forEach var="funcionario" items="${listaFuncionarios}">
														<option value="${funcionario.id}">${funcionario.nome}</option>
													</c:forEach>
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
															class="select-box pull-right form-control">
															
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
														value="Adicionar etapa" onclick="AddCampos()" name="">
													<br> <br>
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
												<textarea id="wysihtml5-textarea" placeholder="Digite ..."
													class="form-control" rows="6" name=""></textarea>
											</div>
										</section>
										<!-- /panel -->
									</div>
									<div class="tab-pane fade" id="third">
										<section class="panel panel-default">
											<div class="panel-heading text-center">
												<label for="exampleInputEmail1">Avaliação de
													competências</label>
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
				<li class="active">Aprovação de candidatos</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<div class="padding-md">
				<div class="row">
					<div>
						<div class="panel panel-default">
							<div class="panel-heading">Aprovação de candidatos</div>
							<div class="panel-body">
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
										<tr>
										<c:forEach var="candidato" items="${candidatos}">
											<td>${candidato.nome}</td>
											<td>${candidato.vagas.nomeVaga}</td>
											<td>${candidato.valorPretensao}</td>
											<td><fmt:formatDate value="${candidato.dataAbertura}" pattern="dd/MM/yyyy"/></td>
<%-- 											<td><fmt:formatDate value="${candidato.dataFechamento}" pattern="dd/MM/yyyy"/></td> --%>
<%--  											<td>${candidato.ultimoStatus.status.nome}</td> --%>
											<td><span class="label label-analiseRH"></span></td>
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
									</td>
									</c:forEach>
									</tr>
								</tbody>
							</table>
							
								</div>
								<!-- /.row -->
							</div>
							<!-- /.panel-body -->
							
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

	
</body>
</html>