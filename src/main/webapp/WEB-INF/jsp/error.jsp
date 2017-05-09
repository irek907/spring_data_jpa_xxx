<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%

String error = (String)request.getAttribute("ex");

System.out.println(error);
response.getWriter().write(error);

%>