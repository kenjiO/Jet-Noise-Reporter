package edu.westga.jetnoisereporter.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public class ClearProfileYesNoDialog extends DialogFragment {

    public interface ClearProfileOkListener {
        void clearProfileOkSelected();
    }
    private ClearProfileOkListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Context context = getActivity();
        if (context instanceof ClearProfileOkListener) {
            this.listener = (ClearProfileOkListener) context;
        } else {
            this.dismiss();
        }

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("This will erase your current user profile")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ClearProfileYesNoDialog.this.listener.clearProfileOkSelected();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ClearProfileYesNoDialog.this.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

