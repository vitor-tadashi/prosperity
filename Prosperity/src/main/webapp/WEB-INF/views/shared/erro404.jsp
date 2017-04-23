<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Erro 404</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">


<!-- Link e style aqui -->
</head>

<body>


	<!-- Corpo da pagina aqui -->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="pagina-inicial">
						Início</a></li>
				<li class="active">Erro 404</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<div class="padding-md" style="margin-top:50px;">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 text-center">
						<div class="h5">Ooops, a página não foi encontrada!</div>
						<h1 class="m-top-none error-heading">404</h1>
						
						<p class="font-14">Verifique o endereço digitado.</p>
						<a class="btn btn-success m-bottom-sm" href="/pagina-inicial"><i class="fa fa-home"></i> Página inicial</a>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.padding-md -->
		</div>
	</div>


	
</body>
</html>