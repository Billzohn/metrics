function manager_create() {
	var merchandiseId = $("#manager_create_merchandiseId").val();
	var merchandiseName = $("#manager_create_merchandiseName").val();
	var brandCN = $("#manager_create_brandCN").val();
	var brandEN = $("#manager_create_brandEN").val();
	var firstCategory = $("#manager_create_firstCategory").val();
	var secondCategory = $("#manager_create_secondCategory").val();
	var thirdCategory = $("#manager_create_thirdCategory").val();
	var fourthCategory = $("#manager_create_fourthCategory").val();
	var color = $("#manager_create_color").val();
	var gender = $("#manager_create_gender").val();
	var data = {
		"merchandiseId" : merchandiseId,
		"merchandiseName" : merchandiseName,
		"brandCN" : brandCN,
		"brandEN" : brandEN,
		"firstCategory" : firstCategory,
		"secondCategory" : secondCategory,
		"thirdCategory" : thirdCategory,
		"fourthCategory" : fourthCategory,
		"color" : color,
		"gender" : gender,
	};
	$.post("../manager/create", data, function(result, status) {
		alert("创建成功！");
		$("#manager_create_merchandiseId").val('');
		$("#manager_create_merchandiseName").val('');
		$("#manager_create_brandCN").val('');
		$("#manager_create_brandEN").val('');
		$("#manager_create_firstCategory").val('');
		$("#manager_create_secondCategory").val('');
		$("#manager_create_thirdCategory").val('');
		$("#manager_create_fourthCategory").val('');
		$("#manager_create_color").val('');
		$("#manager_create_gender").val(0);
		d();
	}, "json");

}

$(function() {
	d();
});

function d(){
	$("#manager_query_merchandiseId").val('');
	$("#manager_query_merchandiseName").val('');
	$("#manager_query_brandCN").val('');
	$("#manager_query_brandEN").val('');
	$("#manager_query_gender").val(2);
	manager_init();
}

function manager_init() {
	var merchandiseId = $("#manager_query_merchandiseId").val();
	var merchandiseName = $("#manager_query_merchandiseName").val();
	var brandCN = $("#manager_query_brandCN").val();
	var brandEN = $("#manager_query_brandEN").val();
	var gender = $("#manager_query_gender").val();
	var data = {
			"merchandiseId" : merchandiseId,
			"merchandiseName" : merchandiseName,
			"brandCN" : brandCN,
			"brandEN" : brandEN,
			"gender" : gender,
	};
	var url = "../manager/querymanagersCount";
	$.post(url,data, function(result) {
		computerPage(result, "manager");
		first();
		
	},"json");

}

function manager_query(){
	var merchandiseId = $("#manager_query_merchandiseId").val();
	var merchandiseName = $("#manager_query_merchandiseName").val();
	var brandCN = $("#manager_query_brandCN").val();
	var brandEN = $("#manager_query_brandEN").val();
	var gender = $("#manager_query_gender").val();
	var page = (pager.num-1)*pager.size;
	var size = pager.size;
	var direction = pager.direction;
	var property = pager.property;
	var url = "../manager/querymanagers";
	var data = {
			"merchandiseId" : merchandiseId,
			"merchandiseName" : merchandiseName,
			"brandCN" : brandCN,
			"brandEN" : brandEN,
			"gender" : gender,
			"size" : size,
			"direction" : direction,
			"property" : property,
			"page" : page,
	};
	$.post(url,data, function(result) {
		var state;
		var gender;
		var button;
		var button_state
		var content = "";
		for (var i = 0; i < result.length; i++) {
			switch(result[i].dataState){
			case 1:state="启用";button="btn-danger";button_state="禁用";break;
			case 0:state="禁用";button="btn-success";button_state="启用";break;
			}
			switch(result[i].gender){
			case 1:gender="女";break;
			case 0:gender="男";break;
			}
			content += "<tr>" + "<td>" + result[i].id + "</td>" + "<td>" + result[i].merchandiseId + "</td>"
			+ "<td>" + result[i].merchandiseName + "</td>" + "<td>" + result[i].brandCN + "</td>" 
			+ "<td>" + result[i].brandEN + "</td>" + "<td>" + result[i].firstCategory + "</td>" 
			+ "<td>" + result[i].secondCategory + "</td>" + "<td>" + result[i].thirdCategory + "</td>" 
			+ "<td>" + result[i].fourthCategory + "</td>" + "<td>" + result[i].color + "</td>" 
			+ "<td>" + gender + "</td>" + "<td>" + state
			+ "</td>" + "<td><div style='float: right'><button class='btn btn-default btn-sm' data-toggle='modal' data-target='#manager_myModal1' onclick='h_manager("+result[i].id+
				   ")'>编辑</button>&nbsp;<button class='btn "+button+" btn-sm' onclick='d_manager("+result[i].id+","+result[i].dataState+")'>"+button_state+"</button></div</td>"+ "</tr>";
		}
		console.log(content);
		$("#manager-content").html(content);
	},"json");
}

