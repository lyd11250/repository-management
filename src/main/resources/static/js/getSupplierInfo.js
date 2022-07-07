function getAllSupplier(){
    $.ajax({
        //dataType:  "json",//服务器返回的数据类型
        //data:"",  //发生给服务器的数据，如果请求是查询所有数据，一般不需要传值
        url: "supplier/list" ,//请求的地址(必须写)
        type: "GET",//指定请求的方式（get、post）
        cache:false,  //发送相同的请求是否从缓存中读取数据
        success:function (data){//data 接受后台响应数据
            var tableHtml = "<table class='list_table'>";
            tableHtml = tableHtml+"<thead><tr><th>公司名称</th><th>联系人</th><th>公司地址</th>";
            tableHtml = tableHtml+"<th>联系电话</th><th>供应商品</th><th>操作</th></thead>";
            tableHtml = tableHtml +"<tbody>"
            for(var i = 0;i<data.length;i++){
                tableHtml = tableHtml + "<tr><td>"+data[i].spName+"</td>";
                tableHtml = tableHtml + "<td>"+data[i].spCon+"</td>";
                tableHtml = tableHtml + "<td>"+data[i].spAdd+"</td>";
                tableHtml = tableHtml + "<td>"+data[i].spPhone+"</td>";
                tableHtml = tableHtml + "<td>"+data[i].spGoods+"</td>";
                tableHtml = tableHtml +"<td><button className='btn btn82 btn_add' onclick=parent.changePath('/editSupplierInfo.html','修改信息')>修改</button>";
                tableHtml = tableHtml +"<button className='btn btn82 btn_add' onclick='deleteSupplierInfo("+data[i].spId+")' >删除</button></td></tr>";
                // tableHtml = tableHtml+ "<td><a href='javascript:void(0)' class='label xiugai'>修改</a>";
                /*JSON是一个js提供json字符串工具
                * JSON字符串：通常用于作为前后端数据传输的方式。格式：{"参数名":参数值}
                * JSON.parse()--把json字符串解析成对象
                * */
                // tableHtml = tableHtml+ "<td><a href='javascript:void(0)' class='label xiugai' onclick='editUser("+JSON.stringify(data[i])+")'>修改</a>"
                // /*绑定事件1.获取到标签之后绑定 2.在标签中通过属性方式来绑定（事件名=‘绑定的函数名’）*/
                // tableHtml = tableHtml+ "<a href='javascript:void(0)' class='label shanchu' onclick='deleteUser("+data[i].id+")'>删除</a></td></tr>"
            }
            tableHtml = tableHtml +"</tbody></table>";
            $(".table-responsive").empty();//清除掉原有的数据
            $(".table-responsive").append(tableHtml);
        },
        error:function (){},//如果请求失败的话，要做什么操作
    })
}