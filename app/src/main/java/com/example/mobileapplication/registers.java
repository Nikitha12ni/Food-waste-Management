
package com.example.mobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registers extends AppCompatActivity {
EditText inEmail,inPass,inConfPass;
Button reggg;
//String emPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+" ;
  //  String emPattern= "^(.+)@(.+)$";
ProgressDialog progressDialog;
FirebaseAuth mAuth;
FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registers);
        inEmail=(EditText) findViewById(R.id.inEmail);
        inPass=(EditText) findViewById(R.id.inPassword);
        inConfPass=(EditText) findViewById(R.id.inConfirm);
        reggg=(Button) findViewById(R.id.regg);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();



        reggg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              setAuth();

            }
        });
    }

    private void setAuth() {
        String Email=inEmail.getText().toString();
        String Password=inPass.getText().toString();
        String ConfirmPass=inConfPass.getText().toString();


      /*  if(!Email.equals(emPattern))
        {
            inEmail.setError("Enter valid email address");

        }
        else*/ if(Password.isEmpty()||Password.length()<6)
        {
            inPass.setError("Enter proper Password");

        }
        else if(!Password.equals(ConfirmPass))
        {
            inConfPass.setError("Password didnt matched");
        }
        else
        {
            progressDialog.setMessage("Please wait while registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(registers.this,"Registrtion succesfull",Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(registers.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(registers.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}