package com.mwa.xqnframeworkdemo.mvp.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mwa.xqnframeworkdemo.R;
import com.mwa.xqnframeworkdemo.base.BaseFragment;
import com.mwa.xqnframeworkdemo.mvp.model.PersonalcenterModel;
import com.mwa.xqnframeworkdemo.mvp.presenter.PersonalcenterPresenter;

public class PersonalCenterFragment extends BaseFragment<PersonalcenterPresenter> implements View.OnClickListener {
    private Button mBtn_get_data;

    @Override
    protected int initView(ViewGroup container) {
        return R.layout.personal_center_layout;
    }

    @Override
    protected void initData() {
        mBtn_get_data = mView.findViewById(R.id.btn_get_data);
        mBtn_get_data.setOnClickListener(this);
        mPresenter = new PersonalcenterPresenter(getContext(), this, new PersonalcenterModel());
    }

    @Override
    public void onClick(View v) {
        mPresenter.requestLogin();
    }

    public void onSuccess(final String json) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), json, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onErro(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
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
