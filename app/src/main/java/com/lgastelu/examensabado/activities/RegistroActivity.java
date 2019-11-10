package com.lgastelu.examensabado.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lgastelu.examensabado.R;
import com.lgastelu.examensabado.repositories.UserRepository;

public class RegistroActivity extends AppCompatActivity {
    private EditText nameText,usernameText,emailText,passwordText;
    private Button returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nameText = (EditText)findViewById(R.id.name_txt);
        usernameText = (EditText)findViewById(R.id.username_txt);
        emailText = (EditText)findViewById(R.id.email_txt);
        passwordText = (EditText)findViewById(R.id.password_txt);
        returnBtn=(Button)findViewById(R.id.return_btn);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Return();
            }
        });
    }
    public void callRegister(View view){
        String name = nameText.getText().toString();
        String username = usernameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if(name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        UserRepository.create(name, username, email, password);
        finish();
    }

    private void Return(){

    }
}
