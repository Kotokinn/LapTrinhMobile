package com.example.myapplication.chuong7.baitap.supactivitiesbai3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.chuong7.baitap.Chuong7_BaiTap3;

public class Chuong7_BaiTap3_GetStringAndIntExtraActivity extends AppCompatActivity {

    TextView txtSTT, txtHoTen;
    Button btnBackMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap3_get_string_and_int_extra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBackMain = (Button) findViewById(R.id.c7_b3_getStrAndInt_btnBackMain);
        txtSTT = (TextView) findViewById(R.id.c7_b3_getStrAndInt_txtSTT);
        txtHoTen = (TextView) findViewById(R.id.c7_b3_getStrAndInt_txtHoTen);

        Intent intentStrAndInt = this.getIntent();
        String baseStr = "Ho Va Ten: ";
        String baseInt = "So Thu Tu: ";
        int stt = intentStrAndInt.getIntExtra("numSTT", 0);
        String HoTen = intentStrAndInt.getStringExtra("strHoTen");

        txtSTT.setText(baseInt + stt);
        txtHoTen.setText(baseStr + HoTen);

        Intent main = new Intent(this, Chuong7_BaiTap3.class);

        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
            }
        });
    }
}