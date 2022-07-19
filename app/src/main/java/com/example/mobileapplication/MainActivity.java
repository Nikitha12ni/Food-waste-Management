package com.example.mobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
  Button regis,logg;
    EditText inEmail,inPass;

    //String emPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+" ;
    //  String emPattern= "^(.+)@(.+)$";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
   // TextView m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regis=(Button)findViewById(R.id.regis);
        inEmail=(EditText)findViewById(R.id.inEm);
        inPass=(EditText)findViewById(R.id.inPa) ;
        logg=(Button)findViewById(R.id.log) ;
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
       // m=(TextView)findViewById(R.id.ni) ;



        logg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLoginActivity();
            }
        });
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opnactivity();

            }

        });
    }

    private void setLoginActivity() {
        String Emmail=inEmail.getText().toString();
        String Password=inPass.getText().toString();

       /* if(!Email.equals(emPattern))
        {
            inEmail.setError("Enter correct email");

        }
        else */if(Password.isEmpty()||Password.length()<6)
        {
            inPass.setError("Enter proper Password");

        }

        else {
            progressDialog.setMessage("Please wait while login...");
            progressDialog.setTitle("login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(Emmail,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                                intent.putExtra("Username",Emmail);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                //sendUserToNextActivity1();
                        Toast.makeText(MainActivity.this,"Login  succesfull",Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }



    private void opnactivity() {
        Intent intent=new Intent(this,registers.class);
        startActivity(intent);
    }
    /*private void sendUserToNextActivity1() {
        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
        intent.putExtra("Username",)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }*/
}