package com.example.administrator.listviewtest;

public class Person {

    private String img;//头像
    private String name;//人名
    private String intro;//个人介绍
    private String area;//来源地

    public Person(String img, String name, String intro, String area) {
        this.img = img;
        this.name = name;
        this.intro = intro;
        this.area = area;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

