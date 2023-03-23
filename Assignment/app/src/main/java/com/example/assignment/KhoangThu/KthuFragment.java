package com.example.assignment.KhoangThu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment.KhoangThu.adapter.adapter_ViewPages;
import com.example.assignment.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KthuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KthuFragment extends Fragment {
    private ViewPager2 mViewPages2;
    private TabLayout mTabLayout;
    private adapter_ViewPages adapter_viewPages;


    public KthuFragment() {
        // Required empty public constructor
    }


    public static KthuFragment newInstance() {
        KthuFragment fragment = new KthuFragment();

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
        return inflater.inflate(R.layout.fragment_kthu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPages2=view.findViewById(R.id.id_viewpage);
        mTabLayout=view.findViewById(R.id.id_tablayout);
        adapter_viewPages=new adapter_ViewPages(getActivity());
        mViewPages2.setAdapter(adapter_viewPages);

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(mTabLayout, mViewPages2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
               switch (position){
                   case 0:
                      tab.setText("Khoản Thu");
                      break;
                   case 1:
                       tab.setText("Loại Thu");
                       break;
               }


            }
        });
        tabLayoutMediator.attach();

    }
}