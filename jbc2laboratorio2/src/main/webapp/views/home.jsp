<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Welcome to Home Page</h1>
    <p>This is a basic JSP page.</p>
    
    <%
        String message = "Hello from JSP!";
        out.println("<p>" + message + "</p>");
    %>
    <br> hola ${nombre} de ${edad} de nacionalidad ${nacionalidad}
    <br> Hoy es <%=request.getAttribute("nombre") %>
    <br> Prueba ${pageContext.request.contextPath} 
</body>
</html>