<%-- 
    Document   : usuario
    Created on : 23 jun 2025, 10:17:53 p.m.
    Author     : jperezgil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${titulo}</h1>
        <mvc:form action="registrarUsuario" method="post" modelAttribute="usuarioBean">
            <table>
                <tr>
                    <td>
                        <mvc:label path="nombreCompleto">Nombre Completo</mvc:label>
                    </td>
                    <td>
                        <mvc:hidden path="idUsuario"/>
                        <mvc:hidden path="estado"/>
                        <mvc:input type="text" path="nombreCompleto"/>
                        <mvc:errors  path="nombreCompleto" cssStyle="color:red"/> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <mvc:label path="user">User</mvc:label>
                    </td>
                    <td>
                        <mvc:input type="text" path="user"/>
                        <mvc:errors  path="user" cssStyle="color:red"/> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <mvc:label path="password">Password</mvc:label>
                    </td>
                    <td>
                        <mvc:input type="password" path="password"/>
                        <mvc:errors  path="password" cssStyle="color:red"/> 
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="GRABAR" />
                    </td>
                </tr>
            </table>
            <div>
                <label style="color: red">${msgError}</label>
            </div>
        </mvc:form>
    </body>
</html>
