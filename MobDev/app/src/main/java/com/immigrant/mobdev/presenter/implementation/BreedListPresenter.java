package com.immigrant.mobdev.presenter.implementation;

import com.immigrant.mobdev.domain.uc.ListBreed;
import com.immigrant.mobdev.presenter.MobDevBasePresenter;
import com.immigrant.mobdev.presenter.contracts.BreedListInterface;
import com.immigrant.mobdev.view.contracts.BreedListViewInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedListPresenter extends MobDevBasePresenter<BreedListViewInterface> implements BreedListInterface {
    ListBreed useCase;

    public BreedListPresenter(){
        useCase = new ListBreed();
    }

    @Override
    public void fetchAllBreeds() {

        view().showLoading();
        useCase.execute().observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(new Consumer<List<com.immigrant.mobdev.domain.model.BreedViewModel>>() {
                    @Override
                    public void accept(List<com.immigrant.mobdev.domain.model.BreedViewModel> breedImageModels)
                            throws Exception {
                        view().hideLoading();
                        view().updateData(breedImageModels);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view().hideLoading();
                    }
                });
    }
}
