<!DOCTYPE html>
<html lang="en"><html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        function jump() {
            window.location.herf="choose.html";
        }
        function jump1(){
            window.location.herf="logon.html";
        }
        $(function () {
            $("#submit").on('click', function () {
                $.ajax({
                    url: "/login",
                    type: 'POST',
                    data: {'username': $("#username").val(), 'password': $("#password").val()},
                    success: function (data) {
                        jump();
                        alert(data);
                    }
                });
            })
        });

    </script>
</head>
<body>
<h2>登录</h2>
用户名<input id="username" type="text"/>
密码<input id="password" type="password"/>
<input id="submit" type="submit" value="提交"/>
<input type="button" value="注册" onclick="jump1()"/>
</body>
</html>
