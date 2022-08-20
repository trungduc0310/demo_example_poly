package com.humin.demotest1;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

public class ListStaffFragment extends Fragment {

    public static ListStaffFragment newInstance(){
        return new ListStaffFragment();
    }

    private RecyclerView rvListStaff;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListStaffAdapter listStaffAdapter;
    private StaffDAO staffDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_staff,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findByViewIdView(view);
        initRecyclerViewAdapter();
        initStaffDAO();
        getListStaffDB();
    }

    private void initStaffDAO() {
        MyDatabaseOpenHelper myOpenHelper = new MyDatabaseOpenHelper(requireContext());
        SQLiteDatabase sqLiteDatabase = myOpenHelper.getWritableDatabase();
        staffDAO = new StaffDAO(sqLiteDatabase);
    }

    private void findByViewIdView(View view) {
        rvListStaff = view.findViewById(R.id.rv_list_staff);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        rvListStaff.setLayoutManager(new LinearLayoutManager(requireContext()));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // get List staff trong nay
                swipeRefreshLayout.setRefreshing(false);
                getListStaffDB();
            }
        });
    }

    private void getListStaffDB() {
        ArrayList<Staff> staffArrayList = staffDAO.getListAllStaff();
        listStaffAdapter.setListStaff(staffArrayList);
    }

    private void initRecyclerViewAdapter() {
        listStaffAdapter = new ListStaffAdapter(getContext());
        rvListStaff.setAdapter(listStaffAdapter);
    }
}
