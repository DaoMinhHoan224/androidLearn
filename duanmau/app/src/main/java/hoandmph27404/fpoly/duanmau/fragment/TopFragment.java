package hoandmph27404.fpoly.duanmau.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hoandmph27404.fpoly.duanmau.DAO.ThongKeDAO;
import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.adapter.TopAdapter;
import hoandmph27404.fpoly.duanmau.model.Top;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopFragment extends Fragment {
    ListView lv;
    ArrayList<Top> list;
    TopAdapter adapter;

    public TopFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TopFragment newInstance(String param1, String param2) {
        TopFragment fragment = new TopFragment();

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
        View v=inflater.inflate(R.layout.fragment_top,container,false);
        lv=v.findViewById(R.id.lvTop);
        ThongKeDAO thongKeDAO=new ThongKeDAO(getActivity());
        list=(ArrayList<Top>) thongKeDAO.getTop();
        adapter=new TopAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);
        return v;
    }
}