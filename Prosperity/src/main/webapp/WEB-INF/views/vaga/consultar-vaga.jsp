<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Consultar vaga</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Font Awesome-->
	<link href="css/font-awesome.min.css" rel="stylesheet">

	<!-- Pace -->
	<link href="css/pace.css" rel="stylesheet">
	
	<!-- Datatable -->
	<link href="css/jquery.dataTables_themeroller.css" rel="stylesheet">
	
	<!-- Perfect -->
	<link href="css/app.min.css" rel="stylesheet">
	<link href="css/app-skin.css" rel="stylesheet">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<style type="text/css">
 footer {
	page-break-before: always;
	}
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
    label {
		font-weight: normal;
	}
	#quebra { page-break-inside:avoid; }
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
												<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
													<label for="solicitante">Solicitante</label> <input
														class="form-control input-sm" disabled
														name="solicitante.id" id="solicitante"
														data-required="true" name="solicitante">
												</div>
												<!-- /form-group -->
'
												<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Local de trabalho:</label>
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
												<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
													<label for="cargo">Cargo</label> <input
														class="form-control input-sm" disabled
														name="cargo.id" id="cargo"
														data-required="true" name="cargo">
												</div>
												
									
												<!-- /form-group -->

												<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Tipo de vaga:</label>
													<div class="radiogroup" name="idTipoVaga" id="tipo">
														<label id="tpVaga" class="label-radio inline" value = "">
														</label>
													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>

										<div class="form-group row">
											<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
													<label for="senioridade">Senioridade da vaga</label> <input
														class="form-control input-sm" disabled
														name="senioridade.id" id="senioridade"
														data-required="true" name="senioridade">
												</div>
											<!-- /form-group -->

											<div class="form-group" style="margin-bottom: 0px">
												<label class="control-label" style="padding-left: 15px;">Horário:</label>

												<div>
													<div class="form-group col-md-2 col-xs-2">
														<div class="input-group bootstrap-timepicker">
															<label id="horaEntrada" name="horarioEntrada"
																	type="time" style="margin-top: 7px" value=""></label>
														</div>
													</div>

													<div class="form-group col-md-1 col-xs-1">
														<label style="margin-top: 7px">Às</label>
													</div>

													<div class="form-group col-md-2 col-xs-1">
														<div class="input-group bootstrap-timepicker">
															<label id="horaSaida" name="horaSaida" type="time"
																	style="margin-top: 7px" value=""></label>
														</div>
													</div>
												</div>

											</div>
										</div>

										<div class="form-group row">

											<div class="">
												<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
													<label for="exampleInputPassword1">Faixa salarial</label> <input
														 class="form-control input-sm"
														id="pretensao" placeholder="Faixa Salarial"
														disabled name="valorPretensao">
												</div>
												<!-- /form-group -->

												<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
													<label for="exampleInputEmail1">Aumento de quadro:</label>
													<div class="radiogroup" name="aumentoQuadro" id="aumento">
														<label id="lblQuadro" class="label-radio inline" value = "">
														</label>

													</div>
													<!-- /.col -->
												</div>
											</div>
										</div>

										<div class="form-group row">

											<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">

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

											<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 0px">
												<div id="" class="">
													<label id="substituidoId">Nome do substituido:</label> 
												</div>
												<label id="substituido" name="nomeSubstituido"
														style="margin-top: 7px" value=""></label>
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
				<input class="reprovar-id" type="hidden"> <input
					class="reprovar-status" type="hidden">
				<div class="modal-footer">
					<a href="#">
						<button id="fechaVaga" onclick="status()" type="button" class="btn btn-primary"
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
				<input class="cancela-id" type="hidden"> <input
					class="cancela-status" type="hidden">
				<div class="modal-footer">
					<a href="#">
						<button id="excluiVaga" onclick="status()" type="button" class="btn btn-primary"
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
				<li><i class="fa fa-home"></i><a href="dashboard.html"> Início</a></li>
				<li class="active">Vaga</li>
				<li><a href="consultar">Consultar</a></li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="padding-md">
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default table-responsive">
						<div class="panel-heading">Consulta de vagas</div>
						<!--<form class="form-inline">-->
						<div class="panel-body">

							<form action="filtro" method="GET" class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label>Vaga</label> <input class="form-control" id="filtro1" name="nomeVaga" placeholder="Digite o nome de uma vaga">
									</div>
								</div>

								<div class="col-md-5">
									<label for="">Data</label>
									<div class="input-group">
										<input type="date" name="dataAberturaDe" id="data1" class="form-control"> <span
											class="input-group-addon">até</span> <input type="date"
											class="form-control" name="dataAberturaPara" id="data2">
									</div>
								</div>

								<div class="col-md-1">
									<label for="cargo">Status</label> 
									<select class="form-control" style="width: 130px;" id="status" name="status">
											<option value="0">Selecione</option>
										<c:forEach var="status" items="${listaStatusDrop}">
												<option id="${status.id}"value="${status.id}">${status.nome}</option>
										</c:forEach>
									</select>
								</div>

								<div class="text-right">
									<a href="#" style="text-decoration: none; color: #ffffff">
										<button class="btn btn-primary"
											style="margin-top: 22px; margin-right: 22px;" type="submit">Pesquisar</button>
									</a>
								</div>
							</form>
						</div>
						<!--</panel body>-->
						<div class="padding-md clearfix">
						<table
							id="tabelaVaga"
							class="table table-bordered table-condensed table-hover table-striped"
							style="font-size: 12px; vertical-align: middle;"
							id="dataTable">
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
									<td><fmt:formatDate value="${vaga.dataAbertura}" pattern="dd/MM/yyyy"/></td>
									<td id="linhaStatus"><span class="label status span-${vaga.ultimoStatus.status.nome}">${vaga.ultimoStatus.status.nome}</span></td>
									<td>
										<div class="btn-group">
											<button class="btn btn-sm btn-info dropdown-toggle"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<i class="fa fa-cogs fa-lg">&nbsp;</i> <span class="caret"></span>
											</button>
											<ul class="dropdown-menu dropdown-menu-right slidedown">
											<li><a href="#visualizar-modal" 
													onclick="info(${vaga.id})"><i
														class="fa fa-eye">&nbsp</i>Visualizar</a></li>
														
												<li id="${vaga.ultimoStatus.status.nome}" class="divider"></li>
												
												<li id="${vaga.ultimoStatus.status.nome}"><a href="#fecha-modal" 
												onclick="alterarStatus(${vaga.id}, 'RECUSADO')"
												data-toggle="modal"><i
														class="fa fa-lock">&nbsp</i>Fechar</a></li>
												<li id="${vaga.ultimoStatus.status.nome}" class="divider "></li>
												
							
												<li id="${vaga.ultimoStatus.status.nome}"><a href="#delete-modal" 
												onclick="alterarStatus(${vaga.id}, 'CANCELADO')"
												data-toggle="modal"><i
														class="fa fa-times">&nbsp</i>Cancelar</a></li>
												
													
											</ul>
										</div> <!-- /btn-group -->
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
						
					</div>
					<!--</panel default>-->
