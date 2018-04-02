package com.immigrant.mobdev.domain.wrapper;

import com.immigrant.mobdev.domain.model.BreedViewModel;
import com.immigrant.mobdev.entity.model.BreedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class ListBreedWrapper {

    public static List<BreedViewModel> transform(List<BreedModel> list){

        List<BreedViewModel> breedModelList = new ArrayList<>();
        for (BreedModel business : list){
            BreedViewModel model = new BreedViewModel(business.getName());
            breedModelList.add(model);
        }
        return breedModelList;
    }

}
