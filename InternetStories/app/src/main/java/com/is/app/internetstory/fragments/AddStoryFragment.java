package com.is.app.internetstory.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.is.app.internetstory.MainActivity;
import com.is.app.internetstory.R;
import com.is.app.internetstory.addGIF;
import com.is.app.internetstory.addImage;
import com.is.app.internetstory.addText;

/**
 * Created by Giorgos on 11/11/2016.
 */

public class AddStoryFragment extends Fragment {

    private View view;
    private TextView addImageTV;
    private TextView addGIFTV;
    private TextView addTextTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null)
        {
            view = inflater.inflate(R.layout.add_story_tab, container, false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        addImageTV = (TextView) view.findViewById(R.id.addImageStory);
        addGIFTV = (TextView) view.findViewById(R.id.addGIFStory);
        addTextTV = (TextView) view.findViewById(R.id.addTextStory);

        addImageTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), addImage.class);
                startActivity(intent);
            }
        });

        addGIFTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), addGIF.class);
                startActivity(intent);
            }
        });

        addTextTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), addText.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
