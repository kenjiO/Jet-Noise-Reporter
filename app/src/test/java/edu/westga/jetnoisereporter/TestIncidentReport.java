package edu.westga.jetnoisereporter;

import org.junit.Test;

import java.util.Date;

import edu.westga.jetnoisereporter.Model.IncidentReport;
import edu.westga.jetnoisereporter.Model.User;

import static org.junit.Assert.*;

public class TestIncidentReport {

    @Test
         public void testGetEmailTextForTypicalCase() {
        User user = new User("Ron Hill", "365 3rd Ave", "San Francisco", "94118", "415-422-8989", "ronhill@example.com");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :Ron Hill\n" +
                        "   Address :365 3rd Ave\n" +
                        "   City :San Francisco\n" +
                        "   Zip Code :94118\n" +
                        "   Phone :415-422-8989\n" +
                        "   Email :ronhill@example.com\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }

    @Test
    public void testGetEmailTextWhenLongName() {
        User user = new User("Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit", "365 3rd Ave", "San Francisco", "94118", "415-422-8989", "ronhill@example.com");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit\n" +
                        "   Address :365 3rd Ave\n" +
                        "   City :San Francisco\n" +
                        "   Zip Code :94118\n" +
                        "   Phone :415-422-8989\n" +
                        "   Email :ronhill@example.com\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }

    @Test
    public void testGetEmailTextWhenLongAddress() {
        User user = new User("Ron Hill", "Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit", "San Francisco", "94118", "415-422-8989", "ronhill@example.com");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :Ron Hill\n" +
                        "   Address :Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit\n" +
                        "   City :San Francisco\n" +
                        "   Zip Code :94118\n" +
                        "   Phone :415-422-8989\n" +
                        "   Email :ronhill@example.com\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }

    @Test
    public void testGetEmailTextWhenLongCity() {
        User user = new User("Ron Hill", "365 3rd Ave", "Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit", "94118", "415-422-8989", "ronhill@example.com");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :Ron Hill\n" +
                        "   Address :365 3rd Ave\n" +
                        "   City :Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit\n" +
                        "   Zip Code :94118\n" +
                        "   Phone :415-422-8989\n" +
                        "   Email :ronhill@example.com\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }

    @Test
    public void testGetEmailTextWhenLongZipcode() {
        User user = new User("Ron Hill", "365 3rd Ave", "San Francisco", "Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit", "415-422-8989", "ronhill@example.com");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :Ron Hill\n" +
                        "   Address :365 3rd Ave\n" +
                        "   City :San Francisco\n" +
                        "   Zip Code :Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit\n" +
                        "   Phone :415-422-8989\n" +
                        "   Email :ronhill@example.com\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }

    @Test
    public void testGetEmailTextWhenLongPhone() {
        User user = new User("Ron Hill", "365 3rd Ave", "San Francisco", "94118", "Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit", "ronhill@example.com");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :Ron Hill\n" +
                        "   Address :365 3rd Ave\n" +
                        "   City :San Francisco\n" +
                        "   Zip Code :94118\n" +
                        "   Phone :Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit\n" +
                        "   Email :ronhill@example.com\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }

    @Test
    public void testGetEmailTextWhenLongEmail() {
        User user = new User("Ron Hill", "365 3rd Ave", "San Francisco", "94118", "415-422-8989", "Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :Ron Hill\n" +
                        "   Address :365 3rd Ave\n" +
                        "   City :San Francisco\n" +
                        "   Zip Code :94118\n" +
                        "   Phone :415-422-8989\n" +
                        "   Email :Krungthepmahanakhon Amonrattanakosin Mahintharayutthaya Mahadilokphop Noppharatratchathaniburirom Udomratchaniwetmahasathan Amonphimanawatansathit Sakkathattiyawitsanukamprasit\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }

    @Test
    public void testGetEmailTextWhenAllFieldsEmpty() {
        User user = new User("", "", "", "", "", "");
        IncidentReport report = new IncidentReport(user);
        String expected =
                "Personal Information:\n" +
                        "   Name :\n" +
                        "   Address :\n" +
                        "   City :\n" +
                        "   Zip Code :\n" +
                        "   Phone :\n" +
                        "   Email :\n" +
                        "Noise Event Information:\n" +
                        "   Disturbance Date and Time : " + (new Date()).toString() + "\n" +
                        "   Disturbance Type : Loud disturbance\n" +
                        "   Activity Disturbed :\n";
        assertEquals(expected, report.getEmailText());
    }
}
