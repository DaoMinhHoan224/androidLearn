package com.example.hoandmph27404.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hoandmph27404.fragment.danhsachFragment;
import com.example.hoandmph27404.fragment.themghichuFragment;

public class adapter_Viewpager extends FragmentStateAdapter {
    public adapter_Viewpager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new danhsachFragment();
                break;
            case 1:
                fragment=new themghichuFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;   
    }
}
