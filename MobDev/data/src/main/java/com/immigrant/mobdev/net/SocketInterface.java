package com.immigrant.mobdev.net;

import com.immigrant.mobdev.entity.response_model.BreedImageResponse;
import com.immigrant.mobdev.entity.response_model.BreedResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Andres on 31/03/2018.
 */

public interface SocketInterface {

    @GET("api/breeds/list")
    Observable<BreedResponse> getAllBreeds();
    @GET("api/breed/{name}/images")
    Observable<BreedImageResponse> getBreedImages(@Path("name") String breedName);

}
