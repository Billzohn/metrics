<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<!-- saved from url=(0041)http://v3.bootcss.com/examples/dashboard/ -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="resources/images/favicon.ico">

<title>搜索评测系统-主题管理</title>
<link href="resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/dashboard/dashboard.css" rel="stylesheet">
<link href="resources/css/core.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="resources/dashboard/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="./dashboard/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">搜索评测系统</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">帮助</a></li>
					<li><a href="/loginout">修改</a></li>
					<li><a href="/loginout">退出</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<h4>
					<span style="margin-left: -15px;"
						class="glyphicon glyphicon-triangle-bottom"></span>&nbsp;评测数据集
				</h4>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#" onclick="theme()">主题词管理</a></li>
					<li><a href="document">文档管理</a></li>
					<li><a href="association">相关度管理</a></li>
					<li><a href="manager">用户管理</a></li>
				</ul>
				<h4>
					<span style="margin-left: -15px;"
						class="glyphicon glyphicon-triangle-bottom"></span>&nbsp;评测内容
				</h4>
				<ul class="nav nav-sidebar">
					<li><a href="">准确度评测</a></li>
					<li><a href="">搜全率评测</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="page-header">主题词管理</h2>

				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li class="active">主题词管理</li>
				</ol>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">操作区</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-11">
								<span>主题词：</span> <input id="theme_query_word" type="text"
									name="word" /> <input type="button" class="btn btn-primary"
									id="theme_query_button" value="查询" onclick="theme_init()" />
							</div>
							<div class="col-xs-1">
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#create-theme">添加</button>
							</div>
						</div>
					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>主键</th>
								<th>主题</th>
								<th>拼音</th>
								<th>搜索频率</th>
								<th>数据状态</th>
								<th>更新时间</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="theme-content">
						</tbody>
					</table>
				</div>
				<!-- 分页开始 -->
				<div id="cell-pager" class="row">
					<nav>
						<ul class="pager">
							<li><a href="#" onclick="first()">首页</a></li>
							<li><a href="#" onclick="previous()">上一页</a></li>
							<li><a href="#" onclick="next()">下一页</a></li>
							<li><a href="#" onclick="end()">末页</a></li>
							<li id="theme_page-info">共 1/14 页</li>
						</ul>
					</nav>
				</div>
				<!-- 分页结束 -->


				<!-- 创建开始-->
				<div class="modal fade" id="create-theme" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">创建主题词</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" method="post"
										action="../theme/create">
										<div class="form-group">
											<label for="word" class="col-sm-2 control-label">元词:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="theme_create_word" name="word">
											</div>
										</div>
										<div class="form-group">
											<label for="pinyin" class="col-sm-2 control-label">拼音:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="theme_create_pinyin" name="pinyin">
											</div>
										</div>
										<div class="form-group">
											<label for="frequency" class="col-sm-2 control-label">搜索频率:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="theme_create_searchFrequency" name="searchFrequency"
													value="0">
											</div>
										</div>

									</form>
								</div>

							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="submit" class="btn btn-primary"
									onclick="theme_create()" data-dismiss="modal">创建</button>
							</div>
						</div>
					</div>
					<!-- 创建结束 -->

				</div>
				<!-- 编辑开始 -->
				<div class="modal fade" id="theme_myModal1" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">编辑</h4>
							</div>
							<div class="modal-body" id="theme_update"></div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" id="theme_update_button">更新</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 编辑结束 -->
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="resources/js/jquery-2.1.3.min.js"></script>
	<script src="resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	<script src="resources/dashboard/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="resources/dashboard/ie10-viewport-bug-workaround.js"></script>
	<script src="resources/js/pager.js"></script>
	<script src="resources/js/theme.js"></script>
</body>
</html>
