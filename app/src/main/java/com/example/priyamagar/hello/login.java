package com.example.priyamagar.hello;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private static final String TAG ="" ;
    private  Button b1;
    private Button b2;
    Boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1=(Button)findViewById(R.id.button7);
        b2=(Button)findViewById(R.id.button8);
      /*  SharedPreferences applicationPreferences= PreferenceManager.getDefaultSharedPreferences(login.this);
        SharedPreferences.Editor editor=applicationPreferences.edit();
        flag=applicationPreferences.getBoolean("flag",false);
        if(flag){
            Intent intent=new Intent(this,NavigationD.class);
            startActivity(intent);
        }else {
            editor.putBoolean("flag",true);
            editor.commit();
        }*/
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            Intent i = new Intent(login.this,NavigationD.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        else
        {
            Log.d(TAG,"signed out");
        }

    }
    public void log(View view){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void regi(View v){
        Intent intent=new Intent(this,register.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }
}
