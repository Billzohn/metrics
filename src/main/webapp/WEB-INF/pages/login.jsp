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
<form action="/check" method="post">
用户名:<input type="text" name="name" id="name"/>
密&nbsp;码:<input type="text" name="pass" id="pass"/>
<input type="submit" value="登陆"/>
</form>
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
