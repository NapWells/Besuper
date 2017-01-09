/**
 * Created by anybody on 2016/12/13.
 */
// $(document).ready(function () {
//     $("#submitButton").click(function () {
//         $.ajax({
//             type: "POST",
//             async: false,
//             url: "updateManager.action",
//             data: $("#employee-form").serialize(),
//             success: function () {
//                 alert("修改成功！");
//             },
//             error: function () {
//                 alert("系统异常,请稍后再试");
//             }
//         })
//     });
// });

$(document).ready(function () {
    $("#submitButton").click(function () {
        $("#employee-form").attr("action","updateStaff.action");
        $("#employee-form").submit();
    });
});
