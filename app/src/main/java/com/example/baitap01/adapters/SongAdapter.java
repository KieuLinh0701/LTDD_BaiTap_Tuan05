package com.example.baitap01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap01.R;
import com.example.baitap01.models.SongModel;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private static final String TAG = "SongAdapter"; // Hằng số để ghi log (nếu cần).
    private static List<SongModel> mSongs; // Danh sách các bài hát.
    private static Context mContext; // Context của ứng dụng.
    private LayoutInflater mLayoutInflater; // LayoutInflater để "inflate" các layout.

    // Constructor của adapter.
    public SongAdapter(Context context, List<SongModel> datas) {
        mContext = context;
        mSongs = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout cho từng item trong RecyclerView.
        View itemView = mLayoutInflater.inflate(R.layout.row_item_song, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        // Lấy đối tượng bài hát tại vị trí hiện tại.
        SongModel song = mSongs.get(position);

        // Gán dữ liệu vào ViewHolder.
        holder.tvCode.setText(song.getmCode());
        holder.tvTitle.setText(song.getmTitle());
        holder.tvLyric.setText(song.getmLyric());
        holder.tvArtist.setText(song.getmArtist());
    }

    @Override
    public int getItemCount() {
        // Trả về số lượng bài hát trong danh sách.
        return mSongs.size();
    }

    // Lớp ViewHolder để ánh xạ và quản lý các thành phần giao diện.
    public static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView tvCode, tvTitle, tvLyric, tvArtist;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);

            // Ánh xạ các thành phần giao diện từ layout XML.
            tvCode = itemView.findViewById(R.id.tv_code);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvLyric = itemView.findViewById(R.id.tv_lyric);
            tvArtist = itemView.findViewById(R.id.tv_artist);

            //thiết lập sự kiện
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SongModel song = mSongs.get(getAdapterPosition());
                    Toast.makeText(mContext, song.getmTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}

