package com.immigrant.mobdev.view.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.immigrant.mobdev.domain.model.BreedViewModel;
import com.immigrant.mobdev.presenter.MobDevBasePresenter;
import com.immigrant.mobdev.presenter.implementation.BreedListPresenter;
import com.immigrant.mobdev.view.adapter.BreedNamesAdapter;
import com.immigrant.mobdev.view.contracts.BreedListViewInterface;

import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedListActivity extends MobDevBaseActivity implements BreedListViewInterface{

    @Override
    MobDevBasePresenter getPresenter() {
        return new BreedListPresenter();
    }

    @Override
    void getList() {
        ((BreedListPresenter) presenter).fetchAllBreeds();

    }

    @Override
    RecyclerView.Adapter getAdapter() {
        return new BreedNamesAdapter();
    }

    @Override
    void onItemClicked(String name) {
        Intent intent = new Intent(this, BreedCategoryImagesActivity.class);
        intent.putExtra(BreedCategoryImagesActivity.BREED_NAME,name);
        startActivity(intent);
    }


    @Override
    public void updateData(List<BreedViewModel> breedViewModelList) {
        ((BreedNamesAdapter) adapter).updateData(breedViewModelList);
    }
}
