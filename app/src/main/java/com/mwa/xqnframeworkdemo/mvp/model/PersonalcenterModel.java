package com.mwa.xqnframeworkdemo.mvp.model;

import com.mwa.xqnframeworkdemo.base.MyBaseModel;
import com.mwa.xqnframeworkdemo.mvp.contract.HomeContract;
import com.mwa.xqnframeworkdemo.mvp.contract.PersonalcenterContract;
import com.mwa.xqnframeworkdemo.mvp.model.api.Callback;

public class PersonalcenterModel extends MyBaseModel implements PersonalcenterContract.Model{
    @Override
    public void requestLogin(Callback callback) {
        mNetWork.requestLogin(callback);
    }
}
