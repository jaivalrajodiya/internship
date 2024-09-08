package com.example.internship_jaival.Layout_Inflater;

import java.util.ArrayList;

public class Layout_HomeDataModel {

    ArrayList<Layout_DataModel> data;


    String title;
    String type;
    String isViewAll;
    String isBorder;
    String screenNo;
    String bgColor;

    public Layout_HomeDataModel(ArrayList<Layout_DataModel> data, String title, String type, String isViewAll, String isBorder, String screenNo, String bgColor) {
        this.data = data;
        this.title = title;
        this.type = type;
        this.isViewAll = isViewAll;
        this.isBorder = isBorder;
        this.screenNo = screenNo;
        this.bgColor = bgColor;
    }

    public ArrayList<Layout_DataModel> getData() {
        return data;
    }

    public void setData(ArrayList<Layout_DataModel> data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsViewAll() {
        return isViewAll;
    }

    public void setIsViewAll(String isViewAll) {
        this.isViewAll = isViewAll;
    }

    public String getIsBorder() {
        return isBorder;
    }

    public void setIsBorder(String isBorder) {
        this.isBorder = isBorder;
    }

    public String getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(String screenNo) {
        this.screenNo = screenNo;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
