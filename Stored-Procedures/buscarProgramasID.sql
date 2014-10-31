-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`oypdbuser`@`localhost` PROCEDURE `buscarProgramasID`(
  inIDPrograma TEXT,
  inValorDolar DOUBLE
)
  BEGIN
    DROP TABLE IF EXISTS resultados;

    CREATE TEMPORARY TABLE IF NOT EXISTS resultados
      AS
        SELECT
          P.idPrograma,
          P.nombrePrograma,

          P.idDependencia,
          nombreDependencia,
          imagenDependencia,

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

          P.idPrograma = inIDPrograma


        GROUP BY P.idPrograma;

    SELECT
      *
    FROM resultados;


    SELECT
      idDependencia,
      nombreDependencia,
      anioPrograma,
      count(*)            AS numeroObras,
      SUM(inversionTotal * CASE tipoMoneda WHEN 'MDP' THEN 1 WHEN 'MDD' THEN inValorDolar END) AS totalInvertido
    FROM resultados
    GROUP BY nombreDependencia, anioPrograma;

    SELECT
      idEstado,
      anioPrograma,
      nombreEstado,
      latitud,
      longitud,
      count(*)            AS numeroObras,
      SUM(inversionTotal * CASE tipoMoneda WHEN 'MDP' THEN 1 WHEN 'MDD' THEN inValorDolar END) AS totalInvertido
    FROM resultados
    GROUP BY nombreEstado, anioPrograma;

    SELECT
      count(*)            AS numeroRegistros,
      SUM(inversionTotal * CASE tipoMoneda WHEN 'MDP' THEN 1 WHEN 'MDD' THEN inValorDolar END) AS totalInvertido,
      anioPrograma
    FROM resultados
    GROUP BY anioPrograma;


  END