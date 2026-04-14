<%-- 
    Document   : mantenimientoUsuarios
    Created on : 23 jun 2025, 10:05:12 p.m.
    Author     : jperezgil
--%>

<%@page import="java.util.List"%>
<%@page import="edu.cibertec.entity.UsuarioEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MANTENIMIENTO USUARIOS</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID USUARIO</th>
                    <th>NOMBRES COMPLETOS</th>
                    <th>USER</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <% 
            List<UsuarioEntity> listaUsuarios =(List<UsuarioEntity>) request.getAttribute("listaUsuarios");
            %>
            <tbody>
                <% 
                    for(UsuarioEntity usuario:listaUsuarios){
                %>
                <tr>
                    <td><%=usuario.getIdUsuario() %></td>
                    <td><%=usuario.getNombreCompleto()%></td>
                    <td><%=usuario.getUser()%></td>
                    <td>
                        <a href="elinarUsuario?idUsuario=<%=usuario.getIdUsuario() %>">E</a> - 
                        <a href="formularioActualizarUsuario?idUsuario=<%=usuario.getIdUsuario() %>">A</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <label style="color: red">${msgError}</label>
        <label style="color: blue">${msgExito}</label>
        <h3><a href="formularioNuevoUsuario">Nuevo Usuario</a></h3>
    </body>
</html>
