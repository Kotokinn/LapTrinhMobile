package com.example.myapplication.chuong7.baitap;

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
import com.example.myapplication.chuong7.baitap.supactivitiesbai6.Chuong7_BaiTap6_GetObjectActivity;

import java.io.Serializable;

public class Chuong7_BaiTap6 extends AppCompatActivity {


    EditText eTenKhoaHoc, eHocPhi;
    Button btnSendObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        eTenKhoaHoc = (EditText) findViewById(R.id.c7_b6_eTenKhoaHoc);
        eHocPhi = (EditText) findViewById(R.id.c7_b6_eHocPhi);

        btnSendObj = (Button) findViewById(R.id.c7_b6_btnObject);

        btnSendObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chuong7_BaiTap6_ObjectMonHoc objectMonHoc = new Chuong7_BaiTap6_ObjectMonHoc(
                        eTenKhoaHoc.getText().toString(),
                        Integer.parseInt(eHocPhi.getText().toString()));
                Intent objIntent = new Intent(Chuong7_BaiTap6.this, Chuong7_BaiTap6_GetObjectActivity.class);
                objIntent.putExtra("objMonHoc", objectMonHoc);
                startActivity(objIntent);
            }
        });
    }
}