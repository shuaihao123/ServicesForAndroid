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
 * 护理/洁身沐浴
 */
public class ChastityActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.timerq)//洁身沐浴日期
    RoundLinearLayout timerq;
    @Bind(R.id.jieshentime)//洁身沐浴时间
    SeekBar jieshentime;
    @Bind(R.id.beizhu)//备注
    EditText beizhu;
    @Bind(R.id.lianxiname)//姓名
    EditText lianxiname;
    @Bind(R.id.lianxiphone)//电话
    EditText lianxiphone;
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
            msg("请输入正确的手机号");
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

