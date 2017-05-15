<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Cadastro de Candidato</title>
	</layout:put>

	<layout:put block="contents">
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial">
							Página inicial</a></li>
					<li>Candidato</li>
					<li class="active">Cadastrar</li>

				</ul>
			</div>
			<!--breadcrumb-->

			<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->

			<div class="padding-md">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">Informações do candidato</div>

						<div class="panel-body">
							<div id="textDiv">
								<c:forEach var="erro" items="${listaErros}">
									<p>${erro}</p>
								</c:forEach>
							</div>
							<c:if test="${not empty sucesso}">
								<div id="msg-sucesso" class="alert alert-success msg-margin">
									<ul style="list-style: none;">
										<li class="li-msg">${sucesso}</li>
									</ul>
								</div>
							</c:if>

							<div id="textDiv1"></div>
							<div id="textDiv2"></div>
							<div id="textDiv3"></div>
							
							<form class="form-border" action="salvar" method="post"
								enctype="multipart/form-data" id=formCadastro
								onsubmit="validarVaga()">

								<!--TABS DA PÁGINA -->

								
								<fmt:formatDate value="${candidato.dataAbertura}"
														pattern="dd/MM/yyyy" var="dataAbertura" />
								
								<input type="hidden" name="dataAbertura" value="${dataAbertura}">

								<div class="panel-tab clearfix">
									<ul class="tab-bar wizard-demo" id="wizardDemo">
										<li class="active tab-verity"><a href="#first"
											data-toggle="tab"><i class="fa fa-user"></i> Inf.
												pessoais</a></li>
										<li class="tab-verity"><a href="#second"
											data-toggle="tab" class="text-success"><i
												class="fa fa-pencil"></i> Inf. acadêmicas</a></li>
										<li class="tab-verity"><a href="#third" data-toggle="tab"
											class="text-success"><i class="fa fa-briefcase"></i> Inf.
												vaga</a></li>
										<li class="tab-verity"><a href="#fourth"
											data-toggle="tab" class="text-success"><i
												class="fa fa-calendar"></i>&nbsp;Datas de entrevista</a></li>
										<li class="tab-verity"><a href="#five" data-toggle="tab"
											class="text-success"><i class="fa fa-calendar"></i> Data ultimo 
											contato</a></li>
									</ul>
								</div>
								<div class="panel-body">
									<div class="tab-content">
										<div class="tab-pane fade in active" id="first">
											<div class="row">
												<input type="hidden" value="${candidato.id}" id="id"
													name="id">
												<div class="form-group col-md-3">
													<label for="cpf" class="control-label">CPF</label>
													<input type="text"
														class="form-control cpf parsley-validated" id="cpf"
														name="cpf" data-required="true"
														placeholder="Informe seu CPF" value="${candidato.cpf}"
														onblur="pesquisacpf()" ${not empty candidato.id ? 'disabled="disabled"' : ''} />
													<input type="hidden" id="cpf" name="cpf"
														value="${candidato.cpf}" />
												</div>
												<div class="form-group col-md-4">
													<label class="control-label" for="nome">Nome</label> <input
														value="${candidato.nome}" type="text"
														placeholder="Informe seu nome" maxlength="100"
														class="form-control parsley-validated" data-minlength="8"
														id="nome" name="nome">
												</div>
												<div class="form-group col-md-3">
													<label for="email" class="control-label">E-mail</label> <input
														type="email" class="form-control parsley-validated"
														id="email" name="email" data-required="true"
														maxlength="100" placeholder="Informe seu email"
														value="${candidato.email}">
												</div>

												<div class="form-group col-md-2">
													<label for="rg" class="control-label">RG</label> <input
														type="text" class="form-control rg parsley-validated"
														maxlength="50" id="rg" name="rg" data-required="true"
														data-required="true" placeholder="Informe seu RG"
														value="${candidato.rg}">
												</div>
												<div class="form-group col-md-2 col-sm-4">
													<label for="dataNascimento" class="control-label">Data
														nascimento</label>
													<fmt:formatDate value="${candidato.dataNascimento}"
														pattern="dd/MM/yyyy" var="dataNascimento" />
													<input type="text" class="form-control date"
														name="dataNascimento" data-required="false"
														id="dataNascimento" onblur="validarData('dataNascimento')"
														value="${dataNascimento}">
												</div>
												<div class="form-group col-md-2">
													<label for="contato" class="control-label">Telefone</label>
													<input type="text"
														class="form-control telefone parsley-validated"
														maxlength="30" placeholder="Informe seu telefone"
														data-required="true" id="contato" name="contato.telefone"
														onchange="validarTel()"
														value="${candidato.contato.telefone}">
												</div>
												<div class="form-group col-md-2">
													<label for="cep" class="control-label">CEP</label> <input
														type="text" class="form-control cep parsley-validated"
														id="cep" name="endereco.cep" placeholder="Informe seu CEP"
														value="${candidato.endereco.cep}" data-required="true"
														onblur="pesquisacep(this.value)" />
												</div>
												<div class="form-group col-md-6">
													<label for="rua" class="control-label">Endereço</label> <input
														type="text" class="form-control parsley-validated"
														id="rua" data-required="true" name="endereco.logradouro"
														value="${candidato.endereco.logradouro}" />
												</div>
												<div class="form-group col-md-2">
													<label for="numero" class="control-label">Número</label> <input
														type="number" class="form-control parsley-validated"
														id="numero" data-required="true" name="endereco.numero"
														value="${candidato.endereco.numero}">
												</div>
												<div class="form-group col-md-3">
													<label for="complemento" class="control-label">Complemento</label>
													<input type="text" class="form-control" id="complemento"
														data-required="true" name="endereco.complemento"
														value="${candidato.endereco.complemento}">
												</div>
												<div class="form-group col-md-3">
													<label for="uf" class="control-label">Estado</label> <input
														type="text" class="form-control parsley-validated" id="uf"
														data-required="true" name="endereco.estado"
														value="${candidato.endereco.estado}" />

												</div>
												<div class="form-group col-md-4">
													<label for="cidade" class="control-label">Cidade</label> <input
														type="text" class="form-control parsley-validated"
														id="cidade" data-required="true" name="endereco.cidade"
														value="${candidato.endereco.cidade}" />
												</div>
												<div class="form-group col-xs-12">
													<label class="control-label">Currículo</label>
													<div class="upload-file" style="width: 356px;">
														<input type="file" id="upload-curriculo" name="file"
															class="upload-demo" value="${candidato.curriculo}">
														<label data-title="Selecione" for="upload-curriculo">
															<span data-title="Nenhum arquivo selecionado..."></span>
														</label>
													</div>
												</div>
											</div>
										</div>
										<div class="tab-pane fade" id="second">
											<div class="form-group col-md-4">
												<label for="curso">Curso</label> <input type="text"
													class="form-control" id="curso" name="formacao.nomeCurso"
													placeholder="Informe seu curso" maxlength="50"
													value="${candidato.formacao.nomeCurso}">
											</div>
											<div class="form-group col-md-5">
												<label for="instituicao">Instituição</label> <input
													type="text" class="form-control" id="instituicao"
													name="formacao.nomeInstituicao" maxlength="50"
													placeholder=" Informe a instituição"
													value="${candidato.formacao.nomeInstituicao}">
											</div>
											<div class="form-group col-md-3">
												<label for="tipoDeCurso">Grau de instrução</label> <select
													class="form-control" id="tipoDeCurso"
													name="formacao.tipoCurso.id">
													<option value="0">Selecione</option>
													<c:forEach var="tipoCurso" items="${tiposCurso}">
														<option value="${tipoCurso.id}"
															${tipoCurso.id == candidato.formacao.tipoCurso.id ? 'selected="selected"' : ''}>${tipoCurso.nome}</option>
													</c:forEach>

												</select>
											</div>
											<div class="form-group col-md-2">
												<label for="situacaoAtual">Situação atual</label> <select
													class="form-control" id="situacaoAtual"
													name="formacao.situacaoAtual.id">
													<option value="0">Selecione</option>
													<c:forEach var="situacaoAtual"
														items="${listaSituacaoAtual}">
														<option value="${situacaoAtual.id}"
															${situacaoAtual.id == candidato.formacao.situacaoAtual.id ? 'selected="selected"' : ''}>${situacaoAtual.descricao}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group col-md-2">
												<label for="mesAnoConclusao">Data de conclusão</label>
												<fmt:formatDate value="${candidato.formacao.dataConclusao}"
													pattern="dd/MM/yyyy" var="dataConclusao" />
												<input type="text" class="form-control date"
													id="mesAnoConclusao" data-required="false"
													name="formacao.dataConclusao"
													onblur="validarData1('mesAnoConclusao')"
													value="${dataConclusao}">
											</div>
										</div>
										<div class="tab-pane fade" id="third">
											<div class="form-group col-xs-12">
												<div class="row">
													<div class="col-xs-12">
														<label class="control-label" for="pretensaoSalarial">Pretensão
															salarial</label>
													</div>


													<div class="col-md-2">
														<input type="text" class="form-control dinheiro pretensao"
															id="valorPretensao" placeholder="R$"
															name="valorPretensao" value="${candidato.valorPretensao}" />
													</div>
												</div>
											</div>

											<div class="form-group col-md-3">
												<label for="vaga">Vaga a ser aplicado</label> <select
													class="form-control" id="vaga" name="vagaCandidato.vaga.id"
													required="required" ${!podeEditarVaga ? 'disabled="disabled"' : ''}>
													<option value="0">Selecione</option>
													<c:forEach var="vaga" items="${listaVaga}">
														<option value="${vaga.id}"
															${vaga.id == candidato.vagaCandidato.vaga.id ? 'selected="selected"' : ''}>${vaga.nomeVaga}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group col-md-3">
												<label for="canalInformacao">Como ficou sabendo
													desta vaga?</label> <select class="form-control"
													name="vagaCandidato.CanalInformacao.id"
													id="canalInformacao">
													<option value="0">Selecione</option>
														<c:forEach var="canalInformacao" items="${listaCanal}">
															<option value="${canalInformacao.id}"
															${canalInformacao.id == candidato.vagaCandidato.canalInformacao.id ? 'selected="selected"' : ''}>${canalInformacao.nome}</option>
													</c:forEach>
												</select>
											</div>
											<!--começo - tab 4 -->
											<div class="tab-pane fade" id="fourth">
												<!-- conteudo gerado pelo ajax!!!!!-->
											</div>
											<!--fim - tab 4 -->

										</div>
										
										<div class="tab-pane fade" id="five">
										<div class="form-group col-md-3" style="padding-right: 15px; width: 180px;">
												<label class="control-label"> Data ultimo contato</label>
										<div class="form-group">
												<div class="input-group">
												<input type="text" class="form-control date"
												name="dataContato" data-required="false"
												id="dataContato" 
												value="">
												</div>
												</div>
										</div>
										<div class="form-group col-md-5" style=" padding-left: 15px;">
											<label class="control-label"> Observações</label>
										<div class="form-group">
												<div class="input-group">
												<input type="text" placeholder="Informe observações" class="form-control"
												name="observacoes" data-required="false"
												id="obs" value style="width: 526px;"
												>
												</div>
											</div>
										</div>
										

											<table 
							class="table table-bordered table-condensed table-hover table-striped"
							id="tabelaContato"
							style="font-size: 12px !important; vertical-align: middle !important;">
							<!-- Começo Tabela -->
							<thead>
								<tr class="text-center">
									<th class="text-center" style="width: 212px;">Data ultimo contato</th>
									<th class="text-center">Observações</th>
									<th class="text-center" style="width: 212px;">Usuário</th>
									
									</tr>
									</tbody>
									</table>
									<!--começo - tab 5 -->
								<div class="tab-pane fade" id="fourth">
							<!-- conteudo gerado pelo ajax!!!!!-->
											</div>
											<!--fim - tab 5 -->
										</div>
									</div>
								</div>

								<div class="panel-footer">
									<input type="hidden" value="${candidato.id}" name="id">
									<input type="hidden" value="${erro}" id="contErro"> <a
										href="/candidato/file/${candidato.id}" target="_blank"
										class="btn btn-default pull-left download-download">Download</a>
									<button class="btn btn-success pull-right">Salvar</button>
								</div>
							</form>
						</div>
					</div>

                                    <!--começo - tab 4 -->    
                                    <div class="tab-pane fade" id="fourth">
											<c:if test="${not empty candidato.dataEntrevista}">
												<c:forEach var="data" items="${candidato.dataEntrevista}" varStatus="status">
													<div class="row">
														<div class='col-xs-4 form-group'>
															<input type="hidden" value="${data.id}" name="dataEntrevista[${status.index}].id" />
															<label>Nome do entrevistador: &nbsp;</label> 
															<p>${data.usuario.funcionario.nome}</p>
															<%-- <input type="hidden" name="candidatoBean.dataEntrevista[${status.index}].usuario.funcionario.nome" value="${data.usuario.funcionario.nome}" /> --%>
														</div>
														<div class='col-md-2 form-group'>
															<label>Data de entrevista: &nbsp;</label>
															<fmt:formatDate pattern="dd/MM/yyyy" value="${data.dataEntrevista}" var="dataEntrevista"/>
															<input type="text" name="dataEntrevista[${status.index}].dataEntrevista" id="dataEntrevista" class="form-control date" data-required="false" value="${dataEntrevista}">
														 </div>
													</div>
												</c:forEach>
											</c:if>
                                    </div>
                                    <!--fim - tab 4 -->        
                                </div>
                            </div>
                            </div>
                            <div class="panel-footer">
                                <input type="hidden" value="${candidato.id}" name="id">
                                <input type="hidden" value="${erro}" id="contErro">
                                <a href="/candidato/file/${candidato.id}" target="_blank" class="btn btn-default pull-left download-download">Download</a>
                                <button class="btn btn-success pull-right">Salvar</button>
                            </div>
                        </form>
                    </div>
                </div>

				</div>
			</div>
		</div>

	</layout:put>

	<layout:put block="scripts" type="REPLACE">
		<script src="/resources/js/parsley.min.js"></script>
		<script src="/resources/js/custom/cadastrar-candidato.js"></script>
	</layout:put>
</layout:extends>
