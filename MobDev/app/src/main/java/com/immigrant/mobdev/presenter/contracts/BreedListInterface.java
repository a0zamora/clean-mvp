package com.immigrant.mobdev.presenter.contracts;

import com.immigrant.mobdev.presenter.BasePresenter;
import com.immigrant.mobdev.view.contracts.BreedListViewInterface;

/**
 * Created by Andres on 01/04/2018.
 */

public interface BreedListInterface extends BasePresenter<BreedListViewInterface> {

    public void fetchAllBreeds();

}
