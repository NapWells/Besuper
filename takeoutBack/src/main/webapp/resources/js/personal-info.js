$(document).ready(function () {
    $("#submitButton").click(function () {
        $.ajax({
            type: "POST",
            async: false,
            url: "updateManager.action",
            data: $("#managerInfoForm").serialize(),
            dataType: "json",
            success: function () {
                alert("修改成功！");
            },
            error: function () {
                alert("系统异常,请稍后再试");
            }
        })
    });
});