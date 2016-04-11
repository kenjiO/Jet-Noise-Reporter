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

    public String getEmailText() {
        if (this.user == null) {
            return "User has not been set";
        }
        String emailText =
                "Personal Information:\n" +
                        "   Name :" + this.user.getName() + "\n" +
                        "   Address :" + this.user.getAddress() + "\n" +
                        "   City :" + this.user.getCity() + "\n" +
                        "   Zip Code :" + this.user.getZipcode() + "\n" +
                        "   Phone :" + this.user.getPhone() + "\n" +
                        "   Email :" + this.user.getEmail() + "\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        return emailText;
    }
}
