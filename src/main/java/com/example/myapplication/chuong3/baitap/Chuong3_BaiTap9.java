package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap9 extends AppCompatActivity {

    Button btnSend;
    LinearLayout checkboxGroup;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        btnSend = findViewById(R.id.btn_send);
        checkboxGroup = findViewById(R.id.checkbox_group);
        radioGroup = findViewById(R.id.radio_group);

        btnSend.setOnClickListener(handleSend);
    }

    private View.OnClickListener handleSend = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String favorite = "";
            String rating = "";

            for (int i = 0; i < checkboxGroup.getChildCount(); i++) {
                View view = checkboxGroup.getChildAt(i);
                if (view instanceof CheckBox) {
                    CheckBox cb = (CheckBox) view;
                    if (cb.isChecked()) {
                        favorite += cb.getText() + " ";
                    }
                }
            }
            int selectId = radioGroup.getCheckedRadioButtonId();
            if (selectId != -1) {
                RadioButton rb = findViewById(selectId);
                rating = rb.getText().toString();
            }

            if (favorite.isEmpty() || rating.isEmpty()) {
                Toast.makeText(Chuong3_BaiTap9.this, "Vui lòng chọn đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(Chuong3_BaiTap9.this, "Sở thích: " + favorite + " - Đánh giá: " + rating, Toast.LENGTH_SHORT).show();
        }
    };
}