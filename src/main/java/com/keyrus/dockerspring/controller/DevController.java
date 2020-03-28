package com.keyrus.dockerspring.controller;

import com.keyrus.dockerspring.data.DevData;
import com.keyrus.dockerspring.form.DevListData;
import com.keyrus.dockerspring.service.DevService;
import com.keyrus.dockerspring.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev")
public class DevController {

    @Value(value = "${kafka.topic}")
    private String topicName;

    @Autowired
    private DevService devService;

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/all")
    @ResponseBody
    public DevListData getAllDevs() {
        return devService.getAll();
    }

    @PostMapping(value = "/save")
    public HttpStatus saveDev(@RequestBody DevData devData) {
        try {
            devService.save(devData);
            return HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e);
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PostMapping(value = "/kafka")
    public HttpStatus sendKafka(@RequestBody DevData devData) {
        try {
            kafkaService.sendMessage(topicName, devData);
            return HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e);
            return HttpStatus.BAD_REQUEST;
        }
    }

}
