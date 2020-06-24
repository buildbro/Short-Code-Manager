package com.example.shortcodemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.shortcodemanager.model.Code;
import com.example.shortcodemanager.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {

    RecyclerView codeRecyclerView;
    CodeRecyclerViewAdapter codeRecyclerViewAdapter;

    MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codeRecyclerView = findViewById(R.id.code_recycler_view);
        codeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        codeRecyclerViewAdapter = new CodeRecyclerViewAdapter(this);
        codeRecyclerView.setAdapter(codeRecyclerViewAdapter);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getCodes().observe(this, new Observer<List<Code>>() {
            @Override
            public void onChanged(List<Code> codes) {
                codeRecyclerViewAdapter.setCodes(codes);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            startActivity(new Intent(MainActivity.this, AddCodeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRowClicked(int position) {

    }

    @Override
    public void onViewClicked(View view, int position) {

        Code code = codeRecyclerViewAdapter.mCodes.get(position);

        if (view.getId() == R.id.phone_ico) {
            makeCall(code.getCode());
        }

    }

    private void makeCall(String number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + number));
        startActivity(callIntent);
    }
}
