package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.RoundTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 医疗/医疗咨询
 */
public class MedicaladviceActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yiliaoriqi)
    LinearLayout yiliaoriqi;
    @Bind(R.id.yiliaobeizhu)
    EditText yiliaobeizhu;
    @Bind(R.id.yiliaoname)
    EditText yiliaoname;
    @Bind(R.id.yiliaophone)
    EditText yiliaophone;
    @Bind(R.id.yiliaodizhi)
    EditText yiliaodizhi;
    @Bind(R.id.yiliaoadd)
    TextView yiliaoadd;
    @Bind(R.id.yiliaofinsh)
    TextView yiliaofinsh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicaladvice);
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
    @OnClick(R.id.yiliaoadd)
    void btntijiao() {
        String name = yiliaoname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yiliaoname.requestFocus();
            return;
        }
        String phone = yiliaophone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yiliaophone.requestFocus();
            return;
        }
        String dizhi = yiliaodizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yiliaodizhi.requestFocus();
            return;
        }
        String bz = yiliaobeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            yiliaobeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.yiliaofinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

