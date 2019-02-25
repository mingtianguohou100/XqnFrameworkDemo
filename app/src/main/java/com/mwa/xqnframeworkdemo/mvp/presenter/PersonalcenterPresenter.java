package com.mwa.xqnframeworkdemo.mvp.presenter;

import android.content.Context;

import com.mwa.xqnframeworkdemo.base.MyBasePresent;
import com.mwa.xqnframeworkdemo.mvp.model.PersonalcenterModel;
import com.mwa.xqnframeworkdemo.mvp.model.api.Callback;
import com.mwa.xqnframeworkdemo.mvp.ui.fragment.PersonalCenterFragment;

public class PersonalcenterPresenter extends MyBasePresent<PersonalcenterModel, PersonalCenterFragment> {
    public PersonalcenterPresenter(Context context, PersonalCenterFragment view, PersonalcenterModel model) {
        super(context, view, model);
    }

    public PersonalcenterPresenter(PersonalCenterFragment rootView) {
        super(rootView);
    }


    public void requestLogin() {
        mView.showLoading();
        mModel.requestLogin(new Callback() {
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
