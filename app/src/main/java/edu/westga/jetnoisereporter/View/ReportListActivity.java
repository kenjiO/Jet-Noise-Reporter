package edu.westga.jetnoisereporter.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.westga.jetnoisereporter.Model.LogItem;
import edu.westga.jetnoisereporter.R;

public class ReportListActivity extends AppCompatActivity {
    private List<LogItem> logItems = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReportListItemAdapter listItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        listItemAdapter = new ReportListItemAdapter(logItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listItemAdapter);

        logItems.add(new LogItem(new Date(), "Dummy1"));
        logItems.add(new LogItem(new Date(), "Dummy2"));

        listItemAdapter.notifyDataSetChanged();
    }

}
