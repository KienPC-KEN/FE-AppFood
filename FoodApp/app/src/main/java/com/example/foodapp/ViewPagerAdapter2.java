package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter2 extends FragmentStatePagerAdapter {
    public ViewPagerAdapter2(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomePage_Fragment();
            case 1:
                return new Menu_Fragment();
            case 2:
                return new History_Fragment();
            case 3:
                return new More_Fragment();
            default:
                return new HomePage_Fragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        String title = "";
//        switch (position){
//            case 0:
//                title = "Home";
//                break;
//            case 1:
//                title = "Menu";
//                break;
//            case 2:
//                title = "History";
//                break;
//            case 3:
//                title = "More";
//                break;
//
//        }
//        return super.getPageTitle(position);
//    }
}
