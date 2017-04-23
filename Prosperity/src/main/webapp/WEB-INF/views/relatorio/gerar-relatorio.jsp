<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Gerar relatório</title>
	</layout:put>

	<layout:put block="contents">
		<div id="main-container">
			<div id="breadcrumb">
				<ul class="breadcrumb">
					<li><i class="fa fa-home"></i><a href="dashboard.html">
							Início</a></li>
					<li class="active">Gerar relatório</li>
				</ul>
			</div>
			<!--breadcrumb-->
	
			<!--corpo -->
				<div class="padding-md">
					<div class="row">
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading"><strong>Relatório</strong></div>
								<!--<form class="form-inline">-->
								<div class="panel-body">
									<form>
										<div class="row">
											<div class="form-group col-md-4">
												<label for="cmbTipoRelatorio">Tipo</label> <select
													id="cmbTipoRelatorio" class="form-control input-sm">
													<option value="">Selecionar</option>
													<option value="1">Candidatos</option>
													<option value="2">Vagas</option>
												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-4">
												<label for="dtInicio">Data</label>
												<div class="row">
													<div class="col-xs-5">
														<input type="date" class="form-control input-sm"
															id="dtInicio" />
													</div>
													<p class="small col-xs-1">até</p>
													<div class="col-xs-6">
														<input type="date" class="form-control input-sm"
															id="dtFinal" />
													</div>
												</div>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-12" id="divVagas">
												<label>Vagas desejadas</label> <select multiple
													class="form-control input-sm">
													<c:forEach var="vaga" items="${vagas}">
														<option value="${vaga.id}">${vaga.nomeVaga}</option>
													</c:forEach>
												</select>
											</div>
											<!-- /form-group -->
											<div class="form-group col-md-12" id="divSituacao">
												<label>Situação</label> <select class="form-control input-sm">
													<option>Selecione</option>
													<c:forEach var="situacao" items="${situacoes}">
														<option value="${situacao.value}">${situacao}</option>
													</c:forEach>
												</select>
											</div>
											<!-- /form-group -->
										</div>
										<div class="row">
											<div class="col-xs-12">
												<button type="submit"
													class="btn btn-success btn-sm pull-right">Gerar</button>
											</div>
										</div>
									</form>
								</div>
								<!--</panel body>-->
							</div>
							<!--</col-sm-12>-->
						</div>
						<!--</row>-->
					</div>
					<!--</padding>-->
				</div>
				<!--</container>-->
		</div>
	</layout:put>
	
	<layout:put block="scripts" type="REPLACE">
	<script>
		$("#divVagas").css('display', 'none');
		$("#divSituacao").css('display', 'none');

		$("#cmbTipoRelatorio").on('change', function() {
			var element = $("#cmbTipoRelatorio");
			if (element.val() == "1") {
				$("#divVagas").css('display', 'none');
				$("#divSituacao").css('display', 'none');
			} else if (element.val() == "2") {
				$("#divVagas").css('display', 'block');
				$("#divSituacao").css('display', 'block');
			} else {
				$("#divVagas").css('display', 'none');
				$("#divSituacao").css('display', 'none');
			}
		});
	</script>
	</layout:put>
	
</layout:extends>