package com.is.app.internetstory.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.is.app.internetstory.fragments.AddStoryFragment;
import com.is.app.internetstory.fragments.CategoriesFragment;
import com.is.app.internetstory.fragments.StoriesFragment;

/**
 * Created by Giorgos on 11/11/2016.
 */

public class myPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public myPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                StoriesFragment tab1 = new StoriesFragment();
                return tab1;
            case 1:
                CategoriesFragment tab2 = new CategoriesFragment();
                return tab2;
            case 2:
                AddStoryFragment tab3 = new AddStoryFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
