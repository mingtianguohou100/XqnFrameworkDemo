package com.mwa.xqnframeworkdemo.viewmodel;

import android.app.Activity;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.mwa.xqnframeworkdemo.model.Callback;
import com.mwa.xqnframeworkdemo.model.NetWork;

public class PersonalCenterViewHolder {
    private Activity mActivity;
    public final ObservableBoolean loading = new ObservableBoolean(false);

    public final ObservableBoolean loadingSuccess = new ObservableBoolean(false);

    public final ObservableBoolean loadingFailure = new ObservableBoolean(false);

    public final ObservableField<String> mJson = new ObservableField<>();

    public PersonalCenterViewHolder(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void requestLogin() {
        loading.set(true);
        loadingSuccess.set(false);
        loadingFailure.set(false);
        NetWork.getInstance().requestHomeData(new Callback() {
            @Override
            public void onSuccess(final String json) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mJson.set(json);
                        loadingSuccess.set(true);
                    }
                });

            }

            @Override
            public void onErro(final String msg) {
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mJson.set(msg);
                        loadingFailure.set(true);
                    }
                });
            }

            @Override
            public void onFinish() {
                loading.set(false);
            }
        });
    }
}
