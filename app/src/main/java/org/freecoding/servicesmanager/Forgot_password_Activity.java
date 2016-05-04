package org.freecoding.servicesmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Forgot_password_Activity extends AppCompatActivity {

    @Bind(R.id.dazhen)
    TextView dazhen;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.loginname)
    EditText loginname;
    @Bind(R.id.loginpwd)
    EditText loginpwd;
    @Bind(R.id.loginbutton)
    TextView loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_);
        ButterKnife.bind(this);
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

    /**
     * 忘记密码
     */
    @OnClick(R.id.loginbutton) void btnloginbutton(){
        Intent intent = new Intent(this, Set_new_password_Activity.class);
        startActivity(intent);
    }
}
