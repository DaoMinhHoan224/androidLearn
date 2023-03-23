package hoandmph27404.fpoly.duanmau.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hoandmph27404.fpoly.duanmau.DAO.ThuThuDAO;
import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.model.ThuThu;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChangePassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChangePassFragment extends Fragment {
    ThuThuDAO dao;
    Button btnCancel, btnSave;
    EditText edPassOld, edPass, edRePass;

    public ChangePassFragment() {
        // Required empty public constructor
    }


    public static ChangePassFragment newInstance() {
        ChangePassFragment fragment = new ChangePassFragment();

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
        return inflater.inflate(R.layout.fragment_change_pass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCancel=view.findViewById(R.id.btnCancelUserChange);
        btnSave=view.findViewById(R.id.btnSaveUserChange);
        edPass=view.findViewById(R.id.edPassChange);
        edPassOld=view.findViewById(R.id.edPassOld);
        edRePass=view.findViewById(R.id.edRePassChange);
        dao=new ThuThuDAO(getActivity());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edPassOld.setText("");
                edPass.setText("");
                edRePass.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đọc user, pass trong SharedPreferences
                SharedPreferences  pref =getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
                String user=pref.getString("USERNAME","");
                if (validate()>0){
                    ThuThu thuThu=dao.getID(user);
                    thuThu.setMatKhau(edPass.getText().toString());
                    dao.updatePass(thuThu);
                    if (dao.updatePass(thuThu) >0){
                        Toast.makeText(getActivity(), "Thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        edPassOld.setText("");
                        edPass.setText("");
                        edRePass.setText("");
                    }else{
                        Toast.makeText(getActivity(), "Thay đổi mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public int validate(){
        int check=1;
        if (edPassOld.getText().length()==0 || edPass.getText().length()==0 || edRePass.getText().length()==0){
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check=-1;
        }else{
            // đọc user, pass trong sharepreferences
            SharedPreferences pref=getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
            String passOld=pref.getString("PASSWORD","");
            String pass=edPass.getText().toString();
            String rePass=edRePass.getText().toString();
            if (!passOld.equals(edPassOld.getText().toString())){
                Toast.makeText(getContext(), "Mật khẩu cũ sai", Toast.LENGTH_SHORT).show();
                check=-1;
            }
            if (!pass.equals(rePass)){
                Toast.makeText(getContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check=-1;
            }
        }
        return check;
    }
}