-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`oypdbuser`@`localhost` PROCEDURE `buscarObras`(
inTipoObra TEXT,
inDependencia TEXT,
inEstado TEXT,
inRangoInversionMin DOUBLE,
inRangoInversionMax DOUBLE,
inFechaInicio date,
inFechaTermino date,
inImpacto TEXT,
inCargoInaugura TEXT,
inTipoInversion TEXT,
inTipoClasificacion TEXT,
inSusceptible TEXT
)
BEGIN
SELECT
O.idObra,
O.denominacion,
O.idTipoObra,
nombreTipoObra,



O.idDependencia,
nombreDependencia,

O.idEstado,
nombreEstado,
estados.latitud,
estados.longitud,


O.idImpacto,
nombreImpacto,

GROUP_CONCAT(DISTINCT tipo_inversion.idTipoInversion) AS listaIDInversiones,
GROUP_CONCAT(DISTINCT nombreTipoInv) AS listaInversiones,

GROUP_CONCAT(DISTINCT tipo_clasificacion.idTipoClasificacion ) AS listaIDclasificaciones,
GROUP_CONCAT( DISTINCT nombreTipoClasificacion) AS listaClasificaciones,

O.idcargoInaugura,
nombreCargoInaugura,

descripcion,
observaciones,
fechaInicio,
fechaTermino,
inversionTotal,
totalBeneficiarios,
senializacion,
suceptibleInauguracion,
porcentajeAvance,
fotoAntes,
fotoDurante,
fotoDespues,
O.fecMod,
tipoMoneda,
inauguradoObra,
pobObjetivo,
municipio

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

(inEstado Is Null OR FIND_IN_SET(O.idEstado, inEstado)>0 ) AND
(inTipoClasificacion Is Null OR FIND_IN_SET(detalle_clasificacion_obra.idTipoClasificacion, inTipoClasificacion)>0 ) AND
(inTipoInversion Is Null OR FIND_IN_SET(detalle_inversion.idTipoInversion , inTipoInversion)>0 ) AND


(inCargoInaugura Is Null OR  FIND_IN_SET(O.idcargoInaugura, inCargoInaugura)>0 ) AND


(inImpacto Is Null OR  FIND_IN_SET(O.idImpacto, inImpacto)>0 ) AND
(inSusceptible Is Null OR FIND_IN_SET(suceptibleInauguracion, inSusceptible)>0 ) AND


(inRangoInversionMin Is Null OR inRangoInversionMax Is Null OR
(inRangoInversionMin Is Not Null AND inRangoInversionMax Is Not Null AND
O.inversionTotal BETWEEN inRangoInversionMin AND inRangoInversionMax)) AND

(inFechaInicio Is Null OR inFechaTermino Is Null OR
(inFechaInicio Is Not Null AND inFechaTermino Is Not Null AND
O.fechaInicio BETWEEN inFechaInicio AND inFechaTermino))
GROUP BY O.idObra
;
END