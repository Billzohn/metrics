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

<title>搜索评测系统-文档管理</title>
<link href="resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/dashboard/dashboard.css" rel="stylesheet">
<link href="resources/css/core.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="./dashboard/ie-emulation-modes-warning.js"></script>

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
					<li><a href="index">主题词管理</a></li>
					<li class="active"><a href="#" onclick="d()">文档管理</a></li>
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
				<h2 class="page-header">文档管理</h2>

				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li class="active">文档管理</li>
				</ol>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">操作区</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-xs-11">
								<span>商品主键：</span> <input id="document_query_merchandiseId"
									type="text" /> <span>商品名称：</span> <input
									id="document_query_merchandiseName" type="text" /> <span>品牌中文名：</span>
								<input id="document_query_brandCN" type="text" /> <span>品牌英文名：</span>
								<input id="document_query_brandEN" type="text" /> <span>性别：</span><select
									id='document_query_gender'>
									<option value=2>不限</option>
									<option value=0>男</option>
									<option value=1>女</option>
								</select> <input type="button" class="btn btn-primary"
									id="document_query_button" value="查询" onclick="document_init()" />
							</div>
							<div class="col-xs-1">
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#create-document">添加</button>
							</div>
						</div>
					</div>
				</div>

				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>主键</th>
								<th>商品主键</th>
								<th>商品名称</th>
								<th>品牌中文名</th>
								<th>品牌英文名</th>
								<th>一级分类</th>
								<th>二级分类</th>
								<th>三级级分类</th>
								<th>四级分类</th>
								<th>颜色</th>
								<th>性别</th>
								<th>状态</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="document-content">
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
							<li id="document_page-info">共 1/14 页</li>
						</ul>
					</nav>
				</div>
				<!-- 分页结束 -->


				<!-- 创建开始-->
				<div class="modal fade" id="create-document" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">创建文档</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" method="post"
										action="../document/create">
										<div class="form-group">
											<label for="merchandiseId" class="col-sm-2 control-label">商品主键:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_merchandiseId" name="merchandiseId">
											</div>
										</div>
										<div class="form-group">
											<label for="merchandiseName" class="col-sm-2 control-label">商品名称:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_merchandiseName" name="merchandiseName">
											</div>
										</div>
										<div class="form-group">
											<label for="brandCN" class="col-sm-2 control-label">品牌中文名:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_brandCN" name="brandCN">
											</div>
										</div>
										<div class="form-group">
											<label for="brandEN" class="col-sm-2 control-label">品牌英文名:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_brandEN" name="brandEN">
											</div>
										</div>
										<div class="form-group">
											<label for="firstCategory" class="col-sm-2 control-label">一级分类:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_firstCategory" name="firstCategory">
											</div>
										</div>
										<div class="form-group">
											<label for="secondCategory" class="col-sm-2 control-label">二级分类:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_secondCategory" name="secondCategory">
											</div>
										</div>
										<div class="form-group">
											<label for="thirdCategory" class="col-sm-2 control-label">三级分类:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_thirdCategory" name="thirdCategory">
											</div>
										</div>
										<div class="form-group">
											<label for="fourthCategory" class="col-sm-2 control-label">四级分类:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_fourthCategory" name="fourthCategory">
											</div>
										</div>
										<div class="form-group">
											<label for="color" class="col-sm-2 control-label">颜色:</label>
											<div class="col-sm-9">
												<input type="text" class="form-control"
													id="document_create_color" name="color">
											</div>
										</div>
										<div class='form-group'>
											<label for='document_create_gender'
												class='col-sm-2 control-label'>性別:</label>
											<div class='col-sm-9'>
												<select class='form-control' id='document_create_gender'>
													<option value=0>男</option>
													<option value=1>女</option>
												</select>
											</div>
										</div>
									</form>
								</div>

							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="submit" class="btn btn-primary"
									onclick="document_create()" data-dismiss="modal">创建</button>
							</div>
						</div>
					</div>
					<!-- 创建结束 -->
				</div>
				<!-- 编辑开始 -->
				<div class="modal fade" id="document_myModal1" tabindex="-1"
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
							<div class="modal-body" id="document_update"></div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" id="document_update_button">更新</button>
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
	<script src="resources/js/document.js"></script>
</body>
</html>
