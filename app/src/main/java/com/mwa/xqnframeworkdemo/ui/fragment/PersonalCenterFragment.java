package com.mwa.xqnframeworkdemo.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mwa.xqnframeworkdemo.R;
import com.mwa.xqnframeworkdemo.databinding.PersonalCenterLayoutBinding;
import com.mwa.xqnframeworkdemo.viewmodel.PersonalCenterViewHolder;


public class PersonalCenterFragment extends Fragment {
    private PersonalCenterViewHolder mHomeViewHolder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        PersonalCenterLayoutBinding inflate = DataBindingUtil.inflate(inflater, R.layout.home_layout, container, false);
        mHomeViewHolder = new PersonalCenterViewHolder(getActivity());
        inflate.setViewModel(mHomeViewHolder);
        return inflate.getRoot();
    }

}
