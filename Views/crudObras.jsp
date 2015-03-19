<%--
  Created by IntelliJ IDEA.
  User: db2
  Date: 15/03/15
  Time: 01:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">

    <%@ include file="Menu/headMenu.jsp"%>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/estilocss.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/noTables.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<form action="controlObras.action" method="POST">
    <%@ include file="Menu/menu.jsp"%>
<div class="container" style="margin-top:0px;">

        <div class= "container" style="margin-top:0px;">
            <div class="jumbotronMC" style="margin-top:0px;">
                <div class="row" style="margin-top:0px;">
                    <div class="col-md-4" align="center">
                        <s:textfield name="idObra" label="Identificador de Obra" cssClass="form-control" value="OB_CDI_00008"/>
                    </div>
                    <div class="col-md-4" align="center" >
                        <input type="submit" name="action" value="Buscar" class="btn btn-primary"/>
                        <input type="submit" name="action" value="Guardar" class="btn btn-primary"/>
                        <br/>
                        <span class="labelErr label-danger">${msgBusca}</span>
                    </div>
                </div>
            </div>
        </div>
    <div class="row" style="margin-top:0px;">
            <div class="panel with-nav-tabs panel-default" style="margin-top:0px;">
                <div class="panel-heading" style="margin-top:0px;">
                    <ul class="nav nav-tabs" style="margin-top:0px;">
                        <li class="active"><a href="#tab1default" data-toggle="tab">Datos Generales</a></li>
                        <li><a href="#tab2default" data-toggle="tab">Inversi&oacute;n, Poblaci&oacute;n, Clasificaci&oacute;n</a></li>
                        <li><a href="#tab3default" data-toggle="tab">Descripci&oacute;n e Inauguraci&oacute;n</a></li>
                        <li><a href="#tab4default" data-toggle="tab">Fotograf&iacute;as</a></li>
                    </ul>
                </div>
                <div class="panel-body" style="margin-top:0px;">
                    <div class="tab-content" style="margin-top:0px;">
                        <div class="tab-pane fade in active" id="tab1default">
                                <div class="row">
                                    <div class="col-md-4">
                                        <s:textfield name="denominacion" label="Denominacion" cssClass="form-control"/>
                                    </div>
                                    <div class="col-md-4">
                                        <label class="labelFrm">Dependencia / Organismo</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select id="selectedDependencia" name="selectedDependencia">
                                            <c:forEach items="${listaDependencias}" var="item">
                                                <option value="${item.idDependencia}">${item.nombreDependencia}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-4">
                                        <label class="labelFrm">Estado</label>
                                    </div>
                                    <div class="col-md-4">
                                        <select id="selectedEstado" name="selectedEstado">
                                            <c:forEach items="${listaEstados}" var="item">
                                                <option value="${item.idEstado}">${item.nombreEstado}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>



                            <div class="row">
                                <div class="col-md-4">
                                    <s:textfield name="municipio" label="Municipio" cssClass="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <s:textfield name="fechaInicio" id="fechaInicio" label="Fecha de Inicio" cssClass="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <s:textfield name="fechaFinal" id="fechaFinal" label="Fecha de Término" cssClass="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="tab2default">Default 2</div>
                        <div class="tab-pane fade" id="tab3default">Default 3</div>
                        <div class="tab-pane fade" id="tab4default">Default 4</div>
                    </div>
                </div>
            </div>
    </div>
</div>

<br/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
    <script>
        $(function() {
            $( "#fechaInicio" ).datepicker();
            $( "#fechaFinal" ).datepicker();
        });

    </script>
</form>
</body>
</html>
