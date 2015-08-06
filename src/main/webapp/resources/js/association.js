$(function() {
	init();
});

function init() {
	$.get("../theme/queryValidThemes", function(result) {
		var selectItem = $("#themeId");
		for (var i = 0; i < result.length; i++) {
			var optionItem = "<option value='" + result[i].id + "'>"
					+ result[i].word + "</option>";
			$("#themeId").append(optionItem);
		}
		$('.combobox').combobox();
	});

	$.get("../association/queryAssociationsCount", function(result) {
		computerPage(result, "association");
		first();
	});
}

function associationQuery() {
	var themeId = $("#themeId").val();
	var flag = $("#associationId").val();
	
	var data = {
			"themeId":themeId,
			"flag":flag,
			"size" : pager.size,
			"page" :  ((pager.num-1)*pager.size) ,
			"direction" : 'ASC',
			"property" : 'tid'
	};
	
	$.get("../association/queryAssociations", data, function(result) {
		var content = "";
		for (var i =0 ;i<result.length; i++) {
			if (0==result[i].gender) {
				result[i].gender = "男";
			} else {
				result[i].gender = "女";
			}
			
			content += draw(result[i]);
		}
		$("#theme-content").html(content);
		
	});
}

function draw(item) {
	var selectStr = selectValue(item);
	var tr = "<tr>"
			+ "<td id='"+item.themeId+"'>" + item.word + "</td>"
			+ "<td>" + selectStr + "</td>"
			+ "<td id='"+item.documentId+"'>" + item.merchandiseName + "</td>" 
			+ "<td>" + item.merchandiseId + "</td>"
			+ "<td>" + item.brandCN + "</td>"
			+ "<td>" + item.brandEN + "</td>"
			+ "<td>" + item.fourthCategory + "</td>"
			+ "<td>" + item.thirdCategory + "</td>"
			+ "<td>" + item.secondCategory + "</td>"
			+ "<td>" + item.firstCategory + "</td>"
			+ "<td>" + item.gender + "</td>"
			+ "<td>" + item.color + "</td>"
			+ "</tr>";
	return tr;
}

function selectValue(item) {
	var selectStr =  "<select id='association' class='form-control' onchange='set("+item.value+","+item.themeId+","+item.documentId+","+"this)'>";
	for (var i = 0; i<=10; i ++) {
		if (i == 0 && null == item.value) {
			selectStr += "<option selected='selected' value=''>请选择</option>";
		}else if (i == 0 && null != item.value) {
			selectStr += "<option>请选择</option>";
		}else if (i/10 == item.value) {
			selectStr += "<option selected='selected' value='" +i / 10 + "'>" + i/10 + "</option>";
		} else {
			selectStr += "<option value='" +i / 10 + "'>" + i/10 + "</option>";
		}
	}
	return selectStr;
}


function queryCriteria() {

	var themeId = $("#themeId").val();
	var flag = $("#associationId").val();
	var data = {
			"themeId":themeId,
			"flag":flag
	};
	$.get( "../association/queryAssociationsCount", data,  function(result) {
		computerPage(result, "association");
		first();
	});
	
}

function set(value,themeId,documentId,t){
	var data = {
			"value" : t.value,
			"themeId" : themeId,
			"documentId" : documentId,
	};
	if(value==null){
		$.get( "../association/createAssociation", data,  function(result) {
		});
		}
	else{
		$.get( "../association/updateAssociation", data,  function(result) {
		});
	}
}
