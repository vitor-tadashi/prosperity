<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cria perfil</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->
<style>
.page-header h1 {
	font-size: 3.26em;
	text-align: center;
	color: #efefef;
	text-shadow: 1px 1px 0 #000;
}

/** timeline box structure **/
.timeline {
	list-style: none;
	padding: 20px 0 20px;
	position: relative;
}

.timeline:before {
	top: 0;
	bottom: 0;
	position: absolute;
	content: " ";
	width: 3px;
	background-color: #eee;
	left: 50%;
	margin-left: -1.5px;
}

.tldate {
	display: block;
	width: 200px;
	background: #414141;
	border: 3px solid #212121;
	color: #ededed;
	margin: 0 auto;
	padding: 3px 0;
	font-weight: bold;
	text-align: center;
	-webkit-box-shadow: 0 0 11px rgba(0, 0, 0, 0.35);
}

.timeline li {
	margin-bottom: 25px;
	position: relative;
}

.timeline li:before, .timeline li:after {
	content: " ";
	display: table;
}

.timeline li:after {
	clear: both;
}

.timeline li:before, .timeline li:after {
	content: " ";
	display: table;
}

/** timeline panels **/
.timeline li .timeline-panel {
	width: 46%;
	float: left;
	background: #fff;
	border: 1px solid #d4d4d4;
	padding: 20px;
	position: relative;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	-webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.15);
	box-shadow: 0 1px 6px rgba(0, 0, 0, 0.15);
}

/** panel arrows **/
.timeline li .timeline-panel:before {
	position: absolute;
	top: 26px;
	right: -15px;
	display: inline-block;
	border-top: 15px solid transparent;
	border-left: 15px solid #ccc;
	border-right: 0 solid #ccc;
	border-bottom: 15px solid transparent;
	content: " ";
}

.timeline li .timeline-panel:after {
	position: absolute;
	top: 27px;
	right: -14px;
	display: inline-block;
	border-top: 14px solid transparent;
	border-left: 14px solid #fff;
	border-right: 0 solid #fff;
	border-bottom: 14px solid transparent;
	content: " ";
}

.timeline li .timeline-panel.noarrow:before, .timeline li .timeline-panel.noarrow:after
	{
	top: 0;
	right: 0;
	display: none;
	border: 0;
}

.timeline li.timeline-inverted .timeline-panel {
	float: right;
}

.timeline li.timeline-inverted .timeline-panel:before {
	border-left-width: 0;
	border-right-width: 15px;
	left: -15px;
	right: auto;
}

.timeline li.timeline-inverted .timeline-panel:after {
	border-left-width: 0;
	border-right-width: 14px;
	left: -14px;
	right: auto;
}

/** timeline circle icons **/
.timeline li .tl-circ {
	position: absolute;
	top: 23px;
	left: 50%;
	text-align: center;
	background: #6a8db3;
	color: #fff;
	width: 35px;
	height: 35px;
	line-height: 35px;
	margin-left: -16px;
	border: 3px solid #90acc7;
	border-top-right-radius: 50%;
	border-top-left-radius: 50%;
	border-bottom-right-radius: 50%;
	border-bottom-left-radius: 50%;
	z-index: 99999;
}

/** timeline content **/
.tl-heading h4 {
	margin: 0;
	color: #c25b4e;
}

.tl-body p, .tl-body ul {
	margin-bottom: 0;
}

.tl-body>p+p {
	margin-top: 5px;
}

/** media queries **/
@media ( max-width : 991px) {
	.timeline li .timeline-panel {
		width: 44%;
	}
}

@media ( max-width : 700px) {
	.page-header h1 {
		font-size: 1.8em;
	}
	ul.timeline:before {
		left: 40px;
	}
	.tldate {
		width: 140px;
	}
	ul.timeline li .timeline-panel {
		width: calc(100% - 90px);
		width: -moz-calc(100% - 90px);
		width: -webkit-calc(100% - 90px);
	}
	ul.timeline li .tl-circ {
		top: 22px;
		left: 22px;
		margin-left: 0;
	}
	ul.timeline>li>.tldate {
		margin: 0;
	}
	ul.timeline>li>.timeline-panel {
		float: right;
	}
	ul.timeline>li>.timeline-panel:before {
		border-left-width: 0;
		border-right-width: 15px;
		left: -15px;
		right: auto;
	}
	ul.timeline>li>.timeline-panel:after {
		border-left-width: 0;
		border-right-width: 14px;
		left: -14px;
		right: auto;
	}
}

