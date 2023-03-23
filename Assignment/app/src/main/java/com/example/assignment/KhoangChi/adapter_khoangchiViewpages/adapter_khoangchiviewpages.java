package com.example.assignment.KhoangChi.adapter_khoangchiViewpages;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment.KhoangChi.Khoanchi.KhoanChiFragment;
import com.example.assignment.KhoangChi.Loaichi.LoaiChiFragment;

public class adapter_khoangchiviewpages extends FragmentStateAdapter {
    public adapter_khoangchiviewpages(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new KhoanChiFragment();
                break;
            case 1:
                fragment=new LoaiChiFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
