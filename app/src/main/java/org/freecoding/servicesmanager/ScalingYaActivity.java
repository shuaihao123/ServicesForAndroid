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
import org.freecoding.servicesmanager.model.JiaZhengOrder;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 护理/洁牙
 */
public class ScalingYaActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.jieyariqi)
    LinearLayout jieyariqi;
    @Bind(R.id.jieyatime)
    SeekBarPressure jieyatime;
    @Bind(R.id.jieyashowtime)
    TextView jieyashowtime;
    @Bind(R.id.jieyabeizhu)
    EditText jieyabeizhu;
    @Bind(R.id.jieyaname)
    EditText jieyaname;
    @Bind(R.id.jieyaphone)
    EditText jieyaphone;
    @Bind(R.id.jieyadizhi)
    EditText jieyadizhi;
    @Bind(R.id.jieyabaya)
    CheckBox jieyabaya;
    @Bind(R.id.jieyabuya)
    CheckBox jieyabuya;
    @Bind(R.id.jieyazhengxing)
    CheckBox jieyazhengxing;
    Handler hd;
    ServicesItem info;
    JiaZhengOrder jiaZhengOrder;
    StringBuffer sb;
    String shijian;
    String name;
    String phone;
    String dizhi;
    String bz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaling_ya);
        ButterKnife.bind(this);
        init();
        hd = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    msg("操作成功");
                } else if (msg.what == 1) {
                    msg("操作失败");
                } else {
                    msg("请检查网络");
                }
            }
        };
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        jieyatime.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                jieyashowtime.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow) / 2 + ":00"), String.valueOf((int) (12 + progressHigh) / 2 + ":00")));
            }

            @Override
            public void onProgressAfter() {

            }
        });
        if (getIntent() != null && getIntent().getSerializableExtra("info") != null) {
            info = (ServicesItem) getIntent().getSerializableExtra("info");
        } else if (getIntent() != null && getIntent().getSerializableExtra("order") != null) {
            jiaZhengOrder = (JiaZhengOrder) getIntent().getSerializableExtra("order");
            loadOrder();
        }
    }

    private void loadOrder() {
        String serviceItem = jiaZhengOrder.serviceItem;
        if (serviceItem.contains("1")) {
            jieyabaya.setChecked(true);
        }
        if (serviceItem.contains("2")) {
            jieyabuya.setChecked(true);
        }
        if (serviceItem.contains("3")) {
            jieyazhengxing.setChecked(true);
        }

        String date = jiaZhengOrder.serviceTime;
        String[] dates = date.split("---");
        int kaishi = Integer.parseInt(dates[0].split(":")[0]);
        int end = Integer.parseInt(dates[1].split(":")[0]);
        jieyatime.setProgressLow(kaishi);
        jieyatime.setProgressHigh(end);
        jieyashowtime.setText(kaishi + ":00-" + end + ":00");
        jieyaname.setText(jiaZhengOrder.customerName);
        jieyaphone.setText(jiaZhengOrder.custmerPhone);
        jieyadizhi.setText(jiaZhengOrder.address);
        jieyabeizhu.setText(jiaZhengOrder.remark);
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
        int state=1;
         shijian=jieyashowtime.getText().toString().trim();
        sb = new StringBuffer();
        if (jieyabaya.isChecked()) {
            sb.append("1:" + jieyabaya.getText().toString().trim() + ";");
        }
        if (jieyabuya.isChecked()) {
            sb.append("2:" + jieyabuya.getText().toString().trim() + ";");
        }
        if (jieyazhengxing.isChecked()) {
            sb.append("3:" + jieyazhengxing.getText().toString().trim() + ";");
        }
         name = jieyaname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            jieyaname.requestFocus();
            return;
        }
         phone = jieyaphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            jieyaphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            jieyaphone.requestFocus();
            return;
        }
         dizhi = jieyadizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            jieyadizhi.requestFocus();
            return;
        }
         bz = jieyabeizhu.getText().toString().trim();
        HttpUtils.saveServiceItemHuLi(info.id,"2016-5-5",shijian, sb.toString(),bz, name, dizhi, phone, state,new StringCallback() {
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
    @OnClick(R.id.jieyaadd)
    void btntijiao() {
        int state=2;
        shijian=jieyashowtime.getText().toString().trim();
        sb = new StringBuffer();
        if (jieyabaya.isChecked()) {
            sb.append("1:" + jieyabaya.getText().toString().trim() + ";");
        }
        if (jieyabuya.isChecked()) {
            sb.append("2:" + jieyabuya.getText().toString().trim() + ";");
        }
        if (jieyazhengxing.isChecked()) {
            sb.append("3:" + jieyazhengxing.getText().toString().trim() + ";");
        }
         name = jieyaname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            jieyaname.requestFocus();
            return;
        }
         phone = jieyaphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            jieyaphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            jieyaphone.requestFocus();
            return;
        }
         dizhi = jieyadizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            jieyadizhi.requestFocus();
            return;
        }
        bz = jieyabeizhu.getText().toString().trim();
        HttpUtils.saveServiceItemHuLi(info.id,"2016-5-5",shijian, sb.toString(),bz, name, dizhi, phone,state, new StringCallback() {
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

    /**
     * 取消
     */
    @OnClick(R.id.jieyafinsh)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

