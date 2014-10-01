<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.io.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="modelObrasYProgramas.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="com.google.gson.*" errorPage="" %>


<%

        Gson gson = new Gson();

ResultadoObra resultadoObra;
        resultadoObra = (ResultadoObra)request.getAttribute("resultadoObra");

        String json = gson.toJson(resultadoObra);

        out.println(json);
        out.flush();
%>
