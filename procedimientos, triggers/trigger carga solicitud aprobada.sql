delimiter // 
drop trigger if exists aprobada//
create trigger aprobada after update on solicitudes for each row
begin 	
    if(old.estado = 'SOLICITADA' and new.estado = 'APROBADA') then
      insert into solicitudes_aprobadas (idSolicitud, tipo_actividad, requiere_transporte, comentario_transporte, finicio, ffinal, hora_inicio, hora_fin, alojamiento, comentario_alojamiento, comentarios_adicionales, estado, comentario_estado ) 
      values (new.idSolicitud, new.tipo_actividad,  new.requiere_transporte,  new.comentario_transporte,  new.finicio,  new.ffinal,  new.hora_inicio,  new.hora_fin,  new.alojamiento,  new.comentario_alojamiento,  new.comentarios_adicionales,  new.estado,  new.comentario_estado);
      end if;      
end//
delimiter ;