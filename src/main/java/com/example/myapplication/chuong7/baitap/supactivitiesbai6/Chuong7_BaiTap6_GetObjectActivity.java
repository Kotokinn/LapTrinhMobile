package com.example.myapplication.chuong7.baitap.supactivitiesbai6;

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
import com.example.myapplication.chuong7.baitap.Chuong7_BaiTap6;
import com.example.myapplication.chuong7.baitap.Chuong7_BaiTap6_ObjectMonHoc;

public class Chuong7_BaiTap6_GetObjectActivity extends AppCompatActivity {

    TextView txtTenMonHoc, txtGiaTien;
    Button btnBackMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap6_get_object);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBackMain = (Button) findViewById(R.id.c7_b6_getObj_btnBackMain);
        txtTenMonHoc = (TextView) findViewById(R.id.c7_b6_txtTenMonHoc);
        txtGiaTien = (TextView) findViewById(R.id.c7_b6_txtGiaTien);

        Intent main = new Intent(this, Chuong7_BaiTap6.class);
        Intent objIntent = this.getIntent();

        Chuong7_BaiTap6_ObjectMonHoc monHoc = (Chuong7_BaiTap6_ObjectMonHoc) objIntent.getSerializableExtra("objMonHoc");
        txtTenMonHoc.setText("Ten Mon Hoc: " + monHoc.getTenMonHoc());
        txtGiaTien.setText("Gia Tien: " + monHoc.getGiaTien());

        btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
            }
        });
    }
}