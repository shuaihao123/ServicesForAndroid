package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 医疗/陪诊
 */
public class MedicalAccomPanyActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.peizhenriqi)
    RoundLinearLayout peizhenriqi;
    @Bind(R.id.peizhentime)
    SeekBar peizhentime;
    @Bind(R.id.peizhenbeizhu)
    EditText peizhenbeizhu;
    @Bind(R.id.peizhenname)
    EditText peizhenname;
    @Bind(R.id.peizhenphone)
    EditText peizhenphone;
    @Bind(R.id.peizhendizhi)
    EditText peizhendizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_accom_pany);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    void msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 提交
     */
    @OnClick(R.id.peizhenadd)
    void btntijiao() {
        String name = peizhenname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            peizhenname.requestFocus();
            return;
        }
        String phone = peizhenphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            peizhenphone.requestFocus();
            return;
        }
        String dizhi = peizhendizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            peizhendizhi.requestFocus();
            return;
        }
        String bz = peizhenbeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            peizhenbeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.peizhenfish)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
}