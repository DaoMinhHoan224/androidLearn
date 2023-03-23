package com.example.assignment.KhoangThu.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment.KhoangThu.Khoanthu.KhoanThuFragment;
import com.example.assignment.KhoangThu.Loaithu.LoaiThuFragment;

public class adapter_ViewPages extends FragmentStateAdapter {
    public adapter_ViewPages(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                //hiển thịfragment của khoản thu
                fragment=new KhoanThuFragment();
                break;
            case 1:
                //hiển thị fragment của loại thu
                fragment=new LoaiThuFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
