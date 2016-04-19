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
 * 家政服务/保姆
 */
public class HomeNurseActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baomuriqi)
    SeekBar baomuriqi;
    @Bind(R.id.baomubeizhu)
    EditText baomubeizhu;
    @Bind(R.id.baomuname)
    EditText baomuname;
    @Bind(R.id.baomuphone)
    EditText baomuphone;
    @Bind(R.id.baomufuwudizhi)
    EditText baomufuwudizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nurse);
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
    @OnClick(R.id.baomuadd)
    void btntijiao() {
        String name = baomuname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            baomuname.requestFocus();
            return;
        }
        String phone = baomuphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            baomuphone.requestFocus();
            return;
        }
        String dizhi = baomufuwudizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            baomufuwudizhi.requestFocus();
            return;
        }
        String bz = baomubeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            baomubeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.baomufinsh)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}
