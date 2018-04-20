<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.4.5/themes/default/easyui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.4.5/themes/icon.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-easyui-1.5.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/login.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/common.js"></script>
    <title>登录</title>
</head>
<body>
<label>用户名</label><input type="text" id="userName"> <br>
<label>密码</label><input type="password" id="password"> <br>
<button onclick="login()">登陆</button>
</body>

</html>
