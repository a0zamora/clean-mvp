package com.immigrant.mobdev.presenter.implementation;

import com.immigrant.mobdev.domain.model.BreedImageViewModel;
import com.immigrant.mobdev.domain.uc.ListBreedImages;
import com.immigrant.mobdev.presenter.MobDevBasePresenter;
import com.immigrant.mobdev.presenter.contracts.BreedImagesInterface;
import com.immigrant.mobdev.view.contracts.BreedImagesViewInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedImagesPresenter extends MobDevBasePresenter<BreedImagesViewInterface> implements
        BreedImagesInterface{
    ListBreedImages useCase;

    public BreedImagesPresenter(){
        useCase = new ListBreedImages();
    }

    @Override
    public void fetchBreedImages(String name) {

        view().showLoading();
        useCase.execute(name).observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).subscribe(new Consumer<List<BreedImageViewModel>>() {
            @Override
            public void accept(List<BreedImageViewModel> breedImageModels)
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
