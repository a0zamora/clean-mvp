package com.immigrant.mobdev.repository;

import com.immigrant.mobdev.entity.model.BreedImageModel;
import com.immigrant.mobdev.entity.model.BreedModel;
import com.immigrant.mobdev.net.ApiImpl;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedDataRepository implements BreedDataRepositoryInterface {

    ApiImpl api;

    public BreedDataRepository(){
        api = new ApiImpl();
    }

    @Override
    public Observable<List<BreedModel>> fetchAll() {
        return api.getAllBreeds();
    }

    @Override
    public Observable<List<BreedImageModel>> fetchBreedImages(String name) {
        return api.getBreedImages(name);
    }
}
