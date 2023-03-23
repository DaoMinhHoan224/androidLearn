package com.example.day04.bai4.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.day04.bai4.gridview.GridviewFragment;
import com.example.day04.bai4.listview.ListviewFragment;
import com.example.day04.bai4.spinner.SpinnerFragment;

public class Adapter_Viewpager extends FragmentStateAdapter {

    public Adapter_Viewpager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                //hiển thị fragment của gridview
                fragment=new GridviewFragment();
                break;
            case 1:
                //hiển thị fragment listview
                fragment=new ListviewFragment();
                break;
            case 2:
                fragment= SpinnerFragment.newInstance();
                //hiển thị fragment spinner
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;//đưa vào số lượng trang
    }
}
