package com.example.alertusingbroadcastrec;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;



public class MainActivity extends FragmentActivity {
    private EditText numberInput;
    private Button button;
    private TextView act1TextV1;
    private DialogBox dialogBox;
    private FragmentManager fM = getSupportFragmentManager();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        numberInput = (EditText) findViewById(R.id.numberInput);
        act1TextV1 = (TextView) findViewById(R.id.act1TextV1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox = new DialogBox(numberInput.getText().toString());
                dialogBox.show(fM, null);
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

