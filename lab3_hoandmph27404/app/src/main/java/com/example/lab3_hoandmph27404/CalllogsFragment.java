package com.example.lab3_hoandmph27404;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.CallLog;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalllogsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalllogsFragment extends Fragment {


    public CalllogsFragment() {
        // Required empty public constructor
    }


    public static CalllogsFragment newInstance() {
        CalllogsFragment fragment = new CalllogsFragment();

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
        return inflater.inflate(R.layout.fragment_calllogs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> list=new ArrayList<>();
        String [] projection=new String[]{
                CallLog.Calls.DATE,
                CallLog.Calls.NUMBER,
                CallLog.Calls.DURATION};

        Cursor c=getActivity().getContentResolver().query(CallLog.Calls.CONTENT_URI,projection,
                CallLog.Calls.DURATION+"<?",new String[]{"30"}, CallLog.Calls.DATE);
        c.moveToFirst();
        String s="";
        while (c.isAfterLast()==false){
            for (int i=0;i<c.getColumnCount();i++){
                s+=c.getString(i)+ " - ";
            }
            s+="\n";
            c.moveToNext();
            list.add(s);
        }
        c.close();
        ListView lv_calllogs=view.findViewById(R.id.lv_calllogs);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list);
        Log.d("zzz","abcxyz");
        lv_calllogs.setAdapter(adapter);
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }
}