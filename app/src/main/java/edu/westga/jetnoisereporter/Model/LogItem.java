package edu.westga.jetnoisereporter.Model;

import java.util.Date;

public class LogItem {
    private Date dateTime;
    private String activityDisturbed;

    public LogItem(Date dateTime, String activityDisturbed) {
        this.dateTime = dateTime;
        this.activityDisturbed = activityDisturbed;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public String getActivityDisturbed() {
        return this.activityDisturbed;
    }
}
