package com.example.priyamagar.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class books extends AppCompatActivity {
    PDFView book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        book=(PDFView)findViewById(R.id.pdfbook);

        Intent startingIntent = getIntent();

        //  high=(TextView)findViewById(R.id.hscore);

        String whatYouSent = startingIntent.getStringExtra("msg");
        if(whatYouSent.equals("intro")){
            book.fromAsset("introduction.pdf").load();

        }
        if(whatYouSent.equals("noun")){
            book.fromAsset("noun.pdf").load();

        }
        if(whatYouSent.equals("pronoun")){
            book.fromAsset("pronoun.pdf").load();

        }
        if(whatYouSent.equals("adjectives")){
            book.fromAsset("adjectives.pdf").load();

        }
        if(whatYouSent.equals("verbs")){
            book.fromAsset("verbs.pdf").load();

        }
        if(whatYouSent.equals("adverbs")){
            book.fromAsset("adverbs.pdf").load();

        }
        if(whatYouSent.equals("aux")){
            book.fromAsset("auxiliaryverb.pdf").load();

        }
        if(whatYouSent.equals("prepositions")){
            book.fromAsset("prepositions.pdf").load();

        }
        if(whatYouSent.equals("articles")){
            book.fromAsset("articles.pdf").load();

        }
        if(whatYouSent.equals("tenses")){
            book.fromAsset("tenses.pdf").load();

        }
        if(whatYouSent.equals("phrases")){
            book.fromAsset("phrase.pdf").load();

        }
        if(whatYouSent.equals("idioms")){
            book.fromAsset("idioms.pdf").load();

        }
        if(whatYouSent.equals("determiners")){
            book.fromAsset("determiners.pdf").load();

        }
        if(whatYouSent.equals("conjections")){
            book.fromAsset("cunjuctions1.pdf").load();

        }
        if(whatYouSent.equals("interjections")){
            book.fromAsset("interjections.pdf").load();

        }
        if(whatYouSent.equals("questiontag")){
            book.fromAsset("questiontag.pdf").load();

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,grammar.class);
        startActivity(intent);

        super.onBackPressed();
    }
}
