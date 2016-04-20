package org.freecoding.servicesmanager;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 护理/洁身沐浴
 */
public class ChastityActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.timerq)//洁身沐浴日期
            LinearLayout timerq;
    @Bind(R.id.jieshentime)//洁身沐浴时间
    SeekBar jieshentime;
    @Nullable
    @Bind(R.id.beizhu)//备注
    EditText beizhu;
    @Nullable
    @Bind(R.id.lianxiname)//姓名
    EditText lianxiname;
    @Nullable
    @Bind(R.id.lianxiphone)//电话
    EditText lianxiphone;
    @Nullable
    @Bind(R.id.baomufuwudizhi)//地址
    EditText baomufuwudizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chastity);
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
    @OnClick(R.id.addtijiao)
    void btntijiao() {
        String remarks = beizhu.getText().toString().trim();
        if (remarks.length() == 0) {
            msg("备注不能为空");
            beizhu.requestFocus();
            return;
        }
        String name = lianxiname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            lianxiname.requestFocus();
            return;
        }
        String phone = lianxiphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            lianxiphone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            lianxiphone.requestFocus();
            return;
        }
        String dizhi = baomufuwudizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            baomufuwudizhi.requestFocus();
            return;
        }
    }
    /**
     * 取消
     */
    @OnClick(R.id.qxfinsh)
    void btnqxfinsh() {

        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        return true;
    }

}

