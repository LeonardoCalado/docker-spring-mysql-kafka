package com.keyrus.dockerspring.form;

import javax.persistence.*;

@Entity
@Table(name = "developer")
public class DevForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String language;
    private int age;

    public DevForm(Long id, String name, String language, int age) {
        this.id  = id;
        this.name = name;
        this.language = language;
        this.age = age;
    }

    public DevForm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
