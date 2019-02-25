package com.mwa.xqnframeworkdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.mwa.xqnframeworkdemo.base.BaseActivity;
import com.mwa.xqnframeworkdemo.base.BaseFragment;
import com.mwa.xqnframeworkdemo.mvp.ui.fragment.HomeFragment;
import com.mwa.xqnframeworkdemo.mvp.ui.fragment.PersonalCenterFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRg_bottom;
    private List<BaseFragment> mFragmentArr;
    private int mFragmentPosition;
    private FragmentTransaction fragmentTransaction;
    protected Fragment last;

    @Override
    protected int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mRg_bottom = findViewById(R.id.rg_bottom);
        mRg_bottom.setOnCheckedChangeListener(this);
        mFragmentArr = new ArrayList<>();
        mFragmentArr.add(new HomeFragment());
        mFragmentArr.add(new PersonalCenterFragment());
        //首次进入默认展示首页内容
        startSwitchFragmnet(0);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_btn_home:
                startSwitchFragmnet(0);
                break;
            case R.id.rb_btn_my:
                startSwitchFragmnet(1);
                break;
        }
    }

    private void startSwitchFragmnet(int position) {
        mFragmentPosition = position;
        fragmentSwitch(last, mFragmentArr.get(mFragmentPosition));
    }

    /**
     * 当前的Fragment没有add过就add
     * add过，就show,同时隐藏上一个Fraagment
     */
    public void fragmentSwitch(Fragment from, Fragment to) {
        if (from != to) {
            last = to;
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!to.isAdded()) {
                //to没有被添加
                //from隐藏
                if (from != null) {
                    fragmentTransaction.hide(from);
                }
                //添加to
                if (to != null) {
                    fragmentTransaction.add(R.id.frllayout_main_view, to).commitAllowingStateLoss();
                }
            } else {
                //to已经被添加
                // from隐藏
                if (from != null) {
                    fragmentTransaction.hide(from);
                }
                //显示to
                if (to != null) {
                    fragmentTransaction.show(to).commitAllowingStateLoss();
                }
            }
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}