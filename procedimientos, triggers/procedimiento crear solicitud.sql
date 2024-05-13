CREATE PROCEDURE crear_solicitud (in activ varchar(50), in tipo_activ varchar(25), in previsto tinyint, in transp tinyint, in coment_transp varchar(80), in fini date, in ffin date, in hini time, in hfin time, in alojam tinyint, comen_alojam varchar(80), in idsol int(11))
BEGIN

if((select activo from profesores where idProgesores = idsol) = true) then

	if((select ocupacion from profesores where idProgesores = idsol) in ('superusuario', 'administrador')) then
    
		insert into solicitudes (idSolicitud, tipo_actividad, requiere_transporte, comentario_transporte, finicio, ffinal, hora_inicio, hora_fin, alojamiento, comentario_alojamiento, comentarios_adicionales) 
		values (activ, tipo_activ, previsto, transp, coment_transp, fini, ffin, hini, hfin, alojam, coment_alojam);
        
	end if;
end if;
 

END
