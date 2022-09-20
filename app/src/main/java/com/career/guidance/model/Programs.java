package com.career.guidance.model;

public class Programs {

// here i am taking only image url. and this is as integer because i am using it from drawable file.

    Integer itemId;
    Integer imageUrl;
    String programName;
    String nameOfHtmlFile;

    public Programs(Integer itemId, Integer imageUrl, String programName,String nameOfHtmlFile) {
        this.itemId = itemId;
        this.imageUrl = imageUrl;
        this.programName=programName;
        this.nameOfHtmlFile=nameOfHtmlFile;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setProgramName(String programName){
        this.programName=programName;
    }
    public String getProgramName(){return programName;}
    public String getNameOfHtmlFile(){return  nameOfHtmlFile;}
}
