function queryInfo() {
    var studentId = $("#studentId").val();
    if(studentId==null){
        alert("请输入学生编号！");
    }
    $.ajax({
        type : "get",  //提交方式
        url : "/daoStudy/StudentExamInfoManage.do",//路径
        data : {
            "doSomething" : "queryInfo",
            "studentId":studentId,
        },//数据，这里使用的是Json格式进行传输
        success: function (data) {
            var obj = JSON.parse(data);
            if(obj.status==0){//查询成功
                var dataValue = obj.data;
                $("#student_id").val(dataValue.studentId);
                $("#studentName").val(dataValue.studentName);
                $("#studentClass").val(dataValue.studentClass);
                $("#studentScore").val(dataValue.studentScore);
                $("#subjectsName").val(dataValue.subjectsName);
            }else {
                alert(obj.status+":"+obj.message);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("学生成绩列表查询失败！");
        }
    });
}