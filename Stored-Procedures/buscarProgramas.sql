-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`oypdbuser`@`localhost` PROCEDURE `buscarProgramas`(
inDependencia TEXT,
inEstado TEXT,
inRangoInversionMin DOUBLE,
inRangoInversionMax DOUBLE,
inTipoClasificacion TEXT
)
BEGIN
SELECT
P.idPrograma,
P.nombrePrograma,

P.idDependencia,
nombreDependencia,

P.idEstado,
nombreEstado,
estados.latitud,
estados.longitud,

P.idTipoApoyo,
nombreTipoApoyo,


GROUP_CONCAT(DISTINCT tipo_clasificacion.idTipoClasificacion ) AS listaIDclasificaciones,
GROUP_CONCAT( DISTINCT nombreTipoClasificacion) AS listaClasificaciones,


pobObjetivo,


montoApoyo,
totalBeneficiario,
totalMunicipiosBeneficiados,
observaciones,
anioPrograma,

inversionTotal,
tipoMoneda,
lineaBase,
metaBeneficiarios,
absoluto,
porcentual,
P.fechaMod

FROM
programas P

JOIN
tipo_apoyo ON P.idTipoApoyo = tipo_apoyo.idTipoApoyo

JOIN
dependencias ON P.idDependencia = dependencias.idDependencia
JOIN
estados ON P.idEstado = estados.idEstado


JOIN
detalle_clasificacion_programas ON P.idPrograma= detalle_clasificacion_programas.idPrograma
JOIN
tipo_clasificacion ON detalle_clasificacion_programas.idTipoClasificacion = tipo_clasificacion.idTipoClasificacion

WHERE
(inDependencia Is Null OR FIND_IN_SET(P.idDependencia, inDependencia)>0)AND

(inEstado Is Null OR FIND_IN_SET(P.idEstado, inEstado)>0 ) AND
(inTipoClasificacion Is Null OR FIND_IN_SET(detalle_clasificacion_programas.idTipoClasificacion, inTipoClasificacion)>0 ) AND



(inRangoInversionMin Is Null OR inRangoInversionMax Is Null OR
(inRangoInversionMin Is Not Null AND inRangoInversionMax Is Not Null AND
P.inversionTotal BETWEEN inRangoInversionMin AND inRangoInversionMax))


GROUP BY P.idPrograma
;
END