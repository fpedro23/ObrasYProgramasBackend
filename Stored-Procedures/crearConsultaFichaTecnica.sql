-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=``@`` PROCEDURE `consultarFichaTecnica`(inIdObra varchar(15))
BEGIN
    SELECT 
        idObra,
        nombreDependencia,
        nombreEstado,
        nombreMunicipio,
        denominacion,
        fechaInicio,
        fechaTermino,
        inversionTotal,
        nombrePobObj,
        totalBeneficiarios,
        nombreImpacto,
        descripcion
    FROM
        obras O
            JOIN
        tipo_obra ON O.idTipoObra = tipo_obra.idTipoObra
            JOIN
        municipios ON O.idMunicipio = municipios.idMunicipio
            JOIN
        estados ON O.idEstado = estados.idEstado
            JOIN
        poblacion_objetivo ON O.idPobObjetivo = poblacion_objetivo.idpoblacionObjetivo
            JOIN
        impactos ON O.idImpacto = impactos.idImpacto
            JOIN
        dependencias ON O.idDependencia = dependencias.idDependencia
            JOIN
        cargo_inaugura ON O.idcargoInaugura = cargo_inaugura.idCargoInaugura
	 WHERE idObra = inIdObra;
END