package com.example.assignment.ThongKe;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment.KhoangChi.Khoanchi.DAO.KhoanchiDAO;
import com.example.assignment.KhoangThu.Khoanthu.DAO.KhoanthuDAO;
import com.example.assignment.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TkeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TkeFragment extends Fragment implements OnChartValueSelectedListener {
     KhoanthuDAO khoanthuDAO;
     KhoanchiDAO khoanchiDAO;


    public TkeFragment() {
        // Required empty public constructor
    }


    public static TkeFragment newInstance() {
        TkeFragment fragment = new TkeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tke,container,false);

        khoanthuDAO=new KhoanthuDAO(getContext());
        khoanchiDAO=new KhoanchiDAO(getContext());

        // Inflate the layout for this fragment
        PieChart mChart=view.findViewById(R.id.piechart);
        mChart.setRotationEnabled(true);
        mChart.setDescription(new Description());
        mChart.setHoleRadius(35f);
        mChart.setTransparentCircleAlpha(0);
        mChart.setCenterText("Thống kê");
        mChart.setCenterTextSize(10);
        mChart.setDrawEntryLabels(true);
        addDataSetThu(mChart);


        return view;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }



            private void addDataSetThu(PieChart pieChart) {
                float[] yDatathu = khoanthuDAO.getThongTinThuChi();
                String[] xDatathu = { "Khoản thu","Khoản chi" };

                ArrayList<PieEntry> entrys = new ArrayList<>();
                for (int i = 0; i < yDatathu.length; i++) {
                    entrys.add(new PieEntry(yDatathu[i], xDatathu[i]));
                }
                PieDataSet pieDataSet = new PieDataSet(entrys, " ");
                pieDataSet.setSliceSpace(2);
                pieDataSet.setValueTextSize(12);
                ArrayList<Integer> colors = new ArrayList<>();
                colors.add(Color.BLUE);
                colors.add(Color.RED);
                pieDataSet.setColors(colors);
                Legend legend = pieChart.getLegend();
                legend.setForm(Legend.LegendForm.CIRCLE);
                PieData pieData = new PieData(pieDataSet);
                pieChart.setData(pieData);
                pieChart.invalidate();
            }

//
        }
