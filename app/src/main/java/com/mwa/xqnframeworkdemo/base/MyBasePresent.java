package com.mwa.xqnframeworkdemo.base;

import android.content.Context;


public class MyBasePresent<M extends IModel, V extends IView> implements IPresenter {
    protected V mView;
    protected M mModel;
    protected Context mContext;

    public MyBasePresent(Context context, V view, M model) {
        this.mView = view;
        this.mModel = model;
        this.mContext = context;
        onStart();
    }

    public MyBasePresent(V rootView) {
        this.mView = rootView;
        onStart();
    }

    @Override
    public void onStart() {

    }

    public void onDestroy() {
        if (mModel != null)
            mModel.onDestroy();
        this.mModel = null;
        this.mView = null;
    }
}
