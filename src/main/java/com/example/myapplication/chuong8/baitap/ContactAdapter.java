package com.example.myapplication.chuong8.baitap;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Contact> lContact;


    public ContactAdapter(List<Contact> lContact, int layout, Context context) {
        this.lContact = lContact;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lContact.size();
    }

    @Override
    public Object getItem(int position) {
        return lContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lContact.get(position).getId();
    }

    private class Viewholder {
        TextView tvId, tvName, tvType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;
        if (convertView == null) {
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            // Ánh xạ view
            holder.tvId = convertView.findViewById(R.id.tvId);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvType = convertView.findViewById(R.id.tvType);

            convertView.setTag(holder);
        } else {
            holder = (Viewholder) convertView.getTag();
        }

        // Lấy đối tượng DanhBa tại vị trí position
        Contact danhBa = lContact.get(position);

        // Gán dữ liệu vào view
        holder.tvId.setText(String.valueOf(danhBa.getId()));
        holder.tvName.setText(danhBa.getName());
        holder.tvType.setText(danhBa.getType());

        return convertView;
    }
}
