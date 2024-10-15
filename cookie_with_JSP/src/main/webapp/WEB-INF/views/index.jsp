<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/makeCookie">[쿠키 발급받으러 가기]</a>
</body>
<%
    String loginId = (String)session.getAttribute("loginId");
    if(loginId == null) {
%>
    <a href="<%=request.getContextPath()%>/user?action=login">[로그인]</a>
<%
    }else {
%>
    <%=loginId%>님 반가워요!
    <a href="<%=request.getContextPath()%>/user?action=logout">[logout]</a>
<%
    }
%>
</html>