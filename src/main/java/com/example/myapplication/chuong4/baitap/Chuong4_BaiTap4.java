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

public class Chuong4_BaiTap4 extends AppCompatActivity {

    private Button btnCong,btnTru,btnNhan,btnChia;
    private EditText txtSoA,txtSoB;

    private TextView txtVResult;


    void handlePhepTinh(int idBtn, Double soA, Double soB){
        Double result = 0.0;
        if(getResources().getResourceEntryName(idBtn).equals("BaiTap4_cong")) result = soA + soB;
        if(getResources().getResourceEntryName(idBtn).equals("BaiTap4_tru")) result = soA-soB;
        if(getResources().getResourceEntryName(idBtn).equals("BaiTap4_nhan")) result = soA * soB;
        if(getResources().getResourceEntryName(idBtn).equals("BaiTap4_chia"))
            if(soB != 0)
                result = soA / soB;
        txtVResult.setText(result.toString());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong4_bai_tap4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCong = (Button) findViewById(R.id.BaiTap4_cong);
        btnChia = (Button) findViewById(R.id.BaiTap4_chia);
        btnNhan = (Button) findViewById(R.id.BaiTap4_nhan);
        btnTru = (Button) findViewById(R.id.BaiTap4_tru);

        txtSoA = (EditText) findViewById(R.id.BaiTap4_soA);
        txtSoB = (EditText) findViewById(R.id.BaiTap4_soB);

        txtVResult = (TextView) findViewById(R.id.BaiTap4_result);

        btnNhan.setOnClickListener(btnPhepTinh);
        btnTru.setOnClickListener(btnPhepTinh);
        btnChia.setOnClickListener(btnPhepTinh);
        btnCong.setOnClickListener(btnPhepTinh);

    }

    View.OnClickListener btnPhepTinh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            handlePhepTinh(
                    v.getId(),
                    Double.parseDouble(String.valueOf(txtSoA.getText())),
                    Double.parseDouble(String.valueOf(txtSoB.getText()))
            );
        }
    };
}