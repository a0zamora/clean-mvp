package com.immigrant.mobdev.net;

import com.immigrant.mobdev.entity.model.BreedImageModel;
import com.immigrant.mobdev.entity.model.BreedModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andres on 01/04/2018.
 */

public interface ApiInterface {

    Observable<List<BreedModel>> getAllBreeds();
    Observable<List<BreedImageModel>> getBreedImages(String name);

}
