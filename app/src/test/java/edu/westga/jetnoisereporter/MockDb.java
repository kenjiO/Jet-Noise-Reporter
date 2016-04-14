package edu.westga.jetnoisereporter;

import edu.westga.jetnoisereporter.Model.User;
import edu.westga.jetnoisereporter.database.JetNoiseDbInterface;

public class MockDb implements JetNoiseDbInterface{
    private User currentUser;

    @Override
    public long updateUser(User user) {
        this.currentUser = user;
        return 0;
    }

    @Override
    public User lookupUser() {
        return this.currentUser;
    }
}
