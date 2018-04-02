package com.immigrant.mobdev.view.contracts;

import com.immigrant.mobdev.domain.model.BreedViewModel;
import com.immigrant.mobdev.presenter.BasePresenter;

import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public interface BreedListViewInterface extends BasePresenter.LoadingInterface {

    void updateData(List<BreedViewModel> breedViewModelList);

}
