package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button btn1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    ActionBarDrawerToggle barDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        drawerLayout=findViewById(R.id.layout);
        navigationView=findViewById(R.id.naviView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.send:
                        Toast.makeText(MainActivity.this, "메세지 보내기", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.login:
                        Toast.makeText(MainActivity.this, "로그인하기", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "프로필 보기", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        barDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}