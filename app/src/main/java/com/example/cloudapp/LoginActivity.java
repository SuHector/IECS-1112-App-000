package com.example.cloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
        private EditText account_et;
        private EditText password_et;

        private Button Login;
        private Button Sign;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            //account_tv = findViewById(R.id.account_tv);
            account_et = findViewById(R.id.login_account);
            //password_tv = findViewById(R.id.password_tv);
            password_et = findViewById(R.id.login_password);
            Login = findViewById(R.id.btn_login);
            Sign = findViewById(R.id.btn_register);


            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view.getId() == R.id.btn_login) {
                        String account = account_et.getText().toString();
                        String password = password_et.getText().toString();
                        String message = "密碼錯誤";
                        int correct = 0;
                        if (account.equals("abcd") && password.equals("abcd")) {
                            message = "密碼正確";
                            correct = 1;
                        }
                        Toast toast = Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT);
                        toast.show();
                        if(correct == 1){
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this, ChooseRestaurantActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            });

            Sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(view.getId() == R.id.btn_register) {
                        Intent intent = new Intent();
                        intent.setClass(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    }
                }
            });//ClickListener結束
        }//OnCreate結束

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu.findItem( R.id.InOut_control).setTitle("註冊");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.InOut_control:
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }//menu設定 結束

}
