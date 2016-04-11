package edu.westga.jetnoisereporter.Model;

import java.util.Date;

public class IncidentReport {
    private User user;

    public IncidentReport(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        this.user = user;
    }

    public String getEmailText(User user) {
        String emailText =
                "Personal Information:\n" +
                        "   Name :" + user.getName() + "\n" +
                        "   Address :" + user.getAddress() + "\n" +
                        "   City :" + user.getCity() + "\n" +
                        "   Zip Code :" + user.getZipcode() + "\n" +
                        "   Phone :" + user.getPhone() + "\n" +
                        "   Email :" + user.getEmail() + "\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        return emailText;
    }
}
