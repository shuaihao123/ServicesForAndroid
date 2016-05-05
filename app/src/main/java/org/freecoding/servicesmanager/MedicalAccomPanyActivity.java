package org.freecoding.servicesmanager;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.MultiLineEditText;
import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 医疗/陪诊
 */
public class MedicalAccomPanyActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.peizhenriqi)
    LinearLayout peizhenriqi;
    @Bind(R.id.peizhenshijian)
    SeekBarPressure peizhenshijian;
    @Bind(R.id.peizhenshowshijian)
    TextView peizhenshowshijian;
    @Bind(R.id.peizhenbeizhu)
    MultiLineEditText peizhenbeizhu;
    @Bind(R.id.peizhenname)
    EditText peizhenname;
    @Bind(R.id.peizhenphone)
    EditText peizhenphone;
    @Bind(R.id.peizhendizhi)
    EditText peizhendizhi;
    @Bind(R.id.peitongzhiliao)
    CheckBox peitongzhiliao;
    Handler hd;
    ServicesItem info;
    StringBuffer sb;
    String shijian;
    String name;
    String phone;
    String dizhi;
    String peizhenbz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_accom_pany);
        ButterKnife.bind(this);
        init();
        hd = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    msg("保存成功");
                } else if (msg.what == 1) {
                    msg("保存失败");
                } else {
                    msg("请检查网络");
                }
            }
        };
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        peizhenshijian.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                peizhenshowshijian.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow) / 2 + ":00"), String.valueOf((int) (12 + progressHigh) / 2 + ":00")));
            }

            @Override
            public void onProgressAfter() {

            }
        });
        info = (ServicesItem) getIntent().getSerializableExtra("info");
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
            case R.id.saveButton:
                save();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void save() {
         shijian = peizhenshowshijian.getText().toString().trim();
         name = peizhenname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            peizhenname.requestFocus();
            return;
        }
         phone = peizhenphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            peizhenphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            peizhenphone.requestFocus();
            return;
        }
         dizhi = peizhendizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            peizhendizhi.requestFocus();
            return;
        }
         peizhenbz = peizhenbeizhu.getText().toString().trim();
        sb = new StringBuffer();
        if (peitongzhiliao.isChecked()) {
            sb.append("1:" + peitongzhiliao.getText().toString().trim() + ";");
        }
        HttpUtils.saveServiceItemYiLiao(info.id, "2016-5-5", shijian, sb.toString(), peizhenbz, name, dizhi, phone , new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                hd.sendEmptyMessage(2);
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResult result = gson.fromJson(response, HttpResult.class);
                if (result.success) {
                    hd.sendEmptyMessage(0);
                    finish();
                } else {
                    hd.sendEmptyMessage(1);
                }
            }
        });
    }

    void msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 提交
     */
    @OnClick(R.id.peizhenadd)
    void btntijiao() {
         name = peizhenname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            peizhenname.requestFocus();
            return;
        }
         phone = peizhenphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            peizhenphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            peizhenphone.requestFocus();
            return;
        }
         dizhi = peizhendizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            peizhendizhi.requestFocus();
            return;
        }
         peizhenbz = peizhenbeizhu.getText().toString().trim();
    }

    /**
     * 取消
     */
    @OnClick(R.id.peizhenfish)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
}