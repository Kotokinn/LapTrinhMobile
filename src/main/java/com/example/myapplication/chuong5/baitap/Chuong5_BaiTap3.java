package com.example.myapplication.chuong5.baitap;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong5_BaiTap3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong5_bai_tap3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnThoat = (Button) findViewById(R.id.btnShowId);

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogXacNhan();
            }
        });
    }

    private void DialogXacNhan() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Xac nhan?");
        dialog.setContentView(R.layout.custom_dialog);
        Button btnDongY = (Button) dialog.findViewById(R.id.btnDongYId);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuyId);

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}