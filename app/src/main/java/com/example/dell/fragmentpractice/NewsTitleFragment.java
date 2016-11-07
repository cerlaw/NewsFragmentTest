package com.example.dell.fragmentpractice;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/11/6.
 */

public class NewsTitleFragment extends Fragment implements
        AdapterView.OnItemClickListener {
    private ListView newsTitleListView;

    private List<News> newsList;

    private NewsAdapter adapter;

    private boolean isTwoPane;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newsList = getNews();
        adapter = new NewsAdapter(context, R.layout.news_item,newsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView = (ListView) view.findViewById(R.id.
                news_title_list_view);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if(getActivity().findViewById(R.id.news_content_layout)!=null){
//            isTwoPane = true;
//        }else {
//            isTwoPane = false;
//        }
        isTwoPane = false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = newsList.get(position);
        if(isTwoPane){
            NewsContentFragment newsContentFragment = (NewsContentFragment)
                    getFragmentManager().findFragmentById(R.id.
                            news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        }else {
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),
                    news.getContent());
        }
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("wewrfofs dfjisdfnf disfjisd sdfjisd");
        news1.setContent("sdfhuashdfua asdfhusdahs adfusadbfuasbf " +
                "sdfsabfusadfas fuasbfj afusa f safjabsdf asdfbuasf asdfbuas " +
                "df sfasngihwrg wrmg jwrbgsfgknas");
        News news2 = new News();
        news2.setTitle("shudhudv nidsn visdnvi vkdnvcx vkjsek");
        news2.setContent("dfh wfus dfue fuwrwirj2 iiwergs iqf w fqwefa eqiw" +
                "fhqweuh aifias iwenfiasd awefiahf uqd fauefihaeffasfkoake" +
                "fauhfuashd awjefoqdkjfisyg aiejfif asnfahwiefiafafnawie");
        newsList.add(news1);
        newsList.add(news2);
        return newsList;
    }
}
