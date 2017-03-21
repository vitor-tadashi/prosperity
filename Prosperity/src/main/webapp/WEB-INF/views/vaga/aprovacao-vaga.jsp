<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Aprovar vagas</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

</head>
<body>

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!-- Modal visualizar-->
	<div class="modal fade" id="vaga-modal" data-target="#vaga-modal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="titulo" > Vaga</h4>
				</div>
				<div class="modal-body">
					<div class="panel-tab clearfix">
						<ul class="tab-bar">
							<li class="active"><a data-toggle="tab" href="#home"><i
									class="fa fa-tags">&nbsp</i>Especificações</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
							<section class="panel panel-default">
								<div class="panel-heading">Informações básicas</div>
								<div class="panel-body">
									<form>
										<div class="form-group row">
											<div>
												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="solicitante">Solicitante</label> <input
														class="form-control input-sm" disabled
														name="solicitante.id" id="solicitante"
														data-required="true" name="solicitante">
												</div>
												<!-- /form-group -->

												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Local de trabalho</label>
													<div class="radiogroup" name="localTrabalho" id="local">
														<label class="label-radio inline"> <input
															id="interno" type="radio" value="I" name="radLocalTrabalho" disabled>
															<span class="custom-radio"></span> Interno
														</label> <label class="label-radio inline"> <input
															id="cliente" type="radio" value="C" name="radLocalTrabalho" disabled> <span
															class="custom-radio"></span> Cliente
														</label>
													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div>
												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="cargo"></label> <input type="name"
														class="form-control input-sm" id="cargo" value="Cargo"
														disabled>
												</div>
												<!-- /form-group -->

												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Tipo de vaga</label>
													<div class="radiogroup" name="idTipoVaga" id="tipo">
														<label class="label-radio inline"> <input
															type="radio" id="real" value="R" name="inline-radio3" checked disabled> <span
															class="custom-radio"></span> Real
														</label> <label class="label-radio inline"> <input
															type="radio" id="prospeccao" value="P" name="inline-radio3" disabled> <span
															class="custom-radio"></span> Prospecção
														</label> <label class="label-radio inline"> <input
															type="radio" id="hunting" value="H" name="inline-radio3" disabled> <span
															class="custom-radio"></span> Hunting
														</label>
													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="form-group col-md-4" style="margin-bottom: 0px">
												<label for="vagaSenioridade">Senioridade da vaga</label>
												<input type="name" class="form-control input-sm"
													id="vagaSenioridade" placeholder="Estágio"
													value="Senioridade
													da Vaga" disabled>
											</div>
											<!-- /form-group -->
											<div class="form-group" style="margin-bottom: 0px">
												<label class="control-label">Horário</label>
												<div>
													<div class="form-group col-md-3">
														<div class="input-group bootstrap-timepicker"
															style="width: 105%;">
															<input class="timepicker form-control" id="vagaHorario" type="text"
																/ value="08:00 AM" disabled> <span
																class="input-group-addon"><i
																class="fa fa-clock-o"></i></span>
														</div>
													</div>
													<div class="form-group col-md-1">
														<label style="margin-top: 7px">Às</label>
													</div>
													<div class="form-group col-md-3">
														<div class="input-group bootstrap-timepicker"
															style="width: 105%;">
															<input class="timepicker form-control" id="vagaHorario1" type="text"
																value="05:00 PM" disabled> <span
																class="input-group-addon"><i
																class="fa fa-clock-o"></i></span>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="">
												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="vagaSalario">Faixa salarial</label> <input
														class="form-control input-sm"
														id="vagaSalario" placeholder="Faixa Salarial"
														disabled>
												</div>
												<!-- /form-group -->
												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="vagaQuadro">Aumento de quadro</label>
													<div class="radiogroup" name="aumentoQuadro" id="aumento">
														<label class="label-radio inline"> <input
															id="novo" type="radio" value="N" name="novoQuadro" disabled>
															<span class="custom-radio"> </span> Novo
														</label> <label class="label-radio inline"> <input
															id="sub" type="radio" value="S" name="novoQuadro" disabled> <span
															class="custom-radio"> </span> Substituição
														</label>

													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<div class="form-group">
													<label class="control-label"> Data para inicio</label>
													<div class="form-group">
														<div class="input-group">
															<input type="text" value="01/01/2017"
																class="datepicker form-control" id="vagaInicio" disabled> <span
																class="input-group-addon"><i
																class="fa fa-calendar"></i></span>
														</div>
													</div>
													<!-- /.col -->
												</div>
												<!-- /form-group -->
											</div>
											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<div id="" class="">
													<label>Nome do substituido</label> <input type="text"
														class="form-control input-sm" id="vagaSubstituto" disabled>
												</div>
											</div>
										</div>
									</form>
								</div>
							</section>
							<!-- /Section -->
							<section class="panel panel-default">
								<div class="row">
									<div class="panel-heading">Informações de projeto</div>
									<div class="form-group row"></div>
									<!-- /form-group -->
									<div class="form-group col-md-4">
										<label class="control-label">Projeto</label> <input readonly
											class="form-control default-cursor" id="vagaProjeto" value="Mobile">
									</div>
									<div class="form-group col-md-4">
										<label class="control-label">Cliente</label> <input readonly
											class="form-control" id="vagaCiente" value="Carrefour">
									</div>
									<div class="form-group col-md-4">
										<label class="control-label">Gestor imediato</label> <input
											readonly class="form-control" id="vagaGestor"value="Vitor Tadashi">
									</div>
								</div>
							</section>
							<!-- /panel -->
							<section class="panel panel-default">
								<div class="panel-heading">Formação acadêmica</div>
								<div class="panel-body relative">
									<div class="form-group">
										<textarea class="form-control" rows="3" name= "vagaFormacao" id=vagaFormacao disabled >
										</textarea>
									</div>
									<!-- /form-group -->
								</div>
							</section>
							<!-- /panel -->
							<section class="panel panel-default">
								<div class="panel-heading">Perfil comportamental</div>
								<div class="panel-body relative">
									<div class="form-group">
										<textarea class="form-control" rows="3"  name= "vagaPerfil" id=vagaPerfil disabled></textarea>
									</div>
									<!-- /form-group -->
								</div>
							</section>
							<!-- /panel -->

							<section class="panel panel-default">
								<div class="panel-heading">Perfil técnico</div>
								<div class="panel-body relative">
									<div class="form-group">
										<textarea class="form-control" rows="3"  name= "vagaPerfilTecnico" id=vagaPerfilTecnico disabled></textarea>
									</div>
									<!-- /form-group -->
								</div>
							</section>
							<!-- /panel -->
							<div class="modal-footer">
								<button type="button" class="btn btn-primary">Imprimir</button>
							</div>
						</div>
					</div>
					<!-- /tab-content -->
				</div>
			</div>
		</div>
	</div>

	<!-- CORPO DA PÁGINA -->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						Início</a></li>
				<li class="active">Aprovação de vaga</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<div class="padding-md">
			<div class="panel panel-default">
				<div class="panel-heading">Aprovação de vaga</div>
				<div class="panel-body">

					<table
						class="table table-bordered table-condensed table-hover table-striped"
						id=""
						style="font-size: 12px !important; vertical-align: middle !important;">
						<!-- Começo Tabela -->
						<thead>
							<tr class="text-center">
								<th class="text-center">Nome da vaga</th>
								<th class="text-center">Solicitante</th>
								<th class="text-center">Senioridade</th>
								<th class="text-center">Projeto</th>
								<th class="text-center">Cliente</th>
								<th class="text-center">Local de trabalho</th>
								<th class="text-center">Data abertura</th>
								<th class="text-center">Data encerramento</th>
								<th class="text-center">Ações</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<c:forEach var="vaga" items="${vagas}" varStatus="i">

								<tr>
									<td>${vaga.nomeVaga}</td>
									<td>${vaga.nomeSolicitante}</td>
									<td>${vaga.senioridadeBean.nome}</td>
									<td>${vaga.projetoBean.nome}</td>
									<td>${vaga.projetoBean.cliente.nome}</td>
									<td>
									<c:if test="${vaga.localTrabalho == 73}" >
										     Interno
										</c:if>
										<c:if test="${vaga.localTrabalho == 67}" >
										     Cliente
										</c:if>
									</td>
									<td>${vaga.dataAbertura }</td>
									<td>${vaga.dataFechamento }</td>
									<td>
										<div class="btn-group">
											<!-- <-- ! Começo Botão -->
											<button class="btn btn-sm dropdown-toggle btn-info"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg"></i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a onclick="info(${vaga.id})"> <i
														class="fa fa-eye">&nbsp</i>Visualizar</a></li>
												<li role="separator" class="divider"></li>
												<li><a href="#"><i class="fa fa-check fa-lg"></i>
														Aprovar</a></li>
												<li role="separator" class="divider"></li>
												<li><a href="#"><i class="fa fa-times fa-lg"></i>
														Reprovar</a></li>
											</ul>
										</div> <!-- Fim Botão -->
									</td>
								</tr>

							</c:forEach>
							<!-- <tr>
								<td>Desenvolvedor</td>
								<td>Vitor Tadashi</td>
								<td>Senior</td>
								<td>Projeto Web</td>
								<td>Carrefour</td>
								<td>Interno</td>
								<td>17/02/2017</td>
								<td>01/03/2017</td>
								<td>
									<div class="btn-group">
										Começo Botão
										<button class="btn btn-sm dropdown-toggle btn-info"
											data-toggle="dropdown">
											<i class="fa fa-cogs fa-lg"></i> <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#vaga-modal" data-toggle="modal"><i
													class="fa fa-eye">&nbsp</i>Visualizar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-check fa-lg"></i>
													Aprovar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-times fa-lg"></i>
													Reprovar</a></li>
										</ul>
									</div> Fim Botão
								</td>
							</tr> -->
							<!-- <tr>
								<td>Analista</td>
								<td>Marcelo</td>
								<td>Junior</td>
								<td>Mobile</td>
								<td>Alelo</td>
								<td>Interno</td>
								<td>17/02/2017</td>
								<td>01/03/2017</td>
								<td>
									<div class="btn-group">
										Começo Botão
										<button class="btn btn-sm dropdown-toggle btn-info"
											data-toggle="dropdown">
											<i class="fa fa-cogs fa-lg"></i> <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#vaga-modal" data-toggle="modal"><i
													class="fa fa-eye">&nbsp</i>Visualizar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-check fa-lg"></i>
													Aprovar</a></li>
											<li role="separator" class="divider"></li>
											<li><a href="#"><i class="fa fa-times fa-lg"></i>
													Reprovar</a></li>
										</ul>
									</div> Fim Botão
								</td>
							</tr> -->
						</tbody>
					</table>
					<!-- Fim Tabela -->
				</div>
				<!-- /panel -->
			</div>
			<!-- /.padding-md -->

		</div>
		<!-- /wrapper -->
	</div>
	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>

	<!-- JavaScript -->

	<script type="text/javascript">
	
	function info(listaId){
    	//
    	$.ajax({
    		url: "visualizar",
    		type: "GET",
    		dataType: "JSON",
    		data: { 'id' : listaId},
    		success: function(lista){
    			console.log(lista);
    			$('#titulo').html(lista.nomeVaga);
    			$('input#vagaGestor').val(lista.nomeSolicitante);
    			if(lista.localTrabalho == 'C') {
    				$("#cliente").attr('checked', 'checked');
    			} else {
    				$("#interno").attr('checked', 'checked');
    			}
    			if(lista.idTipoVaga == 'H') {
    				$("#hunting").attr('checked', 'checked');
    			} else if(lista.idTipoVaga == 'P') {
    				$("#prospeccao").attr('checked', 'checked');
    			} else {
    				$("#real").attr('checked', 'checked');
    			}
    			if(lista.aumentaQuadro == 'S') {
    				$("#sub").attr('checked', 'checked');
    			} else {
    				$("#novo").attr('checked', 'checked');
    			}
    			$('input#vagaSalario').val(lista.valorPretensao);
    			$('input#cargo').val(lista.cargoBean.nome);
    			$('input#vagaSenioridade').val(lista.senioridadeBean.nome);
    			$('input#vagaHorario').val(lista.horarioEntrada);
    			$('input#vagaHorario1').val(lista.horarioSaida);
    			$('input#solicitante').val(lista.nomeSolicitante);
    			$('input#vagaQuadro').val(lista.aumentaQuadro);
    			$('input#vagaSubstituto').val(lista.nomeSubstituido);
    			$('input#vagaInicio').val(lista.dataInicio);
    			$('input#vagaCiente').val(lista.projetoBean.cliente.nome);
    			$('input#vagaProjeto').val(lista.projetoBean.nome);
    			$('#vagaPerfil').val(lista.descricaoPerfilComportamental);
    			$('#vagaFormacao').val(lista.descricaoFormacaoAcademica);
    			$('#vagaPerfilTecnico').val(lista.descricaoPerfilTecnico);
    			$('#vaga-modal').modal('show');
    		}
    	})
    } 

	</script>
</body>
</html>