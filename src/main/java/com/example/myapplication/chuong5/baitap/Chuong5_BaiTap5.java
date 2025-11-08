package com.example.myapplication.chuong5.baitap;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Chuong5_BaiTap5 extends AppCompatActivity {
    TextView txtChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong5_bai_tap5);
        txtChangeColor = (TextView) findViewById(R.id.txtChangeColorId);
        registerForContextMenu(txtChangeColor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.RedId) {
            txtChangeColor.setTextColor(getResources().getColor(R.color.color_Red));
            return true;
        } else if (id == R.id.GreenId) {
            txtChangeColor.setTextColor(getResources().getColor(R.color.color_Green));
            return true;
        } else if (id == R.id.BlueId) {
            txtChangeColor.setTextColor(getResources().getColor(R.color.color_Blue));
            return true;
        }
        return super.onContextItemSelected(item);
    }
}