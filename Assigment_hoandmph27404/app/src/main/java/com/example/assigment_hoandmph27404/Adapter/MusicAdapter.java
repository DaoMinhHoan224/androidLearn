package com.example.assigment_hoandmph27404.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment_hoandmph27404.DTO.Bxhmusic;
import com.example.assigment_hoandmph27404.DTO.Song;
import com.example.assigment_hoandmph27404.MusicPlayActivity;
import com.example.assigment_hoandmph27404.MyMediaPlayer;
import com.example.assigment_hoandmph27404.R;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private ArrayList<Song> songslist;
    Context context;

    public MusicAdapter(ArrayList<Song> songslist, Context context) {
        this.songslist = songslist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.song_item,parent,false);
        return new MusicAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Song songData=songslist.get(position);
        holder.titleTextView.setText(songData.getSongTitle());

//        if (MyMediaPlayer.currentIndex==position){
//            holder.titleTextView.setTextColor(Color.parseColor("FF0000"));
//        }else{
//            holder.titleTextView.setTextColor(Color.parseColor("#000000"));
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMediaPlayer.getInstance().reset();
                MyMediaPlayer.currentIndex=position;
                Intent intent=new Intent(context, MusicPlayActivity.class);
                intent.putExtra("LIST",songslist);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return songslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView iconImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView=itemView.findViewById(R.id.song_title);
            iconImageView=itemView.findViewById(R.id.icon_view);

        }
    }
}
