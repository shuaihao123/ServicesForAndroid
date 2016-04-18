package org.freecoding.servicesmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;

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
    }
}
