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

    <%@ include file="menu/headMenu.jsp"%>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/resources/css/estilocss.css">
    <script src="${pageContext.request.contextPath}/Views/resources/js/checkandradio.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

<form action="controlObras.action" method="POST" enctype="multipart/form-data">
    <%@ include file="menu/menu.jsp"%>
<div class="container" style="margin-top:0px;">


            <div class="jumbotronMC" style="margin-top:5px;">
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

    <div class="row" style="margin-top:0px;">

        <div class="tabbable-panel">
            <div class="tabbable-line">

                <ul class="nav nav-tabs ">
                    <li class="active">
                        <a href="#tab_default_1" data-toggle="tab">Datos Generales</a>
                    </li>
                    <li>
                        <a href="#tab_default_2" data-toggle="tab">Inversi&oacute;n, Poblaci&oacute;n, Clasificaci&oacute;n</a>
                    </li>
                    <li>
                        <a href="#tab_default_3" data-toggle="tab">Descripci&oacute;n e Inauguraci&oacute;n</a>
                    </li>
                    <li>
                        <a href="#tab_default_4" data-toggle="tab">Fotograf&iacute;as</a>
                    </li>
                </ul>
            </div>
                <div class="tab-content">
                    <div class="tab-pane active" id="tab_default_1"  width="80%">
                        <br/>
                            <div class="row" width="80%">
                                <div class="col-md-4">
                                    <s:textfield name="denominacion" label="Denominacion" cssClass="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <span class="labelFrm ">Dependencia / Organismo</span>
                                    <select id="selectedDependencia" name="selectedDependencia">
                                        <c:forEach items="${listaDependencias}" var="item">
                                            <option value="${item.idDependencia}">${item.nombreDependencia}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <label class="labelFrm">Estado</label>
                                    <select id="selectedEstado" name="selectedEstado">
                                        <c:forEach items="${listaEstados}" var="item">
                                            <option value="${item.idEstado}">${item.nombreEstado}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row" width="80%">
                                <div class="col-md-4">
                                    <s:textfield name="municipio" label="Municipio" cssClass="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <s:textfield name="fechaInicio" id="fechaInicio" label="Fecha de Inicio" cssClass="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <s:textfield name="fechaFinal" id="fechaFinal" label="Fecha de Término" cssClass="form-control"/>
                                </div>
                            </div >
                            <div class="row" width="80%">
                                <div class="col-md-4">
                                    <label class="labelFrm">Tipo de Obra:</label>
                                    <select id="selectedTipoObra" name="selectedTipoObra" aria-label="Tipo de Obra">
                                        <c:forEach items="${listaTiposObra}" var="item">
                                            <option value="${item.idTipoObra}">${item.nombreTipoObra}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <s:textfield name="avanceFisico" id="avanceFisico" label="Avance Fisico" cssClass="form-control"/>
                                </div>
                                <div class="col-md-4">
                                    <s:textfield name="fechaModificacion" id="fechaModificacion" label="Fecha de modifiacion" cssClass="form-control" readonly="true"/>
                                </div>
                            </div>

                    </div>


                    <div class="tab-pane" id="tab_default_2">
                        <br/>
                        <div class="col-xs-6 col-md-3">

                            <div class="panel status panel-danger">
                                <div class="panel-heading">
                                    <h1 class="panel-title text-center">Inversi&oacute;n</h1>
                                </div>
                                <div class="panel-body ">
                                        <div class="row">
                                            <div class="btn-group" data-toggle="buttons" style="width: 100%">
                                                <label class="btn btn-success" >
                                                    <input type="checkbox" autocomplete="off">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                    Federal&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                </label>
                                            </div>
                                        </div>
                                        </br>
                                        <div class="row">
                                            <div class="btn-group" data-toggle="buttons">
                                                <label class="btn btn-success">
                                                    <input type="checkbox" autocomplete="off">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                    Estatal&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                </label>
                                            </div>
                                        </div>
                                        </br>
                                        <div class="row">
                                            <div class="btn-group" data-toggle="buttons">
                                                <label class="btn btn-success">
                                                    <input type="checkbox" autocomplete="off">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                    Municipal&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                </label>
                                            </div>
                                        </div>
                                        </br>
                                        <div class="row">
                                            <div class="btn-group" data-toggle="buttons">
                                                <label class="btn btn-success">
                                                    <input type="checkbox" autocomplete="off">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                    Social&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                </label>
                                            </div>
                                        </div>
                                        </br>
                                        <div class="row">
                                            <div class="btn-group" data-toggle="buttons">
                                                <label class="btn btn-success">
                                                    <input type="checkbox" autocomplete="off">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                    Privada&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                </label>
                                            </div>
                                        </div>
                                        </br>
                                        <div class="row">
                                            <div class="btn-group" data-toggle="buttons">
                                                <label class="btn btn-success">
                                                    <input type="checkbox" autocomplete="off">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                    Otra Inversi&oacute;n
                                                </label>
                                            </div>
                                        </div>
                                        </br>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <s:textfield name="importeInversion" id="importeInversion" label="Inversión Total" cssClass="form-control" style="width: 150%"/>
                                            </div>
                                            <p></p>
                                            <div class="col-md-5">
                                                <select id="selectedTipoMoneda" name="selectedTipoMoneda" style="width: 120%">
                                                    <option value="MDP">MDP</option>
                                                    <option value="MDD">MDD</option>
                                                </select>
                                            </div>
                                        </div>

                                </div>
                            </div>
                        </div>

                        <div class="col-xs-6 col-md-3">

                            <div class="panel status panel-danger">
                                <div class="panel-heading">
                                    <h1 class="panel-title text-center">Poblaci&oacute;n</h1>
                                </div>
                                <div class="panel-body ">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <s:textfield name="poblacionObjetivo" id="poblacionObjetivo" label="Población Objetivo" cssClass="form-control" style="width: 250%"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-5">
                                            <span class="labelFrm ">&nbsp;Impacto&nbsp;</span>
                                            <select id="selectedTipoImpacto" name="selectedTipoImpacto" style="width: 220%">
                                                <c:forEach items="${listaImpactos}" var="item">
                                                    <option value="${item.idImpacto}">${item.nombreImpacto}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    </br>
                                    <div class="row">
                                        <div class="btn-group" data-toggle="buttons" style="width: 100%">
                                            <label class="btn btn-success" >
                                                <input type="checkbox" autocomplete="off">
                                                <span class="glyphicon glyphicon-ok"></span>
                                                Señalizaci&oacute;n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xs-6 col-md-3">

                            <div class="panel status panel-danger">
                                <div class="panel-heading">
                                    <h1 class="panel-title text-center">Clasificaci&oacute;n</h1>
                                </div>
                                <div class="panel-body ">
                                    <div class="row">
                                        <div class="btn-group" data-toggle="buttons" >
                                            <label class="btn btn-success" >
                                                <input type="checkbox" autocomplete="off">
                                                <span class="glyphicon glyphicon-ok"></span>
                                                Compromiso de Gobierno&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            </label>
                                        </div>

                                            <select id="selectedSubClasificaciones" name="selectedSubClasificaciones" style="width: 40%">
                                                <c:forEach items="${listaSubClasificaciones}" var="item">
                                                    <option value="${item.idSubClasificacion}">${item.nombreSubclasificacion}</option>
                                                </c:forEach>
                                            </select>


                                    </div>
                                    </br>
                                    <div class="row">
                                        <div class="btn-group" data-toggle="buttons">
                                            <label class="btn btn-success">
                                                <input type="checkbox" autocomplete="off">
                                                <span class="glyphicon glyphicon-ok"></span>
                                                Plan Nuevo Guerrero&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            </label>
                                        </div>
                                    </div>
                                    </br>
                                    <div class="row">
                                        <div class="btn-group" data-toggle="buttons">
                                            <label class="btn btn-success">
                                                <input type="checkbox" autocomplete="off">
                                                <span class="glyphicon glyphicon-ok"></span>
                                                Plan Michoacan&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            </label>
                                        </div>
                                    </div>
                                    </br>
                                    <div class="row">
                                        <div class="btn-group" data-toggle="buttons">
                                            <label class="btn btn-success">
                                                <input type="checkbox" autocomplete="off">
                                                <span class="glyphicon glyphicon-ok"></span>
                                                Plan Nacional de infraestructura&nbsp;&nbsp;&nbsp;
                                            </label>
                                        </div>
                                    </div>
                                    </br>
                                    <div class="row">
                                        <div class="btn-group" data-toggle="buttons">
                                            <label class="btn btn-success">
                                                <input type="checkbox" autocomplete="off">
                                                <span class="glyphicon glyphicon-ok"></span>
                                                Cruzada Nacional Contra el Hambre
                                            </label>
                                        </div>
                                    </div>
                                    </br>
                                    <div class="row">
                                        <div class="btn-group" data-toggle="buttons">
                                            <label class="btn btn-success">
                                                <input type="checkbox" autocomplete="off">
                                                <span class="glyphicon glyphicon-ok"></span>
                                                Otra Clasificaci&oacute;n
                                            </label>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane" id="tab_default_3">
                        <div class="row" >
                            <div class="col-md-4">
                                <s:textarea name="descripcion" label="Descripción" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="row" >
                            <div class="col-md-4">
                                <s:textarea name="observaciones" label="Observaciones" cssClass="form-control"/>
                            </div>
                        </div>

                        </br>
                        <div class="row">
                            <div class="btn-group" data-toggle="buttons" style="width: 100%">
                                <label class="btn btn-success" >
                                    <input type="checkbox" autocomplete="off">
                                    <span class="glyphicon glyphicon-ok"></span>
                                    Inaugurada&oacute;n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </label>
                            </div>
                        </div>
                        </br>
                        <div class="row">
                            <div class="btn-group" data-toggle="buttons" style="width: 100%">
                                <label class="btn btn-success" >
                                    <input type="checkbox" autocomplete="off">
                                    <span class="glyphicon glyphicon-ok"></span>
                                    Susceptible de inaugurar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </label>
                            </div>
                        </div>
                        </br>
                        <div class="row">
                            <div class="col-md-5">
                                <span class="labelFrm ">Cargo que Inaugur&oacute;</span>
                                <select id="selectedInaugurador" name="selectedInaugurador" style="width: 220%">
                                    <c:forEach items="${listaInaugurador}" var="item">
                                        <option value="${item.idCargoInaugura}">${item.nombreCargoInaugura}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>



                    </div>
                    </br>
                    <div class="tab-pane" id="tab_default_4">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Antes:</label>
                                <input type="file" class="form-control" name="antes"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Durante:</label>
                                <input type="file" class="form-control" name="durante"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Despu&eacute;s:</label>
                                <input type="file" class="form-control" name="despues"/>
                            </div>
                        </div>
                    </div>
                </div>

        </div>



    </div>
</div>

<br/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Views/resources/js/jquery.ui.datepicker-es.js"></script>


    <script>
        $(function() {
            $( "#fechaInicio" ).datepicker({dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true, yearRange: '-100:+0'});
            $( "#fechaFinal" ).datepicker({dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true, yearRange: '-100:+0'});
        });

    </script>

    <script src="${pageContext.request.contextPath}/resources/js/jquery.numeric.js" ></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/utilerias.js" ></script>


</form>
</body>
</html>
