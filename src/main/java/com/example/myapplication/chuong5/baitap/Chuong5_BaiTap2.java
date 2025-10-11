package com.example.myapplication.chuong5.baitap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong5_BaiTap2 extends AppCompatActivity {

    Button btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong5_bai_tap2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnThoat = (Button) findViewById(R.id.btnThoatId);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });
    }

    void Exit() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Xac nhan de thoat..!!");
//        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setMessage("Ban co chac chan muon thoat ?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Dong y", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Khong dong y", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Chuong5_BaiTap2.this, "Ban da click vao nut khong dong y", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNeutralButton("Huy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Chuong5_BaiTap2.this, "Ban da click vao nut huy", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}