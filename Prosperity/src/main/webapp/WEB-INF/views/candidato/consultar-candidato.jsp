<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Consulta de candidatos</title>
	</layout:put>
'
	<layout:put block="contents">
		<style>
li a.active {
	background: #f2f2f2;
}
</style>	
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial">
							Página inicial</a></li>
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
								<form action="filtrar" method="GET" class="row" id="filtroForm">
									<div class="col-md-2">
										<label for="exampleInputEmail1">Nome: </label>
										<div class="search-block">
											<div class="input-group">
												<input type="text" class="form-control input-sm"
													placeholder="Nome" name="nome" value="${filtroC.nome }"
													id="nmCandidato">
											</div>
											<!-- /input-group -->
										</div>
										<!-- /search-block -->
									</div>
									<div class="col-md-2">
										<label for="exampleInputEmail1">Vaga</label> <select
											class="form-control inline" id="vagaFiltro"
											name="vagaBean.id">
											<option value="0">Selecione</option>
											<c:forEach var="vaga" items="${listaVagaDrop}">
												<option value="${vaga.id}"
													${vaga.id == filtroC.vagaBean.id? 'selected="selected"' : ''}>${vaga.nomeVaga}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-md-1">
										<label for="salário">Salário</label> <input type="text"
											class="form-control money2 parsley-validated"
											id="pretensaoDe" name="pretensaoDe" placeholder="De"
											style="width: 80px" value="${filtroC.pretensaoDe }">
									</div>
									<div class="col-md-1">
										<label for="exampleInputEmail1">&nbsp;</label> <input
											type="text" name="pretensaoPara" class="form-control money2"
											id="pretensaoPara" placeholder="Até" style="width: 80px"
											value="${filtroC.pretensaoPara }">
									</div>
									<div class="col-md-3">
										<label for="exampleInputEmail1">Data:</label>
										<div class="input-group">
											<fmt:formatDate value="${filtroC.dataAberturaDe}"
												pattern="yyyy-MM-dd" var="d1" />
											<fmt:formatDate value="${filtroC.dataAberturaPara}"
												pattern="yyyy-MM-dd" var="d2" />
											<input type="date" name="dataAberturaDe" class="form-control"
												value="${d1 }" id="dtDe"> <span
												class="input-group-addon">até</span> <input type="date"
												name="dataAberturaPara" class="form-control" value="${d2 }"
												id="dtPara">
										</div>
									</div>
									<div class="col-md-2 col-md-offset-1">
										<button class="btn btn-primary pull-right "
											style="margin-top: 22px" id="pesquisar">Pesquisar</button>
									</div>
								</form>
								<!-- /.row -->
								<br />
								<table id="tabelaVaga"
									class="table table-bordered table-condensed table-hover table-striped"
									style="font-size: 12px; vertical-align: middle">
									<thead>
										<tr>
											<th class="text-center">Nome do candidato</th>
											<th class="text-center">Vaga</th>
											<th class="text-center">Pretensão</th>
											<th class="text-center">Data de candidatura</th>
											<th class="text-center">Último status</th>
											<th class="text-center">Status atual</th>
											<th class="text-center">Ações</th>
										</tr>
									</thead>
									<tbody class="text-center">
										<c:forEach var="candidato" items="${candidatos}">
											<input type="hidden" value="${candidato.ultimoStatus}">
											<tr>
												<td>${candidato.nome}</td>
												<td>${candidato.ultimaVaga.nomeVaga}</td>
												<td><fmt:formatNumber
														value="${candidato.valorPretensao}" type="currency"></fmt:formatNumber></td>
												<td><fmt:formatDate value="${candidato.dataAbertura}"
														pattern="dd/MM/yyyy" /></td>
												<td id="linhaStatus"><span class="label"
													style="color: #fff; background-color: ${candidato.penultimoStatus.status.css}">${candidato.penultimoStatus.status.nome}</span></td>
												<td id="linhaStatus"><span class="label"
													style="color: #fff; background-color: ${candidato.ultimoStatus.status.css}">${candidato.ultimoStatus.status.nome}</span></td>
												<td>
													<div class="btn-group">
														<button class="btn btn-xs btn-info dropdown-toggle"
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="fa fa-cogs fa-lg">&nbsp;</i> <span
																class="caret"></span>
														</button>
														<ul class="dropdown-menu slidedown btnAlinhado">
															<li><c:url value="historico/${candidato.id}"
																	var="myURL">
																</c:url> <a href="${myURL}"><i class="fa fa-book fa-lg">&nbsp;</i>Histórico
																	do Candidato</a></li>
															<li class="divider js-editar"></li>
															<li class="js-editar"><c:url
																	value="editar/${candidato.id}" var="myURL">
																</c:url> <a href="${myURL}"><i class="fa fa-pencil fa-lg"></i>
																	Editar</a></li>
														</ul>
													</div>
												</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<c:forEach var="funcionalidade" items="${autenticado.perfil.listaFuncionalidades}">
									<input id = "func${funcionalidade.id}" type="hidden" value="${funcionalidade.id}">
								</c:forEach>
							</div>
							<!-- /.panel-body - ATE AQUI O FILTRAR-->
							<div class="panel-footer clearfix">

								<input type="hidden" id="pageActive" value="${page }">
								<ul class="pagination pagination-xs m-top-none pull-right">
									<li><c:if test="${page > 1}">
											<button class="btn btn-default btn-sm"
												onclick="paginar(${page-1})">Anterior</button>
										</c:if> <c:forEach begin="${startpage}" end="${endpage}" var="p">
											<button class="btn btn-default btn-sm"
												onclick="paginar(${p})" id="page${p}">${p}</button>
										</c:forEach> <c:if test="${page < endpage}">
											<button class="btn btn-default btn-sm"
												onclick="paginar(${page+1})">Próximo</button>
										</c:if></li>
								</ul>

								<button type="button" onclick="voltarConsultaVaga()" class="btn btn-xs btn-default js-retornar"><i
									class="fa fa-reply"></i> Retornar</button>

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
	
	function paginar (page){
		if($('#nmCandidato').val() || $('#vagaFiltro').val() > 0 || $('#pretensaoDe').val() ||
				$('#pretensaoPara').val() || $('#dtDe').val() || $('#dtPara').val()){
			$('form').append('<input type="hidden" name="page" value="' + page +'"/>')
			$('#pesquisar').click();
		}
		else{
			window.location.href = '/candidato/consultar?page='+page;
		}
	};
	
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
		
	</script>


		<script>
		
		function voltarConsultaVaga() {
			$('.js-retornar').click(function() {
				window.location.href = document.referrer;
			});
		}
		
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

		//Só RH pode editar:
		$(document).ready(function() {
			
			$('.js-editar').hide();
			$('.js-retornar').hide();
			
			if($('#func32').val()==32) {
				$('.js-editar').show();
			}
			if(document.referrer.match('/vaga/')) {
				$('.js-retornar').show();
			}
		});
		
	</script>
	</layout:put>
</layout:extends>