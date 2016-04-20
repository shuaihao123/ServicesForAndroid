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
 * 护理/皮肤护理
 */
public class Skin_Care_Activity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
   @Bind(R.id.pifuriqi)
   LinearLayout pifuriqi;
    @Bind(R.id.pifutime)
    SeekBar pifutime;
    @Bind(R.id.pifubeizhu)
    EditText pifubeizhu;
    @Bind(R.id.pifuname)
    EditText pifuname;
    @Bind(R.id.pifuphone)
    EditText pifuphone;
    @Bind(R.id.pifudizhi)
    EditText pifudizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin__care_);
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
    @OnClick(R.id.pifuadd)
    void btntijiao() {
        String name = pifuname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            pifuname.requestFocus();
            return;
        }
        String phone = pifuphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            pifuphone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            pifuphone.requestFocus();
            return;
        }
        String dizhi = pifudizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            pifudizhi.requestFocus();
            return;
        }
        String bz = pifubeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            pifubeizhu.requestFocus();
            return;
        }
    }
    /**
     * 取消
     */
    @OnClick(R.id.pifufinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

