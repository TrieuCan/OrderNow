package com.example.myapplication2.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication2.R;
import com.example.myapplication2.fragment.ActionFragment;
import com.example.myapplication2.fragment.detailproduct.DetailProductFragment;
import com.example.myapplication2.fragment.evaluate.EvaluateFragment;
import com.example.myapplication2.fragment.favourite.FavouriteFragment;
import com.example.myapplication2.fragment.history.HistoryFragment;
import com.example.myapplication2.fragment.home.HomeFragment;
import com.example.myapplication2.fragment.productcategory.ProductCategoryFragment;
import com.example.myapplication2.fragment.setting.SettingFragment;
import com.example.myapplication2.model.productcategory.ProductCategory;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getName();
    private Boolean checkOnBackPress;

    @Override
    protected void initView() {
        fragmentAction();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void callBack(String key, Object data) {
        switch (key) {
            case ActionFragment.FRAGMENT_HOME:
                showFrg(HomeFragment.TAG);
                break;
            case ActionFragment.FRAGMENT_HISTORY:
                showFrg(HistoryFragment.TAG);
                break;
            case ActionFragment.FRAGMENT_FAVORITE:
                showFrg(FavouriteFragment.TAG);
                break;
            case ActionFragment.FRAGMENT_EVALUATE:
                showFrg(EvaluateFragment.TAG);
                break;
            case ActionFragment.FRAGMENT_SETTING:
                showFrg(SettingFragment.TAG);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }


    public void fragmentAction() {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        ActionFragment actionFragment = new ActionFragment();
        actionFragment.setCallBack(this);
        tran.replace(R.id.ln_main, actionFragment);
        tran.addToBackStack(null).commit();
    }


    public void fragmentProductCategory(int id) {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        ProductCategoryFragment productCategoryFragment = new ProductCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Id", id);
        productCategoryFragment.setArguments(bundle);
        tran.add(R.id.framentMain, productCategoryFragment);
        tran.addToBackStack(null).commit();
    }

    public void fragmentDeatilProduct(ProductCategory productCategory) {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        DetailProductFragment detailProductFragment = new DetailProductFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ID", productCategory);
        detailProductFragment.setArguments(bundle);
        tran.add(R.id.framentMain, detailProductFragment);
        tran.addToBackStack(null).commit();
    }

}