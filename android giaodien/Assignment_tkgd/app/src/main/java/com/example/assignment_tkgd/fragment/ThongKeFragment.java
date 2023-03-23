//package com.example.assignment_tkgd.fragment;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//
//import com.example.assignment_tkgd.R;
//import com.example.assignment_tkgd.dao.ThuChiDAO;
//
//import java.util.ArrayList;
//
//public class ThongKeFragment extends Fragment implements OnChartValueSelectedListener {
//   ThuChiDAO thuChiDAO;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.thongke_fragment, container, false);
//
//        thuChiDAO = new ThuChiDAO(getContext());
//
//        PieChart mChart = view.findViewById(R.id.piechart);
//        mChart.setRotationEnabled(true);
//        mChart.setDescription(new Description());
//        mChart.setHoleRadius(35f);
//        mChart.setTransparentCircleAlpha(0);
//        mChart.setCenterText("Thống kê");
//        mChart.setCenterTextSize(10);
//        mChart.setDrawEntryLabels(true);
//        addDataSet(mChart);
//        mChart.setOnChartValueSelectedListener(this);
//
//        return view;
//    }
//
//    @Override
//    public void onValueSelected(Entry e, Highlight h) {
//
//    }
//
//    @Override
//    public void onNothingSelected() {
//
//    }
//
//    private void addDataSet(PieChart pieChart) {
//        float[] yData = thuChiDAO.getThongTinThuChi();
//        String[] xData = { "Khoản thu", "Khoản chi" };
//
//        ArrayList<PieEntry> entrys = new ArrayList<>();
//        for (int i = 0; i < yData.length; i++) {
//            entrys.add(new PieEntry(yData[i], xData[i]));
//        }
//        PieDataSet pieDataSet = new PieDataSet(entrys, " ");
//        pieDataSet.setSliceSpace(2);
//        pieDataSet.setValueTextSize(12);
//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.BLUE);
//        colors.add(Color.RED);
//        pieDataSet.setColors(colors);
//        Legend legend = pieChart.getLegend();
//        legend.setForm(Legend.LegendForm.CIRCLE);
//        PieData pieData = new PieData(pieDataSet);
//        pieChart.setData(pieData);
//        pieChart.invalidate();
//    }
//}
