package com.mwa.xqnframeworkdemo.base;

import com.mwa.xqnframeworkdemo.mvp.model.api.NetWork;

public class MyBaseModel implements IModel {
    protected NetWork mNetWork = NetWork.getInstance();

    @Override
    public void onDestroy() {

    }
}
