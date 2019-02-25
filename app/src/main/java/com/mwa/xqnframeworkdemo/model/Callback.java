package com.mwa.xqnframeworkdemo.model;

public interface Callback {
   void onSuccess(String json);
   void onErro(String msg);
   void onFinish();
}
