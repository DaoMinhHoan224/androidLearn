package com.example.assignment_tkgd.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.assignment_tkgd.R;
import com.example.assignment_tkgd.adapter.ViewPager2ThuAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ThuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thu_fragment, container, false);

        TabLayout tabLayoutThu = view.findViewById(R.id.tabLayoutThu);
        ViewPager2 viewPager2Thu = view.findViewById(R.id.viewPager2Thu);

        ViewPager2ThuAdapter adapter = new ViewPager2ThuAdapter(getActivity());
        viewPager2Thu.setAdapter(adapter);

        new TabLayoutMediator(tabLayoutThu, viewPager2Thu, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Loại thu");
                }else {
                    tab.setText("Khoản thu");
                }
            }
        }).attach();

        return view;
    }
}
