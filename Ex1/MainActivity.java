package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Pn;
    Button button;
    TextView msg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.Name);
        Prenom=(EditText)findViewById(R.id.Pn);
        button=(Button)findViewById(R.id.button);
        msg = (TextView) findViewById(R.id.msg);

        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void  onClick(View view) {

                    String name=Name.getText().toString();
                    String prenom=Prenom.getText().toString();
                    msg.setText("Bonjour "+name+" "+prenom);



                }
        });
    }
}