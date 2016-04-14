package edu.westga.jetnoisereporter;

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
}
