package com.exampledev.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
Button bt;
public static String e;
    public static String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ed1 =(EditText)findViewById(R.id.editText);
        ed2 =(EditText)findViewById(R.id.editText2);
        bt =(Button) findViewById(R.id.button);



       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               e = ed1.getText().toString();
               p = ed2.getText().toString();

               Intent intent = new Intent(MainActivity.this,main2.class);
               startActivity(intent);
           }
       });


    }

}
