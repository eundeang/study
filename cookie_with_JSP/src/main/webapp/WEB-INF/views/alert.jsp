<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<body>
<script>
    alert('<%=request.getAttribute("msg")%>');
    alert('<%=request.getAttribute("path")%>');
    if('<%=request.getAttribute("path")%>') {
        location.href = "<%=request.getAttribute("path")%>";
    }else {
        location.href="../../../web";
    }
</script>
</body>