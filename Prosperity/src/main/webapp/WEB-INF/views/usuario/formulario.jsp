<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Consulta de usuário</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->

</head>

<body>
	<!-- Modais aqui-->

	<!-- Modal -->
	<div class="modal fade" id="editar-usuario-modal"
		data-target="#editar-usuario-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Editar usuário</h4>
				</div>
				<div class="modal-body">
					<div class="padding-md">
						<div class="row">
							<form>
								<div class="row">
									<div class="form-group col-md-6">
										<label for="funcionario">Funcionário</label> <select
											class="form-control">
											<option value="0">Selecionar funcionário</option>
											<option value="1">André</option>
											<option value="2">Daniel</option>
											<option value="3">Fabio</option>
											<option value="4">Graziela</option>
											<option value="5">Guilherme</option>
											<option value="6">Iago</option>
											<option value="7">Leonardo</option>
											<option value="8">Stephen</option>
											<option value="9">Thamires</option>
											<option value="10">Vitor</option>
											<option value="11">Yuri</option>
										</select>
									</div>
									<div class="form-group col-md-6">
										<label for="usuario">Usuário</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user"></i></span>
											<input type="text" class="form-control" id="usuario"
												data-required="true">
										</div>
									</div>
									<div class="form-group col-md-6 cold-md-offset-6">
										<label for="email">E-mail corporativo</label>
										<div class="input-group">
											<span class="input-group-addon">@</span> <input type="email"
												class="form-control" id="email" data-required="true">
										</div>
									</div>
									<div class="form-group open col-md-6">
										<label for="permissao">Perfil</label> <select
											class="form-control">
											<option value="0">Selecionar</option>
											<option value="1">Administrador</option>
											<option value="2">RH</option>
											<option value="3">Gestor Administrativo</option>
											<option value="4">Gestor de Desenvolvimento</option>
											<option value="5">Gestor de Teste</option>
											<option value="6">Gestor de Projetos</option>
											<option value="7">Arquiteto</option>
											<option value="8">Diretor de Operação</option>
											<option value="9">CEO</option>
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
					<button class="btn btn-success">
						<i class="fa fa-check"></i> Salvar
					</button>
					<button class="btn btn-warning">
						<i class="fa fa-edit"></i> Redefinir senha
					</button>
					<button class="btn btn-danger">
						<span class="fa fa-power-off"></span> Desativar
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
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						Início</a></li>
				<li><a href="listar">Consultar usuário</a></li>
				<li class="active">${title} usuário</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<div class="padding-md">
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading">${title} usuário</div>
							<div class="panel-body">
								<form action="cadastrar" method="POST">
									<input type="hidden" name="id" value="${usuario.id}" />
									<div class="row">
										<div class="form-group col-md-6">
											<label for="funcionario">Funcionário</label> <select
												class="form-control" name="funcionario.id" id="cmbFuncionario">
												<option value="">Selecione...</option>
												<c:forEach var="funcionario" items="${funcionarios}">
													<option value="${funcionario.id}">${funcionario.nome}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group col-md-6">
											<label for="usuario">Usuário</label>
											<div class="input-group">
												<span class="input-group-addon"><i class="fa fa-user"></i></span>
												<input type="text" class="form-control" id="usuario"
													data-required="true" name="nome" value="${usuario.nome}">
											</div>
										</div>
										<div class="form-group col-md-6 cold-md-offset-6">
											<label for="email">E-mail corporativo</label>
											<div class="input-group">
												<span class="input-group-addon">@</span> <input type="email"
													class="form-control" id="email" data-required="true" name="email" value="${usuario.email}">
											</div>
										</div>
										<div class="form-group open col-md-6">
											<label for="permissao">Perfil</label> <select
												class="form-control" name="perfil.id" id="cmbPerfil">
												<option value="">Selecione...</option>
												<c:forEach var="perfil" items="${perfis}">
													<option value="${perfil.id}">${perfil.nome}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<button type="submit" class="btn btn-success"><i class="fa fa-check"></i> Confirmar</button>
									<c:if test="${usuario.id != null}">
										<a class="btn btn-warning" href="redefinir-senha">
											<i class="fa fa-refresh"></i> Redefinir senha
										</a>
										<c:if test="${!usuario.ativo}">
											<a class="btn btn-primary" href="mudar-status?ativo=${usuario.ativo}">
												<span class="fa fa-power-off"></span> Ativar
											</a>
										</c:if>
										<c:if test="${usuario.ativo}">
											<a class="btn btn-danger" href="mudar-status?ativo=${usuario.ativo}">
												<span class="fa fa-power-off"></span> Desativar
											</a>
										</c:if>
									</c:if>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
	
	<!-- javaScript aqui -->
	<script>
		$('select#cmbFuncionario').val(${usuario.funcionario.id});
		$('select#cmbPerfil').val(${usuario.perfil.id});
	</script>
</body>
</html>