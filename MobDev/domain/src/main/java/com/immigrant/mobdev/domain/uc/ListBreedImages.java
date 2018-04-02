package com.immigrant.mobdev.domain.uc;

import com.immigrant.mobdev.domain.model.BreedImageViewModel;
import com.immigrant.mobdev.domain.uc.contracts.ListBreedImagesInterface;
import com.immigrant.mobdev.domain.wrapper.ListBreedImagesWrapper;
import com.immigrant.mobdev.entity.model.BreedImageModel;
import com.immigrant.mobdev.repository.BreedDataRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Andres on 01/04/2018.
 */

public class ListBreedImages implements ListBreedImagesInterface{
    BreedDataRepository breedDataRepository;

    public ListBreedImages(){
        breedDataRepository =  new BreedDataRepository();
    }

    @Override
    public Observable<List<BreedImageViewModel>> execute(String name) {
        return breedDataRepository.fetchBreedImages(name).map(new Function<List<BreedImageModel>, List<BreedImageViewModel>>() {
            @Override
            public List<BreedImageViewModel> apply(List<BreedImageModel> breedModels) throws Exception {
                return ListBreedImagesWrapper.transform(breedModels);
            }
        });
    }
}
