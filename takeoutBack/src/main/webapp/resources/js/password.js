$(document).ready(function () {
    $("#submitButton").click(function () {
        if ($("input[name='password']").val().trim() == "" || $("input[name='newPassword']").val() == "") {
            alert("密码不能为空！");
            return false;
        }
        // $.post(
        //     "checkOldPassword.action",
        //     {password: $("input[name='password']").val()},
        //     function (data,status) {
        //         alert(data+status);
        //     }
        // );
        $.ajax({
            type: "POST",
            url: "checkOldPassword.action",
            data: {password: $("input[name='password']").val()},
            success: function (date) {
                if (date == "error") {
                    alert("原始密码错误！请重试！");
                    return false;
                }
            },
            error: function () {
                alert("系统异常,请稍后再试1!");
                return false;
            }
        })


        if ($("input[name='newPassword']").val() !== $("input[name='repeatPassword']").val()) {
            alert("两次密码不一致！");
            return false;
        }

        $.ajax({
            type: "POST",
            url: "resetPassword.action",
            data: {newPassword: $("input[name='newPassword']").val()},
            success: function (data) {
                if(data=="success"){
                    alert("修改成功！");
                    return false;
                }
                else{
                    alert("修改失败！"+data);
                    return false;
                }
            },
            error: function () {
                alert("系统异常,请稍后再试2!");
                return false;
            }
        })

    });


});

