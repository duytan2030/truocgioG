package com.example.bt2_3_bt1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> arrNhanVien =null;
    ArrayAdapter arrayAdapter =null;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText txtMa,txtTen;
    RadioGroup genderGroup;
    ListView lstNhanVien ;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrNhanVien = new ArrayList<NhanVien>();
        arrayAdapter = new ArrayAdapter(MainActivity.this,R.layout.my_item_layout,arrNhanVien);
        btnNhap=(Button) findViewById(R.id.button_nhap);
        txtMa=(EditText) findViewById(R.id.ed_manv);
        txtTen=(EditText)findViewById(R.id.ed_tennv);
        genderGroup =(RadioGroup) findViewById(R.id.radGroup);
        lstNhanVien =(ListView)findViewById(R.id.listview_nhanvien);
        lstNhanVien.setAdapter(arrayAdapter);
        btnRemoveAll=(ImageButton)findViewById(R.id.imageButton_xoa);

        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulixoa();
            }
        });
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulynhap();
            }
        });


    }
    public void xulixoa(){
        for(int i = lstNhanVien.getChildCount()-1;i>=0;i--){
            View v =lstNhanVien.getChildAt(i);
            CheckBox chk =(CheckBox)v.findViewById(R.id.chk_item);
            if(chk.isChecked()){
                arrNhanVien.remove(i);
            }
        }
        arrayAdapter.notifyDataSetChanged();
    }
    public void xulynhap(){
        String ma = txtMa.getText() +"";
        String ten= txtTen.getText()+"";
        boolean gioitinh=false;
        if(genderGroup.getCheckedRadioButtonId()== R.id.rd_nam){
            gioitinh= true;
        }
        NhanVien nv = new NhanVien(ma,ten,gioitinh);
        arrNhanVien.add(nv);
        arrayAdapter.notifyDataSetChanged();
        txtTen.setText("");
        txtMa.setText("");
        txtMa.requestFocus();
    }
}
