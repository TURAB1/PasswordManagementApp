package com.example.myev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavbarActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();

                return true;

            case R.id.managePassword:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                Intent intent  = new Intent(getApplicationContext(), SqlitelistActivity.class);
                startActivity(intent);
                return true;

            case R.id.strengthCheck:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
               // Intent myIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.passwordmonster.com/"));
                Intent myIntent  = new Intent(getApplicationContext(), PasswordCheckActivity.class);
                startActivity(myIntent);
                return true;
        }
        return false;
    }
}
