package com.example.mobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    EditText Dtof, Dadd, Dmno;
    Button doo;
   // TextView m1;
   // FirebaseDatabase DfirebaseDatabase;
    DatabaseReference DdatabaseReference;
    Donarsinfo donarinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Dtof = (EditText) findViewById(R.id.type);
        Dadd = (EditText) findViewById(R.id.address);
        Dmno = (EditText) findViewById(R.id.mno);
        //m1=(TextView)findViewById(R.id.ni);

        DdatabaseReference = FirebaseDatabase.getInstance().getReference().child("Donars");
       // String Emmail=getIntent().getStringExtra("Username");
      //  m1.setText(Emmail);
       // m
        //DdatabaseReference=firebaseDatabase.getReference("Donarsinfo");
      //  donarinfo = new Donarsinfo();
        doo = (Button) findViewById(R.id.cdo);
        doo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              insertDonarsdata();
                Intent intent=new Intent(MainActivity2.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void insertDonarsdata() {
        String tof=Dtof.getText().toString();
        String add=Dadd.getText().toString();
        String mno=Dmno.getText().toString();
       String Emmail=getIntent().getStringExtra("Username");
        Donarsinfo donarsinfo=new Donarsinfo(tof,add,mno);
      //  Emmail.reference.push().getKey();
       // donarsinfo.setKey(Emmail);
        DdatabaseReference.push().setValue(donarsinfo);
    Toast.makeText(MainActivity2.this,"Data Inserted",Toast.LENGTH_SHORT).show();
    }
}
              /*  String tof=Dtof.getText().toString();
                String add=Dadd.getText().toString();
                String mno=Dmno.getText().toString();

                if(TextUtils.isEmpty(tof)  && TextUtils.isEmpty(add)  && TextUtils.isEmpty(add))
                {
                    Toast.makeText(MainActivity2.this,"Please add some data",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    addDatatoFirebase(tof,add,mno);
                }
            }
        });

    }

    private void addDatatoFirebase(String tof, String add, String mno) {
        Donarsinfo.setDt--++++++++++++++++++++++++++++++-of(tof);
        Donarsinfo.setDadd(add);
        Donarsinfo.setDmno(mno);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(Donarsinfo);
                Toast.makeText(MainActivity2.this,"data added",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(MainActivity2.this,"Failed to add data...."+error,Toast.LENGTH_SHORT).show();
            }
        });
            }
}*/