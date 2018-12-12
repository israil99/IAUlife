package iaulife.entity;

import java.util.Date;

public class Events {
    private int userId;
    private Date date;
    private String description;

    public Events(int userId, Date date, String description) {
        this.userId = userId;
        this.date = date;
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
