window.onload=function() {
    var $myTable = $("#myTable");
    $myTable.html("");
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
                var list = (obj.data==null)?null: obj.data.list;
               if(list != null && list.length>0){
                   var $headTr ="<tr><td>编号</td><td>班别</td><td>姓名</td><td>科目</td><td>成绩</td></tr>";
                   for (var i=0;i<list.length;i++){
                       $headTr = $headTr+"<tr><td>"+list[i].studentId+"</td><td>"+list[i].studentClass+"</td><td>"+list[i].studentName+"</td><td>"+list[i].subjectsName+"</td><td>"+list[i].studentScore+"</td></tr>";
                   }
                   $myTable.html($headTr);
               }
            }else {
                $myTable.html("暂无数据！");
            }
            var pageDiv = $("#pageDiv").html("第"+obj.data.pageNumber+"/"+obj.data.totalPages+"页");

        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            $myTable.html("学生成绩列表查询失败！");
        }
    });
}