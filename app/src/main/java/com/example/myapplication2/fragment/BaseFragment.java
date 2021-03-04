package com.example.myapplication2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication2.callback.OnActionCallBack;

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected View mRootView;
    protected OnActionCallBack mCallBack;
    protected String sourceTag;

    public final void setCallBack(OnActionCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        setHasOptionsMenu(true);
        initView();
        return mRootView;
    }


    protected final <T extends View> T findViewById(@IdRes int id,
                                                    View.OnClickListener event) {
        T v = mRootView.findViewById(id);
        if (event != null) {
            v.setOnClickListener(event);
        }
        return v;
    }

    protected final <T extends View> T findViewById(@IdRes int id) {
        return mRootView.findViewById(id);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

}
