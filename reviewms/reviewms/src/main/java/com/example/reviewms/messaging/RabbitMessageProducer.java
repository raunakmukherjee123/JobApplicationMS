package com.example.reviewms.messaging;

import com.example.reviewms.Review;
import com.example.reviewms.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMessageProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review)
    {
        ReviewMessage reviewMessage=new ReviewMessage();

        reviewMessage.setCompanyId(review.getCompanyId());
        reviewMessage.setDescription(review.getDescription());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setTitle(review.getTitle());

        rabbitTemplate.convertAndSend(exchange,routingKey,reviewMessage);
    }
}
