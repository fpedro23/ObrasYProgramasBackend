-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=``@`` PROCEDURE `buscarObras`(
inTipoObra TEXT,
inDependencia TEXT,
inEstado int,
inMunicipio int,
inRangoInversionMin DOUBLE,
inRangoInversionMax DOUBLE,
inFechaInicio date,
inFechaTermino date,
inImpacto int,
inCargoInaugura int,
inTipoInversion TEXT,
inTipoClasificacion TEXT

)
BEGIN
SELECT
O.idObra,O.denominacion,O.idDependencia,nombreDependencia,GROUP_CONCAT(DISTINCT nombreTipoInv) AS listaInversiones,GROUP_CONCAT( DISTINCT nombreTipoClasificacion) AS listaClasificaciones
FROM
obras O

JOIN
detalle_inversion ON O.idObra = detalle_inversion.idObra
JOIN
tipo_inversion ON detalle_inversion.idTipoInversion = tipo_inversion.idTipoInversion



JOIN
tipo_obra ON O.idTipoObra = tipo_obra.idTipoObra
JOIN
dependencias ON O.idDependencia = dependencias.idDependencia

JOIN
estados ON O.idEstado = estados.idEstado

JOIN
municipios ON O.idMunicipio = municipios.idMunicipio

JOIN
poblacion_objetivo ON O.idPobObjetivo = poblacion_objetivo.idpoblacionObjetivo

JOIN
impactos ON O.idImpacto = impactos.idImpacto
JOIN
cargo_inaugura ON O.idcargoInaugura = cargo_inaugura.idCargoInaugura

JOIN
detalle_clasificacion_obra ON O.idObra = detalle_clasificacion_obra.idObra
JOIN
tipo_clasificacion ON detalle_clasificacion_obra.idTipoClasificacion = tipo_clasificacion.idTipoClasificacion

WHERE



(inTipoObra Is Null OR FIND_IN_SET(O.idTipoObra, inTipoObra)>0)AND
(inDependencia Is Null OR FIND_IN_SET(O.idDependencia, inDependencia)>0)AND

(inEstado Is Null OR inEstado = O.idEstado) AND

(inMunicipio Is Null OR inMunicipio = O.idMunicipio) AND
(inCargoInaugura Is Null OR inCargoInaugura = O.idcargoInaugura) AND
(inImpacto Is Null OR inImpacto = O.idImpacto) AND

(inRangoInversionMin Is Null OR inRangoInversionMax Is Null OR
(inRangoInversionMin Is Not Null AND inRangoInversionMax Is Not Null AND
O.inversionTotal BETWEEN inRangoInversionMin AND inRangoInversionMax)) AND

(inFechaInicio Is Null OR inFechaTermino Is Null OR
(inFechaInicio Is Not Null AND inFechaTermino Is Not Null AND
O.fechaInicio BETWEEN inFechaInicio AND inFechaTermino))
GROUP BY O.idObra
;
END