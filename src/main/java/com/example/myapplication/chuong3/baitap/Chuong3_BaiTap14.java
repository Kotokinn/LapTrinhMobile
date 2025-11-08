package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap14 extends AppCompatActivity {
    RadioGroup rgChooseCofe;
    CheckBox cbKem;
    ImageButton btnOrderDen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap14);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        rgChooseCofe = findViewById(R.id.rg_choose_cofe);
        cbKem = findViewById(R.id.cb_kem);
        btnOrderDen = findViewById(R.id.btnOrderDen);

        btnOrderDen.setOnClickListener(handleChooseCofe);
    }

    private View.OnClickListener handleChooseCofe = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Kiem tra da check cofe
            if (rgChooseCofe.getCheckedRadioButtonId() == -1) {
                Toast.makeText(Chuong3_BaiTap14.this, "Vui lòng chọn Cofe", Toast.LENGTH_SHORT).show();
                return;
            }

            String isCheckbox = cbKem.isChecked() ? "Có kem" : "Không kem";
            RadioButton isCheckRadio = (RadioButton) findViewById(rgChooseCofe.getCheckedRadioButtonId());
            Toast.makeText(Chuong3_BaiTap14.this, "Bạn đã chọn " + isCheckRadio.getText() + " " + isCheckbox, Toast.LENGTH_SHORT).show();
        }
    };
}