<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>

<layout:extends name="base">
	<layout:put block="title" type="REPLACE">
		<title>Página inicial</title>
	</layout:put>

	<layout:put block="contents">
	<!-- Corpo da pagina aqui -->
	<div id="main-container">
		<div id="breadcrumb">
			<ul class="breadcrumb">
                <li class="active"><i class="fa fa-home"></i> Página inicial</li>
            </ul>
        </div><!--breadcrumb-->
        <div class="main-header clearfix">
			<div class="page-title">
				<h3 class="no-margin">Página inicial</h3>
				<span>Bem-vindo ao sistema <strong class="text-success">Prosperity</strong>!</span>
			</div><!-- /page-title -->
		</div>
		<div class="padding-md">
			<div class="row">
				<div class="col-sm-6 col-md-3">
					<div class="panel-stat3 bg-danger">
						<h2 class="m-top-none" id="userCount">362</h2>
						<h5>Registered users</h5>
						<i class="fa fa-arrow-circle-o-up fa-lg"></i><span class="m-left-xs">5% Higher than last week</span>
						<div class="stat-icon">
							<i class="fa fa-user fa-3x"></i>
						</div>
						<div class="loading-overlay">
							<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
						</div>
					</div>
				</div><!-- /.col -->
				<div class="col-sm-6 col-md-3">
					<div class="panel-stat3 bg-info">
						<h2 class="m-top-none"><span id="serverloadCount">15</span>%</h2>
						<h5>Server Load</h5>
						<i class="fa fa-arrow-circle-o-up fa-lg"></i><span class="m-left-xs">1% Higher than last week</span>
						<div class="stat-icon">
							<i class="fa fa-hdd-o fa-3x"></i>
						</div>
						<div class="loading-overlay">
							<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
						</div>
					</div>
				</div><!-- /.col -->
				<div class="col-sm-6 col-md-3">
					<div class="panel-stat3 bg-warning">
						<h2 class="m-top-none" id="orderCount">593</h2>
						<h5>New Orders</h5>
						<i class="fa fa-arrow-circle-o-up fa-lg"></i><span class="m-left-xs">3% Higher than last week</span>
						<div class="stat-icon">
							<i class="fa fa-shopping-cart fa-3x"></i>
						</div>
						<div class="loading-overlay">
							<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
						</div>
					</div>
				</div><!-- /.col -->
				<div class="col-sm-6 col-md-3">
					<div class="panel-stat3 bg-success">
						<h2 class="m-top-none" id="visitorCount">7214</h2>
						<h5>Total Visitors</h5>
						<i class="fa fa-arrow-circle-o-up fa-lg"></i><span class="m-left-xs">15% Higher than last week</span>
						<div class="stat-icon">
							<i class="fa fa-bar-chart-o fa-3x"></i>
						</div>
						<div class="loading-overlay">
							<i class="loading-icon fa fa-refresh fa-spin fa-lg"></i>
						</div>
					</div>
				</div><!-- /.col -->
			</div>
		</div>
	</div>
	</layout:put>
</layout:extends>