package com.ageng.belajar_springboot.helper;

public class BreadCrumbItem {
    private String name;
    private String url;

    public BreadCrumbItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}