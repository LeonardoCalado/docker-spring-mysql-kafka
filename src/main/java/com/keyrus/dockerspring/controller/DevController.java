package com.keyrus.dockerspring.controller;

import com.keyrus.dockerspring.data.DevData;
import com.keyrus.dockerspring.form.DevListData;
import com.keyrus.dockerspring.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev")
public class DevController {

    @Autowired
    private DevService devService;

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
            return HttpStatus.BAD_REQUEST;
        }
    }


}
