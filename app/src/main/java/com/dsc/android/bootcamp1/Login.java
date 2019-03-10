package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername,etPassword;
    private Button etButtonLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
       //ButtonLog.setOnClickListener(this)
    }
    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
       // buttonLog =findViewById(R.id.buttonLog);

  /*  @Override
    public void onClick(View v) {

    }*/
}

    @Override
    public void onClick(View v) {

    }
}
