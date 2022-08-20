package com.humin.demotest1;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddStaffFragment extends Fragment {

    private TextView tvBirthday, btnAdd, btnCancel;
    private EditText edtName, edtDepartment;
    private RelativeLayout conBirthDay;
    private StaffDAO staffDAO;

    public static AddStaffFragment newInstance(){
        return new AddStaffFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_staff,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViewByIdView(view);
        initClickView();
        initStaffDAO();
    }

    private void initStaffDAO() {
        MyDatabaseOpenHelper myOpenHelper = new MyDatabaseOpenHelper(requireContext());
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();
        staffDAO = new StaffDAO(sqLiteDatabase);
    }

    private void initClickView() {
        conBirthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInputData();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputData()){
                    // thực hiện thêm mấy cái đã nhập vào db
                    String name = edtName.getText().toString();
                    int department = Integer.parseInt(edtDepartment.getText().toString());
                    String birthday = tvBirthday.getText().toString();
                    Staff staff = new Staff(name,birthday,department);
                    staffDAO.insertStaff(staff);
                    clearInputData();
                }
            }
        });
    }

    private boolean validateInputData() {
        String checkName = edtName.getText().toString();
        String checkDepartment = edtDepartment.getText().toString();
        String checkBirthday = tvBirthday.getText().toString();
        if (checkName.isEmpty()){
            // show err
            return false;
        }
        if (checkBirthday.isEmpty()){
            return false;
        }
        if (checkDepartment.isEmpty()){
            return false;
        }
        return true;
    }

    private void clearInputData() {
        edtName.setText("");
        edtDepartment.setText("");
        tvBirthday.setText("");
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int dOm) {
                String selectDate = dOm + "-" + m + "-" + y;
                tvBirthday.setText(selectDate);
            }
        }, 2022, 8, 20);
        datePickerDialog.show();
    }

    private void findViewByIdView(View view) {
        tvBirthday = view.findViewById(R.id.tv_input_birthday_staff);
        btnAdd = view.findViewById(R.id.btn_add);
        btnCancel = view.findViewById(R.id.btn_cancel);
        edtName = view.findViewById(R.id.edt_input_name_staff);
        edtDepartment = view.findViewById(R.id.edt_input_department_staff);
        conBirthDay = view.findViewById(R.id.con_birthday);
    }
}
