package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.RoundTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 医疗/预约打针
 */
public class MedicalInjectionActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yuyueriqi)
    LinearLayout yuyueriqi;
    @Bind(R.id.yuyuetime)
    SeekBar yuyuetime;
    @Bind(R.id.yuyuebeizhu)
    EditText yuyuebeizhu;
    @Bind(R.id.yuyuename)
    EditText yuyuename;
    @Bind(R.id.yuyuephone)
    EditText yuyuephone;
    @Bind(R.id.yuyuedizhi)
    EditText yuyuedizhi;
    @Bind(R.id.yuyueadd)
    TextView yuyueadd;
    @Bind(R.id.yuyuefinsh)
    TextView yuyuefinsh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_injection);
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
    @OnClick(R.id.yuyueadd)
    void btntijiao() {
        String name = yuyuename.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yuyuename.requestFocus();
            return;
        }
        String phone = yuyuephone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yuyuephone.requestFocus();
            return;
        }
        String dizhi = yuyuedizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yuyuedizhi.requestFocus();
            return;
        }
        String bz = yuyuebeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            yuyuebeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.yuyuefinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}


