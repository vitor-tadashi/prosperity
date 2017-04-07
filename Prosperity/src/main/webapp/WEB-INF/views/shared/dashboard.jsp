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
					<li class="divider"></li>
					<li><a tabindex="-1" class="main-link logoutConfirm_open"
						href="usuario"> <i class="fa fa-lock fa-lg"></i> Sair
					</a></li>
				</ul></li>
		</ul>
	</div>
	<input type="hidden" id="idPerfil" value="${autenticado.perfil.id }">
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
						</span> <span class="text"> Aprovar / Reprovar </span> <span class="menu-hover"></span>
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
						</span> <span class="text"> Relatório </span> <span class="menu-hover"></span>
					</a></li>
					<li class="openable menu22 menu16 hide" value=""><a href="#"> <span class="menu-icon">
								<i class="fa fa-cogs fa-lg"></i>
						</span> <span class="text"> Gerenciar </span> <span class="menu-hover"></span>
					</a>
						<ul class="submenu">
							<li class="menu-opcao hasMenu hide" value="22"><a
								href="/usuario/gerenciar"> <span class="submenu-label">Usuário</span>
							</a></li>
							<li class="menu-opcao hasMenu hide" value="16"><a
								href="/usuario/perfil/gerenciar"> <span
									class="submenu-label">Perfil</span>
							</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /main-menu -->
		</div>
		<!-- /sidebar-inner scrollable-sidebar -->
	</aside>
</div>