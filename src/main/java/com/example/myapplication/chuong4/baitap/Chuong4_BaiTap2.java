package com.example.myapplication.chuong4.baitap;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong4_BaiTap2 extends AppCompatActivity {

    TextView txtCount;
    int count = 1;
    Button btnCong,btnTru;


    int countFunc(int value){
        return count+=value;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong4_bai_tap2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtCount = (TextView)findViewById(R.id.textView13);
        btnCong = (Button)findViewById(R.id.btnCong);
        btnTru = (Button)findViewById(R.id.btnTru);

        btnCong.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCount.setText(String.valueOf(countFunc(1)));
            }
        });

        btnTru.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCount.setText(String.valueOf(countFunc(-1)));
            }
        });
    }

}