-- Procediimiento que entregara a un usuario con los permisos 
-- asignados asi como su region y sus estados.
USE dbobras;
SELECT
  u.nombreUsuario,
  u.apellidoPaterno,
  GROUP_CONCAT(DISTINCT p.nombrePermiso)      AS nombrePermiso,
  GROUP_CONCAT(DISTINCT p.descripcionPermiso) AS descripcionPermiso,
  e.nombreEstado                              AS nombreRegion,
  GROUP_CONCAT(DISTINCT f.nombreEstado)       AS nombreEstados,
  d.nombreDependencia

FROM usuarios u
  JOIN roles r
    ON u.idRol = r.idRol
  JOIN rol_has_permisos rhp
    ON r.idRol = rhp.idRol
  JOIN permisos p
    ON rhp.idPermiso = p.idPermiso
  JOIN estados e
    ON u.idEstado = e.idEstado
  JOIN estado_belongs_region
    ON e.idEstado = estado_belongs_region.idRegion
  JOIN estados f
    ON estado_belongs_region.idEstado = f.idEstado
  JOIN dependencias d
    ON u.idDependencia = d.idDependencia

GROUP BY u.nombreUsuario;

;