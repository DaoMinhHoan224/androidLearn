package com.example.testlailannuane.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testlailannuane.fragment.danhsachgvFragment;
import com.example.testlailannuane.fragment.themgvFragment;

public class adapter_viewpages extends FragmentStateAdapter {
    public adapter_viewpages(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new danhsachgvFragment();
                break;
            case 1:
                fragment=new themgvFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
