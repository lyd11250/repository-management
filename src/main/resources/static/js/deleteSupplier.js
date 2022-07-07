//删除
function deleteSupplierInfo(spId) {
    console.log(spId)
    $.ajax({
        url:"supplier/delete",
        data:"spId="+spId,
        type:"POST",
        success:function (data){
            if (data) {
                //提示
                alert("删除成功!");
                getAllSupplier();
            }
            else{
                alert("删除失败");
            }
        }
    })
}