$("#manager_update_button").click(function() {
	var id = $("#manager_update_id").val();
	var merchandiseId = $("#manager_update_merchandiseId").val();
	var merchandiseName = $("#manager_update_merchandiseName").val();
	var brandCN = $("#manager_update_brandCN").val();
	var brandEN = $("#manager_update_brandEN").val();
	var firstCategory = $("#manager_update_firstCategory").val();
	var secondCategory = $("#manager_update_secondCategory").val();
	var thirdCategory = $("#manager_update_thirdCategory").val();
	var fourthCategory = $("#manager_update_fourthCategory").val();
	var color = $("#manager_update_color").val();
	var gender = $("#manager_update_gender").val();
	var dataState = $("#manager_update_state").val();
	var data = {
		"id" : id,
		"merchandiseId" : merchandiseId,
		"merchandiseName" : merchandiseName,
		"brandCN" : brandCN,
		"brandEN" : brandEN,
		"firstCategory" : firstCategory,
		"secondCategory" : secondCategory,
		"thirdCategory" : thirdCategory,
		"fourthCategory" : fourthCategory,
		"color" : color,
		"gender" : gender,
		"dataState" : dataState,
	};
	$.ajax({
		type : "post",
		async : false,
		url : "/manager/update",
		data : data,
		success : function(){
			alert("修改成功！");
			manager_query();
		},
		error : function(errorMsg) {
			alert("请求数据失败！");
		}
	});
});

function h_manager(id){   
    $.ajax({
			type : "get",
			async : false,
			url : "/manager/findOne?id="+id,
			dataType : "json",
			success : function(result){
				var update_state;
				var update_gender;
				switch(result.dataState){
				case 1:update_state="<option value=1>启用</option><option value=0>禁用</option>";break;
				case 0:update_state="<option value=0>禁用</option><option value=1>启用</option>";break;
				}
				switch(result.gender){
				case 1:update_gender="<option value=1>女</option><option value=0>男</option>";break;
				case 0:update_gender="<option value=0>男</option><option value=1>女</option>";break;
				}
				var update = "<div class='row'><form class='form-horizontal'><div class='form-group'><label for='manager_update_id' class='col-sm-2 control-label'>ID:</label>"+
				"<div class='col-sm-9'><input type='text' class='form-control' id='manager_update_id' disabled value='"+result.id+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_merchandiseId' class='col-sm-2 control-label'>商品主键:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_merchandiseId' value='"+result.merchandiseId+"'></div></div>"+
			    "<div class='form-group'><label for='manager_update_merchandiseName' class='col-sm-2 control-label'>商品名称:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_merchandiseName' value='"+result.merchandiseName+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_brandCN' class='col-sm-2 control-label'>品牌中文名:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_brandCN' value='"+result.brandCN+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_brandEN' class='col-sm-2 control-label'>品牌英文名:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_brandEN' value='"+result.brandEN+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_firstCategory' class='col-sm-2 control-label'>一级分类:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_firstCategory' value='"+result.firstCategory+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_secondCategory' class='col-sm-2 control-label'>二级分类:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_secondCategory' value='"+result.secondCategory+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_thirdCategory' class='col-sm-2 control-label'>三级分类:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_thirdCategory' value='"+result.thirdCategory+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_fourthCategory' class='col-sm-2 control-label'>四级分类:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_fourthCategory' value='"+result.fourthCategory+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_color' class='col-sm-2 control-label'>颜色:</label><div class='col-sm-9'>"+
				"<input type='text' class='form-control' id='manager_update_color' value='"+result.color+"'></div></div>"+
				"<div class='form-group'><label for='manager_update_gender' class='col-sm-2 control-label'>性别:</label><div class='col-sm-9'>"+
				"<select class='form-control' id='manager_update_gender'>"+update_gender+"</select></div></div></form></div>";
				"<div class='form-group'><label for='manager_update_state' class='col-sm-2 control-label'>状态:</label><div class='col-sm-9'>"+
				"<select class='form-control' id='manager_update_state'>"+update_state+"</select></div></div></form></div>";
				$("#manager_update").replaceWith("<div class='modal-body' id='manager_update'>" + update + "</div>");
	       		
			},
			error : function(errorMsg) {
				alert("请求数据失败！");
			}
		});
 }; 
function d_manager(id,dataState){
	 var url;
	 switch(dataState){
	 	case 1:url="/manager/update?id="+id+"&dataState=0";break;
		case 0:url="/manager/update?id="+id+"&dataState=1";break;
	 }
    $.ajax({
			type : "get",
			async : false,
			url : url,
			success : function(){
				manager_query();
			},
			error : function(errorMsg) {
				alert("请求数据失败！");
			}
		});
 }; 
