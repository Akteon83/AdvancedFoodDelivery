package com.Akteon_.afd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.Akteon_.afd.R;
import com.Akteon_.afd.adapter.EnterPageAdapter;
import com.Akteon_.afd.databinding.ActivityEnterBinding;

public class EnterActivity extends AppCompatActivity {

    ActivityEnterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                runOnUiThread(() -> {
                    findViewById(R.id.main_icon).setVisibility(View.VISIBLE);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        binding.pager.setAdapter(new EnterPageAdapter(getSupportFragmentManager()));
        binding.tabs.setupWithViewPager(binding.pager);
    }
}