package com.example.baitap01.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap01.R;
import com.example.baitap01.adapters.CustomAdapter;
import com.example.baitap01.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView rvMultipleViewType;
    private List<Object> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);

        rvMultipleViewType = (RecyclerView) findViewById(R.id.rv_multiple_view_type);
        mData = new ArrayList<>();

        mData.add(new UserModel("Nguyen Van Nghia", "Quan 11"));
        mData.add(R.drawable.avatar_1);
        mData.add("Text 1");
        mData.add(new UserModel("Nguyen Hoang Minh", "Quan 3"));
        mData.add(R.drawable.avatar_2);
        mData.add("Text 2");
        mData.add(R.drawable.avatar_3);
        mData.add(new UserModel("Pham Nguyen Tam Phu", "Quan 10"));
        mData.add("Text 3");
        mData.add("Text 4");
        mData.add(new UserModel("Tran Van Phuc", "Quan 1"));
        mData.add(R.drawable.avatar_4);

        CustomAdapter adapter = new CustomAdapter(this, mData);
        rvMultipleViewType.setAdapter(adapter);
        rvMultipleViewType.setLayoutManager(new LinearLayoutManager(this));
    }
}