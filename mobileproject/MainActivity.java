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

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    private Button btnLogin;
    private Button bntbtnSignup;

    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

        mDialog=new ProgressDialog(this);

        LoginFunction();
    }

    private void LoginFunction(){

        email=findViewById(R.id.Email);
        password=findViewById(R.id.password);

        btnLogin=findViewById(R.id.btnLogin);
        bntbtnSignup=findViewById(R.id.btnSignup);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mEmail=email.getText().toString().trim();
                String mpassword=password.getText().toString().trim();

                if(TextUtils.isEmpty(mEmail)){

                    email.setError("Required field");

                }
                if(TextUtils.isEmpty(mpassword)){

                    password.setError("Required field");

                }

                mDialog.setMessage("Processing...");
                mDialog.show();

                mAuth.signInWithEmailAndPassword(mEmail,mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                            mDialog.dismiss();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Login Failed..",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        bntbtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

    }
}