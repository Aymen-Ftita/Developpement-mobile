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
    EditText poid ;
    Button btn;
    RadioButton ptk;
    RadioButton ktp;
    TextView msg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poid=(EditText)findViewById(R.id.poid);
        btn=(Button)findViewById(R.id.button);
        ptk=(RadioButton)findViewById(R.id.ptk);
        ktp=(RadioButton)findViewById(R.id.ktp);
        msg = (TextView) findViewById(R.id.msg);

        btn.setOnClickListener(new View.OnClickListener() {

                @SuppressLint("SetTextI18n")
                @Override
                public void  onClick(View view) {

                    Double p = new Double(poid.toString());
                    Double r = 0.0;
                    if(ptk.isChecked()){
                        r=p*2.2;
                        msg.setText(r.toString());}
                    else if(ktp.isChecked()){
                        r=p/2.2;
                        msg.setText(r.toString());}
                    else
                        msg.setText("Not Cheked");

                    msg.setText(r.toString());


                }
        });
    }
}