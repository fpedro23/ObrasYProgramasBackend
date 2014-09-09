<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.io.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="modelObrasYProgramas.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="com.google.gson.*" errorPage="" %>


<%

        Gson gson = new Gson();

        List<Programa> listaProgramas;
        listaProgramas = (List)request.getAttribute("listaProgramas");

        String json = gson.toJson(listaProgramas);

        out.println(json);
        out.flush();
%>
