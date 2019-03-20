package com.example.priyamagar.hello;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Levels extends AppCompatActivity {
    Button l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        l1=(Button)findViewById(R.id.level1);
        l2=(Button)findViewById(R.id.level2);
        l2.setEnabled(false);
        l3=(Button)findViewById(R.id.level3);
        l3.setEnabled(false);
        l4=(Button)findViewById(R.id.button13);
        l4.setEnabled(false);
        l5=(Button)findViewById(R.id.button17);
        l5.setEnabled(false);
        l6=(Button)findViewById(R.id.button12);
        l6.setEnabled(false);
        l7=(Button)findViewById(R.id.button10);
        l7.setEnabled(false);
        l8=(Button)findViewById(R.id.button11);
        l8.setEnabled(false);
        l9=(Button)findViewById(R.id.button9);
        l9.setEnabled(false);
        l10=(Button)findViewById(R.id.button14);
        l10.setEnabled(false);
        l11=(Button)findViewById(R.id.button16);
        l11.setEnabled(false);
        l12=(Button)findViewById(R.id.button15);
        l12.setEnabled(false);
      /*  PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("MYLABEL", "myStringToSave").apply();

        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("MYLABEL", "defaultStringIfNothingFound");

       // String enable = getIntent().getStringExtra("button");*/
       // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences prefs = getSharedPreferences("myprefenre", MODE_PRIVATE);


        //if(value==5){
        if(getIntent().getStringExtra("level2")!=null && getIntent().getStringExtra("level2").equals("enabled")){
           // Boolean b=mypref.getBoolean("levelb",true);
            l2.setEnabled(true);
            prefs.edit().putBoolean("b2enabled", true).commit();//saving State here
        }
        else{
            l2.setEnabled(false);
        }
        if(getIntent().getStringExtra("level3")!=null && getIntent().getStringExtra("level3").equals("enabled")){
           // Boolean b=mypref.getBoolean("levelb",true);
            l3.setEnabled(true);
            prefs.edit().putBoolean("l3enabled", true).commit();
        }
        else{
            l3.setEnabled(false);
        }
        if(getIntent().getStringExtra("level4")!=null && getIntent().getStringExtra("level4").equals("enabled")){
            // Boolean b=mypref.getBoolean("levelb",true);
            l4.setEnabled(true);
            prefs.edit().putBoolean("l4enabled", true).commit();//saving State here
        }
        else{
            l4.setEnabled(false);
        }

        Boolean b2state= prefs.getBoolean("b2enabled", false);
        Boolean l3state= prefs.getBoolean("l3enabled", false);
        Boolean l4state= prefs.getBoolean("l4enabled", false);



        if (b2state){
            l2.setEnabled(true);
        }
        else{
            l2.setEnabled(false);
        }
        if (l3state){
            l3.setEnabled(true);
        }
        else{
            l3.setEnabled(false);
        }
        if (l4state){
            l4.setEnabled(true);
        }
        else{
            l4.setEnabled(false);
        }




    }
  /*  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0)
            l2.setEnabled(true);


    }*/
    public void Level1(View view){
       // Intent intent=new Intent(this,MCQtest.class);
        //startActivityForResult(intent,0);
        int b=0;
        Intent sendStuff = new Intent(Levels.this, MCQtest.class);

        sendStuff.putExtra("initial",b);
        startActivity(sendStuff);

    }
    public void level2on(View view){
        int b=5;
        Intent sendStuff = new Intent(Levels.this, MCQtest.class);

        sendStuff.putExtra("initial",b);
        startActivity(sendStuff);


    }
    public void level33(View view){
        int b=10;
        Intent sendStuff = new Intent(Levels.this, MCQtest.class);

        sendStuff.putExtra("initial",b);
        startActivity(sendStuff);


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,NavigationD.class);
        startActivity(intent);

        super.onBackPressed();
    }




}
