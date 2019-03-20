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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registration extends AppCompatActivity implements View.OnClickListener {
    private EditText uname;
    private EditText uage;
    private EditText phone;
    private EditText addr;
    private Button submit;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.pswrd);
        buttonSignup = (Button) findViewById(R.id.register);
        uname=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.pno);
        uage=(EditText)findViewById(R.id.age);
        addr=(EditText)findViewById(R.id.addre);
        submit=(Button)findViewById(R.id.login);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("student");
        progressDialog = new ProgressDialog(this);
        // databaseReference= FirebaseDatabase.getInstance().getReference();

        //attaching listener to button
        buttonSignup.setOnClickListener(this);
        submit.setOnClickListener(this);


    }
    private void inform(){
        final String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
        String fname = uname.getText().toString().trim();
        String number= phone.getText().toString().trim();
        String age=uage.getText().toString().trim();
        String address=addr.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(fname)){
            Toast.makeText(this,"Please enter full name",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this,"Please enter phone number",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(address)){
            Toast.makeText(this,"Please enter address",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(age)){
            Toast.makeText(this,"Please enter age",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
       // final UserInformation userInformation = new UserInformation(fname,age,number,address,emai);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              //  databaseReference.child(email).setValue(userInformation);





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });


        // textViewSignin.setOnClickListener(this);



        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(registration.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(registration.this,MainActivity.class));


                        }else{
                            //display some message here
                            Toast.makeText(registration.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });



    }


    @Override
    public void onClick(View v) {
        if(v==buttonSignup) {
            inform();
        }
        if (v==submit){
            startActivity(new Intent(registration.this,MainActivity.class));
        }
    }

    @Override
    public void finish() {
        super.finish();
    }
}
