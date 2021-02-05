package com.iagodkin.showpostapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.iagodkin.showpostapi.databinding.ActivityMainBinding;
import com.iagodkin.showpostapi.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainActivityViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainActivityViewModel.class);
        binding.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onBtnClick();
            }
        });
        viewModel.liveDataB.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                binding.myProgress.setVisibility(View.VISIBLE);
            } else
                binding.myProgress.setVisibility(View.GONE);
            }
        });
        viewModel.liveDataS.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.showTxt.setText(s);
            }
        });

    }
}