package com.example.priyamagar.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class progressmenu extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressmenu);
        txt=(TextView)findViewById(R.id.textView6);

    }
    public void ok(View view){
        Intent intent=new Intent(progressmenu.this,NavigationD.class);
        startActivity(intent);
    }
}
