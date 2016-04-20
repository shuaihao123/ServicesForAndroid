package org.freecoding.servicesmanager;

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
 * 护理/洗发
 */
public class SpaActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.xifariqi)
    LinearLayout xifariqi;
    @Bind(R.id.xifatime)
    SeekBar xifatime;
    @Bind(R.id.xifabeizhu)
    EditText xifabeizhu;
    @Bind(R.id.xifaname)
    EditText xifaname;
    @Bind(R.id.xifaphone)
    EditText xifaphone;
    @Bind(R.id.xifadizhi)
    EditText xifadizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa);
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
    @OnClick(R.id.xifaadd)
    void btntijiao() {
        String name = xifaname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            xifaname.requestFocus();
            return;
        }
        String phone = xifaphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            xifaphone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            xifaphone.requestFocus();
            return;
        }
        String dizhi = xifadizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            xifadizhi.requestFocus();
            return;
        }

        String bz = xifabeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            xifabeizhu.requestFocus();
            return;
        }
    }
    /**
     * 取消
     */
    @OnClick(R.id.xifafinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}
