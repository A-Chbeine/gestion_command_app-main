package com.fstt.cours.ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fstt.cours.ecommerce.model.User;
import com.fstt.cours.ecommerce.prevalent.Prevalent;


public class RegisterActivity extends AppCompatActivity {

    private Button btn_create_account;
    private EditText input_name , input_phone , input_password ;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_create_account = (Button) findViewById(R.id.btn_register);
        input_name = (EditText) findViewById(R.id.register_username_input);
        input_phone = (EditText) findViewById(R.id.register_phone_number_input);
        input_password = (EditText) findViewById(R.id.register_password_input);
        loadingBar = new ProgressDialog(this);

        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount()
    {
        String name = input_name.getText().toString();
        String phone = input_phone.getText().toString();
        String password = input_password.getText().toString();

        if (TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Saisissez votre nom SVP...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Saisissez votre numéro SVP...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Saisissez votre password SVP...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Création du compte");
            loadingBar.setMessage("Veuiller patienter SVP");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            validate(name, phone, password);
        }
    }



    private void validate(final String name, final String phone, final String password)
    {
        Toast.makeText(getApplicationContext(), "Bienvenue ...", Toast.LENGTH_SHORT).show();
        loadingBar.dismiss();
        Prevalent.currentOnlineUser =new User(name,phone,password,"url","addresse ");
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
