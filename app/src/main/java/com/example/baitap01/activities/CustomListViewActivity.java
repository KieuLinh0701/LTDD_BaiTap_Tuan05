package com.example.baitap01.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitap01.R;
import com.example.baitap01.adapters.MonHocAdapter;
import com.example.baitap01.models.MonHoc;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {
    //khai báo
    ListView listView;
    ArrayList<MonHoc> arrayList;
    MonHocAdapter adapter;
    EditText editText;
    Button btnNhap, btnCapNhat, btnXoa;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view);

        //ánh xạ
        listView = (ListView) findViewById(R.id.listview1);
        editText = (EditText) findViewById(R.id.editText1);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        btnXoa = (Button) findViewById(R.id.btnXoa);

        //ánh xạ
        AnhXa();
        //Tạo Adapter
        adapter = new MonHocAdapter(
                CustomListViewActivity.this,
                R.layout.row_monhoc,
                arrayList
        );


        //truyền dữ liệu từ adapter ra listview
        listView.setAdapter(adapter);

        //bắt sự kiện click nhanh trên từng dòng của Listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //code yêu cầu
                //i: trả về vị trí click chuột trên ListView -> iban đầu =0
                Toast.makeText(CustomListViewActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                //lấy nội dung đua lên edittext
                editText.setText(arrayList.get(i).getName());
                vitri = i;
            }
        });

        //bắt sự kiện click giữ trên từng dòng của Listview
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //code yêu cầu
                //i: trả về vị trí click chuột trên ListView -> i ban đầu =0
                Toast.makeText(CustomListViewActivity.this, "Bạn đang nhấn giữ "+ i + "-" + arrayList.get(i) , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                arrayList.add(new MonHoc(name, "Mô tả mặc định", R.drawable.default_image));
                adapter.notifyDataSetChanged();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri >= 0 && vitri < arrayList.size()) {
                    MonHoc updatedMonHoc = arrayList.get(vitri);
                    updatedMonHoc.setName(editText.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.listview1);
        editText = (EditText) findViewById(R.id.editText1);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        //Thêm dữ liệu vào List
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java","Java 1",R.drawable.java1));
        arrayList.add(new MonHoc("C#","C# 1",R.drawable.c));
        arrayList.add(new MonHoc("PHP","PHP 1",R.drawable.php));
        arrayList.add(new MonHoc("Kotlin","Kotlin 1",R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart","Dart 1",R.drawable.dart));
    }
}