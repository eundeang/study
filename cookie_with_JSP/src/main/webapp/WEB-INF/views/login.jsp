<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user" method="post">
    ID : <input type="text" name="userid"/><br>
    PW : <input type="password" name="userpw"/><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>