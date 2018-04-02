package com.immigrant.mobdev.domain.uc.contracts;

import com.immigrant.mobdev.domain.model.BreedImageViewModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andres on 01/04/2018.
 */

public interface ListBreedImagesInterface {
    Observable<List<BreedImageViewModel>> execute(String name);
}
