package com.example.companyms.messaging;

import com.example.companyms.CompanyService;
import com.example.companyms.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {
    private final CompanyService companyService;

    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(ReviewMessage reviewMessage)
    {
        companyService.updateCompanyRating(reviewMessage);
    }
}
