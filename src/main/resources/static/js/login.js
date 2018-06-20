$(function(){

    $("#login").click(function(){
            var username = $("input[name='username']").val();
            var password = $("input[name='password']").val();
            $.ajax({
                    type: "POST",
                    url: "/login",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify({username:username, password:password}),
                    dataType: "json",
                    success: function (data) {
                        if(data.code == "0000"){
                            alert("登录成功" + "\n" + JSON.stringify(data.data.nickname));
                            window.location.href="/user.html";
                        }else{
                            alert("登录失败");
                        }
                    },
                    error: function (message) {
                        alert("网络错误");
                    }
                });
        }
    );

});