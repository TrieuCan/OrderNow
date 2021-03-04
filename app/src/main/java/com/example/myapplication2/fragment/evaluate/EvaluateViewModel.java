package com.example.myapplication2.fragment.evaluate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EvaluateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EvaluateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}