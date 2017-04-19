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
	
	.hiddenRow {
    padding: 0 !important;
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

li a.active {
	background: #f2f2f2;
	
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
												
											</div>
											
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
												
											</div>
											
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
								<div class="panel-heading">Especificações</div>
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
		<div class="container">
		<div class="padding-md clearfix">
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
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
						
						<table
							id="tabelaVaga"
							class="table table-bordered table-condensed table-hover table-striped"
							style="font-size: 12px; vertical-align: middle; margin-top: -10px;">
							<thead>
								<tr>
									<th class="text-center">Vaga</th>
									<th class="text-center">Solicitante</th>
									<th class="text-center">Cliente</th>
									<th class="text-center">Local de trabalho</th>
									<th class="text-center">Data de abertura</th>
									<th class="text-center">Data de Início</th>
									<th class="text-center">Status</th>
									<th class="text-center">Ações</th>
								</tr>
							</thead>
							<tbody class="text-center">
								<c:forEach var="vaga" items="${vagas}" varStatus="count">
									<tr position="infoVaga"  data-toggle="collapse" data-target="#demo${count.index}" class="accordion-toggle" style="cursor: pointer;">
										<td id="linhaNome" name="nomeVaga">
										${vaga.nomeVaga}
										</td>
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
										<td><fmt:formatDate value="${vaga.dataInicio}" pattern="dd/MM/yyyy"/></td>
										<td id="linhaStatus"><span class="label"
															style="color: #fff; background-color: ${vaga.ultimoStatus.status.css}">${vaga.ultimoStatus.status.nome}</span></td>
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
												<li role="separator" class="editarDivider divider btnEdita hide"></li>
															
															<li><a href="/candidato/filtrar?nome=&vagaBean.id=${vaga.id}"  
														><i
															class="fa fa-group">&nbsp</i>Visualizar candidatos</a></li>
															
															
												<c:if test="${vaga.ultimoStatus.status.nome == 'Pendente'}">
													<li role="separator" class="editarDivider pro divider"></li>
													<li><c:url value="editar/${vaga.id}" var="myURL">
														</c:url> <a href="${myURL}" class="editarPendente pro"><i class="fa fa-pencil"></i> Editar</a></li>
													</c:if>
													
													<c:if test="${vaga.ultimoStatus.status.nome == 'Aguardando avaliadores'}">
													<li role="separator" class="editarDivider divider btnEdita pre hide"></li>
													<li><c:url value="editar/${vaga.id}" var="myURL">
														</c:url> <a href="${myURL}" class="editarPendente btnEdita pre hide"><i class="fa fa-pencil"></i> Editar avaliadores</a></li>
													</c:if>					
												</ul>
											</div> <!-- /btn-group -->
										</td>
									</tr>
									 <tr >
            <td colspan="8" class="hiddenRow"><div class="accordian-body collapse" id="demo${count.index}">
            
            	<br/>
            		<div class="col-sm-12" style="margin-left: 5px">
            			<div class="col-md-3 well well-sm btn btn-success" style="height: 56px;
															    margin-right: 5px;
															    width: 200px;
															    margin-left: 5px;">
            				<label>Data de Abertura</label>
            					<p>${vaga.dataAbertura}</p>
            			</div>
            			<div class="col-md-3 well well-sm btn btn-info" style="    height: 56px;
    margin-right: 5px;
    width: 200px;
    margin-left: 5px;">
            				<label>Data de Aprovação</label>
            					<p>12/12/2019</p>
            			</div>
            			<div class="col-md-3 well well-sm btn btn-danger" style="    height: 56px;
    margin-right: 5px;
    width: 200px;
    margin-left: 5px;">
            				<label>Data de Fechamento</label>
            					<p>12/12/2019</p>
            			</div>
            			<div class="col-md-3 well well-sm btn btn-success" style="    height: 56px;
    margin-right: 5px;
    width: 200px;
    margin-left: 5px;">
            				<label>Proposta</label>
            					<p>R$ ${vaga.valorPretensao}</p>
            			</div>
            			<div class="col-md-3 well well-sm btn btn-warning" style="    height: 56px;
    margin-right: 5px;
    width: 200px;
    margin-left: 5px;">
            				<label>Numero de Candidatos</label>
            					<p>19</p>
            			</div>
            		</div>
            	
            	<br/>
            
            
             </div> </td>
        </tr>
								
								</c:forEach>
							</tbody>
						</table>
						
						
					</div>
					<!--</panel default>-->
					   <div class="panel-footer clearfix">
                          <div class="row">
                              <input type="hidden" id="pageActive" value="${page }">
                              <ul class="pagination pagination-xs m-top-none pull-right">
                                  <li>
                                      <c:if test="${page > 1}">
                                          <a href="<c:url value="/vaga/consultar" ><c:param name="page" value="${page - 1}"/></c:url>">Anterior</a>
                                      </c:if>
                                      <c:forEach begin="${startpage}" end="${endpage}" var="p">
                                          <a id="page${p}" href="<c:url value="/vaga/consultar" ><c:param name="page" value="${p}"/>${p}</c:url>">${p}</a>
                                      </c:forEach>
                                      <c:if test="${page < endpage}">
                                          <a href="<c:url value="/vaga/consultar" ><c:param name="page" value="${page + 1}"/></c:url>">Próximo</a>
                                      </c:if>
                                  </li>
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
	
	<script type="text/javascript">
	
	$('.accordian-body').on('show.bs.collapse', function () {
	    $(this).closest("table")
	        .find(".collapse.in")
	        .not(this)
	        .collapse('toggle')
	})
	
	var id = $("#idPerfil").val();
	$.ajax({
		url: "http://localhost:8080/usuario/obter-perfil-funcionalidade",
		type: "GET",
		dataType: "JSON",
		data: {id : id},
		success: function(lista){
			if(lista != null){
    				$.each(lista,function(i,item){
    					if(item.id == 24){
    						
    						$(".btnEdita").removeClass('hide')
    					}
    					
    				});
				
			}
		}
	});
	
	
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
	<script>/* paginação */
	var pagina = $('#pageActive').val();
	$('#page'+pagina).addClass('active');
	
	$(function	()	{
		$('#alterei').dataTable( {
			"bJQueryUI": true,
			"sPaginationType": "simple_numbers",
			"bFilter": false,
			"bInfo": false,
			"bLengthChange": false,
			"bSort": false,

			"oLanguage": {
				"sEmptyTable": "Nenhum registro encontrado",
				"sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
				"sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
				"sInfoFiltered": "(Filtrados de _MAX_ registros)",
				"sInfoPostFix": "",
				"sInfoThousands": ".",
				"sLengthMenu": "_MENU_ resultados por página",
				"sLoadingRecords": "Carregando...",
				"sProcessing": "Processando...",
				"sZeroRecords": "Nenhum registro encontrado",
				"sSearch": "Pesquisar",
				"oPaginate": {
					"sNext": "Próximo",
					"sPrevious": "Anterior",
					"sFirst": "Primeiro",
					"sLast": "Último"
				},
				"oAria": {
					"sSortAscending": ": Ordenar colunas de forma ascendente",
					"sSortDescending": ": Ordenar colunas de forma descendente"
				}
			}
		/* $(function	()	{
			$('#tabelaVaga').dataTable( {
				"bJQueryUI": true,
				"sPaginationType": "full_numbers"
			});
			$('#tabelaVaga_length').hide();
			$('#tabelaVaga_filter').hide();
			$('#tabelaVaga_info').hide();
			$('#tabelaVaga_last').css('margin-left:2000px');
			$('#tabelaVaga_next').css('margin-left:200px');
			$('#tabelaVaga_paginate').css('margin-left: 500px');
			$("#tabelaVaga_next").text("Próximo");
			$("#tabelaVaga_last").text("Último");
			$("#tabelaVaga_previous").text("Anterior");
			$("#tabelaVaga_first").text("Primeiro");
			
			$("#tabelaVaga_next").attr("href", "#");
			$("#tabelaVaga_last").attr("href", "#");
			$("#tabelaVaga_previous").attr("href", "#");
			$("#tabelaVaga_first").attr("href", "#");
			$(".fg-button").attr("href", "#"); */
 		
		});
	});
		
$(function() {
		
    	var id = $("#idPerfil").val();
    	$.ajax({
    		url: "http://localhost:8080/usuario/obter-perfil-funcionalidade",
    		type: "GET",
    		dataType: "JSON",
    		data: {id : id},
    		success: function(lista){
    			if(lista != null){
    				var editar = 0;
    				
	    				$.each(lista,function(i,item){
    						if(item.id == 31){
    							editar++;
	    					}
	    				});
	    				
    				if (editar == 0){
    					$('.pro').hide();
    					$('.pre').hide();
    				}
    				
    			}
    		}
    	});
	})
	
	function filtrarCandidato(){
	$.ajax({
		url: "filtro",
		type: "GET",
		dataType: "JSON",
		data: { 'CandidatoBean' : $('nomeVaga').val()},
		success: function(){
				location.reload();	
			}
	});
	}
	</script>
	
	</body>
	</html>