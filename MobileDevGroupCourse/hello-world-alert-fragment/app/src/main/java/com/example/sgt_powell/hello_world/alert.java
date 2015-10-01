package com.example.sgt_powell.hello_world;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by SGT_POWELL on 9/27/2015.
 */
public class alert extends DialogFragment {

    String hello="Hello World!";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       builder.setTitle("Hi There!");
        builder.setMessage(hello);
        builder.setCancelable(true);

        Dialog dialog = builder.create();


        return dialog;
    }
}
