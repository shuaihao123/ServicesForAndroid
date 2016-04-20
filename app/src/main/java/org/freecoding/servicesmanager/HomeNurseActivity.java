package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
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
    @Bind(R.id.baomuriqi)//保姆日期
            SeekBar baomuriqi;
    @Bind(R.id.baomucheckzf)//做饭
            CheckBox baomucheckzf;
    @Bind(R.id.baomucheckzgxh)//照顾小孩
            CheckBox baomucheckzgxh;
    @Bind(R.id.baomucheckzglr)//照顾老人
            CheckBox baomucheckzglr;
    @Bind(R.id.baomucheckzgbr)//照顾病人
            CheckBox baomucheckzgbr;

    @Bind(R.id.baomubeizhu)//备注
            EditText baomubeizhu;
    @Bind(R.id.baomuname)//姓名
            EditText baomuname;
    @Bind(R.id.baomuphone)//电话
            EditText baomuphone;
    @Bind(R.id.baomufuwudizhi)//地址
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
     * 提交
     */
    @OnClick(R.id.baomuadd)
    void btntijiao() {
        if (baomucheckzf.isChecked() == true) {
            String checkzf = baomucheckzf.getText().toString().trim();
        }
        if (baomucheckzgxh.isChecked() == true) {
            String checkzgxh = baomucheckzgxh.getText().toString().trim();
        }
        if (baomucheckzglr.isChecked() == true) {
            String checkzglr = baomucheckzglr.getText().toString().trim();
        }
        if (baomucheckzgbr.isChecked() == true) {
            String checkzgbr = baomucheckzgbr.getText().toString().trim();
        }
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
        if (phone.length() !=11) {
            msg("手机号输入错误");
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
