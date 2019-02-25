package com.mwa.xqnframeworkdemo.mvp.model;

import com.mwa.xqnframeworkdemo.base.MyBaseModel;
import com.mwa.xqnframeworkdemo.mvp.contract.HomeContract;
import com.mwa.xqnframeworkdemo.mvp.model.api.Callback;

public class HomeModel extends MyBaseModel implements HomeContract.Model {
    @Override
    public void requestHomeData(Callback callback) {
        mNetWork.requestHomeData(callback);
    }

}
