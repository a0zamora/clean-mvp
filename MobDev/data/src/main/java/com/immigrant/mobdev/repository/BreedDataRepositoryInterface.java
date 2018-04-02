package com.immigrant.mobdev.repository;

import com.immigrant.mobdev.entity.model.BreedImageModel;
import com.immigrant.mobdev.entity.model.BreedModel;

import java.util.List;
import io.reactivex.Observable;

/**
 * Created by Andres on 01/04/2018.
 */

public interface BreedDataRepositoryInterface {
    Observable<List<BreedModel>> fetchAll();
    Observable<List<BreedImageModel>> fetchBreedImages(String name);
}
