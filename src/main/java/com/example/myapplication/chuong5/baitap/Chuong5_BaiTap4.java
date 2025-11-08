package com.example.myapplication.chuong5.baitap;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong5_BaiTap4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong5_bai_tap4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settingsId) {
            Toast.makeText(this, "Bạn đã chọn Settings",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.toolsId) {
            Toast.makeText(this, "Bạn đã chọn Tools",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.ExitId) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//Kết thúc onOptionsItemSelected
}