package com.example.myapplication.chuong7.baitap.supactivitiesbai5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong7_BaiTap5_GetStringArray extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong7_bai_tap5_get_string_array);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intentgetStringArray = getIntent();
        String[] getStringKhoahocArray;
        getStringKhoahocArray = intentgetStringArray.getStringArrayExtra("Khoahoc");
        ListView lsKhoahoc = (ListView) findViewById(R.id.lsKhoahoc);
        ArrayAdapter adapter = new ArrayAdapter(Chuong7_BaiTap5_GetStringArray.this, android.R.layout.simple_list_item_1, getStringKhoahocArray);
        lsKhoahoc.setAdapter(adapter);

    }
}