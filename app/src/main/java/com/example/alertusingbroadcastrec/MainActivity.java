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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.util.Log;


public class MainActivity extends FragmentActivity {
    private EditText numberInput;
    private Button button;
    private TextView act1TextV1;
    private DialogBox dialogBox;
    private FragmentManager fM=getSupportFragmentManager();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        numberInput = (EditText)findViewById(R.id.numberInput);
        act1TextV1 = (TextView)findViewById(R.id.act1TextV1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox = new DialogBox(numberInput.getText().toString());
                dialogBox.show(fM,null);
                dialogBox.setOnPositiveClickListener(new OnPositiveClickListener() {
                    @Override
                    public void setText(String text) {
                        Log.i ("502", "onPos Click");
                        act1TextV1.setText(text);
                    }
                });

            }
        });
    }
}

