package com.example.shortcodemanager.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.shortcodemanager.model.Code;

import java.util.List;

public class CodeRepository {

    private static CodeRepository instance;
    private CodeDao codeDao;

    private CodeRepository(Context context) {
        codeDao = AppDatabase.getInstance(context).codeDao();
    }

    public static CodeRepository getInstance(Context context) {
        if (instance == null) {
            instance = new CodeRepository(context);
        }

        return instance;
    }

    public void insertCode(final Code code) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            codeDao.insertCode(code);
        });
    }

    public LiveData<List<Code>> getCodes() {
        return codeDao.fetchCodes();
    }
}
