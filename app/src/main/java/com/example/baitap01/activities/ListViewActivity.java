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

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    //Khai báo
    ListView listView;
    ArrayList<String> arrayList;
    EditText editText1;
    Button btnNhap, btnCapNhat, btnXoa;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        //ánh xạ
        listView = (ListView) findViewById(R.id.listview1);
        editText1 = (EditText) findViewById(R.id.editText1);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        btnXoa = (Button) findViewById(R.id.btnXoa);

        //Thêm dữ liệu vào List
        arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");

        //Tạo ArrayAdapter
        ArrayAdapter adapter = new ArrayAdapter(
                ListViewActivity.this,
                android.R.layout.simple_list_item_1,
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
                Toast.makeText(ListViewActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                //lấy nội dung đua lên edittext
                editText1.setText(arrayList.get(i));
                vitri = i;
            }
        });

        //bắt sự kiện click giữ trên từng dòng của Listview
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //code yêu cầu
                //i: trả về vị trí click chuột trên ListView -> i ban đầu =0
                Toast.makeText(ListViewActivity.this, "Bạn đang nhấn giữ "+ i + "-" + arrayList.get(i) , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                arrayList.add(name);
                adapter.notifyDataSetChanged();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(vitri, editText1.getText().toString());
                adapter.notifyDataSetChanged();
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
}