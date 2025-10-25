package com.example.myapplication.chuong7.baitap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.chuong7.baitap.supactivitiesbai3.Chuong7_BaiTap3_GetIntExtraActivity;
import com.example.myapplication.chuong7.baitap.supactivitiesbai3.Chuong7_BaiTap3_GetStringAndIntExtraActivity;
import com.example.myapplication.chuong7.baitap.supactivitiesbai3.Chuong7_BaiTap3_GetStringExtraActivity;

public class Chuong7_BaiTap3 extends AppCompatActivity {

    Button btnSendStr, btnSendInt, btnSendStrAndInt;

    EditText eHoTen, eSTT;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnSendInt = (Button) findViewById(R.id.c7_b3_btnSendInt);
        btnSendStr = (Button) findViewById(R.id.c7_b3_btnSendStr);
        btnSendStrAndInt = (Button) findViewById(R.id.c7_b3_btnSendStrAndInt);

        eHoTen = (EditText) findViewById(R.id.c7_b3_eHoTen);
        eSTT = (EditText) findViewById(R.id.c7_b3_eSTT);
/// ///////////////////////////////////////////////////////
        btnSendStrAndInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStrAndInt = new Intent(Chuong7_BaiTap3.this, Chuong7_BaiTap3_GetStringAndIntExtraActivity.class);
                intentStrAndInt.putExtra("strHoTen", eHoTen.getText().toString());
                intentStrAndInt.putExtra("numSTT", Integer.parseInt(eSTT.getText().toString()));
                startActivity(intentStrAndInt);
            }
        });
//        /////////////////////////////////////////////////
        btnSendStr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStr = new Intent(Chuong7_BaiTap3.this, Chuong7_BaiTap3_GetStringExtraActivity.class);
                intentStr.putExtra("strHoTen", eHoTen.getText().toString());
                startActivity(intentStr);
            }
        });
/// /////////////////////////////////////////////////
        btnSendInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInt = new Intent(Chuong7_BaiTap3.this, Chuong7_BaiTap3_GetIntExtraActivity.class);
                intentInt.putExtra("numSTT", Integer.parseInt(eSTT.getText().toString()));
                startActivity(intentInt);
            }
        });
    }
}