package com.houssem.superhero;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.houssem.superhero.utils.Storage;

/**
 * Created by Formation on 25/03/2016.
 */
public class SignInActivity extends AbstractActivity {

    private EditText login, password;
    private Button loginBtn;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_sign_in;
    }

    @Override
    public void findViews() {
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.loginBtn);
    }

    @Override
    public void initializeUI() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(login.getText().toString(), password.getText().toString());
            }
        });
    }

    private void login(String aLogin, String aPassword){
        if (aLogin.isEmpty() || aPassword.isEmpty()){
            Toast.makeText(getApplicationContext(),getString(R.string.required_login_password), Toast.LENGTH_LONG);
        }
        else if (aLogin.equals(getString(R.string.test)) && aPassword.equals(getString(R.string.test))){
            Storage storage = new Storage();
            storage.setLoginKey(aLogin);
            storage.setPasswordKey(aPassword);
            startActivity(new Intent(SignInActivity.this, HerosListActivity.class));
        }
        else{
            Toast.makeText(getApplicationContext(),getString(R.string.wrong_login_password), Toast.LENGTH_SHORT);
        }
    }

}
