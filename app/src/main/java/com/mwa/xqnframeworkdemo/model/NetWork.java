package com.mwa.xqnframeworkdemo.model;

/*
 * 这里可以实现全局网络请求
 * **/
public class NetWork {
    private static NetWork mNetWork = new NetWork();

    private NetWork() {
    }

    public static NetWork getInstance() {
        return mNetWork;
    }


    /*
     * 获取首页数据,模拟网络请求
     * **/
    public void requestHomeData(final Callback callback) {
        if (callback != null) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        sleep(2000);
                        callback.onSuccess("获取首页数据成功");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        callback.onErro(e.getMessage());
                    }finally {
                        callback.onFinish();
                    }
                }
            }.start();

        }

    }

    /*
     * 登陆请求,模拟网络请求
     * **/
    public void requestLogin(final Callback callback) {
        if (callback != null) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        sleep(2000);
                        callback.onSuccess("登陆成功");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        callback.onErro(e.getMessage());
                    }finally {
                        callback.onFinish();
                    }
                }
            }.start();
        }
    }


}