.timeline-title {
	font-size: 16px;
}

.label-stand, .badge-stand {
	background-color: #9b59b6;
	color: #fff;
}

.label-aprovadoPendente, .badge-stand {
	background-color: #2980b9;
	color: #fff;
}

.label-analiseRH, .badge-stand {
	background-color: #e67e22;
	color: #fff;
}

.label-analiseTecnica, .badge-stand {
	background-color: #f1c40f;
	color: #fff;
}

.label-reprovado, .badge-stand {
	background-color: #e74c3c;
	color: #fff;
}

.label-contratado, .badge-stand {
	background-color: #2ecc71;
	color: #fff;
}

.dropdown-menu {
	/*left: -115px !important;*/
	z-index: 1050;
}

.col-md-9 .label-radio {
	margin-right: 58px;
	margin-left: 20px;
}
</style>

</head>

<body>
	<!-- Modais aqui-->
	<!-- Modal de erro -->
	<div class="modal fade" id="erro" data-target="#erro" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Erro</h4>
				</div>
				<div class="modal-body">
					<div class="padding-md">
						<div class="row">
							<form>
								<div class="row">
									<label>hashaushuahduashduahd</label>
								</div>
							</form>
						</div>
						<!--close row-->
					</div>
					<!--close padding-->
				</div>
				<div class="modal-footer">
					<button class="btn btn-success">Ok</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal -->

	<!-- Modal salvo com sucesso -->
	<div class="modal fade" id="salvo" data-target="#salvo" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="alert alert-success text-center">
			<strong>Salvo com sucesso!</strong>
		</div>
	</div>
	<!-- Modal -->

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!-- Corpo da pagina aqui -->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="index.html"> Home</a></li>
				<li class="active">Criar perfil</li>
			</ul>
		</div>
		<!--breadcrumb-->
		<div class="container">
			<form action="salvar-perfil" method="get">
			<div class="padding-md">
				<div class="row">
					<div class="form-group col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<label>Criação de perfil</label>
							</div>
							<div class="panel-body col-md-5">
								<label>Perfil</label> <input type="text" class="form-control"
									id="usuario" data-required="true" name="nome">
							</div>
							<div class="row"></div>
							<div class="panel-body relative">
								<select multiple="multiple" id="selectedBox1"
									class="select-box pull-left form-control">
									<c:forEach var="funcionalidade" items="${funcionalidades}"
										varStatus="i">
										<option value="i">${funcionalidade.nome }</option>
									</c:forEach>
								</select>

								<div class="select-box-option">
									<a class="btn btn-sm btn-default" id="btnRemove"><i
										class="fa fa-angle-left"></i></a> <a
										class="btn btn-sm btn-default" id="btnSelect"><i
										class="fa fa-angle-right"></i></a>
									<div class="seperator"></div>
									<a class="btn btn-sm btn-default" id="btnRemoveAll"><i
										class="fa fa-angle-double-left"></i></a> <a
										class="btn btn-sm btn-default" id="btnSelectAll"><i
										class="fa fa-angle-double-right"></i></a>
								</div>

								<select multiple="multiple" id="selectedBox2"
									class="select-box pull-right form-control"
									>
									<option value="Alterar candidato">Alterar candidato</option>
									<option>Cadastrar usuário</option>
									<option>Excluir usuário</option>
									<option>Consultar usuário</option>
								</select>
								<input type="text" class="form-control"
									id="usuario" data-required="true" >
							</div>
						</div>
						<!-- /panel -->
					</div>
					<!-- /form-group -->
				</div>
				<div class="btn-group pull-right">
					<button class="btn btn-success" type="submit" data-toggle="modal">Salvar</button>
				</div>
			</div>
			</form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>

	<!-- javaScript aqui -->

</body>
</html>