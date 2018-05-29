<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
<html>
<head><title>Insult App v<%=application.getInitParameter("version")%></title></head>
<body>
<h1>Insult App v<%=application.getInitParameter("version")%></h1>
<p>
Running FOOBAR <%=application.getInitParameter("version")%> on host <%= InetAddress.getLocalHost().getHostAddress() %>
</p>
</body>
</html>
