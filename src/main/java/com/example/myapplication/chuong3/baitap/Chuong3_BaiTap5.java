package com.example.myapplication.chuong3.baitap;

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

public class Chuong3_BaiTap5 extends AppCompatActivity {
    Button btn_cong, btn_tru, btn_nhan, btn_chia;
    EditText edt_first_number, edt_second_number;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        connectView();
        setListener();
    }

    private View.OnClickListener operatorClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a = Double.parseDouble(edt_first_number.getText().toString());
            double b = Double.parseDouble(edt_second_number.getText().toString());
            double result = 0;

            int id = view.getId();
            if (id == R.id.btn_cong) {
                result = a + b;
            } else if (id == R.id.btn_tru) {
                result = a - b;
            } else if (id == R.id.btn_nhan) {
                result = a * b;
            } else if (id == R.id.btn_chia) {
                result = b != 0 ? a / b : 0;
            }

            txt_result.setText("" + Math.round(result));
        }
    };

    private void setListener() {
        btn_cong.setOnClickListener(operatorClick);
        btn_tru.setOnClickListener(operatorClick);
        btn_nhan.setOnClickListener(operatorClick);
        btn_chia.setOnClickListener(operatorClick);
    }

    private void connectView() {
        // Ánh xạ view
        btn_cong = findViewById(R.id.btn_cong);
        btn_tru = findViewById(R.id.btn_tru);
        btn_nhan = findViewById(R.id.btn_nhan);
        btn_chia = findViewById(R.id.btn_chia);
        edt_first_number = findViewById(R.id.edt_first_number);
        edt_second_number = findViewById(R.id.edt_second_number);
        txt_result = findViewById(R.id.txt_result);
    }
}