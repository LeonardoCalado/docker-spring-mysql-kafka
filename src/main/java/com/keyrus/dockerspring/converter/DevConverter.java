package com.keyrus.dockerspring.converter;

import com.keyrus.dockerspring.data.DevData;
import com.keyrus.dockerspring.form.DevForm;
import org.springframework.stereotype.Component;

@Component
public class DevConverter {

    public static DevData devDataConverter(DevForm devForm) {
        DevData devData = new DevData();

        devData.setName(devForm.getName());
        devData.setLanguage(devForm.getLanguage());
        devData.setAge(devForm.getAge());

        return devData;
    }

    public static DevForm devFormConverter(DevData devData) {
        DevForm devForm = new DevForm();

        devForm.setName(devData.getName());
        devForm.setLanguage(devData.getLanguage());
        devForm.setAge(devData.getAge());

        return devForm;
    }

}
