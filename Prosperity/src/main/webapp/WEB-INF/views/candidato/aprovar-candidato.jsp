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
													<div class="col-md-6">
														<div class="form-group">
															<label class="col-md-6">Empresa anterior:</label>
															<p class="col-md-1">&nbsp;</p>
															<p id="anteriorEmpresa" class="col-md-5"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Cargo:</label>
															<p class="col-md-1">&nbsp;</p>
															<p class="col-md-5" id="anteriorCargo"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Salário fixo bruto:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntSalarioFixoBruto"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Salário líquido mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntSalarioLiquidoMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">VR mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro"  id="vlrAntVrMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">VA mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntVaMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Seguro de saúde mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntSeguroSaudeMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Vale auto:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntValeAuto"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Vale estacionamento:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntValeEstacionamento"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Vale transporte:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntValeTransporte"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Líquido m. + ben.:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntLiquidoComBeneficios"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Anual líquido:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntAnualLiquido"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">PLR anual líquido/bonús:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntParticipacaoLucrosOuBonus"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Total anual líquido + ben.:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrAntTotalAnualLiquidoComBeneficios"></p>
														</div>
													</div>
													<div class="col-md-6 row">
														<div class="form-group">
															<label class="col-md-6">Empresa atual:</label>
															<p class="col-md-1">&nbsp;</p>
															<p class="col-md-5" id="novaEmpresa"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Cargo:</label>
															<p class="col-md-1">&nbsp;</p>
															<p class="col-md-5" id="novoCargo"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Salário fixo bruto:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvSalarioFixoBruto"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Salário líquido mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvSalarioLiquidoMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">VR mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvVrMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">VA mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvVaMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Seguro de saúde mensal:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvSeguroSaudeMensal"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Vale auto:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvValeAuto"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Vale estacionamento:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvValeEstacionamento"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Vale transporte:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvValeTransporte"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Líquido m. + ben.:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvLiquidoComBeneficios"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Anual líquido:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvAnualLiquido"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">PLR anual líquido/bonús:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvParticipacaoLucrosOuBonus"></p>
														</div>
														<div class="form-group">
															<label class="col-md-6">Total anual líquido + ben.:</label>
															<p class="col-md-1">R$ </p>
															<p class="col-md-5 dinheiro" id="vlrNvTotalAnualLiquidoComBeneficios"></p>
														</div>
														<!-- /form-group -->
													</div>
													<div class="form-group col-md-6">
														<label class="control-label">Importe a proposta</label>
														<div class="upload-file" onchange="gerarProposta()">
															<input type="file" name="file" id="upload-proposta"
																class="upload-demo" required/> <label
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
		<script src="/resources/js/custom/aprovar-candidato.js"></script>
		<script>
		/*gerador de campo*/
		var cont = 0;
		$("#gerarCampo").click(function() {
			var campos =
				"<div class='div"+cont+" processoSeletivo'>"
				+ "<div class='row'>"
				+ "<div class='col-md-4 form-inline'>"
				+ "<a id='btnRemover' onclick='remover("
				+ cont
				+ ")'class='text-danger fa fa-times fa-lg'></a>"
				+ "&nbsp;<select class='form-control parsley-validated' id='prova-js' data-required='true'>"
				+ "<option value='0'>Selecione</option>"
				+ "<c:forEach var='selecao' items='${provas}'>"
				+ "<option value='${selecao.id}'>${selecao.nome}</option>"
				+ "</c:forEach>"
				+ "</select>"
				+ "</div>"
				+ "<div class='col-md-5 form-inline'>"
				+ "<input name='papers' id='modalPapers' type='file' class='input-sm parsley-validated' multiple data-input='false' data-required='true'>"
				+ "</div>"
				+ "</div>" + "</div>";
				cont++;
				/*adiciona na div*/
			$("#processoSeletivo").append(campos);

			/*contador de caracter - descrição prova*/
		});
		</script>

	</layout:put>
</layout:extends>
