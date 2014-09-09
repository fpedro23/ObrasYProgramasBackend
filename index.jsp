<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Programas</title>
    </head>
    <body>
        <h1>Acciones de Programas</h1>
        <form action="operacionProgramas.action">
            <input type="submit" value="Consulta General"/>
        </form>
        <form action="operacionProgramasConsultaEspecifica.action">
            <input type="text" name="idPrograma"/>
            <input type="submit" value="Consulta Específica"/>
        </form>
    </body>
</html>