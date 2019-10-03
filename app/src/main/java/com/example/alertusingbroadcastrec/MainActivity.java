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
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText numberInput;
    private TextView act1TextV1;
    DialogBox dialogBox;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle b = intent.getExtras();
            textViewSetter(b.getString("502"));
        }
    };

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
                dialogBox = new DialogBox(MainActivity.this, numberInput.getText().toString());
                dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogBox.show();
            }
        });
        registerReceiver(broadcastReceiver, new IntentFilter("customBoxReceiver"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (broadcastReceiver != null)
            unregisterReceiver(broadcastReceiver);
    }

    public void textViewSetter(String text) {
        this.act1TextV1.setText(text);
    }
}
