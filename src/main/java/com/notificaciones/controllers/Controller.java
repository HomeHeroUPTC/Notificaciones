package com.notificaciones.controllers;

import com.notificaciones.models.Notificacion;
import com.notificaciones.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/homeHero-Notificaciones")
public class Controller {

    @Autowired
    private Services service;

    @GetMapping(value = "/notificaciones")
    public List<Notificacion> getAllUsuarios(){
        return service.getAllNotificaciones();
    }

    @GetMapping("/notificacion/{id}")
    public ResponseEntity<Notificacion> getNotificacionById(@PathVariable("id") int id) {
        Optional<Notificacion> notificacionById = service.getNotificacionById(id);
        return notificacionById.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/notificacion")
    public ResponseEntity<Notificacion> createNotificacion(@RequestBody Notificacion notificacion){
        Notificacion createNotificacion = service.createNotificacion(notificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createNotificacion);
    }

    @PutMapping("/notificacion/{id}")
    public ResponseEntity<Notificacion> updateNotificacion(@PathVariable("id") int id, @RequestBody Notificacion notificacion) {
        Optional<Notificacion> updateNotificacion = service.updateNotificacion(id, notificacion);
        return updateNotificacion.map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.noContent().build());
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> deletedNotificacionById(@PathVariable("id") int id){
        boolean deleted = service.deletedNotificacion(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
