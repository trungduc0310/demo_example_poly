package com.humin.demotest1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomViewPagerMainAdapter extends FragmentStateAdapter {

    public CustomViewPagerMainAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment currentFragment = null;
        switch (position){
            case 0:
                currentFragment = ListStaffFragment.newInstance();
                break;
            case 1:
                currentFragment = AddStaffFragment.newInstance();
                break;
        }
        return currentFragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
