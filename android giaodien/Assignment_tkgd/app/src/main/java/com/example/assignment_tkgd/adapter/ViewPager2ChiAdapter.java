package com.example.assignment_tkgd.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment_tkgd.fragment.KhoanChiFragment;
import com.example.assignment_tkgd.fragment.LoaiChiFragment;


public class ViewPager2ChiAdapter extends FragmentStateAdapter {
    public ViewPager2ChiAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0)
            return new LoaiChiFragment();
        return new KhoanChiFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
