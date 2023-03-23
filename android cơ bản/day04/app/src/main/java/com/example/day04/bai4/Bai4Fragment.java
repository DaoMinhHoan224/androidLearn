package com.example.day04.bai4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day04.R;
import com.example.day04.bai4.adapter.Adapter_Viewpager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bai4Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bai4Fragment extends Fragment {
     private ViewPager2 mViewPager2;
     private TabLayout mTabLayout;
     private Adapter_Viewpager adapter_viewpager;

    public Bai4Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Bai4Fragment newInstance() {
        Bai4Fragment fragment = new Bai4Fragment();

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
        return inflater.inflate(R.layout.fragment_bai4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager2=view.findViewById(R.id.id_viewpage);
        mTabLayout=view.findViewById(R.id.id_tablayout);
        adapter_viewpager=new Adapter_Viewpager(getActivity());
        mViewPager2.setAdapter(adapter_viewpager);

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Gridview");
                        break;
                    case 1:
                        tab.setText("Listview");
                        break;
                    case 2:
                        tab.setText("Spinner");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }
}