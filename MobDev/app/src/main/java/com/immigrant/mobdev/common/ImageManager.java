package com.immigrant.mobdev.common;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Andres on 01/04/2018.
 */

public class ImageManager {

    public static void renderImage(ImageView imageView, String url){
        Picasso.get().load(url).into(imageView);
    }

}
