package com.is.app.internetstory.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.is.app.internetstory.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Giorgos on 11/11/2016.
 */

public class StoriesFragment extends Fragment {

    View view;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(view==null)
        {
            view = inflater.inflate(R.layout.stories_tab, container, false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        imageView = (ImageView) view.findViewById(R.id.imgStory);

        String img_url = "https://cdn.meme.am/instances/500x/55506023.jpg";
        Picasso.with(getActivity())
                .load(img_url)
                .fit()
                .into(imageView);

        return view;

    }
}
