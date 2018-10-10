package com.tsj.alotest.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;


import com.tsj.alotest.R;
import com.tsj.alotest.ui.BaseActivity;
import com.tsj.alotest.ui.profil.ProfilFragment;

import butterknife.Bind;

/**
 * Created by tunggul.jati on 09/10/2018.
 */

public class HomeActivity extends BaseActivity {

    @Bind(R.id.navigation)
    BottomNavigationView navigation;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.toolbar_title)
    TextView toolbar_title;


    @Override
    protected int getLayout() {
        return R.layout.a_menu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profil:
                    fragment = new ProfilFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };


    public static void startActivity(BaseActivity sourceActivity) {
        Intent i = new Intent(sourceActivity, HomeActivity.class);
        sourceActivity.startActivity(i);
    }

    private void loadFragment(android.support.v4.app.Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        toolbar_title.setText("Alotest");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

}
