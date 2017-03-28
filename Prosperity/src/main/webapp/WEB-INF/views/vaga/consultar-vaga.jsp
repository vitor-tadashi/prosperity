<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Consultar vaga</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<style type="text/css">

@media screen {
    #printSection {
        display: none;
    }
}
@media print {

    body * {
        visibility:hidden;
    }
    #printSection * {
        visibility:visible;
    }
    #printSection {
        position: absolute;
        left: 0;
        top: 0;
        
    }
}
</style>

<style>

.label-stand, .badge-stand {
	background-color: #9b59b6;
	color: #fff;
}

.label-aprovadoPendente, .badge-stand {
	background-color: #2980b9;
	color: #fff;
}

.label-analiseRH, .badge-stand {
	background-color: #e67e22;
	color: #fff;
}

.label-analiseTecnica, .badge-stand {
	background-color: #f1c40f;
	color: #fff;
}

.label-reprovado, .badge-stand {
	background-color: #e74c3c;
	color: #fff;
}

.label-contratado, .badge-stand {
	background-color: #2ecc71;
	color: #fff;
}

.dropdown-menu {
	left: -115px !important;
}

.col-md-9 .label-radio {
	margin-right: 58px;
	margin-left: 20px;
}

</style>

	

</head>
<body>
	<!-- Modal visualizar-->
	<div class="modal fade" id="vaga-modal" data-target="#vaga-modal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div id="PrintThis">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="titulo">Desenvolvedor .Net
						Pleno</h4>
				</div>
				<div class="modal-body">
					<div class="panel-tab clearfix">
						<ul class="tab-bar">
							<li class="active"><a data-toggle="tab" href="#home"><i
									class="fa fa-info-circle">&nbsp</i>Informações</a></li>
							<li><a data-toggle="tab" href="#menu1"><i
									class="fa fa-tags">&nbsp</i>Especificações</a></li>
						</ul>
					</div>
					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
							<form>
								<section class="panel panel-default panel-body">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">Data de abertura</label>
												<div class="form-group">
													<div class="input-group">
														<input type="text" value="01/01/2017"
															class="datepicker form-control" id="dataAbertura" name="dataAbertura"
															readonly> <span class="input-group-addon"><i
															class="fa fa-calendar"></i></span>
													</div>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">Data de aprovação</label>
												<div class="form-group">
													<div class="input-group">
														<input type="text" value="01/01/2017"
															class="datepicker form-control" id="dataAprovacao" name="dataAprovacao"
															readonly> <span class="input-group-addon"><i
															class="fa fa-calendar"></i></span>
													</div>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label class="control-label">Data de fechamento</label>
												<div class="form-group">
													<div class="input-group">
														<input type="text" value="01/01/2017"
															class="datepicker form-control" id="dataFechamento" name="dataFechamento"
															readonly> <span class="input-group-addon"><i
															class="fa fa-calendar"></i></span>
													</div>
												</div>
												<!-- /.col -->
											</div>
											<!-- /form-group -->
										</div>
									</div>
									<div class="row">
										<div class="form-group col-md-3">
											<label for="">Candidatos</label> <input type="number"
												class="form-control input-sm" id="candidatos" min="0" value="123"
												name="numeroCandidatos" disabled>
										</div>
										<!-- /form-group -->
									</div>
								</section>
							</form>
						</div>
						<div id="menu1" class="tab-pane fade">
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
'
												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Local de trabalho</label>
													<div class="radiogroup" name="localTrabalho" id="local">
														<label id="lblLocal" class="label-radio inline" value="">
														</label>
													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>

										<div class="form-group row">
											<div>
												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="cargo">Cargo</label> <input
														class="form-control input-sm" disabled
														name="cargo.id" id="cargo"
														data-required="true" name="cargo">
												</div>
												
									
												<!-- /form-group -->

												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Tipo de vaga</label>
													<div class="radiogroup" name="idTipoVaga" id="tipo">
														<label id="tpVaga" class="label-radio inline" value = "">
														</label>
													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>

										<div class="form-group row">
											<div class="form-group col-md-5 col-xs-5" style="margin-bottom: 0px">
													<label for="senioridade">Senioridade da vaga</label> <input
														class="form-control input-sm" disabled
														name="senioridade.id" id="senioridade"
														data-required="true" name="senioridade">
												</div>
											<!-- /form-group -->

											<div class="form-group" style="margin-bottom: 0px">
												<label class="control-label">Horário</label>

												<div>
													<div class="form-group col-md-3">
														<div class="input-group bootstrap-timepicker"
															style="width: 105%;">
															<input class="timepicker form-control" type="text"
																/ value="08:00 AM" id="horaEntrada" name="horarioEntrada" disabled> <span
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
															<input class="timepicker form-control" type="text"
																/ value="05:00 PM" id="horaSaida" name="horarioSaida" disabled> <span
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
													<label for="exampleInputPassword1">Faixa salarial</label> <input
														 class="form-control input-sm"
														id="pretensao" placeholder="Faixa Salarial"
														disabled name="valorPretensao">
												</div>
												<!-- /form-group -->

												<div class="form-group col-md-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Aumento de quadro</label>
													<div class="radiogroup" name="aumentoQuadro" id="aumento">
														<label id="lblQuadro" class="label-radio inline" value = "">
														</label>

													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>

										<div class="form-group row">

											<div class="form-group col-md-6" style="margin-bottom: 0px">

												<div class="form-group">
													<label class="control-label">Data para inicio</label>
													<div class="form-group">
														<div class="input-group">
															<input type="text" value="01/01/2017"
																class="datepicker form-control" name="dataInicio" id="dataInicio" disabled>
															<span class="input-group-addon"> <i
																class="fa fa-calendar"></i></span>
														</div>
													</div>
													<!-- /.col -->
												</div>
												<!-- /form-group -->
											</div>

											<div class="form-group col-md-6" style="margin-bottom: 0px">
												<div id="" class="">
													<label id="substituidoId">Nome do substituido</label> <input type="text"
														class="form-control input-sm"
														placeholder="Nome do substituido" name="nomeSubstituido" id="substituido" disabled>
												</div>
											</div>

										</div>

									</form>
								</div>
							</section>
							<!-- /Section -->
							<section class="panel panel-default">
								<div class="panel-heading">Formação acadêmica</div>
								<div class="panel-body relative">
									<div class="form-group">
										<textarea class="form-control" rows="3"
											name="formacaoAcademica" id="formacaoAcademica" disabled></textarea>
									</div>
									<!-- /form-group -->

								</div>
							</section>
							<!-- /panel -->

							<section class="panel panel-default">
								<div class="panel-heading">Perfil comportamental</div>
								<div class="panel-body relative">
									<div class="form-group">
										<textarea class="form-control" rows="3"
											name="perfilComportamental" id="perfilComportamental" disabled></textarea>
									</div>
									<!-- /form-group -->

								</div>
							</section>
							<!-- /panel -->

							<section class="panel panel-default">
								<div class="panel-heading">Perfil técnico</div>
								<div class="panel-body relative">

									<div class="form-group">
										<textarea class="form-control" rows="3" name="perfilTecnico" id="perfilTecnico" disabled></textarea>
									</div>
									<!-- /form-group -->

								</div>
							</section>
							</div>
							</div>
					</div>
					
					</div>
					<!-- /panel -->
					<!-- /tab-content -->
					<div class="modal-footer">
								<button type="button" class="btn btn-primary" id="Print" onclick="imprimir()">Imprimir</button>
							</div>
				</div>
			</div>
			</div>
	
	<!-- Modal visualizar -->

	<!-- Modal fechar -->
	<div class="modal fade" id="fecha-modal" data-target="#fecha-modal"
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
				<div class="modal-body">Deseja realmente fechar está vaga?</div>
				<div class="modal-footer">
					<a href="#">
						<button id="fechaVaga" type="button" class="btn btn-primary"
							data-dismiss="modal">Sim</button>
					</a>
					<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal fechar-->

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
					<h4 class="modal-title" id="modalLabel">Cancelar vaga</h4>
				</div>
				<div class="modal-body">Deseja realmente cancelar está vaga?</div>
				<div class="modal-footer">
					<a href="#">
						<button id="excluiVaga" type="button" class="btn btn-primary"
							data-dismiss="modal">Sim</button>
					</a>
					<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal delete-->

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!--corpo -->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">Início</a></li>
				<li>Consultar</li>
				<li class="active">Vaga</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="padding-md">
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">Consulta de vagas</div>
						<!--<form class="form-inline">-->
						<div class="panel-body">

							<form action="filtrar" method="GET" class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label>Vaga</label> <input class="form-control" id="filtro1" name="nomeVaga" placeholder="Digite o nome de uma vaga">
									</div>
								</div>

								<div class="col-md-5">
									<label for="">Data</label>
									<div class="input-group">
										<input type="date" id="data1" class="form-control" name="dataAberturaDe"> <span
											class="input-group-addon">até</span> <input type="date"
											class="form-control" name="dataAberturaPara" id="data2">
									</div>
								</div>

								<div class="col-md-2">
									<label for="cargo">Status</label> 
									<select class="form-control" style="width: 130px;" id="status" name="statusVagaBean[0].id">
										<c:forEach var="status" items="${listaStatusVaga}">
												<option value="${status.id}">${status.statusBean.nome}</option>
										</c:forEach>
									</select>
								</div>

								<div class="text-right">
									<a href="#" style="text-decoration: none; color: #ffffff">
										<button class="btn btn-primary"
											style="margin-top: 22px; margin-right: 22px;" type="submit">Filtrar</button>
									</a>
								</div>
							</form>
						</div>
						<!--</panel body>-->
						<table
							id="tabelaVaga"
							class="table table-bordered table-condensed table-hover table-striped"
							style="font-size: 12px; vertical-align: middle;">
							<thead>
								<tr>
									<th class="text-center">Vaga</th>
									<th class="text-center">Solicitante</th>
									<th class="text-center">Cliente</th>
									<th class="text-center">Local de trabalho</th>
									<th class="text-center">Data de abertura</th>
									<th class="text-center">Status</th>
									<th class="text-center">Ações</th>
								</tr>
							</thead>
							<tbody class="text-center">
								<c:forEach var="vaga" items="${vagas}">
									<tr position="infoVaga">
									<td id="linhaNome">${vaga.nomeVaga}</td>
									<td>${vaga.nomeSolicitante}</td>
									<td>${vaga.projeto.cliente.nome}</td>
									<td>
										<c:if test="${vaga.localTrabalho == 73}" >
										     Interno
										</c:if>
										<c:if test="${vaga.localTrabalho == 67}" >
										     Cliente
										</c:if>

									</td>
									<td id="linhaData">${vaga.dataAbertura}</td>
									<td id="linhaStatus"><span id="tdStatus" class="label label-contratado">Ativo</span></td>
									<td>
										<div class="btn-group">
											<button class="btn btn-sm btn-info dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right slidedown">
												<li><a onclick="info(${vaga.id})"><i
														class="fa fa-eye">&nbsp</i>Visualizar</a></li>
												<li class="divider"></li>
												<li><a href="#fecha-modal" data-toggle="modal"><i
														class="fa fa-lock">&nbsp</i>Fechar</a></li>
												<li class="divider "></li>
												<li><a href="#delete-modal" data-toggle="modal"><i
														class="fa fa-times">&nbsp</i>Cancelar</a></li>
											</ul>
										</div> <!-- /btn-group -->
									</td>
								</tr>
								</c:forEach>
								<!-- <tr>
									<td>Analista de sistema</td>
									<td>Carrefour</td>
									<td>Interno</td>
									<td>15/02/2017</td>
									<td><span class="label label-analiseTecnica">Fechado</span></td>
									<td>
										<div class="btn-group">
											<button class="btn btn-sm btn-info dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right slidedown">
												<li><a href="#vaga-modal" data-toggle="modal"><i
														class="fa fa-eye ">&nbsp</i>Visualizar</a></li>
												<li class="divider "></li>
												<li><a href="# "><i class="fa fa-pencil ">&nbsp</i>Editar</a></li>
												<li class="divider "></li>
												<li><a href="#delete-modal" data-toggle="modal"><i
														class="fa fa-trash-o ">&nbsp</i>Excluir</a></li>
											</ul>
										</div> /btn-group
									</td>
								</tr> -->
								<!-- <tr>
									<td>Analista .NET Pleno</td>
									<td>Carrefour</td>
									<td>Alocado</td>
									<td>15/02/2017</td>
									<td><span class="label label-reprovado">Cancelado</span></td>
									<td>
										<div class="btn-group">
											<button class="btn btn-info btn-sm dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right slidedown">
												<li><a href="#vaga-modal" data-toggle="modal"><i
														class="fa fa-eye ">&nbsp</i>Visualizar</a></li>
												<li class="divider "></li>
												<li><a href="# "><i class="fa fa-pencil ">&nbsp</i>Editar</a></li>
												<li class="divider "></li>
												<li><a href="#delete-modal" data-toggle="modal"><i
														class="fa fa-trash-o ">&nbsp</i>Excluir</a></li>
											</ul>
										</div> /btn-group
									</td>
								</tr> -->
							</tbody>
						</table>
					</div>
					<!--</panel default>-->
					<div class="panel-footer clearfix">
						<div class="row">
							<ul class="pagination pagination-xs m-top-none pull-right">
								<li class="disabled"><a href="#">Anterior</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">Próximo</a></li>
							</ul>
						</div>
						<!--</div row>-->
					</div>
					<!--</panel footer>-->
				</div>
				<!--</col-sm-12>-->
			</div>
			<!--</row>-->
		</div>
		<!--</padding>-->
	</div>
	<!--</container>-->
	<!--</main container>-->
	<!--corpo -->

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
	
	
	<script type="text/javascript">
	

	
	function info(listaId){
		
    	//var Visualizar = $("#fid option:selected").val();
    	var Solicitante;
    	var Titulo;
    	
    	//
    	$.ajax({
    		url: "abrir",
    		type: "GET",
    		dataType: "JSON",
    		data: { 'id' : listaId},
    		success: function(lista){
    			console.log(lista);
    			$('#titulo').html(lista.nomeVaga);
    			$('input#dataAbertura').val(lista.dataAbertura);
    			$('input#dataAprovacao').val(lista.dataAprovacao);
    			$('input#dataFechamento').val(lista.dataFechamento);
    			$('input#candidatos').val(lista.numeroCandidatos);
    			
    			if(lista.localTrabalho == 'C') {
    				//$("#cliente").attr('checked', 'checked');
    				$("#lblLocal").text('Cliente')
    			} else {
    				//$("#interno").attr('checked', 'checked');
    				$("#lblLocal").text('Interno')
    			}
    			if(lista.idTipoVaga == 'H') { 
    				$("#tpVaga").text('Hunting')
    			} else if(lista.idTipoVaga == 'P') {
    				$("#tpVaga").text('Prospecção')
    			} else {
    				$("#tpVaga").text('Real')
    			}
    			if(lista.aumentaQuadro == 'N') {
    				$("#lblQuadro").text('Novo');
    				$("#substituido").hide();
    				$("#substituidoId").hide();
       			} else {
       				$("#lblQuadro").text('Substituição')
    			}
    			
    			$('input#solicitante').val(lista.nomeSolicitante);
    			
    			
    			$('input#cargo').val(lista.cargoBean.nome);
    			
    			
    			$('input#senioridade').val(lista.senioridadeBean.nome);
    			$('input#horaEntrada').val(lista.horarioEntrada);
    			$('input#horaSaida').val(lista.horarioSaida);
    			$('input#pretensao').val(lista.valorPretensao);
    			
    			$('input#dataInicio').val(lista.dataInicio);
    			$('input#substituido').val(lista.nomeSubstituido);
    			$('#formacaoAcademica').val(lista.descricaoFormacaoAcademica);
    			$('#perfilComportamental').val(lista.descricaoPerfilComportamental);
    			$('#perfilTecnico').val(lista.descricaoPerfilTecnico);
    			$('#vaga-modal').modal('show');
    		}
    	})
    } 
	function imprimir(){
	//document.getElementById("Print").onclick = function() {
	    printElement(document.getElementById("PrintThis"));
	//};
	}

	function printElement(elem) {
	    var domClone = elem.cloneNode(true);

	    var $printSection = document.getElementById("printSection");

	    if (!$printSection) {
	        var $printSection = document.createElement("div");
	        $printSection.id = "printSection";
	        document.body.appendChild($printSection);
	    }

	    $printSection.innerHTML = "";
	    $printSection.appendChild(domClone);
	    window.print();
	}
	
	function mudarQuadro() {
		var $quadro = document.getElementById("lblQuadro");
		var $sub = document.getElementById("substituido");
		
		
	}
	
	
	</script>
	</body>
	</html>