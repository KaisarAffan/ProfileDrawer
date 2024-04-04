package com.example.navdrawerexample;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.navdrawerexample.fragments.Warung;
import com.example.navdrawerexample.fragments.FavoritDrink;
import com.example.navdrawerexample.fragments.FavoritFood;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showSiswaPage();

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.menu_item1) {
                    showSiswaPage();
                } else if (itemId == R.id.menu_item2) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new FavoritFood())
                            .commit();
                    getSupportActionBar().setTitle("Favourite Food");
                } else if (itemId == R.id.menu_item3) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new FavoritDrink())
                            .commit();
                    getSupportActionBar().setTitle("Favourite Drink");
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void showSiswaPage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new Warung())
                .commit();

        getSupportActionBar().setTitle("Warung");
    }

}
