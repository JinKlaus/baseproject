$(document).ready(function () {
    $("#queryBtn").click(function () {
        jQuery.ajax({
            type: "post",
            url: "/query.do",
            timeout: 60000,
            async: false,
            data: JSON.stringify({
                io_type: "I",
                userList: [{
                    sex: "M"
                }]
            }),
            dataType: "json",
            contentType: "application/json",
            beforeSend: function () {

            },
            complete: function () {

            },
            success: function (data) {

                if (data != null && data != undefined) {
                    console.info(data.rtn_msg);
                    for (var i = 0; i < data.userList.length; i++) {
                        console.info(data.userList[i].user_name);
                    }
                } else {
                    alert("很抱歉,获取失败！");
                }
            }
        })
    });

    $("#addBtn").click(function () {
        var iary = [];
        var user1 = {
            user_id: "W7",
            user_name: "王",
            sex: "F"
           // age: 20
        }
        iary.push(user1);
        jQuery.ajax({
            type: "post",
            url: "/add.do",
            timeout: 60000,
            async: false,
            data: JSON.stringify({
                io_type: "I",
                userList: iary
            }),
            dataType: "json",
            contentType: "application/json",
            beforeSend: function () {

            },
            complete: function () {

            },
            success: function (data) {

                if (data != null && data != undefined) {
                    alert(data.rtn_msg);
                } else {
                    alert("很抱歉,获取失败！");
                }
            }
        })
    });
});