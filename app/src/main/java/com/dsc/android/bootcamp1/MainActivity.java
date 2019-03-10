package com.dsc.android.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName, etEmail, etPassword, etConfirm_Password;
    private Button buttonRegister;
    private String name,email,password, confirmpassword;
    private TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new TinyDB(this);
        initView();
        buttonRegister.setOnClickListener(this);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm_Password = findViewById(R.id.etConfirm_Password);
        buttonRegister=findViewById(R.id.buttonRegister);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRegister:
                getInfo();
                register();
                break;
        }
    }
    private void getInfo(){
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString();
        confirmpassword = etConfirm_Password.getText().toString();
    }
    private void register(){
        if(name.isEmpty()||email.isEmpty()||password.isEmpty()||confirmpassword.isEmpty()){
            Toast.makeText(this,"One or more fields is empty",Toast.LENGTH_LONG).show();
        }
        else {
            if(password.equals(confirmpassword)){
                db.putString("Name",name);
                db.putString("email",email);
                db.putString("password",password);
                Toast.makeText(this,"User registered",Toast.LENGTH_LONG).show();
                Intent i=new Intent(this,Login.class);
                startActivity(i);
                finish();

            }
            else{
                Toast.makeText(this,"Passwords did not match!",Toast.LENGTH_LONG).show();
            }
        }
    }
}
