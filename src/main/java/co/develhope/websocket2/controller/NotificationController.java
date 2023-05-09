package co.develhope.websocket2.controller;

import co.develhope.websocket2.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/broadcast-message")
    public ResponseEntity broadcastMessage(@RequestBody MessageDTO messageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/broadcast",messageDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PostMapping("/client-message")
    public ResponseEntity clientMessage(@RequestBody MessageDTO messageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/broadcast", messageDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}