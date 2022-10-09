$(function (){
    $("#renewLogTable").click(function (){
        //ajax
        $.ajax({
            url:"http://localhost:8080/getRules",
            data:"",
            type:"GET",
            success:function (data){
                //清空表格信息
                $("#logTable tr").empty();
                //将数据生成转化为json数组
                var jsonObj = JSON.parse(data);
                // 生成一个tr，然后追加到table中
                for (let i=0; i<jsonObj.length; i++){
                    let td=$("<tr><td>"+jsonObj[i].number+"</td><td>"+jsonObj[i].user+"</td><td>"+jsonObj[i].username+"</td><td>"+jsonObj[i].kind+"</td><td>"+jsonObj[i].content+"</td><td>"+jsonObj[i].time+"</td></tr>")//将获取的内容更改为节点的样式
                    $("#logTable").append(td);//将添加的内容添加到table最后
                }
            },
            dataType:"text"
        })
    })
})