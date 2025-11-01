package com.example.myapplication.chuong7.baitap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.chuong7.baitap.supactivitiesbai5.Chuong7_BaiTap5_GetStringArray;

public class Chuong7_BaiTap5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnSendArray = (Button) findViewById(R.id.btnSendStringArray);
        btnSendArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSendStringArray = new Intent(Chuong7_BaiTap5.this, Chuong7_BaiTap5_GetStringArray.class);
                String[] ArrayKhoaHoc = {"Lập trình Android Cơ Bản", "Lập trình Android Nâng Cao", "Lập Trình C#", "QUảng cáo FaceBook", "Quảng cáo Google Android"};
                intentSendStringArray.putExtra("Khoahoc", ArrayKhoaHoc);
                startActivity(intentSendStringArray);
            }
        });
    }
}