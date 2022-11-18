package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        email=findViewById(R.id.eamil_s_id);
        password=findViewById(R.id.password_s_id);
    }

    public void sign_in(View view) {

        DB_Helper db_helper= new DB_Helper(this);
        String Email=email.getText().toString();
        String Password=password.getText().toString();
        if (Email.isEmpty() ||Password.isEmpty())
        {
            Toast.makeText(this, "fill all the filed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "fill", Toast.LENGTH_SHORT).show();
            boolean i=db_helper.inserdata(Email,Password);
        if (i==true)
        {
            Toast.makeText(this, "inser not", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "inset", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(signupActivity.this,loginActivity.class));
        }
        }
    }
}