<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.io.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="modelObrasYProgramas.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="com.google.gson.*" errorPage="" %>


<%

        Gson gson = new Gson();

        List lista;
        lista = (List)request.getAttribute("lista");

ResultadoObra resultado;
resultado = (ResultadoObra)request.getAttribute("resultado");
        String json = gson.toJson(resultado);

        out.println(json);
        out.flush();
%>
