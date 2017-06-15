function delInfo() {
    var studentId = $("#studentId").val();
    if(studentId==null || studentId.length==0){
        alert("请输入编号");
    }
    $.ajax({
        type : "get",  //提交方式
        url : "/daoStudy/StudentExamInfoManage.do",//路径
        data : {
            "doSomething" : "del",
            "studentId":studentId
        },//数据，这里使用的是Json格式进行传输
        success: function (data) {
            var obj = JSON.parse(data);
            if(obj.status==0){//查询成功
                $("#studentId").val("");
                alert("删除成功！");
            }else {
                alert(obj.status+":"+obj.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("删除失败！");
        }
    });
}