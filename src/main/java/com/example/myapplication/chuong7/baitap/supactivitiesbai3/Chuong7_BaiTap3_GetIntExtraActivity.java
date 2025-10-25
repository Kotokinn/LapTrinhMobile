package com.example.myapplication.chuong7.baitap.supactivitiesbai3;

import android.annotation.SuppressLint;
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

public class Chuong7_BaiTap3_GetIntExtraActivity extends AppCompatActivity {

    TextView txtSTT;
    Button btnBackMain;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap3_get_int_extra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBackMain = (Button) findViewById(R.id.c7_b3_getInt_btnBackMain);
        txtSTT = (TextView) findViewById(R.id.c7_b3_getInt_txtSTT);

        Intent main = new Intent(this, Chuong7_BaiTap3.class);

        Intent intentStr = this.getIntent();
        String baseStr = "So Thu Tu: ";
        int stt = intentStr.getIntExtra("numSTT", 0);

        txtSTT.setText(baseStr + stt);


        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
            }
        });
    }
}