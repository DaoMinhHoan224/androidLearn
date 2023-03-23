package com.example.day04.lab4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day04.R;
import com.example.day04.bai5.RecyclerViewAdapter;
import com.example.day04.bai5.UserObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Lab4Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lab4Fragment extends Fragment {
    private RecyclerView recyclerViewlab4;
    private RecyclerView recyclerViewdoc;
    private ArrayList<UserObjectLab4> arrayList4=new ArrayList<>();
    private Lab4Adapter adapterlab4;
    private adapterdoc adapterdoc;

    public Lab4Fragment() {
        // Required empty public constructor
    }


    public static Lab4Fragment newInstance() {
        Lab4Fragment fragment = new Lab4Fragment();

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
        return inflater.inflate(R.layout.fragment_lab4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewlab4=view.findViewById(R.id.id_recycleviewngang);
        createData();

        adapterlab4=new Lab4Adapter(getActivity());
        adapterlab4.setDatalab4(arrayList4);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewlab4.setLayoutManager(linearLayoutManager);
        recyclerViewlab4.setAdapter(adapterlab4);
        adapterDoc(view);



    }

    public void createData(){
        arrayList4.add(new UserObjectLab4("Android",R.drawable.android));
        arrayList4.add(new UserObjectLab4("Apple",R.drawable.apple));
        arrayList4.add(new UserObjectLab4("Blogger",R.drawable.blogger));
        arrayList4.add(new UserObjectLab4("Chrome",R.drawable.chrome));
        arrayList4.add(new UserObjectLab4("Dell",R.drawable.dell));
        arrayList4.add(new UserObjectLab4("Facebook",R.drawable.facebook));
        arrayList4.add(new UserObjectLab4("FireFox",R.drawable.firefox));
    }

    public void adapterDoc(View view){
        recyclerViewdoc=view.findViewById(R.id.id_recycleviewdoc);
        createData();

        adapterdoc=new adapterdoc(getActivity());
        adapterdoc.setDatalab4doc(arrayList4);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerViewdoc.setLayoutManager(linearLayoutManager1);
        recyclerViewdoc.setAdapter(adapterdoc);
    }
}