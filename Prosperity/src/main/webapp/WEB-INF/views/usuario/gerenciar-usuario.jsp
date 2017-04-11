<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Controle de usuários</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->
</head>

<body>
	<!-- Modais aqui-->
	<!-- Modal -->
	<div class="modal fade" id="usuario-modal" tabindex="-1" role="dialog"
		aria-labelledby="usuarioLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="usuarioLabel">Novo usuário</h4>
				</div>
				<div class="modal-body">
					<div class="padding-md">
						<div class="row">
							<form action="cadastrar" method="POST" id="frmUsuario" data-validate="parsley" novalidate>
								<input type="hidden" name="id" id="id" />
								<div class="row">
									<div class="form-group col-md-6">
										<label for="funcionario">Funcionário</label>
										<select class="form-control" name="funcionario.id" id="cmbFuncionario" data-required="true">
											<option value="">Selecione</option>
											<c:forEach var="funcionario" items="${funcionarios}">
												<option value="${funcionario.id}">${funcionario.nome}</option>
											</c:forEach>
										</select>
									</div>
									
									<div class="form-group col-md-6">
										<label for="usuario">Usuário</label>
										<input type="text" data-type="user" class="form-control" id="usuario" data-required="true" name="nome" placeholder="Informe o usuário">
									</div>
									<div class="form-group col-md-6">
										<label for="email">E-mail corporativo</label>
										<input type="email" class="form-control" id="email" data-required="true" name="email" placeholder="example@verity.com.br">
									</div>
									<div class="form-group col-md-6">
										<label for="permissao">Perfil</label>
										<select class="form-control" name="perfil.id" id="cmbPerfil" data-required="true">
											<option value="">Selecione</option>
											<c:forEach var="perfil" items="${perfis}">
												<option value="${perfil.id}">${perfil.nome}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</form>
						</div>
						<!--close row-->
					</div>
					<!--close padding-->
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger" id="btnMudarStatus">
					</button>
					<button class="btn btn-warning" id="btnRedefinirSenha">
						<i class="fa fa-edit"></i> Redefinir senha
					</button>
					<button class="btn btn-success" id="btnSalvar">
						<i class="fa fa-check"></i> Salvar
					</button>
				</div>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!-- Corpo da pagina aqui -->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="/pagina-inicial">
						Início</a></li>
				<li class="active">Controle de usuários</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<div class="padding-md">
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading"><strong>Usuários:</strong></div>
							<div class="panel-body">
								<div id="divAlert"></div>
								<c:if test="${not empty mensagem}">
									<div class="alert alert-info mensagem">
										${mensagem}
									</div>
								</c:if>
								<table class="table table-bordered table-condensed table-hover table-striped" id="tbUsuario">
									<thead>
										<tr>
											<th class="text-center">Nome</th>
											<th class="text-center">Usuário</th>
											<th class="text-center">E-mail</th>
											<th class="text-center">Perfil</th>
											<th class="text-center">Situação</th>
											<th class="text-center">Editar</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="usuario" items="${usuarios}">
											<tr class="text-center">
												<td>${usuario.funcionario.nome}</td>
												<td>${usuario.nome}</td>
												<td>${usuario.email}</td>
												<td>${usuario.perfil.nome}</td>
												<td id="status_${usuario.id}">
													<c:if test="${usuario.ativo}">
														<span class="label label-success status">Ativo</span>
													</c:if>
													<c:if test="${!usuario.ativo}">
														<span class="label label-danger status">Inativo</span>
													</c:if>
												</td>
												<td>
													<div class="btn-group">
														<a class="btn btn-info btn-xs" onclick="abrirModal('editar', ${usuario.id})"><i class="fa fa-edit"></i></a>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.col -->
						<div class="pull-right">
							<a class="btn btn-primary" onclick="abrirModal('incluir')"><span class="fa fa-plus"></span> Novo usuário</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
	
	<!-- javaScript aqui -->
	<script src="/resources/js/api/usuario-api.js"></script>
	<script src='/resources/js/parsley.min.js'></script>
	<script>/* paginação */
		$(function	()	{
			$('#tbUsuario').dataTable( {
				"bJQueryUI": true,
				"sPaginationType": "simple_numbers",
				"bFilter": false,
				"bInfo": false,
				"bLengthChange": false,
	
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
	 		
			});
	});
	</script>
</body>
</html>