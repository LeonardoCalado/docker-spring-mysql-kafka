package com.keyrus.dockerspring.service;

import com.keyrus.dockerspring.data.DevData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaService {

    @Autowired
    private DevService devService;

    @Autowired
    private KafkaTemplate<String, DevData> kafkaTemplate;

    public void sendMessage(String topicName, DevData message) {
        ListenableFuture<SendResult<String, DevData>> future =
                kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, DevData>>() {

            @Override
            public void onSuccess(SendResult<String, DevData> result) {
                System.out.println("Success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Error");
            }
        });
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "docker_spring")
    public void listen(DevData devData) {
        devService.save(devData);
        System.out.println("Message: Name - " + devData.getName() + " | Language - " + devData.getLanguage() + " | Age - " + devData.getAge());
    }

}
