package com.example.lab3_hoandmph27404;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import android.provider.Browser;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookmarkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookmarkFragment extends Fragment {
    ListView lv_bookmark;
    public BookmarkFragment() {
        // Required empty public constructor
    }


    public static BookmarkFragment newInstance() {
        BookmarkFragment fragment = new BookmarkFragment();

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
        return inflater.inflate(R.layout.fragment_bookmark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Uri uri=Uri.parse("content://browser/bookmarks");
        List<String> list=new ArrayList<String>();
        String[] history= new String[]{
                "_id",
                "_url",
                "title",
        };
        Cursor cursor= getActivity().managedQuery(uri,history,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            String s="";
            s+=cursor.getString(1)+ " - " + cursor.getString(2);
            list.add(s);
            cursor.moveToNext();
        }
        cursor.close();
        lv_bookmark=view.findViewById(R.id.lv_bookmark);
        ArrayAdapter<String> adapterbookmark=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list);
        Log.d("zzz","abcxyz");
        lv_bookmark.setAdapter(adapterbookmark);
    }

}