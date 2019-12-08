package org.csc.auctionsniper.web.rest;

import org.csc.auctionsniper.service.AuctionsniperKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auctionsniper-kafka")
public class AuctionsniperKafkaResource {

    private final Logger log = LoggerFactory.getLogger(AuctionsniperKafkaResource.class);

    private AuctionsniperKafkaProducer kafkaProducer;

    public AuctionsniperKafkaResource(AuctionsniperKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
