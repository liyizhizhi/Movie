package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.EncryptUtil;
import com.bw.movie.R;
import com.bw.movie.model.bean.EamalBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.presenter.EmailPresenter;
import com.bw.movie.presenter.RegisterPresenter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements IMainView.CallBackEmail, IMainView.CallBackRegister {
    private EditText register_name;
    private EditText register_pwd;
    private EditText register_email;
    private Button register_huoqu;
    private EditText register_verification;
    private TextView jump_login;
    private Button register;
    private String email;
    private EmailPresenter emailPresenter;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_name = (EditText) findViewById(R.id.register_name);
        register_pwd = (EditText) findViewById(R.id.register_pwd);
        register_email = (EditText) findViewById(R.id.register_email);
        register_huoqu = (Button) findViewById(R.id.register_huoqu);
        register_verification = (EditText) findViewById(R.id.register_verification);
        jump_login = (TextView) findViewById(R.id.jump_login);
        register = (Button) findViewById(R.id.register);

        emailPresenter = new EmailPresenter();
        emailPresenter.ActachView(this);

        registerPresenter = new RegisterPresenter();
        registerPresenter.ActachView(this);

        //点击跳转登录界面
        jump_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
        register_huoqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = register_email.getText().toString().trim();
                emailPresenter.EmailPresenter(em);
                CountDownTimer countDownTimer = new CountDownTimer(10 * 1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        register_huoqu.setClickable(false);
                        register_huoqu.setText(l / 1000 + "秒");
                    }

                    @Override
                    public void onFinish() {
                        register_huoqu.setClickable(true);
                        register_huoqu.setText("重新发送");
                    }
                };
                countDownTimer.start();//开启


            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            private HashMap<String, Object> map;

            @Override
            public void onClick(View v) {
                String name = register_name.getText().toString().trim();
                String pwd = register_pwd.getText().toString().trim();
                email = register_email.getText().toString().trim();
                String code = register_verification.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(pwd);
                map = new HashMap<>();
                map.put("nickName", name);
                map.put("pwd", encrypt);
                map.put("email", email);
                map.put("code", code);
                registerPresenter.RegisterPresenter(map);
            }
        });


    }

    @Override
    public void success(EamalBean eamalBean) {
        if (eamalBean.getStatus().equals("0000")) {
            Toast.makeText(RegisterActivity.this, eamalBean.getMessage(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(RegisterActivity.this, eamalBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void success(RegisterBean registerBean) {
        if (registerBean.getStatus().equals("0000")) {
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        emailPresenter.DatachView();
        registerPresenter.DatachView();
    }
}
