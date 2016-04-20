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
 * 家政服务/保洁
 */
public class HouseBaojActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baojieriqi)
    LinearLayout baojieriqi;
    @Bind(R.id.baojietime)
    SeekBar baojietime;
    @Bind(R.id.baojiebeizhu)
    EditText baojiebeizhu;
    @Bind(R.id.baojiename)
    EditText baojiename;
    @Bind(R.id.baojiephone)
    EditText baojiephone;
    @Bind(R.id.baojiedizhi)
    EditText baojiedizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_baoj);
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
    @OnClick(R.id.baojieadd)
    void btntijiao() {
        String name = baojiename.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            baojiename.requestFocus();
            return;
        }
        String phone = baojiephone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            baojiephone.requestFocus();
            return;
        }
        String dizhi = baojiedizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            baojiedizhi.requestFocus();
            return;
        }
        String bz = baojiebeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            baojiebeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.baojiefinsh)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

