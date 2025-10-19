package com.example.myapplication.chuong4.baitap;

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

public class Chuong4_BaiTap9 extends AppCompatActivity {

    Button btnExec, btnExit, btnRemove;
    EditText eDuongLich, eReruslt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong4_bai_tap9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnExec = (Button) findViewById(R.id.c4_b9_btnExec);
        btnExit = (Button) findViewById(R.id.c4_b9_btnExit);
        btnRemove = (Button) findViewById(R.id.c4_b9_btnRemove);

        eReruslt = (EditText) findViewById(R.id.c4_b9_result);
        eDuongLich = (EditText) findViewById(R.id.c4_b9_eDuongLic);


        btnExec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int canNum, chiNum;
                canNum = (int) Math.floor(eDuongLich.getAlpha() / 10 / 100);
                chiNum = (int) Math.floor(eDuongLich.getAlpha() / 12 / 100);
                String result = canFunc(canNum) + chiFunc(chiNum);
                eReruslt.setText(result);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eReruslt.setText("");
                eDuongLich.setText("");
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public String canFunc(int canNum) {
        switch (canNum) {
            case 1:
                return "Tan";
            case 2:
                return "Nham";
            case 3:
                return "Quy";
            case 4:
                return "Giap";
            case 5:
                return "At";
            case 6:
                return "Binh";
            case 7:
                return "Dinh";
            case 8:
                return "Mau";
            case 9:
                return "Ky";
            default:
                return "Canh";
        }
    }

    public String chiFunc(int chiNum) {
        switch (chiNum) {
            case 1:
                return "Dau";
            case 2:
                return "Tuat";
            case 3:
                return "Hoi";
            case 4:
                return "Ty";
            case 5:
                return "Suu";
            case 6:
                return "Dan";
            case 7:
                return "Meo";
            case 8:
                return "Thin";
            case 9:
                return "Ty";
            case 10:
                return "Ngo";
            case 11:
                return "Mui";
            default:
                return "Than";
        }
    }
}