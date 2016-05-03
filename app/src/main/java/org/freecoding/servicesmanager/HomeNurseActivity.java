package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 家政服务/保姆
 */
public class HomeNurseActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baomushijian)//保姆日期
            SeekBarPressure baomushijian;
    @Bind(R.id.baomucheckzf)//做饭
            CheckBox baomucheckzf;
    @Bind(R.id.baomucheckzgxh)//照顾小孩
            CheckBox baomucheckzgxh;
    @Bind(R.id.baomucheckzglr)//照顾老人
            CheckBox baomucheckzglr;
    @Bind(R.id.baomucheckzgbr)//照顾病人
            CheckBox baomucheckzgbr;
    @Bind(R.id.textviewshijian)
    TextView textviewshijian;
    @Bind(R.id.baomubeizhu)//备注
            EditText baomubeizhu;
    @Bind(R.id.baomuname)//姓名
            EditText baomuname;
    @Bind(R.id.baomuphone)//电话
            EditText baomuphone;
    @Bind(R.id.baomufuwudizhi)//地址
            EditText baomufuwudizhi;
    ServicesItem info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nurse);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        baomushijian.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                textviewshijian.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow)/2+":00"), String.valueOf((int) (12 + progressHigh)/2+":00")));
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
        HttpUtils.saveServiceItemJiaZheng(info.id, "", info.serviceItem, "", "", "", new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResult result = gson.fromJson(response, HttpResult.class);
                if (result.success) {
                    //成功
                } else {
                    //保存失败
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
    @OnClick(R.id.baomuadd)
    void btntijiao() {
        if (baomucheckzf.isChecked() == true) {
            String checkzf = baomucheckzf.getText().toString().trim();
        }
        if (baomucheckzgxh.isChecked() == true) {
            String checkzgxh = baomucheckzgxh.getText().toString().trim();
        }
        if (baomucheckzglr.isChecked() == true) {
            String checkzglr = baomucheckzglr.getText().toString().trim();
        }
        if (baomucheckzgbr.isChecked() == true) {
            String checkzgbr = baomucheckzgbr.getText().toString().trim();
        }
        String name = baomuname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            baomuname.requestFocus();
            return;
        }
        String phone = baomuphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            baomuphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            baomuphone.requestFocus();
            return;
        }
        String dizhi = baomufuwudizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            baomufuwudizhi.requestFocus();
            return;
        }
        String bz = baomubeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            baomubeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.baomufinsh)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}
