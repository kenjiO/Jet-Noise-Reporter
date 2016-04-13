package edu.westga.jetnoisereporter.database;

import edu.westga.jetnoisereporter.Model.User;

public interface JetNoiseDbInterface {

    public long updateUser(User user);
    public User lookupUser() ;

}

