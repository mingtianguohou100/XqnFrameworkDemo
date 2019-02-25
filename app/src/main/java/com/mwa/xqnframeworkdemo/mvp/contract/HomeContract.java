package com.mwa.xqnframeworkdemo.mvp.contract;

import android.app.Activity;

import com.mwa.xqnframeworkdemo.base.IModel;
import com.mwa.xqnframeworkdemo.base.IView;
import com.mwa.xqnframeworkdemo.mvp.model.api.Callback;

import java.util.List;

public interface HomeContract {
    interface View extends IView {

    }

    interface Model extends IModel {
        void requestHomeData(Callback callback);
    }
}
