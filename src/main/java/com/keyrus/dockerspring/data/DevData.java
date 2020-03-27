package com.keyrus.dockerspring.data;

public class DevData {

    private String name;
    private String language;
    private int age;

    public DevData(String name, String language, int age) {
        this.name = name;
        this.language = language;
        this.age = age;
    }

    public DevData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
