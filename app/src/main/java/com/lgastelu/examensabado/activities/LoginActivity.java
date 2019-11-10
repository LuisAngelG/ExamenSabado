package com.lgastelu.examensabado.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lgastelu.examensabado.R;
import com.lgastelu.examensabado.adapters.NotasAdapter;
import com.lgastelu.examensabado.adapters.UserAdapter;
import com.lgastelu.examensabado.models.Notas;
import com.lgastelu.examensabado.models.User;
import com.lgastelu.examensabado.repositories.NotasRepository;
import com.lgastelu.examensabado.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    NotasAdapter notasAdapter;

    private EditText user_txt,pass_txt;
    private Button btn_login;
    private User users;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notasAdapter = new NotasAdapter((List<Notas>) this);

        user_txt=findViewById(R.id.user_text);
        pass_txt=findViewById(R.id.pass_text);

        btn_login=findViewById(R.id.login_btn);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_txt.getText().toString().trim();
                String password = pass_txt.getText().toString().trim();
                users = new User();

                if (username.equals(users.getUsername()) && password.equals(users.getPassword())){

                }


            }
        });

    }
}
