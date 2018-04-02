package com.immigrant.mobdev.domain.uc;

import com.immigrant.mobdev.domain.model.BreedViewModel;
import com.immigrant.mobdev.domain.uc.contracts.ListBreedInterface;
import com.immigrant.mobdev.domain.wrapper.ListBreedWrapper;
import com.immigrant.mobdev.entity.model.BreedModel;
import com.immigrant.mobdev.repository.BreedDataRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Andres on 01/04/2018.
 */

public class ListBreed implements ListBreedInterface{
    BreedDataRepository repository;

    public ListBreed(){
        repository = new BreedDataRepository();
    }


    @Override
    public Observable<List<BreedViewModel>> execute() {
        return repository.fetchAll().map(new Function<List<BreedModel>, List<BreedViewModel>>() {
            @Override
            public List<BreedViewModel> apply(List<BreedModel> breedModels) throws Exception {
                return ListBreedWrapper.transform(breedModels);
            }
        });
    }
}
