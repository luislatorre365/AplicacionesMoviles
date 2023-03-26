package com.example.practica1parcial3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class    MainActivity extends AppCompatActivity {
    FirstFragment firstfragment = new FirstFragment();
    SecondFragment secondfragment = new SecondFragment();
    ThirdFragment thirdfragment   = new ThirdFragment();
    FourFragment fourfragment     = new FourFragment();

    FiveFragment fiveFragment = new FiveFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(firstfragment);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.first_fragment:
                        loadFragment(firstfragment);
                        return true;
                    case R.id.secondFragment:
                        loadFragment(secondfragment);
                        return true;
                    case R.id.thirdFragment:
                        loadFragment(thirdfragment);
                        return true;
                    case R.id.FourFragment:
                        loadFragment(fourfragment);
                        return true;
                    case R.id.fiveFragment:
                        loadFragment(fiveFragment);
                        return true;
                }
                return false;
            }
        };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}