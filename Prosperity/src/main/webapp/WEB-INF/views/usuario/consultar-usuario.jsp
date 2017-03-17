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
								<input type="hidden" name="id" id="txtId" />
								<div class="row">
									<div class="form-group col-md-6">
										<label for="funcionario">Funcionário</label> <select
											class="form-control" name="funcionario.id" id="cmbFuncionario">
										</select>
									</div>
									<div class="form-group col-md-6">
										<label for="usuario">Usuário</label>
										<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-user"></i></span>
											<input type="text" class="form-control" id="txtUsuario"
												data-required="true" name="nome">
										</div>
									</div>
									<div class="form-group col-md-6 cold-md-offset-6">
										<label for="email">E-mail corporativo</label>
										<div class="input-group">
											<span class="input-group-addon">@</span> <input type="email"
												class="form-control" id="txtEmail" data-required="true" name="email">
										</div>
									</div>
									<div class="form-group open col-md-6">
										<label for="permissao">Perfil</label> <select
											class="form-control" name="perfil.id" id="cmbPerfil">
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
					<button class="btn btn-warning">
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
													<a class="btn btn-info btn-xs" onclick="testeModal(${usuario.id})"><i class="fa fa-edit"></i> Editar</a>
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
							<a class="btn btn-primary" onclick="testeModal()">Criar novo usuário</a>
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
		var funcionario;
		var perfil;
		var ativo;
		
		function testeModal(id){
			
			if(id != undefined) {
	    		$.ajax({
		    		url: "carregar-usuario",
		    		type: "GET",
		    		dataType: "JSON",
		    		data: {id : id},
		    		success: function(data){
		    			console.log(data);
		    			$('input#txtId').val(data.id);
		    			$('input#txtUsuario').val(data.nome);
		    			$('input#txtEmail').val(data.email);
		    			funcionario = data.funcionario.id;
		    			perfil = data.perfil.id;
		    			ativo = data.ativo;
		    		}
		    	});
	    	}
	    	$.ajax({
	    		url: "carregar-combos",
	    		type: "GET",
	    		dataType: "JSON",
	    		data: {},
	    		success: function(data){
	    			$('#cmbPerfil').empty();
	    			$('#cmbFuncionario').empty();
	    			var perfis = data[0];
	    			var funcionarios = data[1];
	    			
	    			$('#cmbPerfil').append('<option value="">Selecione</option>');
	    			$('#cmbFuncionario').append('<option value="">Selecione</option>');
	    			for(var i = 0; i < perfis.length; i++) {
	    				var newOption = $('<option value=' + perfis[i].id + '>' +  perfis[i].nome + '</option>');
	    				$('#cmbPerfil').append(newOption);
	    			}
	    			for(var i = 0; i < funcionarios.length; i++) {
	    				var newOption = $('<option value=' + funcionarios[i].id + '>' +  funcionarios[i].nome + '</option>');
	    				$('#cmbFuncionario').append(newOption);
	    			}
	    			if(funcionario != undefined) {
	    				$('select#cmbFuncionario').val(funcionario);
		    			$('select#cmbPerfil').val(perfil);
	    			}
	    			
	    			$('#usuario-modal').modal('show');
	    		}
	    	});
		}
		
		$("#btnSalvar").click(function() {
			$("#frmUsuario").submit();
		});
		
		$("#btnMudarStatus").click(function() {
			$.ajax({
	    		url: "mudar-status",
	    		type: "POST",
	    		dataType: "JSON",
	    		data: {ativo : ativo}
	    	});
			location.reload();
		});
		
		
	</script>
</body>
</html>