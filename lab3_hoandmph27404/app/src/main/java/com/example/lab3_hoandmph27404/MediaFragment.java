package com.example.lab3_hoandmph27404;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MediaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MediaFragment extends Fragment {

    public MediaFragment() {
        // Required empty public constructor
    }


    public static MediaFragment newInstance() {
        MediaFragment fragment = new MediaFragment();
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
        return inflater.inflate(R.layout.fragment_media, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] projection={
                MediaStore.MediaColumns.DISPLAY_NAME,
                MediaStore.MediaColumns.DATE_ADDED,
                MediaStore.MediaColumns.MIME_TYPE
        };

        CursorLoader loader=new CursorLoader(getActivity(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection
                                               ,null,null,null);
        Cursor c=loader.loadInBackground();
        c.moveToFirst();
        String s="";
        while (!c.isAfterLast()){
            for (int i=0;i<c.getColumnCount();i++){
                s+=c.getString(i) + " - ";
            }
            s+="\n";
            c.moveToNext();
        }
        Log.d("zzz","abcxyz");
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }
}