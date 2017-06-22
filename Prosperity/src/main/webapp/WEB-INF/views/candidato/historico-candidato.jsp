<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Histórico de candidato</title>
		<link rel="stylesheet" href="/resources/css/custom/timeline.css" />
	</layout:put>
	
	<layout:put block="contents">
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						Início</a></li>
				<li class="active">Histórico candidato</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->
		<div class="padding-md">
			<div class="row">
				<section class="panel panel-default">
					<div class="panel-heading">Informações básicas</div>
					<div class="panel-body">
						<div class="panel-tab clearfix">
							<ul class="tab-bar wizard-demo" id="wizardDemo">
								<li class="active tab-verity"><a href="#first"
									data-toggle="tab"><i class="fa fa-user"></i> Dados gerais</a></li>
								<li class="tab-verity"><a href="#second"
									data-toggle="tab" class="text-success"><i
										class="fa fa-pencil"></i> Processo seletivo</a></li>
								<li class="tab-verity"><a href="#third" data-toggle="tab"
									class="text-success"><i class="fa fa-code-fork"></i> Linha do tempo</a></li>
							</ul>
						</div>
						<br>
						<div class="panel-body">
							<div class="tab-content">
								<div class="tab-pane fade in active" id="first">
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Informações básicas</strong></h5></legend>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Nome: </strong>${candidato.nome}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Data de nascimento: </strong><fmt:formatDate value="${candidato.dataNascimento}"
													pattern="dd/MM/yyyy" /></p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>CPF: </strong>${candidato.cpf}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>RG: </strong>${candidato.rg}</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>E-mail: </strong>${candidato.email}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Telefone: </strong>${candidato.contato.telefone}</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Pretensão salarial: </strong>R$ ${candidato.valorPretensao }</p>
											</div>
											<c:if test="${not empty candidato.curriculo }">
												<div class="form-group col-md-6">
													<p class="" id="nome"><strong>Currículo: </strong>&nbsp;&nbsp;<a href="/candidato/file/${candidato.id}" target="_blank" data-toggle="tooltip" title="Baixar currículo" class="fa fa-download fa-lg"></a></p>
												</div>
											</c:if>
										</div>
									</fieldset>
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Endereço</strong></h5></legend>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Logradouro: </strong>${candidato.endereco.logradouro}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Número: </strong>${candidato.endereco.numero}</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Complemento: </strong>${candidato.endereco.complemento}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>CEP: </strong>${candidato.endereco.cep}</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Cidade: </strong>${candidato.endereco.cidade}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Estado: </strong>${candidato.endereco.estado}</p>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Formação</strong></h5></legend>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Curso: </strong>${candidato.formacao.nomeCurso}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Instituição: </strong>${candidato.formacao.nomeInstituicao}</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Grau de instrução: </strong>${candidato.formacao.tipoCurso.nome}</p>
											</div>
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Situação Atual: </strong>${candidato.formacao.situacaoAtual.descricao}</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-6">
												<p class="" id="nome"><strong>Data de conclusão: </strong><fmt:formatDate value="${candidato.formacao.dataConclusao}"
													pattern="dd/MM/yyyy" /></p>
											</div>
										</div>
									</fieldset>
								</div>
								<div class="tab-pane fade" id="second">
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Vaga aplicado</strong></h5></legend>
										<div class="row">
											<div class="form-group col-md-4">
												<p class="" id="nome"><strong>Vaga: </strong>${candidato.ultimaVaga.nomeVaga}</p>
											</div>
											<div class="form-group col-md-4">
												<p class="" id="nome"><strong>Solicitante: </strong>${candidato.ultimaVaga.nomeSolicitante}</p>
											</div>
											<div class="form-group col-md-4">
												<p class="" id="nome"><strong>Horário: </strong>${candidato.ultimaVaga.horarioEntrada} às ${candidato.ultimaVaga.horarioSaida }</p>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-md-4">
												<p class="" id="nome"><strong>Cargo: </strong>${candidato.ultimaVaga.cargoBean.nome}</p>
											</div>
											<div class="form-group col-md-4">
												<p class="" id="nome"><strong>Senioridade: </strong>${candidato.ultimaVaga.senioridadeBean.nome}</p>
											</div>
											<div class="form-group col-md-4 bootstrap-timepicker">
												<p class="" id="nome"><strong>Data de início: </strong><fmt:formatDate value="${candidato.ultimaVaga.dataInicio}" pattern="dd/MM/yyyy"/></p>
											</div>
										</div>
									</fieldset>	
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Datas de contatos</strong></h5></legend>
										<div class="row">
											<div class="col-md-12">
												<c:forEach items="${datasContatos }" var="dtContato">
													<div class="col-md-2">
														<p class="" id="nome"><i class="fa fa-calendar"></i> <fmt:formatDate value="${dtContato.dataContato}"
															pattern="dd/MM/yyyy" /></p>
														<p class="" id="nome"><strong>Avaliador:</strong>${dtContato.usuarioBean.funcionario.nome}</p>
													</div>
													<div class="col-md-4">
														<p class="" id="nome"><strong>Obs:</strong> ${dtContato.observacao }</p>
														<p> &nbsp;</p>
													</div>
												</c:forEach>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Datas de entrevistas</strong></h5></legend>
										<div class="row">
											<div class="col-md-12">
												<c:forEach items="${candidato.dataEntrevista }" var="dtEntrevista">
													<c:if test="${not empty dtEntrevista.dataEntrevista}">
														<div class="col-md-3">
															<p class="" id="nome"><i class="fa fa-calendar"></i> <fmt:formatDate value="${dtEntrevista.dataEntrevista}"
																pattern="dd/MM/yyyy" /></p>
															<p class="" id="nome"><strong>Avaliador:</strong> ${dtEntrevista.usuario.funcionario.nome }</p>
														</div>
													</c:if>
												</c:forEach>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Provas aplicadas</strong></h5></legend>
										<div class="row">
											<div class="col-md-12">
												<c:forEach items="${provas }" var="prova" varStatus="i">
													<c:if test="${prova.idVaga == candidato.ultimaVaga.id }">
													<div class="col-md-2">
													<input type="hidden" id="p${i.count }" value="${prova.caminhoProva }">
													<c:url value="/candidato/papers" var="url">
														<c:param name="caminho">${prova.caminhoProva}</c:param>
													</c:url>
														<p class="" id="nome"><strong>${i.count }.</strong> ${prova.provas.nome }&nbsp;&nbsp;<a href="${url }" target="_blank" data-toggle="tooltip" title="Baixar prova" class="fa fa-download fa-lg"></a></p>
													</div>
													</c:if>
												</c:forEach>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Avaliação de skill</strong></h5></legend>
										<div class="row">
											<c:forEach begin="1" end="${colCompetencias }" var="i">
												<div class="form-group col-md-4">
													<p class="text-center" id="nome"><strong>Avaliador: </strong>${candidato.competencias[(i * 7) -1].nmAvaliador }</p>
													<table class="table table-condensed">
														<tbody>
															<tr>
																<th class="text-center">Competências</th>
																<th class="text-center">Resultados</th>
															</tr>
															<c:forEach var="c" begin="${(i*7)-7 }" end="${(i * 7) -1 }">
																<tr class="text-center">
																	<td>${candidato.competencias[c].competencia.nome}</td>
																	<td><span class="badge" style="color:#fff; background-color:${candidato.competencias[c].avaliacao.tipoCss}">${candidato.competencias[c].avaliacao.nome}</span></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</c:forEach>
										</div>
									</fieldset>
								</div>
								<div class="tab-pane fade" id="third">
									<fieldset>
										<legend style="color:#424f63"><h5><strong>Eventos do processo seletivo</strong></h5></legend>
										<ul class="timeline">
											<c:set var="c" value="0" scope="page" />
											<c:forEach var="statusPorMesAno"
												items="${candidato.statusPorMesAno}">
												<li><div class="tldate">${statusPorMesAno.key}</div></li>
												<c:forEach var="status" items="${statusPorMesAno.value}"
													varStatus="count">
				
													<c:choose>
														<c:when test="${count.index %2 eq 0}">
															<c:set value="timeline" var="cssTimeline"></c:set>
														</c:when>
														<c:otherwise>
															<c:set value="timeline-inverted" var="cssTimeline"></c:set>
														</c:otherwise>
													</c:choose>
				
													<li class="${cssTimeline}">
														<div class="tl-circ" style="background:${status.status.css}"></div>
														<div class="timeline-panel">
															<div class="tl-heading">
																<h4>Status: ${status.status.nome}  ${status.nomeVaga } </h4>
																<p>
																	<small class="text-muted"><i class="fa fa-calendar"></i>
																		<fmt:formatDate value="${status.dataAlteracao}"
																			pattern="dd/MM/yyyy" /></small>
																</p>
															</div>
															<div class="tl-body">
																<div class="col-md-12">
																	<div class="row">
																		<p class="desParecer">
																			<label>Parecer:</label> <span>${status.descricaoParecer}</span>
																		</p>
																	</div>
																	<div class="row">
																		<p>
																			<label>Funcionário:</label> <span>${status.usuario.funcionario.nome}</span>
																		</p>
																	</div>
																	<c:if test="${status.status.id == 17}">
																		<div class="row">
																			<p class="">
																				<label>Motivo:</label> <span>${status.cancelamento.descricao}</span>
																			</p>
																		</div>
																		<div class="row">
																			<p class="">
																				<label> Obs:</label> <span>${status.dsCancelamento}</span>
																			</p>
																		</div>
																	</c:if>
																	<c:if test="${status.status.id == 10}">
																		<div class="row hide proposta-js">
																			<p class="">
																				<label>Salário anual c/ benef.:</label>R$: <span>${candidato.propostaBean[c].anteriorTotalAnualLiquidoComBeneficios}</span>
																				<i class="fa fa-long-arrow-right"></i>
																				R$: <span>${candidato.propostaBean[c].novoTotalAnualLiquidoComBeneficios}</span>
																			</p>
																		<input type="hidden" value="${c=c+1 }">
																		</div>
																	</c:if>
																</div>
															</div>
														</div>
													</li>
												</c:forEach>
											</c:forEach>
										</ul>
									</fieldset>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- /Section -->
			</div>
			<!-- /.padding-md -->
		</div>
	</div>
	</layout:put>
	<layout:put block="scripts" type="REPLACE">
	<script>	
		$(function() {
			$('p.desParecer').each(function() {
				if($(this).find('span').text() == '') {
					$(this).remove();
				}
			});
			if($('#funcionalidade23').val() || $('#funcionalidade26').val()){
				$('.proposta-js').removeClass('hide');
			}
		});
		function baixarProva(index){
			var url = $('#p'+index).val()
			$.ajax({
				url : "/candidato/papers",
				data : {
					'caminho' : url
				},
				type : "POST",
				success : function() {
					console.log('sucesso');
					}
			});
		}
		
		
	</script>
	</layout:put>
</layout:extends>