package com.example.priyamagar.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class info extends AppCompatActivity {
    private EditText uname;
    private EditText uage;
    private EditText phone;
    private EditText addr;
    private Button submit;

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        uname=(EditText)findViewById(R.id.editText12);
        uage=(EditText)findViewById(R.id.editText13);
        phone=(EditText)findViewById(R.id.editText15);
        addr=(EditText)findViewById(R.id.editText16);
        submit=(Button)findViewById(R.id.button18);



        databaseReference= FirebaseDatabase.getInstance().getReference("student");

        submit.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                    final String name = uname.getText().toString();
                final String age = uage.getText().toString();
                final String ph=phone.getText().toString();
                final String add=addr.getText().toString();

               //
                final UserInformation userInformation = new UserInformation(name, age,ph,add);

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                      //  FirebaseUser user=firebaseAuth.getCurrentUser();
                        register r=new register();
                      //  databaseReference.child(user.getUid()).setValue(userInformation);
                        databaseReference.child(name).setValue(userInformation);
                        startActivity(new Intent(info.this,MainActivity.class));
                        Toast.makeText(info.this,"information added!",Toast.LENGTH_LONG).show();




                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(info.this,"something went wrong",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        // textViewSignin.setOnClickListener(this);

    }

}
