package com.example.database;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;



public class loginActivity extends AppCompatActivity {
    EditText email,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.eamil_l_id);
        password=findViewById(R.id.password_l_id);
        login=findViewById(R.id.login_btn_id);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                DB_Helper db_helper= new DB_Helper(loginActivity.this);
                if (Email.isEmpty()||Password.isEmpty())
                {
                    Toast.makeText(loginActivity.this, "fill all the filed", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(loginActivity.this, "fill", Toast.LENGTH_SHORT).show();
                    boolean i= db_helper.checkemailpassword(Email,Password);
                    if (i==true)
                    {
                        Toast.makeText(loginActivity.this, "login fail", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(loginActivity.this, " accessn", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginActivity.this,home.class));
                    }
                }
            }
        });
    }


}