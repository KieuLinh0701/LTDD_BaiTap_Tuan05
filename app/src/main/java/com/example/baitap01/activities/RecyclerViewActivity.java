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
import com.example.baitap01.adapters.SongAdapter;
import com.example.baitap01.models.SongModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<SongModel> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Liên kết RecyclerView
        rvSongs = findViewById(R.id.rv_songs);

        // Tạo dữ liệu bài hát
        mSongs = new ArrayList<>();
        mSongs.add(new SongModel("66056", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new SongModel("66701", "NGỐC", "Có rất nhiều những câu chuyện em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new SongModel("66702", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Có yêu thương", "Thiên Dũng"));
        mSongs.add(new SongModel("66703", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đôi lòng anh ngập tràn bão", "Duy Cường"));
        mSongs.add(new SongModel("66704", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay nước mắt em", "Phan Mạnh Quỳnh"));
        mSongs.add(new SongModel("66705", "NGƯỜI ẤY", "Anh mơ gặp em anh đã được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        mSongs.add(new SongModel("66752", "TÌNH YÊU CHẤP VÁ", "Muốn đi xa nói yêu thương mình từng có để không nghe", "Mr. Siro"));
        mSongs.add(new SongModel("66753", "CHỜ NGÀY MƯA TAN", "1 ngày nụ và em khuất xa nơi ánh bóng đang cờ", "Trung Đức"));
        mSongs.add(new SongModel("66754", "CÂU HỎI CHƯA TRẢ LỜI", "Cần nơi em 1 lời giải thích thật lòng Đừng lặng im", "Yuki Huy Nam"));
        mSongs.add(new SongModel("66756", "QUA ĐI LẶNG LẼ", "Bởi khi đến với nhau yêu thương chẳng được lâu những khi", "Phan Mạnh Quỳnh"));
        mSongs.add(new SongModel("66856", "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ - REMIX", "Cần thêm bao lâu để em quên đi niềm đau Cần thêm", "Thiện Ngôn"));

        // Thiết lập Adapter và LayoutManager
        mSongAdapter = new SongAdapter(this, mSongs);
        rvSongs.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);


    }
}