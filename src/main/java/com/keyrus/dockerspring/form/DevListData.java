package com.keyrus.dockerspring.form;

import com.keyrus.dockerspring.data.DevData;

import java.util.List;

public class DevListData {

    private List<DevData> devList;

    public DevListData(List<DevData> devList) {
        this.devList = devList;
    }

    public DevListData() {
    }

    public List<DevData> getDevList() {
        return devList;
    }

    public void setDevList(List<DevData> devList) {
        this.devList = devList;
    }
}
