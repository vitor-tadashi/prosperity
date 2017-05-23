<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" type="image/ico" href="/resources/img/prosperity.ico"/>
	
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
	
	<layout:block name="title">
		<title>Prosperity</title>
	</layout:block>
</head>
<body class="overflow-hidden">
	
	<c:forEach items="${autenticado.perfil.listaFuncionalidades }" var="funcionalidade">
		<input id="funcionalidade${funcionalidade.id }" class="hide" value="${funcionalidade.id }" type="hidden">
	</c:forEach>
	<!-- Overlay Div -->
	<div id="overlay" class="transparent"></div>
	
	<div id="wrapper" class="preload">
	    <div id="top-nav" class="skin-6 fixed">
			<div class="brand">
				<a href="/pagina-inicial"><img
					src="/resources/img/prosperity-logo.png" class="logo"></a>
			</div>
			<!-- /brand -->
			<button type="button" class="navbar-toggle pull-left"
				id="sidebarToggle">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<button type="button" class="navbar-toggle pull-left hide-menu"
				id="menuToggle">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<ul class="nav-notification clearfix">
				<li class="profile dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <strong>${autenticado.funcionario.nome}</strong>
						<span><i class="fa fa-chevron-down"></i></span>
				</a>
					<ul class="dropdown-menu">
						<li><a class="clearfix" href="#">
								<div class="detail">
									<strong>${autenticado.funcionario.nome}</strong>
									<p class="grey">${autenticado.email}</p>
								</div>
						</a></li>
						<li><a class="clearfix download-download" href="manual/download" target="_blank">
								<div class="detail">
									<strong>Manual</strong>
									<!-- <p class="grey">${autenticado.email}</p> -->
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" class="main-link logoutConfirm_open"
							href="usuario"> <i class="fa fa-lock fa-lg"></i> Sair
						</a></li>
					</ul></li>
			</ul>
		</div>
		<input type="hidden" id="idPerfil" value="${autenticado.perfil.id }">
		<input type="hidden" id="idPerfilComp" value="${autenticado.perfil}">
		<!-- /top-nav-->
		<aside class="fixed skin-6">
			<div class="sidebar-inner scrollable-sidebar">
				<div class="size-toggle">
					<a class="btn btn-sm" id="sizeToggle"> <span class="icon-bar"></span>
						<span class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="btn btn-sm pull-right logoutConfirm_open" href="usuario">
						<i class="fa fa-power-off"></i>
					</a>
				</div>
				<!-- /size-toggle -->
		
				<div class="main-menu" id="menu-toggle">
					<ul>
						<li><a href="/pagina-inicial"> <span class="menu-icon">
									<i class="fa fa-home fa-lg"></i>
							</span> <span class="text"> Página inicial </span> <span
								class="menu-hover"></span>
						</a></li>
						<li class="openable menu17 menu18 hide"><a href="#"> <span class="menu-icon">
									<i class="fa fa-user fa-lg"></i>
							</span> <span class="text"> Candidato </span> <span class="menu-hover"></span>
						</a>
							<ul class="submenu">
								<li class="menu-opcao hasMenu hide" value="17"><a
									href="/candidato/cadastrar"> <span class="submenu-label">Cadastrar</span>
								</a></li>
								<li class="menu-opcao hasMenu hide" value="18"><a
									href="/candidato/consultar"> <span
										class="submenu-label">Consultar</span>
								</a></li>
							</ul></li>
						<li class="openable menu3 menu2 hide"><a href="#"> <span class="menu-icon">
									<i class="fa fa-book fa-lg"></i>
							</span> <span class="text"> Vaga </span> <span class="menu-hover"></span>
						</a>
							<ul class="submenu">
								<li class="menu-opcao hasMenu hide" value="3"><a
									href="/vaga/solicitar"> <span class="submenu-label">Solicitar
											abertura</span>
								</a></li>
								<li class="menu-opcao hasMenu hide" value="2"><a
									href="/vaga/consultar"> <span
										class="submenu-label">Consultar</span>
								</a></li>
							</ul></li>
							<li class="openable menu25 menu1 hide"><a href="#"> <span class="menu-icon">
									<i class="fa fa-check fa-lg"></i>
							</span> <span class="text"> Aprovar / Reprovar</span> <span class="menu-hover"></span>
						</a>
							<ul class="submenu">
								<li class="menu-opcao hasMenu hide" value="25"><a
									href="/candidato/aprovar"> <span class="submenu-label">Candidato</span>
								</a></li>
								<li class="menu-opcao hasMenu hide" value="1"><a
									href="/vaga/aprovar"> <span
										class="submenu-label">Vaga</span>
								</a></li>
							</ul></li>
						<li class="menu-opcao hide" value="21"><a href="/relatorio">
								<span class="menu-icon"> <i class="fa fa-print fa-lg"></i>
							</span> <span class="text"> Relatório</span> <span class="menu-hover"></span>
						</a></li>
						<li class="openable menu22 menu16 hide" value=""><a href="#"> <span class="menu-icon">
									<i class="fa fa-cogs fa-lg"></i>
							</span> <span class="text"> Gerenciar</span> <span class="menu-hover"></span>
						</a>
							<ul class="submenu">
								<li class="menu-opcao hasMenu hide" value="22"><a
									href="/usuario/gerenciar"> <span class="submenu-label">Usuário</span>
								</a></li>
								<li class="menu-opcao hasMenu hide" value="16"><a
									href='<c:url value="/usuario/perfil/gerenciar" />'> <span
										class="submenu-label">Perfil</span>
								</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /main-menu -->
			</div>
			<!-- /sidebar-inner scrollable-sidebar -->
		</aside>
		<!-- conteúdo da página será carregado aqui -->
	    <layout:block name="contents">
	        
	    </layout:block>
	
		<!-- Footer ================================================== -->
		<footer>
			<div class="row">
				<div class="col-sm-6">
					<span class="footer-brand"> <strong class="text-success">Prosperity</strong>
					</span>
					<p class="no-margin">
						&copy; 2017 <strong>Verity TI</strong>. Todos os direitos
						reservados.
					</p>
				</div>
			</div>
		</footer>
	
	</div>
	<!-- /wrapper -->
	
	<!-- Logout confirmation -->
	<div class="custom-popup width-100" id="logoutConfirm">
		<div class="padding-md">
			<h4 class="m-top-none">Deseja realmente sair?</h4>
		</div>
	
		<div class="text-center">
			<a class="btn btn-success m-right-sm" href="/login/logout">Sair</a> <a
				class="btn btn-danger logoutConfirm_close">Cancelar</a>
		</div>
	</div>
	
	
	<!-- Le javascript ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	
	<!-- Jquery -->
	<script src="/resources/js/jquery-1.10.2.min.js"></script>
	<script src="/resources/js/jquery.dataTables.min.js"></script>
	
	<!-- Bootstrap -->
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/js/dataTables.bootstrap.min.js"></script>
	
	<!-- Chosen -->
	<script src='/resources/js/chosen.jquery.min.js'></script>
	
	<!-- Mask-input -->	
	<script src='/resources/js/jquery.mask.min.js'></script>
	
	<!-- Datepicker -->
	<script src='/resources/js/bootstrap-datepicker.min.js'></script>
	
	<!-- Timepicker -->
	<script src='/resources/js/bootstrap-timepicker.min.js'></script>
	
	<!-- Slider -->
	<script src='/resources/js/bootstrap-slider.min.js'></script>
	
	<!-- Tag input -->
	<script src='/resources/js/jquery.tagsinput.min.js'></script>
	
	<!-- WYSIHTML5 -->
	<script src='/resources/js/wysihtml5-0.3.0.min.js'></script>
	<script src='/resources/js/uncompressed/bootstrap-wysihtml5.js'></script>
	
	<!-- Dropzone -->
	<script src='/resources/js/dropzone.min.js'></script>
	
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
	<script src="/resources/js/app/app_form.js"></script>
	<script src="/resources/js/app/app.js"></script>
	
	<!-- menu lateral -->
	<script src="/resources/js/custom/menu.js"></script>

	
	<!-- scripts serão carregados aqui -->	
	<layout:block name="scripts"></layout:block>
	
</body>
</html>