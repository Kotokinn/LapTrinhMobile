package com.example.myapplication.chuong4.baitap;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

public class Chuong4_BaiTap6_AnswerButton extends AppCompatButton {

    private boolean isCorrect;

    public Chuong4_BaiTap6_AnswerButton(Context context, boolean isCorrect) {
        super(context);
        this.isCorrect = isCorrect;
        setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        if (isCorrect) Toast.makeText(getContext(), "Đúng!", Toast.LENGTH_SHORT).show();
        if (!isCorrect) Toast.makeText(getContext(), "Sai!", Toast.LENGTH_SHORT).show();
    }

}
