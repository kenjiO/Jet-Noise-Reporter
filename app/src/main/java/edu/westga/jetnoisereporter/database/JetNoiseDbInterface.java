package edu.westga.jetnoisereporter.database;

import edu.westga.jetnoisereporter.Model.User;

public interface JetNoiseDbInterface {

    /**
     * Update the user profile stored in the DB. Create one if it does not exist.
     * Precondition: user != null
     * @param user User object holding the profile values
     */
    void updateUser(User user);

    /**
     * Get the user profile stored in the DB
     * @return The user profile or null if a user profile doesn't exists
     */
    User lookupUser();

    /**
     * Clears the user profile from the DB
     */
    void clearUsers();

    /**
     * Log a report item to the DB
     * @param activityDisturbed The activity disturbed or null to leave this out from the report
     */
    void logReport(String activityDisturbed);
}

