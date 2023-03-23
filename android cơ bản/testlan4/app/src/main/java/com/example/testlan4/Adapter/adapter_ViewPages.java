package com.example.testlan4.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testlan4.Fragment.danhsachgvFragment;
import com.example.testlan4.Fragment.themgvFragment;

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
