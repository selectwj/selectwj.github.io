$(function (){
    $("#renewLogTable").click(function (){
        //ajax
        $.ajax({
            url:"http://localhost:8080/ajaxServlet",
            data:"action=renew",
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
    $("#renewMessageTable").click(function (){
        //ajax
        $.ajax({
            url:"http://localhost:8080/ajaxServlet",
            data:"action=renewMessage",
            type:"GET",
            success:function (data){
                //清空表格信息
                $("#messageTable tr").empty();
                //将数据生成转化为json数组
                var jsonObj = JSON.parse(data);
                // 生成一个tr，然后追加到table中
                for (let i=0; i<jsonObj.length; i++){
                    let td=$("<tr><td>"+jsonObj[i].studentID+"</td><td>"+jsonObj[i].name+"</td><td>"+jsonObj[i].topic+"</td><td>"+jsonObj[i].teacher+"</td></tr>")//将获取的内容更改为节点的样式
                    $("#messageTable").append(td);//将添加的内容添加到table最后
                }
            },
            dataType:"text"
        })
    })
    $("#renewStudentsTable").click(function (){
        //ajax
        $.ajax({
            url:"http://localhost:8080/ajaxServlet",
            data:"action=renewStudentsTable",
            type:"GET",
            success:function (data){
                //清空表格信息
                $("#studentsTable tr").empty();
                //将数据生成转化为json数组
                var jsonObj = JSON.parse(data);
                // 生成一个tr，然后追加到table中
                for (let i=0; i<jsonObj.length; i++){
                    let td=$("<tr><td>"+jsonObj[i].username+"</td><td>"+jsonObj[i].password+"</td><td>"+jsonObj[i].name+"</td><td>"+jsonObj[i].email+"</td><td>"+jsonObj[i].phone+"</td></tr>")//将获取的内容更改为节点的样式
                    $("#studentsTable").append(td);//将添加的内容添加到table最后
                }
            },
            // success:function (data){
            //     //清空表格信息
            //     $("#studentsTable tr").empty();
            //     //将数据生成转化为json数组
            //     let jsonObj = JSON.parse(data);
            //     // 生成一个tr，然后追加到table中
            //     for (let i=0; i<jsonObj.length; i++){
            //         let td=$("<tr><td>"+jsonObj[i].studentID+"</td><td>"+jsonObj[i].name+"</td><td>"+jsonObj[i].topic+"</td><td>"+jsonObj[i].teacher+"</td></tr>")//将获取的内容更改为节点的样式
            //         $("#studentsTable").append(td);//将添加的内容添加到table最后
            //     }
            //
            //     // let html = '';
            //     // for (let i = 0; i < data.length; i++) {//循环json对象，拼接tr,td的html
            //     //             html = html + '<tr>';
            //     //             html = html + '<td>' + data[i].studentID + '</td>';
            //     //             html = html + '<td>' + data[i].name + '</td>';
            //     //             html = html + '<td>' + data[i].topic + '</td>';
            //     //             html = html + '<td>' + data[i].teacher + '</td>';
            //     //             html = html + '</tr>';
            //     //         }
            //     //         $('#studentsTable').html(html);//通过jquery⽅式获取table，并把tr,td的html输出到table中
            // },
            dataType:"text"
        })
    })
    // $("#select").click(function(){
    //     // // 获取输入框的值
    //     // var input = $(this).prev().val();
    //     // // 对table里面行tr下标大于0的数据进行遍历
    //     // $("table tr:gt(0)").each(function(){
    //     //     // 找到tr下面td下标等于1的数据
    //     //     var name = $(this).find("td:eq(1)").html();
    //     //     // 判断td下标等于1的数据里面是否包含输入框的值
    //     //     if(name.indexOf(input)==-1){
    //     //         $(this).hide();//数据隐藏
    //     //     } else {
    //     //         $(this).show();//数据显示
    //     //     }
    //     // })
    //     let rows = $("#logTable tr")
    //     let report = []
    //     for (let i=1, len = rows.length; i < len; i++) {
    //         let time = $(rows[i]).children()[0].innerText
    //         let value = $($(rows[i]).children()[1]).children()[0].value
    //         report .push({time: time, value: value})
    //     }
    // })


})