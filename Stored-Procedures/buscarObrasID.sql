-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`oypdbuser`@`localhost` PROCEDURE `buscarObrasID`(
  inIDObra TEXT,
  inValorDolar DOUBLE
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

          O.idObra = inIDObra

        GROUP BY O.idObra;

    SELECT
      *
    FROM resultados;


    SELECT
      idDependencia,
      nombreDependencia,
      count(*)            AS numeroObras,
	  SUM(inversionTotal * CASE tipoMoneda WHEN 'MDP' THEN 1 WHEN 'MDD' THEN inValorDolar END) AS totalInvertido

    FROM resultados
    GROUP BY nombreDependencia;


    SELECT
      idEstado,
      nombreEstado,
      latitud,
      longitud,
      count(*)            AS numeroObras,
	  SUM(inversionTotal * CASE tipoMoneda WHEN 'MDP' THEN 1 WHEN 'MDD' THEN inValorDolar END) AS totalInvertido
    FROM resultados
    GROUP BY nombreEstado;

    SELECT
      count(*)            AS numeroObras,
	  SUM(inversionTotal * CASE tipoMoneda WHEN 'MDP' THEN 1 WHEN 'MDD' THEN inValorDolar END) AS totalInvertido
    FROM resultados;


    DROP TABLE resultados;


  END