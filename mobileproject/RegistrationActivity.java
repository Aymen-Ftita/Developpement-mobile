package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class RegistrationActivity extends AppCompatActivity {

    private EditText passwordR ;
    private EditText EmailR ;

    private Button btnSignupR;
    private Button btnLoginR;

    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();

        mDialog=new ProgressDialog(this);

        Registration();

    }

    private void Registration(){

        EmailR=findViewById(R.id.EmailR);
        passwordR=findViewById(R.id.passwordR);

        btnSignupR=findViewById(R.id.btnSignupR);
        btnLoginR=findViewById(R.id.btnLoginR);

        btnLoginR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });

        btnSignupR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=EmailR.getText().toString().trim();
                String password=passwordR.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    EmailR.setError("Required field..");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passwordR.setError("Required field..");
                    return;
                }

                mDialog.setMessage("Processing..");
                mDialog.show();
                
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){

                           Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();

                           startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                           mDialog.dismiss();
                       }else{
                           Toast.makeText(getApplicationContext(),"Registration Failed..",Toast.LENGTH_SHORT).show();
                       }
                    }
                });
            }
        });



    }
}