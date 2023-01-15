package com.fstt.cours.ecommerce;


import android.app.ProgressDialog;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.fstt.cours.ecommerce.model.User;
import com.fstt.cours.ecommerce.prevalent.Prevalent;



public class LoginActivity extends AppCompatActivity {
    private EditText InputPhoneNumber, InputPassword;
    private Button loginButton;
    private ProgressDialog loadingBar;
    private TextView adminLink, notAdminLink, forgetPwd;

    private String parentDbName = "Users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginButton = (Button) findViewById(R.id.login_btn);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        InputPhoneNumber = (EditText) findViewById(R.id.login_phone_number_input);
        adminLink = (TextView) findViewById(R.id.admin_panel_link);
        notAdminLink = (TextView) findViewById(R.id.not_admin_panel_link);
        forgetPwd = (TextView) findViewById(R.id.forget_password_link);

        forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Bientot disponible", Toast.LENGTH_SHORT).show();
            }
        });

        loadingBar = new ProgressDialog(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        adminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.setText("Administrateur");
                adminLink.setVisibility(View.INVISIBLE);
                notAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";
            }
        });

        notAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.setText("Login");
                adminLink.setVisibility(View.VISIBLE);
                notAdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }


    private void loginUser() {
        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Votre numéro SVP...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Votre mot de passe SVP...", Toast.LENGTH_SHORT).show();
        } else {
            loadingBar.setTitle("Connexion");
            loadingBar.setMessage("Veuiller patienté SVP");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            //allowAccessToAccount(phone, password);

                Toast.makeText(LoginActivity.this, "Bienvenue ...", Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
                Prevalent.currentOnlineUser =new User("soufiane","0621500","pass","url","addresse soufiane");
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

        }
    }



}