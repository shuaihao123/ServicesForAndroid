package org.freecoding.servicesmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.utils.HttpUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

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
    HttpResult info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
    }

    /**
     * 返回
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
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
        login();
    }

    private void login() {

        HttpUtils.login(info.message,info.success,new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                msg("请检查网络");
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResult result = gson.fromJson(response, HttpResult.class);
                if (result.success) {
                  msg("登陆成功");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    msg("登陆成功");
                }
            }
        });
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
