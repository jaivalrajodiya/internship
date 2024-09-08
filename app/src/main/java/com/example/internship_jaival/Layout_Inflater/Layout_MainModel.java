package com.example.internship_jaival.Layout_Inflater;

import java.util.ArrayList;

public class Layout_MainModel {

    String fakeEarningPoint;
    String packageInstallTrackingUrl;
    String pid;
    String offer_id;

    ArrayList<Layout_HomeDataModel> homeDataList;


    public Layout_MainModel(String fakeEarningPoint, String packageInstallTrackingUrl, String pid, String offer_id, ArrayList<Layout_HomeDataModel> homeDataList) {
        this.fakeEarningPoint = fakeEarningPoint;
        this.packageInstallTrackingUrl = packageInstallTrackingUrl;
        this.pid = pid;
        this.offer_id = offer_id;
        this.homeDataList = homeDataList;
    }

    public String getFakeEarningPoint() {
        return fakeEarningPoint;
    }

    public void setFakeEarningPoint(String fakeEarningPoint) {
        this.fakeEarningPoint = fakeEarningPoint;
    }

    public String getPackageInstallTrackingUrl() {
        return packageInstallTrackingUrl;
    }

    public void setPackageInstallTrackingUrl(String packageInstallTrackingUrl) {
        this.packageInstallTrackingUrl = packageInstallTrackingUrl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public ArrayList<Layout_HomeDataModel> getHomeDataList() {
        return homeDataList;
    }

    public void setHomeDataList(ArrayList<Layout_HomeDataModel> homeDataList) {
        this.homeDataList = homeDataList;
    }
}
