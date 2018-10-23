package main.java.iaulife.entity;

import java.util.Date;

public class News {
    private int userId;
    private int statusId;
    private int groupId;
    private Date date;
    private String description;
    private String author;

    public News(int userId, int statusId, int groupId, Date date, String description, String author) {
        this.userId = userId;
        this.statusId = statusId;
        this.groupId = groupId;
        this.date = date;
        this.description = description;
        this.author = author;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
