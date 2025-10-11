package com.example.myapplication.chuong4.baitap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.myapplication.R;

public class Chuong4_BaiTap3 extends AppCompatActivity {

    private EditText editTextUsername,editTextPassword;
    private Button btnLogin;


    private  TextView result;


//    hanle function
    boolean handleLogin(String user, String pass){
        return user.equals("HelloWallet") && pass.equals("123");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong4_bai_tap3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        result = (TextView) findViewById(R.id.result);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(handleLogin(editTextUsername.getText().toString(),editTextPassword.getText().toString())) result.setText("Login success");
                  else result.setText("login fail");
            }
        });
    }


}