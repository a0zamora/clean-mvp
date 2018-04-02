package com.immigrant.mobdev.net;

import com.immigrant.mobdev.entity.mapper.BreedImageMapper;
import com.immigrant.mobdev.entity.mapper.BreedMapper;
import com.immigrant.mobdev.entity.model.BreedImageModel;
import com.immigrant.mobdev.entity.model.BreedModel;
import com.immigrant.mobdev.entity.response_model.BreedImageResponse;
import com.immigrant.mobdev.entity.response_model.BreedResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Andres on 01/04/2018.
 */

public class ApiImpl implements ApiInterface {
    ApiSocket socket;

    public ApiImpl(){
        socket = new ApiSocket();
    }

    @Override
    public Observable<List<BreedModel>> getAllBreeds() {
        return socket.generateConnector().getAllBreeds().map(new Function<BreedResponse, List<BreedModel>>() {
            @Override
            public List<BreedModel> apply(BreedResponse breedResponse) throws Exception {
                return BreedMapper.transform(breedResponse);
            }
        });
    }

    @Override
    public Observable<List<BreedImageModel>> getBreedImages(String name) {
        return socket.generateConnector().getBreedImages(name)
                .map(new Function<BreedImageResponse, List<BreedImageModel>>() {
            @Override
            public List<BreedImageModel> apply(BreedImageResponse breedImageResponse) throws Exception {
                return BreedImageMapper.transform(breedImageResponse);
            }
        });
    }

}
