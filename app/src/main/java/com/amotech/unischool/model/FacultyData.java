package com.amotech.unischool.model;

public class FacultyData {
    private String facultyName;
    private String facultyInfo;
    private String facultyImage;
    private String page;


    public FacultyData(String facultyName, String facultyInfo, String facultyImage, String page) {
        this.facultyName = facultyName;
        this.facultyInfo = facultyInfo;
        this.facultyImage = facultyImage;
        this.page = page;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getFacultyName() {
        return facultyName;
    }



    public String getFacultyInfo() {
        return facultyInfo;
    }

    public void setFacultyInfo(String facultyInfo) {
        this.facultyInfo = facultyInfo;
    }

    public String getFacultyImage() {
        return facultyImage;
    }

    public void setFacultyImage(String facultyImage) {
        this.facultyImage = facultyImage;
    }


}
