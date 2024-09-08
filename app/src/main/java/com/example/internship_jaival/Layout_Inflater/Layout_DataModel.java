package com.example.internship_jaival.Layout_Inflater;

public class Layout_DataModel {

    String id;
    String delay;
    String description;
    String entryDate;
    String icon;
    String points;
    String screenNo;
    String status;
    String title;
    String type;
    String url;

    String image;

    String displayImage;

    String jsonImage;

    public Layout_DataModel(String id, String delay, String description, String entryDate, String icon, String points, String screenNo, String status, String title, String type, String url, String image, String displayImage) {
        this.id = id;
        this.delay = delay;
        this.description = description;
        this.entryDate = entryDate;
        this.icon = icon;
        this.points = points;
        this.screenNo = screenNo;
        this.status = status;
        this.title = title;
        this.type = type;
        this.url = url;
        this.image = image;
        this.displayImage = displayImage;
    }

    public String getJsonImage() {
        return jsonImage;
    }

    public void setJsonImage(String jsonImage) {
        this.jsonImage = jsonImage;
    }

    public String getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(String displayImage) {
        this.displayImage = displayImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(String screenNo) {
        this.screenNo = screenNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
