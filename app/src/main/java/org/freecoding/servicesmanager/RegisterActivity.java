package org.freecoding.servicesmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

    void msg (String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    /**
     * 判断手机号
     */
    @OnClick(R.id.reisterButton)
    void btnreister() {
        String phone = reisterphone.getText().toString().trim();
        if (phone.length()==0){
            msg("手机号不能为空");
            reisterphone.requestFocus();
            return;
        }
        if (phone.length()!=11){
            msg("请输入正确的手机号");
            reisterphone.requestFocus();
            return;
        }
        /**
         * 判断密码
         */
        String pwd = reisterpwd.getText().toString().trim();
        if (phone.length()==0){
            msg("密码不能为空");
            reisterpwd.requestFocus();
            return;
        }
        /**
         * 判断确认密码
         */
        String zcpwd = reisteragainpwd.getText().toString().trim();
        if (phone.length()==0){
            msg("确认密码不能为空");
            reisteragainpwd.requestFocus();
            return;
        }
       if(pwd.length()!=zcpwd.length()){
           msg("密码不一致");
           reisteragainpwd.requestFocus();
           return;
       }
    }
}
