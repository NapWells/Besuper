function loginFunction(basepath) {
    document.getElementById('loginForm').action = basepath + "login.action";
    document.getElementById('loginForm').submit();
}

$(document).ready(function () {
    $("#login").click(function () {
        var path = $("input[name = 'path']").val();
        $.ajax({
            type: "POST",
            url: path+"login.action",
            data:{id:$("input[name = 'id']").val(),password:$("input[name = 'password']").val()},
            success: function (data) {
                if(data == "success"){
                    window.location.href = path+"back/index.jsp"
                }else {
                    alert(data);
                }
            }
        });

    });
});