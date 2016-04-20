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
 * 护理/洁牙
 */
public class ScalingYaActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.jieyariqi)
    LinearLayout jieyariqi;
    @Bind(R.id.jieyatime)
    SeekBar jieyatime;
    @Bind(R.id.jieyabeizhu)
    EditText jieyabeizhu;
    @Bind(R.id.jieyaname)
    EditText jieyaname;
    @Bind(R.id.jieyaphone)
    EditText jieyaphone;
    @Bind(R.id.jieyadizhi)
    EditText jieyadizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaling_ya);
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
    @OnClick(R.id.jieyaadd)
    void btntijiao() {
        String name = jieyaname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            jieyaname.requestFocus();
            return;
        }
        String phone = jieyaphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            jieyaphone.requestFocus();
            return;
        }
        String dizhi = jieyadizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            jieyadizhi.requestFocus();
            return;
        }
        String bz = jieyabeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            jieyabeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.jieyafinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

