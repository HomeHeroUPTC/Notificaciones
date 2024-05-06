package com.notificaciones.repositories;

import com.notificaciones.models.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {

    List<Notificacion> findByFechaHoraNotificacionBeforeAndEnviadoPorCorreoIsFalse(Date fechaHoraNotificacion);
}

