package com.mwa.xqnframeworkdemo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.mwa.xqnframeworkdemo.R;


public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context); /**设置对话框背景透明*/
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.loading_tips);
        setCanceledOnTouchOutside(false);
    }

}
