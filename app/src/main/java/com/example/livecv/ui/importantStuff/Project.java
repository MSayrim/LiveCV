package com.example.livecv.ui.importantStuff;


import java.io.Serializable;

public class Project implements Serializable {
    private String projectName;
    private String projectTime;
    private Integer image;
    private String projectDetail;
    private Class projectAdress;



    public Project(String projectName, String projectTime, Integer image , String projeDetail, Class projectAdress) {
        this.projectName = projectName;
        this.projectTime = projectTime;
        this.image=image;
        this.projectDetail = projeDetail;
        this.projectAdress = projectAdress;
    }

    public String getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(String projectDetail) {
        this.projectDetail = projectDetail;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(String projectTime) {
        this.projectTime = projectTime;
    }
    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Class getProjectAdress() {
        return projectAdress;
    }

    public void setProjectAdress(Class projectAdress) {
        this.projectAdress = projectAdress;
    }
}
