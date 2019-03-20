package com.example.priyamagar.hello;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.key;
import static android.R.attr.onClick;


public class score extends AppCompatActivity {
    TextView score1;
    Button play, quit;
    TextView msg1;
    TextView txt,high;
    String wlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score1=(TextView)findViewById(R.id.score);
        play=(Button)findViewById(R.id.strt);
        quit=(Button)findViewById(R.id.quit);
        msg1=(TextView)findViewById(R.id.msg);
        txt=(TextView)findViewById(R.id.textView5);

        Intent startingIntent = getIntent();

        high=(TextView)findViewById(R.id.hscore);

        String whatYouSent = startingIntent.getStringExtra("msg");
         wlevel=startingIntent.getStringExtra("levelw");

        int a=Integer.parseInt(whatYouSent);

        score1.setText(whatYouSent);
        if(score1.getText().toString().equals("5") && wlevel.equals("0")){
            msg1.setText("Congo!! You have completed level 1!");
            play.setText("Quit");
            quit.setText("level 2");


        }else if(score1.getText().toString().equals("5") && wlevel.equals("5")) {
            msg1.setText("Congo!! You have completed level 2!");
            play.setText("Quit");
            quit.setText("level 3");


    }else if(score1.getText().toString().equals("5") && wlevel.equals("10")) {
        msg1.setText("Congo!! You have completed level 3!");
        play.setText("Quit");
        quit.setText("level 4");


    }else{
            msg1.setText("work hard!!");
            play.setText("Quit");
            quit.setText("Try Again");

        }

        SharedPreferences mypref=getPreferences(MODE_PRIVATE);
        int highscore=mypref.getInt("highscore",0);
        if(highscore>=a){
            high.setText("High Score: "+highscore);

        }else{
            high.setText("New high score: "+a);
            SharedPreferences.Editor editor=mypref.edit();
            editor.putInt("highscore",a);
            editor.commit();
        }

        Toast.makeText(getApplicationContext(),wlevel,Toast.LENGTH_LONG).show();
    }
    public void quit1(View view){
        if(quit.getText().toString().equals("Try Again")) {
            Intent i = new Intent(this, MCQtest.class);
            int c=Integer.parseInt(wlevel);
            i.putExtra("initial",c);
            startActivity(i);
        }else if(quit.getText().toString().equals("level 2")){
            //ll2.setEnabled(true);
            Intent sendStuff = new Intent(score.this, Levels.class);
           sendStuff.putExtra("level2","enabled");
          /*  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("key","value");
            editor.apply();*/
            startActivity(sendStuff);
          // setResult(0,null);
           // Intent intent=new Intent(this,Levels.class);
        }
        else if(quit.getText().toString().equals("level 3")){
            //ll2.setEnabled(true);
            Intent sendStuff = new Intent(score.this, Levels.class);
            sendStuff.putExtra("level3","enabled");
          /*  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("key","value");
            editor.apply();*/
            startActivity(sendStuff);
            // setResult(0,null);
            // Intent intent=new Intent(this,Levels.class);
        }else if(quit.getText().toString().equals("level 4")){
            //ll2.setEnabled(true);
            Intent sendStuff = new Intent(score.this, Levels.class);
            sendStuff.putExtra("level4","enabled");
          /*  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("key","value");
            editor.apply();*/
            startActivity(sendStuff);
            // setResult(0,null);
            // Intent intent=new Intent(this,Levels.class);
        }



    }
    public void start(View v){
        Intent intent=new Intent(this,NavigationD.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,NavigationD.class);
        startActivity(intent);

        super.onBackPressed();
    }
}
