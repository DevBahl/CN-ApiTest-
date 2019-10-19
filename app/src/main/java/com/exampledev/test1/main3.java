package com.exampledev.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.exampledev.test1.main2.logintoken;

public class main3 extends AppCompatActivity {
Button bt4;
public static  TextView txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

     bt4=(Button)findViewById(R.id.b4);
     txt4 =(TextView)findViewById(R.id.txt4);

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jasondata1 process1 = new jasondata1();
                process1.execute();
            }
        });

    }
}
