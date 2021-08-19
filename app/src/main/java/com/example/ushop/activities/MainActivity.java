package com.example.ushop.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;

import com.example.ushop.R;
//import com.example.ushop.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

   // HomeFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   myFragment = new HomeFragment();
       // loadFragment(myFragment);
//        fragmentManager = new FragmentManager();
//        loadFragment(homeFragment);
//        FragmentManager fm = getSupportFragmentManager();
    }

//    private void loadFragment(HomeFragment myFragment) {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction();
//        transaction.replace(R.id.my_fragment,myFragment);
//        transaction.commit();
//    }
}