<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Consulta gestor</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="shared/stylesheet.jsp"></c:import>

<style>
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
	left: -115px !important;
}

.col-md-9 .label-radio {
	margin-right: 58px;
	margin-left: 20px;
}
</style>
</head>
<body>
	<c:import url="shared/dashboard.jsp"></c:import>
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
				<li><i class="fa fa-home"></i><a href="dashboard.html">
						Início</a></li>
				<li class="active">Solicitação de vaga</li>
			</ul>
		</div>
		<!--breadcrumb-->

		<div class="padding-md">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Consulta de candidatos - Gestor
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    
                                    
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.panel-body -->
                            
                            <table class="table table-bordered table-condensed table-hover table-striped" id="" style="font-size: 12px !important; vertical-align: middle !important;">
                                <thead>
                                    <tr>
                                        
                                        <th class="text-center">Nome </th>
                                        <th class="text-center">Cargo</th>
                                        <th class="text-center">Senioridade</th>
                                        <th class="text-center">Status</th>
                                        <th class="text-center">Ações</th>
                                        
                                    </tr>
                                </thead>
                                <tbody class="text-center">
                                    <tr>
                                        <td>Leon</td>
                                        <td>SCRUM</td>
                                        <td>Junior</td>
                                        <td><span class="label label-analiseTecnica">Análise</span>
                                        </td>
                                        <!--botão-->
                                        <td>
                                            <div class="btn-group">
                                                <button class="btn btn-info dropdown-toggle  btn-sm" data-toggle="dropdown"><i class="fa fa-cogs fa-lg"></i> <span class="caret"></span></button>
                                                <ul class="dropdown-menu slidedown">
                                                    <li><a href="historico-candidato.html"><i class="fa fa-eye fa-lg"></i> Visualizar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="#aprovado-modal" data-toggle="modal"><i class="fa fa-tasks fa-lg"></i> Gestão de candidato</a></li>
                                                    
                                                    
                                                    </td>
                                                </ul>
                                            </div>
                                    </tr>
                                    <!--botão-->
                                </tr>
                            
                            <tr>
                                <td>Daniel Valle</td>
                                <td>Estágio</td>
                                <td>Estágio</td>
                                <td><span class="label label-analiseTecnica">Análise</span>
                                    
                                <td>
                                            <div class="btn-group">
                                                <button class="btn btn-info dropdown-toggle  btn-sm" data-toggle="dropdown"><i class="fa fa-cogs fa-lg"></i> <span class="caret"></span></button>
                                                <ul class="dropdown-menu slidedown">
                                                    <li><a href="historico-candidato.html"><i class="fa fa-eye fa-lg"></i> Visualizar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="#aprovado-modal" data-toggle="modal"><i class="fa fa-tasks fa-lg"></i> Gestão de candidato</a></li>
                                                    
                                                    
                                                    </td>
                                        </ul>
                                    </div>
                                    <tr>
                                        <td>Igor</td>
                                        <td>Analista de Sistemas</td>
                                        <td>Senior</td>
                                        <td><span class="label label-analiseTecnica">Análise</span>
                                       <td>
                                            <div class="btn-group">
                                                <button class="btn btn-info dropdown-toggle  btn-sm" data-toggle="dropdown"><i class="fa fa-cogs fa-lg"></i> <span class="caret"></span></button>
                                                <ul class="dropdown-menu slidedown">
                                                    <li><a href="historico-candidato.html"><i class="fa fa-eye fa-lg"></i> Visualizar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="#aprovado-modal" data-toggle="modal"><i class="fa fa-tasks fa-lg"></i> Gestão de candidato</a></li>
                                                    
                                                    
                                                    </td>
                                                </ul>
                                            </div>
                                            
                                            <tr>
                                                <td>Guilherme </td>
                                                <td>Desenvolvedor</td>
                                                <td>Pleno</td>
                                                <td><span class="label label-analiseTecnica">Análise</span>
                                                    
                                              <td>
                                            <div class="btn-group">
                                                <button class="btn btn-info dropdown-toggle  btn-sm" data-toggle="dropdown"><i class="fa fa-cogs fa-lg"></i> <span class="caret"></span></button>
                                                <ul class="dropdown-menu slidedown">
                                                    <li><a href="historico-candidato.html"><i class="fa fa-eye fa-lg"></i> Visualizar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="#aprovado-modal" data-toggle="modal"><i class="fa fa-tasks fa-lg"></i> Gestão de candidato</a></li>
                                                    
                                                    
                                                    </td>
                                                        </ul>
                                                    </div>
                                                    
                                                    <tr>
                                                        
                                                        
                                                        
                            </tbody>
                            </table>
                        </div>
                                <!-- /.padding-md -->
							<div class="panel-footer text-right">
								<button class="btn btn-success btn-sm disabled" id="prevStep"
									disabled="">Anterior</button>
								<button type="submit" class="btn btn-sm btn-success"
									id="nextStep">Próximo</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- SOMENTE ALTERAR DAQUI PARA CIMA -->

	<c:import url="shared/footer.jsp"></c:import>
	<c:import url="shared/js.jsp"></c:import>
</body>
</html>