package com.example.baitestgiaodienandroid.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.baitestgiaodienandroid.fragment.danhsachFragment;
import com.example.baitestgiaodienandroid.fragment.themghichuFragment;

public class adapter_Viewpages extends FragmentStateAdapter {
    public adapter_Viewpages(@NonNull FragmentActivity fragmentActivity) {
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
