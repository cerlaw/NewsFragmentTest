package com.example.dell.fragmentpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by DELL on 2016/11/6.
 */

public class NewsContentFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    public void refresh(String newsTitle,String newsContent){
        View visibilitylayout = view.findViewById(R.id.visibility_layout);
        visibilitylayout.setVisibility(View.VISIBLE);
        TextView newsTileText = (TextView) view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView) view.
                findViewById(R.id.news_content);
        newsTileText.setText(newsTitle);
        newsContentText.setText(newsContent);
    }
}
