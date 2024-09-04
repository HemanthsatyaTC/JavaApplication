package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Change Library");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public boolean isValidUsername(String username) {
        return username.contains("@") && username.endsWith(".com");
    }
    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
}