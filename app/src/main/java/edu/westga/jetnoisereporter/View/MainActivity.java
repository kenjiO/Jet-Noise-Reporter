package edu.westga.jetnoisereporter.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


import edu.westga.jetnoisereporter.Controller.JetNoiseAppController;
import edu.westga.jetnoisereporter.R;

public class MainActivity extends AppCompatActivity {
    private JetNoiseAppController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.controller = new JetNoiseAppController(this);
    }

    public void startProfileActivity(View v) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        this.showProfileOrMain();
        super.onResume();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showProfileOrMain(){
        LinearLayout firstRunUI = (LinearLayout) findViewById(R.id.firstrun_container);
        LinearLayout mainUI = (LinearLayout) findViewById(R.id.main_layout);
        if (this.controller.getUserName() == null) {
            firstRunUI.setVisibility(View.VISIBLE);
            mainUI.setVisibility(View.GONE);

        } else {
            firstRunUI.setVisibility(View.GONE);
            mainUI.setVisibility(View.VISIBLE);
        }
    }
}
