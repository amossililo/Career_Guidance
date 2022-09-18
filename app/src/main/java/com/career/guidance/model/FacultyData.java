package com.career.guidance.model;

public class FacultyData {
    private String facultyName;
    private String facultyInfo;
    private Integer facultyImage;
    private String page;


    public FacultyData(String facultyName, String facultyInfo, Integer facultyImage, String page) {
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

    public Integer getFacultyImage() {
        return facultyImage;
    }

    public void setFacultyImage(Integer facultyImage) {
        this.facultyImage = facultyImage;
    }


}
