package com.example.priyamagar.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MCQtest extends AppCompatActivity {
    TextView marks;
    TextView que;
    Button ch1,ch2,ch3;
    private QuestionLibrary mquestionlibrary=new QuestionLibrary();
    private String manswer;
    private int mscore=0;
    int ques=0;




   // int ques = getIntent().getIntExtra("initial",0);
    // int b=Integer.parseInt(ques);*/
     int mquestionnumber=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqtest);

       // score=(TextView)findViewById(R.id.sc);
        marks=(TextView)findViewById(R.id.mark);
        que=(TextView)findViewById(R.id.q);
        ch1=(Button)findViewById(R.id.c1);
        ch2=(Button)findViewById(R.id.c2);
        ch3=(Button)findViewById(R.id.c3);
         ques = getIntent().getIntExtra("initial",0);
        mquestionnumber=ques;

        updatequestion();
        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if(mquestionnumber<3){
                if(ch1.getText().toString()==manswer){
                    mscore=mscore+1;
                    mquestionnumber++;
                    updatequestion();

                    Toast.makeText(MCQtest.this,"correct",Toast.LENGTH_SHORT).show();


                }else {
                    mquestionnumber++;
                    updatequestion();
                  //  updateScore(mscore);
                    Toast.makeText(MCQtest.this,"wrong",Toast.LENGTH_SHORT).show();
                }
               // }else {
                   // startActivity(new Intent(MCQtest.this,score.class));
                  //  Toast.makeText(getApplicationContext(),mscore,Toast.LENGTH_LONG).show();
                    //updateScore(mscore);
                  /*  Intent sendStuff = new Intent(MCQtest.this, score.class);
                    String a=Integer.toString(mscore);
                    sendStuff.putExtra("msg",a);
                    startActivity(sendStuff);
                }*/



            }
        });
        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(mquestionnumber<3){
                if(ch2.getText()==manswer){
                    mscore=mscore+1;
                    mquestionnumber++;
                   // updateScore(mscore);
                    updatequestion();
                    Toast.makeText(MCQtest.this,"correct",Toast.LENGTH_SHORT).show();

                }else {
                    mquestionnumber++;
                    updatequestion();
                   // updateScore(mscore);
                    Toast.makeText(MCQtest.this,"wrong",Toast.LENGTH_SHORT).show();
                }
               /* }else {
                    //startActivity(new Intent(MCQtest.this,score.class));
                   //// updateScore(mscore);
                    Intent sendStuff = new Intent(MCQtest.this, score.class);
                    String a=Integer.toString(mscore);
                    sendStuff.putExtra("msg",a);
                    startActivity(sendStuff);
                }*/


            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if(mquestionnumber<3){
                if(ch3.getText()==manswer){
                    mscore=mscore+1;
                    mquestionnumber++;
                   // updateScore(mscore);
                    updatequestion();
                    Toast.makeText(MCQtest.this,"correct",Toast.LENGTH_SHORT).show();


                }else {
                    mquestionnumber++;
                    updatequestion();
                   // updateScore(mscore);
                    Toast.makeText(MCQtest.this,"wrong",Toast.LENGTH_SHORT).show();
                }
               /* }else {
                   // startActivity(new Intent(MCQtest.this,score.class));
                   // updateScore(mscore);
                    Intent sendStuff = new Intent(MCQtest.this, score.class);
                    String a=Integer.toString(mscore);
                    sendStuff.putExtra("msg",a);
                    startActivity(sendStuff);
                }*/


            }
        });


    }
    private void updatequestion(){
        if(mquestionnumber<(ques+5)) {
            que.setText(mquestionlibrary.getQuestion(mquestionnumber));
            ch1.setText(mquestionlibrary.getChoice1(mquestionnumber));
            ch2.setText(mquestionlibrary.getChoice2(mquestionnumber));
            ch3.setText(mquestionlibrary.getChoice3(mquestionnumber));
            manswer = mquestionlibrary.getCorrectAns(mquestionnumber);

            // mquestionnumber++;
            updateScore(mscore);
        }else{
            Intent sendStuff = new Intent(MCQtest.this, score.class);
            String a=Integer.toString(mscore);
            String b=Integer.toString(ques);
            sendStuff.putExtra("msg",a);
            sendStuff.putExtra("levelw",b);
            startActivity(sendStuff);


        }
       // mquestionnumber++;

    }
    private void updateScore(int point){
        marks.setText(""+mscore);


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,Levels.class);
        startActivity(intent);

        super.onBackPressed();
    }
}

