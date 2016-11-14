package com.is.app.internetstory.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.is.app.internetstory.R;
import com.is.app.internetstory.db.DatabaseHelper;
import com.is.app.internetstory.models.Story;
import com.squareup.picasso.Picasso;

/**
 * Created by Giorgos on 11/11/2016.
 */

public class StoriesFragment extends Fragment {

    View view;
    ImageView imageView;
    TextView getStory;

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
        getStory = (TextView) view.findViewById(R.id.tvGetStory);

        final DatabaseHelper db = new DatabaseHelper(getActivity());

        Story s1 = new Story();
        Story s2 = new Story();
        Story s3 = new Story();
        s1.setId(1);
        s2.setId(2);
        s3.setId(3);
        s1.setUrl("https://cdn.meme.am/instances/500x/55506023.jpg");
        s2.setUrl("http://www.frackfeed.com/wp-content/uploads/2016/08/donaldtrump_fracking_meme.jpg");
        s3.setUrl("http://cdn.smosh.com/sites/default/files/ftpuploads/bloguploads/0913/harry-potter-memes-potter-lookin-fine.jpg");

        db.addStory(s1);
        db.addStory(s2);
        db.addStory(s3);

        getStory.setOnClickListener(new View.OnClickListener() {
            int id = 1;
            @Override
            public void onClick(View view) {
                Story s = db.getStory(id);
                Picasso.with(getActivity())
                        .load(s.getUrl())
                        .fit()
                        .into(imageView);
                id++;
                if(id==4) id =1;
            }
        });

        return view;

    }
}
