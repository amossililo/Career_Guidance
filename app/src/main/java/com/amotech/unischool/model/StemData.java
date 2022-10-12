package com.amotech.unischool.model;

public class StemData {
    private String stemName;
    private String stemInfo;
    private Integer stemImage;
    private String page;

    public StemData(String stemName, String stemInfo, Integer stemImage, String page) {
        this.stemName = stemName;
        this.stemInfo = stemInfo;
        this.stemImage = stemImage;
        this.page = page;
    }

    public String getStemName() {
        return stemName;
    }

    public String getStemInfo() {
        return stemInfo;
    }

    public Integer getStemImage() {
        return stemImage;
    }

    public String getPage() {
        return page;
    }
}
