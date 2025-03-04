package com.example.baitap01.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baitap01.R;
import com.example.baitap01.adapters.MonHocAdapter;
import com.example.baitap01.models.MonHoc;

import java.util.ArrayList;

public class CustomGridViewActivity extends AppCompatActivity {
    GridView gridView;
    EditText editText1;
    Button btnNhap, btnCapNhat, btnXoa;
    int vitri = -1;
    ArrayList<MonHoc> arrayList;
    MonHocAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.customGridViewLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //ánh xạ
        AnhXa();

        //Tạo Adapter
        adapter = new MonHocAdapter(CustomGridViewActivity.this,
                R.layout.row_monhoc2,
                arrayList
        );

        //truyền dữ liệu từ adapter ra listview
        gridView.setAdapter(adapter);

        //bắt sự kiện click nhanh trên từng dòng của Listview
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //code yêu cầu
                //i: trả về vị trí click chuột trên ListView -> iban đầu =0
                Toast.makeText(CustomGridViewActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                //lấy nội dung đua lên edittext
                editText1.setText(arrayList.get(i).getName());
                vitri = i;
            }
        });

        //bắt sự kiện click giữ trên từng dòng của Listview
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //code yêu cầu
                //i: trả về vị trí click chuột trên ListView -> i ban đầu =0
                Toast.makeText(CustomGridViewActivity.this, "Bạn đang nhấn giữ "+ i + "-" + arrayList.get(i) , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                arrayList.add(new MonHoc(name, "Mô tả mặc định", R.drawable.default_image));
                adapter.notifyDataSetChanged();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri >= 0 && vitri < arrayList.size()) {
                    MonHoc updatedMonHoc = arrayList.get(vitri);
                    updatedMonHoc.setName(editText1.getText().toString());
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
        gridView = (GridView) findViewById(R.id.gridview1);
        editText1 = (EditText) findViewById(R.id.editText1);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        btnXoa = (Button) findViewById(R.id.btnXoa);

        // Khởi tạo danh sách
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java", "Java 1", R.drawable.java1));
        arrayList.add(new MonHoc("C#", "C# 1", R.drawable.c));
        arrayList.add(new MonHoc("PHP", "PHP 1", R.drawable.php));
        arrayList.add(new MonHoc("Kotlin", "Kotlin1", R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart", "Dart 1", R.drawable.dart));
    }
}