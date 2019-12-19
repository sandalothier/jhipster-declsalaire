package com.fisc.declsalaire.web.rest;

import com.fisc.declsalaire.service.DeclsalaireKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declsalaire-kafka")
public class DeclsalaireKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclsalaireKafkaResource.class);

    private DeclsalaireKafkaProducer kafkaProducer;

    public DeclsalaireKafkaResource(DeclsalaireKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
