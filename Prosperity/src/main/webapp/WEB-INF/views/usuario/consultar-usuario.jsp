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
<style>
.status {
	font-size: 12px;
}
</style>

</head>

<body>
	<!-- Modais aqui-->
	<!-- Modal -->
	<div class="modal fade" id="usuario-modal" tabindex="-1" role="dialog"
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
							<form action="cadastrar" method="POST" id="frmUsuario">
								<input type="hidden" name="id" id="id" />
								<div class="row">
									<div class="form-group col-md-6">
										<label for="funcionario">Funcionário</label>
										<select class="form-control" name="funcionario.id" id="cmbFuncionario">
											<option value="">Selecione</option>
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
												data-required="true" name="nome" placeholder="Informe o usuário">
										</div>
									</div>
									<div class="form-group col-md-6 cold-md-offset-6">
										<label for="email">E-mail corporativo</label>
										<div class="input-group">
											<span class="input-group-addon">@</span> <input type="email"
												class="form-control" id="email" data-required="true" name="email" placeholder="Informe o e-mail">
										</div>
									</div>
									<div class="form-group open col-md-6">
										<label for="permissao">Perfil</label>
										<select class="form-control" name="perfil.id" id="cmbPerfil">
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
						<span class="fa fa-power-off"></span> Desativar
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
							<div class="panel-heading">Controle de usuários</div>
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
									<c:forEach var="usuario" items="${usuarios}">
										<tr class="text-center">
											<td>${usuario.funcionario.nome}</td>
											<td>${usuario.nome}</td>
											<td>${usuario.email}</td>
											<td>${usuario.perfil.nome}</td>
											<td>
												<c:if test="${usuario.ativo}">
													<span class="label label-success status">Ativo</span>
												</c:if>
												<c:if test="${!usuario.ativo}">
													<span class="label label-danger status">Inativo</span>
												</c:if>
											</td>
											<td>
												<div class="btn-group">
													<a class="btn btn-info btn-xs" onclick="abrirModal('editar', ${usuario.id})"><i class="fa fa-edit"></i> Editar</a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br>
						</div>
						<!-- /.col -->
						<div class="pull-right">
							<a class="btn btn-primary" onclick="abrirModal('incluir')">Criar novo usuário</a>
							<a class="btn btn-warning" href="criar-perfil">Criar perfil</a>
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

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
	
	<!-- javaScript aqui -->
	<script>
		var ativo;
		var idUsuario;
		
		function abrirModal(action, id){
			var idFuncionario;
			var idPerfil;
			
			$("#frmUsuario")[0].reset();
			
			if(id != undefined) {
				$('#myModalLabel').text('Alterar usuário');
				$('#btnRedefinirSenha').show();
	    		$('#btnMudarStatus').show();
	    		idUsuario = id;
				$.ajax({
		    		url: "carregar-usuario",
		    		type: "GET",
		    		dataType: "JSON",
		    		data: {id : id},
		    		success: function(data){
		    			console.log(data);
		    			$('#id').val(data.id);
		    			$('#usuario').val(data.nome);
		    			$('#email').val(data.email);
		    			ativo = data.ativo;
		    			$('select#cmbFuncionario').val(data.funcionario.id);
		    			$('select#cmbPerfil').val(data.perfil.id);
		    		}
		    	});
	    	} else {
	    		$('#myModalLabel').text('Incluir usuário');
	    		$('#btnRedefinirSenha').hide();
	    		$('#btnMudarStatus').hide();
	    	}
			$('#usuario-modal').modal('show');
		}
		
		$("#btnSalvar").click(function() {
			$("#frmUsuario").submit();
		});
		
		$("#btnMudarStatus").click(function() {
			$.ajax({
	    		url: "mudar-status",
	    		type: "POST",
	    		dataType: "JSON",
	    		data: {id : idUsuario},
	    		success: function(data) {
	    		},
	    		error: function(erro) {
	    			location.reload();
	    		}
	    	});
		});
		
		
	</script>
</body>
</html>