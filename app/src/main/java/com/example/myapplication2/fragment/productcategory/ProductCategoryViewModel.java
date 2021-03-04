package com.example.myapplication2.fragment.productcategory;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication2.database.RoomDatabase;
import com.example.myapplication2.model.productcategory.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryViewModel extends ViewModel {
    private final MutableLiveData<List<ProductCategory>> mListProductCategory;
    private List<ProductCategory> mList;

    public ProductCategoryViewModel() {
        mListProductCategory = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        mListProductCategory.setValue(mList);
    }

    public MutableLiveData<List<ProductCategory>> getmListProductCategory(RoomDatabase roomDatabase, int id) {
        mList = roomDatabase.queryDAO().checkProductCategory(id);
        mListProductCategory.setValue(mList);
        return mListProductCategory;
    }

    public void addProductCategory(ProductCategory productCategory, RoomDatabase roomDatabase) {
        roomDatabase.queryDAO().insertProductCategory(productCategory);
        mList = roomDatabase.queryDAO().getListProductCatagory();
        mListProductCategory.setValue(mList);
    }
}
