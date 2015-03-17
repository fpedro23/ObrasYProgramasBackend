--
-- Dumping routines for database 'obrasyprogramas'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_del_cargo_inaugura` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_del_cargo_inaugura`(
  IN
  `p_idCargoInaugura`
  INT
)
  BEGIN
    DELETE FROM `cargo_inaugura`
    WHERE
      (`idCargoInaugura` = `p_idCargoInaugura`);
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_del_impactos` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_del_impactos`(
  IN
  `p_idImpacto`
  INT
)
  BEGIN
    DELETE FROM `impactos`
    WHERE
      (`idImpacto` = `p_idImpacto`);
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_del_tipo_clasificacion` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_del_tipo_clasificacion`(
  IN
  `p_idTipoClasificacion`
  INT
)
  BEGIN
    DELETE FROM `tipo_clasificacion`
    WHERE
      (`idTipoClasificacion` = `p_idTipoClasificacion`);
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ins_cargo_inaugura` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_ins_cargo_inaugura`(
  IN `p_nombreCargoInaugura` VARCHAR(100)
)
  BEGIN
    INSERT INTO `cargo_inaugura`
    (
      `nombreCargoInaugura`,
      `fecMod`
    )
    VALUES
      (
        `p_nombreCargoInaugura`,
        curdate()
      );
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ins_impactos` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_ins_impactos`(
  IN `p_nombreImpacto` VARCHAR(100)
)
  BEGIN
    INSERT INTO `impactos`
    (
      `nombreImpacto`,
      `fecMod`
    )
    VALUES
      (
        `p_nombreImpacto`,
        curdate()
      );
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ins_tipo_clasificacion` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_ins_tipo_clasificacion`(
  IN `p_nombreTipoClasificacion` VARCHAR(100),
  IN `p_clasificacionCorta`      VARCHAR(5)
)
  BEGIN
    INSERT INTO `tipo_clasificacion`
    (
      `nombreTipoClasificacion`,
      `clasificacionCorta`,
      `fecMod`
    )
    VALUES
      (
        `p_nombreTipoClasificacion`,
        `p_clasificacionCorta`,
        curdate()
      );
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sel_cargo_inaugura` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_sel_cargo_inaugura`()
  BEGIN
    SELECT
      `idCargoInaugura`,
      `nombreCargoInaugura`,
      `fecMod`
    FROM `cargo_inaugura`;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sel_impactos` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_sel_impactos`()
  BEGIN
    SELECT
      `idImpacto`,
      `nombreImpacto`,
      `fecMod`
    FROM `impactos`;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sel_tipo_clasificacion` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_sel_tipo_clasificacion`()
  BEGIN
    SELECT
      `idTipoClasificacion`,
      `nombreTipoClasificacion`,
      `clasificacionCorta`,
      `fecMod`
    FROM `tipo_clasificacion`;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_upd_cargo_inaugura` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_upd_cargo_inaugura`(
  IN `p_idCargoInaugura`     INT,
  IN `p_nombreCargoInaugura` VARCHAR(100)
)
  BEGIN
    UPDATE `cargo_inaugura`
    SET
      `nombreCargoInaugura` = `p_nombreCargoInaugura`,
      `fecMod`              = curdate()
    WHERE
      (`idCargoInaugura` = `p_idCargoInaugura`);
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_upd_impactos` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_upd_impactos`(
  IN `p_idImpacto`     INT,
  IN `p_nombreImpacto` VARCHAR(100)
)
  BEGIN
    UPDATE `impactos`
    SET
      `nombreImpacto` = `p_nombreImpacto`,
      `fecMod`        = curdate()
    WHERE
      (`idImpacto` = `p_idImpacto`);
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!50003 DROP PROCEDURE IF EXISTS `sp_upd_tipo_clasificacion` */;
/*!50003 SET @saved_cs_client = @@character_set_client */;
/*!50003 SET @saved_cs_results = @@character_set_results */;
/*!50003 SET @saved_col_connection = @@collation_connection */;
/*!50003 SET character_set_client = utf8 */;
/*!50003 SET character_set_results = utf8 */;
/*!50003 SET collation_connection = utf8_general_ci */;
/*!50003 SET @saved_sql_mode = @@sql_mode */;
/*!50003 SET sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
DELIMITER ;;
CREATE DEFINER =`root`@`localhost` PROCEDURE `sp_upd_tipo_clasificacion`(
  IN `p_idTipoClasificacion`     INT,
  IN `p_nombreTipoClasificacion` VARCHAR(100),
  IN `p_clasificacionCorta`      VARCHAR(5)
)
  BEGIN
    UPDATE `tipo_clasificacion`
    SET
      `nombreTipoClasificacion` = `p_nombreTipoClasificacion`,
      `clasificacionCorta`      = `p_clasificacionCorta`,
      `fecMod`                  = curdate()
    WHERE
      (`idTipoClasificacion` = `p_idTipoClasificacion`);
  END ;;
DELIMITER ;
/*!50003 SET sql_mode = @saved_sql_mode */;
/*!50003 SET character_set_client = @saved_cs_client */;
/*!50003 SET character_set_results = @saved_cs_results */;
/*!50003 SET collation_connection = @saved_col_connection */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER =``@`` PROCEDURE `sp_del_tipo_inversion`(
  IN
  `p_idTipoInversion`
  INT
)
  BEGIN
    DELETE FROM `tipo_inversion`
    WHERE
      (`idTipoInversion` = `p_idTipoInversion`);
  END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
    DELIMITER $$

