<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Consulta de candidatos</title>
	</layout:put>

	<layout:put block="contents">
	<style>
		li a.active {
		background: #f2f2f2;
		}
	</style>
	
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
						<form class="form-border" id="formCadastro">
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
													<input class="form-control input-sm" name="candidato.id"
														id="nomeCandidato" data-required="true" name="nome">
												</div>
												<!-- /form-group -->
											</div>
										</div>
										<!-- /form-group -->
										<div class="row">
											<div class="form-group col-md-6">
												<label for="exampleInputEmail1">Vaga:</label> <select
													class="form-control chzn-select" id="nomeVaga" name="ultimaVaga">
													<c:forEach var="vaga" items="${listaVaga}">
														<option value="${vaga.id}">${vaga.nomeVaga}</option>
													</c:forEach>
												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-6">
												<label for="exampleInputEmail1">Senioridade da vaga:</label>
												<select class="form-control chzn-select"
													id="nomeSenioridade" name="senioridade">
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
													<div class="panel-body relative" id="nmPerfil">
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
												<div class="form-group">
													<div class="input-group">
														<input type="text" value="01/01/2017"
															class="datepicker form-control" id="dataUltimoContato">
														<span class="input-group-addon"><i
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
													<div class="form-group">
														<div class="input-group">
															<input type="text" value="00/00/0000"
																class="datepicker form-control" name="dtEntrevista">
															<span class="input-group-addon"><i
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
												<label>Etapas dos processos de seleção	: </label>
												<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->

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
														<th id="">Insatisfatório</th>
														<th>Em Desenvolvimento</th>
														<th>Atende as Expectativas</th>
														<th>Supera as Expectativas</th>
													</tr>
												</thead>
												<tbody class="text-center">
													<tr>
														<td>Desenvolvimento</td>
														<td><label class="label-radio inline"> <input
																id="desenvolvimento_insatisfatorio" type="radio"
																name="inline-radio1" value="1"> <span
																class="custom-radio"></span>
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

										</section>
									</div>
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
				<li><i class="fa fa-home"></i><a href="/pagina-inicial"> Página inicial</a></li>
				<li>Candidato</li>
				<li class="active">Consultar</li>
			</ul>
		</div>
		<!--breadcrumb-->
		
		<div class="padding-md">
		
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
		
						<div class="panel-heading">Consultar candidatos</div>
						<div class="panel-body">
							<form action="filtrar" method="GET" class="row">
								<div class="col-md-2">
									<label for="exampleInputEmail1">Nome: </label>
									<div class="search-block">
										<div class="input-group">
											<input type="text" class="form-control input-sm"
												placeholder="Nome" name="nome" value="${filtroC.nome }">
										</div>
										<!-- /input-group -->
									</div>
									<!-- /search-block -->
								</div>
								<div class="col-md-2">
									<label for="exampleInputEmail1">Vaga</label> <select
										class="form-control inline" id="vagaFiltro" name="vagaBean.id">
										<option value="0">Selecione</option>
										<c:forEach var="vaga" items="${listaVagaDrop}">
											<option value="${vaga.id}"
											${vaga.id == filtroC.vagaBean.id? 'selected="selected"' : ''}>${vaga.nomeVaga}</option>
											
										</c:forEach>
									</select>
								</div>
								<div class="col-md-1">
									<label for="salário">Salário</label> <input
										type="text" class="form-control money2 parsley-validated"
												id="valorPretensao" name="pretensaoDe" class="form-control money2"
										placeholder="De" style="width: 80px" value="${filtroC.pretensaoDe }">
								</div>
								<div class="col-md-1">
									<label for="exampleInputEmail1">&nbsp;</label> <input
										type="text" name="pretensaoPara" class="form-control money2"
										placeholder="Até" style="width: 80px" value="${filtroC.pretensaoPara }">
								</div>
								<div class="col-md-3">
									<label for="exampleInputEmail1">Data:</label>
									<div class="input-group">
									<fmt:formatDate value="${filtroC.dataAberturaDe}"
												pattern="yyyy-MM-dd" var="d1" />
											<fmt:formatDate value="${filtroC.dataAberturaPara}"
												pattern="yyyy-MM-dd" var="d2" />
										<input type="date" name="dataAberturaDe" class="form-control" value="${d1 }">
										<span class="input-group-addon">até</span> <input type="date"
											name="dataAberturaPara" class="form-control" value="${d2 }">
									</div>
								</div>
								<div class="col-md-2 col-md-offset-1">
									<button class="btn btn-primary pull-right "
										style="margin-top: 22px">Pesquisar</button>
								</div>
								
							</form>
							<!-- /.row -->
						
						<br />
						<table
						id="tabelaVaga"
							class="table table-bordered table-condensed table-hover table-striped"
							style="font-size: 12px; vertical-align: middle">
							<thead>
								<tr>
									<th class="text-center">Nome do candidato</th>
									<th class="text-center">Vaga</th>
									<th class="text-center">Pretensão</th>
									<th class="text-center">Data de candidatura</th>
									<!-- <th class="text-center">Data de aprovação</th> -->
									<th class="text-center">Status</th>
									<th class="text-center">Ações</th>
								</tr>
							</thead>
							<tbody class="text-center">
								<c:forEach var="candidato" items="${candidatos}">
												
									<tr>
										<td>${candidato.nome}</td>
										<td>${candidato.vagaCandidato.vaga.nomeVaga}</td>
										 	
										<td><fmt:formatNumber value="${candidato.valorPretensao}" type="currency"></fmt:formatNumber></td>
										<td><fmt:formatDate value="${candidato.dataAbertura}" pattern="dd/MM/yyyy" /></td>
										<td id="linhaStatus"><span class="label" style="color: #fff; background-color: ${candidato.ultimoStatus.status.css}">${candidato.ultimoStatus.status.nome}</span></td>
							

							<td>
									<div class="btn-group">

												<button class="btn btn-xs btn-info dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
												</button>
												<ul class="dropdown-menu slidedown btnAlinhado">


													<li><c:url value="historico/${candidato.id}"
															var="myURL">
														</c:url> <a href="${myURL}"><i class="fa fa-pencil fa-lg">&nbsp;</i>Histórico
															do Candidato</a></li> <li class="divider"></li>

													<li><c:url value="editar/${candidato.id}" var="myURL">
														</c:url> <a href="${myURL}"><i class="fa fa-pencil"></i>
															Editar</a></li>
												


												</ul>
											</div></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>

						</div>
						<!-- /.panel-body - ATE AQUI O FILTRAR-->
						<div class="panel-footer clearfix">
						
                              <input type="hidden" id="pageActive" value="${page }">
                              <ul class="pagination pagination-xs m-top-none pull-right">
                                  <li>
                                      <c:if test="${page > 1}">
                                          <a href="<c:url value="/candidato/consultar" ><c:param name="page" value="${page - 1}"/></c:url>">Anterior</a>
                                      </c:if>
                                      <c:forEach begin="${startpage}" end="${endpage}" var="p">
                                          <a id="page${p}" href="<c:url value="/candidato/consultar" ><c:param name="page" value="${p}"/>${p}</c:url>">${p}</a>
                                      </c:forEach>
                                      <c:if test="${page < endpage}">
                                          <a href="<c:url value="/candidato/consultar" ><c:param name="page" value="${page + 1}"/></c:url>">Próximo</a>
                                      </c:if>
                                  </li>
                              </ul>
						
							<a href="/vaga/consultar" class="btn btn-xs btn-default"><i class="fa fa-reply"></i> Retornar</a>
							 			
					 	</div>
		
					</div>
					<!-- fim da div panel -->
				</div>
			
				<!-- /col-md-12 -->
			</div>
			<!-- /.row -->
		</div>
			<!-- /.paddin.md -->
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
	</layout:put>

	<layout:put block="scripts" type="REPLACE">
	<!-- JavaScript -->

	<script type="text/javascript">
	
	$('#page'+$('#pageActive').val()).addClass('active');
	
	$(document).ready(function(){
		 //$('.money2').mask("#.##0,00", {reverse: true});
	 });
		
		function info(listaId) {
			//
			$.ajax({
				url : "gerenciar",
				type : "GET",
				dataType : "JSON",
				data : {
					'id' : listaId
				},
				success : function(lista) {
					console.log(lista);
					//$('#titulo').html(lista.);
					$('input#nomeCandidato').val(lista.nome);
					$('input#nomeVaga').val(lista.vaga);
					$('input#nomeSenioridade').val(lista.senioridadeBean.nome);
				}
			})
		}
		$('#btn-retornar').click(function() {
			window.history.back();
		});
	</script>


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
		
		$(function	()	{
			
			$('#chk-all').click(function()	{
				if($(this).is(':checked'))	{
					$('#responsiveTable').find('.chk-row').each(function()	{
						$(this).prop('checked', true);
						$(this).parent().parent().parent().addClass('selected');
					});
				}
				else	{
					$('#responsiveTable').find('.chk-row').each(function()	{
						$(this).prop('checked' , false);
						$(this).parent().parent().parent().removeClass('selected');
					});
				}
			});
		});
	</script>
	<script type="text/javascript">
		//Escrevendo o código-fonte HTML e ocultando os campos criados:
		for (iLoop = 1; iLoop <= totalCampos; iLoop++) {
			document
					.write("<span id='linha"+iLoop+"' style='display:none'> <select class='btn btn-default btn-xs dropdown-toggle' style='width: 160px;'><option value='0'>Selecione etapa</option><option value='1'>Prova Prática</option><option value='2'>Prova teórica</option><option value='3'>Dinâmica de Grupo</option></select> <input type='text' id='arq"+iLoop+"' name='arq"+iLoop+"'> <input class='btn btn-xs btn-danger' type='button' value='Remover' onclick='RemoverCampos(\""
							+ iLoop + "\")'></span><br>");

		}
	</script>
		<script>/* paginação */

	</script>
	</layout:put>
</layout:extends>