package com.mwa.xqnframeworkdemo.mvp.contract;

import android.app.Activity;

import com.mwa.xqnframeworkdemo.base.IModel;
import com.mwa.xqnframeworkdemo.base.IView;
import com.mwa.xqnframeworkdemo.mvp.model.api.Callback;


public interface PersonalcenterContract {
    interface View extends IView {

    }

    interface Model extends IModel {
         void  requestLogin(Callback callback);
    }
}
