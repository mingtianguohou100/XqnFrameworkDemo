package com.mwa.xqnframeworkdemo.mvp.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mwa.xqnframeworkdemo.R;
import com.mwa.xqnframeworkdemo.base.BaseFragment;
import com.mwa.xqnframeworkdemo.mvp.model.HomeModel;
import com.mwa.xqnframeworkdemo.mvp.model.PersonalcenterModel;
import com.mwa.xqnframeworkdemo.mvp.presenter.HomePresenter;
import com.mwa.xqnframeworkdemo.mvp.presenter.PersonalcenterPresenter;

public class HomeFragment extends BaseFragment<HomePresenter> implements View.OnClickListener {
    private Button mBtn_get_data;
    private TextView mTv_show_data;

    @Override
    protected int initView(ViewGroup container) {
        return R.layout.home_layout;
    }

    @Override
    protected void initData() {
        mBtn_get_data = mView.findViewById(R.id.btn_get_data);
        mTv_show_data = mView.findViewById(R.id.tv_show_data);
        mBtn_get_data.setOnClickListener(this);
        mPresenter = new HomePresenter(getContext(), this, new HomeModel());

    }

    @Override
    public void onClick(View v) {
        mPresenter.requestHomeData();
    }

    public void onSuccess(final String json) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTv_show_data.setText(json);
            }
        });
    }

    public void onErro(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTv_show_data.setText(msg);
            }
        });

    }

    @Override
    public void showLoading() {
        showNetLoading();
    }

    @Override
    public void hideLoading() {
        dissNetLoading();
    }
}
