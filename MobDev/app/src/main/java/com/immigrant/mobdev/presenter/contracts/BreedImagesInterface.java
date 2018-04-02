package com.immigrant.mobdev.presenter.contracts;

import com.immigrant.mobdev.presenter.BasePresenter;
import com.immigrant.mobdev.view.contracts.BreedImagesViewInterface;

/**
 * Created by Andres on 01/04/2018.
 */

public interface BreedImagesInterface extends BasePresenter<BreedImagesViewInterface> {

    public void fetchBreedImages(String name);

}
