package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap11 extends AppCompatActivity {
    TimePicker tpChooseTime;
    Button btnChooseTime;
    ImageView ivBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap11);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        tpChooseTime = findViewById(R.id.tp_choose_time);
        btnChooseTime = findViewById(R.id.btn_choose_time);
        ivBackground = findViewById(R.id.iv_background);

        tpChooseTime.setIs24HourView(true);
        btnChooseTime.setOnClickListener(handleChooseTime);
    }

    private View.OnClickListener handleChooseTime = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int hour = tpChooseTime.getHour();
            int minute = tpChooseTime.getMinute();

            if (hour >= 6 && hour <= 18) {
                ivBackground.setImageResource(R.drawable.sun);
                Toast.makeText(Chuong3_BaiTap11.this, "Troi sang", Toast.LENGTH_SHORT).show();
            } else {
                ivBackground.setImageResource(R.drawable.moon);
                Toast.makeText(Chuong3_BaiTap11.this, "Troi toi", Toast.LENGTH_SHORT).show();
            }
        }
    };
}