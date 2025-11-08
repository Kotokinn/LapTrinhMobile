package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.Locale;

public class Chuong3_BaiTap10 extends AppCompatActivity {
    Button btnConfirmSelectDate;
    DatePicker dtpkSelectDate;
    TimePicker tpChooseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap10);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        btnConfirmSelectDate = findViewById(R.id.btn_confirm_select_date);
        dtpkSelectDate = findViewById(R.id.dtpk_select_date);
        tpChooseTime = findViewById(R.id.tp_choose_time);

        // Set cho thời gian chọn là 24 giờ và chỉnh ngày giờ theo dd/mm/yyyy
        tpChooseTime.setIs24HourView(true);

        Locale locale = new Locale("vi");
        locale.setDefault(locale);

        btnConfirmSelectDate.setOnClickListener(handleSelectDate);
    }

    private View.OnClickListener handleSelectDate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String formattedDate = String.format(
                    "%02d/%02d/%04d",
                    dtpkSelectDate.getDayOfMonth(),
                    dtpkSelectDate.getMonth() + 1,
                    dtpkSelectDate.getYear()
            );

            String formattedTime = String.format(
                    "%02d:%02d",
                    tpChooseTime.getCurrentHour(),
                    tpChooseTime.getCurrentMinute()
            );

            Toast.makeText(Chuong3_BaiTap10.this, "Ngày: " + formattedDate + " - Giờ " + formattedTime, Toast.LENGTH_SHORT).show();
        }
    };
}