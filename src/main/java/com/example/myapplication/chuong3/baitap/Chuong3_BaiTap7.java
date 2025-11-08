package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap7 extends AppCompatActivity {

    TextView txt_result_date;
    DatePicker dtpk_select_date;
    Button btn_confirm_select_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }

    private void initView() {
        txt_result_date = findViewById(R.id.txt_result_date);
        dtpk_select_date = findViewById(R.id.dtpk_select_date);
        btn_confirm_select_date = findViewById(R.id.btn_confirm_select_date);

        btn_confirm_select_date.setOnClickListener(confirmSelectDate);
    }

    private View.OnClickListener confirmSelectDate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            var day = dtpk_select_date.getDayOfMonth();
            var month = dtpk_select_date.getMonth();
            var year = dtpk_select_date.getYear();

            String result = "Bạn sinh vào ngày: " + "Ngày: " + day + ", Tháng: " + month + ", Năm: " + year;
            txt_result_date.setText(result);
        }
    };
}