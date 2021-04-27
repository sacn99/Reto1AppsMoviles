package com.example.reto1cabreraalejandro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private NewFragment newFragment;
    private MapsFragment mapsFragment;
    private SearchFragment searchFragment;
    private BottomNavigationView navigator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigator = findViewById(R.id.navigator);

        newFragment = NewFragment.newInstance();
        mapsFragment = new MapsFragment();
        searchFragment = SearchFragment.newInstance();

        showFragment(newFragment);

        navigator.setOnNavigationItemReselectedListener(
                (menuItem) ->{

                    switch (menuItem.getItemId()){
                        case R.id.newItem:
                            showFragment(newFragment);
                            break;
                        case R.id.mapItem:
                            showFragment(mapsFragment);
                            break;
                        case R.id.searchItem:
                            showFragment(searchFragment);
                            break;
                    }
                }
        );
    }

    public void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    public Fragment getMapFragment(){
        return mapsFragment;
    }
}