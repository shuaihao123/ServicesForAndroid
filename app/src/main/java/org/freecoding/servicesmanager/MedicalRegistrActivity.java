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
 * 医疗/挂号
 */
public class MedicalRegistrActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.guahaoriqi)
    LinearLayout guahaoriqi;
    @Bind(R.id.guahaotime)
    SeekBar guahaotime;
    @Bind(R.id.guahaobeizhu)
    EditText guahaobeizhu;
    @Bind(R.id.guahaoname)
    EditText guahaoname;
    @Bind(R.id.guahaophone)
    EditText guahaophone;
    @Bind(R.id.guahaodizhi)
    EditText guahaodizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_registr);
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
    @OnClick(R.id.guahaoadd)
    void btntijiao() {
        String name = guahaoname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            guahaoname.requestFocus();
            return;
        }
        String phone = guahaophone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            guahaophone.requestFocus();
            return;
        }
        String dizhi = guahaodizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            guahaodizhi.requestFocus();
            return;
        }
        String bz = guahaobeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            guahaobeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.guahaofinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}



