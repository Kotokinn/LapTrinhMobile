package com.example.myapplication.chuong4.baitap;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong4_BaiTap6 extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong4_bai_tap6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        layout = (LinearLayout) findViewById(R.id.c4_b6_l1);

        Chuong4_BaiTap6_AnswerButton btn1 = new Chuong4_BaiTap6_AnswerButton(this, true);
        btn1.setText("Hà Nội");

        Chuong4_BaiTap6_AnswerButton btn2 = new Chuong4_BaiTap6_AnswerButton(this, false);
        btn2.setText("TP.HCM");

        Chuong4_BaiTap6_AnswerButton btn3 = new Chuong4_BaiTap6_AnswerButton(this, false);
        btn3.setText("Đà Nẵng");

        layout.addView(btn1);
        layout.addView(btn2);
        layout.addView(btn3);

    }
}