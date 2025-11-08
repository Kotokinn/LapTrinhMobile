package com.example.myapplication.chuong5.baitap;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong5_BaiTap1 extends AppCompatActivity {
    Button btnShowToast, btnExit;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong5_bai_tap1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        InitWidget();
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = Chuong5_BaiTap1.this;
                String msg = "Toast xin chao";
                int duration = Toast.LENGTH_LONG;
                toast = Toast.makeText(context, msg, duration);
                toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void InitWidget() {
        btnShowToast = (Button) findViewById(R.id.btnShowToast);
        btnExit = (Button) findViewById(R.id.btnExit);
    }
}