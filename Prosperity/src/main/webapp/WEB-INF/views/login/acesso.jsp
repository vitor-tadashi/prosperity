<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Acesso</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

</head>
<body>

	<div class="login-wrapper">
		<div class="text-center">
			<img src="/resources/img/png_colorido_slogan.png" alt="Second slide"
				class="m-bottom-md" style="width: 400px;">
		</div>
		<div class="login-widget animation-delay1">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<div class="text-center">
						<label>Acesso</label>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-login">
						<div class="form-group bounceIn animation-delay2">
							<label>Usuário</label>
							<div class="input-group input-sm">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" placeholder="Usuário" class="form-control">
							</div>
						</div>
						<div class="form-group bounceIn animation-delay3">
							<label>Senha</label>
							<div class="input-group input-sm">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" placeholder="Senha" class="form-control">
							</div>
						</div>
						<a
							class="btn btn-success btn-sm bounceIn animation-delay4 login-link pull-right"
							href="dashboard.html"><i class="fa fa-sign-in"></i> Entrar</a>
					</form>
				</div>
			</div>
			<!-- /panel -->
		</div>
		<!-- /login-widget -->
	</div>
	<!-- /login-wrapper -->
	
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>

</body>
</html>