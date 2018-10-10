package sample;

import java.util.Date;

public class log {
    private int logId;
    private int userId;
    private Date date;
    private String description;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
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

    public log(int logId, int userId, Date date, String description) {

        this.logId = logId;
        this.userId = userId;
        this.date = date;
        this.description = description;
    }
}
