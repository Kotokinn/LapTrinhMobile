package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap15 extends AppCompatActivity {
    Button btnDate, btnTime, btnRegister;
    TimePicker tpChooseTime;
    DatePicker dpChooseDate;
    EditText edtEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap15);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        btnDate = findViewById(R.id.btn_date);
        btnTime = findViewById(R.id.btn_time);
        btnRegister = findViewById(R.id.btn_register);
        tpChooseTime = findViewById(R.id.tp_choose_time);
        dpChooseDate = findViewById(R.id.dp_choose_date);
        edtEvent = findViewById(R.id.edt_event);

        tpChooseTime.setIs24HourView(true);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dpChooseDate.setVisibility(DatePicker.VISIBLE);
                tpChooseTime.setVisibility(TimePicker.GONE);
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dpChooseDate.setVisibility(DatePicker.GONE);
                tpChooseTime.setVisibility(TimePicker.VISIBLE);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String event = edtEvent.getText().toString();
                String date = dpChooseDate.getDayOfMonth() + "/" + (dpChooseDate.getMonth() + 1) + "/" + dpChooseDate.getYear();
                String time = tpChooseTime.getHour() + ":" + tpChooseTime.getMinute();

                Toast.makeText(Chuong3_BaiTap15.this, "Sự kiện: " + event + "Xảy ra vào " + date + " " + time, Toast.LENGTH_SHORT).show();
            }
        });
    }
}