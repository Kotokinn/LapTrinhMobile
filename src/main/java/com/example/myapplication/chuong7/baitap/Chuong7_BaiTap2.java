package com.example.myapplication.chuong7.baitap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong7_BaiTap2 extends AppCompatActivity {

    ImageButton btnCall, btnExpress, btnMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnExpress = (ImageButton) findViewById(R.id.c7_b2_btnExpress);
        btnCall = (ImageButton) findViewById(R.id.c7_b2_btnCall);
        btnMess = (ImageButton) findViewById(R.id.c7_b2_btnMess);

        btnMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mess = new Intent(Intent.ACTION_SENDTO);
                mess.setData(Uri.parse("sms:hello world"));
                startActivity(mess);
            }
        });

        btnExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent express = new Intent(Intent.ACTION_VIEW);
                express.setData(Uri.parse("https://vnexpress.net"));
                startActivity(express);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent();
                call.setAction(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:0999999999"));
                startActivity(call);
            }
        });

    }


}