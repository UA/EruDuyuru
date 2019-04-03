package com.ua.eruduyuru.ui.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.ua.eruduyuru.R;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;
import com.ua.eruduyuru.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainViewImpl extends BaseActivity implements MainView {
    @Inject
    MainPresenter<MainView> mPresenter;

    private List<Department> departments;

    @BindView(R.id.departments_recyclerView)
    protected RecyclerView mRecyclerView;

    @Inject
    MainAdapter mMainAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(MainViewImpl.this);
        setUp();
    }

    @Override
    protected void setUp() {
        departments = mMainAdapter.getDepartments();
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mMainAdapter);
        mPresenter.getDepartments();
    }

    @Override
    public void onRetrieveDepartments(List<Department> result) {
        departments.addAll(result);
        mMainAdapter.notifyDataSetChanged();
    }
}
