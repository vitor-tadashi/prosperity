<!-- Overlay Div -->
<div id="overlay" class="transparent"></div>

<div id="wrapper" class="preload">
	<div id="top-nav" class="skin-6 fixed">
		<div class="brand">
			<a href="#"><img src="/resources/img/prosperity-logo.png" class="logo"></a>
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
			<li class="dropdown"></li>
			<li class="profile dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <strong>${autenticado.funcionario.nome}</strong>
					<span><i class="fa fa-chevron-down"></i></span>
			</a>
				<ul class="dropdown-menu">
					<li><a class="clearfix" href="#"> <strong>${autenticado.funcionario.nome}</strong>
							<p class="grey">${autenticado.email}</p>
					</a></li>
					<li><a tabindex="-1" href="#" class="theme-setting"><i
							class="fa fa-cog fa-lg"></i> Configurações</a></li>
					<li class="divider"></li>
					<li><a tabindex="-1" class="main-link logoutConfirm_open"
						href="usuario"><i class="fa fa-lock fa-lg"></i> Sair</a></li>
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

					<li class="openable menu-opcao hide" value="22"><a href="#">
							<span class="menu-icon"> <i class="fa fa-desktop fa-lg"></i>
						</span> <span class="text"> Tela de acesso </span> <span
							class="menu-hover"></span>
					</a>
						<ul class="submenu">
							<li><a href="/login/"><span class="submenu-label">Acesso</span></a></li>
							<li><a href="/login/autenticar"><span
									class="submenu-label">Primeiro acesso</span></a></li>

						</ul></li>

					<li><a href="/pagina-inicial"> <span class="menu-icon">
								<i class="fa fa-home fa-lg"></i>
						</span> <span class="text"> Página inicial </span> <span
							class="menu-hover"></span>
					</a></li>
					<li class="menu-opcao hide" value="3"><a
						href="/vaga/solicitar"> <span class="menu-icon"> <i
								class="fa fa-plus fa-lg"></i>
						</span> <span class="text"> Solicitar vaga </span> <span
							class="menu-hover"></span>
					</a></li>
					<li class="menu-opcao hide" value="17"><a
						href="/candidato/cadastrar"> <span class="menu-icon"> <i
								class="fa fa-edit fa-lg"></i>
						</span> <span class="text"> Cadastrar candidato </span> <span
							class="menu-hover"></span>
					</a></li>

					<li class="openable"><a href="#"> <span class="menu-icon">
								<i class="fa fa-file-text fa-lg"></i>
						</span> <span class="text"> Consultar </span> <span class="menu-hover"></span>
					</a>
						<ul class="submenu">
							<li class="menu-opcao hide" value="20"><a
								href="/candidato/consultar-rh"><span class="submenu-label">Candidato</span></a></li>
							<li class="menu-opcao hide" value="19"><a
								href="/candidato/consultar-gestor"><span
									class="submenu-label">Candidato</span></a></li>
							<li class="menu-opcao hide" value="2"><a
								href="/vaga/consultar"><span class="submenu-label">Vaga</span></a></li>
							<li class="menu-opcao hide" value="18"><a
								href="/candidato/historico"><span class="submenu-label">Histórico</span></a></li>
						</ul></li>

					<li class="openable"><a href="#"> <span class="menu-icon">
								<i class="fa fa-check fa-lg"></i>
						</span> <span class="text"> Aprovar </span> <span class="menu-hover"></span>
					</a>
						<ul class="submenu">
							<li class="menu-opcao hide" value="20"><a
								href="/candidato/consultar-rh"><span class="submenu-label">Candidato</span></a></li>
							<li class="menu-opcao hide" value="1"><a
								href="/vaga/aprovar"><span class="submenu-label">Vaga</span></a></li>

						</ul></li>

					<li class="menu-opcao hide" value="21"><a href="/relatorio">
							<span class="menu-icon"> <i class="fa fa-print fa-lg"></i>
						</span> <span class="text"> Relatório </span> <span class="menu-hover"></span>
					</a></li>

					<li class="menu-opcao hide" value="15"><a
						href="/usuario/listar"> <span class="menu-icon"> <i
								class="fa fa-cogs fa-lg"></i>
						</span> <span class="text"> Configurações </span> <span
							class="menu-hover"></span>
					</a></li>
				</ul>
			</div>
			<!-- /main-menu -->
		</div>
		<!-- /sidebar-inner scrollable-sidebar -->
	</aside>
</div>