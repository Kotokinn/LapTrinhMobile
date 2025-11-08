package com.example.myapplication.chuong6.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Chuong6_BaiTap2 extends AppCompatActivity {

    String[] MonHocs = {"Lập trình Android", "Lập trình IOS", "Thiết kế Web", "FaceBook Ads", "Google Adwords", "Lập trình C#"};

    ListView lMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong6_bai_tap2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Lấy danh sách dữ liệu
        List<Chuong6_BaiTap2_KhoaHoc> listData = getListData();

        // Gán adapter cho ListView
        ListView listView = findViewById(R.id.lvkhoahocid);
        Chuong6_BaiTap2_Adapter adapter = new Chuong6_BaiTap2_Adapter(this, listData);
        listView.setAdapter(adapter);

        // Bắt sự kiện click item trong ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chuong6_BaiTap2_KhoaHoc khoaHoc = listData.get(position);
                Toast.makeText(Chuong6_BaiTap2.this,
                        "Đã chọn: " + khoaHoc.getTenKhoaHoc() + " - Học phí: " + khoaHoc.getHocPhi(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Chuong6_BaiTap2_KhoaHoc> getListData() {
        List<Chuong6_BaiTap2_KhoaHoc> list = new ArrayList<>();

        list.add(new Chuong6_BaiTap2_KhoaHoc("600000", "android", "Lập trình Android"));
        list.add(new Chuong6_BaiTap2_KhoaHoc("600000", "window", "Lập trình Windows"));
        list.add(new Chuong6_BaiTap2_KhoaHoc("600000", "ios", "Lập trình iOS"));
        list.add(new Chuong6_BaiTap2_KhoaHoc("600000", "csharp", "Lập trình C#"));
        list.add(new Chuong6_BaiTap2_KhoaHoc("600000", "fb", "Quảng cáo Facebook"));
        list.add(new Chuong6_BaiTap2_KhoaHoc("600000", "ggadv", "Quảng cáo Google Adwords"));

        return list;
    }
}
