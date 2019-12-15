<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<input type="text" id="username">
<input type="text" id="password">
<button id="submit">提交</button>
<a href="/weChat/login">微信授权</a>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
</script>
<script type="text/javascript">
    $(function () {
        $('#submit').click(function () {
            var name = $('#username').val();
            var word = $('#password').val();
            var datauser = {};
            datauser.username = $('#username').val();
            datauser.password = $('#password').val();
            $.ajax({
                url:'/user/login',
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
