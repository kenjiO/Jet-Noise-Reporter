package edu.westga.jetnoisereporter.Controller;

import android.content.Context;

import edu.westga.jetnoisereporter.Model.IncidentReport;
import edu.westga.jetnoisereporter.Model.User;
import edu.westga.jetnoisereporter.database.JetNoiseDbInterface;

public class JetNoiseAppController {
    private JetNoiseDbInterface db;
    private User currentUser;

    public JetNoiseAppController(JetNoiseDbInterface db) {
        if (db == null) {
            throw new IllegalArgumentException("JetNoiseDbInterface object cannot be null");
        }
        this.db = db;
    }

    public void updateUser(String name, String address, String city, String zipcode,
                           String phone, String email) {
        User user = new User(name, address, city, zipcode, phone, email);
        if (name == null || address == null || city == null || zipcode == null
                || phone == null || email == null) {
            throw new IllegalArgumentException("All paramaters must not be null");
        }
        db.updateUser(user);
        this.currentUser = user;
    }

    public User getUser() {
        return this.currentUser = db.lookupUser();
    }

    public String getEmailText() {
        if (this.getUser() == null) {
            return "User Profile Not Loaded";
        }
        IncidentReport report = new IncidentReport(this.currentUser);
        return report.getEmailText();
    }


}
