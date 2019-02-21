<%@page import="paqueteclima.CreaHTML"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="paqueteclima.DatoHorario" %>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<%
ArrayList<DatoHorario> datos=(ArrayList<DatoHorario>)request.getAttribute("datos_horarios");
String html_tabla=CreaHTML.pintarTabla(datos);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=html_tabla%>
</body>
</html>