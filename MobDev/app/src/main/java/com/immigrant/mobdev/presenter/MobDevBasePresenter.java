package com.immigrant.mobdev.presenter;

/**
 * Created by Andres on 01/04/2018.
 */

public class MobDevBasePresenter <T extends BasePresenter.MobDevView> implements BasePresenter<T> {
    private T mView;
    @Override
    public void bind(T view) {
        mView = view;
    }

    @Override
    public void unBind() {
        mView = null;
    }

    public T view(){
        return mView;
    }
}
