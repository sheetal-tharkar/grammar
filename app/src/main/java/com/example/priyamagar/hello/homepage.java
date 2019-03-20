package com.example.priyamagar.hello;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class homepage extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

    }





    public void tutorials(View v){
        Intent i=new Intent(this,grammar.class);
        startActivity(i);
    }
    public void sp(View view){
        Intent intent=new Intent(this,speech.class);
        startActivity(intent);
    }
    public void test1(View view){
        Intent intent = new Intent(this, Levels.class);
        startActivity(intent);
    }




}
