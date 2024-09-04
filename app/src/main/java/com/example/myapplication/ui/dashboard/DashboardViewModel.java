package com.example.myapplication.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
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