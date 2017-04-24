<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Primeiro acesso</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Font Awesome -->
<link href="/resources/css/font-awesome.min.css" rel="stylesheet">

<!-- Pace -->
<link href="/resources/css/pace.css" rel="stylesheet">

<!-- Perfect -->
<link href="/resources/css/app.css" rel="stylesheet">
<link href="/resources/css/app-skin.css" rel="stylesheet">

<link href="/resources/css/custom.css" rel="stylesheet">

<link href="/resources/css/custom/acesso.css" rel="stylesheet"/>

</head>

<body>
	<!-- Modais aqui-->

	<!-- Corpo da pagina aqui -->
	<div class="login-wrapper">
		<div class="text-center">
			<img src="/resources/img/logo-prosperity.png" alt="Second slide"
				class="m-bottom-md tamanho">
		</div>
		<div class="login-widget animation-delay1">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<div class="text-center">
						<label>Primeiro acesso</label>
					</div>
				</div>
				<div class="panel-body">
					<form class="form-login" action="primeiro-acesso" method="POST"
						id="FormSenha" name="FormSenha" onsubmit="return validarSenha()">
						<div id="textDiv"></div>

						<div class="form-group bounceIn animation-delay2">
							<label>Nova senha</label>
							<div class="input-group input-sm">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" placeholder="Senha"
									class="form-control input-sm" name="senha" id="senha">
							</div>
						</div>
						<div class="form-group bounceIn animation-delay3">
							<label>Confirmar nova senha</label>
							<div class="input-group input-sm">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" placeholder="Confirmar nova senha"
									class="form-control input-sm" id="confirmarSenha"
									name="confirmarSenha">
							</div>
						</div>
						<button class="btn btn-success btn-sm">
							<i class="fa fa-sign-in"></i> Entrar
						</button>
					</form>
				</div>
			</div>
			<!-- /panel -->
		</div>
		<!-- /login-widget -->
	</div>
	<!-- /login-wrapper -->

	<!-- Jquery -->
	<script src="/resources/js/jquery-1.10.2.min.js"></script>
	<script src="/resources/js/jquery.dataTables.min.js"></script>
	
	<!-- Bootstrap -->
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/js/dataTables.bootstrap.min.js"></script>
	
	<!-- Mask-input -->
	<script src='/resources/js/jquery.maskedinput.min.js'></script>
	
	<!-- Modernizr -->
	<script src='/resources/js/modernizr.min.js'></script>
	
	<!-- Pace -->
	<script src='/resources/js/pace.min.js'></script>
	
	<!-- Popup Overlay -->
	<script src='/resources/js/jquery.popupoverlay.min.js'></script>
	
	<!-- Slimscroll -->
	<script src='/resources/js/jquery.slimscroll.min.js'></script>
	
	<!-- Cookie -->
	<script src='/resources/js/jquery.cookie.min.js'></script>
	
	<!-- Perfect -->
	<script src="/resources/js/app/app.js"></script>
	
	<!-- menu lateral -->
	<script src="/resources/js/custom/menu.js"></script>
	
	<script src="/resources/js/custom/custom.js"></script>
	<script src="/resources/js/parsley.min.js"></script>

	<!-- javaScript aqui -->
	<script src="/resources/js/custom/primeiro-acesso.js"></script>
</body>
</html>