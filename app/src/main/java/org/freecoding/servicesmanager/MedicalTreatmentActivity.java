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
 * 医疗/上门诊疗
 */
public class MedicalTreatmentActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.shangmenriqi)
    LinearLayout shangmenriqi;
    @Bind(R.id.shangmentinme)
    SeekBar shangmentinme;
    @Bind(R.id.shangmenbeizhu)
    EditText shangmenbeizhu;
    @Bind(R.id.shangmenname)
    EditText shangmenname;
    @Bind(R.id.shangmenphone)
    EditText shangmenphone;
    @Bind(R.id.shangmendizhi)
    EditText shangmendizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_treatment);
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
    @OnClick(R.id.shangmenadd)
    void btntijiao() {
        String name = shangmenname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            shangmenname.requestFocus();
            return;
        }
        String phone = shangmenphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            shangmenphone.requestFocus();
            return;
    }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            shangmenphone.requestFocus();
            return;
        }
        String dizhi = shangmendizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            shangmendizhi.requestFocus();
            return;
        }
        String bz = shangmenbeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            shangmenbeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.shangmenfinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}



