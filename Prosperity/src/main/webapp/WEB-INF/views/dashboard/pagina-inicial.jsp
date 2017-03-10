<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página inicial</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<c:import url="/WEB-INF/views/shared/stylesheet.jsp"></c:import>

<!-- Link e style aqui -->

</head>

<body>
	<!-- Modais aqui-->

	<c:import url="/WEB-INF/views/shared/dashboard.jsp"></c:import>

	<!-- Corpo da pagina aqui -->
	<div id="main-container">
                <div id="breadcrumb">
                    <ul class="breadcrumb">
                        <li class="active"><i class="fa fa-home"></i>Página inicial</li>
                    </ul>
                </div><!--breadcrumb-->
                <div class="container">
                    <div class="padding-md">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="main-header clearfix">
                                    <div class="page-title">
                                        <h3 class="no-margin">Página inicial</h3>
                                        <span>Bem-vindo ao sistema <strong class="text-success">Prosperity</strong>!</span>
                                    </div><!-- /page-title -->
                                </div>
                            </div>
                            <div class="panel-body">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

	<c:import url="/WEB-INF/views/shared/footer.jsp"></c:import>
	<c:import url="/WEB-INF/views/shared/js.jsp"></c:import>

	<!-- javaScript aqui -->

</body>
</html>