<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
{"result" :
<%
if (request.getParameter("id").equals("aaaa") && request.getParameter("pw").equals("aaaa")) {
%>
	"ok"}
<%
} else {
%>
	"fail"}
<%
}
%>