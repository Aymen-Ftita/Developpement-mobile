package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileproject.Model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostTrainigActivity<FirebaseRecyclerAdapter> extends AppCompatActivity {

    private Button Post_new_training;

    //Recyler view..

    private RecyclerView rv ;

    //Firebase..

    private FirebaseAuth mAuth;
    private DatabaseReference a_PostDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_trainig);

        Post_new_training=findViewById(R.id.Post_new_training);

        FirebaseUser mUser=mAuth.getCurrentUser();
        String Uid= mUser.getUid();

        a_PostDataBase= FirebaseDatabase.getInstance().getReference().child("Annonce de Stage").child(Uid);

        rv=findViewById(R.id.recyler_view_id);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(layoutManager);

        Post_new_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),InsertPostActivity.class));

            }
        });

    }

    @Override
    protected  void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter FirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Data, MyViewHolder>(
                Data.class,
                R.layout.post_item,
                MyViewHolder.class,
                a_PostDataBase

        ){

            protected  void populateViewHolder(MyViewHolder viewHolder , int position){

                viewHolder.setTtitle(Data.getTitre());

            }


        };

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        View myview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myview=itemView;
        }

        public void setcompany(String company){
            TextView mcompany=myview.findViewById(R.id.a_company);
            mcompany.setText(company);
        }

        public void setTtitle(String title){
            TextView mTitle=myview.findViewById(R.id.a_titre);
            mTitle.setText(title);
        }

        public void setTdescp(String descp){
            TextView mdescp=myview.findViewById(R.id.a_description);
            mdescp.setText(descp);
        }

        public void setTskills(String skills){
            TextView mskills=myview.findViewById(R.id.a_skills);
            mskills.setText(skills);
        }

        public void setTduree(String duree){
            TextView mduree=myview.findViewById(R.id.a_duree);
            mduree.setText(duree);
        }


    }


}