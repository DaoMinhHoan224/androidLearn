package com.dinhnt.asmtutor.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dinhnt.asmtutor.fragment.KhoanThuFragment;
import com.dinhnt.asmtutor.fragment.LoaiThuFragment;

public class ViewPager2ThuAdapter extends FragmentStateAdapter {
    public ViewPager2ThuAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0)
            return new LoaiThuFragment();
        return new KhoanThuFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
