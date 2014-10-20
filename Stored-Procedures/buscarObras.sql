CREATE DEFINER=`oypdbuser`@`localhost` PROCEDURE `buscarObras`(
inTipoObra TEXT,
inDependencia TEXT,
inEstado TEXT,
inRangoInversionMin DOUBLE,
inRangoInversionMax DOUBLE,
inFechaInicio date,
inFechaInicioSegunda date,
inFechaTermino date,
inFechaTerminoSegunda date,
inImpacto TEXT,
inCargoInaugura TEXT,
inTipoInversion TEXT,
inTipoClasificacion TEXT,
inSusceptible TEXT,
inInaugurada TEXT,
inLimiteMin integer,
inLimiteMax integer,
inDenominacion TEXT 
)
BEGIN
CREATE TEMPORARY TABLE IF NOT EXISTS  resultados AS
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

LEFT JOIN
detalle_inversion ON O.idObra = detalle_inversion.idObra
LEFT JOIN
tipo_inversion ON detalle_inversion.idTipoInversion = tipo_inversion.idTipoInversion
LEFT JOIN

tipo_obra ON O.idTipoObra = tipo_obra.idTipoObra
LEFT JOIN

dependencias ON O.idDependencia = dependencias.idDependencia
LEFT JOIN

estados ON O.idEstado = estados.idEstado
LEFT JOIN

impactos ON O.idImpacto = impactos.idImpacto
LEFT JOIN

cargo_inaugura ON O.idcargoInaugura = cargo_inaugura.idCargoInaugura
LEFT JOIN

detalle_clasificacion_obra ON O.idObra = detalle_clasificacion_obra.idObra
LEFT JOIN
tipo_clasificacion ON detalle_clasificacion_obra.idTipoClasificacion = tipo_clasificacion.idTipoClasificacion
WHERE



(inTipoObra Is Null OR FIND_IN_SET(O.idTipoObra, inTipoObra)>0)AND
(inDependencia Is Null OR FIND_IN_SET(O.idDependencia, inDependencia)>0)AND

(inEstado Is Null OR FIND_IN_SET(O.idEstado, inEstado)>0 ) AND
(inTipoClasificacion Is Null OR FIND_IN_SET(detalle_clasificacion_obra.idTipoClasificacion, inTipoClasificacion)>0 ) AND
(inTipoInversion Is Null OR FIND_IN_SET(detalle_inversion.idTipoInversion , inTipoInversion)>0 ) AND


(inCargoInaugura Is Null OR  FIND_IN_SET(O.idcargoInaugura, inCargoInaugura)>0 ) AND

(inInaugurada Is Null OR  FIND_IN_SET(inauguradoObra, inInaugurada)>0 ) AND


(inImpacto Is Null OR  FIND_IN_SET(O.idImpacto, inImpacto)>0 ) AND
(inSusceptible Is Null OR FIND_IN_SET(suceptibleInauguracion, inSusceptible)>0 ) AND

(O.denominacion like CASE WHEN inDenominacion is null THEN O.denominacion else CONCAT ('%', inDenominacion ,'%') end ) AND 



(inRangoInversionMin Is Null OR inRangoInversionMax Is Null OR
(inRangoInversionMin Is Not Null AND inRangoInversionMax Is Not Null AND
O.inversionTotal BETWEEN inRangoInversionMin AND inRangoInversionMax)) AND



(inFechaInicio Is Null OR inFechaInicioSegunda Is Null OR
(inFechaInicio Is Not Null AND inFechaInicioSegunda Is Not Null AND
O.fechaInicio BETWEEN inFechaInicio AND inFechaInicioSegunda)) AND


(inFechaTermino Is Null OR inFechaTerminoSegunda Is Null OR
(inFechaTermino Is Not Null AND inFechaTerminoSegunda Is Not Null AND
O.fechaTermino BETWEEN inFechaTermino AND inFechaTerminoSegunda))

GROUP BY O.idObra

;

select * from resultados limit inLimiteMin,inLimiteMax;


  SELECT
    idDependencia,
    nombreDependencia,
    count(*)            AS numeroObras,
    SUM(inversionTotal) AS totalInvertido
  FROM resultados
  GROUP BY nombreDependencia;

  SELECT
    idEstado,
    nombreEstado,
    latitud,
    longitud,
    count(*)            AS numeroObras,
    SUM(inversionTotal) AS totalInvertido
  FROM resultados
  GROUP BY nombreEstado;

select
count(*) AS numeroObras,
SUM(inversionTotal) AS totalInvertido
from resultados;


DROP TABLE resultados;


END
