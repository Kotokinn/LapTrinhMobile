package com.example.myapplication.chuong3.baitap;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap12 extends AppCompatActivity {
    GridLayout gridDays;
    DatePicker datePicker;
    ImageButton btnAddEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap12);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void hiddenDay() {
        int daySpinnerId = getResources().getIdentifier("day", "id", "android");
        if (daySpinnerId != 0) {
            View dayView = datePicker.findViewById(daySpinnerId);
            if (dayView != null) {
                dayView.setVisibility(View.GONE);
            }
        }
    }

    private View.OnClickListener handleSelectDate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < gridDays.getChildCount(); i++) {
                TextView txtDay = (TextView) gridDays.getChildAt(i);
                // Xử lý tắt tất cả sự kiện
                if ((boolean) txtDay.getTag()) {
                    txtDay.setTag(false);
                }
                // Xóa màu
                txtDay.setBackgroundColor(Color.TRANSPARENT);
            }

            v.setTag(true);
            v.setBackgroundColor(getResources().getColor(R.color.black));
        }
    };

    private View.OnClickListener handleClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean hasSelection = false;

            for (int i = 0; i < gridDays.getChildCount(); i++) {
                TextView txtDay = (TextView) gridDays.getChildAt(i);
                if ((boolean) txtDay.getTag()) {
                    // Đổi màu sang đỏ để đánh dấu có sự kiện
                    txtDay.setBackgroundColor(Color.RED);
                    txtDay.setTag(false); // reset để không bị giữ mãi
                    hasSelection = true;
                    break;
                }
            }

            if (!hasSelection) {
                Toast.makeText(Chuong3_BaiTap12.this, "Chưa chọn ngày nào!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Chuong3_BaiTap12.this, "Đã thêm sự kiện!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void init() {
        gridDays = findViewById(R.id.grid_days);
        datePicker = findViewById(R.id.date_picker);
        btnAddEvent = findViewById(R.id.btn_mark_event);

        // Khởi tạo 31 ngày
        for (int i = 1; i <= 31; i++) {
            TextView txtDay = new TextView(this);
            txtDay.setId(View.generateViewId());
            txtDay.setTag(false); // Để kiểm tra xem sự kiện nào đang chạy
            txtDay.setText(String.valueOf(i));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.setMargins(8, 8, 8, 8);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            txtDay.setLayoutParams(params);

            txtDay.setOnClickListener(handleSelectDate);

            gridDays.addView(txtDay);
        }

        hiddenDay();
        btnAddEvent.setOnClickListener(handleClick);
    }
}