-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=``@`` PROCEDURE `buscarObras`(
inTipoObra TEXT,
inDependencia int,
inEstado int,
inMunicipio int,
inRangoInversionMin DOUBLE,
inRangoInversionMax DOUBLE,
inFechaInicio date,
inFechaTermino date,
inImpacto int,
inCargoInaugura int

)
BEGIN
select inTipoObra;
SELECT
*
FROM
obras O
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

WHERE



(inTipoObra Is Null OR FIND_IN_SET(O.idTipoObra, inTipoObra)>0)AND




(inDependencia Is Null OR inDependencia = O.idDependencia)AND
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

;
END