package com.example.myapplication.chuong7.baitap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.chuong7.baitap.supactivitiesbai4.Chuong7_BaiTap4_SupActivity;

public class Chuong7_BaiTap4 extends AppCompatActivity {
    EditText edUser, edPass;
    Button btnlogin, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bait_tap4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        edUser = (EditText) findViewById(R.id.etUser);
        edPass = (EditText) findViewById(R.id.etPass);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edUser.getText().toString();
                String pass = edPass.getText().toString();
                Intent intentMainActivity = new Intent(Chuong7_BaiTap4.this, Chuong7_BaiTap4_SupActivity.class);
                if (user.equals("admin") && pass.equals("123")) {
                    startActivity(intentMainActivity);
                } else {
                    Toast.makeText(Chuong7_BaiTap4.this, "Sai username hoặc mật khâu", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}