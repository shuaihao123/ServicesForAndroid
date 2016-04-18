package org.freecoding.servicesmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;

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
    }
}
