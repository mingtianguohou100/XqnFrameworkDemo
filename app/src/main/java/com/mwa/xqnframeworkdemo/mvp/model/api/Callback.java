package com.mwa.xqnframeworkdemo.mvp.model.api;

public interface Callback {
   void onSuccess(String json);
   void onErro(String msg);
   void onFinish();
}
