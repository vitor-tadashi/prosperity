<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <link href="/resources/css/custom/criar-perfil.css" rel="stylesheet"/>
    </head>
    <body>
        <!-- Modais aqui-->
        <c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>
        <!-- Corpo da pagina aqui -->
        <div id="main-container">
            <div id="breadcrumb">
                <ul class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="/pagina-inicial/"> Home</a></li>
                    <li>Controle de usuários</li>
                    <li class="active">Criar perfil</li>
                </ul>
            </div>
            <!--breadcrumb-->
            <div class="container">
                <form action="salvar-perfil" method="post">
                    <div class="padding-md">
                        <div class="row">
                            <div class="panel panel-default">
                                <div class="panel panel-default form-group col-md-12">
                                    <div class="panel-heading">
                                        <label>Criação de perfil</label>
                                    </div>
                                    <div class="panel-body col-md-10">
                                        <label>Perfil</label>
                                        <div class="" id="nome-perfil">
                                            <input class="form-control" id="nm-perfil" name="nome" type="text" placeholder="Insira um nome para o perfil" required/>
                                        </div>
                                        <div class="hide" id="select-perfil">
                                            <select class="form-control chzn-select hide" id="selected-perfil" name="">
                                                <option value="" id="xq">Selecione</option>
                                                <c:forEach var="perfil" items="${perfis }" varStatus="i">
                                                    <option value="${perfil.id }">${perfil.nome }</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <br>
                                        <c:if test="${not empty erros}">
	                                        <div class="alert alert-danger">
												<ul>
													<c:forEach items="${erros }" var="erro">
														<li class="li-msg"><strong> ${erro }</strong></li>
													</c:forEach>
												</ul>
											</div>
										</c:if>
										<c:if test="${not empty sucesso}">
											<div id="msg-sucesso" class="alert alert-success">
												<ul>
													<li class="li-msg">${sucesso }</li>
												</ul>
											</div>
										</c:if>
                                        <div class="form-group text-center">
                                            <div>
                                                <label class="label-radio inline">
                                                <input id="novo-perfil" type="radio" name="inline-radio" checked> 
                                                <span class="custom-radio">
                                                </span>
                                                Novo perfil
                                                </label>
                                                <label class="label-radio inline">
                                                <input id="edita-perfil" type="radio" name="inline-radio">
                                                <span class="custom-radio" >
                                                </span>
                                                Editar perfil existente
                                                </label>
                                            </div>
                                            <!-- /.col -->
                                        </div>
                                        <!-- /form-group -->
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <span class="fa fa-check text-primary font14"> Selecione as funcionalidades para o perfil:</span>
                                            </div>
                                            <table class="table table-responsive" id="responsiveTable">
                                                <tbody>
                                                    <c:forEach var="funcionalidade" items="${funcionalidades}" varStatus="i">
                                                        <tr>
                                                            <td>
                                                                <label class="label-checkbox">
                                                                <input type="checkbox" class="chk-row listFun" id="${i.index }" name="listaFuncionalidades[${i.index }].id" value="${funcionalidade.id }">
                                                                <span class="custom-checkbox"></span>
                                                                </label>
                                                            </td>
                                                            <td>${funcionalidade.nome }</td>
                                                        </tr>
                                                        <input type="hidden" id="tamFun" value="i.index">
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /panel -->
                                        <hr>
                                        <div class="pull-right">
                                            <button class="btn btn-success" type="submit" data-toggle="modal">Salvar</button>
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
        </div>
        <c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
        <c:import url="/WEB-INF/views/shared/js.jsp"></c:import>
        <!-- javaScript aqui -->
        <script src="/resources/js/custom/criar-perfil.js"></script>
    </body>
</html>