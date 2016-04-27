package edu.westga.jetnoisereporter;

import java.util.ArrayList;
import java.util.List;

import edu.westga.jetnoisereporter.Model.LogItem;
import edu.westga.jetnoisereporter.Model.User;
import edu.westga.jetnoisereporter.database.JetNoiseDbInterface;

public class MockDb implements JetNoiseDbInterface{
    private User currentUser;

    @Override
    public void updateUser(User user) {
        this.currentUser = user;
    }

    @Override
    public User lookupUser() {
        return this.currentUser;
    }

    @Override
    public void clearUsers() {
    }

    @Override
    public void logReport(String activityDisturbed) {
    }


    @Override
    public List<LogItem> getReportLog() {
        return new ArrayList<LogItem>();
    }
}
