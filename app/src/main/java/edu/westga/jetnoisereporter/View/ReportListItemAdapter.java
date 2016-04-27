package edu.westga.jetnoisereporter.View;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.westga.jetnoisereporter.Model.LogItem;
import edu.westga.jetnoisereporter.R;

public class ReportListItemAdapter extends RecyclerView.Adapter<ReportListItemAdapter.ReportItemViewHolder> {
    private List<LogItem> logItems;

    public class ReportItemViewHolder extends RecyclerView.ViewHolder {
        public TextView dateTime;
        public TextView activityDisturbed;

        public ReportItemViewHolder(View view) {
            super(view);
            dateTime = (TextView) view.findViewById(R.id.dateTime);
            activityDisturbed = (TextView) view.findViewById(R.id.activityDisturbed);
        }
    }

    public ReportListItemAdapter(List<LogItem> logItems) {
        this.logItems = logItems;
    }

    @Override
    public ReportItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.report_list_item, parent, false);
        return new ReportItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReportItemViewHolder holder, int position) {
        LogItem item = logItems.get(position);
        DateFormat df = new SimpleDateFormat("EEE, MMM d  hh:mm aaa");
        holder.dateTime.setText(df.format(item.getDateTime()));
        holder.activityDisturbed.setText("Activity Disturbed: " + item.getActivityDisturbed());
    }

    @Override
    public int getItemCount() {
        return logItems.size();
    }


}
