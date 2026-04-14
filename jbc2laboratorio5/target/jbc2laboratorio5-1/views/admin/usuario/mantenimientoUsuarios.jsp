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
        <title>MANTENIMIENTO USUARIOS</title>
    </head>
    <body>
        <h1>MANTENIMIENTO USUARIOS</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID USUARIO</th>
                    <th>NOMBRES COMPLETOS</th>
                    <th>USER</th>
                    <th>FOTO</th>
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
                        <% if(usuario.getFoto() != null && usuario.getFoto().length > 0) { %>
                           <img width="50px" height="50px" src="<%=usuario.getFotoString() %>" alt="Sin foto" /> 
                        <%} else{%>
                            <label>Sin foto</label>
                        <%}%>
                    </td>
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
        <h2>Sesion Mapeada por anotacion y imprimida con el scriplet tradicional: <%= ((UsuarioEntity)request.getSession().getAttribute("usuario")).getNombreCompleto() %></h2>
        <h2>Sesion Mapeada por anotacion y imprimida con el scriplet mejorado: ${usuario.nombreCompleto}</h2>
        <h2>Sesion Mapeada de manera tradicional y imprimida con el scriplet mejorado: <%= ((UsuarioEntity)request.getSession().getAttribute("usuarioSesion")).getNombreCompleto() %></h2>
    </body>
</html>
