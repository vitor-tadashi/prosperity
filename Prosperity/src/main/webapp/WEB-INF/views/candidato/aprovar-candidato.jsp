<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>

<layout:extends name="base">
	<layout:put block="contents">
		<!--    Modais   -->
		<!-- Modal Avaliação de Competencias -->
		<div id="modalProposta" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 style="text-align: center;" class="modal-title"
							id="modalTitulo">placeholder</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-tab clearfix">
								<ul class="tab-bar" id="tabs">
									<li id="entrevista-tab" class="active"><a
										href="#infoEntrevista" data-toggle="tab"><i
											class="fa fa-user"></i> Informações de entrevista</a></li>
									<li id="processo-tab"><a href="#processoSelecao"
										data-toggle="tab"><i class="fa fa-pencil"></i> Processo de
											seleção</a></li>
									<li id="avaliacao-tab"><a href="#avaliacaoComp"
										data-toggle="tab"><i class="fa fa-briefcase"></i>
											Avaliação de competências</a></li>
									<li id="proposta-tab"><a href="#proposta"
										data-toggle="tab"><i class="fa fa-money"></i> Proposta</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<form id="formValidar" data-validate="parsley" novalidate
									enctype="multipart/form-data">
									<input type="hidden" name="idCandidato" id="idCandidatoFile"
										value="">
									<div class="tab-content">
										<div class="tab-pane fade in active" id="infoEntrevista">
											<div class="form-group">
												<label class="control-label">Observação :</label>
												<div class="form-group">
													<input type="hidden" id="hdn-id-candidato" /> <input
														type="hidden" id="hdn-status" />
													<textarea class="form-control parsley-validated"
														id="parecer" style="margin-left: 0px; width: 800px"
														name="parecer" data-required="true" maxlength="500"
														rows="5" onkeyup="maxCaracterParecer()"></textarea>
													<label id="maxParecer">Caracteres restantes : 500</label>
												</div>
											</div>
										</div>
										<div class="tab-pane fade" id="processoSelecao">
											<div class="form-group">
												<div class="panel panel-default">
													<div class="panel-body">
														<div class="form-group col-md-12" id="processoSeletivo">
															<label>Etapas dos processos de seleção: </label> <input
																type="button" id="gerarCampo"
																value="Gerar etapa do processo seletivo"
																class="btn btn-sm btn-primary"> <br> <br>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="tab-pane fade" id="avaliacaoComp">
											<section class="panel panel-default">
												<div class="panel-heading text-center">
													<label for="exampleInputEmail1">Avaliação de
														competências</label>
												</div>
												<table id="tabelaCompetencias" class="table"
													style="font-size: 10px">
													<thead class="text-center">
														<tr class="text-center">
															<th class="text-center">Competências</th>
															<c:forEach var="avaliacao" items="${avaliacoes}">
																<th>${avaliacao.nome}</th>
															</c:forEach>
														</tr>
													</thead>
													<tbody class="text-center">
														<c:forEach var="competencia" items="${competencias}">
															<tr class="linhaAvaliacao">
																<td>${competencia.nome}</td>
																<c:forEach var="avaliacao" items="${avaliacoes}">
																	<td><label class="label-radio inline"> <input
																			class="avaliacaoCompetencia" type="radio"
																			alt="${avaliacao.id}"
																			name="avaliacao${competencia.nome}"
																			value="${competencia.id}"> <span
																			class="custom-radio"></span>
																	</label></td>
																</c:forEach>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</section>
										</div>
										<div class="tab-pane fade" id="proposta">
											<div class="panel panel-default">
												<div class="panel-heading">Proposta</div>
												<div class="panel-body">
													<div class="col-md-6 row">
														<div class="form-group">
															<label>Empresa anterior:</label> <input type="text" id="anteriorEmpresa"
																name="anteriorEmpresa" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Cargo:</label> <input type="text" id="anteriorCargo" name="anteriorCargo"
																class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Salário fixo bruto:</label> <input type="text"
																id="vlrAntSalarioFixoBruto" name="vlrAntSalarioFixoBruto" class="form-control dinheiro input-sm" min="0.01" step="0.01" max="2500" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Salário líquido mensal:</label> <input type="text"
																id="vlrAntSalarioLiquidoMensal" name="vlrAntSalarioLiquidoMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>VR mensal:</label> <input type="text" id="vlrAntVrMensal"
																name="vlrAntVrMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>VA mensal:</label> <input type="text" id="vlrAntVaMensal"
																name="vlrAntVaMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Seguro de saúde mensal:</label> <input type="text"
																id="vlrAntSeguroSaudeMensal" name="vlrAntSeguroSaudeMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Vale auto:</label> <input type="text" id="vlrAntValeAuto"
																name="vlrAntValeAuto" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Vale transporte(até 6% desc.):</label> <input
																type="text" id="vlrAntValeTransporte" name="vlrAntValeTransporte" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Líquido m. + ben.:</label> <input type="text"
																id="vlrAntLiquidoComBeneficios" name="vlrAntLiquidoComBeneficios" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Anual líquido:</label> <input type="text" id="vlrAntAnualLiquido"
																name="vlrAntAnualLiquido" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>PLR anual líquido/bonús:</label> <input
																type="text" id="vlrAntParticipacaoLucrosOuBonus" name="vlrAntParticipacaoLucrosOuBonus" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Total anual líquido + ben.:</label> <input
																type="text" id="vlrAntTotalAnualLiquidoComBeneficios" name="vlrAntTotalAnualLiquidoComBeneficios" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label>Empresa atual:</label> <input type="text" id="novaEmpresa" name="novaEmpresa"
																class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Cargo:</label> <input type="text" id="novoCargo" name="novoCargo"
																class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Salário fixo bruto:</label> <input type="text"
																id="vlrNvSalarioFixoBruto" name="vlrNvSalarioFixoBruto" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Salário líquido mensal:</label> <input type="text"
																id="vlrNvSalarioLiquidoMensal" name="vlrNvSalarioLiquidoMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>VR mensal:</label> <input type="text" id="vlrNvVrMensal"
																name="vlrNvVrMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>VA mensal:</label> <input type="text" id="vlrNvVaMensal"
																name="vlrNvVaMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Seguro de saúde mensal:</label> <input type="text"
																id="vlrNvSeguroSaudeMensal" name="vlrNvSeguroSaudeMensal" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Vale auto:</label> <input type="text" id="vlrNvValeAuto"
																name="vlrNvValeAuto" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Vale transporte(até 6% desc.):</label> <input
																type="text" id="vlrNvValeTransporte" name="vlrNvValeTransporte" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Líquido m. + ben.:</label> <input type="text"
																id="vlrNvLiquidoComBeneficios" name="vlrNvLiquidoComBeneficios" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Anual líquido:</label> <input type="text" id="vlrNvAnualLiquido"
																name="vlrNvAnualLiquido" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>PLR anual líquido/bonús:</label> <input
																type="text" id="vlrNvParticipacaoLucrosOuBonus" name="vlrNvParticipacaoLucrosOuBonus" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group">
															<label>Total anual líquido + ben.:</label> <input
																type="text" id="vlrNvTotalAnualLiquidoComBeneficios" name="vlrNvTotalAnualLiquidoComBeneficios" class="form-control dinheiro input-sm" disabled>
														</div>
														<!-- /form-group -->
													</div>
													<div class="form-group col-md-6 row">
														<label class="control-label">Proposta</label>
														<div class="upload-file" onchange="gerarProposta()">
															<input type="file" name="file" id="upload-proposta"
																class="upload-demo" required /> <label
																data-title="Selecione" for="upload-proposta"> <span
																id="caminho"></span>
															</label>
														</div>
													</div>
												</div>
												<!-- /panel -->
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="panel-footer clearfix">
								<button type="button" class="btn btn-sm btn-primary pull-right"
									id="btnEnviar">
									<i class="fa fa-check fa-lg"></i>&nbsp;Enviar
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Confirmação</h4>
					</div>
					<div class="modal-body">
						<p>Deseja confirmar a operação?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" id="alterarStatus">Sim</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal delete -->
		<div class="modal fade" id="delete-modal" data-target="#delete-modal"
			tabindex="-1" role="dialog" aria-labelledby="modalLabel"
			data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel">Cancelar candidato</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<form id="frmCancelar">
								<div class="row">
									<div class="form-group col-sm-12">
										<label for="cancelamento">Motivo do cancelamento:</label> <select
											class="form-control" id="cancelamento"
											name="candidato.cancelamento.id">
											<option value="0">Selecione</option>
											<c:forEach var="cancelamento" items="${cancelamento}">
												<option value="${cancelamento.id}"
													${cancelamento.id == candidato.cancelamento.id ? 'selected="selected"' : ''}>${cancelamento.descricao}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-sm-12">
										<label for="">Observação :</label> <input type="hidden"
											id="hdn-id-candidato" /> <input type="hidden"
											id="hdn-status" />
										<textarea class="form-control parsley-validated"
											id="parecerCancelamento" name="parecer" data-required="true"
											maxlength="300" rows="3"
											onkeyup="maxCaracterParecerCancelamento()"></textarea>
										<label id="maxParecerCanc">Caracteres restantes : 300</label>

									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<input type="hidden" id="idCancelamento" value="" />
						<button type="button" class="btn btn-success"
							onclick="cancelarCandidato()">Confirmar</button>
						<button button type="button" class="btn btn-danger"
							data-dismiss="modal">Cancelar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal delete-->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial">
							Página inicial</a></li>
					<li>Consultar</li>
					<li class="active">Aprovação de candidatos</li>
				</ul>
			</div>
			<!--breadcrumb-->
			<div class="padding-md">
				<div class="row">
					<div class="panel panel-default">
						<!-- MENSAGEM DE SUCESSO -->
						<div id="msg-sucesso"></div>
						<div class="panel-heading">Aprovação de candidatos</div>
						<div class="panel-body">
							<input type="hidden" name="user" id="user"
								value="${autenticado.perfil.nome}" />
							<table
								class="table table-bordered table-condensed table-hover table-striped"
								id="tabelaCandidato"
								style="font-size: 12px !important; vertical-align: middle !important;">
								<thead>
									<tr>
										<th class="text-center">Nome do candidato</th>
										<th class="text-center">Vaga</th>
										<th class="text-center">Pretensão</th>
										<th class="text-center">Data de abertura</th>
										<th class="text-center">Status</th>
										<th class="text-center">Ações</th>
									</tr>
								</thead>
								<tbody class="text-center">
									<form id="form">
										<c:forEach var="candidato" items="${candidatos}">
											<tr id="js-trCandidato_${candidato.id}">
												<input type="hidden" id="${candidato.id}" />
												<td>${candidato.nome}</td>
												<td>${candidato.ultimaVaga.nomeVaga}</td>
												<td><fmt:formatNumber
														value="${candidato.valorPretensao}" minFractionDigits="2"
														type="currency" /></td>
												<td><fmt:formatDate value="${candidato.dataAbertura}"
														pattern="dd/MM/yyyy" /></td>
												<td><span class="label"
													style="color: #fff; background-color: ${candidato.ultimoStatus.status.css}">${candidato.ultimoStatus.status.nome}</span></td>
												<td><input type="hidden" name="idStatus" id="idStatus"
													value="${candidato.ultimoStatus.status.id}" />
													<div class="btn-group">
														<button class="btn btn-xs btn-info dropdown-toggle"
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="fa fa-cogs fa-sm">&nbsp;</i> <span
																class="caret"></span>
														</button>
														<ul class="dropdown-menu dropdown-menu-right slidedown">
															<c:forEach var="statusDisponivel"
																items="${candidato.ultimoStatus.status.statusDisponiveis}">
																<li><a class="clickable" id="aprovar-candidato"
																	onclick="alterarStatus('${candidato.id}', '${statusDisponivel.idStatusDisponivel}', '${candidato.nome}')">
																		<i ${statusDisponivel.classe}>&nbsp;</i>${statusDisponivel.nome}</a></li>
																<li class="divider"></li>
															</c:forEach>
															<li><c:url
																	value="cancelar-candidato/${candidato.id}"
																	var="urlCancelar">
																</c:url><a href="#delete-modal"
																onclick="cancelarClick('${candidato.id}', '${candidato.nome}')"
																data-toggle="modal"><i class="fa fa-trash-o fa-lg">&nbsp;</i>Cancelar</a></li>
															<!-- /fim botao -->
														</ul>
													</div> <!-- /btn-group --></td>
											</tr>
										</c:forEach>
									</form>
								</tbody>
								<c:if test="${empty candidatos}">
									<tfoot>
										<tr>
											<td colspan="6">Nenhum registro</td>
										</tr>
									</tfoot>
								</c:if>
							</table>
						</div>
						<!-- /.row -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /col-md-12 -->
			</div>
			<!-- /.row -->
			<!-- /.paddin.md -->
		</div>

	</layout:put>
	<layout:put block="scripts" type="REPLACE">

		<script src="/resources/js/parsley.min.js"></script>
		<!-- <script src="/resources/js/custom/aprovar-candidato.js"></script> -->
		<script>
			var nomeCandidato;

			function maxCaracterParecer() {
				var maxParecer = $("#parecer").val();
				var restante = 500 - maxParecer.length;
				var maxCaracteres = document.querySelector("#maxParecer");
				maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
			}
			function maxCaracterParecerCancelamento() {
				var maxParecer = $("#parecerCancelamento").val();
				var restante = 300 - maxParecer.length;
				var maxCaracteres = document.querySelector("#maxParecerCanc");
				maxCaracteres.innerHTML = "Caracteres restantes : " + restante;
			}

			$("body")
					.on(
							"click",
							"#aprovar-candidato",
							function() {
								var inputs = $(this).closest("tr").find(
										"input[type=hidden]");
								var tituloModal = $(this).text();

								inputs
										.each(function(index, value) {
											if (!isNaN($(value).attr("id"))) {
												var id = $(value).attr("id");

												$
														.ajax({
															url : "buscar/"
																	+ id,
															dataType : "json",
															method : "GET",
															success : function(
																	data) {
																var perfil = $(
																		'#user')
																		.val();
																$(
																		"#modalTitulo")
																		.text(
																				tituloModal);
																if (data.ultimoStatus.status.id == "9") {
																	if (perfil == "Analista de RH"
																			|| perfil == "Gestor RH") {
																		$(
																				"#proposta-tab")
																				.show();
																	}
																} else if (data.ultimoStatus.status.id == "10") {
																	if (perfil == "Administrador"
																			|| perfil == "CEO"
																			|| perfil == "Diretor de operação") {
																		$(
																				"#proposta-tab")
																				.show();
																	}
																} else if (data.ultimoStatus.status.id == "11") {
																	if (perfil == "Analista de RH"
																			|| perfil == "Gestor RH") {
																		$(
																				"#proposta-tab")
																				.show();
																	}
																} else if (data.ultimoStatus.status.id == "13") {
																	if (perfil == "Analista de RH"
																			|| perfil == "Gestor RH") {
																		$(
																				"#proposta-tab")
																				.show();
																	}
																} else if (data.ultimoStatus.status.id == "14") {
																	if (perfil == "Analista de RH"
																			|| perfil == "Gestor RH") {
																		$(
																				"#proposta-tab")
																				.show();
																	}
																} else {
																	$(
																			"#proposta-tab")
																			.hide();
																}
																if (data.ultimoStatus.status.id == "6") {
																	$(
																			"#avaliacao-tab")
																			.show();
																	$(
																			"#processo-tab")
																			.show();
																} else {
																	$(
																			"#avaliacao-tab")
																			.hide();
																	$(
																			"#processo-tab")
																			.hide();
																}
																$(
																		'.tab-bar a[href="#infoEntrevista"]')
																		.tab(
																				'show');
																$(
																		'#modalProposta')
																		.modal(
																				'show');
															}
														})
											}
										});

								function alterarStatus(id, status, nome) {

									nomeCandidato = nome;

									$('input.cancelar-id').val(id);
									$('input.cancelar-status').val(status);
								}

							})
			$('#alterarStatus').click(
					function() {
						var avaliacoes = [];

						$(".avaliacaoCompetencia").each(function() {
							if ($(this).prop("checked")) {
								var idAvaliacao = $(this).attr("alt");
								var idCompetencia = $(this).val();
								avaliacoes.push(idAvaliacao);
								avaliacoes.push(idCompetencia);
							}
						});

						var provasDescricoes = [];
						var x = 0;
						$(".processoSeletivo").each(function() {
							var provaDescricao = {
								"prova" : "",
								"descricao" : ""
							};

							var select = $(this).find("#prova-js").val();
							var input = $(this).find("#descricao-js").val();

							provasDescricoes.push(select);
							provasDescricoes.push(input);
							x++;
						});
						file();

						$.ajax({
							url : "alterar-status-candidato",
							method : "POST",
							dataType : "JSON",
							data : {
								'idCandidato' : $('#hdn-id-candidato').val(),
								'parecer' : $('#parecer').val(),
								'idStatus' : $('#hdn-status').val(),
								'parecerTecnico' : $('#parecerTecnico').val(),
								'processoSelectivo' : JSON
										.stringify(provasDescricoes),
								'ac' : JSON.stringify(avaliacoes)
							},
							success : function(data) {
								$('#confirm-modal').modal('hide');
								msg = 'O candidato <strong>' + nomeCandidato
										+ '</strong> foi alterado com sucesso!'
								$('#msg-sucesso').html(msg).addClass(
										'alert alert-success').show();
								escondeMensagem();
							},
							error : function(e) {
								location.reload();
							}
						});
					});

			function file() {
				var paperElement = document.getElementById("modalPapers");

				if ($(paperElement).val()) {
					var form = document.getElementById("formValidar");
					var formData = new FormData(form);
					var xhr = new XMLHttpRequest();
					xhr.open('POST', "submitFiles");
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4 && xhr.status == 200) {
							console.log("Files Uploaded")
						}
					};
					xhr.send(formData);
				}
			}

			function alterarStatus(idCandidato, idStatus, proposta) {
				$('#hdn-id-candidato').val(idCandidato);
				$('#hdn-proposta').val(proposta);
				$('#hdn-status').val(idStatus);
				$('#idCandidatoFile').val(idCandidato);
			}

			function cancelarClick(id, nome) {

				nomeCandidato = nome;

				$("#idCancelamento").val(id);

				$('#frmCancelar')[0].reset();
				maxCaracterParecerCancelamento();
			}

			/*gerador de campo*/
			var cont = 0;
			$("#gerarCampo")
					.click(
							function() {

								var campos =

								"<div class='div"+cont+" processoSeletivo'>"
										+ "<div class='row'>"
										+ "<div class='col-md-6 form-inline'>"
										+ "<a id='btnRemover' onclick='remover("
										+ cont
										+ ")'class='text-danger fa fa-times fa-lg'></a>"
										+ "&nbsp;<select class='form-control' id='prova-js'>"
										+ "<option value='0'>Selecione</option>"
										+ "<c:forEach var='selecao' items='${provas}'>"
										+ "<option value='${selecao.id}'>${selecao.nome}</option>"
										+ "</c:forEach>"
										+ "</select>"
										+ "<input class='form-control descricaoProva' type='text'	id='descricao-js' name='descricao"
										+ cont
										+ "' placeholder='Descrição' maxlength='50'	onkeyup='maxDescricaoProva()' />"
										+ "</div>"
										+ "<div class='col-md-5 form-inline'>"
										+ "<input name='papers' id='modalPapers' type='file' class='input-sm' multiple data-input='false'>"
										+ "</div>"
										+ "&nbsp; &nbsp;<label id='maxDescricao'>Caracteres restantes : <span class='numeroCaracteres" + cont +"'>50</span></label>"
										+ "</div>" + "</div>";
								cont++;
								/*adiciona na div*/
								$("#processoSeletivo").append(campos);

								/*contador de caracter - descrição prova*/
							});
			/*remove os campos*/

			function maxDescricaoProva() {
				var cont = 0;
				$(".descricaoProva").each(function() {

					var descricao = $(this).val().length;
					var restante = 50 - descricao;
					$(".numeroCaracteres" + cont).text(restante);
					cont++;
				})

			}
			function remover(id) {
				$(".div" + id).remove();
				cont--;
			}

			// Submit do formulário
			$("button#btnEnviar").click(function() {
				$("form#formValidar").submit();
				if ($('form#formValidar').parsley('isValid')) {
					$('#confirm-modal').modal('show');
				}
			});

			$(document).ready(function() {
				$('form#formValidar').parsley();

				$('form#formValidar').on('submit', function(e) {
					e.preventDefault();
					$(this).parsley().validate();
				});
			});

			function gerarProposta() {
				var paperElement = document.getElementById("upload-proposta");

				if ($(paperElement).val()) {
					var form = document.getElementById("formValidar");
					var formData = new FormData(form);
					$.ajax({
						url : 'gerar-proposta',
						enctype : 'multipart/form-data',
						type : 'POST',
						data : formData,
						processData : false,
						contentType : false,
						cache : false,
						success : function(data) {
						},
					});
				}
				$.ajax({
					url : "proposta",
					type : "GET",
					success : function(data) {
						$("#anteriorEmpresa").val(data.anteriorEmpresa);
						$("#anteriorCargo").val(data.anteriorCargo);
						$("#vlrAntSalarioFixoBruto").val(data.anteriorSalarioFixoBruto);
						$("#vlrAntSalarioLiquidoMensal").val(data.anteriorSalarioLiquidoMensal);
						$("#vlrAntVrMensal").val(data.anteriorVrMensal);
						$("#vlrAntVaMensal").val(data.anteriorVaMensal);
						$("#vlrAntSeguroSaudeMensal").val(data.anteriorSeguroSaudeMensal);
						$("#vlrAntValeAuto").val(data.anteriorValeAuto);
						$("#vlrAntEstacionamento").val(data.anteriorEstacionamento);
						$("#vlrAntValeTransporte").val(data.anteriorValeTransporte);
						$("#vlrAntLiquidoComBeneficios").val(data.anteriorLiquidoComBeneficios);
						$("#vlrAntAnualLiquido").val(data.anteriorAnualLiquido);
						$("#vlrAntParticipacaoLucrosOuBonus").val(data.anteriorParticipacaoLucrosOuBonus);
						$("#vlrAntTotalAnualLiquidoComBeneficios").val(data.anteriorTotalAnualLiquidoComBeneficios);
						
						$("#novaEmpresa").val(data.novaEmpresa);
						$("#novoCargo").val(data.novoCargo);
						$("#vlrNvSalarioFixoBruto").val(data.novoSalarioFixoBruto);
						$("#vlrNvSalarioLiquidoMensal").val(data.novoSalarioLiquidoMensal);
						$("#vlrNvVrMensal").val(data.novoVrMensal);
						$("#vlrNvVaMensal").val(data.novoVaMensal);
						$("#vlrNvSeguroSaudeMensal").val(data.novoSeguroSaudeMensal);
						$("#vlrNvValeAuto").val(data.novoValeAuto);
						$("#vlrNvEstacionamento").val(data.novoEstacionamento);
						$("#vlrNvValeTransporte").val(data.novoValeTransporte);
						$("#vlrNvLiquidoComBeneficios").val(data.novoLiquidoComBeneficios);
						$("#vlrNvAnualLiquido").val(data.novoAnualLiquido);
						$("#vlrNvParticipacaoLucrosOuBonus").val(data.novaParticipacaoLucrosOuBonus);
						$("#vlrNvTotalAnualLiquidoComBeneficios").val(data.novoTotalAnualLiquidoComBeneficios);
					},
					error : function(data) {
						alert("Deu ruim");
					}
				});
				$('.dinheiro').mask('000.000,00', {reverse: true});
			};

			function cancelarCandidato() {
				var id = $("#idCancelamento").val();
				debugger;
				$.ajax({
					url : "cancelar-candidato/" + id,
					type : "POST"
				}).done(
						function() {
							$('#delete-modal').modal('hide');
							msg = 'O candidato <strong>' + nomeCandidato
									+ '</strong> foi cancelado com sucesso!'
							$('#msg-sucesso').html(msg).addClass(
									'alert alert-success').show();
							$('#js-trCandidato_' + id).remove();
							escondeMensagem();
						}).fail(function(jqXHR, textStatus) {
					location.reload();
				});
			}

			function escondeMensagem(id) {
				window.setTimeout(function() {
					$("#msg-sucesso").hide();
					$(".mensagem").hide();
				}, 5000);
			}
			/* paginação */
		</script>
	</layout:put>
</layout:extends>
