package com.example.testlan3.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testlan3.fragment.dsgiaovienFragment;
import com.example.testlan3.fragment.themgiaovienFragment;

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
                fragment=new dsgiaovienFragment();
                break;
            case 1:
                fragment=new themgiaovienFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
