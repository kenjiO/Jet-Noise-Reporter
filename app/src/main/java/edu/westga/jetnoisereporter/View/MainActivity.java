package edu.westga.jetnoisereporter.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import edu.westga.jetnoisereporter.Controller.JetNoiseAppController;
import edu.westga.jetnoisereporter.R;
import edu.westga.jetnoisereporter.database.JetNoiseAppDB;

public class MainActivity extends AppCompatActivity implements ClearProfileYesNoDialog.ClearProfileOkListener {
    private JetNoiseAppController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.controller = new JetNoiseAppController(new JetNoiseAppDB(this));
    }

    // Called by handler in xml
    public void startProfileActivity(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void startReportListActivity() {
        Intent intent = new Intent(this, ReportListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        this.showProfileOrMain();
        super.onResume();
    }

    public void onReportButtonClick(View v) {
        String subject = "Noise complaint";
        String[] to = new String[]{"kokamot1@my.westga.edu"};
        this.controller.setActivity(this.getSelectedActivity());
        String emailText = this.controller.getEmailText();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailText);
        startActivity(emailIntent);
        this.controller.logReport(this.getSelectedActivity());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update_profile) {
            this.startProfileActivity(null);
        }

        if (id == R.id.action_clear_profile) {
            this.showConfirmClearDialog();
        }

        if (id == R.id.action_view_logs) {
            this.startReportListActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void clearProfileOkSelected(){
        this.controller.clearProfile();
        this.showProfileOrMain();
        Toast toast = Toast.makeText(getApplicationContext(), "Profile cleared", Toast.LENGTH_SHORT);
        toast.show();
    };

    private void showProfileOrMain(){
        LinearLayout firstRunUI = (LinearLayout) findViewById(R.id.firstrun_container);
        LinearLayout mainUI = (LinearLayout) findViewById(R.id.main_layout);
        if (this.controller.getUser() == null) {
            firstRunUI.setVisibility(View.VISIBLE);
            mainUI.setVisibility(View.GONE);
        } else {
            firstRunUI.setVisibility(View.GONE);
            mainUI.setVisibility(View.VISIBLE);
        }
    }

    private String getSelectedActivity() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        return spinner.getSelectedItem().toString();
    }

    private void showConfirmClearDialog() {
        ClearProfileYesNoDialog confirmClearProfile = new ClearProfileYesNoDialog();
        confirmClearProfile.show(getFragmentManager(), null);
    }

}
