package com.immigrant.mobdev.presenter;

/**
 * Created by Andres on 01/04/2018.
 */

public interface BasePresenter <T extends BasePresenter.MobDevView>{
    void bind(T view);
    void unBind();


    interface MobDevView {

    }

    interface LoadingInterface extends MobDevView {
        void showLoading();
        void hideLoading();
    }

}
