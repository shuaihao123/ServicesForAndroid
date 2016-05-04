package org.freecoding.servicesmanager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 护理/洁身沐浴
 */
public class ChastityActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.jieshen)
    TextView jieshen;
    @Bind(R.id.timerq)
    LinearLayout timerq;
    @Bind(R.id.muyujieshneshowshijian)
    TextView muyujieshneshowshijian;
    @Bind(R.id.muyujieshneshijian)
    SeekBarPressure muyujieshneshijian;
    @Bind(R.id.jieshenbeizhu)
    EditText jieshenbeizhu;
    @Bind(R.id.jieshnelianxiname)
    EditText jieshnelianxiname;
    @Bind(R.id.jieshnelianxiphone)
    EditText jieshnelianxiphone;
    @Bind(R.id.jieshnedizhi)
    EditText jieshnedizhi;
    @Bind(R.id.qxfinsh)
    TextView qxfinsh;
    @Bind(R.id.addtijiao)
    TextView addtijiao;
    Handler hd;
    ServicesItem info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chastity);
        ButterKnife.bind(this);
        init();
        hd = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    msg("登陆成功");
                } else if (msg.what == 1) {
                    msg("登陆失败");
                } else {
                    msg("请检查网络");
                }
            }
        };
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        muyujieshneshijian.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                muyujieshneshowshijian.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow) / 2 + ":00"), String.valueOf((int) (12 + progressHigh) / 2 + ":00")));
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
        HttpUtils.saveServiceItemHuLi(info.id, "", "", "", "", "", "", new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                msg("请检查网络");
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
    @OnClick(R.id.addtijiao)
    void btntijiao() {
        String remarks = jieshenbeizhu.getText().toString().trim();
        String name = jieshnelianxiname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            jieshnelianxiname.requestFocus();
            return;
        }
        String phone = jieshnelianxiphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            jieshnelianxiphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            jieshnelianxiphone.requestFocus();
            return;
        }
        String dizhi = jieshnedizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            jieshnedizhi.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.qxfinsh)
    void btnqxfinsh() {

        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);

        return true;
    }

}

