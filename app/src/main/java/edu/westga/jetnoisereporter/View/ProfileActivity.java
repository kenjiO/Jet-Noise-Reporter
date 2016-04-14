package edu.westga.jetnoisereporter.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.westga.jetnoisereporter.Controller.JetNoiseAppController;
import edu.westga.jetnoisereporter.Model.User;
import edu.westga.jetnoisereporter.R;
import edu.westga.jetnoisereporter.database.JetNoiseAppDB;

public class ProfileActivity extends AppCompatActivity {
    private JetNoiseAppController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.controller = new JetNoiseAppController(new JetNoiseAppDB(this));
        this.populateForm();
    }

    public void onSubmitButtonClick(View v) {
        processForm();
    }

    private void processForm(){
        String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString().trim();
        String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString().trim();
        String  address = ((EditText) findViewById(R.id.streetEditText)).getText().toString().trim();
        String  city = ((EditText) findViewById(R.id.cityEditText)).getText().toString().trim();
        String  zipcode = ((EditText) findViewById(R.id.zipcodeEditText)).getText().toString().trim();
        String  phone = ((EditText) findViewById(R.id.phoneEditText)).getText().toString().trim();
        if (name.equals("") || address.equals("") || city.equals("") || zipcode.equals("")
                || phone.equals("") || email.equals("")) {
            Toast.makeText(ProfileActivity.this, "All fields must be entered", Toast.LENGTH_SHORT).show();
        } else {
            this.controller.updateUser(name, address, city, zipcode, phone, email);
            Toast toast = Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }

    private void populateForm() {
        User user = this.controller.getUser();
        if (user == null) {
            return;
        }
        ((EditText) findViewById(R.id.nameEditText)).setText(user.getName());
        ((EditText) findViewById(R.id.emailEditText)).setText(user.getEmail());
        ((EditText) findViewById(R.id.streetEditText)).setText(user.getAddress());
        ((EditText) findViewById(R.id.cityEditText)).setText(user.getCity());
        ((EditText) findViewById(R.id.zipcodeEditText)).setText(user.getZipcode());
        ((EditText) findViewById(R.id.phoneEditText)).setText(user.getPhone());
    }


}
