package com.example.myapplication2.fragment.setting;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication2.R;
import com.example.myapplication2.fragment.BaseFragment;

public class SettingFragment extends BaseFragment {
    public static final String TAG = SettingFragment.class.getName();
    private SettingViewModel settingViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView() {
        settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);
        settingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
    }
}
