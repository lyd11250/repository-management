//删除
function deleteRepo(id) {
    console.log(id)
    $.ajax({
        url:"Repository/delete",
        data:"id="+id,
        type:"POST",
        success:function (data){
            if (data) {
                //提示
                alert("删除成功!");
                getAllInfo();
            }
            else{
                alert("删除失败");
            }
        }
    })
}