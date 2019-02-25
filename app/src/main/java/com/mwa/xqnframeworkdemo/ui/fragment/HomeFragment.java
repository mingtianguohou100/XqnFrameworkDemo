package com.mwa.xqnframeworkdemo.ui.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mwa.xqnframeworkdemo.R;
import com.mwa.xqnframeworkdemo.base.BaseFragment;
import com.mwa.xqnframeworkdemo.databinding.HomeLayoutBinding;
import com.mwa.xqnframeworkdemo.model.Callback;
import com.mwa.xqnframeworkdemo.model.NetWork;
import com.mwa.xqnframeworkdemo.viewmodel.HomeViewHolder;


public class HomeFragment extends Fragment {
    private HomeViewHolder mHomeViewHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HomeLayoutBinding inflate = DataBindingUtil.inflate(inflater, R.layout.home_layout, container, false);
        mHomeViewHolder = new HomeViewHolder(getActivity());
        inflate.setViewModel(mHomeViewHolder);
        return inflate.getRoot();
    }


}
