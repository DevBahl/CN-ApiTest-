package com.exampledev.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.BufferUnderflowException;

import static com.exampledev.test1.MainActivity.e;
import static com.exampledev.test1.MainActivity.p;

public class main2 extends AppCompatActivity {

    Button b1;
    Button bt3;
    public static String logintoken;

    public static TextView txt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1=(Button)findViewById(R.id.bt1);
        bt3=(Button)findViewById(R.id.bt3);
        txt1=(TextView) findViewById(R.id.txt1);



        Log.i(e,p);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jasondata process = new jasondata();
                process.execute();

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logintoken = txt1.getText().toString();
                Intent intent2=new Intent(main2.this,main3.class);
                startActivity(intent2);
            }
        });
    }
}
