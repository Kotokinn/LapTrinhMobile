package com.example.myapplication.chuong3.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong3_BaiTap13 extends AppCompatActivity {
    EditText etTodo;
    LinearLayout llTodo;
    Button btnAddTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong3_bai_tap13);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private View.OnClickListener handleAddTodo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String todo = etTodo.getText().toString();
            if (todo.isEmpty()) {
                Toast.makeText(Chuong3_BaiTap13.this, "Vui lòng nhập todo", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tạo param để add
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            // Tạo LinearLayout để chứa todo
            LinearLayout ln = new LinearLayout(Chuong3_BaiTap13.this);
            ln.setOrientation(LinearLayout.HORIZONTAL);
            TextView txt = new TextView(Chuong3_BaiTap13.this);
            CheckBox cb = new CheckBox(Chuong3_BaiTap13.this);
            txt.setText(todo);
            ln.addView(txt);
            ln.addView(cb);
            llTodo.addView(ln);

            ln.setLayoutParams(params);
        }
    };

    private void init() {
        etTodo = findViewById(R.id.et_todo);
        llTodo = findViewById(R.id.ll_todo);
        btnAddTodo = findViewById(R.id.btn_add_todo);

        btnAddTodo.setOnClickListener(handleAddTodo);
    }
}