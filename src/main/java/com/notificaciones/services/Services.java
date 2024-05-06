package com.notificaciones.services;

import com.notificaciones.models.Notificacion;
import com.notificaciones.repositories.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import  org.springframework.mail.javamail.JavaMailSender;
import java.util.List;
import java.util.Optional;

@Service
public class Services {

    @Autowired
    private NotificacionRepository repositoryNotificacion;

    public Notificacion createNotificacion(Notificacion notificacion) {
        return repositoryNotificacion.save(notificacion);
    }

    public Optional<Notificacion> updateNotificacion(int id, Notificacion notificacion) {
        if (!repositoryNotificacion.existsById(id)) {
            return Optional.empty();
        }
        notificacion.setId_notificacion(id);
        return Optional.of(repositoryNotificacion.save(notificacion));
    }

    public boolean deletedNotificacion(int id) {
        if (!repositoryNotificacion.existsById(id)) {
            return false;
        }
        repositoryNotificacion.deleteById(id);
        return true;
    }

    public List<Notificacion> getAllNotificaciones() {
        return repositoryNotificacion.findAll();
    }

    public Optional<Notificacion> getNotificacionById(int id) {
        return repositoryNotificacion.findById(id);
    }
}
