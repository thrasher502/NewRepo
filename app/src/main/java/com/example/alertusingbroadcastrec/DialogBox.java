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
    private Double calculatedNumber;
    private OnPositiveClickListener onPositiveClickListener;
    private Button butNegative, butPositive;
    private String input;

    void setOnPositiveClickListener(OnPositiveClickListener onPositiveClickListener) {
        this.onPositiveClickListener = onPositiveClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.dialog_layout, null);
        builder.setView(dialogView);
        butNegative = (Button) dialogView.findViewById(R.id.butNegative);
        butPositive = (Button) dialogView.findViewById(R.id.butPositive);

        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        butPositive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateNumber(input);
                Toast.makeText(getContext(), "Result set", Toast.LENGTH_SHORT).show();

                if (onPositiveClickListener != null)
                    onPositiveClickListener.setText(calculatedNumber.toString());
                dismiss();
            }
        });

        butNegative.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return alertDialog;
    }

    public void setInput(String input) {
        this.input = input;
    }

    private Double calculateNumber(String numberInput) {
        Double input = Double.parseDouble(numberInput);
        calculatedNumber = Math.pow(input, 2);
        return calculatedNumber;
    }
}