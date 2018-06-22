$(function(){
    $.ajax({
        type: "GET",
        url: "/user",
        contentType: "application/json; charset=utf-8",
        data: null,
        dataType: "json",
        success: function (data) {
            if(data.code == "0000"){
                alert("获取成功" + "\n" + JSON.stringify(data.data));
                var user = data.data;
                $("input[name='username']").val(user.username);
                $("input[name='password']").val(user.password);
                $("select[name='gender']").val(user.gender);
                $("input[name='nickname']").val(user.nickname);
                $("input[name='avatar']").val(user.avatar);
                $("input[name='birthDate']").val(user.birthDate);
                $("input[name='phoneNumber']").val(user.phoneNumber);
                $("input[name='address']").val(user.address);
            }else{
                alert("没有登录");
                window.location.href="/login.html";
            }
        },
        error: function (message) {
            alert("网络错误");
        }
    });

    $("#")
});