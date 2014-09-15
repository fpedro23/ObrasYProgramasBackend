-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=``@`` PROCEDURE `generarFichaTecnicaObra`(inIdObra VARCHAR(15))
BEGIN
	CALL consultarFichaTecnica(inIdObra);
	CALL consultarDatosObrasInversion(inIdObra);
	CALL consultarDatosObrasClasificacion(inIdObra);
END