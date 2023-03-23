package com.example.assigment_hoandmph27404.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment_hoandmph27404.BxhPlayActivity;
import com.example.assigment_hoandmph27404.DTO.Bxhmusic;
import com.example.assigment_hoandmph27404.MyMediaPlayer;
import com.example.assigment_hoandmph27404.R;

import java.util.ArrayList;

public class Bxhmusicadapter extends RecyclerView.Adapter<Bxhmusicadapter.ViewHolder> {
    private ArrayList<Bxhmusic> bxhmusic;
    MediaPlayer mymediaPlayer;
    Context context;
    Bxhmusic bxhsong;

    public Bxhmusicadapter(ArrayList<Bxhmusic> bxhmusic, Context context) {
        this.bxhmusic = bxhmusic;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bxhmusic_item,parent,false);
        return new Bxhmusicadapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Bxhmusic musicbxh=bxhmusic.get(position);

        holder.tv_song.setText(musicbxh.getSong());
        holder.tv_singer.setText(musicbxh.getSinger());
        holder.imgpicture.setImageResource(musicbxh.getPicture());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyMediaPlayer.getInstance().reset();
                MyMediaPlayer.currentIndex=position;
                Intent intent=new Intent(context, BxhPlayActivity.class);
                intent.putExtra("BXHLIST",bxhmusic);
                mymediaPlayer=MediaPlayer.create(v.getContext(), musicbxh.getFile());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return bxhmusic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_song, tv_singer;
        ImageView imgpicture;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_song=itemView.findViewById(R.id.song_title);
            tv_singer=itemView.findViewById(R.id.song_artist);
            imgpicture=itemView.findViewById(R.id.img_avatamusic);

        }
    }
}
