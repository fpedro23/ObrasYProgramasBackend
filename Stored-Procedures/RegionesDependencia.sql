-- Procedimiento que entregara las regiones que estan asignadas a una dependencia.

use dbobras;
select 
	GROUP_CONCAT(DISTINCT e.nombreEstado) AS nombreRegion,
	GROUP_CONCAT(DISTINCT d.nombreDependencia) AS nombreDependencia
    
from
		dependencias d
	JOIN dependencia_has_region
		ON d.idDependencia = dependencia_has_region.idDependencia
	JOIN
		estados e
        ON dependencia_has_region.idEstado = e.idEstado
	JOIN estado_belongs_region
		ON e.idEstado = estado_belongs_region.idRegion
WHERE d.idDependencia = 2;
