<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
      
      <title>Cria perfil</title>

      <!-- Link e style aqui -->
      <link href="/resources/css/custom/criar-perfil.css" rel="stylesheet"/>
      </layout:put>

	<layout:put block="contents">
		<!-- Corpo da pagina aqui -->
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="/pagina-inicial">
							Início</a></li>
					<li><a href="#">Gerenciar</a></li>
					<li class="active">Perfil</li>
				</ul>
			</div>
			<!--breadcrumb-->
			<form action="salvar-perfil" method="post">
				<div class="padding-md">
					<div class="row">
						<div class="panel panel-default">
							<div class="panel panel-default form-group col-md-12">
								<div class="panel-heading">
									<label>Gerenciar perfil</label>
								</div>
								<div class="panel-body col-md-12">
									<label>Perfil</label>
									<div class="form-group">
										<div class="col-md-4 padding-esq-0">
											<div class="" id="nome-perfil">
												<input class="form-control" id="nm-perfil" name="nome"
													type="text" placeholder="Insira um nome para o perfil"
													required />
											</div>
											<div class="hide" id="select-perfil">
												<select class="form-control" id="selected-perfil" name="">
													<option value="">Selecione</option>
													<c:forEach var="perfil" items="${perfis }" varStatus="i">
														<option value="${perfil.id }">${perfil.nome }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group text-center col-md-4">
											<div class="margin-topo-5">
												<label class="label-radio inline"> <input
													id="novo-perfil" type="radio" name="inline-radio" checked>
													<span class="custom-radio"> </span> Novo perfil
												</label> <label class="label-radio inline"> <input
													id="edita-perfil" type="radio" name="inline-radio">
													<span class="custom-radio"> </span> Editar perfil
													existente
												</label>
											</div>
											<!-- /.col -->
										</div>
										<br>
										<br>
										<c:if test="${not empty erros}">
											<div class="alert alert-danger msg-margin">
												<ul>
													<c:forEach items="${erros }" var="erro">
														<li class="li-msg"><strong> ${erro }</strong></li>
													</c:forEach>
												</ul>
											</div>
										</c:if>
										<c:if test="${not empty sucesso}">
											<div id="msg-sucesso" class="alert alert-success msg-margin">
												<ul>
													<li class="li-msg">${sucesso }</li>
												</ul>
											</div>
										</c:if>
									</div>
									<!-- /form-group -->
									<div class="panel panel-default">
										<div class="panel-heading">
											<span class="fa fa-check text-primary"></span> <span>
												Selecione as funcionalidades:</span>
										</div>
										<div class="row padding-topo-5">
											<c:forEach var="funcionalidade" items="${funcionalidades}"
												varStatus="i">
												<div class="col-md-4">
													<div class="form-group form-inline">
														<div class="checkbox">
															<label class="label-checkbox"> <input
																type="checkbox" class="chk-row listFun" id="${i.index }"
																name="listaFuncionalidades[${i.index }].id"
																value="${funcionalidade.id }"> <span
																class="custom-checkbox"></span> <input type="text"
																class="form-control input-sm" id="txt-larg"
																value="${funcionalidade.nome }" readonly>
															</label>
														</div>
													</div>
												</div>
												<input type="hidden" id="tamFun" value="i.index">
											</c:forEach>
										</div>
									</div>
									<!-- /panel -->
									<hr>
									<div class="pull-right">
										<button class="btn btn-primary" type="submit"
											data-toggle="modal">Salvar</button>
									</div>
								</div>
								<div class="row"></div>
							</div>
							<!-- /form-group -->
						</div>
						<!-- /panel -->
					</div>
				</div>
			</form>
		</div>
	</layout:put>
      <layout:put block="scripts" type="REPLACE">
	      <!-- javaScript aqui -->
	      <script src="/resources/js/custom/criar-perfil.js"></script>
      </layout:put>
</layout:extends>