package com.example.de2test.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.de2test.fragment.dsGiaovienFragment;
import com.example.de2test.fragment.themGVFragment;

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
                fragment=new dsGiaovienFragment();
                break;
            case 1:
                fragment=new themGVFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
