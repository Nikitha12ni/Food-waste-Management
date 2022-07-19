package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
Button donate,search;
TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);
        donate=(Button) findViewById(R.id.Donate);
        search=(Button) findViewById(R.id.search);
        hello=(TextView)findViewById(R.id.Nikki);

        String Emmail=getIntent().getStringExtra("Username");
        hello.setText("Hello "+Emmail);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,MainActivity2.class);
                intent.putExtra("Username",Emmail);

                startActivity(intent);
                // donatefood();

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchfood();
            }
        });

    }

    private void searchfood() {
        Intent intent=new Intent(HomeActivity.this,MainActivity3.class);
        startActivity(intent);
    }

   /* private void donatefood() {
        Intent intent=new Intent(HomeActivity.this,MainActivity2.class);
        startActivity(intent);
    }*/
}