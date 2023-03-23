package com.example.day04.bai6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day04.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Context_popup_MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Context_popup_MenuFragment extends Fragment implements View.OnClickListener {
    private TextView tv_contextmenu;
    private Button btn_popupmenu;

    public Context_popup_MenuFragment() {

    }


    public static Context_popup_MenuFragment newInstance() {
        Context_popup_MenuFragment fragment = new Context_popup_MenuFragment();

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
        return inflater.inflate(R.layout.fragment_context_popup__menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_popupmenu=view.findViewById(R.id.btn_popupmenu);
        btn_popupmenu.setOnClickListener(this);
        tv_contextmenu=view.findViewById(R.id.tv_contextMenu);
        tv_contextmenu.setOnClickListener(this);
        registerForContextMenu(tv_contextmenu);

    }


    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(getActivity(), "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.account:
                Toast.makeText(getActivity(), "Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Logout:
                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_popupmenu:
                PopupMenu popupmenu=new PopupMenu(getActivity(),v);
                getActivity().getMenuInflater().inflate(R.menu.context_menu,popupmenu.getMenu());
                popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.setting:
                                Toast.makeText(getActivity(), "Setting", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.account:
                                Toast.makeText(getActivity(), "Account", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.Logout:
                                Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupmenu.show();
                break;
            case R.id.tv_contextMenu:
                v.showContextMenu();
        }
    }

}