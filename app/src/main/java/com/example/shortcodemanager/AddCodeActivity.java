package com.example.shortcodemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shortcodemanager.model.Code;
import com.example.shortcodemanager.viewmodel.AddCodeViewModel;

public class AddCodeActivity extends AppCompatActivity {

    EditText titleEditText, codeEditText;
    Button addBtn;

    AddCodeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_code);

        initializeUi();

        viewModel = new ViewModelProvider(this).get(AddCodeViewModel.class);
    }

    private void initializeUi() {
        titleEditText = findViewById(R.id.title_edit_text);
        codeEditText = findViewById(R.id.code_edit_text);

        addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Code code = new Code(titleEditText.getText().toString(), codeEditText.getText().toString());
            viewModel.insertCode(code);
            finish();
        });
    }
}
