-- Procedimiento que entregara SOLAMENTE las regiones con la descripción de sus estados.

use dbobras;
select 
	e.nombreEstado AS nombreRegion,
	GROUP_CONCAT(DISTINCT f.nombreEstado) AS nombreEstados
from estados e
	JOIN estado_belongs_region
		ON e.idEstado = estado_belongs_region.idRegion
	JOIN estados f
		on estado_belongs_region.idEstado = f.idEstado
GROUP BY e.nombreEstado; 