package com.immigrant.mobdev.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.immigrant.mobdev.domain.model.BreedImageViewModel;
import com.immigrant.mobdev.presenter.MobDevBasePresenter;
import com.immigrant.mobdev.presenter.implementation.BreedImagesPresenter;
import com.immigrant.mobdev.view.adapter.BreedImageAdapter;
import com.immigrant.mobdev.view.contracts.BreedImagesViewInterface;

import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedCategoryImagesActivity extends MobDevBaseActivity implements BreedImagesViewInterface {

    public static final String BREED_NAME = "BREED_NAME";
    private String breedName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        breedName = getIntent().getStringExtra(BREED_NAME);
    }

    @Override
    MobDevBasePresenter getPresenter() {
        return new BreedImagesPresenter();
    }

    @Override
    void getList() {
        ((BreedImagesPresenter) presenter).fetchBreedImages(breedName);
    }

    @Override
    void onItemClicked(String name) {
        //TODO: Show image
    }

    @Override
    RecyclerView.Adapter getAdapter() {
        return new BreedImageAdapter();
    }

    @Override
    public void updateData(List<BreedImageViewModel> breedViewModelList) {
        ((BreedImageAdapter) adapter).updateData(breedViewModelList);
    }
}
