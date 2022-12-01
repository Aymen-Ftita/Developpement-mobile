package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileproject.Model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class InsertPostActivity extends AppCompatActivity {

    private EditText titre;
    private EditText societe;
    private EditText competence;
    private EditText description;
    private EditText salaire;
    private Button ajout;

    //firebase

    private FirebaseAuth mAuth;
    private DatabaseReference mPosts;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_post);

        mAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser= mAuth.getCurrentUser();
        String Uid=mUser.getUid();

        mPosts= FirebaseDatabase.getInstance().getReference().child("Annonce de Stage").child(Uid);

        Insert();

    }


    private void Insert(){

        societe=findViewById(R.id.societe);
        titre=findViewById(R.id.titre);
        competence=findViewById(R.id.competence);
        description=findViewById(R.id.description);
        salaire=findViewById(R.id.salaire);

        ajout=findViewById(R.id.btn_insert);

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String society=societe.getText().toString().trim();
                String title=titre.getText().toString().trim();
                String descp=description.getText().toString().trim();
                String duree=salaire.getText().toString().trim();
                String skills=competence.getText().toString().trim();
                if(TextUtils.isEmpty(society)){
                    societe.setError("required Fiel..");
                    return;
                }
                if(TextUtils.isEmpty(title)){
                    titre.setError("required Fiel..");
                    return;
                }
                if(TextUtils.isEmpty(descp)){
                    description.setError("required Fiel..");
                    return;
                }
                if(TextUtils.isEmpty(duree)){
                    salaire.setError("required Fiel..");
                    return;
                }
                if(TextUtils.isEmpty(skills)){
                    competence.setError("required Fiel..");
                    return;
                }

                String id=mPosts.push().getKey();

                String date= DateFormat.getDateInstance().format(new Date());

                Data data=new Data(society,title,descp,skills,duree,id,date);

                mPosts.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),PostTrainigActivity.class));
            }
        });
    }
}