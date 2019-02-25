package com.mwa.xqnframeworkdemo.mvp.presenter;

import android.content.Context;

import com.mwa.xqnframeworkdemo.base.MyBasePresent;
import com.mwa.xqnframeworkdemo.mvp.model.HomeModel;
import com.mwa.xqnframeworkdemo.mvp.model.api.Callback;
import com.mwa.xqnframeworkdemo.mvp.ui.fragment.HomeFragment;

public class HomePresenter extends MyBasePresent<HomeModel, HomeFragment> {

    public HomePresenter(Context context, HomeFragment view, HomeModel model) {
        super(context, view, model);
    }

    public HomePresenter(HomeFragment rootView) {
        super(rootView);
    }

    public void requestHomeData() {
        mView.showLoading();
        mModel.requestHomeData(new Callback() {
            @Override
            public void onSuccess(String json) {
                mView.onSuccess(json);
            }

            @Override
            public void onErro(String msg) {
                mView.onErro(msg);
            }

            @Override
            public void onFinish() {
                mView.hideLoading();
            }
        });
    }

}
