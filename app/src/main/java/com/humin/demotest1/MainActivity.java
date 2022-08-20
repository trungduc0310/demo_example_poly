package com.humin.demotest1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private TextView tvTabAdd, tvTabList;
    private ViewPager2 vpMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIdView();
        initTab();
        initViewPager();
    }

    private void initViewPager() {
        CustomViewPagerMainAdapter adapterVP = new CustomViewPagerMainAdapter(this);
        vpMain.setAdapter(adapterVP);
        vpMain.setCurrentItem(0);
    }

    private void initTab() {
        tvTabList.setSelected(true);
        tvTabAdd.setSelected(false);
        tvTabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTabList.setSelected(false);
                tvTabAdd.setSelected(true);
                vpMain.setCurrentItem(1);
            }
        });

        tvTabList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTabList.setSelected(true);
                tvTabAdd.setSelected(false);
                vpMain.setCurrentItem(0);
            }
        });
    }

    private void findViewByIdView() {
        tvTabAdd = findViewById(R.id.tv_tab_add_staff);
        tvTabList = findViewById(R.id.tv_tab_list_staff);
        vpMain = findViewById(R.id.vp_main_screen);
    }
}
