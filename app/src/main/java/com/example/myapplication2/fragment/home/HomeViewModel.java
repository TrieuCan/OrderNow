package com.example.myapplication2.fragment.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication2.database.RoomDatabase;
import com.example.myapplication2.model.category.Category;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<List<Category>> mListCategory;
    private List<Category> mList;

    public HomeViewModel() {
        mListCategory = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        mList = new ArrayList<>();
        mListCategory.setValue(mList);
    }

    public MutableLiveData<List<Category>> getmListCategory(RoomDatabase roomDatabase) {
        mList = roomDatabase.queryDAO().getListCategory();
        mListCategory.setValue(mList);
        return mListCategory;
    }

    public void addCategory(Category category, RoomDatabase roomDatabase) {
        roomDatabase.queryDAO().insertCategory(category);
        mList = roomDatabase.queryDAO().getListCategory();
        mListCategory.setValue(mList);
    }
}