<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Aprovação de candidatos</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->

</head>
<body>

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!--    Modais   -->
	<!-- Modal Avaliação de Competencias -->
	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 style="text-align: center;">Gestão de candidato</h4>
				</div>
				<div class="modal-body">
					<div class="panel-body">

						<div class="form-group col-md-6">
							<div class="form-group">
								<label class="control-label">Parecer:</label>
								<div class="form-group">
									<input type="hidden" id="hdn-id-candidato" /> <input
										type="hidden" id="hdn-status" />
									<textarea class="form-control" id="parecer"
										style="margin-left: 0px; width: 770px" name="parecer"></textarea>
								</div>
								<!-- /.col -->
							</div>
							<!-- /form-group -->
						</div>
						<!-- /form-group -->
					</div>

					<div class="panel-footer ">

						<button type="button" class="btn btn-sm btn-primary"
							id="btnVaiTomarNoCu">
							<i class="fa fa-check fa-lg"></i>&nbsp;Enviar
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Modal Feedback-->
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
					<h4 class="modal-title" id="modalLabel">Fechar vaga</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir esta vaga?</div>
				<div class="modal-footer">
					<a id="excluir" href="#">
						<button type="button" class="btn btn-danger">Sim</button>
					</a>
					<button type="button" class="btn btn-success" data-dismiss="modal">Não</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal delete-->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="index.html"> Home</a></li>
				<li>Consultar</li>
				<li class="active">Aprovação de candidatos</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<div class="padding-md">
				<div class="row">
					<div>
						<div class="panel panel-default">
							<div class="panel-heading">Aprovação de candidatos</div>
							<div class="panel-body">
								<table
									class="table table-bordered table-condensed table-hover table-striped"
									id=""
									style="font-size: 12px !important; vertical-align: middle !important;">
									<thead>
										<tr>
											<th class="text-center">Nome do candidato</th>
											<th class="text-center">Vaga</th>
											<th class="text-center">Pretensão</th>
											<th class="text-center">Data de abertura</th>
											<th class="text-center">Data de aprovação</th>
											<th class="text-center">Status</th>
											<th class="text-center">Ações</th>
										</tr>
									</thead>
									<tbody class="text-center">

										<c:forEach var="candidato" items="${candidatos}">
											<tr>
												<td>${candidato.nome}</td>
												<td>placeholder</td>
												<td>${candidato.valorPretensao}</td>
												<td><fmt:formatDate value="${candidato.dataAbertura}"
														pattern="dd/MM/yyyy" /></td>
												<td><fmt:formatDate value="${candidato.dataFechamento}"
														pattern="dd/MM/yyyy" /></td>
												<td><span class="label" style="color: #fff; background: ${candidato.ultimoStatus.status.css}">${candidato.ultimoStatus.status.nome}</span></td>
												<td><span class="line"></span>
													<div class="btn-group">

														<!-- comeco do botao -->
														<button type="button"
															class="btn btn-info dropdown-toggle btn-sm"
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="fa fa-cogs fa-lg">&nbsp; </i><span
																class="caret"></span>
														</button>
														<ul class="dropdown-menu slidedown btnAlinhado">
															<li><a data-toggle="modal" data-toggle="modal"
																data-target=".bs-example-modal-lg"
																id="aprovar-candidato"
																onclick="alterarStatus(${candidato.id}, 5)"><i
																	class="fa fa-check fa-lg"></i>&nbsp;Aprovar candidato</a></li>

															<li class="divider"></li>

															<li><a href="#aprovado-modal" data-toggle="modal"
																data-toggle="modal" data-target=".bs-example-modal-lg"><i
																	class="fa fa-times fa-lg"></i>&nbsp;Reprovar candidato</a></li>


															<li class="divider"></li>

															<li><a href="#aprovado-modal" data-toggle="modal"
																data-toggle="modal" data-target=".bs-example-modal-lg"><i
																	class="fa fa-check fa-lg"></i>&nbsp;Aprovar proposta</a></li>

															<li class="divider"></li>

															<li><a href="#aprovado-modal" data-toggle="modal"
																data-toggle="modal" data-target=".bs-example-modal-lg"><i
																	class="fa fa-times fa-lg"></i>&nbsp;Recusar proposta</a></li>

															<li class="divider"></li>

															<li><a href="#aprovado-modal" data-toggle="modal"
																data-toggle="modal" data-target=".bs-example-modal-lg"><i
																	class="fa fa-check fa-lg"></i>&nbsp;Proposta aceita</a></li>

															<li class="divider"></li>

															<li><a href="#aprovado-modal" data-toggle="modal"
																data-toggle="modal" data-target=".bs-example-modal-lg"><i
																	class="fa fa-times fa-lg"></i>&nbsp;Proposta recusada</a></li>

															<li class="divider"></li>

															<li><a href="#aprovado-modal" data-toggle="modal"
																data-toggle="modal" data-target=".bs-example-modal-lg"><i
																	class="fa fa-refresh fa-lg"></i>&nbsp;Refazer proposta</a></li>

															<li class="divider"></li>

															<li><a href="#"><i class="fa fa-pencil fa-lg">&nbsp;</i>Editar</a></li>

															<li class="divider"></li>

															<li><a href="#delete-modal" data-toggle="modal"><i
																	class="fa fa-trash-o fa-lg">&nbsp;</i>Cancelar</a></li>
														</ul>
													</div> <!-- /fim botao --></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>
							<!-- /.row -->
						</div>
						<!-- /.panel-body -->

					</div>
					<!-- fim da div panel -->
					<div class="panel-footer clearfix">
						<ul class="pagination pagination-xs m-top-none pull-right">
							<li class="disabled"><a href="#">Anterior</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">Próxima</a></li>
						</ul>
					</div>
				</div>
				<!-- /col-md-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.paddin.md -->
	</div>
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
	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>

	<script>
		/* $(function() {
			$('#dataTable').dataTable({
				"bJQueryUI" : true,
				"sPaginationType" : "full_numbers"
			}); */

			$('#btnVaiTomarNoCu').click(function() {

				$.ajax({
					url : "alterar-status-candidato",
					type : "POST",
					dataType : "JSON",
					data : {
						'idCandidato' : $('#hdn-id-candidato').val(),
						'parecer' : $('#parecer').val(),
						'idStatus' : $('#hdn-status').val()
					},
					success : function(data) {
						alert(data);
					}
				});
			});
		//});

		function alterarStatus(idCandidato, idStatus) {
			alert(idCandidato);
			alert(idStatus);
			$('#hdn-id-candidato').val(idCandidato);
			$('#hdn-status').val(idStatus);
		}
	</script>


</body>
</html>