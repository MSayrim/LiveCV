package com.example.livecv.ui.importantStuff;

import java.io.Serializable;

public class Hobbies implements Serializable {
    private String hobbieName;
    private String hobbieDetail;
    private Integer hobbiePic;


    public Hobbies(String hobbieName, String hobbieDetail, Integer hobbiePic) {
        this.hobbieName = hobbieName;
        this.hobbieDetail = hobbieDetail;
        this.hobbiePic = hobbiePic;
    }

    public String getHobbieName() {
        return hobbieName;
    }

    public void setHobbieName(String hobbieName) {
        this.hobbieName = hobbieName;
    }

    public String getHobbieDetail() {
        return hobbieDetail;
    }

    public void setHobbieDetail(String hobbieDetail) {
        this.hobbieDetail = hobbieDetail;
    }

    public Integer getHobbiePic() {
        return hobbiePic;
    }

    public void setHobbiePic(Integer hobbiePic) {
        this.hobbiePic = hobbiePic;
    }
}
