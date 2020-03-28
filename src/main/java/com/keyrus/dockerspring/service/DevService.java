package com.keyrus.dockerspring.service;

import com.keyrus.dockerspring.converter.DevConverter;
import com.keyrus.dockerspring.dao.DevDao;
import com.keyrus.dockerspring.data.DevData;
import com.keyrus.dockerspring.form.DevListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DevService {

    @Autowired
    private DevDao devDao;

    public void save(DevData devData) {
        devDao.save(DevConverter.devFormConverter(devData));
    }

    public DevListData getAll() {
        return new DevListData(devDao.findAll().stream().map(DevConverter::devDataConverter).collect(Collectors.toList()));
    }

}
