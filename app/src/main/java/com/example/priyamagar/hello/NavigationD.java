package com.example.priyamagar.hello;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class NavigationD extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t=(TextView)findViewById(R.id.nameuser);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_d, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.prog) {
            Intent i = new Intent(NavigationD.this, progressmenu.class);
            startActivity(i);

            // Handle the camera action
        } else if (id == R.id.sett) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.send) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(getApplicationContext(), "Logout Successfully", Toast.LENGTH_LONG).show();

            startActivity(new Intent(NavigationD.this, login.class));//open login activity on successful logout
            finish();
            SharedPreferences.Editor editor = getSharedPreferences("flag", getApplicationContext().MODE_PRIVATE).edit();
            editor.clear();

           editor.putBoolean("flag",false);
            editor.commit();


            if (editor.commit()) {
                Toast.makeText(getApplicationContext(), "Logout Successfully", Toast.LENGTH_LONG).show();

                startActivity(new Intent(NavigationD.this, login.class));//open login activity on successful logout
                finish();


            }}
            //else if (id == R.id.nav_send) {

            // }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
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
