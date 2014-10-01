<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.io.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="modelObrasYProgramas.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="com.google.gson.*" errorPage="" %>


<%

        Gson gson = new Gson();

        ResultadoPrograma resultadoPrograma;
        resultadoPrograma = (ResultadoPrograma)request.getAttribute("resultadoPrograma");

        String json = gson.toJson(resultadoPrograma);

        out.println(json);
        out.flush();
%>
