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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;

import org.freecoding.servicesmanager.model.JiaZhengOrder;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.MultiLineEditText;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 护理/洗发
 */
public class SpaActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.xifariqi)
    LinearLayout xifariqi;
    @Bind(R.id.xifashijian)
    SeekBarPressure xifashijian;
    @Bind(R.id.xifashowshijian)
    TextView xifashowshijian;
    @Bind(R.id.xifabeizhu)
    MultiLineEditText xifabeizhu;
    @Bind(R.id.xifaname)
    EditText xifaname;
    @Bind(R.id.xifaphone)
    EditText xifaphone;
    @Bind(R.id.xifadizhi)
    EditText xifadizhi;
    @Bind(R.id.xifaxijianchui)
    CheckBox xifaxijianchui;
    @Bind(R.id.xifataishixitou)
    CheckBox xifataishixitou;
    @Bind(R.id.xifafazhibaohu)
    CheckBox xifafazhibaohu;
    ServicesItem info;
    JiaZhengOrder jiaZhengOrder;
    Handler hd;
    StringBuffer sb;
    String showshijian;
    String name;
    String phone;
    String dizhi;
    String bz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa);
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
        xifashijian.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                xifashowshijian.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow) / 2 + ":00"), String.valueOf((int) (12 + progressHigh) / 2 + ":00")));
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
            xifaxijianchui.setChecked(true);
        }
        if (serviceItem.contains("2")) {
            xifataishixitou.setChecked(true);
        }
        if (serviceItem.contains("3")) {
            xifafazhibaohu.setChecked(true);
        }

        String date = jiaZhengOrder.serviceTime;
        String[] dates = date.split("---");
        int kaishi = Integer.parseInt(dates[0].split(":")[0]);
        int end = Integer.parseInt(dates[1].split(":")[0]);
        xifashijian.setProgressLow(kaishi);
        xifashijian.setProgressHigh(end);
        xifashowshijian.setText(kaishi + ":00-" + end + ":00");
        xifaname.setText(jiaZhengOrder.customerName);
        xifaphone.setText(jiaZhengOrder.custmerPhone);
        xifadizhi.setText(jiaZhengOrder.address);
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

    //保存
    private void save() {
        int state = 1;
        showshijian = xifashowshijian.getText().toString().trim();
        sb = new StringBuffer();
        if (xifaxijianchui.isChecked()) {
            sb.append("1:" + xifaxijianchui.getText().toString().trim() + ";");
        }
        if (xifataishixitou.isChecked()) {
            sb.append("2:" + xifataishixitou.getText().toString().trim() + ";");
        }
        if (xifafazhibaohu.isChecked()) {
            sb.append("3:" + xifafazhibaohu.getText().toString().trim() + ";");
        }

        name = xifaname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            xifaname.requestFocus();
            return;
        }
        phone = xifaphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            xifaphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            xifaphone.requestFocus();
            return;
        }
        dizhi = xifadizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请输入地址");
            xifadizhi.requestFocus();
            return;
        }
        bz = xifabeizhu.getText().toString().trim();
        HttpUtils.saveServiceItemHuLi(info.id, "2016-5-5", showshijian, sb.toString(), bz, name, dizhi, phone, state, new StringCallback() {
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
    @OnClick(R.id.xifaadd)
    void btntijiao() {
        int state = 2;
        showshijian = xifashowshijian.getText().toString().trim();
        sb = new StringBuffer();
        if (xifaxijianchui.isChecked()) {
            sb.append("1:" + xifaxijianchui.getText().toString().trim() + ";");
        }
        if (xifataishixitou.isChecked()) {
            sb.append("2:" + xifataishixitou.getText().toString().trim() + ";");
        }
        if (xifafazhibaohu.isChecked()) {
            sb.append("3:" + xifafazhibaohu.getText().toString().trim() + ";");
        }
        name = xifaname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            xifaname.requestFocus();
            return;
        }
        phone = xifaphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            xifaphone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            xifaphone.requestFocus();
            return;
        }
        dizhi = xifadizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            xifadizhi.requestFocus();
            return;
        }
        bz = xifabeizhu.getText().toString().trim();
        HttpUtils.saveServiceItemHuLi(info.id, "2016-5-5", showshijian, sb.toString(), bz, name, dizhi, phone,state, new StringCallback() {
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
    @OnClick(R.id.xifafinsh)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}
