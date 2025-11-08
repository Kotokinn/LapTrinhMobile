package com.example.myapplication.chuong6.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong6_BaiTap1 extends AppCompatActivity {

    Spinner spinnerCourse;
    TextView textViewSelected;
    public static String[] arrayCourse = {
            "Lập trình Android",
            "Lập trình IOS",
            "Thiết kế Web",
            "Facebook Ads",
            "Google Adwords",
            "Lập trình C#"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong6_bai_tap1);

        // Áp dụng insets cho layout chính
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Gọi hàm kết nối View
        ConnectView();

        // Tạo adapter cho Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );

        spinnerAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinnerCourse.setAdapter(spinnerAdapter);

        // Bắt sự kiện chọn item
        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Đã chọn: " + arrayCourse[position];
                Toast.makeText(Chuong6_BaiTap1.this, msg, Toast.LENGTH_SHORT).show();
                textViewSelected.setText(msg);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textViewSelected.setText("Không có mục nào được chọn");
            }
        });
    }

    // Hàm kết nối View với layout
    private void ConnectView() {
        spinnerCourse = findViewById(R.id.spinnercourseId);
        textViewSelected = findViewById(R.id.txtviewSelectedId);
    }
}
