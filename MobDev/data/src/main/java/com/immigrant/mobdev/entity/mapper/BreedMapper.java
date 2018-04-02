package com.immigrant.mobdev.entity.mapper;

import com.immigrant.mobdev.entity.response_model.BreedResponse;
import com.immigrant.mobdev.entity.model.BreedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedMapper {

    public static List<BreedModel> transform(BreedResponse breedResponse){

        List<BreedModel> breedModelList = new ArrayList<>();
        for (String name : breedResponse.message){
            BreedModel model = new BreedModel(name);
            breedModelList.add(model);
        }
        return breedModelList;
    }

}
