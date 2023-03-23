package com.dinhnt.asmtutor.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.dinhnt.asmtutor.R;
import com.dinhnt.asmtutor.adapter.ViewPager2ChiAdapter;
import com.dinhnt.asmtutor.adapter.ViewPager2ThuAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ChiFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chi_fragment, container, false);

        TabLayout tabLayoutChi = view.findViewById(R.id.tabLayoutChi);
        ViewPager2 viewPager2Chi = view.findViewById(R.id.viewPager2Chi);

        ViewPager2ChiAdapter adapter = new ViewPager2ChiAdapter(getActivity());
        viewPager2Chi.setAdapter(adapter);

        new TabLayoutMediator(tabLayoutChi, viewPager2Chi, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Loại chi");
                }else {
                    tab.setText("Khoản chi");
                }
            }
        }).attach();

        return view;
    }
}
