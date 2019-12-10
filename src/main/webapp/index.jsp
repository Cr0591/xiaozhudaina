<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<input type="text" id="username">
<input type="text" id="password">
<button id="submit">提交</button>
<script type="text/javascript" src="./resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('#submit').click(function () {
            var name = $('#username').val();
            var word = $('#password').val();
            var datauser = {};
            datauser.username = $('#username').val();
            datauser.password = $('#password').val();
            $.ajax({
                url:'/xiaozhudaina_war_exploded/user/login',
                type:'POST',
                data:datauser,
                //dataType: 'json',
                success:function (data) {
                    alert(data.success);
                    alert(data.errMsg);
                }
            });
        });
    });
</script>
</body>
</html>
