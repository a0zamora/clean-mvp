package com.immigrant.mobdev.view.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.immigrant.mobdev.R;
import com.immigrant.mobdev.domain.model.BreedViewModel;
import com.immigrant.mobdev.presenter.BasePresenter;
import com.immigrant.mobdev.presenter.MobDevBasePresenter;
import com.immigrant.mobdev.view.adapter.MobDevListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andres on 01/04/2018.
 */

public abstract class MobDevBaseActivity extends AppCompatActivity implements BasePresenter.LoadingInterface, MobDevListAdapter {

    MobDevBasePresenter presenter;
    RecyclerView.Adapter adapter;

    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.loading)
    View loading;

    abstract MobDevBasePresenter getPresenter();
    abstract void getList();
    abstract void onItemClicked(String name);
    abstract RecyclerView.Adapter getAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_list_activity);
        ButterKnife.bind(this);
        presenter = getPresenter();
        adapter = getAdapter();
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) presenter.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter!=null) getList();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) presenter.unBind();
    }

    @Override
    public void showLoading() {
        list.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        list.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
    }

    @Override
    public void onNameClicked(BreedViewModel viewModel) {
        onItemClicked(viewModel.getName());
    }
}
