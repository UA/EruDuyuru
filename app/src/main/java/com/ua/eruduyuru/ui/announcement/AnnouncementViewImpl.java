package com.ua.eruduyuru.ui.announcement;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ua.eruduyuru.R;
import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;
import com.ua.eruduyuru.ui.base.BaseActivity;
import com.ua.eruduyuru.ui.main.MainAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnnouncementViewImpl extends BaseActivity implements AnnouncementView {

    @BindView(R.id.articles_recyclerView)
    protected RecyclerView mRecyclerView;

    @Inject
    protected MainAdapter mMainAdapter;

    @Inject
    protected AnnouncementAdapter mAnnouncementAdapter;

    @Inject
    AnnouncementPresenter<AnnouncementView> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    private List<Article> articles;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(AnnouncementViewImpl.this);

        url = getIntent().getStringExtra("url");
        if (!url.isEmpty()) {
            setUp();
        }
    }


    @Override
    protected void setUp() {
        articles = mAnnouncementAdapter.getArticles();
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAnnouncementAdapter);
        mPresenter.getArticles(url);
    }

    @Override
    public void onRetrieveArticles(List<Article> result) {
        articles.addAll(result);
        mAnnouncementAdapter.notifyDataSetChanged();
    }
}
