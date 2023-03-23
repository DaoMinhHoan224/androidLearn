package com.dinhnt.asmtutor.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dinhnt.asmtutor.fragment.KhoanChiFragment;
import com.dinhnt.asmtutor.fragment.KhoanThuFragment;
import com.dinhnt.asmtutor.fragment.LoaiChiFragment;
import com.dinhnt.asmtutor.fragment.LoaiThuFragment;

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
