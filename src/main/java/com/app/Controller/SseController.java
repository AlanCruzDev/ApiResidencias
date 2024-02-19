package com.app.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.app.Entity.Usuario;


import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;



@RestController
public class SseController {
	
    private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    
 
    
    @GetMapping(path = "/notifications", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getNotifications() {
        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> {
            emitters.remove(emitter);
            emitter.complete();
        });

        return emitter;
    }
    
   

    
    public void sendLoginNotification(Usuario user) {
        String notificationMessage = "Usuario " + user.getNombre() + " ha iniciado sesión.";
        emitters.forEach(emitter -> {
            try {
                emitter.send(SseEmitter.event().id(user.getId().toString()).name("LOGIN_EVENT").data(notificationMessage, MediaType.TEXT_PLAIN));
            } catch (IOException e) {
                System.out.println("Error al enviar notificación: " + e.getMessage());
            }
        });
    } 


}
