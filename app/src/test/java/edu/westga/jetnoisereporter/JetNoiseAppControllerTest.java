package edu.westga.jetnoisereporter;

import org.junit.Test;

import java.util.Date;

import edu.westga.jetnoisereporter.Controller.JetNoiseAppController;
import edu.westga.jetnoisereporter.Model.IncidentReport;
import edu.westga.jetnoisereporter.Model.User;

import static org.junit.Assert.*;

public class JetNoiseAppControllerTest {

    @Test
    public void testUpdateUserSetsName() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        User user = controller.getUser();
        assertEquals("Brad Davis", controller.getUser().getName());
    }

    @Test
    public void testUpdateUserSetsAddress() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        User user = controller.getUser();
        assertEquals("562 Broad St", controller.getUser().getAddress());
    }

    @Test
    public void testUpdateUserSetCity() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        User user = controller.getUser();
        assertEquals("Daly City", controller.getUser().getCity());
    }

    @Test
    public void testUpdateUserSetsZipcode() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        User user = controller.getUser();
        assertEquals("94224", controller.getUser().getZipcode());
    }

    @Test
    public void testUpdateUserSetsPhone() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        User user = controller.getUser();
        assertEquals("650-236-6633", controller.getUser().getPhone());
    }

    @Test
    public void testUpdateUserSetsEmail() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        User user = controller.getUser();
        assertEquals("brad@example.com", controller.getUser().getEmail());
    }

    @Test
    public void testUpdateUserThrowsExceptionWhenNameNull() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        try {
            controller.updateUser(null, "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
            fail("IllegalArgumentException should have been thrown for null parameter");
        } catch (IllegalArgumentException ex) {}
    }

    @Test
    public void testUpdateUserThrowsExceptionWhenAddressNull() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        try {
            controller.updateUser("Brad Davis", null, "Daly City", "94224", "650-236-6633", "brad@example.com");
            fail("IllegalArgumentException should have been thrown for null parameter");
        } catch (IllegalArgumentException ex) {}
    }

    @Test
    public void testUpdateUserThrowsExceptionWhenCityNull() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        try {
            controller.updateUser("Brad Davis", "562 Broad St", null, "94224", "650-236-6633", "brad@example.com");
            fail("IllegalArgumentException should have been thrown for null parameter");
        } catch (IllegalArgumentException ex) {}
    }

    @Test
    public void testUpdateUserThrowsExceptionWhenZipcodeNull() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        try {
            controller.updateUser("Brad Davis", "562 Broad St", "Daly City", null, "650-236-6633", "brad@example.com");
            fail("IllegalArgumentException should have been thrown for null parameter");
        } catch (IllegalArgumentException ex) {}
    }

    @Test
    public void testUpdateUserThrowsExceptionWhenPhoneNull() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        try {
            controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", null, "brad@example.com");
            fail("IllegalArgumentException should have been thrown for null parameter");
        } catch (IllegalArgumentException ex) {}
    }

    @Test
    public void testUpdateUserThrowsExceptionWhenEmailNull() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        try {
            controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", null);
            fail("IllegalArgumentException should have been thrown for null parameter");
        } catch (IllegalArgumentException ex) {}
    }

    @Test
    public void testGetEmailTextProducesEmailWithCorrectData() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        String expected = "Personal Information:\n" +
                "   Name: Brad Davis\n" +
                "   Address: 562 Broad St\n" +
                "   City: Daly City\n" +
                "   Zip Code: 94224\n" +
                "   Phone: 650-236-6633\n" +
                "   Email: brad@example.com\n" +
                "Noise Event Information:\n" +
                "   Disturbance Date and Time: " + (new Date()).toString() + "\n" +
                "   Disturbance Type: Loud disturbance\n";
        assertEquals(expected, controller.getEmailText());
    }

    @Test
    public void testDisturbedActivityAddsTheInfoToTheEmail() {
        JetNoiseAppController controller = new JetNoiseAppController(new MockDb());
        controller.updateUser("Brad Davis", "562 Broad St", "Daly City", "94224", "650-236-6633", "brad@example.com");
        controller.setActivity("Sleeping");
        String expected = "Personal Information:\n" +
                "   Name: Brad Davis\n" +
                "   Address: 562 Broad St\n" +
                "   City: Daly City\n" +
                "   Zip Code: 94224\n" +
                "   Phone: 650-236-6633\n" +
                "   Email: brad@example.com\n" +
                "Noise Event Information:\n" +
                "   Disturbance Date and Time: " + (new Date()).toString() + "\n" +
                "   Disturbance Type: Loud disturbance\n" +
                "   Activity Disturbed: Sleeping\n";
        assertEquals(expected, controller.getEmailText());
    }



}
