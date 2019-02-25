package com.mwa.xqnframeworkdemo.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mwa.xqnframeworkdemo.R;
import com.mwa.xqnframeworkdemo.base.BaseFragment;
import com.mwa.xqnframeworkdemo.model.Callback;
import com.mwa.xqnframeworkdemo.model.NetWork;


public class PersonalCenterFragment extends BaseFragment implements View.OnClickListener {
    private Button mBtn_get_data;

    @Override
    protected int initView(ViewGroup container) {
        return R.layout.personal_center_layout;
    }

    @Override
    protected void initData() {
        mBtn_get_data = mView.findViewById(R.id.btn_get_data);
        mBtn_get_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showNetLoading();
        NetWork.getInstance().requestLogin(new Callback() {
            @Override
            public void onSuccess(String json) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "登陆成功", Toast.LENGTH_LONG).show();
                    }
                });

            }

            @Override
            public void onErro(String msg) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "登陆失败", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onFinish() {
                dissNetLoading();
            }
        });
    }
}
