-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=``@`` PROCEDURE `consultarDatosObrasInversion`(inIdObra varchar(100))
BEGIN
    SELECT 
        obras.idObra, nombreTipoInv
    FROM
        obras
            JOIN
        detalle_inversion ON obras.idObra = detalle_inversion.idObra
            JOIN
        tipo_inversion ON detalle_inversion.idTipoInversion = tipo_inversion.idTipoInversion
    WHERE
        obras.idObra = inIdObra;
END