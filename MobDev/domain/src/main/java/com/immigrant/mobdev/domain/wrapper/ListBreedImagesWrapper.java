package com.immigrant.mobdev.domain.wrapper;

import com.immigrant.mobdev.domain.model.BreedImageViewModel;
import com.immigrant.mobdev.entity.model.BreedImageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class ListBreedImagesWrapper {

    public static List<BreedImageViewModel> transform(List<BreedImageModel> list){

        List<BreedImageViewModel> breedModelList = new ArrayList<>();
        for (BreedImageModel business : list){
            BreedImageViewModel model = new BreedImageViewModel(business.getName());
            breedModelList.add(model);
        }
        return breedModelList;
    }
}