CREATE DEFINER =``@`` PROCEDURE `sp_del_usuarios`(
  IN
  `p_idUsuario`
  INT
)
  BEGIN
    DELETE FROM `usuarios`
    WHERE
      (`idUsuario` = `p_idUsuario`);
  END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
    DELIMITER $$

CREATE DEFINER =``@`` PROCEDURE `sp_ins_tipo_inversion`(
  IN `p_nombreTipoInv`  VARCHAR(100),
  IN `p_inversionCorta` VARCHAR(2)
)
  BEGIN
    INSERT INTO `tipo_inversion`
    (
      `nombreTipoInv`,
      `inversionCorta`,
      `fecMod`
    )
    VALUES
      (
        `p_nombreTipoInv`,
        `p_inversionCorta`,
        curdate()
      );
  END


-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
    DELIMITER $$

CREATE DEFINER =``@`` PROCEDURE `sp_ins_usuarios`(
  IN `p_nombreUsuario`   VARCHAR(100),
  IN `p_apellidoPaterno` VARCHAR(100),
  IN `p_apellidoMaterno` VARCHAR(100),
  IN `p_idDependencia`   INT,
  IN `p_idRol`           INT
)
  BEGIN
    INSERT INTO `usuarios`
    (
      `nombreUsuario`,
      `apellidoPaterno`,
      `apellidoMaterno`,
      `fecMod`,
      `idDependencia`,
      `idRol`
    )
    VALUES
      (
        `p_nombreUsuario`,
        `p_apellidoPaterno`,
        `p_apellidoMaterno`,
        curdate(),
        `p_idDependencia`,
        `p_idRol`
      );
  END


-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
    DELIMITER $$

CREATE DEFINER =``@`` PROCEDURE `sp_sel_usuarios`()
  BEGIN
    SELECT
      `idUsuario`,
      `nombreUsuario`,
      `apellidoPaterno`,
      `apellidoMaterno`,
      `idDependencia`,
      `idRol`
    FROM `usuarios`;
  END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
    DELIMITER $$

CREATE DEFINER =``@`` PROCEDURE `sp_upd_tipo_inversion`(
  IN `p_idTipoInversion` INT,
  IN `p_nombreTipoInv`   VARCHAR(100),
  IN `p_inversionCorta`  VARCHAR(2)
)
  BEGIN
    UPDATE `tipo_inversion`
    SET
      `nombreTipoInv`  = `p_nombreTipoInv`,
      `inversionCorta` = `p_inversionCorta`,
      `fecMod`         = curdate()
    WHERE
      (`idTipoInversion` = `p_idTipoInversion`);
  END

-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
    DELIMITER $$

CREATE DEFINER =``@`` PROCEDURE `sp_upd_usuarios`(
  IN `p_idUsuario`       INT,
  IN `p_nombreUsuario`   VARCHAR(100),
  IN `p_apellidoPaterno` VARCHAR(100),
  IN `p_apellidoMaterno` VARCHAR(100),
  IN `p_idDependencia`   INT,
  IN `p_idRol`           INT
)
  BEGIN
    UPDATE `usuarios`
    SET
      `nombreUsuario`   = `p_nombreUsuario`,
      `apellidoPaterno` = `p_apellidoPaterno`,
      `apellidoMaterno` = `p_apellidoMaterno`,
      `fecMod`          = curdate(),
      `idDependencia`   = `p_idDependencia`,
      `idRol`           = `p_idRol`
    WHERE
      (`idUsuario` = `p_idUsuario`);
  END


-- Dump completed on 2015-03-16 19:27:27
