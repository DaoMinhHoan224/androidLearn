package hoandmph27404.fpoly.duanmau.fragment;

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
 * Use the {@link AddUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddUserFragment extends Fragment {
    Button btnCancel, btnSave;
    EditText edUser,edHoten,edPass,edRePass;
    ThuThuDAO dao;

    public AddUserFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AddUserFragment newInstance() {
        AddUserFragment fragment = new AddUserFragment();

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
        return inflater.inflate(R.layout.fragment_add_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCancel=view.findViewById(R.id.btnCancelAdd);
        btnSave=view.findViewById(R.id.btnSaveAdd);
        edUser=view.findViewById(R.id.edUser);
        edHoten=view.findViewById(R.id.edHoTen);
        edPass=view.findViewById(R.id.edPassChange);
        edRePass=view.findViewById(R.id.edRePassChange);

        dao=new ThuThuDAO(getActivity());
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUser.setText("");
                edHoten.setText("");
                edPass.setText("");
                edRePass.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThuThu thuThu=new ThuThu();
                thuThu.setMaTT(edUser.getText().toString());
                thuThu.setHoTen(edHoten.getText().toString());
                thuThu.setMatKhau(edPass.getText().toString());
                if (validate()>0){
                    if (dao.insert(thuThu)>0){
                        Toast.makeText(getActivity(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                        edUser.setText("");
                        edHoten.setText("");
                        edPass.setText("");
                        edRePass.setText("");
                    }else{
                        Toast.makeText(getActivity(), "Lưu thất bại ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public int validate(){
        int check=1;
        if (edUser.getText().length()==0 || edHoten.getText().length()==0 || edPass.getText().length()==0
        || edRePass.getText().length()==0){
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check=-1;
        }else{
            String pass= edPass.getText().toString();
            String rePass=edRePass.getText().toString();
            if (!pass.equals(rePass)){
                Toast.makeText(getContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check=-1;
            }
        }
        return  check;
    }
}