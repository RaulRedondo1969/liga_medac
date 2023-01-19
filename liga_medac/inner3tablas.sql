select * from jugadores;
use liga_medac;
select demarcacion.id_demarcacion,
demarcacion.nombre_demarcacion,
jugadores.nombre
from demarcacion inner join detalles_jugadores_demarcacion
on demarcacion.id_demarcacion = detalles_jugadores_demarcacion.id_demarcacion
inner join jugadores on jugadores.id_jugadores = detalles_jugadores_demarcacion.id_jugadores