<<<<<<< HEAD
					<div class="panel-footer clearfix">
						<div class="row">
						$ (ElementID) .paginate ()
							<ul class="pagination pagination-xs m-top-none pull-right">
								<li class="disabled"><a href="#">Anterior</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">Próximo</a></li>
							</ul>
						</div>
						<!--</div row>-->
					</div>
=======
					
>>>>>>> 59b16c9bbbd105e49d7ad29f9d5a96a7bbb6c142
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
	<!-- Jquery -->
	<script src="js/jquery-1.10.2.min.js"></script>
	
	<!-- Bootstrap -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
 
	<!-- Datatable -->
	<script src='js/jquery.dataTables.min.js'></script>	
	
	<!-- Modernizr -->
	<script src='js/modernizr.min.js'></script>
	
	<!-- Pace -->
	<script src='js/pace.min.js'></script>
	
	<!-- Popup Overlay -->
	<script src='js/jquery.popupoverlay.min.js'></script>
	
	<!-- Slimscroll -->
	<script src='js/jquery.slimscroll.min.js'></script>
	
	<!-- Cookie -->
	<script src='js/jquery.cookie.min.js'></script>

	<!-- Perfect -->
	<script src="js/app/app.js"></script>
	<script>
	$(function	()	{
		$('#dataTable').dataTable( {
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
		});
		
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
	
	
	
	//linhaStatus
	//span-[status]
	$(".span-Fechado").addClass("label-warning");
	$(".span-Ativo").addClass("label-success");
	$(".span-Cancelado").addClass("label-danger");
	$(".span-Pendente").addClass("label-info");
	
	if($(".span-Fechado") || $(".span-Cancelado") || $(".span-Pendente")) {
		$('li#Fechado').hide();
		$('li#Cancelado').hide();
		$('li#Pendente').hide();
	}
	
	
	
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
       				$("#substituido").show();
    				$("#substituidoId").show();
    			}
    			
    			$('input#solicitante').val(lista.nomeSolicitante);
    			
    			
    			$('input#cargo').val(lista.cargoBean.nome);
    			
    			
    			$('input#senioridade').val(lista.senioridadeBean.nome);
    			$('label#horaEntrada').text(lista.horarioEntrada);
    			$('label#horaSaida').text(lista.horarioSaida);
    			$('input#pretensao').val(lista.valorPretensao);
    			
    			$('input#dataInicio').val(lista.dataInicio);
    			$('label#substituido').text(lista.nomeSubstituido);
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
	
	function status(){
    	$.ajax({
    		url: "status",
    		type: "POST",
    		dataType: "JSON",
    		data: { 'idVaga' : $('.cancela-id').val(), 'status' : $('.cancela-status').val()},
    		success: function(){
    				location.reload();	
    			}
    	});
    	}
	function alterarStatus(id,status){
		$('input.cancela-id').val(id);
		$('input.cancela-status').val(status);
	
		$('input.reprovar-id').val(id);
		$('input.reprovar-status').val(status);
		
	}
	
	
	</script>
	<script>
		$(function	()	{
			$('#dataTable').dataTable( {
				"bJQueryUI": true,
				"sPaginationType": "full_numbers"
			});
			
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
	
	</body>
	</html>