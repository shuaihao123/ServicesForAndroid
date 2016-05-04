package org.freecoding.servicesmanager;

import android.content.Intent;
import android.net.Uri;
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
 * 注册密码
 */
public class RegisterActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.reisterphone)
    EditText reisterphone;
    @Bind(R.id.reisterpwd)
    EditText reisterpwd;
    @Bind(R.id.reisteragainpwd)
    EditText reisteragainpwd;
    @Bind(R.id.reisterButton)
    TextView reisterButton;
    HttpResult info;
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
     * 判断手机号
     */
    @OnClick(R.id.reisterButton)
    void btnreister() {
        String phone = reisterphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("手机号不能为空");
            reisterphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            reisterphone.requestFocus();
            return;
        }
        /**
         * 判断密码
         */
        String pwd = reisterpwd.getText().toString().trim();
        if (phone.length() < 6) {
            msg("密码长度太短");
            reisterpwd.requestFocus();
            return;
        }
        /**
         * 判断确认密码
         */
        String zcpwd = reisteragainpwd.getText().toString().trim();
        if (!zcpwd.equals(pwd)) {
            msg("密码不一致");
            reisteragainpwd.requestFocus();
            return;
        }
        Register();
    }

    private void Register() {
        HttpUtils.register(info.message, info.success, new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                msg("请检查网络");
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResult result = gson.fromJson(response, HttpResult.class);
                if (result.success) {
                    msg("注册成功");
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    msg("注册失败");
                }
            }
        });
    }
}
