package com.is.app.internetstory.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.is.app.internetstory.R;

/**
 * Created by Giorgos on 11/11/2016.
 */

public class AddStoryFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_story_tab, container, false);
    }
}
