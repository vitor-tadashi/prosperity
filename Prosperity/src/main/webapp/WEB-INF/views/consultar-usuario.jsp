<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Consulta de usuário</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->
<style>
.status {
	font-size: 12px;
}
</style>

</head>

<body>
	<!-- Modais aqui-->
	<!-- Modal -->
	<div class="modal fade" id="novo-usuario-modal"
		data-target="#novo-usuario-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Novo usuário</h4>
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
				</div>
			</div>
		</div>
	</div>

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

	<c:import url="shared/dashboard.jsp"></c:import>

	<!-- Corpo da pagina aqui -->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						Início</a></li>
				<li class="active">Consultar usuário</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<div class="padding-md">
				<div class="row">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-heading">Consultar usuário</div>
							<table
								class="table table-bordered table-condensed table-hover table-striped"
								id=""
								style="font-size: 12px !important; vertical-align: middle !important;">
								<thead>
									<tr class="text-center">
										<th class="text-center">Funcionário</th>
										<th class="text-center">Usuário</th>
										<th class="text-center">E-mail</th>
										<th class="text-center">Perfil</th>
										<th class="text-center">Situação</th>
										<th class="text-center">Ações</th>
									</tr>
								</thead>
								<tbody>
									<tr class="text-center">
										<td>André</td>
										<td>Andre.Verity</td>
										<td>andre@verity.com.br</td>
										<td>RH</td>
										<td><span class="label label-success status ">Ativo</span>
										</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-info" href="#editar-usuario-modal"
													data-toggle="modal"><i class="fa fa-edit"></i> Editar</a>
											</div>
										</td>
									</tr>
									<tr class="text-center">
										<td>Vitor</td>
										<td>vitor.verity</td>
										<td>vitor@verity.com.br</td>
										<td>Gestor</td>
										<td><span class="label label-success status">Ativo</span>
										</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-info" href="#editar-usuario-modal"
													data-toggle="modal"><i class="fa fa-edit"></i> Editar</a>
											</div>
										</td>
									</tr>
									<tr class="text-center">
										<td>Alexandro</td>
										<td>alexandro.verity</td>
										<td>alexandro@verity.com.br</td>
										<td>CEO</td>

										<td><span class="label label-success status">Ativo</span>
										</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-info" href="#editar-usuario-modal"
													data-toggle="modal"><i class="fa fa-edit"></i> Editar</a>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<br>
						</div>
						<!-- /.col -->
						<div class="pull-right">
							<a class="btn btn-primary" href="#novo-usuario-modal"
								data-toggle="modal">Criar novo usuário</a> <a
								class="btn btn-warning" href="controlar-perfil.html">Criar
								perfil</a>
						</div>
					</div>
				</div>
			</div>
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
	</div>

	<c:import url="shared/footer.jsp"></c:import>
	<c:import url="shared/js.jsp"></c:import>

	<!-- javaScript aqui -->
</body>
</html>