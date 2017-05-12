<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Aprovação de vagas</title>
		<link rel="stylesheet" href="/resources/css/custom/aprovar-vaga.css" />
	</layout:put>

	<layout:put block="contents">
		<!-- Modal visualizar-->
		<div class="modal fade" id="vaga-modal" data-target="#vaga-modal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
				
					<div id="print_helper"></div>
				<div id="print_helper"></div>
					<div id="printThis">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="titulo">Vaga</h4>
						</div>
						<div class="modal-body">
							<div class="panel-tab clearfix">
								
							</div>
							<div class="tab-content">
								<div id="home" class="tab-pane fade in active">
									<section class="panel panel-default" style="margin-bottom: 0px">
										<div class="panel-heading"><strong>Informações básicas</strong></div>
										<div class="panel-body">
											<form>
												<div class="form-group row">
													<div>
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="solicitante">Solicitante</label> <input
																class="form-control input-sm" disabled
																name="solicitante.id" id="solicitante"
																data-required="true" name="solicitante">
														</div>
														<!-- /form-group -->

														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputEmail1">Local de
																trabalho:</label>
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
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="cargo">Nome do cargo</label> <input
																type="name" class="form-control input-sm" id="cargo"
																value="Cargo" disabled>
														</div>
														<!-- /form-group -->

														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="exampleInputEmail1">Tipo de vaga:</label>
															<div class="radiogroup" name="idTipoVaga" id="tipo">
																<label id="tpVaga" class="label-radio inline" value="">
																</label>
															</div>
															<!-- /.col -->
														</div>
													</div>
												</div>
												<div class="form-group row" style="margin-bottom: 0px;">
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">
														<label for="vagaSenioridade">Senioridade da vaga</label> <input
															type="name" class="form-control input-sm"
															id="vagaSenioridade" placeholder="Estágio"
															value="Senioridade
													da Vaga" disabled>
													</div>
													<!-- /form-group -->
													<div class="form-group" style="margin-bottom: 0px">
														<label for="vagaHorario" style="padding-left: 15px;">Horário:</label>

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
																		style="margin-top: 7px"></label>
																</div>
															</div>
														</div>

													</div>
												</div>

												<div class="form-group row">
													<div class="">
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="vagaSalario">Faixa salarial</label> <input
																class="form-control input-sm" id="vagaSalario"
																placeholder="Faixa Salarial" disabled>
														</div>
														<!-- /form-group -->
														<div class="form-group col-md-6 col-xs-6"
															style="margin-bottom: 0px">
															<label for="vagaQuadro">Aumento de quadro:</label>
															<div class="radiogroup" id="aumento">
																<label id="lblQuadro" class="label-radio inline">
																</label>

															</div>
															<!-- /.col -->
														</div>
													</div>
												</div>
												<div class="form-group row" style="margin-bottom: 0px">
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">
														<div class="form-group">

															<label class="control-label"> Data para inicio</label>
															<div class="form-group">
																<div class="input-group">
																	<fmt:formatDate value="${vaga.dataInicio}"
																		pattern="dd/MM/yyyy" var="dataInicio" />
																	<input type="date" value="${vaga.dataInicio}"
																		name="dataInicio" class="datepicker form-control"
																		id="dataInicio" disabled> <span
																		class="input-group-addon"><i
																		class="fa fa-calendar"></i></span>
																</div>
															</div>
															<!-- /.col -->
														</div>
														<!-- /form-group -->
													</div>
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 0px">
														<div id="" class="">
															<label id="substituidoId">Nome do substituido:</label>
														</div>
														<label id="vagaSubstituto" style="margin-top: 7px"></label>
													</div>
												</div>
											</form>
										</div>
									</section>
									<!-- /Section -->

									<div id="quebra">
										<section class="panel panel-default"
											style="margin-bottom: 5px;">
											<div class="panel-heading"><strong>Informações de projeto</strong></div>
											<div class="panel-body">
												<div class="row">
													<!-- /form-group -->
													<div class="form-group col-md-12"
														style="margin-bottom: 5px;">
														<label class="control-label">Projeto</label> <input
															readonly class="form-control default-cursor"
															id="vagaProjeto" value="Mobile">
													</div>
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 5px;">
														<label class="control-label">Cliente</label> <input
															readonly class="form-control" id="vagaCliente"
															value="Carrefour">
													</div>
													<div class="form-group col-md-6 col-xs-6"
														style="margin-bottom: 5px;">
														<label class="control-label">Gestor imediato</label> <input
															readonly class="form-control" id="vagaGestor"
															value="Vitor Tadashi">
													</div>
													<div id="interno">
													<div class="form-group col-md-6 col-xs-6"
													style="margin-bottom: 5px;">
												    <label class="control-label">Nome do responsável</label> 
												    <input readonly class="form-control" class="form-control input-sm" id="nmResponsavel"
													value=""> 
													</div>
													
													<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 5px;">
													<label class="control-label">Área do responsável</label> 
													<input readonly class="form-control" id="nmAreaResponsavel" 
													value=""> 
													</div>
													
													<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 5px;">
													<label class="control-label">E-mail do responsável</label> 
													<input readonly class="form-control" id="emailResponsavel" 
													value=""> 
													</div>
													
													<div class="form-group col-md-6 col-xs-6" style="margin-bottom: 5px;">
													<label class="control-label">Telefone</label> 
													<input readonly class="form-control" id="telResponsavel" 
													value=""> 
													</div>
													</div>
												</div>
												
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default"
											style="margin-bottom: 0px;">
											<div style="page-break-before: always;"></div>
											<div class="panel-heading"><strong>Formação acadêmica</strong></div>
											<div class="panel-body relative">
													<p class="text-justify">
														<span id="vagaFormacao"></span>
													</p>
												<!-- /form-group -->
											</div>
										</section>
										<!-- /panel -->
										<section class="panel panel-default"
											style="margin-bottom: 0px;">
											<div class="panel-heading"><strong>Perfil comportamental</strong></div>
											<div class="panel-body relative">
													<p class="text-justify">
														<span id="vagaPerfil"></span>
													</p>
												<!-- /form-group -->
											</div>
										</section>
										<!-- /panel -->

										<section class="panel panel-default "
											style="margin-bottom: 0px;">
											<div class="panel-heading"><strong>Perfil técnico</strong></div>
											<div class="panel-body relative">
												<p class="text-justify">
													<span id="vagaPerfilTecnico"></span>
												</p>
											</div>
										</section>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /tab-content -->
					<!-- /panel -->
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="Print">Imprimir</button>
					</div>
				</div>
			</div>
		</div>
		<!-- modal padrão -->
		<div class="modal fade" id="modal-status" data-target="#modal-status"
			tabindex="-1" role="dialog" aria-labelledby="modalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Fechar">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalLabel"></h4>
					</div>
					<div class="modal-body" id="mensagem-modal" ></div>
					<input class="id-vaga" name="idVaga" type="hidden"> <input
						class="id-status" name="idStatus" type="hidden">
					<div class="modal-footer">
						<a href="#">
							<button id="excluiVaga" onclick="status()" type="button"
								class="btn btn-success" data-dismiss="modal">Sim</button>
						</a>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Não</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal padrão -->
	<!-- CORPO DA PÁGINA -->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial">
							Página inicial</a></li>
					<li class="active">Aprovação de vaga</li>
				</ul>
			</div>
			<!--breadcrumb-->

			<div class="padding-md" id="fourth">
				<div class="panel panel-default">
					<div class="panel-heading">Aprovação de vaga</div>
					<div class="panel-body">
							<div id="divAlert"></div>
								<c:if test="${not empty mensagem}">
									<div class="alert alert-info mensagem">${mensagem}</div>
								</c:if>
								<div class ="table-responsive">
						<table 
							class="table table-bordered table-condensed table-hover table-striped"
							id="tabelaVaga"
							style="font-size: 12px !important; vertical-align: middle !important;">
							<!-- Começo Tabela -->
							<thead>
								<tr class="text-center">
									<th class="text-center">Nome da vaga</th>
									<th class="text-center">Cargo</th>
									<th class="text-center">Senioridade</th>
									<th class="text-center">Solicitante</th>
									<th class="text-center">Projeto</th>
									<!-- <th class="text-center">Cliente</th>
								<th class="text-center">Local de trabalho</th> -->
									<th class="text-center">Data abertura</th>
									<th class="text-center">Status</th>
									<th class="text-center">Ações</th>
								</tr>
							</thead>
							<tbody class="text-center">
								<c:forEach var="vaga" items="${vagas}" varStatus="i">
								
								
									<tr>
										<td>${vaga.nomeVaga}</td>
										<td>${vaga.cargoBean.nome}</td>
										<td>${vaga.senioridadeBean.nome}</td>
										<td style="width: 112px;">${vaga.nomeSolicitante}</td>
										<td style="width: 302px;">${vaga.projeto.nome}</td>
										<%-- <td>${vaga.projeto.cliente.nome}</td>
									<td><c:if test="${vaga.localTrabalho == 73}">
										     Interno
										</c:if> <c:if test="${vaga.localTrabalho == 67}">
										     Cliente
										</c:if></td> --%>
										<td><fmt:formatDate value="${vaga.dataAbertura }"
												pattern="dd/MM/yyyy" /></td>
										<td id="linhaStatus"><span class="label"
											style="color: #fff; background-color:${vaga.ultimoStatus.status.css}">${vaga.ultimoStatus.status.nome}</span></td>
										<td>
											<div class="btn-group">
												<!-- <-- ! Começo Botão -->
												
												<input type="hidden" name="idStatus" id="idStatus"
													value="${vaga.ultimoStatus.status.id}" />
													<div class="btn-group">
														<button class="btn btn-sm btn-info dropdown-toggle"
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="fa fa-cogs fa-lg">&nbsp;</i> <span
																class="caret"></span>
														</button>
														
														
														<ul class="dropdown-menu dropdown-menu-right slidedown">
														<li> <c:url
																	value="aprovar/${vaga.id}"
																	var="urlCancelar">
																</c:url>
																<a href="vaga-modal"
																onclick="info(${vaga.id})"
																data-toggle="modal"><i class="fa fa-eye fa-lg">&nbsp;</i>Visualizar</a></li>
															<c:forEach var="statusDisponivel"
																items="${vaga.ultimoStatus.status.statusDisponiveis}">
																<li class="divider"></li>
																<li><a class="clickable" 
																	id="vaga-modal" 
																	onclick="alterarStatus(${vaga.id}, ${statusDisponivel.idStatusDisponivel})">
																		<i ${statusDisponivel.classe}>&nbsp;</i>${statusDisponivel.nome}</a></li>
															</c:forEach>
														</ul>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					
						<!-- Fim Tabela -->
					</div>
					<!-- /panel -->
				</div>
				<!-- /.padding-md -->
			</div>
			<!-- /wrapper -->
		</div>
	</layout:put>

	<layout:put block="scripts" type="REPLACE">
	<script type="text/javascript">
	
	// script para cores dos status
	$(".span-Fechado").addClass("label-warning");
	$(".span-Ativo").addClass("label-success");
	$(".span-Cancelado").addClass("label-danger");
	$(".span-Pendente").addClass("label-info");
	
	// função para mostrar no modal (visualizar) os campos preenchidos
	function info(listaId){
    	//
    	$.ajax({
    		url: "abrir",
    		type: "GET",
    		dataType: "JSON",
    		data: { 'id' : listaId},
    		success: function(lista){
    			console.log(lista);
    			$('#titulo').html(lista.nomeVaga);
    			
    			if(lista.localTrabalho == 'C') {
    				//$("#cliente").attr('checked', 'checked');
    				$("#lblLocal").text('Cliente')
    				$('div#divLocalTrabalho').show();
    				$('#nmResponsavel').val(lista.nmResponsavel);
    				$('#nmAreaResponsavel').val(lista.nmAreaResponsavel);
    				$('#emailResponsavel').val(lista.emailResponsavel);
    				$('#telResponsavel').val(lista.telResponsavel);
    				$("#interno").show();
    			} else {
    				//$("#interno").attr('checked', 'checked');
    				$("#lblLocal").text('Interno')
    				$("#interno").hide();
    			}
    			if(lista.idTipoVaga == 'H') { 
    				$("#tpVaga").text('Hunting')
    			} else if(lista.idTipoVaga == 'P') {
    				$("#tpVaga").text('Prospecção')
    			} else {
    				$("#tpVaga").text('Real')
    			}
    			if(lista.aumentaQuadro == 'N') {
    				$("#lblQuadro").text('Novo')
    				$("#substituidoId").hide();
    				$("#vagaSubstituto").hide();
       			} else {
       				$("#lblQuadro").text('Substituição')
       				$("#substituidoId").show();
    				$("#vagaSubstituto").show();
    			}
    			//var rangeSalarial = ${rangeSalarial.valorMaxSalario};
    			//$('input#vagaSalario').val(rangeSalarial);
    			$('input#cargo').val(lista.cargoBean.nome);
    			$('input#vagaSenioridade').val(lista.senioridadeBean.nome);
    			$('label#horaEntrada').text(lista.horarioEntrada);
    			$('label#horaSaida').text(lista.horarioSaida);
    			$('input#solicitante').val(lista.nomeSolicitante);
    			$('input#vagaQuadro').val(lista.aumentaQuadro);
    			$('label#vagaSubstituto').text(lista.nomeSubstituido);
    			$('input#dataInicio').val(lista.dataInicio);
    			$('input#vagaCliente').val(lista.projeto.cliente.nome);
    			$('input#vagaProjeto').val(lista.projeto.nome);
    			$('#vagaPerfil').text(lista.descricaoPerfilComportamental);
    			$('#vagaFormacao').text(lista.descricaoFormacaoAcademica);
    			$('#vagaPerfilTecnico').text(lista.descricaoPerfilTecnico);
    			$('#vagaGestor').val(lista.usuarioBean.funcionario.nome);
    			
    				var idSenioridade = lista.senioridadeBean.id;
    				var idCargo = lista.cargoBean.id;
    				if (idSenioridade>0 && idCargo>0){
    					$.ajax({
    						url: "/vaga/obter-range-salarial",
    						type: "GET",
    						dataType: "JSON",
    						data: {idCargo : idCargo,
    							idSenioridade : idSenioridade},
    						success: function(lista){
    							$('input#vagaSalario').val("R$ " + lista[0].valorMinSalario + " até " + "R$ " + lista[0].valorMaxSalario);
    							//$("#valorMaximo").val(lista[0].valorMaxSalario);
    						}
    					});
    				} else{
    					$('input#vagaSalario').val("R$ 00,00 - R$ 00,00");
    				}
    			
    			$('#vaga-modal').modal('show');
    		}
    	})
    } 

	// metodo para a função imprimir
	document.getElementById("Print").onclick = function () {
	    printElement(document.getElementById("printThis"));
	};

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
		
	// função para a alteração de status de acordo com os botões de ação.
	
	function status(){
    	$.ajax({
    		url: "status",
    		type: "POST",
    		dataType: "JSON",
    		data: { 'idVaga' : $('.id-vaga').val(), 'idStatus' : $('.id-status').val()}
    		}).done(function(dado) {
    			if(dado == '1') {
    				$('#aprova-modal').modal('hide');
        			msg = 'Vaga aprovada com sucesso!';
    			}else if(dado == '3'){
        			$('#cancela-modal').modal('hide');
        			msg = 'Vaga cancelada com sucesso!';
    			}else if(dado == '27'){
        			$('#aprova-modal').modal('hide');
        			msg = 'Vaga ativada com sucesso!';
    			}else if (dado == '18'){
    			$('#reprova-modal').modal('hide');
    			msg = 'Vaga reprovada com sucesso!';
    			}else if (dado == '2'){
        			$('#fechar-modal').modal('hide');
        			msg = 'Vaga fechada com sucesso!';
    			}
    			
    			$('#divAlert').html(msg).addClass('alert alert-success').show();
    			escondeMensagem();
    			setTimeout('location.reload();', 3000);
    			//location.reload();
        	}).fail(function(jqXHR, textStatus) {
    			console.log();
    			console.log(jqXHR);
    			console.log(textStatus);
    			
    		});
    }
	
	function escondeMensagem() {
		window.setTimeout(function () {
			$("#divAlert").hide();
			$(".mensagem").hide();
		}, 5000);
	}
    	/* 	data: { 'idVaga' : $('.aprovar-id').val(), 'status' : $('.aprovar-status').val()},
    		success: function(){
    				location.reload();	
    			}
    	}); */
    	
	// funcao para alterar status
	function alterarStatus(id,status){
    		var mensagem;
    		var titulo;
    		
    	$('input.id-vaga').val(id);
    	$('input.id-status').val(status);
    		
    	if( status == '1'){
    		titulo = "Aprovar vaga"
    		mensagem = "Deseja realmente aprovar esta vaga?";
    	}else if(status == '18'){
			titulo = "Reprovar vaga"
			mensagem = "Deseja realmente reprovar esta vaga?";
		}else if(status == '3'){
			titulo = "Cancelar vaga"
			mensagem = "Deseja realmente cancelar esta vaga?"
		}else if(status == '2'){
			titulo = "Fechar vaga"
			mensagem = "Deseja realmente fechar esta vaga?"
		}else if(dado == '27'){
			titulo = "Ativar vaga"
			msg = 'Deseja realmente ativar esta vaga?';
		}
    	
    	$("#modalLabel").text(titulo);
    	$("#mensagem-modal").text(mensagem);
    	$("#modal-status").modal();
    	
	}
	// função para formatar a dataInicio dd/MM/yyyy no modal (visualizar)
	function dataAtualFormatada(){
	    var data = new Date();
	    var dia = data.getDate();
	    if (dia.toString().length == 1)
	      dia = "0"+dia;
	    var mes = data.getMonth()+1;
	    if (mes.toString().length == 1)
	      mes = "0"+mes;
	    var ano = data.getFullYear();  
	    return dia+"/"+mes+"/"+ano;
	}
	
	// função para o metodo status ativo
	$(function() {
		
    	var id = $("#idPerfil").val();
    	$.ajax({
    		url: "/usuario/obter-perfil-funcionalidade",
    		type: "GET",
    		dataType: "JSON",
    		data: {id : id},
    		success: function(lista){
    			if(lista != null){
    				var cancelar = 0;
    				var fechar = 0;
    				
	    				$.each(lista,function(i,item){
    						if(item.id == 29){
    							cancelar++;
	    					}
    						if(item.id == 30){
    							fechar++;
	    					}
	    				});
	    				
    				if (cancelar == 0){
    					$('.cancelarAtivos').hide();
   						$('.cancelarDivider').hide();
    				}
    				if (fechar == 0){
    					$('.fecharAtivo').hide();
   						$('.fecharDivider').hide();
   						
   						
    				}
    			}
    		}
    	});
	});
	
	</script>
	</layout:put>
</layout:extends>