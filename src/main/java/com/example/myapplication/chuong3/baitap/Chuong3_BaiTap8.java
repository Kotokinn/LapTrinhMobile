package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap8 extends AppCompatActivity {
    EditText edtFullName, edtEmail;
    RadioButton rbNam, rbNu;
    DatePicker dtpkSelectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap8);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        edtFullName = findViewById(R.id.edt_full_name);
        edtEmail = findViewById(R.id.edt_email);
        rbNam = findViewById(R.id.rb_nam);
        rbNu = findViewById(R.id.rb_nu);
        dtpkSelectDate = findViewById(R.id.dtpk_select_date);
    }
}