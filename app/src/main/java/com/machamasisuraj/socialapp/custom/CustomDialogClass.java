package com.machamasisuraj.socialapp.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.machamasisuraj.socialapp.R;

public class CustomDialogClass extends Dialog  {

    public Context c;
    public Dialog d;
    public Button yes, no;

    public CustomDialogClass(Context a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_alert_dialogbox);
        yes = findViewById(R.id.btn_yes);
        no = findViewById(R.id.btn_no);

    }

}