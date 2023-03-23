package com.example.assignment.GioiThieu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.webView_dksd;
import com.example.assignment.webView_gt;
import com.example.assignment.webView_info;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GioiThieuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GioiThieuFragment extends Fragment implements View.OnClickListener{
    private TextView tv_clickGT;

    public GioiThieuFragment() {
        // Required empty public constructor
    }


    public static GioiThieuFragment newInstance() {
        GioiThieuFragment fragment = new GioiThieuFragment();

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
        return inflater.inflate(R.layout.fragment_gioi_thieu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_clickGT=view.findViewById(R.id.tv_clickgt);
        tv_clickGT.setOnClickListener(this);
        registerForContextMenu(tv_clickGT);
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_gioithieu,menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.thongtin:
//                Intent intent=new Intent(getActivity().getBaseContext(), webView_info.class);
//                startActivity(intent);
//            case R.id.dieukhoansudung:
//                Intent intent1=new Intent(getActivity().getBaseContext(), webView_dksd.class);
//                startActivity(intent1);
//            case R.id.gioithieu:
//                Intent intent2=new Intent(getActivity().getBaseContext(), webView_gt.class);
//                startActivity(intent2);
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.menu_gioithieu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.thongtin:
                Intent intent=new Intent(getActivity().getBaseContext(), webView_info.class);
                startActivity(intent);
                break;
            case R.id.dieukhoansudung:
                Intent intent1=new Intent(getActivity().getBaseContext(), webView_dksd.class);
                startActivity(intent1);
                break;
            case R.id.gioithieu:
                Intent intent2=new Intent(getActivity().getBaseContext(), webView_gt.class);
                startActivity(intent2);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_clickgt:
                v.showContextMenu();
        }

    }
}