package com.example.alertusingbroadcastrec;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

interface OnPositiveClickListener {
    void setText(String text);
}

public class DialogBox extends DialogFragment {

    private OnPositiveClickListener onPositiveClickListener;
    private Button butNegative, butPositive;
    private String inputNumber;
    private String outputNumber;

    DialogBox(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View diagView = inflater.inflate(R.layout.dialog_layout, null);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(diagView);
        butPositive = (Button) diagView.findViewById(R.id.butPositive);
        butNegative = (Button) diagView.findViewById(R.id.butNegative);

        butNegative.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "CANCELLED", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        butPositive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                outputCalculator(inputNumber);
                if (onPositiveClickListener != null)
                    onPositiveClickListener.setText(outputNumber);
                Toast.makeText(getContext(), "Text set !", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        AlertDialog dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    public void outputCalculator(String inputNumber) {
        Double x = Math.pow(Double.parseDouble(inputNumber), 2);
        outputNumber = x.toString();
    }

    public void setOnPositiveClickListener(OnPositiveClickListener onPositiveClickListener) {
        this.onPositiveClickListener = onPositiveClickListener;


    }
}
