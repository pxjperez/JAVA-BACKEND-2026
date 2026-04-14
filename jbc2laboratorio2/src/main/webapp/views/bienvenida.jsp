<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>HOLA ${nombre}</h1>
    <br> Hoy es <%=request.getAttribute("nombre") %>
    <br> contextPath ${pageContext.request.contextPath}
    
    <h1><%=pageContext.getPage().toString()  %></h1>
    <h1>${pageContext.page}</h1>
    <h2><%=application.getContextPath() %></h2>
    <h1>${application.contextPath}</h1>
</body>
</html>