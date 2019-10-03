package com.example.alertusingbroadcastrec;

import android.content.Intent;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class DialogBox extends Dialog implements OnClickListener {
    protected Activity activity;
    protected String numberInput;
    protected Double calculatedNumber;
    protected Button butNegative, butPositive;

    public DialogBox(Activity activity, String numberInput) {
        super(activity);
        this.activity = activity;
        this.numberInput = numberInput;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        butNegative = (Button) findViewById(R.id.butNegative);
        butPositive = (Button) findViewById(R.id.butPositive);
        butPositive.setOnClickListener(this);
        butNegative.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butPositive:
                calculateNumber(numberInput);
                Intent i = new Intent("customBoxReceiver");
                i.putExtra("502",calculatedNumber.toString());
                getContext().sendBroadcast(i);
                dismiss();
                break;

            case R.id.butNegative:
                dismiss();
                break;
        }
    }

    private void calculateNumber(String numberInput) {
        Double input = Double.parseDouble(numberInput);
        calculatedNumber = Math.pow(input, 2);
    }
}