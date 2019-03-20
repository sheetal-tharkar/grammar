package com.example.priyamagar.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class grammar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
    }
    public void intro(View v){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="intro";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void noun(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="noun";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);

    }
    public void pronoun(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="pronoun";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void adj(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="adjectives";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void verbs(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="verbs";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void adverbs(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="adverbs";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void aux(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="aux";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void prepositions(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="prepositions";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void art(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="articles";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void tense(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="tenses";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void phrases(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="phrases";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void idioms(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="idioms";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void determiners(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="determiners";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void conj(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="conjections";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void inter(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="interjections";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }
    public void quetag(View view){
        Intent sendStuff = new Intent(grammar.this, books.class);
        String a="questiontag";
        sendStuff.putExtra("msg",a);
        startActivity(sendStuff);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,NavigationD.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
