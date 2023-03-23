package com.example.lab3_hoandmph27404;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();

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
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Uri uri=Uri.parse("content://contacts/people");
        ArrayList<String> list=new ArrayList<String>();
        Cursor c1=getActivity().getContentResolver().query(uri,null,null,null,null);
        c1.moveToFirst();
        while (c1.isAfterLast()==false){
            String s="";
            String idColumnName= ContactsContract.Contacts._ID;
            int idIndex=c1.getColumnIndex(idColumnName);
            s=c1.getString(idIndex)+" _ ";
            String nameColumnName=ContactsContract.Contacts.DISPLAY_NAME;
            int nameIndex=c1.getColumnIndex(nameColumnName);
            s+=c1.getString(nameIndex);
            c1.moveToNext();
            list.add(s);
        }
        c1.close();
        ListView lv_contact=view.findViewById(R.id.lv_contact);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list);
        Log.d("zzz","abcxyz");
        lv_contact.setAdapter(adapter);
    }
}