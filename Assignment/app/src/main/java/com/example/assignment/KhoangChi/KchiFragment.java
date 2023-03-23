package com.example.assignment.KhoangChi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment.KhoangChi.adapter_khoangchiViewpages.adapter_khoangchiviewpages;
import com.example.assignment.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KchiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KchiFragment extends Fragment {
    private ViewPager2 mViewPagerchi;
    private TabLayout layoutchi;
    private adapter_khoangchiviewpages adapter_khoangchiviewpages;


    public KchiFragment() {
        // Required empty public constructor
    }


    public static KchiFragment newInstance() {
        KchiFragment fragment = new KchiFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kchi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPagerchi=view.findViewById(R.id.id_viewpagechi);
        layoutchi=view.findViewById(R.id.id_tablayoutchi);
        adapter_khoangchiviewpages=new adapter_khoangchiviewpages(getActivity());
        mViewPagerchi.setAdapter(adapter_khoangchiviewpages);

        TabLayoutMediator tabLayoutMediatorchi=new TabLayoutMediator(layoutchi, mViewPagerchi, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Khoản Chi");
                        break;
                    case 1:
                        tab.setText("Loại Chi");
                        break;
                }
            }
        });
        tabLayoutMediatorchi.attach();
    }
}