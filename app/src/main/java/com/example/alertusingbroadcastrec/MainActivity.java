package com.example.alertusingbroadcastrec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


public class MainActivity extends FragmentActivity {
    private Button button;
    FragmentManager fManager = getSupportFragmentManager();
    private EditText numberInput;
    private TextView act1TextV1;
    DialogBox dialogBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        numberInput = (EditText) findViewById(R.id.numberInput);
        act1TextV1 = (TextView) findViewById(R.id.act1TextV1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox = new DialogBox();
                dialogBox.setInput(numberInput.getText().toString());
                dialogBox.show(fManager, null);
                dialogBox.setOnPositiveClickListener(new OnPositiveClickListener() {
                    @Override
                    public void setText(String text) {
                        act1TextV1.setText(text);
                    }
                });
            }
        });
    }
}

