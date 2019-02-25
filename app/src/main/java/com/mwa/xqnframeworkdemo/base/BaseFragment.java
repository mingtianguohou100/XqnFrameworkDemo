package com.mwa.xqnframeworkdemo.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mwa.xqnframeworkdemo.mvp.ui.dialog.LoadingDialog;


public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {
    protected Context mContext;
    protected Activity mActivity;
    protected View mView;
    private LoadingDialog mLoadingDialog;
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getContext();
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = LayoutInflater.from(mContext).inflate(initView(container), container, false);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract int initView(ViewGroup container);

    protected abstract void initData();


    protected void showNetLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(mContext);
        }

        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    protected void dissNetLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        mPresenter = null;
        super.onDestroy();
    }
}
