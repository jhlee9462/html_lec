<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
double base = Double.parseDouble(request.getParameter("base"));
double height = Double.parseDouble(request.getParameter("height"));
double result = base * height / 2.0;
%>
삼각형의 넓이 : <%= result %>