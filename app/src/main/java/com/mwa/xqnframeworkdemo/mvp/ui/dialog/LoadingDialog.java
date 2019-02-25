package com.mwa.xqnframeworkdemo.mvp.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.mwa.xqnframeworkdemo.R;


public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.loading_tips);
        setCanceledOnTouchOutside(false);
    }

}
