package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap6 extends AppCompatActivity {
    EditText edtFullName;
    RadioGroup gender;
    Button btnShowResult;
    RadioButton rbNam, rbNu;
    TextView txtResultInformation;
    CheckBox cbTheThao, cbDienTu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        btnShowResult.setOnClickListener(showResultClick);

    }

    private View.OnClickListener showResultClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strTheThao = cbTheThao.isChecked() ? "Thể thao" : "";
            String strDienTu = cbDienTu.isChecked() ? "Điện tử" : "";
            String strGioiTinh = gender.getCheckedRadioButtonId() == R.id.rb_nam ? "Nam" : "Nữ";
            String strHoTen = edtFullName.getText().toString();
            String result = "Họ tên: " + strHoTen + "\n" + "Giới tính: " + strGioiTinh + "\n" + "Sở thích: " + strTheThao + ", " + strDienTu;

            txtResultInformation.setText(result);
        }
    };

    private void initView() {
        edtFullName = findViewById(R.id.edt_full_name);
        gender = findViewById(R.id.rg_gender);
        btnShowResult = findViewById(R.id.btn_show_result);
        txtResultInformation = findViewById(R.id.txt_result_information);
        cbTheThao = findViewById(R.id.cb_the_thao);
        cbDienTu = findViewById(R.id.cb_dien_tu);
        rbNam = findViewById(R.id.rb_nam);
        rbNu = findViewById(R.id.rb_nu);
    }
}