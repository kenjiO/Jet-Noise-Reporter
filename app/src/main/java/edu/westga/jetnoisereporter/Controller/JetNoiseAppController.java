package edu.westga.jetnoisereporter.Controller;

import android.content.Context;
import edu.westga.jetnoisereporter.database.JetNoiseAppDB;

public class JetNoiseAppController {
    private JetNoiseAppDB db;

    public JetNoiseAppController(Context context) {
        db = new JetNoiseAppDB(context);
    }

    public long updateUser(String name, String address, String city, String zipcode,
                           String phone, String callerCode) {
        return db.updateUser(name, address, city, zipcode, phone, callerCode);
    }

    public String getUserName() {
        return db.lookupUser();
    }


}
