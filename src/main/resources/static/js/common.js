$(function(){
	//表格行，鼠标放上去变色
	$(".tr:odd").css("background", "#FFFCEA");
	$(".tr:odd").each(function(){
		$(this).hover(function(){
			$(this).css("background-color", "#FFE1FF");
		}, function(){
			$(this).css("background-color", "#FFFCEA");
		});
	});
	$(".tr:even").each(function(){
		$(this).hover(function(){
			$(this).css("background-color", "#FFE1FF");
		}, function(){
			$(this).css("background-color", "#fff");
		});
	}); 

	/*ie6,7下拉框美化*/
    if ( $.browser.msie ){
    	if($.browser.version == '7.0' || $.browser.version == '6.0'){
    		$('.select').each(function(i){
			   $(this).parents('.select_border,.select_containers').width($(this).width()+5); 
			 });
    		
    	}
    }
 
});

function changePath(path, location) {
	$(".main iframe").attr("src", path);
	$("#here_area").text("当前位置：" + location);
}

let supplierIdNameMap = new Map();
let goodIdNameMap = new Map();
let repoIdNameMap = new Map();
function getAllGoodName() {
	$.ajax({
		url: "good/list",//请求的地址(必须写)
		type: "GET",//指定请求的方式（get、post）
		cache: true,  //发送相同的请求是否从缓存中读取数据
		async: false,
		success: function (data) {//data 接受后台响应数据
			for (var i = 0; i < data.length; i++) {
				let goodId = data[i].id;
				let goodName = data[i].name;
				goodIdNameMap.set(goodId, goodName);
			}
		},//如果请求成功的话，要做什么操作
		error: function () {
		},//如果请求失败的话，要做什么操作
	})
}
function getAllRepoName() {
	$.ajax({
		url: "Repository/list",//请求的地址(必须写)
		type: "GET",//指定请求的方式（get、post）
		cache: true,  //发送相同的请求是否从缓存中读取数据
		async: false,
		success: function (data) {//data 接受后台响应数据
			for (var i = 0; i < data.length; i++) {
				let id = data[i].id;
				let name = data[i].rmName;
				repoIdNameMap.set(id, name);
			}
		},//如果请求成功的话，要做什么操作
		error: function () {
		},//如果请求失败的话，要做什么操作
	})
}
function getAllSupplierName() {
	$.ajax({
		url: "supplier/list" ,//请求的地址(必须写)
		type: "GET",//指定请求的方式（get、post）
		cache: false,  //发送相同的请求是否从缓存中读取数据
		async: false,
		success: function(data){//data 接受后台响应数据
			for(var i = 0;i<data.length;i++){
				let spId = data[i].spId;
				let spName = data[i].spName;
				supplierIdNameMap.set(spId, spName);
			}
		},//如果请求成功的话，要做什么操作
		error: function(){},//如果请求失败的话，要做什么操作
	})
}