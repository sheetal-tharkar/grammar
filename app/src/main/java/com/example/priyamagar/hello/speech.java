package com.example.priyamagar.hello;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;

public class speech extends ActionBarActivity{
   private TextView resultTEXT;
    String sentence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        resultTEXT=(TextView)findViewById(R.id.TVresult);

    }
    public void onbuttonclick(View v){
        if(v.getId()==R.id.imageButton){

            promptSpeechInput();
        }

    }


   public void promptSpeechInput() {
       Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
       i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
       i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
       i.putExtra(RecognizerIntent.EXTRA_PROMPT,"say something");

       try{
       startActivityForResult(i,100);
    }catch (ActivityNotFoundException a){

           Toast.makeText(speech.this,"sorry your device doesn't support speech language",Toast.LENGTH_LONG).show();
       }
       }


    public void onActivityResult(int request_code, int result_code,Intent i){
        super.onActivityResult(request_code,result_code,i);

        switch(request_code){
            case 100: if(result_code ==RESULT_OK && i!=null){
                ArrayList<String> result=i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                resultTEXT.setText(result.get(0));
                sentence=resultTEXT.getText().toString();
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue(sentence);

            }
                break;
        }

    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,NavigationD.class);
        startActivity(i);
        super.onBackPressed();
    }



    public void speech(View view){
        String type="login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type);
    }

    public class BackgroundWorker extends AsyncTask<String,Void,String> {
        Context context;
        AlertDialog alertDialog;
        BackgroundWorker(Context ctx){
            context=ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String type =params[0];
            String url="http://192.168.43.159:8080/Opennlp/grammer";
            if(type.equals("login")){
                try {
                    //String jsonString=params[1];
                    //String password=params[2];
                    //String rollno=params[3];
                    URL url1=new URL(url);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url1.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream=httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String postData= URLEncoder.encode("jsonString","UTF-8")+"="+URLEncoder.encode(sentence,"UTF-8");
                    bufferedWriter.write(postData);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line;
                    while ((line=bufferedReader.readLine())!=null){
                        result+=line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return  result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            //alertDialog=new AlertDialog.Builder(context).create();
            //alertDialog.setTitle("Checking...");
            /*progressDialog=new ProgressDialog(Grammar.this);
            progressDialog.setMessage("Please Wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();*/
        }

        @Override
        protected void onPostExecute(String aVoid) {

           /* if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }*/
            Toast.makeText(getApplicationContext(),aVoid,Toast.LENGTH_SHORT).show();
           /* if(aVoid!=null) {
                try {
                    JSONObject jsonObject = new JSONObject(aVoid);
                    JSONArray contacts = jsonObject.getJSONArray("user");
                    //int i=contacts.length();
                    // String j=contacts.getJSONObject(3).toString();
                    // textView.setText(j);
                    //Add add ;
                    for (int i=contacts.length()-1;i>=0;i--) {
                        JSONObject c = contacts.getJSONObject(i);
                        String rollno = c.getString("rollno");
                        String note = c.getString("note");
                        String insertedDate = c.getString("insertedDate");
                        String insertedTime = c.getString("insertedTime");
                        // TextView t1 = (TextView) lv.findViewById(R.id.note);
                        //TextView t2 = (TextView) lv.findViewById(R.id.rollno);
                        //t1.setText(note);
                        //t2.setText(rollno);

                        //  new Add(rollno,note,insertedDate,insertedTime);
                        // Toast.makeText(getApplicationContext(),rollno,Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),note,Toast.LENGTH_LONG).show();
                        HashMap<String, String> contact = new HashMap<>();
                        contact.put("rollno", rollno);
                        contact.put("note", note);
                        contact.put("insertedDate",insertedDate);
                        contact.put("insertedTime",insertedTime);
                        contact.put("name",c.getString("name"));
                        contact.put("dept",c.getString("dept"));
                        contact.put("year",c.getString("year"));

                        contactList.add(contact);
                    }

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }

            listAdapter =new SimpleAdapter(Main4Activity.this,contactList,R.layout.activity_list_item,new String[]{"rollno","note","insertedDate","insertedTime","name","dept","year"},new int[]{R.id.rollno,R.id.note,R.id.textView3,R.id.textView4,R.id.textView27,R.id.textView28,R.id.textView29});
            lv.setAdapter(listAdapter);*/




        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}


