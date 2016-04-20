package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import org.freecoding.servicesmanager.view.LinedEditText;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 家政服务/月嫂
 */
public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.age)
    SeekBar yuesaoage;
    @Bind(R.id.name)
    EditText yuesaoname;
    @Bind(R.id.phone)
    EditText yuesaophone;
    @Bind(R.id.dizhi)
    EditText yuesaodizhi;
    @Bind(R.id.beizhu)
    LinedEditText beizhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
    @OnClick(R.id.yuesaoadd)
    void btntijiao() {
        String name = yuesaoname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yuesaoname.requestFocus();
            return;
        }
        String phone = yuesaophone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yuesaophone.requestFocus();
            return;
        }
        String dizhi = yuesaodizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yuesaodizhi.requestFocus();
            return;
        }
        String bz = beizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            beizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.yuesaofinsh)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
}
