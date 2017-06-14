window.onload=function() {
    $.ajax({
        type : "get",  //提交方式
        url : "StudentExamInfoManage.do",//路径
        data : {
            "doSomething" : "queryList",
            "pageSize":20,
            "pageNumber":1
        },//数据，这里使用的是Json格式进行传输
        success: function (data) {
            var obj = JSON.parse(data);
            if(obj.status==0){//查询成功
                alert("success");
            }else {
                alert(obj.status);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("error");
        }
    });
}