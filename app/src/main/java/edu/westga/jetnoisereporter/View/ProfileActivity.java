package edu.westga.jetnoisereporter.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.westga.jetnoisereporter.Controller.JetNoiseAppController;
import edu.westga.jetnoisereporter.R;

public class ProfileActivity extends AppCompatActivity {
    private JetNoiseAppController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.controller = new JetNoiseAppController(this);
    }
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    public void onSubmitButtonClick(View v) {
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
            this.controller.updateUser(name, address, city, zipcode, phone, "code");
        }
    }


}
