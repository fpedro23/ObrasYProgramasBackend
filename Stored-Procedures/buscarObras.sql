-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`oypdbuser`@`localhost` PROCEDURE `buscarObras`(
  inTipoObra            TEXT,
  inDependencia         TEXT,
  inEstado              TEXT,
  inRangoInversionMin   DOUBLE,
  inRangoInversionMax   DOUBLE,
  inFechaInicio         DATE,
  inFechaInicioSegunda  DATE,
  inFechaTermino        DATE,
  inFechaTerminoSegunda DATE,
  inImpacto             TEXT,
  inCargoInaugura       TEXT,
  inTipoInversion       TEXT,
  inTipoClasificacion   TEXT,
  inSusceptible         TEXT,
  inInaugurada          TEXT,
  inLimiteMin           INTEGER,
  inLimiteMax           INTEGER,
  inDenominacion        TEXT
)
  BEGIN
    CREATE TEMPORARY TABLE IF NOT EXISTS resultados
      AS
        SELECT
          O.idObra,
          O.denominacion,
          O.idTipoObra,
          nombreTipoObra,


          O.idDependencia,
          nombreDependencia,
          imagenDependencia,

          O.idEstado,
          nombreEstado,
          estados.latitud,
          estados.longitud,


          O.idImpacto,
          nombreImpacto,

          GROUP_CONCAT(DISTINCT tipo_inversion.idTipoInversion)         AS listaIDInversiones,
          GROUP_CONCAT(DISTINCT nombreTipoInv)                          AS listaInversiones,

          GROUP_CONCAT(DISTINCT tipo_clasificacion.idTipoClasificacion) AS listaIDclasificaciones,
          GROUP_CONCAT(DISTINCT nombreTipoClasificacion)                AS listaClasificaciones,

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
          municipio,
          subclasificacion.idsubClasificacion,
          nombresubClasificacion


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
          LEFT JOIN
          subclasificacion ON detalle_clasificacion_obra.idSubClasificacion = subclasificacion.idsubClasificacion
        WHERE


          (inTipoObra IS NULL OR FIND_IN_SET(O.idTipoObra, inTipoObra) > 0) AND
          (inDependencia IS NULL OR FIND_IN_SET(O.idDependencia, inDependencia) > 0) AND

          (inEstado IS NULL OR FIND_IN_SET(O.idEstado, inEstado) > 0) AND
          (inTipoClasificacion IS NULL OR
           FIND_IN_SET(detalle_clasificacion_obra.idTipoClasificacion, inTipoClasificacion) > 0) AND
          (inTipoInversion IS NULL OR FIND_IN_SET(detalle_inversion.idTipoInversion, inTipoInversion) > 0) AND


          (inCargoInaugura IS NULL OR FIND_IN_SET(O.idcargoInaugura, inCargoInaugura) > 0) AND

          (inInaugurada IS NULL OR FIND_IN_SET(inauguradoObra, inInaugurada) > 0) AND


          (inImpacto IS NULL OR FIND_IN_SET(O.idImpacto, inImpacto) > 0) AND
          (inSusceptible IS NULL OR FIND_IN_SET(suceptibleInauguracion, inSusceptible) > 0) AND

          (O.denominacion LIKE CASE WHEN inDenominacion IS NULL THEN O.denominacion
                               ELSE CONCAT('%', inDenominacion, '%') END) AND


          (inRangoInversionMin IS NULL OR inRangoInversionMax IS NULL OR
           (inRangoInversionMin IS NOT NULL AND inRangoInversionMax IS NOT NULL AND
            O.inversionTotal BETWEEN inRangoInversionMin AND inRangoInversionMax)) AND


          (inFechaInicio IS NULL OR inFechaInicioSegunda IS NULL OR
           (inFechaInicio IS NOT NULL AND inFechaInicioSegunda IS NOT NULL AND
            O.fechaInicio BETWEEN inFechaInicio AND inFechaInicioSegunda)) AND


          (inFechaTermino IS NULL OR inFechaTerminoSegunda IS NULL OR
           (inFechaTermino IS NOT NULL AND inFechaTerminoSegunda IS NOT NULL AND
            O.fechaTermino BETWEEN inFechaTermino AND inFechaTerminoSegunda))

        GROUP BY O.idObra;

    SELECT
      *
    FROM resultados
    LIMIT inLimiteMin, inLimiteMax;


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

    SELECT
      count(*)            AS numeroObras,
      SUM(inversionTotal) AS totalInvertido
    FROM resultados;


    DROP TABLE resultados;


  END