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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        PersonalCenterLayoutBinding inflate = DataBindingUtil.inflate(inflater, R.layout.personal_center_layout, container, false);
        PersonalCenterViewHolder mHomeViewHolder = new PersonalCenterViewHolder(getActivity());
        inflate.setPcViewModel(mHomeViewHolder);
        return inflate.getRoot();
    }

}
