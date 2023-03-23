package com.example.assigment_hoandmph27404.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.assigment_hoandmph27404.Adapter.Bxhmusicadapter;
import com.example.assigment_hoandmph27404.DTO.Bxhmusic;
import com.example.assigment_hoandmph27404.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {

    RecyclerView recyclerViewSongbxh;
    ArrayList<Bxhmusic> bxhsong;
    Bxhmusic bxhmusic;
    int position;
    Bxhmusicadapter bxhmusicadapter;
    MediaPlayer mymediaPlayer;
    TextView notext;
    ViewFlipper viewFlipper;
    int[] arrayhinh={R.drawable.img_slideshow1,R.drawable.img_slideshow2,R.drawable.img_slideshow3,R.drawable.img_slideshow4
            ,R.drawable.img_slideshow5};

    public MusicFragment() {
        // Required empty public constructor
    }

    public static MusicFragment newInstance() {
        MusicFragment fragment = new MusicFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewSongbxh=view.findViewById(R.id.re_bxhmusic);
        notext=view.findViewById(R.id.no_songs_textbxh);
        viewFlipper=view.findViewById(R.id.viewFlipper);
        for (int i=0;i<arrayhinh.length;i++){
            ImageView imageView=new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(arrayhinh[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);

        viewFlipper.setAutoStart(true);


        if(checkPermission() == false){
            requestPermission();
            return;
        }
        bxhsong=new ArrayList<>();
        bxhsong.add(new Bxhmusic("Đoạn kết mới","Hoàng Dũng",R.drawable.img_album1,R.raw.doanketmoi));
        bxhsong.add(new Bxhmusic("Bên trên tầng lầu","Tăng Duy Tân",R.drawable.bentrentanglau,R.raw.bentrentanglau));
        bxhsong.add(new Bxhmusic("Thích Thích","Phương Ly",R.drawable.thichthich,R.raw.thichthich));
        bxhsong.add(new Bxhmusic("Good boy","G-Dragon",R.drawable.goodboy,R.raw.goodboy));
        bxhsong.add(new Bxhmusic("Replay trên con wave","Phúc Du",R.drawable.wave,R.raw.replaytrenconwave));

        mymediaPlayer=MediaPlayer.create(getContext(), bxhsong.get(position).getFile());

        if (bxhsong.size()==0){
            notext.setVisibility(View.VISIBLE);
        }else{
            recyclerViewSongbxh.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewSongbxh.setAdapter(new Bxhmusicadapter(bxhsong,getActivity().getApplicationContext()));

        }

    }

    boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
        if(result == PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            return false;
        }
    }

    void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){
            Toast.makeText(getActivity(),"READ PERMISSION IS REQUIRED,PLEASE ALLOW FROM SETTTINGS",Toast.LENGTH_SHORT).show();
        }else
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(recyclerViewSongbxh!=null){
            recyclerViewSongbxh.setAdapter(new Bxhmusicadapter(bxhsong, getActivity().getBaseContext()));
        }
    }
}