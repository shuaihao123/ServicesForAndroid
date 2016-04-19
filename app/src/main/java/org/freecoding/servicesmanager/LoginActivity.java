package org.freecoding.servicesmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录
 */
public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.loginname)
    EditText loginname;
    @Bind(R.id.loginpwd)
    EditText loginpwd;
    @Bind(R.id.forgetpwd)
    TextView forgetpwd;
    @Bind(R.id.fastpwd)
    TextView fastpwd;
    @Bind(R.id.loginbutton)
    TextView loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
    }

    void msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 登录
     */
    @OnClick(R.id.loginbutton)
    void btnlogin() {
        String phone = loginname.getText().toString().trim();
        if (phone.length() == 0) {
            msg("手机号不能为空");
            loginname.requestFocus();
            return;
        }
        String pwd = loginpwd.getText().toString().trim();
        if (pwd.length() == 0) {
            msg("手机号不能为空");
            loginpwd.requestFocus();
            return;
        }

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    /**
     * 忘记密码
     */
    @OnClick(R.id.forgetpwd)
    void btnforgepwd() {
        Intent it = new Intent(this, RegisterActivity.class);
        startActivity(it);
    }

    /**
     * 快速注册
     */
    @OnClick(R.id.fastpwd)
    void btnfastpwd() {
        Intent it = new Intent(this, RegisterActivity.class);
        startActivity(it);
    }
}
