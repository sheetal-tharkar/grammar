package com.example.priyamagar.hello;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity implements View.OnClickListener{
    public EditText editTextEmail;
    public EditText editTextPassword;
    public Button buttonSignup;

    private ProgressDialog progressDialog;
  /*  private EditText name;
    private EditText no;
    private EditText pswrd;
    private EditText birthdate;*/
   // private DatabaseReference databaseReference;


    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;
    public String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editText6);
        editTextPassword = (EditText) findViewById(R.id.editText8);
      /*  no=(EditText)findViewById(R.id.editText5);
        pswrd=(EditText)findViewById(R.id.editText7);
        birthdate=(EditText)findViewById(R.id.editText4);
        name=(EditText)findViewById(R.id.editText3);*/

        buttonSignup = (Button) findViewById(R.id.button2);


        progressDialog = new ProgressDialog(this);
       // databaseReference= FirebaseDatabase.getInstance().getReference();

        //attaching listener to button
        buttonSignup.setOnClickListener(this);

    }

    private void registerUser(){

        //getting email and password from edit texts
         email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
      /*  String fname = name.getText().toString().trim();
        String number= no.getText().toString().trim();
        String paswrd=pswrd.getText().toString().trim();
        String bdate=birthdate.getText().toString().trim();*/

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();

            return;
        }
        //final UserInformation userInformation = new UserInformation(email);
      /*  if(TextUtils.isEmpty(fname)){
            Toast.makeText(this,"Please enter full name",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this,"Please enter phone number",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(paswrd)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(bdate)){
            Toast.makeText(this,"Please enter birthdate",Toast.LENGTH_LONG).show();
            return;
        }*/



        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
      /*  UserInformation userInformation=new UserInformation(email,password,fname,number,paswrd,bdate);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userInformation);
        Toast.makeText(this,"registered successfully",Toast.LENGTH_LONG).show();*/


        //creating a new user


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(register.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(register.this,info.class));


                        }else{
                            //display some message here
                            Toast.makeText(register.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View view) {
        //calling register method on click
        if (view==buttonSignup){

            registerUser();
        }


    }

    @Override
    public void finish() {
        super.finish();
    }
}


