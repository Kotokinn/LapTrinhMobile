package com.example.myapplication.chuong4.baitap;

import android.app.Activity;
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

public class Chuong4_BaiTap8 extends Activity implements View.OnClickListener {

    private EditText eChiSoDau, eChiSoSau, eSoKWSuDung, eThanhTien, eVAT, eTotal;
    private Button btnTinh, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong4_bai_tap8);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        connectView();
        addEvents();
    }

    @Override
    public void onClick(View v) {
        double soKWSuDung = Double.parseDouble(eChiSoSau.getText().toString()) - Double.parseDouble(eChiSoDau.getText().toString());
        double result;
        double vat = 0.1;
        int donGia;
        if (v.equals(btnTinh)) {
            eSoKWSuDung.setText(String.valueOf(soKWSuDung));
            if (soKWSuDung < 100) donGia = 2000;
            else if (soKWSuDung >= 100 && soKWSuDung <= 200) donGia = 2500;
            else donGia = 3000;
            result = (soKWSuDung * donGia);
            eThanhTien.setText(String.valueOf(result));
            eVAT.setText(String.valueOf(result * vat));

            eTotal.setText(String.valueOf(result + result * vat));
        } else finish();


    }

    private void addEvents() {
        btnTinh.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    private void connectView() {
        eChiSoDau = (EditText) findViewById(R.id.C4_b8_eChiSoDau);
        eChiSoSau = (EditText) findViewById(R.id.C4_b8_eChiSoSau);
        eSoKWSuDung = (EditText) findViewById(R.id.C4_b8_soKWSuDung);
        eThanhTien = (EditText) findViewById(R.id.C4_b8_eThanhTien);
        eVAT = (EditText) findViewById(R.id.C4_b8_eVAT);
        eTotal = (EditText) findViewById(R.id.C4_b8_eTotal);

        btnExit = (Button) findViewById(R.id.C4_b8_btnExit);
        btnTinh = (Button) findViewById(R.id.C4_b8_btnTinh);
    }
}