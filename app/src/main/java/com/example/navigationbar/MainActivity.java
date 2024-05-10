package com.example.navigationbar;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static androidx.core.graphics.drawable.DrawableCompat.applyTheme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ThemeFragment themeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(getResources().getColor(R.color.lavendar));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        themeFragment = new ThemeFragment();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    replaceFragment(new HomeFragment());
                } else if (id == R.id.nav_setting) {
                    replaceFragment(new SettingFragment());
                } else if (id == R.id.nav_share) {
                    replaceFragment(new ShareFragment());
                } else if (id == R.id.nav_aboutus) {
                    replaceFragment(new AboutFragment());
                } else if (id == R.id.nav_theme) {
                    replaceFragment(themeFragment);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    public void setThemeColors(int color) {
        toolbar.setBackgroundColor(color);
        navigationView.getHeaderView(0).setBackgroundColor(color);
        navigationView.setItemIconTintList(ColorStateList.valueOf(color));
        navigationView.setItemTextColor(ColorStateList.valueOf(color));
    }

}