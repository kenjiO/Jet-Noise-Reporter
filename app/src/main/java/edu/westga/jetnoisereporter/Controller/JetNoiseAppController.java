package edu.westga.jetnoisereporter.Controller;

import android.content.Context;

import edu.westga.jetnoisereporter.Model.IncidentReport;
import edu.westga.jetnoisereporter.Model.User;
import edu.westga.jetnoisereporter.database.JetNoiseAppDB;

public class JetNoiseAppController {
    private JetNoiseAppDB db;
    private User currentUser;

    public JetNoiseAppController(Context context) {
        db = new JetNoiseAppDB(context);
    }

    public void updateUser(String name, String address, String city, String zipcode,
                           String phone, String callerCode) {
        db.updateUser(name, address, city, zipcode, phone, callerCode);
        this.currentUser = this.getUser();
    }

    public User getUser() {
        return this.currentUser = db.lookupUser();
    }

    public String getEmailText() {
        if (this.getUser() == null) {
            return "User Profile Not Loaded";
        }
        IncidentReport report = new IncidentReport(this.currentUser);
        return report.getEmailText(this.currentUser);
    }


}
