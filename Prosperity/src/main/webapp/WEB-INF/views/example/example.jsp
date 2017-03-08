<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="UTF-8">
<title>Cadastro de Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

</head>
<body>
	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href=""> Início</a></li>
				<li class="active">Cadastrar example</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->

		<div class="padding-md">
			<div class="row">
				<div class="panel panel-default">
					<div class="panel-heading">Informações do candidato</div>
					<div class="panel-body">
						<form class="form-border" action="cadastrar" method="post">
							<div class="panel-tab clearfix">
								<ul class="tab-bar wizard-demo" id="wizardDemo">
									<li class="active tab-verity"><a href="#first"
										data-toggle="tab"><i class="fa fa-user"></i> Inf. pessoais</a></li>
								</ul>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div class="tab-pane fade in active" id="first">
										<div class="row">
											<div class="form-group col-md-4">
												<label class="control-label" for="nome">Nome</label> <input
													type="text" class="form-control" id="nome" name="nome"
													data-required="true" placeholder="Informe seu nome"
													value="Vitor Tadashi">
											</div>

											<div class="form-group col-md-3">
												<label for="cpf" class="control-label">CPF</label> <input
													type="text" class="form-control" id="cpf" name="cpf"
													data-required="true" placeholder="Informe seu CPF"
													value="382.105.058-66">
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-footer text-right">
								<button class="btn btn-success btn-sm">Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
</body>
</html>