package com.immigrant.mobdev.entity.mapper;

import com.immigrant.mobdev.entity.model.BreedImageModel;
import com.immigrant.mobdev.entity.response_model.BreedImageResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres on 01/04/2018.
 */

public class BreedImageMapper {
    public static List<BreedImageModel> transform(BreedImageResponse breedImageResponse){

        List<BreedImageModel> breedImageModelList = new ArrayList<>();
        for (String name : breedImageResponse.message){
            BreedImageModel model = new BreedImageModel(name);
            breedImageModelList.add(model);
        }
        return breedImageModelList;
    }
}
