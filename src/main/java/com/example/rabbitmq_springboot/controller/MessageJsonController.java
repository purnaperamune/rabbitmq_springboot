package com.example.rabbitmq_springboot.controller;

import com.example.rabbitmq_springboot.dto.User;
import com.example.rabbitmq_springboot.publisher.RabbitMQJsonProducer;
import com.example.rabbitmq_springboot.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MessageJsonController {
    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("JSON Message sent to RabbitMQ!");
    }
}
