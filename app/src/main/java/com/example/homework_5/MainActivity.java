package com.example.homework_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ForButton, ForRecycler {
    HistoryFragment historyFragment;
    ButtonsFragment buttonsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonsFragment = new ButtonsFragment();
        historyFragment = new HistoryFragment();
        changeFragment(buttonsFragment);
    }
    @Override
    public void showHistoryFragment() {
        buttonsFragment.sendAnswer();
    }
    @Override
    public void back() {
        changeFragment(buttonsFragment);
    }
    public void changeFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
