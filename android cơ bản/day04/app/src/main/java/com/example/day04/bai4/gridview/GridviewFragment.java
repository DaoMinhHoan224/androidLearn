package com.example.day04.bai4.gridview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.day04.R;
import com.example.day04.bai4.gridview.adapter.LogoGrid;
import com.example.day04.bai4.gridview.object.Logo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GridviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridviewFragment extends Fragment {
    private GridView gridView;
    private LogoGrid logoGrid;
    private ArrayList<Logo> list_logo;


    public GridviewFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GridviewFragment newInstance() {
        GridviewFragment fragment = new GridviewFragment();

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
        return inflater.inflate(R.layout.fragment_gridview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView=view.findViewById(R.id.id_gridLayout);
        logoGrid=new LogoGrid(getDataGrid(),getActivity(),R.layout.logogrid_layout);
        gridView.setAdapter(logoGrid);
    }

    public ArrayList<Logo> getDataGrid(){
         list_logo=new ArrayList<>();
         list_logo.add(new Logo(R.drawable.android,"Android"));
        list_logo.add(new Logo(R.drawable.apple,"Apple"));
        list_logo.add(new Logo(R.drawable.blogger,"Blogger"));
        list_logo.add(new Logo(R.drawable.chrome,"Chrome"));
        list_logo.add(new Logo(R.drawable.dell,"Dell"));
        list_logo.add(new Logo(R.drawable.facebook,"Facebook"));
        list_logo.add(new Logo(R.drawable.firefox,"Firefox"));
        list_logo.add(new Logo(R.drawable.hp,"HP"));
        list_logo.add(new Logo(R.drawable.twitter,"Twitter"));
        list_logo.add(new Logo(R.drawable.ie,"Messeger"));
        list_logo.add(new Logo(R.drawable.microsoft,"Microsoft"));
        list_logo.add(new Logo(R.drawable.xbox,"XBox"));

        return list_logo;
    }
}