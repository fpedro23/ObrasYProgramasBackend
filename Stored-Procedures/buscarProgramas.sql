-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER =`oypdbuser`@`localhost` PROCEDURE `buscarProgramas`(
  inDependencia       TEXT,
  inEstado            TEXT,
  inRangoInversionMin DOUBLE,
  inRangoInversionMax DOUBLE,
  inTipoClasificacion TEXT,
  inLimiteMin         INTEGER,
  inLimiteMax         INTEGER
)
  BEGIN
    DROP TABLE IF EXISTS resultados;

    CREATE TEMPORARY TABLE IF NOT EXISTS resultados
      as
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


          GROUP_CONCAT(DISTINCT tipo_clasificacion.idTipoClasificacion) AS listaIDclasificaciones,
          GROUP_CONCAT(DISTINCT nombreTipoClasificacion)                AS listaClasificaciones,


          P.idPobObjetivo,
          nombrePobObj,

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

          LEFT JOIN
          tipo_apoyo ON P.idTipoApoyo = tipo_apoyo.idTipoApoyo

          LEFT JOIN
          dependencias ON P.idDependencia = dependencias.idDependencia
          LEFT JOIN
          estados ON P.idEstado = estados.idEstado
          LEFT JOIN
          poblacion_objetivo ON P.idPobObjetivo = poblacion_objetivo.idpoblacionObjetivo


          LEFT JOIN
          detalle_clasificacion_programas ON P.idPrograma = detalle_clasificacion_programas.idPrograma
          LEFT JOIN
          tipo_clasificacion
            ON detalle_clasificacion_programas.idTipoClasificacion = tipo_clasificacion.idTipoClasificacion

        WHERE
          (inDependencia IS NULL OR FIND_IN_SET(P.idDependencia, inDependencia) > 0) AND

          (inEstado IS NULL OR FIND_IN_SET(P.idEstado, inEstado) > 0) AND
          (inTipoClasificacion IS NULL OR
           FIND_IN_SET(detalle_clasificacion_programas.idTipoClasificacion, inTipoClasificacion) > 0) AND


          (inRangoInversionMin IS NULL OR inRangoInversionMax IS NULL OR
           (inRangoInversionMin IS NOT NULL AND inRangoInversionMax IS NOT NULL AND
            P.inversionTotal BETWEEN inRangoInversionMin AND inRangoInversionMax))


        GROUP BY P.idPrograma;

    SELECT
      *
    FROM resultados
    LIMIT inLimiteMin, inLimiteMax;


    SELECT
      idDependencia,
      nombreDependencia,
      anioPrograma,
      count(*)            AS numeroObras,
      SUM(inversionTotal) AS totalInvertido
    FROM resultados
    GROUP BY nombreDependencia, anioPrograma;

    SELECT
      idEstado,
      anioPrograma,
      nombreEstado,
      latitud,
      longitud,
      count(*)            AS numeroObras,
      SUM(inversionTotal) AS totalInvertido
    FROM resultados
    GROUP BY nombreEstado, anioPrograma;

    SELECT
      count(*)            AS numeroRegistros,
      SUM(inversionTotal) AS totalInvertido,
      anioPrograma
    FROM resultados
    GROUP BY anioPrograma;


  END