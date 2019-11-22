package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.EncryptUtil;
import com.bw.movie.R;
import com.bw.movie.model.bean.Loginbean;
import com.bw.movie.presenter.LoginPresenter;
import com.bw.movie.view.interfaces.IMainView;

public class LoginActivity extends AppCompatActivity implements IMainView.CallBackData {
    private EditText name;
    private EditText pass2;
    private Button deng;
    private Button wei;
    private LoginPresenter presenter;
    private TextView zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.name);
        pass2 = findViewById(R.id.pass);
        deng = findViewById(R.id.deng);
        wei = findViewById(R.id.wei);
        zhuce = findViewById(R.id.zhuce);
        presenter = new LoginPresenter();
        presenter.ActachView(this);
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = name.getText().toString().trim();
                String pass1 = pass2.getText().toString().trim();
                String pass = EncryptUtil.encrypt(pass1);
                presenter.LoginPresenter(email, pass);
            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
    }


    @Override
    public void success(Loginbean loginbean) {

        if (loginbean.getStatus().equals("0000")) {
            Toast.makeText(this, loginbean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            int userId = loginbean.getResult().getUserId();
            String sessionId = loginbean.getResult().getSessionId();
            intent.putExtra("userId", userId);
            intent.putExtra("sessionId", sessionId);
            startActivity(intent);
        } else {
            Toast.makeText(this, loginbean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.DatachView();
    }
}
