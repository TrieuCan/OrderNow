package com.example.myapplication2.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication2.R;
import com.example.myapplication2.callback.OnActionCallBack;
import com.example.myapplication2.fragment.BaseFragment;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, OnActionCallBack {
    protected String currentTag;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }

    public final <T extends View> T findViewById(int id,
                                                 View.OnClickListener event) {
        T view = super.findViewById(id);
        if (event != null) {
            view.setOnClickListener(event);
        }
        return view;
    }

    protected abstract void initView();

    protected abstract int getLayoutId();

    protected void showFrg(String tag) {
        try {
            Class<?> clazz = Class.forName(tag);
            BaseFragment fragment = (BaseFragment) clazz.newInstance();
            fragment.setCallBack(this);
            currentTag = tag;
            FragmentManager frgMgr = getSupportFragmentManager();
            frgMgr.beginTransaction().
                    replace(R.id.frame, fragment, tag)
                    .addToBackStack(null)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}