<%@page import="paqueteservletagenda.Contacto"%>
<%@page import="paqueteservletagenda.AccesoBD"%>
<%@page import="paqueteservletagenda.CreaHTML"%>
<%@page import="java.util.ArrayList;" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%

ArrayList<Contacto> lista=(ArrayList<Contacto>)request.getAttribute("lista");
String html_tabla=CreaHTML.crearTabla(lista);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=html_tabla %>
</body>
</html>