<!-- Overlay Div -->
<div id="overlay" class="transparent"></div>

<div id="wrapper" class="preload">
	<div id="top-nav" class="skin-6 fixed">
		<div class="brand">
			<a href="#"><img src="/resources/img/logo.png" class="logo"></a>
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
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-lg"></i>
					<span class="notification-label bounceIn animation-delay6">2</span>
			</a>
				<ul class="dropdown-menu notification dropdown-3">
					<li><a href="#">Você tem 2 novas notificações</a></li>
					<li><a href="#"> <span
							class="notification-icon bg-warning"> <i
								class="fa fa-warning"></i>
						</span> <span class="m-left-xs">Aprovação pendente.</span> <span
							class="time text-muted">Agora</span>
					</a></li>
					<li><a href="#"> <span
							class="notification-icon bg-success"> <i
								class="fa fa-plus"></i>
						</span> <span class="m-left-xs">Novo usuário registrado.</span> <span
							class="time text-muted">2m atrás</span>
					</a></li>
					<li><a href="#">Ver todas as notificações</a></li>
				</ul></li>
			<li class="profile dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <strong>João da Silva</strong>
					<span><i class="fa fa-chevron-down"></i></span>
			</a>
				<ul class="dropdown-menu">
					<li><a class="clearfix" href="#">
							<div class="detail">
								<strong>João da Silva</strong>
								<p class="grey">joaosilva@verity.com.br</p>
							</div>
					</a></li>
					<li><a tabindex="-1" href="profile.html" class="main-link"><i
							class="fa fa-edit fa-lg"></i> Editar perfil</a></li>
					<li><a tabindex="-1" href="#" class="theme-setting"><i
							class="fa fa-cog fa-lg"></i> Configurações</a></li>
					<li class="divider"></li>
					<li><a tabindex="-1" class="main-link logoutConfirm_open"
						href="usuario"><i class="fa fa-lock fa-lg"></i> Sair</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- /top-nav-->

	<aside class="fixed skin-6">
		<div class="sidebar-inner scrollable-sidebar">
			<div class="size-toggle">
				<a class="btn btn-sm" id="sizeToggle"> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="btn btn-sm pull-right logoutConfirm_open"
					href="usuario"> <i class="fa fa-power-off"></i>
				</a>
			</div>
			<!-- /size-toggle -->

			<div class="main-menu">
				<ul>

					<li class="openable"><a href="#"> <span class="menu-icon">
								<i class="fa fa-desktop fa-lg"></i>
						</span> <span class="text"> Tela de acesso </span> <span
							class="menu-hover"></span>
					</a>
						<ul class="submenu">
							<li><a href="usuario"><span class="submenu-label">Acesso</span></a></li>
							<li><a href="usuario/primeiro-acesso"><span
									class="submenu-label">Primeiro acesso</span></a></li>

						</ul></li>

					<li><a href="dashboard.html"> <span class="menu-icon">
								<i class="fa fa-home fa-lg"></i>
						</span> <span class="text"> Página inicial </span> <span
							class="menu-hover"></span>
					</a></li>
					<li><a href="solicitar-vaga.html"> <span class="menu-icon">
								<i class="fa fa-plus fa-lg"></i>
						</span> <span class="text"> Solicitar vaga </span> <span
							class="menu-hover"></span>
					</a></li>
					<li><a href="cadastrar-candidato.html"> <span
							class="menu-icon"> <i class="fa fa-edit fa-lg"></i>
						</span> <span class="text"> Cadastrar candidato </span> <span
							class="menu-hover"></span>
					</a></li>

					<li class="openable"><a href="#"> <span class="menu-icon">
								<i class="fa fa-file-text fa-lg"></i>
						</span> <span class="text"> Consultar </span> <span class="menu-hover"></span>
					</a>
						<ul class="submenu">
							<li><a href="consultar-rh.html"><span
									class="submenu-label">Candidato</span></a></li>
							<li><a href="consultar-vaga.html"><span
									class="submenu-label">Vaga</span></a></li>
							<li><a href="historico-candidato.html"><span
									class="submenu-label">Histórico</span></a></li>
						</ul></li>

					<li class="openable"><a href="#"> <span class="menu-icon">
								<i class="fa fa-check fa-lg"></i>
						</span> <span class="text"> Aprovar </span> <span class="menu-hover"></span>
					</a>
						<ul class="submenu">
							<li><a href=""><span class="submenu-label">Candidato</span></a></li>
							<li><a href="aprovacao-vaga.html"><span
									class="submenu-label">Vaga</span></a></li>

						</ul></li>

					<li><a href="gerar-relatorio.html"> <span
							class="menu-icon"> <i class="fa fa-print fa-lg"></i>
						</span> <span class="text"> Relatório </span> <span class="menu-hover"></span>
					</a></li>

					<li class="openable"><a href="#"> <span class="menu-icon">
								<i class="fa fa-cogs fa-lg"></i>
						</span> <span class="text"> Configurações </span> <span
							class="menu-hover"></span>
					</a></li>
				</ul>
			</div>
			<!-- /main-menu -->
		</div>
		<!-- /sidebar-inner scrollable-sidebar -->
	</aside>