package com.example.bt2_3_bt1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapter extends android.widget.ArrayAdapter<NhanVien> {
    Activity contex =null;
    ArrayList<NhanVien> arrNhanVien =null;
    int layoutID;


    public ArrayAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.contex= context;
        this.layoutID =resource;
        this.arrNhanVien = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = contex.getLayoutInflater();
        convertView = layoutInflater.inflate(layoutID,null);
        if(arrNhanVien.size()>0&&position>=0){
            final TextView txtDisplay=(TextView) convertView.findViewById(R.id.textview_item);
            final NhanVien nv = arrNhanVien.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imageView= (ImageView)convertView.findViewById(R.id.img_item);
            if(nv.isGender()){
                imageView.setImageResource(R.drawable.man);
            }
            else
                imageView.setImageResource(R.drawable.nu);

        }
        return convertView;

    }

}
