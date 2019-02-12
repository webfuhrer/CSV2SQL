<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
int a=9;

%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  Java Server Page  -->
<p>Has escrito el numero <%=a%> </p>
<form action="ServletAgenda" method="POST">
Nombre: <input type="text" name="nombre">
Teléfono: <input type="text" name="telefono">
<input type="submit" value="Enviar">
</form>
<a href="ServletAgenda?accion=listar">Ver contactos</a>
</body>
</html>