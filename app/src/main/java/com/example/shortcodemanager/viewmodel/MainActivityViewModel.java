package com.example.shortcodemanager.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shortcodemanager.database.CodeRepository;
import com.example.shortcodemanager.model.Code;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private CodeRepository codeRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        codeRepository = CodeRepository.getInstance(application);
    }

    public LiveData<List<Code>> getCodes() {
        return codeRepository.getCodes();
    }
}
