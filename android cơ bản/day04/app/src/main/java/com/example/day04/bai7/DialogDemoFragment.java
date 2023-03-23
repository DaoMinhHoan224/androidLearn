package com.example.day04.bai7;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.day04.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogDemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogDemoFragment extends Fragment implements View.OnClickListener {
    private Button btnSimDialog;
    private Button btnItemDialog;
    private String arraymonhoc[]={"PHP","Android","IOS","Web"};
    private Button btnChoiceItemDialog;
    private Button btnMultiChoiceItemDialog;
    private String temp;
    private boolean checkSubject[]={false,false,false,false};

    public DialogDemoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DialogDemoFragment newInstance() {
        DialogDemoFragment fragment = new DialogDemoFragment();

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
        return inflater.inflate(R.layout.fragment_dialog_demo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSimDialog=view.findViewById(R.id.btnSimDialog);
        btnSimDialog.setOnClickListener(this);
        btnItemDialog=view.findViewById(R.id.btnItemDialog);
        btnItemDialog.setOnClickListener(this);
        btnChoiceItemDialog=view.findViewById(R.id.btnChoiceItemDialog);
        btnChoiceItemDialog.setOnClickListener(this);
        btnMultiChoiceItemDialog=view.findViewById(R.id.btnMultiChoiceItemDialog);
        btnMultiChoiceItemDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSimDialog:
                showSimDialog();
                break;
            case R.id.btnItemDialog:
                showItemDialog();
                break;
            case R.id.btnChoiceItemDialog:
                showChoiceItemDialog();
                break;
            case R.id.btnMultiChoiceItemDialog:
                showMultiChoiceItemDialog();
                break;
        }
    }

    private void showSimDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Lời nói thật!");
        builder.setMessage("Bạn có người yêu chưa?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Mình có rồi", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Mình chưa có", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void showItemDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Các môn học");
        builder.setItems(arraymonhoc, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), arraymonhoc[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void showChoiceItemDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Các môn học");
        builder.setSingleChoiceItems(arraymonhoc, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                temp=arraymonhoc[which];
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), temp, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void showMultiChoiceItemDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Các môn học");
        builder.setMultiChoiceItems(arraymonhoc, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkSubject[which]=isChecked;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                temp="";
                for (int j=0;j<checkSubject.length;j++){
                    if (checkSubject[j]) {
                        temp += arraymonhoc[j];
                    }
                }
                Toast.makeText(getActivity(), temp, Toast.LENGTH_SHORT).show();
                for (int j=0;j<checkSubject.length;j++){
                    checkSubject[j]=false;
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}