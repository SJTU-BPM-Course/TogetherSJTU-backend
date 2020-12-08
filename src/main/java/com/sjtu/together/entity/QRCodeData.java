package com.sjtu.together.entity;

import org.springframework.util.DigestUtils;

public class QRCodeData {
    int activityID;
    String md5;

    public QRCodeData(int activityID) {
        this.activityID = activityID;
        this.md5 = DigestUtils.md5DigestAsHex(String.valueOf(activityID).getBytes());
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
