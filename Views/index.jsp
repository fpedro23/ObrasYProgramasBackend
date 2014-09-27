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
        <h1>Acciones de Obras</h1>

        <form action="consultarEstados.action">
            <input type="submit" value="Consulta Estados"/>
        </form>
        
        <form action="consultarDependencias.action">
            <input type="submit" value="Consulta Dependencias"/>
        </form>

        <form action="consultarImpactos.action">
            <input type="submit" value="Consulta Impactos"/>
        </form>

        <form action="consultarInauguradores.action">
            <input type="submit" value="Consulta Inauguradores"/>
        </form>

        <form action="consultarPoblacionesObjetivo.action">
            <input type="submit" value="Consulta Poblaciones Objetivo"/>
        </form>

        <form action="consultarClasificaciones.action">
            <input type="submit" value="Consulta Clasificaciones"/>
        </form>

        <form action="consultarInversiones.action">
            <input type="submit" value="Consulta Inversiones"/>
        </form>

        <form action="consultarTiposDeObra.action">
            <input type="submit" value="Consulta Tipos de Obra"/>
        </form>



    </body>
</html>