package com.example.myapplication.chuong4.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong4_BaiTap7 extends AppCompatActivity implements View.OnClickListener {

    private EditText eName, eWeight, eHeight;
    private Button btnKT, btnTiep, btnThoat;
    private TextView tResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong4_bai_tap7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewConnect();
        addEvents();

    }

    @Override
    public void onClick(View v) {
        String name, result;
        double weight, height, BMI;
        if (v.equals(btnKT)) {
            name = eName.getText().toString();

            weight = Double.parseDouble(eWeight.getText().toString());

            height = Double.parseDouble(eHeight.getText().toString());
            BMI = weight / (height * height);

            if (BMI < 18) tResult.setText(String.format("Bạn %s gầy", name));
            else if (BMI < 24.9) tResult.setText(String.format("Bạn %s bình thường", name));
            else if (BMI < 29.9) tResult.setText(String.format("Bạn %s béo phì I", name));
            else if (BMI < 34.9) tResult.setText(String.format("Bạn %s béo phì II", name));
            else tResult.setText(String.format("Bạn %s béo phì III", name));

        } else if (v.equals(btnTiep)) {
            eName.setText("");
            eHeight.setText("");
            eWeight.setText("");
        } else if (v.equals(btnThoat)) {
            finish();
        }
    }

    void addEvents() {
        btnKT.setOnClickListener((View.OnClickListener) this);
        btnTiep.setOnClickListener((View.OnClickListener) this);
        btnThoat.setOnClickListener((View.OnClickListener) this);
    }

    private void viewConnect() {
        eName = (EditText) findViewById(R.id.c4_b7_eName);
        eWeight = (EditText) findViewById(R.id.c4_b7_eWeight);
        eHeight = (EditText) findViewById(R.id.c4_b7_eHeight);

        btnKT = (Button) findViewById(R.id.c4_b7_btnCheck);
        btnTiep = (Button) findViewById(R.id.c4_b7_btnNext);
        btnThoat = (Button) findViewById(R.id.c4_b7_btnExit);

        tResult = (TextView) findViewById(R.id.c4_b7_tResult);

    }
}