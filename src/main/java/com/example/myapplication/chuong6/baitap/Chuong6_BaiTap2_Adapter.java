package com.example.myapplication.chuong6.baitap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class Chuong6_BaiTap2_Adapter extends BaseAdapter {
    private List<Chuong6_BaiTap2_KhoaHoc> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public Chuong6_BaiTap2_Adapter(Context aContext, List<Chuong6_BaiTap2_KhoaHoc> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.chuong6_b2_lv_layout, null);

            holder = new ViewHolder();
            holder.imagekhoahoc = (ImageView) convertView.findViewById(R.id.imageViewCourse);
            holder.tenkhoahoc = (TextView) convertView.findViewById(R.id.textViewsename);
            holder.hocphi = (TextView) convertView.findViewById(R.id.textViewcoursfree);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Chuong6_BaiTap2_KhoaHoc khoahoc = this.listData.get(position);
        holder.tenkhoahoc.setText(khoahoc.getTenKhoaHoc());
        holder.hocphi.setText("Học phí " + khoahoc.getHocPhi());
        int imageId = this.getMipmapResIdByName(khoahoc.getImag());
        holder.imagekhoahoc.setImageResource(imageId);
        return convertView;
    }

    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        return resID;
    }

    static class ViewHolder {
        ImageView imagekhoahoc;
        TextView tenkhoahoc;
        TextView hocphi;
    }
}
