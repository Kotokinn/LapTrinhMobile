package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap1;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap2;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap3;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap4;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap5;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap6;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap7;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap8;
import com.example.myapplication.chuong4.baitap.Chuong4_BaiTap9;
import com.example.myapplication.chuong5.baitap.Chuong5_BaiTap2;
import com.example.myapplication.chuong5.baitap.Chuong5_BaiTap3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    static final String[] CHUONGS = {
            "chuong4",
            "chuong5",
            "chuong6",
            "chuong7"
    };

    static final int MAX_BAITAP = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        // Dữ liệu hiển thị
        List<String> groupList = new ArrayList<>();
        Map<String, List<String>> childList = new HashMap<>();
        Map<String, Class<?>> classMap = new HashMap<>();

        // Quét từng chương
        for (String chuong : CHUONGS) {
            String groupName = "Chương " + chuong.replace("chuong", "");
            groupList.add(groupName);
            List<String> baiTapNames = new ArrayList<>();

            for (int i = 1; i <= MAX_BAITAP; i++) {
                String pkg = "com.example.myapplication." + chuong + ".baitap";
                String className = pkg + ".Chuong" + chuong.replace("chuong", "") + "_BaiTap" + i;

                try {
                    Class<?> clazz = Class.forName(className);
                    String baiName = "Bài " + i;
                    baiTapNames.add(baiName);
                    classMap.put(groupName + "-" + baiName, clazz);
                } catch (ClassNotFoundException ignored) {
                    // Không tồn tại thì bỏ qua
                }
            }

            if (!baiTapNames.isEmpty()) {
                childList.put(groupName, baiTapNames);
            }
        }

        // Adapter cho ExpandableListView
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return groupList.size();
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return childList.get(groupList.get(groupPosition)).size();
            }

            @Override
            public Object getGroup(int groupPosition) {
                return groupList.get(groupPosition);
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return childList.get(groupList.get(groupPosition)).get(childPosition);
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public android.view.View getGroupView(int groupPosition, boolean isExpanded,
                                                  android.view.View convertView, android.view.ViewGroup parent) {
                android.widget.TextView tv = new android.widget.TextView(MainActivity.this);
                tv.setText("" + getGroup(groupPosition));
                tv.setPadding(100, 25, 0, 25);
                tv.setTextSize(20);
                tv.setTypeface(null, android.graphics.Typeface.BOLD);
                return tv;
            }

            @Override
            public android.view.View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                                  android.view.View convertView, android.view.ViewGroup parent) {
                android.widget.TextView tv = new android.widget.TextView(MainActivity.this);
                tv.setText("" + getChild(groupPosition, childPosition));
                tv.setPadding(150, 15, 0, 15);
                tv.setTextSize(16);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        expandableListView.setAdapter(adapter);

        // Khi click vào bài
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String group = groupList.get(groupPosition);
            String child = childList.get(group).get(childPosition);
            Class<?> clazz = classMap.get(group + "-" + child);
            if (clazz != null) {
                Intent intent = new Intent(this, clazz);
                startActivity(intent);
            }
            return true;
        });
    }
}