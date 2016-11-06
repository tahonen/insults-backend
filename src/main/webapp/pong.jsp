<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
Running version
<%=application.getInitParameter("version")%>
on host
<%=InetAddress.getLocalHost().getHostAddress()%>