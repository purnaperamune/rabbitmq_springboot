package com.example.rabbitmq_springboot.consumer;

import com.example.rabbitmq_springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbiMQJsonConsumer {
    Logger LOGGER = (Logger) LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.jsonQueue.name}"})
    public void consumeJsonMessage(User user){
        LOGGER.info(String.format("JSON Message received -> %s", user.toString()));
    }
}
